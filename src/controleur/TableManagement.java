/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.util.Map;
import model.DAO.DAO;
import model.DAO.DAOFactory;
import model.EcoleTableModel;
import model.local.AnneeScolaire;
import model.local.TableRow;
import vue.MainTable;

/**
 *
 * @author Jerome
 */
public class TableManagement {  

  private Map<Integer, TableRow> datas;

  private final MainTable table;

  public TableManagement() {
    DAO<AnneeScolaire> dao = DAOFactory.getAnneeScolaireDAO();
    datas = dao.findAll();
    table = new MainTable(new EcoleTableModel(datas));
  }

  public void switchTable(int tableId) {
    DAO dao = DAOFactory.getDAOById(tableId);
    datas = dao.findAll();
    table.changeTable(new EcoleTableModel(datas));
  }

  public MainTable getTable() {
    return table;
  }
}
