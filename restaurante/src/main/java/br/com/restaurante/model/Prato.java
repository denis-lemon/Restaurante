package br.com.restaurante.model;

public class Prato {

    private String nome;
    private String tipo;
    private String Descricao;

    public Prato(String nome, String tipo, String descricao) {
        this.nome = nome;
        this.tipo = tipo;
        Descricao = descricao;
    }

    public Prato() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }
}