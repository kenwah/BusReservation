package BusReservationSystem;

import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Bus {
    private String busID;
    private int seatNo;
    private double price;
    private String departureTime;
    private String departureDate;
    private String destination;
    private static int busCount = 0;

    public Bus(){
        
    }

    public Bus(int busCount, String busID, String destination, String departureDate, String departureTime, double price,int seatNo ){
        this.busID = busID;
        this.destination = destination;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.price = price;
        this.seatNo = seatNo;
        busCount++;
    }
    
    public String getBusID(){
        return busID;
    }

    public void setBusID(String busID){
        this.busID = busID; 
    }

    public int getSeatNo(){
        return seatNo;
    }

    public void setSeatNo(int seatNo){
        this.seatNo = seatNo;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public String getDepartureTime(){
        return departureTime;
    }

    public void setDepartureTime(String departureTime){
        this.departureTime = departureTime;
    }

    public String getDepartureDate(){
        return departureDate;
    }

    public void setDepartureDate(String departureDate){
        this.departureDate = departureDate;
    }

    public String getDestination(){
        return destination;
    }

    public void setDestination(String destination){
        this.destination = destination;
    }

    public void displayBus(ArrayList<Bus> busList){
        System.out.println(" _____________________________________________________________________________________________________________________________________________");
        System.out.println("|                                                                       Bus Detail                                                            |");
        System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("| NO. |    Bus ID    |      Destination      |      Departure Date      |      Departure Time      |      Price      |     Seat Available     |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");

    	for(int i=0;i<busList.size();i++){
            busCount++;
            System.out.println(busList.get(i).toString());
        }

        System.out.println("+-----+--------------+-----------------------+--------------------------+--------------------------+-----------------+------------------------+");
        System.out.println("Total Bus Number: " + busCount);
    }

    public void addNewBus(ArrayList<Bus> busList){
        busList.add(new Bus(busCount, busID, destination, departureDate, departureTime, price, seatNo));
    }

    public void modifyBus(ArrayList<Bus> busList, int modifyBus){
        busList.set((modifyBus), new Bus(busCount, busID, destination, departureDate, departureTime, price, seatNo));
    }

    public void deleteBus(ArrayList<Bus> busList, int deleteBus){
        busList.remove(deleteBus);
    }

    public static boolean validateBusId(String newId){
        if(newId.toUpperCase().matches("^[A-Z]{3} [0-9]{1,4}$")){
            return true;
        }
       
        return false;
    }

    public static boolean validateDestination(String newDestination){
        newDestination = newDestination.toUpperCase();
        if(newDestination.equals("SELANGOR") || newDestination.equals("PULAU PINANG")|| newDestination.equals("JOHOR BAHRU") || newDestination.equals("NEGERI SEMBILAN") || newDestination.equals("PULAU PINANG") || newDestination.equals("KELATAN") || newDestination.equals("PERAK")){
            return true;
        }
        return false;
    }

    //validatetion for date format
    private static boolean dateValidation(String date)
    {
      boolean status = false;
    if (checkDate(date)) {
      DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      dateFormat.setLenient(false);
      try {
        dateFormat.parse(date);
        status = true;
      } catch (Exception e) {
        status = false;
      }
    }
    return status;
    }
    
    //validatetion for date
    static boolean checkDate(String newDepartureDate) {
    String pattern = "(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[0-2])\\/([0-9]{4})";
    boolean flag = false;
    if (newDepartureDate.matches(pattern)) {
      flag = true;
    }
    return flag;
  }

    public static boolean validateDate(String newDate){
        if(dateValidation(newDate)==true){
            return true;
        }
        return false;
    }

    public static boolean validateTime(String newTime){
        if(newTime.matches("(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)")){
            return true;
        }
        return false;
    }
    
    public static boolean validateprice(double newPrice){
        if(newPrice > 0 ){
            return true;
        }
        return false;
    }

    public static boolean validateSeatNo(int newSeatNo){
        if(newSeatNo <= 30){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return String.format("|  %-3d|   %-11s|     %-18s|        %-10s        |           %-15s|    RM%8.2f   |          %-5d         |\n",
                busCount, busID, destination, departureDate, departureTime, price, seatNo);
    }
}