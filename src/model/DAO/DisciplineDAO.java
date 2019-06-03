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
import model.local.Discipline;

/**
 *
 * @author Jerome
 */
public class DisciplineDAO extends DAO<Discipline> {

  public DisciplineDAO(Connection connect, String table) {
    super(connect, table);
  }

  @Override
  public boolean create(Discipline obj) {
    try {
      PreparedStatement statement = this.connect.prepareStatement(
          "INSERT INTO discipline (NOM) VALUES(?)");
      statement.setObject(1, obj.getNom(), Types.VARCHAR);
      statement.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
      return false;
    }
    return true;
  }

  @Override
  public boolean delete(Discipline obj) {
    try {
      this.connect.createStatement().executeUpdate(
          "DELETE FROM discipline WHERE ID = " + obj.getId());
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
      return false;
    }
    return true;
  }

  @Override
  public boolean update(Discipline obj) {
    try {
      PreparedStatement statement = this.connect.prepareStatement(
          "UPDATE discipline "
              + "SET NOM = ? "
              + "WHERE ID = ?");
      statement.setString(1, obj.getNom());
      statement.setInt(2, obj.getId());
      statement.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
      return false;
    }
    return true;
  }

  @Override
  public Discipline find(int id) throws IllegalArgumentException {
    Discipline dis = null;
    try {
      ResultSet result = this.connect.createStatement(
          ResultSet.TYPE_SCROLL_INSENSITIVE, 
          ResultSet.CONCUR_READ_ONLY).executeQuery(
              "SELECT * FROM discipline WHERE ID = " + id);
      if (result.first()) {
        dis = new Discipline(result.getInt("ID"), result.getString("NOM"));
      } else {
        throw new IllegalArgumentException("Missing element in Database");
      }
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
    }
    return dis;
  }
  
}