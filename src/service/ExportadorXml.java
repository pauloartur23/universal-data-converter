package service;

import model.ExportadorDados;
import java.util.Map;

public class ExportadorXml implements ExportadorDados {
    @Override
    public String exportar(Map<String, Object> dados) {
        StringBuilder sb = new StringBuilder("<dados>\n");
        
        dados.forEach((chave, valor) -> {
            sb.append("  <").append(chave).append(">");
            sb.append(valor);
            sb.append("</").append(chave).append(">\n");
        });

        sb.append("</dados>");
        return sb.toString();
    }
}
