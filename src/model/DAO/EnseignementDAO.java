/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.local.Classe;
import model.local.Discipline;
import model.local.Enseignement;
import model.local.Professeur;

/**
 *
 * @author Jerome
 */
public class EnseignementDAO extends DAO<Enseignement> {

  public EnseignementDAO(Connection connect) {
    super(connect);
  }

  @Override
  public boolean create(Enseignement obj) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean delete(Enseignement obj) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean update(Enseignement obj) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
