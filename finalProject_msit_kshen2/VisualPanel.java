/*
 * CS 230 - Final Project
 * VisualPanel.java
 * 
 * Michelle Sit & Kasey Shen
 * 
 * PURPOSE: Creates the tabbed pane that provides a visual
 * representation of our virtual world of homes and apartments.
 * Dialog boxes pop up with information regarding the residence
 * at the specific coordinate in the grid. 
 * 
 */

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.*;
import javax.swing.JOptionPane;

public class VisualPanel extends JPanel //implements ItemListener 
{
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //-------------------------------Instance Variables
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private JButton[][] grid;
  private Residence[][] info;
  private JLabel title;
  
  private HomesForAll hfa;
  
  private Color oMaroon = new Color(166, 29, 40);
  private Color ourGreen = new Color(26, 151, 34);
  private Color oGrey = new Color(46, 46, 46);
  private Color oGold = new Color(224, 141, 56);
  
  private final int DEFAULT = 4; //max size of our grid, kept small for basic functionality
  
  private ImageIcon redH, greenH, empty;
  
  
  private JTextField fileName;
  private JButton loadFile, instructButton;

  
  public VisualPanel() {
  }

  public VisualPanel(HomesForAll input) {
    this.hfa = input;
    
    grid = new JButton[DEFAULT][DEFAULT]; //CHANGE VALUE/SIZE OF 2D ARRAY HERE
    
    redH = new ImageIcon("red house.png");
    greenH = new ImageIcon("green house.png");
    empty = new ImageIcon("empty.png");
     
    fileName = new JTextField("Type file name here to load.");
    loadFile = new JButton("Load File");
    loadFile.addActionListener(new ButtonListener());
    
    instructButton = new JButton("Instructions");
    
    
    //creating map in grid representation
    JPanel center = new JPanel();
    center.setLayout(new GridLayout(4, 4, 5, 5));
    center.setBackground(oGrey);
    
    info = new Residence[DEFAULT][DEFAULT];
    //info = hfa.getAddresses();
    
    for (int i=0; i<DEFAULT; i++) {
      for (int j=0; j<DEFAULT; j++) {
        JButton mew = new JButton(" ");
        //mew.setPreferredSize(new Dimension(15,15));
        
        //at creation of button, we can also go through maybe the 2d array storing places
        //check if null, (true: then skip, move on), (false: isInDanger? true: set this icon; false
        // set some other icon)
     
        grid[i][j] = mew;

        
        if(info[i][j] != null) {
          if(info[i][j].getIsInDanger()) {
            mew.setIcon(redH);
          } else {
            mew.setIcon(greenH);
          }
        } else {
          //System.out.println("Reached null point for info"); /*Testing purposes*/
        }
        
        // add each Button to the Panel
        center.add(grid[i][j]);
        grid[i][j].addActionListener(new ButtonListener());
      }
    }
    
    
    JPanel southernFIST = new JPanel();
    southernFIST.add(Box.createRigidArea(new Dimension(15,25)));
    southernFIST.setBackground(oGold);
    
    
    JPanel northernWind = new JPanel();
    northernWind.setBackground(oMaroon);
    northernWind.setLayout(new BorderLayout());
    
    title = new JLabel("Visual Representation of Your Data");
    title.setForeground(Color.WHITE);
    title.setFont(new Font("Verdana", Font.PLAIN, 30));
    
    
    
    JPanel inceptionNorth = new JPanel();
    inceptionNorth.add(fileName);
    inceptionNorth.add(loadFile);
    inceptionNorth.setBackground(oMaroon);
    
    JPanel centerCeption = new JPanel();
    //centerCeption.setLayout(new BorderLayout());
    centerCeption.setBackground(oGrey);
    centerCeption.add(title);
    centerCeption.add(instructButton);
    instructButton.addActionListener(new ButtonListener());
   
    
    northernWind.add(inceptionNorth, BorderLayout.NORTH);
    northernWind.add(centerCeption, BorderLayout.CENTER);
    
    
    //western panel for filling
    JPanel westernHats = new JPanel();
    westernHats.setBackground(oGrey);
    westernHats.add(Box.createRigidArea(new Dimension(100,0)));
    //eastern panel for filling
    JPanel easternFood = new JPanel();
    easternFood.setBackground(oGrey);
    easternFood.add(Box.createRigidArea(new Dimension(100,0)));
    
    setLayout(new BorderLayout());
    add(northernWind, BorderLayout.NORTH);
    add(center, BorderLayout.CENTER);
    add(southernFIST, BorderLayout.SOUTH);
    add(westernHats, BorderLayout.WEST);
    add(easternFood, BorderLayout.EAST);
  }
  

  /**
   * Private class ButtonListener to update panel once actions heard
   * 
   */
  private class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      if (event.getSource() == loadFile) {
        String file = fileName.getText();
        HomesForAll temp = new HomesForAll(file);
        hfa = temp;
        loadFile.setText("File loaded");
        //System.out.println("Testng");
        //System.out.println(hfa);      
        
        info = hfa.getAddresses();
        
        for (int i=0; i<DEFAULT; i++) {
          for (int j=0; j<DEFAULT; j++) {
            if(info[i][j] != null) {
              if(info[i][j].getIsInDanger()) {
                grid[i][j].setIcon(redH);
              } else {
                grid[i][j].setIcon(greenH);
              }
            } else {
              //System.out.println("Reached null point for info"); /*Testing purpose*/
            }
          }
        }
      } 
 
      //use try-catch lets us deal with nulls in info[][]
      try {
        //check to see if any of the 16 buttons was pressed
        for (int i=0; i<DEFAULT; i++) {
          for (int j=0; j<DEFAULT; j++) {
            if (event.getSource() == grid[i][j]) { //if so, then display dialog box
              Residence sub = info[i][j];
              String popUpTitle = sub.getResident() + " @ " + sub.getAddress();
              
              JOptionPane.showMessageDialog(null, //unique message dialog box construction
                                            info[i][j], 
                                            popUpTitle,
                                            JOptionPane.PLAIN_MESSAGE);
            }
          }  
        }//closes outer for loop
      } catch (NullPointerException e) { //catch the NullPointer when no residence exists
        //shows appropriate message to user
        JOptionPane.showMessageDialog(null, "No residence exists here!");
      }
      
      if(event.getSource() == instructButton) {
        JOptionPane.showMessageDialog(null, "\nTo see a visual representation of your data world"
                                      +"\nfirst load file. Then, the buttons below will update."
                                      + "\nA red residence symbolizes the residence being in danger"
                                      +"\nwhile a green residence means its status is okay. Click"
                                      + "\n the button for more information.");
      }
      
    }
  }
}
