package BusReservationSystem;
import java.util.ArrayList;
public class Details{

    private String ID;
    private int    passcode;
    private String name;
    private String ICNo;
    private String phoneNo;
    private char   gender ;
    private Address address;

    public Details() {

    }

    public Details(String ID, int passcode, String name, String ICNo, String phoneNo, char gender, Address address) {
        this.ID = ID;
        this.passcode = passcode;
        this.name = name;
        this.ICNo = ICNo;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.address = address;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    public int getPasscode() {
        return passcode;
    }

    public void setPasscode(int passcode) {
        this.passcode = passcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getICNo() {
        return ICNo;
    }

    public void SetICNo(String ICNo) {
        this.ICNo = ICNo;
    }
    
    public String getPhoneNo() {
        return phoneNo;
    }

    public void SetPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    
    public void setGender(char gender) {
        this.gender = gender;
    }

     public char getGender() {
        return gender;
    }

    public void setAddress(Address address){
        this.address = address;
    }
    
    public void addNewDetail(ArrayList<Details> detailsList) {
        detailsList.add(new Details(ID, passcode, name, ICNo, phoneNo, gender, address));
    }
  

    public void displayDetail(ArrayList<Details> detailsList) {
        for (int i = 0; i < detailsList.size(); i++) {
            System.out.println(detailsList.get(i));
        }
    }

    public void modifyDetail(ArrayList<Details> detailsList, int modifyDetail) {
        detailsList.set((modifyDetail), new Details(ID, passcode, name, ICNo, phoneNo, gender, address));
    }

    public void deleteDetail(ArrayList<Details> detailsList, int deleteDetail) {
        detailsList.remove(deleteDetail);
    }
    
    public static boolean validatePhoneNumber(String phoneNumber){
        if(phoneNumber.matches("[\\d]{3}-[\\d]{7}") || phoneNumber.matches("[\\d]{3}-[\\d]{8}")){
            if(phoneNumber.charAt(0)== '0' && phoneNumber.charAt(1)== '1'){
                return true;
            }
        }
        return false;
    }
    
     public static boolean validateICNo(String IcNumber){
        if(IcNumber.matches("[\\d]{6}-[\\d]{2}-[\\d]{4}")){
            return true;
        }
        return false;
    }
     
     public static boolean validateStaffGender(char staffGender){
        if(staffGender =='M' || staffGender =='F'){
            return true;
        }
        return false;
    }
     
     public static boolean validatePasscode(int passcode){
        return (Math.log10(passcode) >3 && Math.log10(passcode) <4);
    }
    
    public static boolean validateStaffID(String StaffID){
        if(StaffID.matches("\\w\\d{4}")){
            if (StaffID.charAt(0)=='S') {
                return true;
            }
        }
        return false;
    }

    public String toString() {
    	return String.format("%-10s %-10d %-30s %-15s %-15s %10s", ID, passcode, name, ICNo, phoneNo, gender);
    }

   
}