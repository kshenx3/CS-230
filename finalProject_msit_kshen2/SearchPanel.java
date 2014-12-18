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
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //-------------------------------Instance Variables
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //used for the cardlayout
  private JPanel cards; 
  private final static String BANKLORD = "Bank or Landlord";
  private final static String TYPE = "Apartment or Home";
  private final static String ADDRESS = "Street";
  private final static String DANGER = "In Danger of Eviction";
  
  //create colors for easy reference
  private Color oMaroon = new Color(166, 29, 40);
  private Color ourGreen = new Color(26, 151, 34);
  private Color oGrey = new Color(46, 46, 46);
  private Color oGold = new Color(224, 141, 56);
  
  private HomesForAll hfa;
  
  //other instance variables to be used in the panel
  private JButton searchButton1, searchButton2, searchButton3, searchButton4, loadFile;
  private int listLen;
  private String sysOutPrint;
  private JLabel theList, statusLabel;
  private String[] box;
  private HomesForAll outputList;
  private JTextField fileName;
  private JComboBox bankBox, typeBox, addressBox, dangerBox;
  
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //------------------------------Constructor Methods
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public SearchPanel() {
    //bc idk
  }
  
  
  public SearchPanel(HomesForAll input) {
    hfa = input;
    //Create ComboBox Pane -- start of CardLayout
    //First tab
    JPanel comboBoxPane = new JPanel();
    comboBoxPane.setBackground(oMaroon);
    listLen = 0;
    theList = new JLabel(sysOutPrint);
    statusLabel = new JLabel("");
    
    //sets up combobox to decide next pane shown
    String comboBoxItems[] = { BANKLORD, TYPE, ADDRESS, DANGER }; //array of combo box options
    JComboBox cb = new JComboBox(comboBoxItems);
    cb.setEditable(false);
    cb.addItemListener(this);
    
    fileName = new JTextField("Type file name here to load.");
    loadFile = new JButton("Load File");
    loadFile.addActionListener(new ButtonListener());
    
    comboBoxPane.add(fileName);
    comboBoxPane.add(loadFile);
    comboBoxPane.add(cb);
    
    //BANKLORD card
    String[] banklordItems = {"Bank of America", "Wells Fargo", "Chase Bank", "Lord Emurry", "Lord Kasey"};
    JComboBox bankBox = new JComboBox(banklordItems);
    //bankBox.addItem("Bank of America");
    bankBox.setEditable(false);
//    bankBox.addItemListener(this);
    bankBox.addActionListener(new ComboBoxListener());
    
    //TYPE card
    String[] typeItems = {"House", "Apartment"};
    JComboBox typeBox = new JComboBox(typeItems);
    typeBox.setEditable(false);
    typeBox.addItemListener(this);
    typeBox.addActionListener(new ComboBoxListener());
    
    //DANGER card
    String[] dangerItems = {"In Danger", "Not in Danger"};
    JComboBox dangerBox = new JComboBox(dangerItems);
    dangerBox.setEditable(false);
    dangerBox.addItemListener(this);
    dangerBox.addActionListener(new ComboBoxListener());
    
    //ADDRESS card
    String[] addressItems = {"Street A", "Street B", "Street C", "Street D"};
    JComboBox addressBox = new JComboBox(addressItems);
    addressBox.setEditable(false);
    addressBox.addItemListener(this);
    addressBox.addActionListener(new ComboBoxListener());
    
    //Search button
    searchButton1 = new JButton ("Search");
    searchButton1.addActionListener(new ButtonListener());
    searchButton2 = new JButton ("Search");
    searchButton2.addActionListener(new ButtonListener());
    searchButton3 = new JButton ("Search");
    searchButton3.addActionListener(new ButtonListener());
    searchButton4 = new JButton ("Search");
    searchButton4.addActionListener(new ButtonListener());
    
    box = new String[1]; // array of strings of school info input
    listLen = 0;
    outputList = input;
    sysOutPrint = hfa.toString();
    theList = new JLabel(sysOutPrint);
    add(theList);
    
    //Create the "cards".
    //card1 is adding the home
    JPanel card1 = new JPanel();
    card1.setBackground(Color.WHITE);
    card1.add(bankBox);
    card1.add(searchButton1);    
    
    //card2 is the AddApartment shown
    JPanel card2 = new JPanel();
    card2.setBackground(Color.WHITE);
    card2.add(typeBox);
    card2.add(searchButton2);
    
    //card3
    JPanel card3 = new JPanel();
    card3.setBackground(Color.WHITE);
    card3.add(addressBox);
    card3.add(searchButton3);
    
    //card 4
    JPanel card4 = new JPanel();
    card4.setBackground(Color.WHITE);
    card4.add(dangerBox);
    card4.add(searchButton4);
    
    //Create the panel that contains the "cards" (aka the two panels it flips between)
    cards = new JPanel(new CardLayout());
    cards.add(card1, BANKLORD);
    cards.add(card2, TYPE);
    cards.add(card3, ADDRESS);
    cards.add(card4, DANGER);
    
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
      if (event.getSource() == searchButton1) {
        bankBox.getSelectedItem();
        if (bankBox.getSelectedItem() == "Bank of America") {
          outputList.findBanks("boA");
        } if (bankBox.getSelectedItem() == "Wells Fargo") {
          outputList.findBanks("wellsFargo");
        } if (bankBox.getSelectedItem() == "Chase Bank") {
          outputList.findBanks("chaseBank"); 
        } if (bankBox.getSelectedItem() == "Lord Emurry") {
          outputList.findBanks("lordEmurry"); 
        } else if (bankBox.getSelectedItem() == "Lord Kasey") {
          outputList.findBanks("lordKasey"); 
        }
      }
      if (event.getSource() == searchButton2) {
        typeBox.getSelectedItem();
        if (typeBox.getSelectedItem() == "House") {
         outputList.findType("home"); 
        } else if (typeBox.getSelectedItem() == "Apartment") {
         outputList.findType("apt"); 
        }
      }
      if (event.getSource() == searchButton3) {
        addressBox.getSelectedItem();
        if (addressBox.getSelectedItem() == "Street A") {
         outputList.findAddress("streetA"); 
        }if (addressBox.getSelectedItem() == "Street B") {
         outputList.findAddress("streetB"); 
        }
        if (addressBox.getSelectedItem() == "Street C") {
         outputList.findAddress("streetC"); 
        }
        else if (addressBox.getSelectedItem() == "Street D") {
         outputList.findAddress("streetD"); 
        }
      }
      else if (event.getSource() == searchButton4) {
       dangerBox.getSelectedItem();
       if (dangerBox.getSelectedItem() == "In Danger") {
        outputList.findDanger("inDanger"); 
       } else if (dangerBox.getSelectedItem() == "Not in Danger") {
        outputList.findDanger("notDanger"); 
       }
      }
        
       
      
    }
    
  }
  //sysOutPrint = hfa.toString();
  //      for(int x=0; x<(listLen-1); x++) sysOutPrint += schoolInfo[x];
  //     theList.setText(myGSList.toString()); //actually updates JLabel with string list
  // bankBox.getSelectedItem();
  //    String file =  
//      if(event.getSource() == searchButton2) {
//        System.out.println(outputList.findType("home"));
//      }
  
//      //first determine whether or not we need to load in a database, creating
//      //a HFA from a file or else creating an empty one
//      if (event.getSource() == loadFile) {
//          String file = fileName.getText();
//          hfa = new HomesForAll(file);
//          loadFile.setText("File loaded");
//          //System.out.println("Testng");
//          //System.out.println(hfa);      
//      } else {  
//        hfa = new HomesForAll();
//      }
//      
//      //what happens when the other buttons are clicked
//      if(event.getSource() == addH) {
//        
//        
//        //System.out.println("MEW1");
//      } else if (event.getSource() == addA) {
//        
//        //System.out.println("MEW2");
//      } else {
//        
  
  
  private class ComboBoxListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
//      String s = (String) cb.getSelectedItem();
//      switch(s) {
//        case "Bank of America":
//          System.out.println("HI");
//      }
      
//      if (event.getStateChanged() == ItemEvent.SELECTED) {
//        System.out.println("Changed!");
//      }
      
      
    }
  }
  
  
  
}
