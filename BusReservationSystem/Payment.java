package BusReservationSystem;

import java.util.Date;
// import java.util.Scanner;
// import java.util.InputMismatchException;

public class Payment implements serviceCharge{

    //private Reservation booking;
    private int receiptNo;
    private Date paymentDate;
    private double serviceCharge;
    
    private double amount;
    private double totalIncludeSC;
    private static int count = 1000;
    
    //constructor
    public Payment(){
        this.receiptNo = count;
        count++;
    }

    //parameterized constructor
    public Payment(int receiptNo, double serviceCharge, double amount, double totalIncludeSC){
        this.receiptNo = count;
        this.serviceCharge = serviceCharge;
        this.amount = amount;
        this.totalIncludeSC = totalIncludeSC;
        paymentDate = new Date();
        count++;
    }

    //getter for receipt no
    public int getReceiptNo() {
        return receiptNo;
    }

    //getter for payment date
    public Date getPaymentDate() {
        return paymentDate;
    }

    //getter for service charge
    public double getServiceCharge() {
        return serviceCharge;
    }

    //gettter for amount
    public double getAmount() {
        return amount;
    }

    //getter for total include service charge
    public double getTotalIncludeSC() {
        return totalIncludeSC;
    }

    //setter for payment date
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    //polymorphism
    public boolean validatePayCode(){
        return true;
    }

    @Override
    public void calcServiceCharge(int amount){
        serviceCharge = (double) amount * SERVICE_CHARGE;
    }

    @Override
    public void calcTotalIncludeSC(int amount){
        totalIncludeSC = amount + serviceCharge;
    }
    
    public String toString(){
        return "Amount: " +  amount +
                "\nDate: " + paymentDate;
    }
}

//     public void proceedPayment(){

//         String place = booking.getDestination();

//         String time = booking.getTime();
    
//         int price = booking.getPrice();
    
//         int quantity = booking.getQuantity();
    
//         int total = booking.getAmount();

//         Scanner input = new Scanner(System.in);
//         int paymentMethod, eWalletOption, bankOption;
//         boolean continueInput = true;
//         double amountReceived, otherCashReceived, balanceDue;
//         long creditCardNum, accountNum;
//         int payCode;
//         boolean transactionFailed;
//         int receiptNo;

//         do{
//             try{
//                 do{
//                     transactionFailed = false;

//                     //print payment menu
//                     System.out.print("*********************\n");
//                     System.out.print("** Payment  Method **\n");
//                     System.out.print("*********************\n");
//                     System.out.print("* 1. Cash           *\n");
//                     System.out.print("* 2. Credit Card    *\n");
//                     System.out.print("* 3. E-wallet       *\n");
//                     System.out.print("* 4. Online Banking *\n");
//                     System.out.print("*********************\n");
                    
//                     //ask user which payment they want
//                     System.out.print("Select a payment method : ");
//                     paymentMethod = input.nextInt();

//                     switch(paymentMethod) {
//                         case 1:
//                             do{
//                                 try{
//                                     Cash byCash = new Cash();
//                                     byCash.calcServiceCharge(total);//get the service charge
//                                     byCash.calcTotalIncludeSC(total);//get the total include service charge
//                                     //get user input (cash tendered)
//                                     System.out.println("\nCash");
//                                     System.out.println("====");
//                                     System.out.printf("Amount to Pay : RM %.2f\n", byCash.getTotalIncludeSC());
//                                     System.out.print("Pay : RM ");
//                                     amountReceived = input.nextDouble();
//                                     byCash.setCashTendered(amountReceived);
//                                     byCash.paymentBalance(byCash.getTotalIncludeSC());

