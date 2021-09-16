package BusReservationSystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class receipt implements serviceCharge{
    
    private String place;
    private String time;
    private int price;
    private int quantity;
    private int total;
    private  double serviceCharge;
    private  double grandTotal;
    private int receiptNo;
    LocalDateTime date = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String currentDate = date.format(formatter);

    public receipt(){}

    public receipt(String place, String time, int price, int quantity, int total, int receiptNo){
        this.place = place;
        this.price = price;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
        this.receiptNo = receiptNo;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void calcServiceCharge(int total){
        serviceCharge = total * SERVICE_CHARGE;
    }

    @Override
    public void calcTotalIncludeSC(int total){
        grandTotal = total + serviceCharge;
    }

    public void printReceipt(){

        calcServiceCharge(total);
        calcTotalIncludeSC(total);
        System.out.println("\n\n************************************************************************************");
        System.out.printf("*        Receipt No: %d               Date & Time: %s        *\n", receiptNo, currentDate);
        System.out.println("************************************************************************************");
        System.out.println("*  Description       Price (RM)               Quantity               Total (RM)    *");
        System.out.printf("*%5s%s %10d %23d %25d       *\n",place, time, price, quantity, total);
        System.out.println("************************************************************************************");
        System.out.printf("*  Service Charge 2%%:                                              %.2f      *\n", serviceCharge);
        System.out.printf("*  Grandtotal:                                                      %.2f      *\n", grandTotal);
        System.out.println("************************************************************************************\n\n");
        
    }
}
