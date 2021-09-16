package BusReservationSystem;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class UpdateBusDetail {
    public static void UpdateMenu(ArrayList<Bus> busList) {
        int choice;
        boolean continueInput = true;
        Scanner scanner = new Scanner(System.in);
        do{	
            try{
                do{
                    System.out.println(" -----------------------");
                    System.out.println("|   Update Bus Detail   |");
                    System.out.println(" -----------------------");
                    System.out.println("1. Add Bus Detail ");
                    System.out.println("2. Modify Bus Detail ");
                    System.out.println("3. Delete Bus Detail ");
                    System.out.println("4. Display Bus Detail ");
                    System.out.println("5. Back to Main Menu ");
                    System.out.println("\nWhich you want to do.(1-5) :");
                    choice = scanner.nextInt();
                    switch (choice){
                        case 1:
                            addBus(busList);
                            break;
                        case 2:
                            modifyBus(busList);
                            break;
                        case 3:
                            deleteBus(busList);
                            break;
                        case 4:
                            displayBus(busList);
                            System.out.print("Press X to back to the menu.");
                            char actionBack = scanner.next().trim().toUpperCase().charAt(0);

                            if (actionBack == 'X') {
                                break;
                            } else {
                                System.out.println("Press again X to back to the menu.");
                            }
                        case 5:
                            continueInput = false;
                            break;
                        default:
                            System.out.println("Invalid input, please enter again");  
                    }
                }while (choice !=5);
            }catch (InputMismatchException inputMismatchException) {
                System.out.println("Please enter again!");
                scanner.nextLine();
            }
        }while (continueInput);   
    }

    public static void addBus(ArrayList<Bus> busList){
        Scanner scanner = new Scanner(System.in);
        char confirm;

        do{
            System.out.println("Add Bus");

            String busID;
                do{
                    System.out.println("Enter Bus ID:");
                    busID = scanner.nextLine();
                    if(Bus.validateBusId(busID)!=true){
                        System.out.println("Bus ID cannot more than 3 characters,");
                        System.out.println("Bus ID cannot more than 5 number");
                        System.out.println("Please enter proper bus ID!");
                    }
                }while(Bus.validateBusId(busID)!=true);

            String destination;
                do{
                    System.out.println("Enter Destination:");
                    destination = scanner.nextLine();
                    destination = destination.toUpperCase();
                    if(Bus.validateDestination(destination)!=true){
                        System.out.println("Destination must be one of Selangor, Pulau Pinang, Johor Bahru, Negeri Sembilan, Melaka, Kelatan or Perak.");
                        System.out.println("Please enter proper destination!");
                    }
                }while(Bus.validateDestination(destination)!=true);

            String departureDate;
                do{
                    System.out.println("Enter Departure Date:");
                    departureDate = scanner.nextLine();
                    if(Bus.validateDate(departureDate)!=true){
                        System.out.println("Departure date must be in dd/mm/yyyy format.");
                        System.out.println("Please enter proper departure date!");
                    }
                }while(Bus.validateDate(departureDate)!=true);

            String departureTime;
                do{
                    System.out.println("Enter Departure Time:");
                    departureTime = scanner.nextLine();
                    if(Bus.validateTime(departureTime)!=true){
                        System.out.println("The departure time must be in xx:xx(am/pm) format.");
                        System.out.println("Please enter proper departure time!");
                    }
                }while(Bus.validateTime(departureTime)!=true);

            int price;
                do{
                    System.out.println("Enter Price:");
                    price = scanner.nextInt();
                    if(Bus.validateprice(price)!=true){
                        System.out.println("The price cannot be zero or negative.");
                        System.out.println("Please enter proper price!");
                    }   
                }while(Bus.validateprice(price)!=true);

            int seatNo;
                do{
                    System.out.println("Enter Seat Avaible:");
                    seatNo = scanner.nextInt();
                    if(Bus.validateSeatNo(seatNo)!=true){
                        System.out.println("The seat avaible cannot more than 30.");
                        System.out.println("Please enter proper seat avaible!");
                    }
                }while(Bus.validateSeatNo(seatNo)!=true);

            Bus addBus = new Bus(busID, destination, departureDate, departureTime, price, seatNo);
            try{
                addBus.addNewBus(busList);
            }catch (IndexOutOfBoundsException e) {
                    System.out.println("Error");
                }
    
                System.out.print("Do you want to add more bus? Yes(Y)/ No (N)?");
                confirm = scanner.next().trim().toUpperCase().charAt(0);
        } while (confirm == 'Y');
    }

    public static void modifyBus(ArrayList<Bus> busList){
        Bus bus = new Bus();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bus List");
        bus.displayBus(busList);

        String busID;
        do{
            System.out.println("Enter Bus ID for modify:");
            busID = scanner.nextLine();
            busID = busID.toUpperCase();
            if(Bus.validateBusId(busID)==false){
                System.out.println("Bus ID cannot more than 3 characters,");
                System.out.println("Bus ID cannot more than 5 number");
                System.out.println("Please enter proper bus ID!");
            }
        }while(Bus.validateBusId(busID)==false);

        for(int i=0 ; i<busList.size() ; i++){
            if(busID.toUpperCase().compareTo(busList.get(i).getBusID())==0 || busID.equals(busList.get(i).getBusID())){

                String destination;
                do{
                    System.out.println("Enter Destination:");
                    destination = scanner.nextLine();
                    destination = destination.toUpperCase();
                    if(Bus.validateDestination(destination)!=true){
                        System.out.println("Destination must be one of Selangor, Pulau Pinang, Johor Bahru, Negeri Sembilan, Melaka, Kelatan or Perak.");
                        System.out.println("Please enter proper destination!");
                    }
                }while(Bus.validateDestination(destination)!=true);

                String departureDate;
                do{
                    System.out.println("Enter Departure Date:");
                    departureDate = scanner.nextLine();
                    if(Bus.validateDate(departureDate)!=true){
                        System.out.println("Departure date must be in dd/mm/yyyy format.");
                        System.out.println("Please enter proper departure date!");
                    }
                }while(Bus.validateDate(departureDate)!=true);

                String departureTime;
                do{
                    System.out.println("Enter Departure Time:");
                    departureTime = scanner.nextLine();
                    if(Bus.validateTime(departureTime)!=true){
                        System.out.println("The departure time must be in xx:xx(am/pm) format.");
                        System.out.println("Please enter proper departure time!");
                    }
                }while(Bus.validateTime(departureTime)!=true);

                int price;
                do{
                    System.out.println("Enter Price:");
                    price = scanner.nextInt();
                    if(Bus.validateprice(price)!=true){
                        System.out.println("The price cannot be zero or negative.");
                        System.out.println("Please enter proper price!");
                    }   
                }while(Bus.validateprice(price)!=true);

                int seatNo;
                do{
                    System.out.println("Enter Seat Avaible:");
                    seatNo = scanner.nextInt();
                    if(Bus.validateSeatNo(seatNo)!=true){
                        System.out.println("The seat avaible cannot more than 30.");
                        System.out.println("Please enter proper seat avaible!");
                    }
                }while(Bus.validateSeatNo(seatNo)!=true);
                
                Bus modifyBus = new Bus(busID, destination, departureDate, departureTime, price, seatNo);
                modifyBus.modifyBus(busList, i);
                System.out.println("Bus's Details Modify!\n");

            }
        }
    }

    public static void deleteBus(ArrayList<Bus> busList){
        Bus bus = new Bus();
        boolean chekID=true;
        String busID;
        char confirm;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bus List");
        bus.displayBus(busList);
        
        do{
            do{
                System.out.println("Enter Bus ID for delete: ");
                busID = scanner.nextLine();
                for(int i=0 ; i<busList.size() ; i++){
                    if(busID.toUpperCase().compareTo(busList.get(i).getBusID())==0 || busID.equals(busList.get(i).getBusID())){
                        chekID=true;
                        busList.remove(i);
                        break;
                        
                        }else{
                            chekID = false;
                        }
                    }
       
                if(chekID == false){
                    System.out.println("Record Not Found");
                    
                }else{
                    System.out.println("Delete Successfully ! !");
 
                }
            }while(chekID = false); 
            System.out.print("Do you want to modify again? Yes(Y)/ No (N)?");
            confirm = scanner.next().trim().toUpperCase().charAt(0);
        }while(confirm=='y');
    }

    public static void displayBus(ArrayList<Bus> busList){
        Bus bus = new Bus();
        System.out.println("Bus List");
        bus.displayBus(busList);
    }
}