//                                     //check is the cash tendered correct or not
//                                     if (byCash.getBalance() < 0){
//                                         balanceDue = Math.abs(byCash.getBalance());
//                                         System.out.printf("Insufficient payment amount! Please pay the remaining balance.\nBalance Due : RM %.2f\n", balanceDue);
//                                         do {
//                                             System.out.print("Enter amount of remaining balance received : RM ");
//                                             otherCashReceived = input.nextDouble();
//                                             byCash.setOtherCashReceived(otherCashReceived);
//                                             byCash.calculateTotalAmountReceived();
//                                             if (otherCashReceived < balanceDue) {
//                                                 System.out.println("Please pay in full for the remaining balance");
//                                             }
//                                         } while (otherCashReceived < balanceDue);
//                                         byCash.setCashTendered(otherCashReceived);
//                                         byCash.paymentBalance(balanceDue);
//                                         System.out.printf("Change : RM %.2f\n", byCash.getBalance());
//                                     } else {
//                                         byCash.calculateTotalAmountReceived();
//                                         System.out.printf("Change : RM %.2f\n", byCash.getBalance());
//                                     }
//                                     //print receipt
//                                     receiptNo = byCash.getReceiptNo();
//                                     receipt receipt1 = new receipt(place, time, price, quantity, total, receiptNo);
//                                     receipt1.printReceipt();
//                                     continueInput = false;
//                                 } catch (InputMismatchException inputMismatchException){
//                                     System.out.println("Please input correctly, you should enter a number only.");
//                                     input.nextLine();
//                                 }
//                             }while(continueInput);
//                             break;
//                         case 2:
//                             do{
//                                 try{
//                                     CreditCard byCrCard = new CreditCard();
//                                     byCrCard.calcServiceCharge(total);//get the service charge
//                                     byCrCard.calcTotalIncludeSC(total);//get the total include service charge

