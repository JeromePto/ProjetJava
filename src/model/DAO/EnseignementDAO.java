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
import model.local.Discipline;
import model.local.Enseignement;
import model.local.Professeur;

/**
 *
 * 
 */
public class EnseignementDAO extends DAO<Enseignement> {

  public EnseignementDAO(Connection connect, String table) {
    super(connect, table);
  }

  @Override
  public boolean create(Enseignement obj) throws SQLException {
    PreparedStatement statement = this.connect.prepareStatement(
        "INSERT INTO enseignement (CLASSE_ID, DISCIPLINE_ID, PERSONNE_ID) VALUES(?,?,?)");
    statement.setObject(1, obj.getClasse().getId(), Types.INTEGER);
    statement.setObject(2, obj.getDiscipline().getId(), Types.INTEGER);
    statement.setObject(3, obj.getProfesseur().getId(), Types.INTEGER);
    statement.executeUpdate();
    return true;
  }

  @Override
  public boolean update(Enseignement obj) throws SQLException {
    PreparedStatement statement = this.connect.prepareStatement(
        "UPDATE enseignement "
        + "SET CLASSE_ID = ?, DISCIPLINE_ID = ?, PERSONNE_ID = ? "
        + "WHERE ID = ?");
    statement.setInt(1, obj.getClasse().getId());
    statement.setInt(2, obj.getDiscipline().getId());
    statement.setInt(3, obj.getProfesseur().getId());
    statement.setInt(4, obj.getId());
    statement.executeUpdate();
    return true;
  }

  @Override
  public Enseignement find(int id) throws IllegalArgumentException {
    Enseignement ensei = null;
    try {
      ResultSet result = this.connect.createStatement(
          ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.CONCUR_READ_ONLY).executeQuery(
              "SELECT * FROM enseignement WHERE ID = " + id);
      if (result.first()) {
        DAO<Classe> classe = DAOFactory.getClasseDAO();
        DAO<Discipline> discipline = DAOFactory.getDisciplineDAO();
        DAO<Professeur> professeur = DAOFactory.getProfesseurDAO();
        ensei = new Enseignement(result.getInt("ID"),
            classe.find(result.getInt("CLASSE_ID")),
            discipline.find(result.getInt("DISCIPLINE_ID")),
            professeur.find(result.getInt("PERSONNE_ID")));
      } else {
        throw new IllegalArgumentException("Missing element in Database");
      }
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
    }
    return ensei;
  }

}
