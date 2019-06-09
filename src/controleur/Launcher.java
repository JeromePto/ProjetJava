/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import vue.MainFrame;
import vue.ReportingFrame;

/**
 *
 * 
 */
public class Launcher {
  
  public static void main(String[] args) {
    Launcher launcher = new Launcher();
  }
  
  public Launcher() {
    Management management = new Management();
    MainFrame mainFrame = new MainFrame(management);
    ReportingFrame report = new ReportingFrame(management);
    mainFrame.setVisible(true);
    report.setVisible(true);
  }
}