//                                     //get user input credit card number
//                                     System.out.println("\nCredit Card");
//                                     System.out.println("===========");
//                                     System.out.print("Enter credit card number : "); //4440967484181607
//                                     creditCardNum = input.nextLong();
//                                     input.nextLine();
//                                     byCrCard.setCardNum(creditCardNum);
//                                     if(byCrCard.validateCardNum()){
//                                         byCrCard.creditCardType();
//                                         System.out.println("Card Type: " + byCrCard.getCardType());
//                                         System.out.println(String.valueOf(byCrCard.getCardNum()).replaceAll("\\w(?=\\w{4})", "*"));
//                                         System.out.println("Transaction Successful !");
//                                     } else {
//                                         transactionFailed = true;
//                                         System.out.println("Transaction Failed due to invalid credit card number!"); //transaction faiiled , order cancelled? select other payment method ? enter again
//                                         System.out.println("Please input again.\n\n");
//                                     }
//                                     //print receipt
//                                     receiptNo = byCrCard.getReceiptNo();
//                                     receipt receipt2 = new receipt(place, time, price, quantity, total, receiptNo);
//                                     receipt2.printReceipt();
//                                     continueInput = false;
//                                 } catch (InputMismatchException inputMismatchException){
//                                     System.out.println("Please input correctly, you should enter a number only.");
//                                     input.nextLine();
//                                 }
//                             }while (continueInput);
//                             break;
//                         case 3:
//                             do{
//                                 try{
//                                     do{
//                                         System.out.println("\nE-wallet");
//                                         System.out.println("========");
//                                         System.out.println("+--------------------------------+");
//                                         System.out.println("|    1. Touch'n Go eWallet       |");
//                                         System.out.println("|    2. Boost                    |");
//                                         System.out.println("|    3. ShopeePay                |");
//                                         System.out.println("+--------------------------------+");
//                                         System.out.print("Select an eWallet payment option : ");
//                                         eWalletOption = input.nextInt();
//                                         input.nextLine();
//                                         switch (eWalletOption) {
//                                             case 1:
//                                                 Ewallet byTouchnGo = new Ewallet();
//                                                 byTouchnGo.calcServiceCharge(total);//get the service charge
//                                                 byTouchnGo.calcTotalIncludeSC(total);//get the total include service charge
//                                                 byTouchnGo.generatePaymentCode();
//                                                 System.out.println("\nPayment Code: " + byTouchnGo.getPaymentCode());
//                                                 System.out.println("Please enter this code in your eWallet to proceed the payment.");
//                                                 System.out.print("Enter pay code (xxxx) : ");
//                                                 payCode = input.nextInt();
//                                                 byTouchnGo.setPayCode(payCode);
//                                                 if (byTouchnGo.validatePayCode()) {
//                                                     byTouchnGo.ewalletType(eWalletOption);
//                                                     System.out.println(byTouchnGo.getType());
//                                                     System.out.println("Transaction Successful !");
//                                                     //print receipt
//                                                     receiptNo = byTouchnGo.getReceiptNo();
//                                                     receipt receipt3 = new receipt(place, time, price, quantity, total, receiptNo);
//                                                     receipt3.printReceipt();
//                                                 } else {
//                                                     transactionFailed = true;
//                                                     System.out.println("Transaction Failed due to invalid pay code!");
//                                                     System.out.println("Please input again.\n\n");
//                                                 }
//                                                 break;
//                                             case 2:
//                                                 Ewallet byBoost = new Ewallet();
//                                                 byBoost.calcServiceCharge(total);//get the service charge
//                                                 byBoost.calcTotalIncludeSC(total);//get the total include service charge
//                                                 byBoost.generatePaymentCode();
//                                                 System.out.println("\nPayment Code: " + byBoost.getPaymentCode());
//                                                 System.out.println("Please enter this code in your eWallet to proceed the payment.");
//                                                 System.out.print("Enter pay code (xxxx) : ");
//                                                 payCode = input.nextInt();
//                                                 byBoost.setPayCode(payCode);
//                                                 if (byBoost.validatePayCode()) {
//                                                     byBoost.ewalletType(eWalletOption);
//                                                     System.out.println(byBoost.getType());
//                                                     System.out.println("Transaction Successful !");
//                                                     //print receipt
//                                                     receiptNo = byBoost.getReceiptNo();
//                                                     receipt receipt4 = new receipt(place, time, price, quantity, total, receiptNo);
//                                                     receipt4.printReceipt();
//                                                 } else {
//                                                     transactionFailed = true;
//                                                     System.out.println("Transaction Failed due to invalid pay code!");
//                                                     System.out.println("Please input again.\n\n");
//                                                 }
                                                
//                                                 break;
//                                             case 3:
//                                                 Ewallet byShopeePay = new Ewallet();
//                                                 byShopeePay.calcServiceCharge(total);//get the service charge
//                                                 byShopeePay.calcTotalIncludeSC(total);//get the total include service charge
//                                                 byShopeePay.generatePaymentCode();
//                                                 System.out.println("\nPayment Code: " + byShopeePay.getPaymentCode());
//                                                 System.out.println("Please enter this code in your eWallet to proceed the payment.");
//                                                 System.out.print("Enter pay code (xxxx) : ");
//                                                 payCode = input.nextInt();
//                                                 byShopeePay.setPayCode(payCode);
//                                                 if (byShopeePay.validatePayCode()) {
//                                                     byShopeePay.ewalletType(eWalletOption);
//                                                     System.out.println(byShopeePay.getType());
//                                                     System.out.println("Transaction Successful !");
//                                                     //print receipt
//                                                     receiptNo = byShopeePay.getReceiptNo();
//                                                     receipt receipt5 = new receipt(place, time, price, quantity,total, receiptNo);
//                                                     receipt5.printReceipt();
//                                                 } else {
//                                                     transactionFailed = true;
//                                                     System.out.println("Transaction Failed due to invalid pay code!");
//                                                     System.out.println("Please input again.\n\n");
//                                                 }
                                                
