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
import model.local.AnneeScolaire;
import model.local.Trimestre;

/**
 *
 * 
 */
public class TrimestreDAO extends DAO<Trimestre> {

  public TrimestreDAO(Connection connect, String table) {
    super(connect, table);
  }

  @Override
  public boolean create(Trimestre obj) throws SQLException {
    PreparedStatement statement = this.connect.prepareStatement(
        "INSERT INTO trimestre (NUMERO, DEBUT, FIN, ANNEESCOLAIRE_ID) VALUES(?,?,?,?)");
    statement.setObject(1, obj.getNumero(), Types.INTEGER);
    statement.setObject(2, new java.sql.Date(obj.getDebut().getTime().getTime()), Types.DATE);
    statement.setObject(3, new java.sql.Date(obj.getFin().getTime().getTime()), Types.DATE);
    statement.setObject(4, obj.getAnneeScolaire().getId(), Types.INTEGER);
    statement.executeUpdate();
    return true;
  }

  @Override
  public boolean update(Trimestre obj) throws SQLException {
    PreparedStatement statement = this.connect.prepareStatement(
        "UPDATE trimestre "
        + "SET NUMERO = ?, DEBUT = ?, FIN = ?, ANNEESCOLAIRE_ID = ? "
        + "WHERE ID = ?");
    statement.setInt(1, obj.getNumero());
    statement.setDate(2, new java.sql.Date(obj.getDebut().getTime().getTime()));
    statement.setDate(3, new java.sql.Date(obj.getFin().getTime().getTime()));
    statement.setInt(4, obj.getAnneeScolaire().getId());
    statement.setInt(5, obj.getId());
    statement.executeUpdate();
    return true;
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
