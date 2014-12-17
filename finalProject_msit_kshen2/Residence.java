/*
 * CS 230 - Final Project
 * Residence.java
 * 
 * Michelle Sit & Kasey Shen
 * 
 * PURPOSE: 
 * 
 */

/* Random Notes as needed:
 * 
 * 
 * 
 */



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
  //private Vector<Integer> address; 
  
  
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
    amt = xCoor = yCoor = 0;
    
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
  public boolean isInDanger() {
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
   * Returns a String representation of an instance of 'Residence'. 
   * 
   * @return Returns Home information including Resident, Mortgage Value, Bank
   *         and status.
   */
  public String toString() {
    String s = "";
    s += "This is the Residence (type: " + resType + ") you created: \n";
    s += "Resident: " + resident + "\nMortgage/Rent Value: " + amt 
      + "\nBank/Landlord: " + bOrL;
    s += "\nAddress: " + address + "\nStatus: " + isInDanger + "\n";
    return s;
  }
  
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //--------------------------------------Main Method
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static void main(String[] args) {
    Residence mer = new Residence();
    System.out.println(mer);
    
    Residence mer2 = new Residence("Amy", Residence.RESTYPE1, "Bank of Gs", 1200, 3, 2, "Ann Way", false);
    System.out.println(mer2);
    
    
    
  }
}
