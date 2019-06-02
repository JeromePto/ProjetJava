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
import model.local.Classe;
import model.local.Niveau;

/**
 *
 * @author Jerome
 */
public class ClasseDAO extends DAO<Classe> {

  public ClasseDAO(Connection connect) {
    super(connect);
  }

  @Override
  public boolean create(Classe obj) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean delete(Classe obj) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean update(Classe obj) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