//                                                 break;
//                                             default:
//                                                 System.out.println("Invalid input, please enter again");
//                                         }
//                                     }while(eWalletOption != 1 && eWalletOption != 2 && eWalletOption != 3);
//                                     continueInput = false;
//                                 }catch (InputMismatchException inputMismatchException){
//                                     System.out.println("Please input correctly, you should enter a number only.");
//                                     input.nextLine();
//                                 }
//                             }while (continueInput);
//                             break;
//                         case 4:
//                             do{
//                                 try{
//                                     do{
//                                         System.out.println("\n Online Banking");
//                                         System.out.println("=================");
//                                         System.out.println("+--------------------------------+");
//                                         System.out.println("|    1. Public Bank              |");
//                                         System.out.println("|    2. Maybank                  |");
//                                         System.out.println("|    3. CIMB Bank                |");
//                                         System.out.println("|    4. RHB Bank                 |");
//                                         System.out.println("+--------------------------------+");
//                                         System.out.print("Select an online banking option : ");
//                                         bankOption = input.nextInt();
//                                         input.nextLine();
//                                         switch (bankOption) {
//                                             case 1:
//                                                 OnlineBanking byPbBank = new OnlineBanking();
//                                                 byPbBank.calcServiceCharge(total);//get the service charge
//                                                 byPbBank.calcTotalIncludeSC(total);//get the total include service charge
//                                                 System.out.print("\nEnter account number : ");
//                                                 accountNum = input.nextLong();
//                                                 input.nextLine();
//                                                 byPbBank.setAccountNum(accountNum);
//                                                 System.out.print("Enter pay code (xxxx) : ");
//                                                 payCode = input.nextInt();
//                                                 byPbBank.setPayCode(payCode);
//                                                 if(byPbBank.validateAccountNum(bankOption)){
//                                                     if(byPbBank.validatePayCode()){
//                                                         byPbBank .setBankName(bankOption);
//                                                         System.out.println("Bank: " + byPbBank.getBankName());
//                                                         System.out.println("Transaction Successful !");
//                                                         //print receipt
//                                                         receiptNo = byPbBank.getReceiptNo();
//                                                         receipt receipt6 = new receipt(place, time, price, quantity, total, receiptNo);
//                                                         receipt6.printReceipt();
//                                                     }
//                                                 } else {
//                                                     transactionFailed = true;
//                                                     System.out.println("Transaction Failed due to invalid credit card number!"); //transaction faiiled , order cancelled? select other payment method ? enter again
//                                                     System.out.println("Please input again.\n\n");
//                                                 }
                                                
//                                                 break;
//                                             case 2:
//                                                 OnlineBanking byMBank = new OnlineBanking();
//                                                 byMBank.calcServiceCharge(total);//get the service charge
//                                                 byMBank.calcTotalIncludeSC(total);//get the total include service charge
//                                                 System.out.print("\nEnter account number : ");
//                                                 accountNum = input.nextLong();
//                                                 input.nextLine();
//                                                 byMBank.setAccountNum(accountNum);
//                                                 System.out.print("Enter pay code (xxxx) : ");
//                                                 payCode = input.nextInt();
//                                                 byMBank.setPayCode(payCode);
//                                                 if(byMBank.validateAccountNum(bankOption)){
//                                                     if(byMBank.validatePayCode()){
//                                                         byMBank.setBankName(bankOption);
//                                                         System.out.println("Bank: " + byMBank.getBankName());
//                                                         System.out.println("Transaction Successful !");
//                                                         //print receipt
//                                                         receiptNo = byMBank.getReceiptNo();
//                                                         receipt receipt7 = new receipt(place, time, price, quantity, total, receiptNo);
//                                                         receipt7.printReceipt();
//                                                     }
//                                                 } else {
//                                                     transactionFailed = true;
//                                                     System.out.println("Transaction Failed due to invalid credit card number!"); //transaction faiiled , order cancelled? select other payment method ? enter again
//                                                     System.out.println("Please input again.\n\n");
//                                                 }
        
