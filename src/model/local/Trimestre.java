package model.local;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author Jerome
 */
public class Trimestre {

  /**
   * Trimestre ID
   */
  private int id;

  private AnneeScolaire anneeScolaire;

  /**
   * Trimestre number (1-3)
   */
  private int numero;

  /**
   * Starting trimestre date
   */
  private Calendar debut;

  public int getId() {
    return id;
  }

  public AnneeScolaire getAnneeScolaire() {
    return anneeScolaire;
  }

  public int getNumero() {
    return numero;
  }

  public Calendar getDebut() {
    return debut;
  }

  public Calendar getFin() {
    return fin;
  }

  /**
   * Ending trimestre date
   */
  private Calendar fin;

  public Trimestre(int id, AnneeScolaire anneeScolaire, int numero, Calendar debut, Calendar fin) {
    this.id = id;
    this.anneeScolaire = anneeScolaire;
    this.numero = numero;
    this.debut = debut;
    this.fin = fin;
  }
  
  public Trimestre(int id, AnneeScolaire anneeScolaire, int numero, Date debut, Date fin) {
    this.id = id;
    this.anneeScolaire = anneeScolaire;
    this.numero = numero;
    this.debut = Calendar.getInstance();
    this.debut.setTime(debut);
    this.fin = Calendar.getInstance();
    this.fin.setTime(fin);
  }
  
  public String readId(boolean printId) {
    String tmp = "T" + numero + " " + anneeScolaire.readId(false);
    return printId ? String.valueOf(id) + " : " + tmp : tmp;
  }

  @Override
  public String toString() {
    return "Trimestre{" + "id=" + id + ", anneeScolaire=" + anneeScolaire + ", numero=" + numero + ", debut=" + debut.getTime() + ", fin=" + fin.getTime() + '}';
  }

  
}
