package Form;

import Beans.Lista;
import persistance.usuarioDao;
import Beans.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import persistance.ListaDao;

@ManagedBean
@RequestScoped
public class UsuarioForm {

    private Usuario usuario = new Usuario();
    private final usuarioDao u = new usuarioDao();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String FazerLogin() {
        Usuario w = u.buscar(usuario.getLogin());
        if (w != null) {
            if (w.getSenha().equals(usuario.getSenha())) {
                this.usuario = w;
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogado", w);
                return "saudacao";
            }
        }
        return null;
    }

    public String cadastrar() {

        String data = usuario.getValidade();
        String mes = data.substring(0, 2);
        String ano = data.substring(3, 5);
        data = "20" + ano + "-" + mes + "-" + "31";
        usuario.setValidade(data);

        u.inserir(new Usuario(usuario.getLogin(), usuario.getSenha(), usuario.getNome(), usuario.getCartao().replace(" ", ""), usuario.getValidade(), usuario.getCodigodeseguranca()));
        return "saudacao";
    }

    public String alterar(String login) {

        this.usuario.setLogin(login);
        String data = usuario.getValidade();
        String mes = data.substring(0, 2);
        String ano = data.substring(3, 5);
        data = "20" + ano + "-" + mes + "-" + "31";
        usuario.setValidade(data);
        Usuario w = new Usuario(usuario.getLogin(), usuario.getSenha(), usuario.getNome(), usuario.getCartao().replace(" ", ""), usuario.getValidade(), usuario.getCodigodeseguranca());
        
        u.alterar(w);

        return "login";
    }
}
