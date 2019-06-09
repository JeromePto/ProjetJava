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
import model.local.Niveau;

/**
 *
 * 
 */
public class NiveauDAO extends DAO<Niveau> {

  public NiveauDAO(Connection connect, String table) {
    super(connect, table);
  }

  @Override
  public boolean create(Niveau obj) throws SQLException {
    PreparedStatement statement = this.connect.prepareStatement(
        "INSERT INTO niveau (NOM) VALUES(?)");
    statement.setObject(1, obj.getNom(), Types.VARCHAR);
    statement.executeUpdate();
    return true;
  }

  @Override
  public boolean update(Niveau obj) throws SQLException {
    PreparedStatement statement = this.connect.prepareStatement(
        "UPDATE niveau "
        + "SET NOM = ? "
        + "WHERE ID = ?");
    statement.setString(1, obj.getNom());
    statement.setInt(2, obj.getId());
    statement.executeUpdate();
    return true;
  }

  @Override
  public Niveau find(int id) throws IllegalArgumentException {
    Niveau niv = null;
    try {
      ResultSet result = this.connect.createStatement(
          ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.CONCUR_READ_ONLY).executeQuery(
              "SELECT * FROM niveau WHERE ID = " + id);
      if (result.first()) {
        niv = new Niveau(result.getInt("ID"), result.getString("NOM"));
      } else {
        throw new IllegalArgumentException("Missing element in Database");
      }
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
    }
    return niv;
  }

}
