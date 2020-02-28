/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author luis
 */
public class Lista {
    private int id;
    private String nome;
    private String UsuarioLogin;

    public Lista(int id, String nome, String UsuarioLogin) {
        this.id = id;
        this.nome = nome;
        this.UsuarioLogin = UsuarioLogin;
    }

    public Lista() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUsuarioLogin(String UsuarioLogin) {
        this.UsuarioLogin = UsuarioLogin;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getUsuarioLogin() {
        return UsuarioLogin;
    }
    
}
