/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance;

import Beans.MusicadaLista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis
 */
public class MusicaListaDao {

    private Connection con = null;
    private PreparedStatement stmt = null;

    public void inserir(List<MusicadaLista> lista) {
        try {
            con = Conexao.getConexao();
            for (MusicadaLista a : lista) {
                stmt = con.prepareStatement("Insert INTO musica_da_lista values (?,?,?)");
                stmt.setInt(1, a.getListaid());
                stmt.setInt(1, a.getMusicaid());
                stmt.setInt(1, a.getQtdeDeVezesTocada());
                stmt.executeUpdate();
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
    }

}

