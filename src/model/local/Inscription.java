
package model.local;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * 
 */
public class Inscription extends TableRow{

  private Classe classe;

  private Eleve eleve;

  public Inscription(int id, Classe classe, Eleve eleve) {
    super(id);
    this.classe = classe;
    this.eleve = eleve;
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

  @Override
  public List<String> getStringRowField() {
    List<String> out = new ArrayList<>();
    out.add(String.valueOf(id));
    out.add(String.valueOf(classe.getId()));
    out.add(String.valueOf(eleve.getId()));
    return out;
  }
}
