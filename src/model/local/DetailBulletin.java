
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
public class DetailBulletin {
  /**
   * DetailBulletin ID
   */
  private int id;

  /**
   * DetailBulletin appreciation
   */
  private String appreciation;

  private Enseignement enseignement;

  private Bulletin bulletin;
  
  private float average;


  public DetailBulletin(int id, String appreciation, Enseignement enseignement, Bulletin bulletin) {
    this.id = id;
    this.appreciation = appreciation;
    this.enseignement = enseignement;
    this.bulletin = bulletin;
    this.average = -1f;
  }
  
  public void computeAverage(Connection connect) {
    try {
      ResultSet result = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.CONCUR_READ_ONLY).executeQuery(
              "SELECT if(COUNT(NOTE)=0, -1.0, AVG(NOTE)) AS AVERAGE "
                  + "FROM evaluation "
                  + "WHERE DETAILBULLETIN_ID = " + id);
      if (result.first()) {
        average = result.getFloat("AVERAGE");
      }
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
    }
  }
  
  public float getAverage() {
    if (average == -1)
      computeAverage(EcoleConnection.getInstance());
    return average;
  }
  
  public String getStringAverage() {
    if (average == -1)
      computeAverage(EcoleConnection.getInstance());
    return average == -1 ? "No average" : String.valueOf(average);
  }

  public int getId() {
    return id;
  }

  public String getAppreciation() {
    return appreciation;
  }

  public Enseignement getEnseignement() {
    return enseignement;
  }

  public Bulletin getBulletin() {
    return bulletin;
  }

  
  @Override
  public String toString() {
    return "DetailBulletin{" + "id=" + id + ", appreciation=" + appreciation + ", enseignement=" + enseignement + ", bulletin=" + bulletin + '}';
  }

  
}
