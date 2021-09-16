package BusReservationSystem;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args)
    {
        User[] user = {
            new User("M1111", 6790, "Michael", "020519-05-0219", "018-910512213", 'M'),
            new User("S0001", 2324, "John", "021212-05-0210", "011-331946128", 'M'),
            new User("S0002", 2425, "Dylan", "020109-05-0313", "017-249101281", 'M'),
            new User("S0003", 5877, "Dannie", "0201101-05-0414", "019-21564241", 'F'),
            new User("S0004", 2497, "Nicole", "020905-05-0218", "014-123456789", 'F'),
            new User("S0005", 5897, "Emily", "020814-05-0128", "012-645287419", 'F')
        };

        ArrayList<Bus> busList = new ArrayList<Bus>();
        busList.add(new Bus("WZO 5989", "Selangor", "25/5/2021", "7.00am", 10.00, 30));
        busList.add(new Bus("WAZ 1325", "Selangor", "25/5/2021", "10.00am", 11.00, 30));
        busList.add(new Bus("WRT 7226", "Selangor", "25/5/2021", "5.00pm", 12.00, 30));
        busList.add(new Bus("WFS 2391", "Selangor", "25/5/2021", "8.00pm", 10.00, 30));
        busList.add(new Bus("WFK 1490", "Pulau Pinang", "25/5/2021", "7.00am", 40.00, 30));
        busList.add(new Bus("WYF 6457", "Pulau Pinang", "25/5/2021", "10.00am", 41.00, 30));
        busList.add(new Bus("WXI 1812", "Pulau Pinang", "25/5/2021", "5.00pm", 42.00, 30));
        busList.add(new Bus("WEE 5027", "Pulau Pinang", "25/5/2021", "8.00pm", 40.00, 30));
        busList.add(new Bus("WYP 0563", "Johor Bahru", "25/5/2021", "7.00am", 40.00, 30));
        busList.add(new Bus("WFP 9608", "Johor Bahru", "25/5/2021", "10.00am", 41.00, 30));
        busList.add(new Bus("WEO 7328", "Johor Bahru", "25/5/2021", "5.00pm", 42.00, 30));
        busList.add(new Bus("WTD 9930", "Johor Bahru", "25/5/2021", "8.00pm", 40.00, 30));
        busList.add(new Bus("WUO 4034", "Negeri Sembilan", "25/5/2021", "7.00am", 15.00, 30));
        busList.add(new Bus("WXR 2322", "Negeri Sembilan", "25/5/2021", "10.00am", 16.00, 30));
        busList.add(new Bus("WDY 3288", "Negeri Sembilan", "25/5/2021", "5.00pm", 17.00, 30));
        busList.add(new Bus("WSB 1611", "Negeri Sembilan", "25/5/2021", "8.00pm", 15.00, 30));
        busList.add(new Bus("WMQ 8787", "Melaka", "25/5/2021", "7.00am", 16.00, 30));
        busList.add(new Bus("WEU 4211", "Melaka", "25/5/2021", "10.00am", 17.00, 30));
        busList.add(new Bus("WZD 8826", "Melaka", "25/5/2021", "5.00pm", 18.00, 30));
        busList.add(new Bus("WRF 6736", "Melaka", "25/5/2021", "8.00pm", 16.00, 30));
        busList.add(new Bus("WTF 4522", "Kelantan", "25/5/2021", "7.00am", 42.00, 30));
        busList.add(new Bus("WFX 9128", "Kelantan", "25/5/2021", "10.00am", 43.00, 30));
        busList.add(new Bus("WGL 9060", "Kelantan", "25/5/2021", "5.00pm", 44.00, 30));
        busList.add(new Bus("WYQ 4868", "Kelantan", "25/5/2021", "8.00pm", 42.00, 30));
        busList.add(new Bus("WBY 5428", "Perak", "25/5/2021", "7.00am", 39.00, 30));
        busList.add(new Bus("WFN 6188", "Perak", "25/5/2021", "10.00am", 40.00, 30));
        busList.add(new Bus("WNX 0932", "Perak", "25/5/2021", "5.00pm", 41.00, 30));
        busList.add(new Bus("WON 1539", "Perak", "25/5/2021", "8.00pm", 39.00, 30));

        ArrayList<Details> usersList = new ArrayList<>();
        for (int i = 0; i < user.length; i++) {
            usersList.add(user[i]);
        }
        Scanner scanner = new Scanner(System.in);
        int select = 0;
        boolean continueInput;
        System.out.println("Welcome To KKAZ Bus Ticketing!");
        do {
            continueInput = true;
            System.out.println("\n---KKAZ Bus---");
            System.out.println("================");
            System.out.println("1. Staff ");
            System.out.println("2. Management");
            System.out.println("3. Exit");
            do {
                try {
                    System.out.print("Please select one to LOG IN: ");
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
                    staffLoginPage(usersList, busList);
                    break;
                case 2:
                    managementLoginPage(usersList);
                    break;
                default:
                    System.out.println("** Thank You **");
            }
        } while (select != 3);
    }

    public static void staffLoginPage(ArrayList<Details> usersList, ArrayList<Bus> busList) {
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
            staff(busList);
        }
    }
    
    public static void managementLoginPage(ArrayList<Details> usersList) {
        char choose = 'N';
        boolean loginSuccess = false;
        do {
            System.out.println("\nManagement Login Page");
            System.out.println("==================");
            System.out.print("Enter ID(Mxxxx): ");
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
                    if (selectedID.charAt(0) == 'M') {
                        if (passcode == usersList.get(n).getPasscode()) {
                            loginSuccess = true;
                            System.out.println("Login successful");
                            choose = 'N';
                            break;
                        } else {
                            System.err.println("Incorrect Passcode!");
                        }
                    }else {
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
            System.out.println("Welcome to the Management system!!!");
        }    
    }

    public static void staff(ArrayList<Bus> busList) {
        Scanner input = new Scanner(System.in);
        int[] selangorPrice = {10,11,12,10};
        int[] pulauPngPrice = {40, 41, 42, 40};
        int[] johorPrice = {40, 41, 42, 40};
        int[] negeriSemPrice = {15, 16, 17, 18};
        int[] melakaPrice = {16, 17, 18, 16};
        int[] kelatanPrice = {42, 43, 44, 42};
        int[] perakPrice = {39, 40, 41, 39}; 
        int price = 0;
        int amount = 0;
        int select = 0;
        boolean continueInput;
        do {
            continueInput = true;
             // the MAIN MENU//
             System.out.println("********************************************");
             System.out.println("** BUS RESERVATION AND TICKETING SYSTEM   **");
             System.out.println("********************************************");
             System.out.println("** [1] View                               **");
             System.out.println("** [2] Booking                            **");
             System.out.println("** [3] Payment                            **");
             System.out.println("** [4] Maintainance                       **");
             System.out.println("** [5] Exit                               **");
             System.out.println("********************************************");
             System.out.println("********************************************");  
            do {
                try {
                    System.out.print("Please select one: ");
                    select = input.nextInt();
                    if (select > 0 && select < 6) {
                        continueInput = false;
                    } else {
                        System.err.println("** Please enter between 1 to 5 **");
                    }
                } catch (Exception ex) {
                    System.err.println("** Incorrect input: an integer is required **");
                    input.nextLine();
                }
            } while (continueInput);
            switch (select) {
                case 1:
                    //input view details
                    break;
                case 2:
                    //input Booking details
                    break;
                case 3:
                System.out.println("\n------------------------ Booking-------------------------");
                System.out.print("\nDestination: ");
                String destination = input.nextLine();
            
                System.out.print("Onward Time (7am / 10am / 5pm / 8pm): ");
                int onwardTime = input.nextInt();
        
                System.out.print("Quantity: ");
                int quantity = input.nextInt();
        
                if(destination.equalsIgnoreCase("Selangor")){
                    price = getPrice(selangorPrice, onwardTime);
                }
                else if(destination.equalsIgnoreCase("Pulau Pinang")){
                    price = getPrice(pulauPngPrice, onwardTime);
                }
                else if(destination.equalsIgnoreCase("Johor Bahru")){
                    price = getPrice(johorPrice, onwardTime);
                }
                else if(destination.equalsIgnoreCase("Negeri Sembilan")){
                    price = getPrice(negeriSemPrice, onwardTime);
                }
                else if(destination.equalsIgnoreCase("Melaka")){
                    price = getPrice(melakaPrice, onwardTime);
                }
                else if(destination.equalsIgnoreCase("Kelantan")){
                    price = getPrice(kelatanPrice, onwardTime);
                }
                else if(destination.equalsIgnoreCase("Perak")){
                    price = getPrice(perakPrice, onwardTime);  
                }
                
                amount = calcAmount(price, quantity);
                System.out.println("Total: RM" + amount);
        
                proceedPayment(price, quantity, amount);
                break;
                case 4:
                UpdateBusMenu(busList);
                    break;
                default:
                    System.out.println("Exit Page");
            }
        } while (select != 5);    
    }  

    public static void proceedPayment(int price, int quantity, int amount){
    Scanner input = new Scanner(System.in);
    int paymentMethod, eWalletOption, bankOption;
    boolean continueInput = true;
    double amountReceived, otherCashReceived, balanceDue;
    long creditCardNum, accountNum;
    int payCode;
    boolean transactionFailed;
    int receiptNo;

    do{
        try{
            do{
                transactionFailed = false;
                //print payment menu
                System.out.print("*********************\n");
                System.out.print("** Payment  Method **\n");
                System.out.print("*********************\n");
                System.out.print("* 1. Cash           *\n");
                System.out.print("* 2. Credit Card    *\n");
                System.out.print("* 3. E-wallet       *\n");
                System.out.print("* 4. Online Banking *\n");
                System.out.print("*********************\n");
                
                //ask user which payment they want
                System.out.print("Select a payment method : ");
                paymentMethod = input.nextInt();

                switch(paymentMethod) {
                    case 1:
                        do{
                            try{
                                Cash byCash = new Cash();
                                byCash.calcServiceCharge(amount);//get the service charge
                                byCash.calcTotalIncludeSC(amount);//get the total include service charge
                                //get user input (cash tendered)
                                System.out.println("\nCash");
                                System.out.println("====");
                                System.out.printf("Amount to Pay : RM %.2f\n", byCash.getTotalIncludeSC());
                                System.out.print("Pay : RM ");
                                amountReceived = input.nextDouble();
                                byCash.setCashTendered(amountReceived);
                                byCash.paymentBalance(byCash.getTotalIncludeSC());

                                //check is the cash tendered correct or not
                                if (byCash.getBalance() < 0){
                                    balanceDue = Math.abs(byCash.getBalance());
                                    System.out.printf("Insufficient payment amount! Please pay the remaining balance.\nBalance Due : RM %.2f\n", balanceDue);
                                    do {
                                        System.out.print("Enter amount of remaining balance received : RM ");
                                        otherCashReceived = input.nextDouble();
                                        byCash.setOtherCashReceived(otherCashReceived);
                                        byCash.calculateTotalAmountReceived();
                                        if (otherCashReceived < balanceDue) {
                                            System.out.println("Please pay in full for the remaining balance");
                                        }
                                    } while (otherCashReceived < balanceDue);
                                    byCash.setCashTendered(otherCashReceived);
                                    byCash.paymentBalance(balanceDue);
                                    System.out.printf("Change : RM %.2f\n", byCash.getBalance());
                                } else {
                                    byCash.calculateTotalAmountReceived();
                                    System.out.printf("Change : RM %.2f\n", byCash.getBalance());
                                }
                                //print receipt
                                receiptNo = byCash.getReceiptNo();
                                receipt receipt1 = new receipt(price, quantity, amount, receiptNo);
                                receipt1.printReceipt();
                                continueInput = false;
                            } catch (InputMismatchException inputMismatchException){
                                System.out.println("Please input correctly, you should enter a number only.");
                                input.nextLine();
                            }
                        }while(continueInput);
                        break;
                    case 2:
                        do{
                            try{
                                CreditCard byCrCard = new CreditCard();
                                byCrCard.calcServiceCharge(amount);//get the service charge
                                byCrCard.calcTotalIncludeSC(amount);//get the total include service charge

                                //get user input credit card number
                                System.out.println("\nCredit Card");
                                System.out.println("===========");
                                System.out.print("Enter credit card number : ");
                                creditCardNum = input.nextLong();
                                input.nextLine();
                                byCrCard.setCardNum(creditCardNum);
                                if(byCrCard.validateCardNum()){
                                    byCrCard.creditCardType();
                                    System.out.println("Card Type: " + byCrCard.getCardType());
                                    System.out.println(String.valueOf(byCrCard.getCardNum()).replaceAll("\\w(?=\\w{4})", "*"));
                                    System.out.println("Transaction Successful !");
                                } else {
                                    transactionFailed = true;
                                    System.out.println("Transaction Failed due to invalid credit card number!"); //transaction faiiled , order cancelled? select other payment method ? enter again
                                }
                                //print receipt
                                receiptNo = byCrCard.getReceiptNo();
                                receipt receipt2 = new receipt(price, quantity, amount, receiptNo);
                                receipt2.printReceipt();
                                continueInput = false;
                            } catch (InputMismatchException inputMismatchException){
                                System.out.println("Please input correctly, you should enter a number only.");
                                input.nextLine();
                            }
                        }while (continueInput);
                        break;
                    case 3:
                        do{
                            try{
                                do{
                                    System.out.println("\nE-wallet");
                                    System.out.println("========");
                                    System.out.println("+--------------------------------+");
                                    System.out.println("|    1. Touch'n Go eWallet       |");
                                    System.out.println("|    2. Boost                    |");
                                    System.out.println("|    3. ShopeePay                |");
                                    System.out.println("+--------------------------------+");
                                    System.out.print("Select an eWallet payment option : ");
                                    eWalletOption = input.nextInt();
                                    input.nextLine();
                                    switch (eWalletOption) {
                                        case 1:
                                            Ewallet byTouchnGo = new Ewallet();
                                            byTouchnGo.calcServiceCharge(amount);//get the service charge
                                            byTouchnGo.calcTotalIncludeSC(amount);//get the total include service charge
                                            byTouchnGo.generatePaymentCode();
                                            System.out.println("\nPayment Code: " + byTouchnGo.getPaymentCode());
                                            System.out.println("Please enter this code in your eWallet to proceed the payment.");
                                            System.out.print("Enter pay code (xxxx) : ");
                                            payCode = input.nextInt();
                                            byTouchnGo.setPayCode(payCode);
                                            if (byTouchnGo.validatePayCode()) {
                                                byTouchnGo.ewalletType(eWalletOption);
                                                System.out.println(byTouchnGo.getType());
                                                System.out.println("Transaction Successful !");
                                            } else {
                                                transactionFailed = true;
                                                System.out.println("Transaction Failed due to invalid pay code!");
                                            }
                                            //print receipt
                                            receiptNo = byTouchnGo.getReceiptNo();
                                            receipt receipt3 = new receipt(price, quantity, amount, receiptNo);
                                            receipt3.printReceipt();
                                            break;
                                        case 2:
                                            Ewallet byBoost = new Ewallet();
                                            byBoost.calcServiceCharge(amount);//get the service charge
                                            byBoost.calcTotalIncludeSC(amount);//get the total include service charge
                                            byBoost.generatePaymentCode();
                                            System.out.println("\nPayment Code: " + byBoost.getPaymentCode());
                                            System.out.println("Please enter this code in your eWallet to proceed the payment.");
                                            System.out.print("Enter pay code (xxxx) : ");
                                            payCode = input.nextInt();
                                            byBoost.setPayCode(payCode);
                                            if (byBoost.validatePayCode()) {
                                                byBoost.ewalletType(eWalletOption);
                                                System.out.println(byBoost.getType());
                                                System.out.println("Transaction Successful !");
                                            } else {
                                                transactionFailed = true;
                                                System.out.println("Transaction Failed due to invalid pay code!");
                                            }
                                            //print receipt
                                            receiptNo = byBoost.getReceiptNo();
                                            receipt receipt4 = new receipt(price, quantity, amount, receiptNo);
                                            receipt4.printReceipt();
                                            break;
                                        case 3:
                                            Ewallet byShopeePay = new Ewallet();
                                            byShopeePay.calcServiceCharge(amount);//get the service charge
                                            byShopeePay.calcTotalIncludeSC(amount);//get the total include service charge
                                            byShopeePay.generatePaymentCode();
                                            System.out.println("\nPayment Code: " + byShopeePay.getPaymentCode());
                                            System.out.println("Please enter this code in your eWallet to proceed the payment.");
                                            System.out.print("Enter pay code (xxxx) : ");
                                            payCode = input.nextInt();
                                            byShopeePay.setPayCode(payCode);
                                            if (byShopeePay.validatePayCode()) {
                                                byShopeePay.ewalletType(eWalletOption);
                                                System.out.println(byShopeePay.getType());
                                                System.out.println("Transaction Successful !");
                                            } else {
                                                transactionFailed = true;
                                                System.out.println("Transaction Failed due to invalid pay code!");
                                            }
                                            //print receipt
                                            receiptNo = byShopeePay.getReceiptNo();
                                            receipt receipt5 = new receipt(price, quantity, amount, receiptNo);
                                            receipt5.printReceipt();
                                            break;
                                        default:
                                            System.out.println("Invalid input, please enter again");
                                    }
                                }while(eWalletOption != 1 && eWalletOption != 2 && eWalletOption != 3);
                                continueInput = false;
                            }catch (InputMismatchException inputMismatchException){
                                System.out.println("Please input correctly, you should enter a number only.");
                                input.nextLine();
                            }
                        }while (continueInput);
                        break;
                    case 4:
                        do{
                            try{
                                do{
                                    System.out.println("\n Online Banking");
                                    System.out.println("=================");
                                    System.out.println("+--------------------------------+");
                                    System.out.println("|    1. Public Bank              |");
                                    System.out.println("|    2. Maybank                  |");
                                    System.out.println("|    3. CIMB Bank                |");
                                    System.out.println("|    4. RHB Bank                 |");
                                    System.out.println("+--------------------------------+");
                                    System.out.print("Select an online banking option : ");
                                    bankOption = input.nextInt();
                                    input.nextLine();
                                    switch (bankOption) {
                                        case 1:
                                            OnlineBanking byPbBank = new OnlineBanking();
                                            byPbBank.calcServiceCharge(amount);//get the service charge
                                            byPbBank.calcTotalIncludeSC(amount);//get the total include service charge
                                            System.out.print("\nEnter account number : ");
                                            accountNum = input.nextLong();
                                            input.nextLine();
                                            byPbBank.setAccountNum(accountNum);
                                            System.out.print("Enter pay code (xxxx) : ");
                                            payCode = input.nextInt();
                                            byPbBank.setPayCode(payCode);
                                            if(byPbBank.validateAccountNum(bankOption)){
                                                if(byPbBank.validatePayCode()){
                                                    byPbBank .setBankName(bankOption);
                                                    System.out.println("Bank: " + byPbBank.getBankName());
                                                    System.out.println("Transaction Successful !");
                                                }
                                            } else {
                                                transactionFailed = true;
                                                System.out.println("Transaction Failed due to invalid credit card number!"); //transaction faiiled , order cancelled? select other payment method ? enter again
                                            }
                                            //print receipt
                                            receiptNo = byPbBank.getReceiptNo();
                                            receipt receipt6 = new receipt(price, quantity, amount, receiptNo);
                                            receipt6.printReceipt();
                                            break;
                                        case 2:
                                            OnlineBanking byMBank = new OnlineBanking();
                                            byMBank.calcServiceCharge(amount);//get the service charge
                                            byMBank.calcTotalIncludeSC(amount);//get the total include service charge
                                            System.out.print("\nEnter account number : ");
                                            accountNum = input.nextLong();
                                            input.nextLine();
                                            byMBank.setAccountNum(accountNum);
                                            System.out.print("Enter pay code (xxxx) : ");
                                            payCode = input.nextInt();
                                            byMBank.setPayCode(payCode);
                                            if(byMBank.validateAccountNum(bankOption)){
                                                if(byMBank.validatePayCode()){
                                                    byMBank.setBankName(bankOption);
                                                    System.out.println("Bank: " + byMBank.getBankName());
                                                    System.out.println("Transaction Successful !");
                                                }
                                            } else {
                                                transactionFailed = true;
                                                System.out.println("Transaction Failed due to invalid credit card number!"); //transaction faiiled , order cancelled? select other payment method ? enter again
                                            }
                                            //print receipt
                                            receiptNo = byMBank.getReceiptNo();
                                            receipt receipt7 = new receipt(price, quantity, amount, receiptNo);
                                            receipt7.printReceipt();
                                            
                                            break;
                                        case 3:
                                            OnlineBanking byCimBank = new OnlineBanking();
                                            byCimBank.calcServiceCharge(amount);//get the service charge
                                            byCimBank.calcTotalIncludeSC(amount);//get the total include service charge
                                            System.out.print("\nEnter account number : ");
                                            accountNum = input.nextLong();
                                            input.nextLine();
                                            byCimBank.setAccountNum(accountNum);
                                            System.out.print("Enter pay code (xxxx) : ");
                                            payCode = input.nextInt();
                                            byCimBank.setPayCode(payCode);
                                            if(byCimBank.validateAccountNum(bankOption)){
                                                if(byCimBank.validatePayCode()){
                                                    byCimBank.setBankName(bankOption);
                                                    System.out.println("Bank: " + byCimBank.getBankName());
                                                    System.out.println("Transaction Successful !");
                                                }
                                            } else {
                                                transactionFailed = true;
                                                System.out.println("Transaction Failed due to invalid credit card number!"); //transaction faiiled , order cancelled? select other payment method ? enter again
                                            }
                                            //print receipt
                                            receiptNo = byCimBank.getReceiptNo();
                                            receipt receipt8 = new receipt(price, quantity, amount, receiptNo);
                                            receipt8.printReceipt();
                                           
                                            break;
                                        case 4:
                                            OnlineBanking byRhBank = new OnlineBanking();
                                            byRhBank.calcServiceCharge(amount);//get the service charge
                                            byRhBank.calcTotalIncludeSC(amount);//get the total include service charge
                                            System.out.print("\nEnter account number : ");
                                            accountNum = input.nextLong();
                                            input.nextLine();
                                            byRhBank.setAccountNum(accountNum);
                                            System.out.print("Enter pay code (xxxx) : ");
                                            payCode = input.nextInt();
                                            byRhBank.setPayCode(payCode);
                                            if(byRhBank.validateAccountNum(bankOption)){
                                                if(byRhBank.validatePayCode()){
                                                    byRhBank.setBankName(bankOption);
                                                    System.out.println("Bank: " + byRhBank.getBankName());
                                                    System.out.println("Transaction Successful !");
                                                }
                                            } else {
                                                transactionFailed = true;
                                                System.out.println("Transaction Failed due to invalid credit card number!"); //transaction faiiled , order cancelled? select other payment method ? enter again
                                            }
                                            //print receipt
                                            receiptNo = byRhBank.getReceiptNo();
                                            receipt receipt9 = new receipt(price, quantity, amount, receiptNo);
                                            receipt9.printReceipt();
                                            break;
                                        default:
                                            System.out.println("Invalid input, please enter again");
                                    }
                                }while(bankOption != 1 && bankOption != 2 && bankOption != 3);
                                continueInput = false;
                            }catch (InputMismatchException inputMismatchException){
                                System.out.println("Please input correctly, you should enter a number only.");
                                input.nextLine();
                            }
                        }while (continueInput);
                        break;
                    default:
                        System.out.println("Invalid input, please enter again");
                }
            }while (paymentMethod != 1 && paymentMethod != 2 && paymentMethod != 3 && paymentMethod != 4 || transactionFailed);
            continueInput = false;
        } catch(InputMismatchException inputMInputMismatchException){
            System.out.println("Please input correctly, you should enter a number only.");
            input.nextLine();
        }

    }while(continueInput);
}

    public static int calcAmount(int price, int quantity){
    return price * quantity;
}

    public static int getPrice(int[] priceArray, int onwardTime){

    if(onwardTime == 7){
        return priceArray[0];
    }
    else if(onwardTime == 10){
        return priceArray[1];
    }
    else if(onwardTime == 5){
        return priceArray[2];
    }
    else
        return priceArray[3];

}

    public static void UpdateBusMenu(ArrayList<Bus> busList) {
    int choice;
    boolean continueInput = true;
    Scanner scanner = new Scanner(System.in);
    do{	
        try{
            do{
                System.out.println(" -----------------------");
                System.out.println("|     Maintainance      |");
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
                            staff(busList);
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

        double price;
            do{
                System.out.println("Enter Price:");
                price = scanner.nextDouble();
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
        if(Bus.validateBusId(busID)==false){
            System.out.println("Bus ID cannot more than 3 characters,");
            System.out.println("Bus ID cannot more than 5 number");
            System.out.println("Please enter proper bus ID!");
        }
    }while(Bus.validateBusId(busID)==false);

    for(int i=0 ; i<busList.size() ; i++){
        if(busID.toUpperCase().compareTo(busList.get(i).getBusID())==0 || busID.equals(busList.get(i).getBusID())){
            
            int choice;
            boolean continueInput;
            String destination = "";
            String departureDate = "";
            String departureTime = "";
            double price = 0;
            int seatNo = 0;
            do{	
                System.out.println("\nWhat do you wish to modify ?"
                + "\n1.Destination"
                + "\n2.Departure Date"
                + "\n3.Departure Time"
                + "\n4.Price"
                + "\n5.Seat Available"
                + "\n6.Back to Menu");
                System.out.print("\n\n Please select(1-6) : ");
                choice = scanner.nextInt();
                switch (choice){
                    case 1:
                    
                        do{
                            System.out.println("Enter Destination:");
                            destination = scanner.nextLine();
                            if(Bus.validateDestination(destination)!=true){
                                System.out.println("Destination must be one of Selangor, Pulau Pinang, Johor Bahru, Negeri Sembilan, Melaka, Kelatan or Perak.");
                                System.out.println("Please enter proper destination!");
                            }
                        }while(Bus.validateDestination(destination)!=true);
                        break;
                    case 2:
                    
                        do{
                            System.out.println("Enter Departure Date:");
                            departureDate = scanner.nextLine();
                            if(Bus.validateDate(departureDate)!=true){
                                System.out.println("Departure date must be in dd/mm/yyyy format.");
                                System.out.println("Please enter proper departure date!");
                            }
                        }while(Bus.validateDate(departureDate)!=true);
                        break;
                    case 3:
                    
                        do{
                            System.out.println("Enter Departure Time:");
                            departureTime = scanner.nextLine();
                            if(Bus.validateTime(departureTime)!=true){
                                System.out.println("The departure time must be in xx:xx(am/pm) format.");
                                System.out.println("Please enter proper departure time!");
                            }
                        }while(Bus.validateTime(departureTime)!=true);
                        break;
                    case 4:
                    
                        do{
                            System.out.println("Enter Price:");
                            price = scanner.nextDouble();
                            if(Bus.validateprice(price)!=true){
                            System.out.println("The price cannot be zero or negative.");
                                System.out.println("Please enter proper price!");
                            }   
                        }while(Bus.validateprice(price)!=true);
                        break;
                    case 5:
                    
                        do{
                            System.out.println("Enter Seat Avaible:");
                            seatNo = scanner.nextInt();
                            if(Bus.validateSeatNo(seatNo)!=true){
                                System.out.println("The seat avaible cannot more than 30.");
                                System.out.println("Please enter proper seat avaible!");
                            }
                        }while(Bus.validateSeatNo(seatNo)!=true);
                        break;
                    case 6:
                        continueInput = false;
                        break;
                    default:
                        System.out.println("Invalid input, please enter again");
                }
            }while (choice !=6);

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

    public static void management(ArrayList<Details> usersList, ArrayList<Bus> busList) {

        Scanner scanner = new Scanner(System.in);
        int select = 0;
        boolean continueInput;
        do {
            continueInput = true;
            System.out.println("\nManagement Page");
            System.out.println("===============");
            System.out.println("1. Order Menu");
            System.out.println("2. Bus Details");
            System.out.println("3. Staff Management");
            System.out.println("4. Reports");
            System.out.println("5. Exit");
            do {
                try {
                    System.out.print("Please select one: ");
                    select = scanner.nextInt();
                    if (select > 0 && select < 6) {
                        continueInput = false;
                    } else {
                        System.err.println("** Please enter between 1 to 5 **");
                    }
                } catch (Exception ex) {
                    System.err.println("** Incorrect input: an integer is required **");
                    scanner.nextLine();
                }
            } while (continueInput);
            switch (select) {
                case 1:
                    orderMenu(busList);
                    break;
                case 2:
                    UpdateBusMenu(busList);
                    break;
                case 3:
                   staffPage(usersList);
                    break;
                case 4:
                    
                    break;
                default:
                    System.out.println("Exit Management Page");
            }
        } while (select != 5);
    }

    public static void orderMenu(ArrayList<Bus> busList) {
        Scanner input = new Scanner(System.in);
        int[] selangorPrice = {10,11,12,10};
        int[] pulauPngPrice = {40, 41, 42, 40};
        int[] johorPrice = {40, 41, 42, 40};
        int[] negeriSemPrice = {15, 16, 17, 18};
        int[] melakaPrice = {16, 17, 18, 16};
        int[] kelatanPrice = {42, 43, 44, 42};
        int[] perakPrice = {39, 40, 41, 39}; 
        int price = 0;
        int amount = 0;
        int select = 0;
        boolean continueInput;
        do {
            continueInput = true;
             // the MAIN MENU//
             System.out.println("********************************************");
             System.out.println("** BUS RESERVATION AND TICKETING SYSTEM   **");
             System.out.println("********************************************");
             System.out.println("** [1] View                               **");
             System.out.println("** [2] Booking                            **");
             System.out.println("** [3] Payment                            **");
             System.out.println("** [4] Exit                               **");
             System.out.println("********************************************");
             System.out.println("********************************************");  
            do {
                try {
                    System.out.print("Please select one: ");
                    select = input.nextInt();
                    if (select > 0 && select < 6) {
                        continueInput = false;
                    } else {
                        System.err.println("** Please enter between 1 to 5 **");
                    }
                } catch (Exception ex) {
                    System.err.println("** Incorrect input: an integer is required **");
                    input.nextLine();
                }
            } while (continueInput);
            switch (select) {
                case 1:
                    //input view details
                    break;
                case 2:
                    //input Booking details
                    break;
                case 3:
                System.out.println("\n------------------------ Booking-------------------------");
                System.out.print("\nDestination: ");
                String destination = input.nextLine();
            
                System.out.print("Onward Time (7am / 10am / 5pm / 8pm): ");
                int onwardTime = input.nextInt();
        
                System.out.print("Quantity: ");
                int quantity = input.nextInt();
        
                if(destination.equalsIgnoreCase("Selangor")){
                    price = getPrice(selangorPrice, onwardTime);
                }
                else if(destination.equalsIgnoreCase("Pulau Pinang")){
                    price = getPrice(pulauPngPrice, onwardTime);
                }
                else if(destination.equalsIgnoreCase("Johor Bahru")){
                    price = getPrice(johorPrice, onwardTime);
                }
                else if(destination.equalsIgnoreCase("Negeri Sembilan")){
                    price = getPrice(negeriSemPrice, onwardTime);
                }
                else if(destination.equalsIgnoreCase("Melaka")){
                    price = getPrice(melakaPrice, onwardTime);
                }
                else if(destination.equalsIgnoreCase("Kelantan")){
                    price = getPrice(kelatanPrice, onwardTime);
                }
                else if(destination.equalsIgnoreCase("Perak")){
                    price = getPrice(perakPrice, onwardTime);  
                }
                
                amount = calcAmount(price, quantity);
                System.out.println("Total: RM" + amount);
        
                proceedPayment(price, quantity, amount);
                break;
                default:
                    System.out.println("Exit Order Menu Page");
            }
        } while (select != 4);    
    }

    public static void staffPage(ArrayList<Details> usersList) {
        int choice;
        boolean continueInput = true;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                do {
                    System.out.println("\nStaff Page");
                    System.out.println("==========");
                    System.out.println("1. Add Staff");
                    System.out.println("2. Update Staff");
                    System.out.println("3. Remove Staff");
                    System.out.println("4. Display Staff");
                    System.out.println("5. Back To Main Menu");
                    System.out.print("Please enter your choice : ");
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            addStaff(usersList);
                            break;
                        case 2:
                            updateStaff(usersList);
                            break;
                        case 3:
                            removeStaff(usersList);
                            break;
                        case 4:
                            displayStaff(usersList);
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
                } while (choice != 5);
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Please enter again!");
                scanner.nextLine();
            }
        } while (continueInput);
    }

   public static void addStaff(ArrayList<Details> usersList) {

        Scanner scanner = new Scanner(System.in);

        char confirm;

        do {
            System.out.println("Add Staff");

            String staffID;
                do{
                   System.out.print("Enter Staff ID (Sxxxx):");
                   staffID = scanner.next();
                   if(Details.validateStaffID(staffID)!=true){
                       System.err.print("Please Enter Proper Staff ID!\n");
                   }
                }while(Details.validateStaffID(staffID)!=true);
            
            int staffPasscode = 0;
            
             do{
                 try{
                     
                   System.out.print("Enter Passcode :");
                   staffPasscode = scanner.nextInt();
                   if(Details.validatePasscode(staffPasscode)!=true){
                       System.err.print("Please Enter 4 integer!\n");
                   }
                 }catch (IndexOutOfBoundsException e) {
                  System.out.println("Error! Enter integer!\n");
                  }
                }while(Details.validatePasscode(staffPasscode)!=true);
       
             
            System.out.print("Enter Staff Name :");
            Scanner name = new Scanner(System.in);
            String staffName = name.nextLine();

            String staffICNo;
                do{
                   System.out.print("Enter IC Number(xxxxxx-xx-xxxx) :");
                   staffICNo = scanner.next();
                   if(Details.validateICNo(staffICNo)!=true){
                       System.err.print("Please Enter Proper IC Number!\n");
                   }
                }while(Detail.validateICNo(staffICNo)!=true);
            
             String staffPhoneNo;
                do{
                   System.out.print("Enter Phone Number with - :");
                   staffPhoneNo = scanner.next();
                   if(Details.validatePhoneNumber(staffPhoneNo)!=true){
                       System.err.print("Please Enter Proper Phone Number!\n");
                   }
                }while(Details.validatePhoneNumber(staffPhoneNo)!=true);

            char staffGender;
                do{
                   System.out.print("Enter Staff's Gender(F/M):");
                   staffGender = scanner.next().toUpperCase().charAt(0); 
                   if(Details.validateStaffGender(staffGender)!=true){
                       System.err.print("Please Enter F / M\n");
                   }
                }while(Detail.validateStaffGender(staffGender)!=true);   

            Details addstaffs = new Details(staffID, staffPasscode, staffName, staffICNo, staffPhoneNo, staffGender);
            try {
                addstaffs.addNewDetail(usersList);
                System.out.println("Success Added Staff! Total " + staffs.size() + " staff(s).");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error");
            }

            System.out.print("Do you want to add more staff? Yes(Y)/ No (N)?");
            confirm = scanner.next().trim().toUpperCase().charAt(0);
        } while (confirm == 'Y');

    }

   public static void updateStaff(ArrayList<Details> usersList) {

        Details staff = new Details();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Staff List");
        System.out.printf("%-10s %-10s %-30s %-15s %-15s %-10s\n", "Staff ID", "Passcode", "Staff Name", "IC Number", "Phone Number", "Gender");
        System.out.println("--------------------------------------------------------------------------------------------------");
        staff.displayDetail(usersList);

        
        String staffID;
        do{
            System.out.print("Enter the staff ID need to update (Sxxxx):");
            staffID = scanner.next();
            if(Details.validateStaffID(staffID)==false){
                System.err.print("Please Enter Proper Staff ID!\n");
                break;
            }
        }while(Details.validateStaffID(staffID)==false);
            
        for (int n = 0; n <= staffs.size() - 1; n++) {
            if (staffID.equals(staffs.get(n).getID())) {
                System.out.print("Enter the staff name :");
                Scanner name = new Scanner(System.in);
                String staffName = name.nextLine();
                
                int staffPasscode = 0;
            
                do{
                 try{
                     
                   System.out.print("Enter passcode:");
                   staffPasscode = scanner.nextInt();
                   if(Detail.validatePasscode(staffPasscode)!=true){
                       System.err.print("Please Enter 4 integer!\n");
                   }
                 }catch (IndexOutOfBoundsException e) {
                  System.out.println("Error! Enter integer!\n");
                  }
                }while(Detail.validatePasscode(staffPasscode)!=true);


                String staffICNo;
                do{
                   System.out.print("Enter IC Number(xxxxxx-xx-xxxx) :");
                   staffICNo = scanner.next();
                   if(a.validatePhoneNumber(staffICNo)!=true){
                       System.err.print("Please Enter Proper IC Number!\n");
                   }
                }while(Detail.validateICNo(staffICNo)!=true);
                
                
                
                String staffPhoneNo;
                do{
                   System.out.print("Enter Phone Number with - :");
                   staffPhoneNo = scanner.next();
                   if(Detail.validatePhoneNumber(staffPhoneNo)!=true){
                       System.err.print("Please Enter Proper Phone Number!\n");
                   }
                }while(Detail.validatePhoneNumber(staffPhoneNo)!=true);

                
                char staffGender;
                do{
                   System.out.print("Enter Staff's Gender(F/M):");
                   staffGender = scanner.next().toUpperCase().charAt(0); 
                   if(Detail.validateStaffGender(staffGender)){
                       System.err.print("Please Enter F / M\n");
                   }
                }while(Detail.validateStaffGender(staffGender)!=true);
            
                Detail updatestaff = new Detail(staffID, staffPasscode, staffName, staffICNo, staffPhoneNo, staffGender);
                updatestaff.modifyDetail(staffs, n);
                System.out.println("Staff's Details Updated!\n");
            }
        }
    }

  public static void removeStaff(ArrayList<Details> users) {

        Detail staff = new Detail();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Staff List");
        System.out.printf("%-10s %-10s %-30s %-15s %-15s %-10s\n", "Staff ID", "Passcode", "Staff Name", "IC Number", "Phone Number", "Gender");
        System.out.println("--------------------------------------------------------------------------------------------------");
        staff.displayDetail(users);
        
        
        String selectedID;
        do{
            System.out.print("Enter the staff ID want to remove (Sxxxxx):");
            selectedID = scanner.next();
            if(Detail.validateStaffID(selectedID)!=true){
                System.err.print("Please Enter Proper Staff ID!\n");
            }
        }while(Details.validateStaffID(selectedID)!=true);


        for (int m = 0; m <= users.size() - 1; m++) {
            if (selectedID.equals(users.get(m).getID())) {
                staff.deleteDetail(staffs, m);
                System.out.println(" Staff successful remove from list. ");
            }
        }
    }

    public static void displayStaff(ArrayList<Details> users) {

        Detail staff = new Detail();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Staff List");
        System.out.printf("%-10s %-10s %-30s %-15s %-15s %-10s\n", "Staff ID", "Passcode", "Staff Name", "IC Number", "Phone Number", "Gender");
        System.out.println("--------------------------------------------------------------------------------------------------");
        staff.displayDetail(users);

    }

}

