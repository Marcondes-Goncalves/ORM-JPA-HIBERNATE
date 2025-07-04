package com.marcondes.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({

    @NamedQuery(name = "UsuarioPessoa.todos", query = "SELECT u FROM UsuarioPessoa u")

})
public class UsuarioPessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String sobrenome;
    private String email;
    private String login;
    private String senha;
    private int idade;

    @OneToMany(mappedBy = "usuarioPessoa")
    private List<TelefoneUser> TelefoneUser;


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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    

    @Override
    public String toString() {
        return "UsuarioPessoa [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email
                + ", login=" + login + ", senha=" + senha + ", idade=" + idade + "]";
    }

    public List<TelefoneUser> getTelefoneUser() {
        return TelefoneUser;
    }

    public void setTelefoneUser(List<TelefoneUser> telefoneUser) {
        TelefoneUser = telefoneUser;
    }

    

}
