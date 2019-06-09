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
import model.local.DetailBulletin;
import model.local.Evaluation;

/**
 *
 * 
 */
public class EvaluationDAO extends DAO<Evaluation> {

  public EvaluationDAO(Connection connect, String table) {
    super(connect, table);
  }

  @Override
  public boolean create(Evaluation obj) throws SQLException {
    PreparedStatement statement = this.connect.prepareStatement(
        "INSERT INTO evaluation (NOTE, APPRECIATION, DETAILBULLETIN_ID) VALUES(?,?,?)");
    statement.setObject(1, obj.getNote(), Types.FLOAT);
    statement.setObject(2, obj.getAppreciation(), Types.VARCHAR);
    statement.setObject(3, obj.getDetailBulletin().getId(), Types.INTEGER);
    statement.executeUpdate();
    return true;
  }

  @Override
  public boolean update(Evaluation obj) throws SQLException {
    PreparedStatement statement = this.connect.prepareStatement(
        "UPDATE evaluation "
        + "SET NOTE = ?, APPRECIATION = ?, DETAILBULLETIN_ID = ? "
        + "WHERE ID = ?");
    statement.setFloat(1, obj.getNote());
    statement.setString(2, obj.getAppreciation());
    statement.setInt(3, obj.getDetailBulletin().getId());
    statement.setInt(4, obj.getId());
    statement.executeUpdate();
    return true;
  }

  @Override
  public Evaluation find(int id) throws IllegalArgumentException {
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
      } else {
        throw new IllegalArgumentException("Missing element in Database");
      }
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
    }
    return eval;
  }

}
