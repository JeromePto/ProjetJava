
package model.local;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * 
 */
public class Evaluation extends TableRow{

  /**
   * Evaluation mark
   */
  private float note;

  /**
   * Evaluation appreciation
   */
  private String appreciation;

  private DetailBulletin detailBulletin;

  public Evaluation(int id, float note, String appreciation, DetailBulletin detailBulletin) {
    super(id);
    this.note = note;
    this.appreciation = appreciation;
    this.detailBulletin = detailBulletin;
  }
  
  public float getNote() {
    return note;
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

  @Override
  public List<String> getStringRow() {
    List<String> out = new ArrayList<>();
    out.add(String.valueOf(id));
    out.add(String.valueOf(note));
    out.add(appreciation);
    out.add(detailBulletin.readId(true));
    return out;
  }

  @Override
  public List<String> getColumnName() {
    List<String> out = new ArrayList<>();
    out.add("ID");
    out.add("Note");
    out.add("Appreciation");
    out.add("Detail Bulletin");
    return out;
  }

  @Override
  public List<String> getStringRowField() {
    List<String> out = new ArrayList<>();
    out.add(String.valueOf(id));
    out.add(String.valueOf(note));
    out.add(appreciation);
    out.add(String.valueOf(detailBulletin.getId()));
    return out;
  }
}
