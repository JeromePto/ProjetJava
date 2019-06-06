
package model.local;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Jerome
 */
public class AnneeScolaire extends TableRow{
  /**
   * AnneeScolaire ID
   */
  private int id;

  public AnneeScolaire(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "AnneeScolaire{" + "id=" + id + '}';
  }

  public int getId() {
    return id;
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
    out.add(String.valueOf(id) + "-" + String.valueOf(id+1));
    return out;
  }

  @Override
  public List<String> getStringRow() {
    List<String> out = new ArrayList<>();
    out.add(String.valueOf(id));
    return out;
  }

  @Override
  public List<String> getColumnName() {
    List<String> out = new ArrayList<>();
    out.add("ID");
    return out;
  }

}