//                                                 break;
//                                             case 3:
//                                                 OnlineBanking byCimBank = new OnlineBanking();
//                                                 byCimBank.calcServiceCharge(total);//get the service charge
//                                                 byCimBank.calcTotalIncludeSC(total);//get the total include service charge
//                                                 System.out.print("\nEnter account number : ");
//                                                 accountNum = input.nextLong();
//                                                 input.nextLine();
//                                                 byCimBank.setAccountNum(accountNum);
//                                                 System.out.print("Enter pay code (xxxx) : ");
//                                                 payCode = input.nextInt();
//                                                 byCimBank.setPayCode(payCode);
//                                                 if(byCimBank.validateAccountNum(bankOption)){
//                                                     if(byCimBank.validatePayCode()){
//                                                         byCimBank.setBankName(bankOption);
//                                                         System.out.println("Bank: " + byCimBank.getBankName());
//                                                         System.out.println("Transaction Successful !");
//                                                         //print receipt
//                                                         receiptNo = byCimBank.getReceiptNo();
//                                                         receipt receipt8 = new receipt(place, time, price, quantity, total, receiptNo);
//                                                         receipt8.printReceipt();
//                                                     }
//                                                 } else {
//                                                     transactionFailed = true;
//                                                     System.out.println("Transaction Failed due to invalid credit card number!"); //transaction faiiled , order cancelled? select other payment method ? enter again
//                                                     System.out.println("Please input again.\n\n");
//                                                 }
                                            
//                                                 break;
//                                             case 4:
//                                                 OnlineBanking byRhBank = new OnlineBanking();
//                                                 byRhBank.calcServiceCharge(total);//get the service charge
//                                                 byRhBank.calcTotalIncludeSC(total);//get the total include service charge
//                                                 System.out.print("\nEnter account number : ");
//                                                 accountNum = input.nextLong();
//                                                 input.nextLine();
//                                                 byRhBank.setAccountNum(accountNum);
//                                                 System.out.print("Enter pay code (xxxx) : ");
//                                                 payCode = input.nextInt();
//                                                 byRhBank.setPayCode(payCode);
//                                                 if(byRhBank.validateAccountNum(bankOption)){
//                                                     if(byRhBank.validatePayCode()){
//                                                         byRhBank.setBankName(bankOption);
//                                                         System.out.println("Bank: " + byRhBank.getBankName());
//                                                         System.out.println("Transaction Successful !");
//                                                         //print receipt
//                                                         receiptNo = byRhBank.getReceiptNo();
//                                                         receipt receipt9 = new receipt(place, time, price, quantity, total, receiptNo);
//                                                         receipt9.printReceipt();
//                                                     }
//                                                 } else {
//                                                     transactionFailed = true;
//                                                     System.out.println("Transaction Failed due to invalid credit card number!"); //transaction faiiled , order cancelled? select other payment method ? enter again
//                                                     System.out.println("Please input again.\n\n");
//                                                 }
                                                
//                                                 break;
//                                             default:
//                                                 System.out.println("Invalid input, please enter again");
//                                         }
//                                     }while(bankOption != 1 && bankOption != 2 && bankOption != 3);
//                                     continueInput = false;
//                                 }catch (InputMismatchException inputMismatchException){
//                                     System.out.println("Please input correctly, you should enter a number only.");
//                                     input.nextLine();
//                                 }
//                             }while (continueInput);
//                             break;
//                         default:
//                             System.out.println("Invalid input, please enter again");
//                     }
//                 }while (paymentMethod != 1 && paymentMethod != 2 && paymentMethod != 3 && paymentMethod != 4 || transactionFailed);
//                 continueInput = false;
//             } catch(InputMismatchException inputMInputMismatchException){
//                 System.out.println("Please input correctly, you should enter a number only.");
//                 input.nextLine();
//             }

//         }while(continueInput);
//     }
// }
