/*
 * CS 230 - Final Project
 * HomesForAllGUI.java
 * 
 * Michelle Sit & Kasey Shen
 * 
 * PURPOSE:
 * 
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.*;

public class HomesForAllGUI extends HomesForAll {
  
  public static void main (String[] args) {
    //create an instance of HomesForAll
    HomesForAll hfa = new HomesForAll();
    
    // creates and shows a Frame 
    JFrame frame = new JFrame("HomesForAll");
    frame.setPreferredSize(new Dimension(800,800));
    frame.setResizable(false);
//    frame.setFont(new Font("Helvetica", Font.BOLD, 24));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // adds 3 tabs for panels
    JTabbedPane tp = new JTabbedPane(); 
    tp.addTab("About", new AboutPanel(hfa));
    tp.addTab("Add", new AddPanel(hfa));
    tp.addTab("Search", new SearchPanel(hfa));
    tp.addTab("Map", new VisualPanel(hfa));
    
    
    frame.getContentPane().add(tp);
 
    frame.pack();
    frame.setVisible(true);
    
  }
  
}