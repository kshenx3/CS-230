/*
 * CS 230 - Final Project
 * Apartment.java
 * 
 * Michelle Sit & Kasey Shen
 * 
 * PURPOSE: To determine the meaning of life :) (aka 42)
 * 
 */

public class Apartment {
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //-------------------------------Instance Variables
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private boolean isInDanger;
  private String resident, landlord;
  private int rentVal;
  //remember to add "address" somehow... use of coordinates; how to save that as a variable
  
  
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //------------------------------Constructor Methods
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  
  /**
   * Creates an "empty" Apartment object that needs instance variables assigned.
   */
  public Apartment(){
    isInDanger = false;
    resident = landlord = "";
    rentVal = 0;
  }
  
  /**
   * Creates an Apartment from known information & assigns all instance variables.
   * 
   * @param status the status of the residence (inDanger, not, etc.)
   * @param currRes refers to the current resident
   * @param currLL refers to the current landlord in charge of the apartment
   * @param rent numerical value of rent=
   */
  public Apartment(boolean status, String currRes, String currLL, int rent) {
    isInDanger = status;
    resident = currRes;
    landlord = currLL;
    rentVal = rent;
  }
  
  
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //---------------------------------Instance Methods
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  
  /**
   * Returns the resident of the residence. Is a getter method.
   * 
   * @return resident instance variable
   */
  public String getResident() {
    return resident;
  }
  
  /**
   * Returns the landlord in charge of the residence. Is a getter method.
   * 
   * @return landlord instance variable
   */
  public String getLandlord() {
    return landlord;
  }
  
  /**
   * Returns the rent value of the residence. Is a getter method.
   * 
   * @return rentVal instance variable
   */
  public int getRent() {
    return rentVal;
  }
  
  /**
   * Returns the status of the residence. Is a getter method.
   * 
   * @return isInDanger instance variable
   */
  public boolean isInDanger() {
    return isInDanger;
  }
  
  /* public getAddress() {
   *   return address;
   * } */ 
  
  
  
  /**
   * Returns a String representation of an instance of 'Apartment'. 
   * 
   * @return Returns Apartment information including Resident, Rent Value, Landlord
   *         and status.
   */
  public String toString() {
    String s = "";
    s += "This is the Apartment you created: \n";
    s += "Resident: " + resident + "\nRent Value: " + rentVal + "\nLandlord: " 
      + landlord + "\nStatus: " + isInDanger + "\n";
    //s += "\nAddress: " + address;
    return s;
  }
  
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //--------------------------------------Main Method
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static void main (String[] args) {
    Apartment test1 = new Apartment();
    System.out.println(test1);
    System.out.println("Testing getResident(): ( ) " + test1.getResident());
    System.out.println("Testing getLandlord(): ( ) " + test1.getLandlord());
    System.out.println("Testing getRent(): (0) " + test1.getRent());
    System.out.println("Testing isInDanger(): (FALSE) " + test1.isInDanger());
    
    
    Apartment test2 = new Apartment(true, "Marian", "Jackass #2", 1200);
    System.out.println(test2);
    System.out.println("Testing getResident(): (Marian) " + test2.getResident());
    System.out.println("Testing getLandlord(): (Jackass #2) " + test2.getLandlord());
    System.out.println("Testing getRent(): (1200) " + test2.getRent());
    System.out.println("Testing isInDanger(): (TRUE) " + test2.isInDanger());
    System.out.println("Testing compile! YAY WE DID IT!");
    System.out.println("The meaning of life is (Expected: 42) Got: 42");
    
    
  }
  
  
}
