/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @see https://openclassrooms.com/fr/courses/26832-apprenez-a-programmer-en-java/26597-limitez-le-nombre-de-connexions
 * 
 */
public class EcoleConnection {
  /**
   * Database URL
   */
  private static String url = "jdbc:mysql://localhost/ecole";

  /**
   * Database user name
   */
  private static String user = "root";

  /**
   * Database Passeword
   */
  private static String password = "";

  /**
   * Connection object
   */
  private static Connection connect;

  /**
   * Create and/or just return it
   * @return Connection instance
   */
  public static Connection getInstance() {
    if (connect == null) {
      try {
        connect = DriverManager.getConnection(url, user, password);
      } catch (SQLException ex) {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "Erreur de connection", ex);
      }
    }
    return connect;
  }
  
}
