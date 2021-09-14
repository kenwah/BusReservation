package BusReservationSystem;

import java.util.Date;

public class Payment {

    //private variables
    private int receiptNo;
    private Date paymentDate;
    private double serviceCharge;
    private static final double SERVICE_CHARGE = 0.02;
    private double amount;
    private double totalIncludeSC;
    private static int count = 1000;
    
    //constructor
    public Payment(){}

    //parameterized constructor
    public Payment(double serviceCharge, double amount, double totalIncludeSC){
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

    public void calcServiceCharge(){
        serviceCharge = amount * SERVICE_CHARGE;
    }

    public void calcTotalIncludeSC(){
        totalIncludeSC = amount + serviceCharge;
    }
    
    public String toString(){
        return "Amount: " +  amount +
                "\nDate: " + paymentDate;
    }

}
    
