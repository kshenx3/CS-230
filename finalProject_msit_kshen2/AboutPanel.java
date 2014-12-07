/*
 * CS 230 - Final Project
 * AboutPanel.java
 * 
 * Michelle Sit & Kasey Shen
 * 
 * PURPOSE:
 * 
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.*;

public class AboutPanel extends JPanel {
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //-------------------------------Instance Variables
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private JLabel empty;
  private JLabel mainTitle, aboutPro, directions, aboutCreators, michelle, mDescript, kasey, kDescript;
  private JPanel programInfo, creatorsInfo;
  private HomesForAll hfaAbout;
  
  public AboutPanel() {
    //meow .__.
  }
  
  public AboutPanel(HomesForAll input) {
    hfaAbout = input;
    
    JLabel mainTitle = new JLabel("About\n\n");
    JLabel aboutPro = new JLabel("blahblahblahblahblahblahblah\n");
    JLabel directions = new JLabel("How do I do all this MERH\n\n");
    JLabel aboutCreators = new JLabel("About the Creators~");
    JLabel michelle = new JLabel("Michelle");
    JLabel mDescript = new JLabel("Msit's description goes here");
    JLabel kasey = new JLabel("Kasey");
    JLabel kDescript = new JLabel("Kasey's description?");
    
    JLabel empty = new JLabel("_______");
    
    this.setLayout(new BorderLayout());
    
    JPanel programInfo = new JPanel();
    programInfo.setLayout(new BoxLayout(programInfo, BoxLayout.Y_AXIS));
    programInfo.add(mainTitle);
    programInfo.add(Box.createRigidArea(new Dimension(10,10)));
    programInfo.add(aboutPro);
    programInfo.add(Box.createRigidArea(new Dimension(0,10)));
    programInfo.add(directions);
    
    
    JPanel creatorsInfo = new JPanel();
    creatorsInfo.setLayout(new GridLayout(0,2));
    creatorsInfo.add(aboutCreators);
    creatorsInfo.add(empty);
    creatorsInfo.add(michelle);
    creatorsInfo.add(kasey);
    creatorsInfo.add(mDescript);
    creatorsInfo.add(kDescript);
    
    
    this.add(mainTitle, BorderLayout.NORTH);
    this.add(programInfo, BorderLayout.CENTER);
    this.add(creatorsInfo, BorderLayout.SOUTH);
    
    
  }
  
  
}