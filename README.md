# Universal Data Converter 🚀

O **Universal Data Converter** é um motor de processamento e exportação de dados desenvolvido em **Java**. O projeto foi construído para demonstrar a aplicação prática de conceitos avançados de **Programação Orientada a Objetos (POO)** e padrões de arquitetura de software, transformando entradas dinâmicas em formatos estruturados como **JSON** e **XML**.

## 🛠️ Tecnologias e Arquitetura

Este projeto utiliza recursos modernos do ecossistema Java para garantir um código limpo, extensível e de fácil manutenção:

*   **Java 17+**: Utilização de *Switch Expressions* e estruturas de dados otimizadas como `LinkedHashMap` para preservação da ordem de inserção.
*   **Java Time API**: Uso das classes `LocalDate` e `LocalDateTime` para manipulação de datas de forma imutável e segura.
*   **Padrão de Projeto Strategy**: Implementação de uma interface comum para algoritmos de exportação, permitindo alternar entre formatos sem alterar a lógica de captura.
*   **Polimorfismo de Inclusão**: O sistema interage com interfaces em vez de implementações concretas, facilitando a expansibilidade.
*   **Tratamento de Exceções**: Lógica robusta de conversão de tipos para evitar falhas durante a execução (Runtime).

## 📂 Estrutura do Projeto

O projeto segue uma organização de pastas profissional (Separation of Concerns):
```text
src/
├── main/       # Classe Principal e execução do programa
├── model/      # Contratos (Interfaces) e Modelos de dados
└── service/    # Implementações dos algoritmos de exportação (JSON/XML)


📌 Funcionalidades
O conversor processa entradas baseadas no padrão NOME;VALOR;TIPO e suporta:

Tipos Dinâmicos: Texto, Inteiro, Decimal, Boleano e Datas.

Múltiplos Formatos: Escolha em tempo de execução entre exportação para JSON ou XML.

Extensibilidade: Facilidade para adicionar novos formatos (como YAML ou CSV) apenas implementando a interface ExportadorDados.

🚀 Como Executar

Clone o repositório:
git clone [https://github.com/seu-usuario/universal-data-converter.git](https://github.com/seu-usuario/universal-data-converter.git)

Compile os arquivos:
javac -d bin src/main/*.java src/model/*.java src/service/*.java

Execute a aplicação:
java -cp bin main.Principal

📝 Exemplo de Uso
Entrada no Terminal:

Plaintext
nome;Paulo Artur;texto
saldo;1500.50;decimal
nascimento;2000-05-20;data
ativo;true;boleano
sair

Saída Gerada (JSON):
JSON
{
  "nome": "Paulo Artur",
  "saldo": 1500.50,
  "nascimento": "2000-05-20",
  "ativo": true
}


## 🎓 Certificação

Este projeto foi desenvolvido para aplicar os conhecimentos adquiridos na certificação:

*   **Curso**: Imersão Prática com Collections e Outras Classes Úteis do Java.
*   **Instituição**: DIO[cite: 1].
*   **Carga Horária**: 11 horas[cite: 1].
*   **Data de Conclusão**: 01/05/2026[cite: 1].

📄 [**Clique aqui para visualizar o certificado em PDF**](./docs/Certificado-Java-Collections-Paulo-Artur.pdf)
Desenvolvido como projeto prático para consolidar conhecimentos em Engenharia de Software e POO.