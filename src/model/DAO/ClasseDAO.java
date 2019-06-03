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
import model.local.Classe;
import model.local.Niveau;

/**
 *
 * @author Jerome
 */
public class ClasseDAO extends DAO<Classe> {

  public ClasseDAO(Connection connect, String table) {
    super(connect, table);
  }

  @Override
  public boolean create(Classe obj) {
    try {
      PreparedStatement statement = this.connect.prepareStatement(
          "INSERT INTO evaluation (NOM, NIVEAU_ID, ANNEESCOLAIRE_ID) VALUES(?,?,?)");
      statement.setObject(1, obj.getNom(), Types.VARCHAR);
      statement.setObject(2, obj.getNiveau().getId(), Types.INTEGER);
      statement.setObject(3, obj.getAnneeScolaire().getId(), Types.INTEGER);
      statement.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
      return false;
    }
    return true;
  }

  @Override
  public boolean delete(Classe obj) {
    try {
      this.connect.createStatement().executeUpdate(
          "DELETE FROM classe WHERE ID = " + obj.getId());
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
      return false;
    }
    return true;
  }

  @Override
  public boolean update(Classe obj) {
    try {
      PreparedStatement statement = this.connect.prepareStatement(
          "UPDATE classe "
              + "SET NOM = ?, NIVEAU_ID = ?, ANNEESCOLAIRE_ID = ? "
              + "WHERE ID = ?");
      statement.setString(1, obj.getNom());
      statement.setInt(2, obj.getNiveau().getId());
      statement.setInt(3, obj.getAnneeScolaire().getId());
      statement.setInt(4, obj.getId());
      statement.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
      return false;
    }
    return true;
  }

  @Override
  public Classe find(int id) throws IllegalArgumentException {
    Classe classe = null;
    try {
      ResultSet result = this.connect.createStatement(
          ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.CONCUR_READ_ONLY).executeQuery(
              "SELECT * FROM classe WHERE ID = " + id);
      if (result.first()) {
        DAO<AnneeScolaire> anneeScolaire = DAOFactory.getAnneeScolaireDAO();
        DAO<Niveau> niveau = DAOFactory.getNiveauDAO();
        classe = new Classe(result.getInt("ID"), result.getString("NOM"),
            anneeScolaire.find(result.getInt("ANNEESCOLAIRE_ID")), 
            niveau.find(result.getInt("NIVEAU_ID")));
      } else {
        throw new IllegalArgumentException("Missing element in Database");
      }
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
    }
    return classe;
  }

}
