/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.local.Classe;
import model.local.Niveau;

/**
 *
 * @author Jerome
 */
public class NiveauDAO extends DAO<Niveau> {

  public NiveauDAO(Connection connect) {
    super(connect);
  }

  @Override
  public boolean create(Niveau obj) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean delete(Niveau obj) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean update(Niveau obj) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Niveau find(int id) throws IllegalArgumentException{
    Niveau niv = null;
    try {
      ResultSet result = this.connect.createStatement(
          ResultSet.TYPE_SCROLL_INSENSITIVE, 
          ResultSet.CONCUR_READ_ONLY).executeQuery(
              "SELECT * FROM niveau WHERE ID = " + id);
      if (result.first()) {
        List<Classe> classes = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        for(Integer it : ids) {
          DAO<Classe> tmp = DAOFactory.getClasseDAO();
          classes.add(tmp.find(it));
        }
        niv = new Niveau(result.getInt("ID"), result.getString("NAME"), classes);
      } else {
        throw new IllegalArgumentException("Missing element in Database");
      }
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
    }
    return niv;
  }
  
}
