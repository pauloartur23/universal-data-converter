package service;

import model.ExportadorDados;
import java.util.Map;

public class ExportadorJson implements ExportadorDados {
    @Override
    public String exportar(Map<String, Object> dados) {
        StringBuilder sb = new StringBuilder("{\n");
        
        dados.forEach((chave, valor) -> {
            sb.append("  \"").append(chave).append("\": ");
            
            // Lógica simples para diferenciar Strings de números/booleanos no JSON
            if (valor instanceof Number || valor instanceof Boolean) {
                sb.append(valor);
            } else {
                sb.append("\"").append(valor).append("\"");
            }
            sb.append(",\n");
        });

        sb.append("}");
        return sb.toString().replace(",\n}", "\n}"); // Limpa a última vírgula
    }
}