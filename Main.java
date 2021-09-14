package BusReservation;
/*qqq*/
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        User[] user = {
            new User("S9999", 6790, "Michael", "020519-05-0219", "018-910512213", 'M'),
            new User("C0001", 2324, "John", "021212-05-0210", "011-331946128", 'M'),
            new User("C0002", 2425, "Dylan", "020109-05-0313", "017-249101281", 'M'),
            new User("C0003", 5877, "Dannie", "0201101-05-0414", "019-21564241", 'F'),
            new User("C0004", 2497, "Nicole", "020905-05-0218", "014-123456789", 'F'),
            new User("C0005", 5897, "Emily", "020814-05-0128", "012-645287419", 'F')
        };

        ArrayList<Details> usersList = new ArrayList<>();
        for (int i = 0; i < user.length; i++) {
            usersList.add(user[i]);
        }
        Scanner scanner = new Scanner(System.in);
        int select = 0;
        boolean continueInput;
        System.out.println("Welcome To KKAZ!");
        do {
            continueInput = true;
            System.out.println("\n---KKAZ---");
            System.out.println("===========");
            System.out.println("1. Staff Log In");
            System.out.println("2. Customer Log In");
            System.out.println("3. Exit");
            do {
                try {
                    System.out.print("Please select one: ");
                    select = scanner.nextInt();
                    if (select > 0 && select < 4) {
                        continueInput = false;
                    } else {
                        System.err.println("** Please enter between 1 to 3 **");
                    }
                } catch (Exception ex) {
                    System.err.println("** Incorrect input: an integer is required **");
                    scanner.nextLine();
                }
            } while (continueInput);
            switch (select) {
                case 1:
                    staffLoginPage(usersList);
                    break;
                case 2:
                    customerLoginPage(usersList);
                    break;
                default:
                    System.out.println("** Thank You **");

            }
        } while (select != 3);
    }

    public static void staffLoginPage(ArrayList<Details> usersList) {
        char choose = 'N';
        boolean loginSuccess = false;
        do {
            System.out.println("\nStaff Login Page");
            System.out.println("==================");
            System.out.print("Enter Staff ID:");
            Scanner scanner = new Scanner(System.in);
            String selectedID = scanner.nextLine();
            System.out.println();
            int passcode = 0;
            boolean continueInput = true;
            do {
                try {
                    System.out.print("Enter your passcode:");
                    passcode = scanner.nextInt();
                    continueInput = false;
                } catch (Exception ex) {
                    System.err.println("Incorrect input: an integer is required");
                    scanner.nextLine();
                }
            } while (continueInput);
            for (int n = 0; n <= usersList.size() - 1; n++) {
                if (selectedID.equals(usersList.get(n).getID())) {
                    if (selectedID.charAt(0) == 'S') {
                        if (passcode == usersList.get(n).getPasscode()) {
                            loginSuccess = true;
                            System.out.println("Login successful");
                            choose = 'N';
                            break;
                        } else {
                            System.err.println("Incorrect Passcode!");
                        }
                    } else {
                        System.err.println("Incorrect ID!");
                   }
                }
            }
            if(loginSuccess == false){
                do {
                System.out.print("Login Again? (Yes = Y / No = N)");
                choose = scanner.next().trim().toUpperCase().charAt(0);
                if(choose != 'Y' && choose != 'N'){
                    System.err.println("** Only Y or N are allowed **");
                }
            } while (choose != 'Y' && choose != 'N');
            }
            
        } while (Character.toUpperCase(choose) == 'Y');
        if(loginSuccess == true){
            System.out.println("Welcome to the Staff system!!!");
        }
        //scanner.close();
    }
    


public static void customerLoginPage(ArrayList<Details> usersList) {
    char choose = 'N';
    boolean loginSuccess = false;
    do {
        System.out.println("\nCustomer Login Page");
        System.out.println("==================");
        System.out.print("Enter Name:");
        Scanner scanner = new Scanner(System.in);
        String selectedID = scanner.nextLine();
        System.out.println();
        int passcode = 0;
        boolean continueInput = true;
        do {
            try {
                System.out.print("Enter your passcode:");
                passcode = scanner.nextInt();
                continueInput = false;
            } catch (Exception ex) {
                System.err.println("Incorrect input: an integer is required");
                scanner.nextLine();
            }
        } while (continueInput);
        for (int n = 0; n <= usersList.size() - 1; n++) {
            if (selectedID.equals(usersList.get(n).getID())) {
                if (selectedID.charAt(0) == 'C') {
                    if (passcode == usersList.get(n).getPasscode()) {
                        loginSuccess = true;
                        System.out.println("Login successful");
                        choose = 'N';
                        break;
                    } else {
                        System.err.println("Incorrect Passcode!");
                    }
                }
                else {
                        System.err.println("Incorrect ID!");
                    }
            }
        }
        if(loginSuccess == false){
            do {
            System.out.print("Login Again? (Yes = Y / No = N)");
            choose = scanner.next().trim().toUpperCase().charAt(0);
            if(choose != 'Y' && choose != 'N'){
                System.err.println("** Only Y or N are allowed **");
            }
        } while (choose != 'Y' && choose != 'N');
        }
        
    } while (Character.toUpperCase(choose) == 'Y');
    if(loginSuccess == true){
        System.out.println("Welcome to the Booking system!!!");
    }
    
}
//scanner.close();
}
