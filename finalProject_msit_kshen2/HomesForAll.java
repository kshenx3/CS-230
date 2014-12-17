/*
 * CS 230 - Final Project
 * HomesForAll.java
 * 
 * Michelle Sit & Kasey Shen
 * 
 * PURPOSE:
 * 
 */

/* THINGS TO DO:
 * - javadoc X__X
 * 
 */

import java.util.*;
import java.io.*;

public class HomesForAll {
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //-------------------------------Instance Variables
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private File output;
  private int count;
  
  //MSit: Example linkedlist categories.  Used for testing purposes only
  //LinkedLists
  private LinkedList<Residence> database, homes, apts, boA, wellsFargo, chaseBank, lordEmurry, lordKasey,
    streetA, streetB, streetC, streetD, inDanger, notDanger;
  
  //Sorting hashtables
  private Hashtable<Boolean, LinkedList> dangerSort; //sorts by isInDanger
  private Hashtable<String, LinkedList> lOrBSort; //sorts by landlord or bank
  private Hashtable<String, LinkedList> residentSort; //sorts by resident
  private Hashtable<String, LinkedList> addressSort;  //sorts by String address
  private Hashtable<Integer, LinkedList> rentSort; //sorts by mortgage or rent
  
  //Kasey's testing LL and HT
  private LinkedList searchRes;
  private Hashtable<String, LinkedList> sortingHat; /*kekeke*/ 
  
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //------------------------------Constructor Methods
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  
  /**
   * Creates an instance of HomesForAll class when there is no input database to refer to.
   * Will create a new database from scratch. 
   */ 
  public HomesForAll() {
    count = 0;
  
    //initializing sorting hashtables
    this.dangerSort = new Hashtable<Boolean, LinkedList>();
    this.lOrBSort = new Hashtable<String, LinkedList>();
    this.residentSort = new Hashtable<String, LinkedList>();
    this.addressSort = new Hashtable<String, LinkedList>();
    this.rentSort = new Hashtable<Integer, LinkedList>();
    
    //initalizing all  LLs
    //MasterLL
    this.database = new LinkedList<Residence>();
    //Residence types
    this.homes = new LinkedList<Residence>();
    this.apts = new LinkedList<Residence>();
    //Landlords and Banks
    this.boA = new LinkedList<Residence>();
    this.wellsFargo = new LinkedList<Residence>();
    this.chaseBank = new LinkedList<Residence>();
    this.lordEmurry = new LinkedList<Residence>();
    this.lordKasey = new LinkedList<Residence>();
    //streets for addresses
    this.streetA = new LinkedList<Residence>();
    this.streetB = new LinkedList<Residence>();
    this.streetC = new LinkedList<Residence>();
    this.streetD = new LinkedList<Residence>();
    //inDanger or not
    this.inDanger = new LinkedList<Residence>();
    this.notDanger = new LinkedList<Residence>();
    
    //Kasey's testers
    this.sortingHat = new Hashtable<String, LinkedList>();
    this.database = new LinkedList();
  }
  
  
  /**
   * Creates a HomesForAll object with an input file that acts as the loaded database reference.
   * 
   * @param fileName Name of the database reference as a String
   */
  public HomesForAll(String fileName) {
    database = new LinkedList();
    
    try {
      Scanner scan = new Scanner(new File(fileName));
      
      while (scan.hasNext()) {
        Residence res = new Residence(); //create empty Residence
        
        res.setResident(scan.nextLine());
        res.setResType(scan.nextLine());
        res.setBOrL(scan.nextLine());
        
        //need to convert nextLine Strings into Integers for the amt, xCoor, and yCoor
        int a = Integer.parseInt(scan.nextLine());
        res.setAmt(a);
        int x = Integer.parseInt(scan.nextLine());
        res.setXCoor(x);
        int y = Integer.parseInt(scan.nextLine());
        res.setYCoor(y);
        
        res.setAddress(scan.nextLine());
        
        //convert nextLine() String to boolean for isInDanger
        boolean input = Boolean.parseBoolean(scan.nextLine());
        res.setIsInDanger(input);
        database.push(res);
        
        //System.out.println("New Residence!: \n" + res); /* for debugging purposes */
      }
      scan.close(); 
      
    } catch (FileNotFoundException error) {
      System.out.println("File not found. Constructor failed. Error: " + error + "\n"); 
    } catch (NoSuchElementException e) { //catches the case when the latter portion of data is missing
      System.out.println("File is missing a line somewhere in data. Constructor failed. Info creation stopped. \nError: " + e + "\n");
    } catch (NumberFormatException mew) { //catches the case where a line is missing somewhere in the middle
      System.out.println("File is not formatted correctly; missing line somewhere. Info creation stopped.\nError: " + mew + "\n");
    }
  }
  

  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //---------------------------------Instance Methods
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  
  public void saveSearchRes(String newFileName) {
    try {
   PrintWriter writer = new PrintWriter(new File(newFileName));
   //need to go through the searchRes LinkedList and print out each...
   //LinkedLIst needs to be type... fuck. needs to be type Apt or Home... 
   //maybe we actually do need a parent/child relationship...
   writer.println("");
   
   writer.close();
  } catch (IOException ex) {
   System.out.println("***(T)ERROR*** The file couldn't be written: " + ex);
  }
  }
  
  
  
  /**
   * Returns a String representation of the HomesForAll class.
   * 
   * @return Returns HomesForAll.
   */
  public String toString() {
    String s = "";
    s += "Current size of database: (3) " + database.size() + "\n";
    s += "First item from popping: \n" + database.pop() + "\nYayyy :D";
    s += "\nNow go through rest of thingy\n\n";
    while (database.size() > 0) {
      s += "Size: " + database.size() + "\n" + database.pop() + "\n";
      
    }
    return s;
  }
  
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //--------------------------------------Main Method
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static void main (String[] args) {
    HomesForAll test = new HomesForAll();
    
    test.sortingHat.put("Meow", test.database);
    test.database.push("Meow");
    test.database.push("Argh");
    test.sortingHat.put("Argh", test.database);
    
    System.out.println(test.sortingHat.get("Meow"));
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    
    System.out.println("Testing the second constructor method");
    HomesForAll test2 = new HomesForAll("testing.txt");
    System.out.println(test2);
    
    //what this tells me is... 
    /* i need to individually go through the entire list and check for the characteristic
     * add that to the linked list
     * the hashtable only allows for quick searching & returning the linked list, 
     * does not actually sort the items into the linked list...
     * 
     * so each find____ method should first call upon a helper method that 
     * both initializes and then sorts the database items into linkedlists that 
     * the hash table then will sort into
     * then at the end, the find____ method will return the value of the key input... 
     * the "search"
     * 
     */
    
    //also need to find a way to distinguish between Homes & Apartments when going through a list of them
    //** my soln: create a method in both classes that return a String "type" that is final
    //** so that we can check if .equals? 
    //** OR 
    //** we can assign a final integer that is symbolic of either home or apartment
    
  }
}
