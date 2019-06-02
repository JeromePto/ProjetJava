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
import model.local.AnneeScolaire;
import model.local.Trimestre;

/**
 *
 * @author Jerome
 */
public class TrimestreDAO extends DAO<Trimestre> {

  public TrimestreDAO(Connection connect) {
    super(connect);
  }

  @Override
  public boolean create(Trimestre obj) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean delete(Trimestre obj) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean update(Trimestre obj) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Trimestre find(int id) throws IllegalArgumentException {
    Trimestre tri = null;
    try {
      ResultSet result = this.connect.createStatement(
          ResultSet.TYPE_SCROLL_INSENSITIVE, 
          ResultSet.CONCUR_READ_ONLY).executeQuery(
              "SELECT * FROM trimestre WHERE ID = " + id);
      if (result.first()) {
        DAO<AnneeScolaire> anneeScolaire = DAOFactory.getAnneeScolaireDAO();
        tri = new Trimestre(result.getInt("ID"), 
            anneeScolaire.find(result.getInt("ANNEESCOLAIRE_ID")), 
            result.getInt("NUMERO"), 
            result.getDate("DEBUT"), 
            result.getDate("FIN"));
      } else {
        throw new IllegalArgumentException("Missing element in Database");
      }
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
    }
    return tri;
  }
  
}
