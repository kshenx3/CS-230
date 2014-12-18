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
  //used for the cardlayout
  private JPanel cards; 
  private final static String HOMEPANEL = "Add Home";
  private final static String APTPANEL = "Add Apartment";
  
  //create colors for easy reference
  private Color oMaroon = new Color(166, 29, 40);
  private Color ourGreen = new Color(26, 151, 34);
  private Color oGrey = new Color(46, 46, 46);
  private Color oGold = new Color(224, 141, 56);

  private JTextField fileName;
  private HomesForAll hfa;
  
  //other instance variables to be used in the panel
  private JLabel resNameInput, mortgageInput, bankNameInput, addressNameInput, inDangerLabel;
  private JTextField resNameH, resNameA, mortgage, rent, llName;
  private JComboBox addressOptions1, addressOptions2, bankOptions;
  private String[] addOpt1, addOpt2, bankOpt;
  private JButton addA, addH, loadFile;
  
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //------------------------------Constructor Methods
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public AddPanel() {
    //bc idk
  }
//  
//  
  public AddPanel(HomesForAll input) {
   input = hfa;
    //Create ComboBox Pane -- start of CardLayout
    JPanel comboBoxPane = new JPanel();
    comboBoxPane.setBackground(oMaroon);
    
    //sets up combobox to decide next pane shown
    String comboBoxItems[] = { HOMEPANEL, APTPANEL }; //array of combo box options
    JComboBox cb = new JComboBox(comboBoxItems);
    cb.setEditable(false);
    cb.addItemListener(this);
    
    fileName = new JTextField("Type file name here to load.");
    loadFile = new JButton("Load File");
    loadFile.addActionListener(new ButtonListener());
    
    comboBoxPane.add(cb);
    comboBoxPane.add(fileName);
    comboBoxPane.add(loadFile);
    
    
    //Initializing instance variables
    resNameA = new JTextField("Resident Name Goes Here", 20);
    resNameH = new JTextField("Resident Name Goes Here", 20);
    mortgage = new JTextField("Enter mortage value", 20);
    rent = new JTextField("Enter rent value", 20);
    addH = new JButton("Add");
    addA = new JButton("Add");
    
    String[] bankStrings = {"Bank of America", "Wells Fargo", "Chase"};
    bankOptions = new JComboBox(bankStrings);
    
    String[] streetNames = {"A", "B", "C", "D"};
    String[] streetVal = {"1", "2", "3", "4"};
    
    addressOptions1 = new JComboBox(streetNames);
    addressOptions2 = new JComboBox(streetVal);
    
    
    //Adding ActionListeners to each
    addH.addActionListener(new ButtonListener());
    addA.addActionListener(new ButtonListener());
    bankOptions.addActionListener(new ComboBoxListener());
    addressOptions1.addActionListener(new ComboBoxListener());
    addressOptions2.addActionListener(new ComboBoxListener());
    
    
    //Create the "cards".
    //card1 is adding the home
    JPanel card1 = new JPanel();
    //card1.setLayout(new BorderLayout());
    card1.setBackground(Color.WHITE);
    card1.setLayout(new BorderLayout());
    
    JPanel centerC1 = new JPanel();
    centerC1.setLayout(new BoxLayout(centerC1, BoxLayout.Y_AXIS));
    centerC1.add(resNameH);
    centerC1.add(mortgage);
    centerC1.add(addH);
    
    card1.add(new JLabel("Add a new Home to Data"), BorderLayout.NORTH);
    card1.add(centerC1, BorderLayout.CENTER);
    

    //card2 is the AddApartment shown
    JPanel card2 = new JPanel();
    card2.setBackground(Color.WHITE);
    
    card2.add(resNameA);
    card2.add(rent);
    card2.add(addA);
    
    
    //Create the panel that contains the "cards" (aka the two panels it flips between)
    cards = new JPanel(new CardLayout());
    cards.add(card1, HOMEPANEL);
    cards.add(card2, APTPANEL);
    
    
    //Create southern panel
    JPanel southernFist = new JPanel();
    southernFist.setBackground(oGold);
    southernFist.add(Box.createRigidArea(new Dimension(0, 25)));
    
    
    //adding everything to the main panel
    this.setLayout(new BorderLayout());
    add(comboBoxPane, BorderLayout.PAGE_START);
    add(cards, BorderLayout.CENTER);
    add(southernFist, BorderLayout.SOUTH);

  }
  
  /**
   * Method called that determines which "card" should be displayed
   * @param evt takes in an ItemEvent to know when combobox choice changed
   */
  public void itemStateChanged(ItemEvent evt) {
    CardLayout cl = (CardLayout)(cards.getLayout());
    cl.show(cards, (String)evt.getItem());
  }
  
  private class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      //first determine whether or not we need to load in a database, creating
      //a HFA from a file or else creating an empty one
      if (event.getSource() == loadFile) {
          String file = fileName.getText();
          HomesForAll temp = new HomesForAll(file);
          hfa = temp;
          loadFile.setText("File loaded");
          //System.out.println("Testng");
          //System.out.println(hfa);      
      } else {  
        HomesForAll temp = new HomesForAll();
        hfa = temp;
      }
      
      //what happens when the other buttons are clicked
      if(event.getSource() == addH) {
        
        
        //System.out.println("MEW1");
      } else if (event.getSource() == addA) {
        
        //System.out.println("MEW2");
      } else {
        
      }
    }
  }
  
  private class ComboBoxListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      
      
      
    }
  }
  
}
