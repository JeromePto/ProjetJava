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
import model.local.Inscription;
import model.local.Trimestre;

/**
 *
 * @author Jerome
 */
public class BulletinDAO extends DAO<Bulletin> {

  public BulletinDAO(Connection connect, String table) {
    super(connect, table);
  }

  @Override
  public boolean create(Bulletin obj) throws SQLException {
    PreparedStatement statement = this.connect.prepareStatement(
        "INSERT INTO bulletin (APPRECIATION, INSCRIPTION_ID, TRIMESTRE_ID) VALUES(?,?,?)");
    statement.setObject(1, obj.getAppreciation(), Types.VARCHAR);
    statement.setObject(2, obj.getInscription().getId(), Types.INTEGER);
    statement.setObject(3, obj.getTrimestre().getId(), Types.INTEGER);
    statement.executeUpdate();
    return true;
  }

  @Override
  public boolean update(Bulletin obj) throws SQLException {
    PreparedStatement statement = this.connect.prepareStatement(
        "UPDATE bulletin "
        + "SET APPRECIATION = ?, INSCRIPTION_ID = ?, TRIMESTRE_ID = ? "
        + "WHERE ID = ?");
    statement.setString(1, obj.getAppreciation());
    statement.setInt(2, obj.getInscription().getId());
    statement.setInt(3, obj.getTrimestre().getId());
    statement.setInt(4, obj.getId());
    statement.executeUpdate();
    return true;
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
