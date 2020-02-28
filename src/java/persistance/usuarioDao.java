package persistance;

import Beans.Usuario;
import com.mysql.jdbc.SQLError;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class usuarioDao {

    private Connection con = null;
    private PreparedStatement st = null;

    public Usuario buscar(String login) {
        try {
            con = Conexao.getConexao();
            st = con.prepareStatement("SELECT * FROM usuario WHERE login=? ");
            st.setString(1, login);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                String logi = rs.getString("login");
                String senha = rs.getString("senha");
                String nome = rs.getString("nome");
                String cartao = rs.getString("cartao");
                String validade = rs.getDate("validate").toString();
                int cvv = rs.getInt("cvv");

                return new Usuario(logi, senha, nome, cartao, validade, cvv);
            }

        } catch (SQLException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }

    public void inserir(Usuario usuario) {
        try {
            con = Conexao.getConexao();

            st = con.prepareStatement("INSERT INTO usuario VALUES (?,?,?,?,?,?)");

            st.setString(1, usuario.getLogin());
            st.setString(2, usuario.getSenha());
            st.setString(3, usuario.getNome());
            st.setString(4, usuario.getCartao());
            st.setDate(5, java.sql.Date.valueOf(usuario.getValidade()));
            st.setInt(6, usuario.getCodigodeseguranca());

            st.executeUpdate();

        } catch (SQLException e) {

        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void alterar(Usuario usuario) {
        try {
            con = Conexao.getConexao();

            st = con.prepareStatement("UPDATE usuario SET senha = ? , nome = ? , cartao = ? , validate = ? , cvv = ? WHERE login LIKE ?");

            st.setString(1, usuario.getSenha());
            st.setString(2, usuario.getNome());
            st.setString(3, usuario.getCartao());
            st.setDate(4, java.sql.Date.valueOf(usuario.getValidade()));
            st.setInt(5, usuario.getCodigodeseguranca());
            st.setString(6, usuario.getLogin());

            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
