/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import model.EcoleConnection;
import java.sql.Connection;

/**
 * 
 * @author Jerome
 */
public class DAOFactory {
  /**
   * Connection state
   */
  protected static final Connection connect = EcoleConnection.getInstance();
  
  public static DAO getEvaluationDAO() {
    return new EvaluationDAO(connect);
  }
  
  public static DAO getNiveauDAO() {
    return new NiveauDAO(connect);
  }
  
  public static DAO getClasseDAO() {
    return new ClasseDAO(connect);
  }
  
  public static DAO getAnneeScolaireDAO() {
    return new AnneeScolaireDAO(connect);
  }
  
  public static DAO getTrimestreDAO() {
    return new TrimestreDAO(connect);
  }
  
  public static DAO getBulletinDAO() {
    return new BulletinDAO(connect);
  }
  
  public static DAO getInscriptionDAO() {
    return new InscriptionDAO(connect);
  }
  
  public static DAO getEleveDAO() {
    return new EleveDAO(connect);
  }
  
  public static DAO getProfesseurDAO() {
    return new ProfesseurDAO(connect);
  }
  
  public static DAO getDisciplineDAO() {
    return new DisciplineDAO(connect);
  }
  
  public static DAO getEnseignementDAO() {
    return new EnseignementDAO(connect);
  }
  
  public static DAO getDetailBulletinDAO() {
    return new DetailBulletinDAO(connect);
  }
}
