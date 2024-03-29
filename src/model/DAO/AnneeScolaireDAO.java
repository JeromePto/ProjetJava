/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.local.AnneeScolaire;

/**
 *
 * 
 */
public class AnneeScolaireDAO extends DAO<AnneeScolaire> {

  public AnneeScolaireDAO(Connection connect, String table) {
    super(connect, table);
  }

  @Override
  public boolean create(AnneeScolaire obj) throws SQLException {
    PreparedStatement statement = this.connect.prepareStatement(
        "INSERT INTO anneescolaire (ID) VALUES(?)");
    statement.setObject(1, obj.getId(), Types.INTEGER);
    statement.executeUpdate();
    return true;
  }

  @Override
  public boolean update(AnneeScolaire obj) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public AnneeScolaire find(int id) throws IllegalArgumentException {
    AnneeScolaire annee = null;
    try {
      ResultSet result = this.connect.createStatement(
          ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.CONCUR_READ_ONLY).executeQuery(
              "SELECT * FROM anneescolaire WHERE ID = " + id);
      if (result.first()) {
        annee = new AnneeScolaire(result.getInt("ID"));
      } else {
        throw new IllegalArgumentException("Missing element in Database");
      }
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
    }
    return annee;
  }

}
