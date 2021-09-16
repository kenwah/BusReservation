package BusReservationSystem;

public class reservationDetails {
    private String name;
    private int to;
    private int seat;
    private int custAmount;


    public String getname(){
        return name;
    }
    public int getdest(){
        return to;
    }
    public int getseat(){
        return seat;
    }
    public int getpassenger(){
        return custAmount;
    }
    public reservationDetails (String name, int dest, int seat) {
        this.name = name;
        this.to = dest;
        this.seat = seat;
    }
    
    @Override
    public String toString() {
        return "Your ticket's details: \n" +
                "Name: " + getname() + "\n" +
                "Destination: " + getdest() + "\n" +
                "Seat: " + getseat()  + "\n" +
                "Number of passenger: " + getpassenger()  + "\n" +
                "Thank You for traveling with us!";
    }
}
