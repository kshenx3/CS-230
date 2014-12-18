/*
 * CS 230 - Final Project
 * Residence.java
 * 
 * Michelle Sit & Kasey Shen
 * 
 * PURPOSE: 
 * 
 */


import java.util.*;
import java.io.*;


public class Residence {
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //-------------------------------Instance Variables
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private String resident, bOrL, resType; //bOrL = bank or landlord
  private boolean isInDanger;
  private int amt; //Amount to pay for either rent or mortgage
  final static String RESTYPE1 = "Home";
  final static String RESTYPE2 = "Apartment";
  
  private int xCoor, yCoor;
  private String address;


  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //------------------------------Constructor Methods
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  /**
   * Residence() constructor creates "empty" Residence object where
   * none of the instance variables are assigned. Will be assigned 
   * at a later point. All of the strings (resident, bank/landlord, 
   * res type) are set to null and the default for isInDanger is false.
   * The initial amount is also set to 0.
   * 
   */ 
  public Residence() {
    resident = bOrL = resType = address = null;
    isInDanger = false;
    amt = xCoor = yCoor = -1;
  }
  
  /**
   * This second constructor takes in parameters that immediately sets 
   * the instance variables with the parameter input. 
   * 
   * @param status what is the current status of the residence, sets isInDanger
   * @param currRes sets resident to the current resident
   * @param type can only be either RESTYPE1 or RESTYPE2 (Home or Apt)
   * @param currBOrl sets the current bank or landlord for bOrL
   * @param value sets amt of current rent or mortgage
   */
  public Residence(String currRes, String type, String currBOrL, int value, int x, int y, String loc, boolean status) {
    isInDanger = status;
    resident = currRes;
    resType = type;
    bOrL = currBOrL;
    amt = value;
    //for the address part
    xCoor = x;
    yCoor = y;
    address = loc;
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
   * Returns the bank in charge of the home's mortgage or the landlord
   * in charge of the apartment.
   * 
   * @return bOrL instance variable
   */
  public String getBOrL() {
    return bOrL;
  }
  
  /**
   * Returns the mortgage value of the home or the rent value 
   * of an apartment.
   * 
   * @return amt instance variable
   */
  public int getAmount() {
    return amt;
  }
  
  /**
   * Returns the status of the residence. Is a getter method.
   * 
   * @return isInDanger instance variable
   */
  public boolean getIsInDanger() {
    return isInDanger;
  }
  
  /**
   * Returns the type of residence (either Home [1] or Apt [2]).
   *
   * @return resType instance variable
   */
  public String getResType() {
    return resType;
  }
  
  
  /**
   * Returns the address of the Residence
   * 
   * @return address instance variable
   */
  public String getAddress() {
   return address; 
  }
  
  /**
   * Returns the x coordinate of the Residence
   * 
   * @return yCoor instance variable
   */
  public int getXCoor() {
    return xCoor;
  }
  
  /**
   * Returns the y coordinate of the Residence
   * 
   * @return yCoor instance variable
   */
  public int getYCoor() {
    return yCoor;
  }
  
  /**
   * Sets the Resident name to the string input
   * 
   * @param name the new Resident name
   */
  public void setResident(String name) {
    resident = name;
  }
  
  
  /**
   * Sets the resType to string input
   * 
   * @param type the new resType assignment
   */
  public void setResType(String type) {
    String s = type.toLowerCase();
    //resType gets either RESTYPE1 or RESTYPE2 depending on whether or not the 
    //string parameter fits in the required pattern (either 'home' or 'apt')
    //otherwise sets as null
    resType = (s.equals("home")) ? RESTYPE1 : (s.equals("apt") || s.equals("apartment")) ? RESTYPE2 : null;  
  }
  
  /**
   * Sets the bOrL to the string input. 
   * 
   * @param borl the new bOrL
   */
  public void setBOrL(String borl) {
    this.bOrL = borl;
  }
  
  /**
   * Sets the amoount of either mortgage or rent to the input
   * 
   * @param value the new amt
   */
  public void setAmt(int value) {
    amt = value;
  }
  
  /**
   * Sets the xCoor to the input
   * 
   * @param x new xCoor
   */
  public void setXCoor(int x) {
    xCoor = x;
  }
  
  /**
   * Sets the yCoor to the input
   * 
   * @param y new yCoor
   */
  public void setYCoor(int y) {
    yCoor = y;
  }
  
  /**
   * Sets the address to the input.
   * 
   * @input the new address value
   */
  public void setAddress(String input) {
    address = input;
  }
  
  /**
   * Sets the isInDanger boolean to the input
   * 
   * @param status the current status of residence
   */
  public void setIsInDanger(boolean status) {
    isInDanger = status;
  }
  
  /**
   * Returns a String representation of an instance of 'Residence'. 
   * 
   * @return Returns Home information including Resident, Mortgage Value, Bank
   *         and status.
   */
  public String toString() {
    String s = "";
    s += "Residence (type: " + resType + "): \n";
    s += "Resident: " + resident + "\nMortgage/Rent Value: " + amt 
      + "\nBank/Landlord: " + bOrL;
    s += "\nAddress: " + address + "\nStatus: ";
    s += (isInDanger) ? "In Danger\n" : "Not in Danger\n";
    return s;
  }
  
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //--------------------------------------Main Method
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static void main(String[] args) {
    Residence mer = new Residence();
    System.out.println(mer);
    
    Residence mer2 = new Residence("Amy", "home", "chase", 1200, 3, 2, "Ann Way", false);
    System.out.println(mer2);
    
    
    
  }
}
