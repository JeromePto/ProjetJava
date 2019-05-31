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
import model.local.Bulletin;
import model.local.DetailBulletin;
import model.local.Enseignement;
import model.local.Evaluation;

/**
 *
 * @author Jerome
 */
public class DetailBulletinDAO extends DAO<DetailBulletin> {

  public DetailBulletinDAO(Connection connect) {
    super(connect);
  }

  @Override
  public boolean create(DetailBulletin obj) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean delete(DetailBulletin obj) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean update(DetailBulletin obj) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public DetailBulletin find(int id) throws IllegalArgumentException {
    DetailBulletin det = null;
    try {
      ResultSet result = this.connect.createStatement(
          ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.CONCUR_READ_ONLY).executeQuery(
              "SELECT * FROM detailbulletin WHERE ID = " + id);
      if (result.first()) {
        DAO<Enseignement> enseignement = DAOFactory.getEnseignementDAO();
        DAO<Bulletin> bulletin = DAOFactory.getBulletinDAO();
        List<Evaluation> evaluations = new ArrayList<>();
        ResultSet result2 = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeQuery(
                "SELECT * FROM detailbulletin \n"
                + "INNER JOIN evaluation ON evaluation.DETAILBULLETIN_ID = detailbulletin.ID\n"
                + "WHERE detailbulletin.ID = " + id);
        while (result2.next()) {
          
        }
        System.out.println(evaluations);
//        det = new DetailBulletin(result.getInt("ID"), result.getString("APPRECIATION"), 
//            enseignement.find(result.getInt("ENSEIGNEMENT_ID")), 
//            bulletin.find(result.getInt("BULLETIN_ID")), evaluations);        
      } else {
        throw new IllegalArgumentException("Missing element in Database");
      }
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
    }
    return det;
  }

}
