/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;

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

  /**
   * Constructor
   * @param connect Connection parmeter
   */
  public DAO(Connection connect) {
    this.connect = connect;
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
}
