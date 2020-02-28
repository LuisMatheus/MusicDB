package Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Usuario {

    private String login;
    private String senha;
    private String nome;
    private String cartao;
    private String validade;
    private int codigodeseguranca;

    public Usuario(String login, String senha, String nome, String cartao, String validade, int codigodeseguranca) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.cartao = cartao;
        this.validade = validade;
        this.codigodeseguranca = codigodeseguranca;
    }

    public Usuario() {
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public int getCodigodeseguranca() {
        return codigodeseguranca;
    }

    public void setCodigodeseguranca(int codigodeseguranca) {
        this.codigodeseguranca = codigodeseguranca;
    }

    

}
