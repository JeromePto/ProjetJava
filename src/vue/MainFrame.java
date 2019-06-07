/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.Management;
import controleur.ManagementInterface;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.TABLE;

/**
 *
 * @author Jerome
 */
public class MainFrame extends JFrame implements ActionListener{

  private JPanel bottomPanel;
  private JPanel buttonPanel;
  private JButton createButton;
  private JButton deletebutton;
  private JPanel fieldPanel;
  private List<JButton> tableChange;
  private JPanel tableChoicePanel;
  private JPanel tablePanel;
  private JPanel topPanel;
  private JButton updatebutton;
  private ManagementInterface management;

  public MainFrame(ManagementInterface management) {
    this.management = management;
    this.tablePanel = management.getTable();
    this.fieldPanel = management.getField();
    initComponents();
  }

  private void makeTopPanel() {
    topPanel = new JPanel();
    buttonPanel = new JPanel();
    createButton = new JButton();
    updatebutton = new JButton();
    deletebutton = new JButton();

    topPanel.setLayout(new BorderLayout());
    topPanel.add(fieldPanel, BorderLayout.CENTER);

    buttonPanel.setLayout(new GridLayout());

    createButton.setText("Créer");
    buttonPanel.add(createButton);

    updatebutton.setText("Modifier");
    buttonPanel.add(updatebutton);

    deletebutton.setText("Supprimer");
    buttonPanel.add(deletebutton);

    topPanel.add(buttonPanel, BorderLayout.EAST);

    getContentPane().add(topPanel, BorderLayout.NORTH);
  }

  private void initComponents() {
    GridBagConstraints gridBagConstraints;
    tableChange = new ArrayList<>();
    makeTopPanel();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    bottomPanel = new JPanel();
    tableChoicePanel = new JPanel();
    bottomPanel.setLayout(new BorderLayout());
    bottomPanel.add(tablePanel, BorderLayout.CENTER);
    tableChoicePanel.setLayout(new GridBagLayout());
    for (int i = 0; i < 12; i++) {
      tableChange.add(new JButton());
      tableChange.get(i).setText(TABLE.name(i));
      tableChange.get(i).addActionListener(this);
      gridBagConstraints = new GridBagConstraints();
      gridBagConstraints.gridx = 0;
      gridBagConstraints.gridy = i;
      gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
      tableChoicePanel.add(tableChange.get(i), gridBagConstraints);
    }

    bottomPanel.add(tableChoicePanel, BorderLayout.WEST);
    getContentPane().add(bottomPanel, BorderLayout.CENTER);

    pack();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().getClass() == JButton.class) {
      JButton tmp = (JButton) e.getSource();
      for (int i = 0 ; i < 12 ; i++) {
        if (tmp == tableChange.get(i)) {
          management.switchTable(i);
        }
      }
    }
  }
  
  
}
