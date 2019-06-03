/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @param <T>
 * @see https://openclassrooms.com/fr/courses/26832-apprenez-a-programmer-en-java/26830-liez-vos-tables-avec-des-objets-java-le-pattern-dao
 * @author Jerome
 */
public abstract class DAO<T> {
  /**
   * Connection state
   */
  protected Connection connect = null;
  
  protected String table;

  /**
   * Constructor
   * @param connect Connection parmeter
   */
  public DAO(Connection connect, String table) {
    this.connect = connect;
    this.table = table;
  }
  
  /**
   * create object in database
   * @param obj object to create
   * @return success
   */
  public abstract boolean create(T obj);
  
  /**
   * delete object in database
   * @param obj object to delete
   * @return success
   */
  public abstract boolean delete(T obj);
  
  /**
   * update object in database
   * @param obj object to update
   * @return success
   */
  public abstract boolean update(T obj);
  
  /**
   * find object in DB
   * @param id id of object in DB
   * @return the object
   */
  public abstract T find(int id) throws IllegalArgumentException;
  
  public Map<Integer, T> findAll() {
    Map<Integer, T> out = new HashMap<>();    
    try {
      ResultSet result = this.connect.createStatement(
          ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.CONCUR_READ_ONLY).executeQuery(
              "SELECT * FROM " + table + " WHERE 1");
      while(result.next()) {
        out.put(result.getInt("ID"), this.find(result.getInt("ID")));
      }
    } catch (SQLException ex) {
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
    }
    return out;
  }
}
