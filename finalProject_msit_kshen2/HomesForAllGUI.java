/*
 * CS 230 - Final Project
 * HomesForAllGUI.java
 * 
 * Michelle Sit & Kasey Shen
 * 
 * PURPOSE: Is the main driver for our GUI application. Creates the tabbed
 * panes.
 * 
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.*;

public class HomesForAllGUI extends HomesForAll {
  
  public static void main (String[] args) {
    //create an instance of HomesForAll
    HomesForAll hfa = new HomesForAll();
    
    // creates and shows a Frame 
    JFrame frame = new JFrame("HomesForAll");
    frame.setPreferredSize(new Dimension(800,775));
    frame.setResizable(false); //set fixed dimensions
    //frame.getContentPane().setFont(new Font("Helvetica", Font.BOLD, 24));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // adds 4 tabs for panels
    JTabbedPane tp = new JTabbedPane(); 

    AddPanel addp = new AddPanel(hfa);
    SearchPanel sp = new SearchPanel(hfa);
    VisualPanel vp = new VisualPanel(hfa);
    
    tp.addTab("About", new AboutPanel());
    tp.addTab("Add", addp);    
    tp.addTab("Search", sp);
    tp.addTab("Map", vp);
    
    
    //the new Color created is the green we had... wasn't sure which you had...
    frame.getContentPane().setBackground(new Color(26, 151, 34));
    frame.getContentPane().add(tp);
 
    frame.pack();
    frame.setVisible(true);
    
  }
  
}
