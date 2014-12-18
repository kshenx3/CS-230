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

public class HomesForAll implements HomesForAllInterface {
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //-------------------------------Instance Variables
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private File output;
  ///private int count;
  
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
  
  private Residence[][] addresses = new Residence[4][4];
  
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //------------------------------Constructor Methods
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  
  /**
   * Creates an instance of HomesForAll class when there is no input database to refer to.
   * Will create a new database from scratch. 
   */ 
  public HomesForAll() {
    
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
    
    //nested for loop in order to assign all the grid squares
    //null/initialize addresses[][]
    for(int i = 0; i<4; i++) {
      for (int j = 0; j<4; j++) {
        addresses[i][j] = null;
      }
    }
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
    
    //nested for loop in order to assign all the grid squares
    //null/initialize addresses[][]
    for(int i = 0; i<4; i++) {
      for (int j = 0; j<4; j++) {
        addresses[i][j] = null;
      }
    }
    
    try {
      Scanner scan = new Scanner(new File(fileName));
      
      while (scan.hasNext()) {
        Residence res = new Residence(); //create empty Residence
        
        //the scanner's input from each line is set as the appropriate instance
        //variables for Residence (or else will notify user of an error in the 
        //file's data order by catching exceptions (see below)
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
        //System.out.println("Inside Constructor: " + res.getAddress());  /*debugging purposes*/
        
        //convert nextLine() String to boolean for isInDanger
        boolean input = Boolean.parseBoolean(scan.nextLine());
        res.setIsInDanger(input);
        database.add(res);
        
        addresses[x][y] = res;
        //System.out.println("New Residence!: \n" + res);  /*debugging purposes */
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
  
  /**
   * Method should be called when updates are made to the database
   * Needs to be manually called.
   * 
   * @param newFileName the String parameter that becomes the new file's name
   */
  public void updateInputFile(String newFileName) {
    try {
      PrintWriter writer = new PrintWriter(new File(newFileName));
      
      int count = database.size();
      
      for (int i = 0; i<count; i++) {
        Residence r = new Residence();
        r = database.get(i); //get(i) returns the Residence at index i
        
        writer.println(r.getResident()); //print out each variable
        writer.println(r.getResType()); //in proper order
        writer.println(r.getBOrL());
        writer.println(r.getAmount());
        writer.println(r.getXCoor());
        writer.println(r.getYCoor());
        writer.println(r.getAddress());
        
        if(i == count-1) {
          writer.print(r.getIsInDanger());
        } else {
          writer.println(r.getIsInDanger());
        }
      }
      writer.close();
      
    } catch (IOException ex) {
      System.out.println("***(T)ERROR*** The file couldn't be written: " + ex);
    }
  }
  
  /**
   * adds residences to the appropriate linked lists
   * 
   * @param name takes in a Residence
   */
  public void addBanksLordsLL (Residence name) {
    //System.out.println("Inside addBanksLordsLL: " + name.getBOrL());  /*debugging purposes*/
    
    if (name.getBOrL().equals("boA") && boA.contains(name)==false) {
      boA.add(name); 
      //System.out.println("BOA" + boA.peek()); /*testing purpose*/
    } else if (name.getBOrL().equals("wellsFargo") && !wellsFargo.contains(name)) {
      wellsFargo.add(name); 
      //System.out.println("WF" + wellsFargo.peek()); /*testing purpose*/
    } else if (name.getBOrL().equals("chaseBank") && !chaseBank.contains(name)) {
      chaseBank.add(name); 
      //System.out.println("CB" + chaseBank.peek()); /*testing purpose*/
    } else if (name.getBOrL().equals("lordEmurry") && !lordEmurry.contains(name)) {
      lordEmurry.add(name); 
      //System.out.println("LE" + lordEmurry.peek()); /*testing purpose*/
    } else if (name.getBOrL().equals("lordKasey") && !lordKasey.contains(name)) {
      lordKasey.add(name); 
      //System.out.println("LK" + lordKasey.peek()); /*testing purpose*/
    } else {
      System.out.println("Something went wrong in addBanksLordsLL() OR Duplicate");
    }
  }
  
  /**
   * adds specifically the parameter Residence to one of 2 linked lists:
   * either the homes list or the apartment list based on its resType
   * 
   * @param name takes in a Residence object
   */
  public void addTypeLL(Residence name) {
    if (name.getResType().equalsIgnoreCase("home") &&!homes.contains(name)) {
      homes.add(name); 
    } else if ((name.getResType().equalsIgnoreCase("apt") || name.getResType().equalsIgnoreCase("apartment")) && !apts.contains(name)) {
      apts.add(name); 
    } else {
      System.out.println("Something went wrong in addTypeLL() OR Duplicate");
    }
  }
  
  
  /**
   * adds the specific Residence paramter to the correct street linked
   * list (there are 4 possible ones)
   * 
   * @param name takes in a Residence object 
   */
  public void addStreetLL(Residence name) {
    //System.out.println("Inside addStreetLL: " + name.getAddress());   /*debugging purposes*/
    
    if (name.getAddress().equals("streetA") && !streetA.contains(name)) {
      streetA.add(name); 
    } else if (name.getAddress().equals("streetB") && !streetB.contains(name)) {
      streetB.add(name); 
    } else if (name.getAddress().equals("streetC") && !streetC.contains(name)) {
      streetC.add(name); 
    } else if (name.getAddress().equals("streetD") && !streetC.contains(name)) {
      streetD.add(name);
    } else {
      System.out.println("Something went wrong in addStreetLL() OR Duplicate");
    }
  }
  
  
  /**
   * adds the specific Residence parameter into the proper linked list of two
   * kinds: 1) isInDanger == true, or 2) isInDanger == false.
   * 
   * @param name takes in a Residence object
   */
  public void addDangerLL(Residence name) {
    if (name.getIsInDanger() == true && !inDanger.contains(name)) {
      inDanger.add(name);
    } else if (name.getIsInDanger() == false && !notDanger.contains(name)) {
      notDanger.add(name); 
    } else {
      System.out.println("Something went wrong in addDangerLL()");
    }
  }
  
  
  /**
   * this method adds the specific banks and landlord linked lists
   * to the hashtables; it specifies the keys to be used and then the
   * linked list values for each respective key; it calls upon
   * addBanksLordsLL() to first add the parameter to the correct LL
   * 
   * @param name takes in a Residence object
   */
  public void addBanksLordsHT (Residence name) {
    addBanksLordsLL(name); //calls on method to sort into proper linked list
    lOrBSort.put("boA", boA);
    lOrBSort.put("wellsFargo", wellsFargo);
    lOrBSort.put("chaseBank", chaseBank);
    lOrBSort.put("lordEmurry", lordEmurry);
    lOrBSort.put("lordKasey", lordKasey);
    //System.out.println("BoA"+lOrBSort.get("boA")); /*testing purposes*/
  }
  
  /**
   * this method sorts the input Residence into its correct linked list
   * and then constructs the hashtable for the type of residence, with the
   * keys being either "homes" or "apts" pointing to their respective linked lists
   * 
   * @param name takes in a Residence object
   */
  public void addTypeHT(Residence name) {
    addTypeLL(name);
    homeAptSort.put("homes", homes);
    homeAptSort.put("apts", apts);
    //System.out.println("homes"+homeAptSort.get("homes")); /*testing purposes*/
  }
  
  /**
   * this method sorts the specific Residence parameter into its
   * proper address linked list and then constructs the hashtable with keys
   * for each street and then the linked list containing Residences on that
   * street
   * 
   * @param name takes in a Residence object
   */
  public void addStreetHT(Residence name) {
    addStreetLL(name);
    addressSort.put("streetA", streetA);
    addressSort.put("streetB", streetB);
    addressSort.put("streetC", streetC);
    addressSort.put("streetD", streetD);
    //System.out.println("SA"+ addressSort.get("streetB")); /*testing purposes*/
  }
  
  /**
   * Method sorts the Residence parameter based on its status: in danger
   * or not. Adds it to the correct linked list and then constructs a
   * hashtable that contains the linked lists with the keys being either 
   * 'inDanger' or 'notDanger'
   * 
   * @param name takes in a Residence object
   */
  public void addDangerHT(Residence name) {
    addDangerLL(name);
    dangerSort.put("inDanger", inDanger);
    dangerSort.put("notDanger", notDanger);
    //System.out.println("danger" + dangerSort.get("inDanger")); /*testing purposes*/
  }
  
  
  /**
   * This method adds one Residence object's info into all of the LinkedLists
   * in a concise manner
   * 
   * @param name takes in a Residence object
   */
  public void addAllInfo(Residence name) {
    if (!database.contains(name)){
      addToDatabase(name);
    } else {
      System.out.println("Error adding to database --Possible duplicate; addAllInfo");
    }
    
    addBanksLordsHT(name);
    addTypeHT(name);
    addStreetHT(name);
    addDangerHT(name);
    
    addresses[name.getXCoor()][name.getYCoor()] = name;
  }
  
  /**
   * This method adds the Residence object to the database Linked List
   * updating it to include new additions when created
   * 
   * @param name new Residence object that is assumed to not be in database 
   */
  public void addToDatabase(Residence name) {
//    if (database.contains(name)){
      database.add(name);
//    } else {
//      System.out.println("Error adding to database. Possible duplicate");
//    }
  }
  
  
  
  /**
   * Creates a copy of the "master" database linked list and then destroys
   * it to add all of the read-in Residence objects to sorted Linked Lists
   * 
   * The check for copies comes from calling on the other add methods (which
   * are called from addAllInfo()).
   * Technically, should not be necessary to use because from constructor
   * alone, we already add all of files from being read-in to the database. 
   * 
   */
  public void addLL () {
    //LinkedList<Residence> copy = new LinkedList<Residence>();
    //copy = database;
    
    int count = database.size();
    //while (copy.size() > 0) {
    for(int i = 0; i < count; i++) {  
      //Residence temp = (Residence) copy.poll();
      Residence temp  = database.get(i);
      addAllInfo(temp);  
      //System.out.println(i); /*debugging purposes*/
    }
    //System.out.println(homes); /*testing purposes*/
  }
  
  /**
   * Getter method to access Residence[][] addresses for the VisualPanel.
   * 
   * @return a Residence[][]
   */
  public Residence[][] getAddresses() {
    return addresses;
  }
  
  //All the finder methods -- the methods that look through the Hashtables
  //and return the correct linked list
  /**
   * Takes the parameter as the key for the hashtable and returns the 
   * LinkedList value
   * 
   * @param bank String input is the key
   */
  public LinkedList findBanks (String bank) {
    return lOrBSort.get(bank);
  }
  
  /**
   * Takes the parameter as the key for the hashtable and returns the 
   * LinkedList value
   * 
   * @param residences String input is the key
   */
  public LinkedList findType (String residences) {
    return homeAptSort.get(residences);
  }
  
  
  /**
   * Takes the parameter as the key for the hashtable and returns the 
   * LinkedList value
   * 
   * @param street String input is the key
   */
  public LinkedList findAddress (String street) {
    return addressSort.get(street);
  }
  
  
  /**
   * Takes the parameter as the key for the hashtable and returns the 
   * LinkedList value
   * 
   * @param danger String input is the key
   */
  public LinkedList findDanger (String danger) {
    return dangerSort.get(danger); 
  }
  
  /**
   * An accessor method that will return the database
   * 
   * @return database instance variable
   */
  public LinkedList getDatabase() {
    return this.database;
  }
  
  /**
   * Returns a String representation of the HomesForAll class.
   * 
   * @return Returns HomesForAll.
   */
  public String toString() {
    int count = database.size(); //size to use in the for loops
    
    LinkedList<Residence> copy = new LinkedList<Residence>(); //create a copy LL to manipulate
    for(int i = 0; i < count; i++) {
      Residence r = database.get(i);
      copy.add(r);
    }
    
    String s = "";
    //for loop to print out each Residence within database, destroys copy along the way    
    for(int i = 0; i<count; i++) {  
      Residence temp = (Residence)copy.pop(); //create a temp Residence object to print out each loop
      s += "Resident: " + temp.getResident() + ", Type: " + temp.getResType() + ", Landlord/Bank: "
        + temp.getBOrL() + ", Rent/Mortgage: " + temp.getAmount() + ", Address: " + temp.getAddress() 
        + ", Status: ";
      s += (temp.getIsInDanger()) ? "In Danger\n\n" : "Not in Danger\n\n";
    }
    return s;
  }
  
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //--------------------------------------Main Method
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static void main (String[] args) {
//    System.out.println("Testing the first constructor method\n");
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
    
    
    //System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    
    System.out.println("Testing the second constructor method\n");
    HomesForAll test2 = new HomesForAll("testing.txt");
    System.out.println("test2~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println(test2);
    
    //System.out.println("test2database~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    //System.out.println(test2.database); 
    
//    System.out.println("addLL~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//    test2.addLL(); // -- should be goin through database
    //and adding all of the residences to the proper linked lists.... but only when its
    //necessary; a constructed HFA from a text file does not need this step; ex: will print 
    //out all of the "errors" from repeats
    
//    System.out.println(test2);
    
    //System.out.println("test2database~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    //System.out.println(test2.database); 

//    System.out.println(test2); /*DEBUGGING*/
//    System.out.println("test2database AFTER toString to check database still there~~~~~~~\n");
//    System.out.println(test2.database);
//    System.out.println(test2.database.size()); /*end DEBUGGING*/
    
//    System.out.println("Banks-----------------");
//    System.out.println("Boa\n"+test2.findBanks("boA"));
//    System.out.println("wellsFargo\n"+test2.findBanks("wellsFargo"));
//    System.out.println("chase\n"+test2.findBanks("chaseBank"));
//    System.out.println("lordEmurry\n"+test2.findBanks("lordEmurry"));
//    System.out.println("lordKasey\n"+test2.findBanks("lordKasey"));
//    System.out.println("\nhomes/Apt---------");
//    System.out.println("homes\n"+test2.findType("homes"));
//    System.out.println("apts\n"+test2.findType("apts"));
//    System.out.println("\naddress---------------");
//    System.out.println("streetA\n"+test2.findAddress("streetA"));
//    System.out.println("streetB\n"+test2.findAddress("streetB"));
//    System.out.println("streetC\n"+test2.findAddress("streetC"));
//    System.out.println("streetD\n"+test2.findAddress("streetD"));
//    System.out.println("\ndanger------------");
//    System.out.println("inDanger\n"+test2.findDanger("inDanger"));
//    System.out.println("notDanger\n"+test2.findDanger("notDanger"));
    
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
    
    
    //TO ADD NEW RESIDENCE OBJECTS: 1) create Residence, 2) add to all LL
    Residence mer = new Residence("Amy Ann", "home", "boA", 1200, 3, 2, "streetA", false);
    //test2.addToDatabase(mer); //gets Possible duplicate from addto database
    test2.addAllInfo(mer);
    
    System.out.println("\ntest2 AFTER addition~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println(test2);
    System.out.println(test2.database.size());
      
    
//    System.out.println("\nTESTING FOR getAddresses(); PRINTS OUT ARRAY REP. OF ADDRESSES");
//    Residence[][] copy = test2.getAddresses();
//    
//    String s = "";
//    String res = "";
//    int n = 4;
//    
//    for (int i = 0; i<n; i++) {  
//      for (int j = 0; j<n; j++) {
//        res = (copy[i][j] != null) ? "1" : "-";
//        //s gets either res + a tabbed space if it is not the last element or else
//        //s will get res and then starts a new line
//        s += (j==(n-1)) ? res + " \n" : res + "\t";
//      }
//    }
//    System.out.println(s);

    System.out.println("testing update file: " );
    test2.updateInputFile("testing3.txt");
    
    System.out.println("test3~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    HomesForAll test3 = new HomesForAll("testing3.txt");
    System.out.println(test3);
    
//    System.out.println("after addll test3~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//    System.out.println(test3.getDatabase().size());
//    test3.addLL(); //should print out error message because all of the residence objects
    //should already be loaded into the database linked list
//    System.out.println(test3);
//    System.out.println(test3.getDatabase().size());  
//    System.out.println("Testing findInDanger\n" + test3.findDanger("inDanger"));
    
  }
}
