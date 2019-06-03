package model.local;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.EcoleConnection;

/**
 *
 * @author Jerome
 */
public class Bulletin {

  /**
   * Bulletin ID
   */
  private int id;

  /**
   * Bulletin appreciation
   */
  private String appreciation;

  private Trimestre trimestre;

  private Inscription inscription;
  
  private float average;

  public Bulletin(int id, String appreciation, Trimestre trimestre, Inscription inscription) {
    this.id = id;
    this.appreciation = appreciation;
    this.trimestre = trimestre;
    this.inscription = inscription;
    this.average = -1f;
  }

  @Override
  public String toString() {
    return "Bulletin{" + "id=" + id + ", appreciation=" + appreciation + ", trimestre=" + trimestre + ", insription=" + inscription + '}';
  }
  
  public void computeAverage(Connection connect) {
    try {
      ResultSet result = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.CONCUR_READ_ONLY).executeQuery(
              "SELECT if(COUNT(NOTE)=0, -1.0, AVG(NOTE)) AS AVERAGE "
                  + "FROM bulletin "
                  + "INNER JOIN detailbulletin ON detailbulletin.BULLETIN_ID = bulletin.ID "
                  + "INNER JOIN evaluation ON evaluation.DETAILBULLETIN_ID = detailbulletin.ID "
                  + "WHERE bulletin.ID = " + id);
      if (result.first()) {
        average = result.getFloat("AVERAGE");
      }
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
    }
  }

  /**
   * calculate the average
   *
   * @return Average for the bulletin
   */
  public float getAverage() {
    if (average == -1) {
      computeAverage(EcoleConnection.getInstance());
    }
    return average;
  }
  
  public String getStringAverage() {
    if (average == -1) {
      computeAverage(EcoleConnection.getInstance());
    }
    return average == -1 ? "No average" : String.valueOf(average);
  }

  public int getId() {
    return id;
  }

  public String getAppreciation() {
    return appreciation;
  }

  public Trimestre getTrimestre() {
    return trimestre;
  }

  public Inscription getInscription() {
    return inscription;
  }
  
  public String read() {
    return String.valueOf(id) + " info bulletin"; //TODO complete this
  }

}
