package model.local;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Jerome
 */
public abstract class Personne extends TableRow {

  /**
   * Peronne ID
   */
  protected int id;

  /**
   * Personne Name
   */
  protected String nom;

  /**
   * Surname Personne
   */
  protected String prenom;

  public Personne(int id, String nom, String prenom) {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
  }

  /**
   * is it an Eleve ?
   *
   * @return true if is an eleve
   */
  public abstract boolean isEleve();

  @Override
  public String toString() {
    return "Personne{" + "id=" + id + ", nom=" + nom + ", Prenom=" + prenom + '}';
  }

  public int getId() {
    return id;
  }

  public String getNom() {
    return nom;
  }

  public String getPrenom() {
    return prenom;
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
    out.add((isEleve() ? "Eleve" : "Prof") + " " + prenom + " " + nom);
    return out;
  }  

  @Override
  public List<String> getStringRow() {
    List<String> out = new ArrayList<>();
    out.add(String.valueOf(id));
    out.add(nom);
    out.add(prenom);
    return out;
  }

  @Override
  public List<String> getColumnName() {
    List<String> out = new ArrayList<>();
    out.add("ID");
    out.add("Nom");
    out.add("Prenom");
    return out;
  }
}
