package br.edu.ifpb.padroes.model;

public class Endereco implements Cloneable {

    private String rua;
    private Cidade cidade;
    private Estado estado;
    private Pais pais;
    private String complemento;

    public Endereco() {
    }

    public Endereco(String rua, Cidade cidade, Estado estado, Pais pais, String complemento) {
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.complemento = complemento;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
           throw new RuntimeException(e);
        }
    }

}
