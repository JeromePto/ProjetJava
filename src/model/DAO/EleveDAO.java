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
import model.local.Eleve;

/**
 *
 * @author Jerome
 */
public class EleveDAO extends DAO<Eleve> {

  public EleveDAO(Connection connect) {
    super(connect);
  }

  @Override
  public boolean create(Eleve obj) {
    try {
      PreparedStatement statement = this.connect.prepareStatement(
          "INSERT INTO personne (NOM, PRENOM, TYPE) VALUES(?,?,1)");
      statement.setObject(1, obj.getNom(), Types.VARCHAR);
      statement.setObject(2, obj.getPrenom(), Types.VARCHAR);
      statement.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
      return false;
    }
    return true;
  }

  @Override
  public boolean delete(Eleve obj) {
    try {
      this.connect.createStatement().executeUpdate(
          "DELETE FROM personne WHERE TYPE = 1 AND ID = " + obj.getId());
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
      return false;
    }
    return true;
  }

  @Override
  public boolean update(Eleve obj) {
    try {
      PreparedStatement statement = this.connect.prepareStatement(
          "UPDATE personne "
              + "SET NOM = ?, PRENOM = ? "
              + "WHERE TYPE = 1 AND ID = ?");
      statement.setString(1, obj.getNom());
      statement.setString(2, obj.getPrenom());
      statement.setInt(3, obj.getId());
      statement.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
      return false;
    }
    return true;
  }

  @Override
  public Eleve find(int id) throws IllegalArgumentException {
    Eleve eleve = null;
    try {
      ResultSet result = this.connect.createStatement(
          ResultSet.TYPE_SCROLL_INSENSITIVE, 
          ResultSet.CONCUR_READ_ONLY).executeQuery(
              "SELECT * FROM personne WHERE TYPE = 1 AND ID = " + id);
      if (result.first()) {
        eleve = new Eleve(result.getInt("ID"), 
            result.getString("NOM"), result.getString("PRENOM"));
      } else {
        throw new IllegalArgumentException("Missing element in Database");
      }
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
    }
    return eleve;
  }
  
}
