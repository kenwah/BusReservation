package BusReservationSystem;

public class Reservation {
    //name, quantity, seat, destination,price
    private String name;
    private String destination;
    private String time;
    private int seat;
    private int quantity;
    private int price;

    public Reservation (String name, String destination, String time, int seat, int quantity, int price) {
        this.name = name;
        this.destination = destination;
        this.time = time;
        this.seat = seat;
        this.quantity = quantity;
        this.price = price;
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
    public int getseat(){
        return seat;
    }
    public int price(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }

    


}
