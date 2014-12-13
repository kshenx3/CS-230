/*
 * CS 230 - Final Project
 * AboutPanel.java
 * 
 * Michelle Sit & Kasey Shen
 * 
 * PURPOSE: Creates 
 * 
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font.*;
import javax.swing.*;

public class AboutPanel extends JPanel {
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //-------------------------------Instance Variables
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private JLabel mainTitle; //North Panel
  private JLabel aboutPro, aboutPro2, aboutPro3, aboutPro4, aboutPro5, aboutPro6, aboutPro7, aboutPro8;
  private JLabel aboutTitle, aboutCreators, michelle, mDescript, kasey, kDescript; //Center panel
  private JPanel titlePanel, programInfo, creatorsInfo, leftPanel, rightPanel;
  private HomesForAll hfaAbout;
  
  public AboutPanel() {
    //meow .__.
  }
  
  public AboutPanel(HomesForAll input) {
    hfaAbout = input;
    
    //North Panel
    JLabel mainTitle = new JLabel("Homes For All");
    mainTitle.setFont(new Font("Verdana", Font.BOLD, 50));
    mainTitle.setForeground(Color.WHITE);
    
    //adding and spacing
    JPanel titlePanel = new JPanel();
    titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
    titlePanel.setBackground(new Color (25, 171, 33));
    titlePanel.add(mainTitle);
    titlePanel.add(Box.createRigidArea(new Dimension(0,50)));
    
    //Center Panel
    //About content
    JLabel aboutTitle = new JLabel("About:");
    JLabel aboutPro  = new JLabel("This project was inspired by the national campaign Homes For All that seeks to \"protect,");
    JLabel aboutPro2 = new JLabel("defend, and expand housing that is truly affordable and dignified for low-income and very");
    JLabel aboutPro3 = new JLabel("low-income communities by engaging those most directly impacted by this crisis through local");
    JLabel aboutPro4 = new JLabel("and national organizing, winning strong local policies that protect renters and homeowners,");
    JLabel aboutPro5 = new JLabel("and shifting the national debate on housing.\" Our project is aimed at giving leaders in the");
    JLabel aboutPro6 = new JLabel("movement the opportunity to keep track of information about the houses and apartments in");
    JLabel aboutPro7 = new JLabel("their areas including whether these residences are in danger of eviction.  Users will have the");
    JLabel aboutPro8 = new JLabel("opporunity to save their information and access it in future sessions.");
    
    //font formatting
    aboutTitle.setFont(new Font("Verdana", Font.BOLD, 25));
    aboutPro.setFont(new Font("Verdana", Font.PLAIN, 12));
    aboutPro2.setFont(new Font("Verdana", Font.PLAIN, 12));
    aboutPro3.setFont(new Font("Verdana", Font.PLAIN, 12));
    aboutPro4.setFont(new Font("Verdana", Font.PLAIN, 12));
    aboutPro5.setFont(new Font("Verdana", Font.PLAIN, 12));
    aboutPro6.setFont(new Font("Verdana", Font.PLAIN, 12));
    aboutPro7.setFont(new Font("Verdana", Font.PLAIN, 12));
    aboutPro8.setFont(new Font("Verdana", Font.PLAIN, 12));
    
    //adding and spacing
    JPanel programInfo = new JPanel();
    programInfo.setLayout(new BoxLayout(programInfo, BoxLayout.Y_AXIS));
    programInfo.setBackground(Color.WHITE);
    programInfo.setFont(new Font("Helvetica", Font.BOLD, 18));
    programInfo.add(Box.createRigidArea(new Dimension(0,10)));
    programInfo.add(aboutTitle);
    programInfo.add(Box.createRigidArea(new Dimension(0,10)));
    programInfo.add(aboutPro);
    programInfo.add(aboutPro2);
    programInfo.add(aboutPro3);
    programInfo.add(aboutPro4);
    programInfo.add(aboutPro5);
    programInfo.add(aboutPro6);
    programInfo.add(aboutPro7);
    programInfo.add(aboutPro8);
    programInfo.add(Box.createVerticalGlue());
    
    //Creators info
    //Creator descriptions
    JLabel aboutCreators = new JLabel("About the Creators~");
    JLabel michelle = new JLabel("Michelle Sit");
    JLabel mDescript = new JLabel("Msit's description goes here");
    JLabel kasey = new JLabel("Kasey Shen");
    JLabel kDescript = new JLabel("Kasey's description?"); 
    
    //font formatting
    aboutCreators.setFont(new Font("Verdana", Font.BOLD, 25));
    michelle.setFont(new Font("Verdana", Font.BOLD, 16));
    mDescript.setFont(new Font("Verdana", Font.PLAIN, 12));
    kasey.setFont(new Font("Verdana", Font.BOLD, 16));
    kDescript.setFont(new Font("Verdana", Font.PLAIN, 12));
    
    //adding and spacing
    programInfo.add(aboutCreators);
    programInfo.add(Box.createRigidArea(new Dimension(0,10)));
    programInfo.add(michelle);
    programInfo.add(mDescript);
    programInfo.add(Box.createRigidArea(new Dimension(0,10)));
    programInfo.add(kasey);
    programInfo.add(kDescript);
    programInfo.add(Box.createRigidArea(new Dimension(0,30)));
       
    //Panels used for spacing
    JPanel bottomPanel = new JPanel();
    bottomPanel.setLayout(new GridLayout(0,2));
    bottomPanel.setBackground(new Color (25, 171, 33));
    bottomPanel.setFont(new Font("Helvetica", Font.BOLD, 18));
    bottomPanel.add(Box.createRigidArea(new Dimension(0,100)));
    
    JPanel leftPanel = new JPanel();
    leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
    leftPanel.setBackground(Color.WHITE);
    leftPanel.add(Box.createRigidArea(new Dimension(100,0)));
    
    JPanel rightPanel = new JPanel();
    rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
    rightPanel.setBackground(Color.WHITE);
    rightPanel.add(Box.createRigidArea(new Dimension(100,0)));
    
    this.setLayout(new BorderLayout());
    this.add(titlePanel, BorderLayout.NORTH);
    this.add(programInfo, BorderLayout.CENTER);
    this.add(leftPanel, BorderLayout.WEST);
    this.add(rightPanel, BorderLayout.EAST);
    this.add(bottomPanel, BorderLayout.SOUTH);
    
    
  }
  
  
}