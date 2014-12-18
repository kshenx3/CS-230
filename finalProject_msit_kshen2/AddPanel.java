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
  private JLabel resNameInput1, resNameInput2, mortgageLabel, bankNameInput, addressNameInput, coorInput, inDangerLabel, landlordInput, rentLabel, addressNameInputA, coorInputA, inDangerLabelA;
  private JTextField resNameH, resNameA, mortgage, rent;
  private JComboBox addressName, addressOptions1, addressOptions2, addressNameA, addressOptions1A, addressOptions2A, bankOptions, llName, dangerOpt, dangerOptA;
  private String[] streetNamesRL, streetNames, streetVal, streetNamesRLA, streetNamesA, streetValA, bankStrings, landlords, dangYN, dangYNA;
  private JButton addA, addH, loadFile;
  
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //------------------------------Constructor Methods
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public AddPanel() {
  }
//  
  public AddPanel(HomesForAll input) {
   hfa = input;
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
    
    
    resNameInput1 = new JLabel("Resident: ");
    resNameInput2 = new JLabel("Resident: ");
    mortgageLabel = new JLabel("Mortgage Value: ");
    bankNameInput = new JLabel("Bank: ");
    addressNameInput = new JLabel("Address: ");
    addressNameInputA = new JLabel("Address: ");
    coorInput = new JLabel("Coordinates: ");
    inDangerLabel = new JLabel("Status: ");
    coorInputA = new JLabel("Coordinates: ");
    inDangerLabelA = new JLabel("Status: ");
    rentLabel = new JLabel("Rent Value: ");
    landlordInput = new JLabel("Landlord: ");
    
    bankStrings = new String[]{"Bank of America", "Wells Fargo", "Chase"};
    bankOptions = new JComboBox(bankStrings);
    
    landlords = new String[]{"lordEmurry", "lordKasey"};
    llName = new JComboBox(landlords);
    
    streetNamesRL = new String[]{"streetA", "streetB", "streetC", "streetD"};
    addressName = new JComboBox(streetNamesRL);
    streetNamesRLA = new String[]{"streetA", "streetB", "streetC", "streetD"};
    addressNameA = new JComboBox(streetNamesRL);
    
    streetNames = new String[]{"A", "B", "C", "D"};
    streetVal = new String[]{"1", "2", "3", "4"}; 
    addressOptions1 = new JComboBox(streetNames);
    addressOptions2 = new JComboBox(streetVal);
    
    streetNamesA = new String[]{"A", "B", "C", "D"};
    streetValA = new String[]{"1", "2", "3", "4"}; 
    addressOptions1A = new JComboBox(streetNames);
    addressOptions2A = new JComboBox(streetVal);
    
    dangYN = new String[]{"In Danger", "Not in Danger"};
    dangerOpt = new JComboBox(dangYN);
    dangYNA = new String[]{"In Danger", "Not in Danger"};
    dangerOptA = new JComboBox(dangYN);
    
    
    
    //Create the "cards".
    //card1 is adding the home
    JPanel card1 = new JPanel();
    //card1.setLayout(new BorderLayout());
    card1.setBackground(Color.WHITE);
    
    JPanel centerC1 = new JPanel();
    centerC1.setBackground(Color.WHITE);
    centerC1.setLayout(new GridLayout(0,3));
    centerC1.add(resNameInput1);
    centerC1.add(resNameH);
    centerC1.add(Box.createRigidArea(new Dimension(0,5)));
    centerC1.add(bankNameInput);
    centerC1.add(bankOptions);
    centerC1.add(Box.createRigidArea(new Dimension(0,5)));
    centerC1.add(mortgageLabel);
    centerC1.add(mortgage);
    centerC1.add(Box.createRigidArea(new Dimension(0,5)));
    centerC1.add(addressNameInput);
    centerC1.add(addressName);
    centerC1.add(Box.createRigidArea(new Dimension(0,5)));
    centerC1.add(coorInput);
    centerC1.add(addressOptions1);
    centerC1.add(addressOptions2);
    centerC1.add(inDangerLabel);
    centerC1.add(dangerOpt);
    centerC1.add(Box.createRigidArea(new Dimension(0,5)));
       
    card1.add(new JLabel("Add a new Home to Data"), BorderLayout.NORTH);
    card1.add(centerC1, BorderLayout.CENTER);
    card1.add(addH, BorderLayout.SOUTH);
    

    //card2 is the AddApartment shown
    JPanel card2 = new JPanel();
    card2.setBackground(Color.WHITE);
    
    JPanel centerC2 = new JPanel();
    centerC2.setBackground(Color.WHITE);
    centerC2.setLayout(new GridLayout(0,3));
    centerC2.add(resNameInput2);
    centerC2.add(resNameA);
    centerC2.add(Box.createRigidArea(new Dimension(0,5)));
    centerC2.add(landlordInput);
    centerC2.add(llName);
    centerC2.add(Box.createRigidArea(new Dimension(0,5)));
    centerC2.add(rentLabel);
    centerC2.add(rent);
    centerC2.add(Box.createRigidArea(new Dimension(0,5)));
    centerC2.add(addressNameInputA);
    centerC2.add(addressNameA);
    centerC2.add(Box.createRigidArea(new Dimension(0,5)));
    centerC2.add(coorInputA);
    centerC2.add(addressOptions1A);
    centerC2.add(addressOptions2A);
    centerC2.add(inDangerLabelA);
    centerC2.add(dangerOptA);
    centerC2.add(Box.createRigidArea(new Dimension(0,5)));
       
    card2.add(new JLabel("Add a new Apartment to Data"), BorderLayout.NORTH);
    card2.add(centerC2, BorderLayout.CENTER);
    card2.add(addA, BorderLayout.SOUTH);
    
    
    
    //Adding ActionListeners to all
    addH.addActionListener(new ButtonListener()); //buttons
    addA.addActionListener(new ButtonListener());
    
    resNameA.addActionListener(new ButtonListener()); //text fields
    resNameH.addActionListener(new ButtonListener());
    mortgage.addActionListener(new ButtonListener());
    rent.addActionListener(new ButtonListener());
    
    bankOptions.addActionListener(new ComboBoxListener()); //comboboxes
    addressName.addActionListener(new ComboBoxListener());
    addressOptions1.addActionListener(new ComboBoxListener());
    addressOptions2.addActionListener(new ComboBoxListener());
    llName.addActionListener(new ComboBoxListener());
    dangerOpt.addActionListener(new ComboBoxListener());
    
    addressNameA.addActionListener(new ComboBoxListener());
    addressOptions1A.addActionListener(new ComboBoxListener());
    addressOptions2A.addActionListener(new ComboBoxListener());
    dangerOptA.addActionListener(new ComboBoxListener());
     
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
  
  /**
   * Private class ButtonListener 
   * 
   */
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
