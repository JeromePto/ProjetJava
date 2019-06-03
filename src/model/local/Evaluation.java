
package model.local;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 
 * @author Jerome
 */
public class Evaluation {
  /**
   * Evaluation ID
   */
  private int id;

  /**
   * Evaluation mark
   */
  private float note;

  /**
   * Evaluation appreciation
   */
  private String appreciation;

  private DetailBulletin detailBulletin;

  public Evaluation() {
  }

  public Evaluation(int id, float note, String appreciation, DetailBulletin detailBulletin) {
    this.id = id;
    this.note = note;
    this.appreciation = appreciation;
    this.detailBulletin = detailBulletin;
  }
  
  public float getNote() {
    return note;
  }

  public int getId() {
    return id;
  }

  public String getAppreciation() {
    return appreciation;
  }

  public DetailBulletin getDetailBulletin() {
    return detailBulletin;
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
    out.add(String.valueOf(note));
    out.addAll(detailBulletin.getInfo());
    return out;
  }

  @Override
  public String toString() {
    return "Evaluation{" + "id=" + id + ", note=" + note + ", appreciation=" + appreciation + ", detailBulletin=" + detailBulletin + '}';
  }

}
