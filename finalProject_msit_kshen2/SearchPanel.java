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
import java.awt.Font.*;

public class SearchPanel extends JPanel implements ItemListener {
  private JLabel mainTitle;
  private JPanel titleMenu, searchMenu, bottomPanel, leftPanel, rightPanel;
//  private final static String 
  
  public SearchPanel() {
    
  }
  
  public SearchPanel(HomesForAll input) {
    
    //North Panel
    JLabel mainTitle = new JLabel("Homes For All");
    mainTitle.setFont(new Font("Verdana", Font.BOLD, 50));
    mainTitle.setForeground(Color.WHITE);
    
    //adding and spacing
    JPanel titleMenu = new JPanel();
    titleMenu.setLayout(new BoxLayout(titleMenu, BoxLayout.Y_AXIS));
    titleMenu.setBackground(new Color (25, 171, 33));
    titleMenu.add(mainTitle);
    titleMenu.add(Box.createRigidArea(new Dimension(0,50)));
    
    JPanel searchMenu = new JPanel();
    searchMenu.setLayout(new BoxLayout(searchMenu, BoxLayout.Y_AXIS));
    searchMenu.setBackground(Color.WHITE);
    
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
    this.add(titleMenu, BorderLayout.NORTH);
    this.add(searchMenu, BorderLayout.CENTER);
    this.add(bottomPanel, BorderLayout.SOUTH);
    this.add(leftPanel, BorderLayout.WEST);
    this.add(rightPanel, BorderLayout.EAST);
    
  }
  
  public void itemStateChanged(ItemEvent evt) {
    
  }
  
}