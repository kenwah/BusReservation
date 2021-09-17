package BusReservationSystem;

import java.util.Random;

public class Ewallet extends Payment{
    
    private String type; //use num let user choose tngowallet / boost / shopee pay*
    private String accountName;
    private int paymentCode;
    private int payCode;
    private static int countEwallet = 0;

    //costructor
    public Ewallet(){
        countEwallet++;
    }

    //parameterized constructor
    public Ewallet(int receiptNo, double serviceCharge, double amount, double totalIncludeSC, String type, String accountName, int paymentCode){
        super(receiptNo, serviceCharge, amount, totalIncludeSC);
        this.type = type;
        this.accountName = accountName;
        this.paymentCode = paymentCode;
        countEwallet++;
    }

     //getter for ewallet type
     public String getType() {
        return type;
    }

    public static int getCountEwallet() {
        return countEwallet;
    }

    //getter for payment code
    public int getPaymentCode() {
        return paymentCode;
    }

    //getter for payCode
    public int getPayCode() {
        return payCode;
    }

    //setter for payCode
   public void setPayCode(int payCode) {
       this.payCode = payCode;
   }

    //get type when after user choosed we only provide three options ewallet method 
    public void ewalletType(int ewalletOption){//use num let user choose tngowallet / boost / shopee pay*
        
        if(ewalletOption == 1){
            type = "Touch N Go Ewallet";
        }
        else if(ewalletOption == 2){
            type = "Boost";
        }
        else
            type = "ShopeePay";
    }

    //random give user a code for user to make payment in ewallet
    public void generatePaymentCode(){
        Random rand = new Random();
        paymentCode = rand.nextInt(10000);
    }

    //check code from user after they made payment
    @Override
    public boolean validatePayCode(){
        if(String.valueOf(payCode).charAt(1) != '2'){
            return false;
        }
        return true;
    }

    //toString method
    public String toString(){
        return "\nE-Wallet Type: " + type +
                "\nE-Wallet Account Name: " + accountName;
    }
}
