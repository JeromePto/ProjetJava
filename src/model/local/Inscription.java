
package model.local;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Jerome
 */
public class Inscription extends TableRow{
  /**
   * Inscription ID
   */
  private int id;

  private Classe classe;

  private Eleve eleve;

  public Inscription() {
  }

  public Inscription(int id, Classe classe, Eleve eleve) {
    this.id = id;
    this.classe = classe;
    this.eleve = eleve;
  }

  public int getId() {
    return id;
  }

  public Classe getClasse() {
    return classe;
  }

  public Eleve getEleve() {
    return eleve;
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
    out.addAll(eleve.getInfo());
    out.addAll(classe.getInfo());
    return out;
  }

  @Override
  public String toString() {
    return "Inscription{" + "id=" + id + ", classe=" + classe + ", eleve=" + eleve + '}';
  }
  
  @Override
  public List<String> getStringRow() {
    List<String> out = new ArrayList<>();
    out.add(String.valueOf(id));
    out.add(classe.readId(true));
    out.add(eleve.readId(true));
    return out;
  }

  @Override
  public List<String> getColumnName() {
    List<String> out = new ArrayList<>();
    out.add("ID");
    out.add("Classe");
    out.add("Eleve");
    return out;
  }
}
