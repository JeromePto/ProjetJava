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
import model.local.Classe;
import model.local.Eleve;
import model.local.Inscription;

/**
 *
 * @author Jerome
 */
public class InscriptionDAO extends DAO<Inscription> {

  public InscriptionDAO(Connection connect, String table) {
    super(connect, table);
  }

  @Override
  public boolean create(Inscription obj) throws SQLException {
    PreparedStatement statement = this.connect.prepareStatement(
        "INSERT INTO inscription (CLASSE_ID, PERSONNE_ID) VALUES(?,?)");
    statement.setObject(1, obj.getClasse().getId(), Types.INTEGER);
    statement.setObject(2, obj.getEleve().getId(), Types.INTEGER);
    statement.executeUpdate();
    return true;
  }

  @Override
  public boolean update(Inscription obj) throws SQLException {
    PreparedStatement statement = this.connect.prepareStatement(
        "UPDATE inscription "
        + "SET CLASSE_ID = ?, PERSONNE_ID = ? "
        + "WHERE ID = ?");
    statement.setInt(1, obj.getClasse().getId());
    statement.setInt(2, obj.getEleve().getId());
    statement.setInt(3, obj.getId());
    statement.executeUpdate();
    return true;
  }

  @Override
  public Inscription find(int id) throws IllegalArgumentException {
    Inscription inscri = null;
    try {
      ResultSet result = this.connect.createStatement(
          ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.CONCUR_READ_ONLY).executeQuery(
              "SELECT * FROM inscription WHERE ID = " + id);
      if (result.first()) {
        DAO<Classe> classe = DAOFactory.getClasseDAO();
        DAO<Eleve> eleve = DAOFactory.getEleveDAO();
        inscri = new Inscription(result.getInt("ID"),
            classe.find(result.getInt("CLASSE_ID")),
            eleve.find(result.getInt("PERSONNE_ID")));
      } else {
        throw new IllegalArgumentException("Missing element in Database");
      }
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
    }
    return inscri;
  }

}
