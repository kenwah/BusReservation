public class Cash extends Payment{
    private double cashTendered;
    private double balance;

    //constructor
    public Cash(){}

    //parameterized constructor
    public Cash(double serviceCharge, double amount, double totalIncludeSC, double cashTendered , double balance){
        super(serviceCharge, amount, totalIncludeSC);
        this.cashTendered = cashTendered;
        this.balance = balance;
    }

    //getter for cash tendered
    public double getCashTendered() {
        return cashTendered;
    }

    //getter for balance
    public double getBalance(){
        return balance;
    }

    //setter for cash tendered
    public void setCashTendered(double cashTendered) {
        this.cashTendered = cashTendered;
    }

    //setter for balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    //method calculate the balance 
    public void paymentBalance(double amount){
        balance = cashTendered - amount;
    }

    //toString method
    public String toString(){
        return super.toString() +
                "\nCash Tendered: " + cashTendered +
                "\nBalance: " + balance;
    }
}
