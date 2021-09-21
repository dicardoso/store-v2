package br.edu.ifpb.padroes.model;

import java.util.List;

public class Usuario implements Cloneable {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private List<Endereco> enderecos;

    public Usuario () {}

    public Usuario (Usuario user) {
        this.id = user.getId();
        this.nome = user.getNome();
        this.email = user.getEmail();
        this.senha = user.getSenha();
        this.enderecos = user.getEnderecos();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public void addEndereco(Endereco endereco) {
        this.enderecos.add(endereco);
    }

    public void removeEndereco(Endereco endereco) {
        this.enderecos.remove(endereco);
    }

    @Override
    protected Object clone() {
        return new Usuario(this);
    }


}
