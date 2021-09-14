package BusReservationSystem;
import java.io.*;

public class menu {
    
    public static void displayMenu(String [] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String choice;
        int end1=0;
        for (int x = 1; x == 1;) {
            // the MAIN MENU//
            System.out.println("********************************************");
            System.out.println("** BUS RESERVATION AND TICKETING SYSTEM   **");
            System.out.println("********************************************");
            System.out.println("** [1] View                               **");
            System.out.println("** [2] Booking                            **");
            System.out.println("** [3] Payment                            **");
            System.out.println("** [4] View                               **");
            System.out.println("** [5] Exit                               **");
            System.out.println("********************************************");
            System.out.println("********************************************\n");

            for (x = 1; x == 1;) {
                System.out.print("ENTER CHOICE: ");
                choice = in.readLine();

                if (choice.equals("1")) {
                    x=0;

                }

                else if (choice.equals("2")) {
                    x=0;
                    

                }


                else if (choice.equals("3")) {
                    x=0;

                }

                else if (choice.equals("4")) {
                    x=0;

                }

                else if (choice.equals("5")) {
                    end1 = 1;
                    x = 0;
                    System.out.println("Thank You!");
                }

                else {
                    System.out.println("Invalid Input!");
                    x = 1;
                }
        }
    }
    }
}