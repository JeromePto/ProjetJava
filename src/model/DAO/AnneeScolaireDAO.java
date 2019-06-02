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

/**
 *
 * @author Jerome
 */
public class AnneeScolaireDAO extends DAO<AnneeScolaire> {

  public AnneeScolaireDAO(Connection connect) {
    super(connect);
  }

  @Override
  public boolean create(AnneeScolaire obj) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean delete(AnneeScolaire obj) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean update(AnneeScolaire obj) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
