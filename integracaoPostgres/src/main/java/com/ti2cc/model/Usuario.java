package com.ti2cc.model;

public class Usuario {
    //data --> same data from database table 'usuario'
    private int codigo;
    private String login;
    private String senha;
    private char sexo;

    //empty constructor usuario
    public Usuario() {
        this.codigo = -1;
        this.login = "";
        this.senha = "";
        this.sexo = '*';
    }

    //fill constructor usuario
    public Usuario(int codigo, String login, String senha, char sexo) {
        this.codigo = codigo;
        this.login = login;
        this.senha = senha;
        this.sexo = sexo;
    }
    
    //getters && setters
    //codigo
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    //login
    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin(){
        return login;
    }

    //senha
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    //sexo
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public char getSexo() {
        return sexo;
    }

    @Override
    public String toString() {
        return "Usuario [codigo=" + codigo + ", login=" + login + ", senha=" + senha + ", sexo=" + sexo + "]";
    }
}
