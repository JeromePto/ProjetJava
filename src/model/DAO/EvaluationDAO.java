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
import model.local.DetailBulletin;
import model.local.Evaluation;

/**
 *
 * @author Jerome
 */
public class EvaluationDAO extends DAO<Evaluation> {

  public EvaluationDAO(Connection connect) {
    super(connect);
  }

  @Override
  public boolean create(Evaluation obj) {
    return false;
  }

  @Override
  public boolean delete(Evaluation obj) {
    return false;
  }

  @Override
  public boolean update(Evaluation obj) {
    return false;
  }

  @Override
  public Evaluation find(int id) throws IllegalArgumentException{
    Evaluation eval = null;
    try {
      ResultSet result = this.connect.createStatement(
          ResultSet.TYPE_SCROLL_INSENSITIVE, 
          ResultSet.CONCUR_READ_ONLY).executeQuery(
              "SELECT * FROM evaluation WHERE ID = " + id);
      if (result.first()) {
        DAO<DetailBulletin> detailBulletin = DAOFactory.getDetailBulletinDAO();
        eval = new Evaluation(result.getInt("ID"), result.getFloat("NOTE"),
        result.getString("APPRECIATION"), detailBulletin.find(result.getInt("DETAILBULLETIN_ID")));
      }
      else {
        throw new IllegalArgumentException("Missing element in Database");
      }
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
    }
    return eval;
  }

}
