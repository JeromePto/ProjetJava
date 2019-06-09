/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.ManagementInterface;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import model.DAO.DAOFactory;

/**
 * Classe : affiche des statistiques sur le nombre d'eleves par niveau 
 */
public class ReportingFrame extends JFrame {

  private JLabel TitleLabel;
  private List<JLabel> labels;
  private List<JProgressBar> bars;
  private ManagementInterface management;
  private Map<String, Integer> datas;
  /**
   * Constructeur : initialise tous les composants de la fenetre
   * @param management effectue les actions associés aux tables/boutons
   */
  public ReportingFrame(ManagementInterface management) {
    super("Reporting");
    this.management = management;
    labels = new ArrayList<>();
    bars = new ArrayList<>();
    setData();
    initComponents();
  }

  public void setData() {
    datas = management.getReporting();
  }
/**
 * Initialisation de la fenetre et de ses composants 
 */
  private void initComponents() {
    GridBagConstraints gridBagConstraints;
    GridBagConstraints gridBagConstraints1;
    int i = 0;

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(new GridBagLayout());
    setMinimumSize(new Dimension(300, 400));

    TitleLabel = new JLabel();
    
    /**
     * Diagramme en barres : pour chaque Map de niveau, on ajoute une barre et un label associé (pour le niveau) 
     */
    for (Map.Entry<String, Integer> it : datas.entrySet()) {
      labels.add(new JLabel());
      bars.add(new JProgressBar());
      gridBagConstraints = new GridBagConstraints();
      gridBagConstraints1 = new GridBagConstraints();
      labels.get(i).setText(it.getKey());
      gridBagConstraints.gridx = i;
      gridBagConstraints.gridy = 2;
      gridBagConstraints.weightx = 1.0;
      getContentPane().add(labels.get(i), gridBagConstraints);
      bars.get(i).setOrientation(JProgressBar.VERTICAL); //Parametres des barres 
      bars.get(i).setMaximum(DAOFactory.getInscriptionDAO().findAll().size());
      bars.get(i).setValue(it.getValue());
      gridBagConstraints1.gridx = i;
      gridBagConstraints1.gridy = 1;
      gridBagConstraints1.weightx = 1.0;
      gridBagConstraints1.weighty = 1.0;
      gridBagConstraints1.fill = GridBagConstraints.VERTICAL;
      gridBagConstraints1.weighty = 1.0;
      getContentPane().add(bars.get(i), gridBagConstraints1);
      i++;
    }
    TitleLabel.setHorizontalAlignment(SwingConstants.CENTER); //Affichage 
    TitleLabel.setText("Elève par Niveau");
    gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = i;
    gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 1.0;
    getContentPane().add(TitleLabel, gridBagConstraints);
    pack();
  }
}
