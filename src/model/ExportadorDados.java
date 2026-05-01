package model;

import java.util.Map;

public interface ExportadorDados {
    // Toda classe que exportar dados deve seguir este contrato
    String exportar(Map<String, Object> dados);
}