/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import model.EcoleConnection;
import java.sql.Connection;
import model.TABLE;

/**
 *
 * 
 */
public class DAOFactory {

  /**
   * Connection state
   */
  protected static final Connection connect = EcoleConnection.getInstance();

  public static DAO getEvaluationDAO() {
    return new EvaluationDAO(connect, "evaluation");
  }

  public static DAO getNiveauDAO() {
    return new NiveauDAO(connect, "niveau");
  }

  public static DAO getClasseDAO() {
    return new ClasseDAO(connect, "classe");
  }

  public static DAO getAnneeScolaireDAO() {
    return new AnneeScolaireDAO(connect, "anneescolaire");
  }

  public static DAO getTrimestreDAO() {
    return new TrimestreDAO(connect, "trimestre");
  }

  public static DAO getBulletinDAO() {
    return new BulletinDAO(connect, "bulletin");
  }

  public static DAO getInscriptionDAO() {
    return new InscriptionDAO(connect, "inscription");
  }

  public static DAO getEleveDAO() {
    return new EleveDAO(connect, "personne");
  }

  public static DAO getProfesseurDAO() {
    return new ProfesseurDAO(connect, "personne");
  }

  public static DAO getDisciplineDAO() {
    return new DisciplineDAO(connect, "discipline");
  }

  public static DAO getEnseignementDAO() {
    return new EnseignementDAO(connect, "enseignement");
  }

  public static DAO getDetailBulletinDAO() {
    return new DetailBulletinDAO(connect, "detailbulletin");
  }
/**
 * 
 * @param id de l'objet
 * @return 
 */
  public static DAO getDAOById(int id) {
    switch (id) {
      case TABLE.ANNEESCOLAIRE:
        return getAnneeScolaireDAO();
      case TABLE.BULLETIN:
        return getBulletinDAO();
      case TABLE.CLASSE:
        return getClasseDAO();
      case TABLE.DETAILBULLETIN:
        return getDetailBulletinDAO();
      case TABLE.DISCIPLINE:
        return getDisciplineDAO();
      case TABLE.ELEVE:
        return getEleveDAO();
      case TABLE.ENSEIGNEMENT:
        return getEnseignementDAO();
      case TABLE.EVALUATION:
        return getEvaluationDAO();
      case TABLE.INSCRIPTION:
        return getInscriptionDAO();
      case TABLE.NIVEAU:
        return getNiveauDAO();
      case TABLE.PROFESSEUR:
        return getProfesseurDAO();
      case TABLE.TRIMESTRE:
        return getTrimestreDAO();
      default:
        throw new RuntimeException("Internal error");
    }
  }

}
