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
  
  //LinkedLists
  private LinkedList<Residence> database, homes, apts, boA, wellsFargo, chaseBank, lordEmurry, lordKasey,
    streetA, streetB, streetC, streetD, inDanger, notDanger;
  
  //Sorting hashtables
  //private Hashtable<String, LinkedList> residentSort; //sorts by resident
  private Hashtable<String, LinkedList> homeAptSort; //sorts by either home or apt
  private Hashtable<String, LinkedList> lOrBSort; //sorts by landlord or bank
  private Hashtable<String, LinkedList> addressSort;  //sorts by String address 
  private Hashtable<String, LinkedList> dangerSort; //sorts by isInDanger
  // private Hashtable<Integer, LinkedList> rentSort; //sorts by mortgage or rent
  
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
    //this.residentSort = new Hashtable<String, LinkedList>();
    this.homeAptSort = new Hashtable<String,LinkedList>();
    this.lOrBSort = new Hashtable<String, LinkedList>(); 
    this.addressSort = new Hashtable<String, LinkedList>();
    this.dangerSort = new Hashtable<String, LinkedList>();
    //this.rentSort = new Hashtable<Integer, LinkedList>();
    
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
    
  }
  
  /**
   * Creates a HomesForAll object with an input file that acts as the loaded database reference.
   * 
   * @param fileName Name of the database reference as a String
   */
  public HomesForAll(String fileName) {
    //initializing sorting hashtables
    //this.residentSort = new Hashtable<String, LinkedList>();
    this.homeAptSort = new Hashtable<String,LinkedList>();
    this.lOrBSort = new Hashtable<String, LinkedList>(); 
    this.addressSort = new Hashtable<String, LinkedList>();
    this.dangerSort = new Hashtable<String, LinkedList>();
    //this.rentSort = new Hashtable<Integer, LinkedList>();
    
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
      writer.println("");
      
      writer.close();
    } catch (IOException ex) {
      System.out.println("***(T)ERROR*** The file couldn't be written: " + ex);
    }
  }
  
  //add residences to the appropriate LL
  public void addBanksLordsLL (Residence name) {
    if (name.getBOrL() == "boA" && boA.contains(name)==false) {
      boA.add(name); 
      //System.out.println("BOA" + boA.peek());
    }
    if (name.getBOrL() == "wellsFargo" && !wellsFargo.contains(name)) {
      wellsFargo.add(name); 
      //System.out.println("WF" + wellsFargo.peek());
    }
    if (name.getBOrL() == "chaseBank" && !chaseBank.contains(name)) {
      chaseBank.add(name); 
      //System.out.println("CB" + chaseBank.peek());
    }
    if (name.getBOrL() == "lordEmurry" && !lordEmurry.contains(name)) {
      lordEmurry.add(name); 
      //System.out.println("LE" + lordEmurry.peek());
    }
    else if (name.getBOrL() == "lordKasey" && !lordKasey.contains(name)) {
      lordKasey.add(name); 
      //System.out.println("LK" + lordKasey.peek());
    }
  }
  
  public void addTypeLL(Residence name) {
    if (name.getResType() == "home" &&!homes.contains(name)) {
      homes.add(name); 
    } else if (name.getResType() == "apt" && !apts.contains(name)) {
      apts.add(name); 
    }
  }
  
  public void addStreetLL(Residence name) {
    if (name.getAddress() == "streetA" && !streetA.contains(name)) {
      streetA.add(name); 
    }
    if (name.getAddress() == "streetB" && !streetB.contains(name)) {
      streetB.add(name); 
    }
    if (name.getAddress() == "streetC" && !streetC.contains(name)) {
      streetC.add(name); 
    }
    else if (name.getAddress() == "streetD" && !streetC.contains(name)) {
      streetD.add(name);
    }
  }
  
  public void addDangerLL(Residence name) {
    if (name.getIsInDanger() == true && !inDanger.contains(name)) {
      inDanger.add(name);
    } else if (name.getIsInDanger() == false && !notDanger.contains(name)) {
      notDanger.add(name); 
    }
  }
  
  //adds the linkedLists to the HashTable
  public void addBanksLordsHT (Residence name) {
    addBanksLordsLL(name);
    lOrBSort.put("boA", boA);
    lOrBSort.put("wellsFargo", wellsFargo);
    lOrBSort.put("chaseBank", chaseBank);
    lOrBSort.put("lordEmurry", lordEmurry);
    lOrBSort.put("lordKasey", lordKasey);
    //System.out.println("BoA"+lOrBSort.get("boA"));
  }
  
  public void addTypeHT(Residence name) {
    addTypeLL(name);
    homeAptSort.put("homes", homes);
    homeAptSort.put("apts", apts);
    //System.out.println("homes"+homeAptSort.get("homes"));
  }
  
  public void addStreetHT(Residence name) {
    addStreetLL(name);
    addressSort.put("streetA", streetA);
    addressSort.put("streetB", streetB);
    addressSort.put("streetC", streetC);
    addressSort.put("streetD", streetD);
    //System.out.println("SA"+ addressSort.get("streetB"));
  }
  
  public void addDangerHT(Residence name) {
    addDangerLL(name);
    dangerSort.put("inDanger", inDanger);
    dangerSort.put("notDanger", notDanger);
    //System.out.println("danger" + dangerSort.get("inDanger"));
  }
  
  //adds one residence info into the hashtables in a concise manner
  public void addAllInfo(Residence name) {
    addBanksLordsHT(name);
    addTypeHT(name);
    addStreetHT(name);
    addDangerHT(name);
  }
 
  //need to make it check for copies
  public void addLL () {
    LinkedList copy = new LinkedList();
    copy = database;
    while (copy.size() > 0) {
      //Residence temp = (Residence) copy.poll();
      addAllInfo((Residence)copy.pop());
      
    }
    System.out.println(homes);
  }
  
  //All the finder methods
  public LinkedList findBanks (String bank) {
    return lOrBSort.get(bank);
  }
  
  public LinkedList findType (String residences) {
    return homeAptSort.get(residences);
  }
  
  public LinkedList findAddress (String street) {
   return addressSort.get(street);
  }
  
  public LinkedList findDanger (String danger) {
   return dangerSort.get(danger); 
  }
  
  
  /**
   * Returns a String representation of the HomesForAll class.
   * 
   * @return Returns HomesForAll.
   */
  public String toString() {
    LinkedList copy = new LinkedList<Residence>();
    copy = database;
    String s = "";
    s += "Current size of database: (3) " + copy.size() + "\n";
    s += "First item from popping: \n" + copy.pop() + "\nYayyy :D";
    s += "\nNow go through rest of thingy\n\n";
    while (copy.size() > 0) {
      s += "Size: " + copy.size() + "\n" + copy.pop() + "\n";
      
    }
    return s;
  }
  
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //--------------------------------------Main Method
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static void main (String[] args) {
//    HomesForAll test = new HomesForAll();
//    Residence person1 = new Residence("Angela", "home", "boA", 900, 0, 0, "streetA", true);
//    Residence person2 = new Residence("Shirley", "home", "boA", 1000, 0, 1, "streetA", false);
//    Residence person3 = new Residence("Celia", "apt", "wellsFargo", 1100, 0, 2, "streetA", true);
//    Residence person4 = new Residence("Maria", "apt", "wellsFargo", 1200, 1, 1, "streetB", false);
//    Residence person5 = new Residence("Kendall", "apt", "chaseBank", 1300, 1, 2, "streetB", true);
//    Residence person6 = new Residence("Rebecca", "home", "chaseBank", 1400, 1, 3, "streetB", false);
//    Residence person7 = new Residence("Savitri", "home", "lordEmurry", 1500, 2, 1, "streetC", true);
//    Residence person8 = new Residence("Ro", "apt", "lordEmurry", 1600, 2, 2, "streetC", false);
//    Residence person9 = new Residence("Alice", "apt", "lordKasey", 1700, 3, 1, "streetD", true);
//    Residence person10 = new Residence("Alisha", "home", "lordKasey", 1800, 3, 2, "streetD", false);
    
//    test.addBanksLordsLL(person1);
//    test.addBanksLordsLL(person2);
//    test.database.add(person1);
//    test.database.add(person2);
//    test.database.add(person3);
//    test.database.add(person4);
//    test.database.add(person5);
//    test.database.add(person6);
//    test.database.add(person7);
//    test.database.add(person8);
//    test.database.add(person9);
//    test.database.add(person10);
//    test.addLL();
//    System.out.println("Banks-----------------");
//    System.out.println("Boa"+test.findBanks("boA"));
//    System.out.println("wellsFargo"+test.findBanks("wellsFargo"));
//    System.out.println("chase"+test.findBanks("chaseBank"));
//    System.out.println("lordEmurry"+test.findBanks("lordEmurry"));
//    System.out.println("lordKasey"+test.findBanks("lordKasey"));
//    System.out.println("homes/Apt---------");
//    System.out.println("homes"+test.findType("homes"));
//    System.out.println("apts"+test.findType("apts"));
//    System.out.println("address---------------");
//    System.out.println("streetA"+test.findAddress("streetA"));
//    System.out.println("streetB"+test.findAddress("streetB"));
//    System.out.println("streetC"+test.findAddress("streetC"));
//    System.out.println("streetD"+test.findAddress("streetD"));
//    System.out.println("danger------------");
//    System.out.println("inDanger"+test.findDanger("inDanger"));
//    System.out.println("notDanger"+test.findDanger("notDanger"));
    
    //System.out.println(test.boA);
//    System.out.println(test.database.poll());
//    test.addAllInfo(person3);
//    test.addAllInfo(person2);
//    
    
    
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    
    System.out.println("Testing the second constructor method");
    HomesForAll test2 = new HomesForAll("testing.txt");
    //System.out.println(test2);
    test2.addLL();
    //System.out.println(test2.database);

    System.out.println("Banks-----------------");
    System.out.println("Boa"+test2.findBanks("boA"));
    System.out.println("wellsFargo"+test2.findBanks("wellsFargo"));
    System.out.println("chase"+test2.findBanks("chaseBank"));
    System.out.println("lordEmurry"+test2.findBanks("lordEmurry"));
    System.out.println("lordKasey"+test2.findBanks("lordKasey"));
//    System.out.println("homes/Apt---------");
//    System.out.println("homes"+test2.findType("homes"));
//    System.out.println("apts"+test2.findType("apts"));
//    System.out.println("address---------------");
//    System.out.println("streetA"+test2.findAddress("streetA"));
//    System.out.println("streetB"+test2.findAddress("streetB"));
//    System.out.println("streetC"+test2.findAddress("streetC"));
//    System.out.println("streetD"+test2.findAddress("streetD"));
//    System.out.println("danger------------");
//    System.out.println("inDanger"+test2.findDanger("inDanger"));
//    System.out.println("notDanger"+test2.findDanger("notDanger"));
//    
//    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
  
    
    
     /*
     * so each find____ method should first call upon a helper method that 
     * both initializes and then sorts the database items into linkedlists that 
     * the hash table then will sort into
     * then at the end, the find____ method will return the value of the key input... 
     * the "search"
     * 
     */
    
  }
}
