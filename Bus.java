package BusReservation;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Bus {
    private String busID;
    private int seatNo;
    private double price;
    private String departureTime;
    private String departureDate;
    private String destination;
    private static int busCount = 1;

    public Bus(){
        busCount++;
    }

    public Bus(String busID, String destination, String departureDate, String departureTime, double price,int seatNo ){
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

    public static int getBusCount(){
        return busCount;
    }

    public static void errorMsg(){
        System.out.println("Invalid Input !  Please Re-enter.\n"); 
    }

    //validatetion for date format
    private static boolean dateValidation(String newDepartureDate)
    {
      boolean status = false;
    if (checkDate(newDepartureDate)) {
      DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      dateFormat.setLenient(false);
      try {
        dateFormat.parse(newDepartureDate);
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

    public static void displayBus(ArrayList<Bus> bus){
       
        System.out.println(" _____________________________________________________________________________________________________________________________________________");
        System.out.println("|                                                                       Bus Detail                                                           |");
        
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
        
        System.out.printf("| %-3d| %-10s| %-20s| %-15s| %-15s| RM%8.2f | %-5d|\n", "NO.","Bus ID","Destination","Departure Date","Departure Time","Price"," Seat Available");
        
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");

    	for(int i=0;i<bus.size();i++){
    			System.out.println(bus.get(i).toString());
    	}

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Total Bus Number: " + getBusCount());
    }

    @Override
    public String toString(){
        return String.format("| %-3d| %-10s| %-20s| %-15s| %-15s| RM%8.2f| %-5d\n",
                busCount, busID, destination, departureDate, departureTime, price, seatNo);
    }

    //add bus method
    public static ArrayList<Bus> addBus(ArrayList<Bus> bus){
        Scanner scan = new Scanner(System.in);

        String newBusID, newDestination, newDepartureDate, newDepartureTime;
        int newSeatNo;
        double newPrice;
        boolean checkInput;

        System.out.println("Current Bus Detail");
        displayBus(bus);
        System.out.println("Start Adding");

        //validate ID
        do{
            System.out.println("Bus ID:");
            newBusID = scan.nextLine();
            
            newBusID = newBusID.toUpperCase();
            int lengd = newBusID.length();
            if(lengd > 5)
            {
                checkInput = false;
                errorMsg();
                System.out.println("Bus id can not be more than 5 numbers");
            }

            if (newBusID.matches("[A-Z][A-Z][A-Z]+")) {
                checkInput = true;
            } 
            else {
                checkInput = false;
                errorMsg();
                System.out.println("Bus id can not be more than or less than 3 characters");
            }
        }while(checkInput==false);

        //validate destination
        do{
            System.out.println("Destination:");
            newDestination = scan.nextLine();
            if(newDestination.toUpperCase()=="SELANGOR" || newDestination=="PULAU PINANG" || newDestination=="JOHOR BAHRU" || newDestination=="NEGERI SEMBILAN" || newDestination=="MELAKA" || newDestination=="KELATAN" || newDestination=="PERAK"){
                checkInput = true;
            }
            else{
                checkInput = false;
                errorMsg();
                System.out.println("The destination must be in one of Selangor, Pulau Pinang, Johor Bahru, Negeri Sembilan, Melaka, Kelatan and Perak.");
            }
        }while(checkInput==false);

        //validate departure date
        do{
            System.out.println("Departure Date:");
            newDepartureDate = scan.nextLine();
            if(dateValidation(newDepartureDate)==true){
                checkInput = true;
            }
            else{
                checkInput = false;
                errorMsg();
                System.out.println("The departure date must be in dd/mm/yyyy format.");
            }   
        }while(checkInput==false);

        //validate departure time
        do{
            System.out.println("Departure Time:");
            newDepartureTime = scan.nextLine();
            if (newDepartureTime.matches("(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)")){
                checkInput = true;
            }else{
                checkInput = false;
                errorMsg();
                System.out.println("The departure time must be in xx:xx(am/pm) format.");
            }
        }while(checkInput==false);

        //validate price
        do{
            System.out.println("Price:");
            newPrice = scan.nextDouble();
            if(newPrice>0){
                checkInput = true;
            }
            else{
                checkInput = false;
                errorMsg();
                System.out.println("The price cannot be zero or negative.");
            }
        }while(checkInput==false);

        //validate seat no
        do{
            System.out.println("Avaible Seat No:");
            newSeatNo = scan.nextInt();
            if(newSeatNo<=30){
                checkInput = true;
            }
            else{
                checkInput = false;
                errorMsg();
                System.out.println("The seat avaible cannot more than 30.");
            }
        }while(checkInput==false);

        //add new bs detail into the array list
        bus.add(new Bus(newBusID, newDestination, newDepartureDate, newDepartureTime, newPrice, newSeatNo));
        
        System.out.println("Bus detail Added Sucessfully !");
        return bus;
    }

    //modify bus method
    public static ArrayList<Bus> modifyBus(ArrayList<Bus> bus){
        String modiDestination, modiDepartureDate, modiDepartureTime;
        double modiPrice;
        int modiSeatNo;
        int holder = 0;
        int modiSelect;
        boolean checkInput;
        boolean innerCheck = true;
        String id;
        Scanner  scan = new Scanner(System.in);

        System.out.println("Current Bus");
        displayBus(bus);

        System.out.print("\nEnter Bus ID for modifying : ");
            id = scan.nextLine();
                    

                for(int i=0 ; i<bus.size() ; i++){
                    if(id.toUpperCase().compareTo(bus.get(i).getBusID())==0){
                        
    			holder=i;
                        innerCheck=true;
                        break;
                        
                    }else{
                        innerCheck=false;
                    }
                }
                
                if(innerCheck==false){
                    System.out.println("Record Not Found");
                    
                }else{
                    do{	
                        System.out.println("\nWhat do you wish to modify ?"
                                + "\n1.Destination"
                                + "\n2.Departure Date"
                                + "\n3.Departure Time"
                                + "\n4.Price"
                                + "\n5.Seat Available"
                                + "\n6.Exit");
                        
                        System.out.print("\n\n Please select(1-6) : ");
                        modiSelect = scan.nextInt();
                        
                        }while (modiSelect<1 ||modiSelect >6);
                        
                        switch(modiSelect){
                                case 1:
                                //Modify destination
                                    do{
                                System.out.print("\nEnter New Name: ");
                                modiDestination = scan.nextLine();
                                        if(modiDestination.toUpperCase()=="SELANGOR" || modiDestination.toUpperCase()=="PULAU PINANG" || modiDestination.toUpperCase()=="JOHOR BAHRU" || modiDestination.toUpperCase()=="NEGERI SEMBILAN" || modiDestination.toUpperCase()=="MELAKA" || modiDestination.toUpperCase()=="KELATAN" || modiDestination.toUpperCase()=="PERAK"){
                                            checkInput = true;
                                        }else{
                                            checkInput = false;
                                            errorMsg();
                                            System.out.print("The destination must be in one of Selangor, Pulau Pinang, Johor Bahru, Negeri Sembilan, Melaka, Kelatan and Perak.");
                                        }
                                    }while(checkInput==false);
                                bus.get(holder).setDestination(modiDestination);
                                System.out.println("\nSuccessfully Modified.");
                                        
                                        break;
                                        
                                case 2:
                                //Modify departure date
                                    do{
                                System.out.print("\nEnter New Departure Date: ");
                                modiDepartureDate = scan.nextLine();
                                        if(dateValidation(modiDepartureDate)==true){
                                            checkInput = true;
                                        }
                                        else{
                                            checkInput = false;
                                            errorMsg();
                                            System.out.println("The departure date must be in dd/mm/yyyy format.");
                                        }   
                                    }while(checkInput==false);
                                bus.get(holder).setDepartureDate(modiDepartureDate);
                                System.out.println("\nSuccessfully Modified.");
                                    
                                        break;
                                    
                                case 3:
                                //Modify departure time
                                    do{
                                System.out.println("\nEnter New Departure Time: ");
                                modiDepartureTime = scan.nextLine();
                                        if (modiDepartureTime.matches("(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)")){
                                            checkInput = true;
                                        }else{
                                            checkInput = false;
                                            errorMsg();
                                            System.out.println("The departure time must be in xx:xx(am/pm) format.");
                                        }
                                    }while(checkInput==false);
                                bus.get(holder).setDepartureTime(modiDepartureTime);
                                System.out.println("\nSuccessfully Modified.");
                                    
                                        break;
                                
                                case 4:
                                //Modify price
                                    do{
                                System.out.println("Enter New Price:");
                                modiPrice = scan.nextDouble();
                                        if(modiPrice>0){
                                            checkInput = true;
                                        }else{
                                            checkInput = false;
                                            errorMsg();
                                            System.out.println("The price cannot be zero or negative.");
                                        }
                                    }while(checkInput==false);
                                bus.get(holder).setPrice(modiPrice);
                                System.out.println("\nSuccessfully Modified.");
                                    
                                        break;
                                
                                        
                                case 5:
                                //Modify seat no
                                    do{
                                System.out.println("Enter New Avaible Seat No:");
                                modiSeatNo = scan.nextInt();
                                        if(modiSeatNo<=30){
                                            checkInput = true;
                                        }else{
                                        checkInput = false;
                                        errorMsg();
                                        System.out.println("The seat avaible cannot more than 30.");
                                        }
                                    }while(checkInput==false);
                                bus.get(holder).setSeatNo(modiSeatNo);
                                System.out.println("\nSuccessfully Modified.");
                                    
                                        break;
                            case 6:
                                    
                                System.out.println("Exited");
                                    
                                    break;
                        }
                                System.out.println("\nBus Detail After Modifying.");
                                displayBus(bus);
                        }
        return bus;
    }

    //delete bus method
    public static ArrayList<Bus> deleteBus(ArrayList<Bus> bus){
    	
        Scanner scan = new Scanner(System.in);
        boolean deleteCheck=true;
        String id;	
    	
        System.out.println("Current Bus");
    	displayBus(bus);
        
    	System.out.print("\nEnter bus ID for deleting: ");
        id = scan.nextLine();
        
        for(int i=0 ; i<bus.size() ; i++){
                    if(id.toUpperCase().compareTo(bus.get(i).getBusID())==0){
    			deleteCheck=true;
                        bus.remove(i);
                        break;
                        
                        }else{
                            deleteCheck = false;
                        }
                    }
       
                if(deleteCheck == false){
                    System.out.println("Record Not Found");
                    
                }else{
                    System.out.println("Delete Successfully ! !");
                    System.out.println("Bus Detail After Deleting.");
                    displayBus(bus);  
                }
        
        return bus;
    }
}
