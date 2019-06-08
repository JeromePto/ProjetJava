
package model.local;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Jerome
 */
public class Discipline extends TableRow{

  /**
   * Discipline name
   */
  private String nom;

  public Discipline(int id, String nom) {
    super(id);
    this.nom = nom;
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

  @Override
  public List<String> getStringRow() {
    List<String> out = new ArrayList<>();
    out.add(String.valueOf(id));
    out.add(nom);
    return out;
  }

  @Override
  public List<String> getColumnName() {
    List<String> out = new ArrayList<>();
    out.add("ID");
    out.add("Nom");
    return out;
  }

  @Override
  public List<String> getStringRowField() {
    List<String> out = new ArrayList<>();
    out.add(String.valueOf(id));
    out.add(nom);
    return out;
  }

  
}
