package Form;

import Beans.Album;
import Beans.Lista;
import Beans.Musica;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import persistance.AlbumDao;
import persistance.ListaDao;
import persistance.MusicaDao;

@ManagedBean
@RequestScoped
public class ListaForm {

    private final AlbumDao aldao = new AlbumDao();
    private final ListaDao l = new ListaDao();
    private Lista lista = new Lista();
    private List<Lista> listas;
    private List<Musica> playlist;
    private final MusicaDao mdao = new MusicaDao();
    private List<Musica> busca = new ArrayList<>();
    private List<Album> buscaAlbum = new ArrayList<>();
    private Musica musica = new Musica();
    private Map<Long, Boolean> musicamap = new HashMap<Long, Boolean>();
    private List<String> musicasSelecionadas = new ArrayList<>();

    public String inserir(String login) {
        this.lista.setUsuarioLogin(login);
        l.inserir(this.lista);
        return "saudacao";
    }

    public String excluir(int id) {
        l.excluir(id);
        return "saudacao";
    }

    public List<Lista> Listar(String login) {
        if (listas == null) {
            listas = new ArrayList<>();
            listas = l.listar(login);
        }
        return listas;
    }

    public String buscarMusica() {
        this.busca = mdao.buscar(musica.getNome());
        this.buscaAlbum = aldao.buscar(musica.getNome());
        return "pesquisarMusicas";
    }

    public String inserirNaLista() {

        for (Map.Entry<Long, Boolean> m : musicamap.entrySet()) {
            musicasSelecionadas.add(m.getKey() + "");
        }

        //mldao.inserir(musicasSelecionadas);
        return "pesquisarMusicas";

    }

    public List<Lista> getListas() {
        return this.listas;
    }

    public void setListas(List<Lista> listas) {
        this.listas = listas;
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

    public List<String> getMusicasSelecionadas() {
        return musicasSelecionadas;
    }

    public void setMusicasSelecionadas(List<String> musicasSelecionadas) {
        this.musicasSelecionadas = musicasSelecionadas;
    }

    public Map<Long, Boolean> getMusicamap() {
        return musicamap;
    }

    public void setMusicamap(Map<Long, Boolean> musicamap) {
        this.musicamap = musicamap;
    }
}
