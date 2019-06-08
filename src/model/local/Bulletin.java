package model.local;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.EcoleConnection;

/**
 *
 * @author Jerome
 */
public class Bulletin extends TableRow {


  /**
   * Bulletin appreciation
   */
  private String appreciation;

  private Trimestre trimestre;

  private Inscription inscription;
  
  private float average;

  public Bulletin(int id, String appreciation, Trimestre trimestre, Inscription inscription) {
    super(id);
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

  public String getAppreciation() {
    return appreciation;
  }

  public Trimestre getTrimestre() {
    return trimestre;
  }

  public Inscription getInscription() {
    return inscription;
  }
  
  public String readId(boolean printId) {
    String tmp = "";
    for(String it : getInfo()) {
      tmp += it + " ";
    }
    return printId ? String.valueOf(id) + " : " + tmp : tmp;
  }
  
  Set<String> getInfo() {
    Set<String> out = new LinkedHashSet<>();
    out.addAll(trimestre.getInfo());
    out.addAll(inscription.getInfo());
    return out;
  }

  @Override
  public List<String> getStringRow() {
    List<String> out = new ArrayList<>();
    out.add(String.valueOf(id));
    out.add(appreciation);
    out.add(trimestre.readId(true));
    out.add(inscription.readId(true));
    out.add(getStringAverage());
    return out;
  }

  @Override
  public List<String> getColumnName() {
    List<String> out = new ArrayList<>();
    out.add("ID");
    out.add("Apperciation");
    out.add("Trimestre");
    out.add("Inscription");
    out.add("Moyenne");
    return out;
  }

  @Override
  public List<String> getStringRowField() {
    List<String> out = new ArrayList<>();
    out.add(String.valueOf(id));
    out.add(appreciation);
    out.add(String.valueOf(trimestre.getId()));
    out.add(String.valueOf(inscription.getId()));
    out.add(getStringAverage());
    return out;
  }

}
