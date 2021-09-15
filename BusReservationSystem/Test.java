package BusReservationSystem;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Test {

    public static void main(String[] args) {

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

}

// Selangor 7 10
// Selangor 10 11
// Selangor 5 12
// Selangor 8 10
// PulauPinang 7 40
// PulauPinang 10 41
// PulauPinang 5 42
// PulauPinang 8 40
// JohorBahru 7 40
// JohorBahru 10 41
// JohorBahru 5 42
// JohorBahru 8 40
// NegeriSembilan 7 15
// NegeriSembilan 10 16
// NegeriSembilan 5 17
// NegeriSembilan 8 15
// Melaka 7 16
// Melaka 10 17
// Melaka 5 18
// Melaka 8 16
// Kelantan 7 42
// Kelantan 10 43
// Kelantan 5 44
// Kelantan 8 42
// Perak 7 39
// Perak 10 40
// Perak 5 41
// Perak 8 39