
package model.local;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 
 * @author Jerome
 */
public class Niveau {
  /**
   * Niveau ID
   */
  private int id;
  
  private String nom;

  public Niveau() {
  }

  public Niveau(int id, String nom) {
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
    return "Niveau{" + "id=" + id + ", nom=" + nom + '}';
  }
  
}
