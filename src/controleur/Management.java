/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.util.Map;
import model.DAO.DAO;
import model.DAO.DAOFactory;
import model.local.AnneeScolaire;
import model.local.TableRow;
import vue.FieldPanel;
import vue.MainTable;

/**
 *
 * @author Jerome
 */
public class Management implements ManagementInterface{  

  private Map<Integer, TableRow> datas;
  private final MainTable table;
  private final FieldPanel field;

  public Management() {
    DAO<AnneeScolaire> dao = DAOFactory.getBulletinDAO();
    datas = dao.findAll();
    table = new MainTable(new EcoleTableModel(datas));
    field = new FieldPanel(new EcoleFieldModel(datas));
  }

  public void switchTable(int tableId) {
    DAO dao = DAOFactory.getDAOById(tableId);
    datas = dao.findAll();
    table.changeTable(new EcoleTableModel(datas));
    field.changeField(new EcoleFieldModel(datas));
  }

  @Override
  public MainTable getTable() {
    return table;
  }
  
  @Override
  public FieldPanel getField() {
    return field;
  }
}
