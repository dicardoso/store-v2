package br.edu.ifpb.padroes.model;

public class EnderecoCreator {

    private String rua;
    private Pais pais;
    private Estado estado;
    private Cidade cidade;
    private String complemento;

    public EnderecoCreator() {
    }

    public EnderecoCreator(String rua, Pais pais, Estado estado, Cidade cidade, String complemento) {
        this.rua = rua;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.complemento = complemento;
    }

    public EnderecoCreator setRua(String rua) {
        this.rua = rua;
        return this;
    }

    public EnderecoCreator setPais(String nome, String sigla) {
        this.pais = new Pais(nome, sigla);
        return this;
    }

    public EnderecoCreator setEstado(String estado, String sigla) {
        this.estado = new Estado(estado, sigla);
        return this;
    }

    public EnderecoCreator setCidade(String cidade) {
        this.cidade = new Cidade(cidade);
        return this;
    }

    public EnderecoCreator setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public Endereco getResult() {
        return new Endereco(rua, cidade, estado, pais, complemento);
    }

}
