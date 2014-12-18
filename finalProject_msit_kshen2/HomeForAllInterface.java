
import java.util.*;
import java.io.*;

public interface HomesForAllInterface {
  public void addAllInfo(Residence name);
  
  public void addBanksLordsHT(Residence name);
  
  public void addBanksLordsLL(Residence name);
  
  public void addDangerHT(Residence name);
  
  public void addDangerLL(Residence name);
  
  public void addLL();
  
  public void addStreetHT(Residence name);
  
  public void addTypeHT(Residence name);
  
  public void addTypeLL(Residence name);
  
  public LinkedList findAddress(String street);
  
  public LinkedList findBanks(String bank);
  
  public LinkedList findDanger(String danger);
  
  public LinkedList findType(String residences);
  
  public Residence[][] getAddresses();
  
  
  public void saveSearchRes(String newFileName);
  
  public String toString();
  
}
