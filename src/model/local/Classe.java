
package model.local;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


/**
 * 
 * @author Jerome
 */
public class Classe extends TableRow {
  /**
   * Classe ID
   */
  private int id;

  /**
   * name of classe
   */
  private String nom;

  private AnneeScolaire anneeScolaire;

  private Niveau niveau;

  public Classe(int id, String nom, AnneeScolaire anneeScolaire, Niveau niveau) {
    this.id = id;
    this.nom = nom;
    this.anneeScolaire = anneeScolaire;
    this.niveau = niveau;
  }

  @Override
  public String toString() {
    return "Classe{" + "id=" + id + ", nom=" + nom + ", anneeScolaire=" + anneeScolaire + ", niveau=" + niveau + '}';
  }

  public int getId() {
    return id;
  }

  public String getNom() {
    return nom;
  }

  public AnneeScolaire getAnneeScolaire() {
    return anneeScolaire;
  }

  public Niveau getNiveau() {
    return niveau;
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
    out.addAll(anneeScolaire.getInfo());
    return out;
  }

  @Override
  public List<String> getStringRow() {
    List<String> out = new ArrayList<>();
    out.add(String.valueOf(id));
    out.add(nom);
    out.add(anneeScolaire.readId(true));
    out.add(niveau.readId(true));
    return out;
  }

  @Override
  public List<String> getColumnName() {
    List<String> out = new ArrayList<>();
    out.add("ID");
    out.add("Nom");
    out.add("Année Scolaire");
    out.add("Niveau");
    return out;
  }
}
