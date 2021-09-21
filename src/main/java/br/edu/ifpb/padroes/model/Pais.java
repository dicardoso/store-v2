package br.edu.ifpb.padroes.model;

public class Pais {

    private String nome;
    private String sigla;

    public Pais(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
