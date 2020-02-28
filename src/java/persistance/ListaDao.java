/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance;

import Beans.Lista;
import com.sun.org.apache.xpath.internal.axes.FilterExprIteratorSimple;
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
public class ListaDao {

    private Connection con = null;
    private PreparedStatement stmt = null;

    public void excluir(int id) {
        try {
            con = Conexao.getConexao();
            stmt = con.prepareStatement("DELETE FROM musica_da_lista WHERE lista_id = ?");
            stmt.setInt(1, id);

            stmt.executeUpdate();
            
            stmt = con.prepareStatement("DELETE FROM lista WHERE id = ?");
            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ListaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public List<Lista> listar(String login) {
        try {
            con = Conexao.getConexao();
            stmt = con.prepareStatement("SELECT * FROM lista WHERE usuario_login LIKE ?");
            stmt.setString(1, login);

            ResultSet rs = stmt.executeQuery();

            List<Lista> temp = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String usuarioLogin = rs.getString("usuario_login");
                temp.add(new Lista(id, nome, usuarioLogin));
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

    public void inserir(Lista lista) {
        try {
            con = Conexao.getConexao();
            stmt = con.prepareStatement("INSERT INTO lista (nome , usuario_login) VALUES (?,?) ");
            stmt.setString(1, lista.getNome());
            stmt.setString(2, lista.getUsuarioLogin());

            stmt.executeUpdate();

        } catch (SQLException e) {

        } finally {
            try {
                con.close();
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ListaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Lista buscar(int id) {
        try {
            con = Conexao.getConexao();
            stmt = con.prepareStatement("SELECT * FROM lista WHERE id = ? ");
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Lista(id, rs.getString("nome"), rs.getString("usuario_login"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
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
