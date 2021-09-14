package BusReservationSystem;

import java.util.Random;

public class Ewallet extends Payment{
    
    private String type; //use num let user choose tngowallet / boost / shopee pay*
    private String accountName;
    private int paymentCode;

    //costructor
    public Ewallet(){}

    //parameterized constructor
    public Ewallet(double serviceCharge, double amount, double totalIncludeSC, String type, String accountName, int paymentCode){
        super(serviceCharge, amount, totalIncludeSC);
        this.type = type;
        this.accountName = accountName;
        this.paymentCode = paymentCode;
    }

     //getter for ewallet type
     public String getType() {
        return type;
    }

    //getter for payment code
    public int getPaymentCode() {
        return paymentCode;
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

    //random give user a code later for check but actually not very useful
    public void generatePaymentCode(){
        Random rand = new Random();
        paymentCode = rand.nextInt(10000);
    }

    //toString method
    public String toString(){
        return super.toString() +
                "\nE-Waller Type: " + type +
                "\nE-Wallet Account Name: " + accountName;
    }
}
