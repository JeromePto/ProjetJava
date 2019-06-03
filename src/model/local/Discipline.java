
package model.local;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 
 * @author Jerome
 */
public class Discipline {
  /**
   * Discipline ID
   */
  private int id;

  /**
   * Discipline name
   */
  private String nom;

  public Discipline(int id, String nom) {
    this.id = id;
    this.nom = nom;
  }

  public int getId() {
    return id;
  }

  public String getNom() {
    return nom;
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
    out.add(nom);
    return out;
  }
  
  @Override
  public String toString() {
    return "Discipline{" + "id=" + id + ", nom=" + nom + '}';
  }

  
}
