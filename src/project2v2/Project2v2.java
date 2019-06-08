/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2v2;

import controleur.Management;
import java.awt.Dimension;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import model.DAO.DAO;
import model.DAO.DAOFactory;
import model.TABLE;
import model.local.*;
import vue.MainFrame;
import vue.MainTable;
import vue.ReportingFrame;

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
    //    DAO<Evaluation> a = DAOFactory.getEvaluationDAO();
    //    Evaluation b = null;
    ////    DAO<Classe> a = DAOFactory.getClasseDAO();
    ////    Classe b = null;
    //    try {
    //      b = a.find(3);
    //    } catch (IllegalArgumentException ex) {
    //      System.out.println("err1");
    //      System.out.println(ex.getMessage());
    //    } catch (UnsupportedOperationException ex) {
    //      System.out.println("err2");
    //      System.out.println(ex.getMessage());
    //      ex.printStackTrace();
    //    }
    //    System.out.println(b);
    //    System.out.println(a.findAll()); renvoie une map 
    //    System.out.println(b.getDetailBulletin().getStringAverage());
    //    System.out.println(b.getDetailBulletin().getBulletin().getStringAverage());
    //    a.delete(a.find(113));
    //    a.create(new Evaluation(-1, 6f, "prout", (DetailBulletin) DAOFactory.getDetailBulletinDAO().find(6)));
    //    a.update(new Evaluation(114, 19.5f, "prout", (DetailBulletin) DAOFactory.getDetailBulletinDAO().find(6)));
    //    System.out.println(b.getDetailBulletin().getBulletin().getInscription().getClasse().getAnneeScolaire().readId(true));
    //    System.out.println(b.getDetailBulletin().getBulletin().readId(true));
    //    System.out.println(b.getDetailBulletin().getBulletin().getInscription().getClasse().readId(true));
    //    System.out.println(b.getDetailBulletin().readId(true));
    //    System.out.println(b.readId(true)); 
    //    //salut
    //    JFrame frame = new JFrame("Test");
    //    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //    Management a = new Management();
    //    MainTable table = a.getTable();
    //    
    //    frame.setContentPane(table);
    //    //frame.setMinimumSize(new Dimension(600, 600));
    //    frame.pack();
    //    frame.setVisible(true);
    //    a.switchTable(TABLE.PROFESSEUR);
  }

}
