/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance;

import Beans.Album;
import Beans.Lista;
import Beans.Musica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis
 */
public class AlbumDao {

    private Connection con = null;
    private PreparedStatement stmt = null;

    public List<Album> buscar(List<Musica> playlist) {
        try {
            con = Conexao.getConexao();
            List<Album> temp = new ArrayList<>();
            for (Musica m : playlist) {
                stmt = con.prepareStatement("SELECT * FROM album WHERE id = ?");
                stmt.setInt(1, m.getAlbumid());

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    for (Album al : temp) {
                        if (al.getId() == id) {
                            continue;
                        } else {
                            String nome = rs.getString("nome");
                            temp.add(new Album(id, nome));

                        }
                    }
                }
            }
            return temp;

        } catch (SQLException e) {

        } finally {
            try {
                con.close();
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ListaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public List<Album> buscar(Musica musica) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Album> buscar(String nome) {
        try {
            con = Conexao.getConexao();
            List<Album> temp = new ArrayList<>();

            stmt = con.prepareStatement("SELECT DISTINCT a.id , a.nome FROM musica m INNER JOIN album a on m.album_id = a.id WHERE m.nome LIKE ? ");
            stmt.setString(1, "%"+nome+"%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
               int id = rs.getInt("id");
               String no = rs.getString("nome");
               
               temp.add(new Album(id, no));
            }

            return temp;

        } catch (SQLException e) {

        } finally {
            try {
                con.close();
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ListaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
