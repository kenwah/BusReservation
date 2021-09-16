package BusReservationSystem;

public class Reservation {
    //name, quantity, seat, destination,price
    private String name;
    private String destination;
    private String time;
    private int quantity;
    private int price;
    private int amount;

    public Reservation (String name, String destination, String time, int quantity, int price, int amount) {
        this.name = name;
        this.destination = destination;
        this.time = time;
        this.quantity = quantity;
        this.price = price;
        this.amount = amount;
    }

    public String getname(){
        return name;
    }
    public String getDestination(){
        return destination;
    }
    public String getTime(){
        return time;
    }
    
    public int getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }

    public int getAmount() {
        return amount;
    }


}
