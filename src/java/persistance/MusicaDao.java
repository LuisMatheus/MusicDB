package persistance;

import Beans.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MusicaDao {

    private Connection con = null;
    private PreparedStatement st = null;

    public ArrayList<Musica> buscar(String nome) {
        try {
            con = Conexao.getConexao();
            st = con.prepareStatement("SELECT * FROM musica WHERE nome LIKE ? ");
            st.setString(1, "%" + nome + "%");
            ArrayList<Musica> som = new ArrayList<>();
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nome");
                String cantor = rs.getString("cantor");
                String arquivo = rs.getString("nome_arquivo");
                som.add(new Musica(id, nom, cantor, arquivo));
            }

            return som;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MusicaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }

    public List<Musica> buscar(int idLista) {
        try {
            con = Conexao.getConexao();
            st = con.prepareStatement("SELECT m.id , m.nome , m.cantor , m.nome_arquivo , m.album_id , a.nome as 'nome album' FROM musica_da_lista ml INNER JOIN musica m on ml.musica_id = m.id  INNER JOIN album a on a.id = m.album_id WHERE lista_id = ?");
            st.setInt(1, idLista);
            ArrayList<Musica> som = new ArrayList<>();
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("id"));
                String cantor = rs.getString("cantor");
                String nome = rs.getString("nome");
                String arquivo = rs.getString("nome_arquivo");
                String albumnome = rs.getString("nome album");

                som.add(new Musica(id, nome, cantor, arquivo, albumnome));
            }
            return som;

        } catch (SQLException ex) {
            Logger.getLogger(usuarioDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MusicaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public void incremetar(int idMusica, int idLista) {
        try {
            con = Conexao.getConexao();
            st = con.prepareStatement("UPDATE musica_da_lista \n"
                    + "    SET qtde_vezes_tocada = qtde_vezes_tocada + 1\n"
                    + "        WHERE lista_id = ? and musica_id = ?;");
            st.setInt(1, idLista);
            st.setInt(2, idMusica);

            st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(usuarioDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MusicaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
