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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.local.Professeur;
import model.local.TableRow;

/**
 *
 * @author Jerome
 */
public class ProfesseurDAO extends DAO<Professeur> {

  public ProfesseurDAO(Connection connect, String table) {
    super(connect, table);
  }

  @Override
  public boolean create(Professeur obj) throws SQLException {
    PreparedStatement statement = this.connect.prepareStatement(
        "INSERT INTO personne (NOM, PRENOM, TYPE) VALUES(?,?,2)");
    statement.setObject(1, obj.getNom(), Types.VARCHAR);
    statement.setObject(2, obj.getPrenom(), Types.VARCHAR);
    statement.executeUpdate();
    return true;
  }

  @Override
  public boolean delete(Professeur obj) throws SQLException {
    this.connect.createStatement().executeUpdate(
        "DELETE FROM personne WHERE TYPE = 2 AND ID = " + obj.getId());
    return true;
  }

  @Override
  public boolean update(Professeur obj) throws SQLException {
    PreparedStatement statement = this.connect.prepareStatement(
        "UPDATE personne "
        + "SET NOM = ?, PRENOM = ? "
        + "WHERE TYPE = 2 AND ID = ?");
    statement.setString(1, obj.getNom());
    statement.setString(2, obj.getPrenom());
    statement.setInt(3, obj.getId());
    statement.executeUpdate();
    return true;
  }

  @Override
  public Professeur find(int id) throws IllegalArgumentException {
    Professeur prof = null;
    try {
      ResultSet result = this.connect.createStatement(
          ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.CONCUR_READ_ONLY).executeQuery(
              "SELECT * FROM personne WHERE TYPE = 2 AND ID = " + id);
      if (result.first()) {
        prof = new Professeur(result.getInt("ID"),
            result.getString("NOM"),
            result.getString("PRENOM"));
      } else {
        throw new IllegalArgumentException("Missing element in Database");
      }
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
    }
    return prof;
  }

  @Override
  public Map<Integer, TableRow> findAll() {
    Map<Integer, TableRow> out = new HashMap<>();
    try {
      ResultSet result = this.connect.createStatement(
          ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.CONCUR_READ_ONLY).executeQuery(
              "SELECT * FROM " + table + " WHERE TYPE = 2");
      while (result.next()) {
        out.put(result.getInt("ID"), (TableRow) this.find(result.getInt("ID")));
      }
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
    }
    return out;
  }

}
