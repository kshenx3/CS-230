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


public class AddPanel extends JPanel implements ItemListener {
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //-------------------------------Instance Variables
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private JPanel cards; 
  
  private final static String HOMEPANEL = "Add Home";
  private final static String APTPANEL = "Add Apartment";
  
  

  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //------------------------------Constructor Methods
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public AddPanel() {
    //bc idk
  }
  
  
  public AddPanel(HomesForAll input) {
    
    JPanel comboBoxPane = new JPanel(); //use FlowLayout
    String comboBoxItems[] = { HOMEPANEL, APTPANEL };
    JComboBox cb = new JComboBox(comboBoxItems);
    cb.setEditable(false);
    cb.addItemListener(this);
    comboBoxPane.add(cb);
    
    //Create the "cards".
    JPanel card1 = new JPanel();
    card1.add(new JButton("Button 1"));
    card1.add(new JButton("Button 2"));
    card1.add(new JButton("Button 3"));
    
    JPanel card2 = new JPanel();
    card2.add(new JTextField("TextField", 20));
    
    //Create the panel that contains the "cards".
    cards = new JPanel(new CardLayout());
    cards.add(card1, HOMEPANEL);
    cards.add(card2, APTPANEL);
    
    
    add(comboBoxPane, BorderLayout.PAGE_START);
    add(cards, BorderLayout.CENTER);
    
  }
  
  
  
  public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }

  
}
