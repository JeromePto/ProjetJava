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
import model.local.Bulletin;
import model.local.DetailBulletin;
import model.local.Enseignement;

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
    try {
      PreparedStatement statement = this.connect.prepareStatement(
          "INSERT INTO detailbulletin (APPRECIATION, BULLETIN_ID, ENSEIGEMENT_ID) VALUES(?,?,?)");
      statement.setObject(1, obj.getAppreciation(), Types.VARCHAR);
      statement.setObject(2, obj.getBulletin().getId(), Types.INTEGER);
      statement.setObject(3, obj.getEnseignement().getId(), Types.INTEGER);
      statement.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
      return false;
    }
    return true;
  }

  @Override
  public boolean delete(DetailBulletin obj) {
    try {
      this.connect.createStatement().executeUpdate(
          "DELETE FROM detailbulletin WHERE ID = " + obj.getId());
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
      return false;
    }
    return true;
  }

  @Override
  public boolean update(DetailBulletin obj) {
    try {
      PreparedStatement statement = this.connect.prepareStatement(
          "UPDATE detailbulletin "
              + "SET APPRECIATION = ?, BULLETIN_ID = ?, ENSEIGNEMENT_ID = ? "
              + "WHERE ID = ?");
      statement.setString(1, obj.getAppreciation());
      statement.setInt(2, obj.getBulletin().getId());
      statement.setInt(3, obj.getEnseignement().getId());
      statement.setInt(4, obj.getId());
      statement.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
      return false;
    }
    return true;
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
        det = new DetailBulletin(result.getInt("ID"), result.getString("APPRECIATION"), 
            enseignement.find(result.getInt("ENSEIGNEMENT_ID")), 
            bulletin.find(result.getInt("BULLETIN_ID")));
      } else {
        throw new IllegalArgumentException("Missing element in Database");
      }
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
    }
    return det;
  }

}
