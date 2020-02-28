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
public class Musica {

    private int id;
    private String nome;
    private String cantor;
    private String arquivo;
    private int albumid;
    private String albumnome;

    public Musica(int id, String nome, String cantor, String arquivo, int albumid, String albumnome) {
        this.id = id;
        this.nome = nome;
        this.cantor = cantor;
        this.arquivo = arquivo;
        this.albumid = albumid;
        this.albumnome = albumnome;
    }

    public Musica(String nome, String cantor, String arquivo, int albumid, String albumnome) {
        this.nome = nome;
        this.cantor = cantor;
        this.arquivo = arquivo;
        this.albumid = albumid;
        this.albumnome = albumnome;
    }

    public Musica(int id, String nome, String cantor, String arquivo) {
        this.id = id;
        this.nome = nome;
        this.cantor = cantor;
        this.arquivo = arquivo;
    }

    public Musica(int id, int albumid, String albumnome) {
        this.id = id;
        this.albumid = albumid;
        this.albumnome = albumnome;
    }

    public Musica(int id, String nome, String cantor, String arquivo, String albumnome) {
        this.id = id;
        this.nome = nome;
        this.cantor = cantor;
        this.arquivo = arquivo;
        this.albumnome = albumnome;
    }

    public Musica() {
    }

    

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCantor() {
        return cantor;
    }

    public void setCantor(String cantor) {
        this.cantor = cantor;
    }

    public int getAlbumid() {
        return albumid;
    }

    public void setAlbumid(int albumid) {
        this.albumid = albumid;
    }

    public String getAlbumnome() {
        return albumnome;
    }

    public void setAlbumnome(String albumnome) {
        this.albumnome = albumnome;
    }

}
