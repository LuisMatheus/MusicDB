package Form;

import Beans.Lista;
import Beans.Musica;
import Beans.MusicadaLista;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import persistance.ListaDao;
import persistance.MusicaDao;

/**
 *
 * @author luis
 */
@ManagedBean
@RequestScoped
public class MusicaForm {

    private final MusicaDao mdao = new MusicaDao();
    private final ListaDao ldao = new ListaDao();
    private Lista lista = new Lista();
    private Musica musica = new Musica();
    private List<Musica> playlist = new ArrayList<>();
    

    public String abrirLista(int idLista) {
        this.playlist = mdao.buscar(idLista);
        this.lista = ldao.buscar(idLista);
        return "repMusica";
    }

    public void addMusica(int idMusica, int idLista) {
        mdao.incremetar(idMusica, idLista);
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

    public Musica getMusica() {
        return musica;
    }

    public void setMusica(Musica musica) {
        this.musica = musica;
    }

    public List<Musica> getPlaylist() {
        return playlist;
    }

    public MusicaForm() {
    }

    public void setPlaylist(List<Musica> playlist) {
        this.playlist = playlist;
    }

    

}
