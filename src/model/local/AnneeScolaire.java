
package model.local;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 
 * @author Jerome
 */
public class AnneeScolaire {
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

}
