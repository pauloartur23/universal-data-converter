package main;

import model.ExportadorDados;
import service.ExportadorJson;
import service.ExportadorXml;

import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // LinkedHashMap mantém a ordem em que o usuário digitou os campos
        Map<String, Object> dadosColetados = new LinkedHashMap<>();

        System.out.println("=== SISTEMA DE CONVERSÃO UNIVERSAL ===");
        System.out.println("Formato de entrada: NOME;VALOR;TIPO");
        System.out.println("Tipos aceitos: texto, inteiro, decimal, boleano, data, data_hora");
        System.out.println("Digite 'sair' para processar os dados.\n");

        // 1. Loop de Captura de Dados
        while (true) {
            System.out.print("Entrada > ");
            String linha = sc.nextLine();

            if (linha.equalsIgnoreCase("sair")) {
                break;
            }

            String[] partes = linha.split(";");
            if (partes.length < 3) {
                System.out.println("[Erro] Use o padrão: NOME;VALOR;TIPO");
                continue;
            }

            String nome = partes[0].trim();
            String valorBruto = partes[1].trim();
            String tipo = partes[2].trim();

            Object valorConvertido = converterTipo(valorBruto, tipo);
            dadosColetados.put(nome, valorConvertido);
        }

        if (dadosColetados.isEmpty()) {
            System.out.println("Nenhum dado informado. Encerrando.");
            sc.close();
            return;
        }

        // 2. Escolha do Formato (Demonstração de Polimorfismo)
        System.out.println("\nEscolha o formato de saída:");
        System.out.println("(1) JSON");
        System.out.println("(2) XML");
        System.out.print("Opção > ");
        
        int opcao = 1;
        try {
            opcao = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida, gerando JSON por padrão.");
        }

        // Referência para a Interface (Programação por Contratos)
        ExportadorDados exportador;

        if (opcao == 2) {
            exportador = new ExportadorXml(); // Injeção da implementação XML
        } else {
            exportador = new ExportadorJson(); // Injeção da implementação JSON
        }

        // 3. Resultado Final
        System.out.println("\n--- RESULTADO DA EXPORTAÇÃO ---");
        System.out.println(exportador.exportar(dadosColetados));

        sc.close();
    }

    /**
     * Método para converter tipos de forma dinâmica e segura.
     * Java Time API e Switch Expressions.
     */
    private static Object converterTipo(String valor, String tipo) {
        try {
            return switch (tipo.toLowerCase()) {
                case "inteiro" -> Integer.parseInt(valor);
                case "decimal" -> Double.parseDouble(valor);
                case "boleano" -> Boolean.parseBoolean(valor);
                case "data"    -> LocalDate.parse(valor); // Padrão: yyyy-MM-dd
                case "data_hora" -> LocalDateTime.parse(valor); // Padrão: yyyy-MM-ddTHH:mm
                case "texto"   -> valor;
                default -> {
                    System.out.println("[Aviso] Tipo '" + tipo + "' desconhecido. Tratando como texto.");
                    yield valor;
                }
            };
        } catch (Exception e) {
            System.out.println("[Erro] Falha ao converter '" + valor + "' para " + tipo + ". Salvo como texto.");
            return valor;
        }
    }
}