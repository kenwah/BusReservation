package BusReservationSystem;

public class Cash extends Payment{
    private double cashTendered;
    private double otherCashReceived;
    private double totalAmountReceived;
    private double balance;
    private static int countCash = 0;

    //constructor
    public Cash(){
        countCash++;
    }

    //parameterized constructor
    public Cash(int receiptNo, double serviceCharge, double amount, double totalIncludeSC, double totalAmountReceived , double balance){
        super(receiptNo, serviceCharge, amount, totalIncludeSC);
        this.totalAmountReceived = totalAmountReceived;
        this.balance = balance;
        countCash++;
    }

    //getter for cash tendered
    public double getCashTendered() {
        return cashTendered;
    }

    //getter for other cash tendered when cash tendered not enough
    public double getOtherCashReceived() {
        return otherCashReceived;
    }

    public static int getCountCash() {
        return countCash;
    }

    //getter for total amount received
    public double getTotalAmountReceived() {
        return totalAmountReceived;
    }

    //getter for balance
    public double getBalance(){
        return balance;
    }

    //setter for cash tendered
    public void setCashTendered(double cashTendered) {
        this.cashTendered = cashTendered;
    }

    //setter for other cash tendered
    public void setOtherCashReceived(double otherCashReceived) {
        this.otherCashReceived = otherCashReceived;
    }

    //setter for balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    //method calculate the balance 
    public void paymentBalance(double amount){
        balance = cashTendered - amount;
    }

    public void calculateTotalAmountReceived(){
        totalAmountReceived = cashTendered + otherCashReceived;
    }

    //toString method
    public String toString(){
        return super.toString() +
                "\nCash Tendered: " + totalAmountReceived +
                "\nBalance: " + balance;
    }
}
