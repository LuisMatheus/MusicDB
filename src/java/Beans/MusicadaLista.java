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
public class MusicadaLista {
    private int listaid;
    private int musicaid;
    private int qtdeDeVezesTocada;

    public MusicadaLista() {
    }

    public MusicadaLista(int listaid, int musicaid, int qtdeDeVezesTocada) {
        this.listaid = listaid;
        this.musicaid = musicaid;
        this.qtdeDeVezesTocada = qtdeDeVezesTocada;
    }

    public int getQtdeDeVezesTocada() {
        return qtdeDeVezesTocada;
    }

    public void setQtdeDeVezesTocada(int qtdeDeVezesTocada) {
        this.qtdeDeVezesTocada = qtdeDeVezesTocada;
    }

    public int getListaid() {
        return listaid;
    }

    public void setListaid(int listaid) {
        this.listaid = listaid;
    }

    public int getMusicaid() {
        return musicaid;
    }

    public void setMusicaid(int musicaid) {
        this.musicaid = musicaid;
    }
    
    
    
}
