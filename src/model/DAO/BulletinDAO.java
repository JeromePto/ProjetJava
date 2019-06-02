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
import model.local.Bulletin;
import model.local.Inscription;
import model.local.Trimestre;

/**
 *
 * @author Jerome
 */
public class BulletinDAO extends DAO<Bulletin> {

  public BulletinDAO(Connection connect) {
    super(connect);
  }

  @Override
  public boolean create(Bulletin obj) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean delete(Bulletin obj) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean update(Bulletin obj) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Bulletin find(int id) throws IllegalArgumentException {
    Bulletin bul = null;
    try {
      ResultSet result = this.connect.createStatement(
          ResultSet.TYPE_SCROLL_INSENSITIVE, 
          ResultSet.CONCUR_READ_ONLY).executeQuery(
              "SELECT * FROM bulletin WHERE ID = " + id);
      if (result.first()) {
        DAO<Trimestre> trimestre = DAOFactory.getTrimestreDAO();
        DAO<Inscription> inscription = DAOFactory.getInscriptionDAO();
        bul = new Bulletin(result.getInt("ID"), result.getString("APPRECIATION"), 
            trimestre.find(result.getInt("TRIMESTRE_ID")), 
            inscription.find(result.getInt("INSCRIPTION_ID")));
      } else {
        throw new IllegalArgumentException("Missing element in Database");
      }
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
    }
    return bul;
  }
  
}
