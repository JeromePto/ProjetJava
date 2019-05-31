/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2v2;

import model.DAO.DAO;
import model.DAO.DAOFactory;
import model.local.Evaluation;

/**
 *
 * @author Jerome
 */
public class Project2v2 {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Project2v2 project2v2;
    project2v2 = new Project2v2();
  }

  public Project2v2() {
    DAO<Evaluation> a = DAOFactory.getEvaluationDAO();
    Evaluation b = null;
    try {
      b = a.find(3);
    } catch (IllegalArgumentException ex) {
      System.out.println("err1");
    } catch (UnsupportedOperationException ex) {
      System.out.println("err2");
    }
    System.out.println(b);
  }
  
}
