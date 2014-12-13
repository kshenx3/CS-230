/*
 * CS 230 - Final Project
 * Home.java
 * 
 * Michelle Sit & Kasey Shen
 * 
 * PURPOSE:
 * 
 */


public class Home {
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //-------------------------------Instance Variables
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private boolean isInDanger;
  private String resident, bank;
  private int mortgageVal;
  
  
  
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //------------------------------Constructor Methods
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  
  /**
   * Creates an "empty" Home that needs its information to be assigned 
   */
  public Home() {
    isInDanger = false;
    resident = bank = "";
    mortgageVal = 0;
    
  }
  
  /**
   * Creates a Home with information already known and taken as input parameters.
   * 
   * @param status the status of the residence (inDanger, not, etc.)
   * @param currRes refers to the current resident
   * @param currBank refers to the current bank in charge of the mortgage
   * @param mortgage numerical value of mortgage
   */
  public Home(boolean status, String currRes, String currBank, int mortgage) {
    isInDanger = status;
    resident = currRes;
    bank = currBank;
    mortgageVal = mortgage;
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
   * Returns the bank in charge of the residence's mortgage. Is a getter method.
   * 
   * @return bank instance variable
   */
  public String getBank() {
    return bank;
  }
  
  
  /**
   * Returns the mortgage value of the residence. Is a getter method.
   * 
   * @return mortgageVal instance variable
   */
  public int getMortgage() {
    return mortgageVal;
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
   * Returns a String representation of an instance of 'Home'. 
   * 
   * @return Returns Home information including Resident, Mortgage Value, Bank
   *         and status.
   */
  public String toString() {
    String s = "";
    s += "This is the Home you created: \n";
    s += "Resident: " + resident + "\nMortgage Value: " + mortgageVal + "\nBank: " 
      + bank + "\nStatus: " + isInDanger + "\n";
    //s += "\nAddress: " + address;
    return s;
  }
  
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //--------------------------------------Main Method
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static void main (String[] args) {
    Home test1 = new Home();
    System.out.println(test1);
    System.out.println("Testing getResident(): ( ) " + test1.getResident());
    System.out.println("Testing getBank(): ( ) " + test1.getBank());
    System.out.println("Testing getMortgage(): (0) " + test1.getMortgage());
    System.out.println("Testing isInDanger(): (FALSE) " + test1.isInDanger() + "\n");
    
    Home test2 = new Home(true, "Bobby", "Bank of America", 500);
    System.out.println(test2);
    System.out.println("Testing getResident(): (Bobby) " + test2.getResident());
    System.out.println("Testing getBank(): (Bank of America) " + test2.getBank());
    System.out.println("Testing getMortgage(): (500) " + test2.getMortgage());
    System.out.println("Testing isInDanger(): (TRUE) " + test2.isInDanger());
    
    
  }
  
  
}
