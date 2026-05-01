package model;

public class Campo {
    private String nome;
    private Object valor;
    private String tipo;

    public Campo(String nome, Object valor, String tipo) {
        this.nome = nome;
        this.valor = valor;
        this.tipo = tipo;
    }

    public String getNome() { return nome; }
    public Object getValor() { return valor; }
}