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
  private JLabel instructions, title;
  
  private HomesForAll hfa;
  
  private Color oMaroon = new Color(166, 29, 40);
  private Color ourGreen = new Color(26, 151, 34);
  private Color oGrey = new Color(46, 46, 46);
  private Color oGold = new Color(224, 141, 56);
  
  private final int DEFAULT = 4; //max size of our grid, kept small for basic functionality
  
  private ImageIcon redH, greenH, empty;
  
  
  private JTextField fileName;
  private JButton loadFile;
  
  private LinkedList dataCopy;
  
  public VisualPanel() {
  }

  public VisualPanel(HomesForAll input) {
    this.hfa = input;
    
    grid = new JButton[DEFAULT][DEFAULT]; //CHANGE VALUE/SIZE OF 2D ARRAY HERE
    
    redH = new ImageIcon("red house.png");
    greenH = new ImageIcon("green house.png");
    empty = new ImageIcon("empty.png");
    
    /* TEMP */
    fileName = new JTextField("Type file name here to load.");
    loadFile = new JButton("Load File");
    loadFile.addActionListener(new ButtonListener());
    
    
    
    //creating map in grid representation
    JPanel center = new JPanel();
    center.setLayout(new GridLayout(4, 4, 5, 5));
    center.setBackground(oGrey);
    
    info = new Residence[DEFAULT][DEFAULT];
    //info = hfa.getAddresses();
    
    for (int i=0; i<DEFAULT; i++) {
      for (int j=0; j<DEFAULT; j++) {
        JButton mew = new JButton(" ");
        mew.setPreferredSize(new Dimension(15,15));
        
        //at creation of button, we can also go through maybe the 2d array storing places
        //check if null, (true: then skip, move on), (false: isInDanger? true: set this icon; false
        // set some other icon)
        

//        for(int i = 0; i<DEFAULT; i++) {
//          for(int j = 0; i<DEFAULT; j++) {
       //     JButton mew = grid[i][j];
//            
//            if(info[i][j] != null) {
//              if(info[i][j].getIsInDanger()) {
//                mew.setIcon(redH);
//            } else {
//              mew.setIcon(greenH);
//            }
//          } else {
//            mew.setIcon(empty);
        
        
        
        
        
        grid[i][j] = mew;
        grid[i][j].addActionListener(new ButtonListener());     
        
        // add each Button to the Panel
        center.add(grid[i][j]);
      }
    }
    
    
    JPanel southernFIST = new JPanel();
    southernFIST.add(Box.createRigidArea(new Dimension(15,25)));
    southernFIST.setBackground(oGold);
    
    
    JPanel northernWind = new JPanel();
    northernWind.setBackground(oMaroon);
    northernWind.setLayout(new BoxLayout(northernWind, BoxLayout.Y_AXIS));
    
    title = new JLabel("VISUAL!!!! (aka RO <3)");
    title.setForeground(Color.WHITE);
    title.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
    
    instructions = new JLabel("Lovely shits go here");
    instructions.setForeground(Color.WHITE);
    
    northernWind.add(fileName);
    northernWind.add(loadFile);
    northernWind.add(title);
    northernWind.add(instructions);
    
    northernWind.add(Box.createRigidArea(new Dimension(0, 50)));
    northernWind.add(Box.createRigidArea(new Dimension(75, 0)));
    
    //northernWind.setLayout(new BorderLayout());
    //northernWind.add(instructions, BorderLayout.CENTER);
    //northernWind.add(title, BorderLayout.NORTH);
    
    JPanel westernHats = new JPanel();
    westernHats.setBackground(oGrey);
    westernHats.add(Box.createRigidArea(new Dimension(25,0)));
    
    JPanel easternFood = new JPanel();
    easternFood.setBackground(oGrey);
    easternFood.add(Box.createRigidArea(new Dimension(25,0)));
    
    setLayout(new BorderLayout());
    add(northernWind, BorderLayout.NORTH);
    add(center, BorderLayout.CENTER);
    add(southernFIST, BorderLayout.SOUTH);
    add(westernHats, BorderLayout.WEST);
    add(easternFood, BorderLayout.EAST);
  }
  
  
  //Instance Methods
  
  private class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      //info = hfa.getAddresses();
      
      
//      for(int i = 0; i<DEFAULT; i++) {
//        for(int j = 0; i<DEFAULT; j++) {
//          JButton mew = grid[i][j];
//          
//          if(info[i][j] != null) {
//            if(info[i][j].getIsInDanger()) {
//              mew.setIcon(redH);
//            } else {
//              mew.setIcon(greenH);
//            }
//          } else {
//            mew.setIcon(empty);
//          }
//        }
//      }
      
      //check to see if any of the 9 buttons was pressed
      for (int i=0; i<DEFAULT; i++) {
        for (int j=0; j<DEFAULT; j++) {
          if (event.getSource() == grid[i][j]) { //if button pressed among the 16,
            //if (grid[i][j].getIcon().equals(/*icon source goes here*/)) {
            //    JOptionPane.showMessageDialog("No residence exists here!");
            
            
            //JOptionPane.showMessageDialog
            Residence test = new Residence();
            String popUpTitle = test.getResident() + " @ " + test.getAddress();
            
            JOptionPane.showMessageDialog(null,
                                          test, //once we connect functions, this should be grid[i][j]
                                          //or whatever array name we title that stores the residences
                                          //so like, hfa.getResidentAtAddress(i,j); --> returns address[i][j]
                                          //or something like that
                                          //what this means is that we will need a 2D array instance var
                                          //in HFA.java b/c it will store the locations of the places...
                                          popUpTitle,
                                          JOptionPane.PLAIN_MESSAGE);

//            //a button was pressed
//            if (game.getIsXTurn()) {  //x's turn
//              buttons[i][j].setText("X");
//              
//              statusLabel.setText("O's turn now");
//              statusLabel.setIcon(oImg);
//            }
//            else { //o's turn
//              buttons[i][j].setText("O"); //play O
//              statusLabel.setText("X's turn now");
//              statusLabel.setIcon(xImg);
//            }
           
          }
        }  
      }//closes outer for loop
      
    }
  }
}
