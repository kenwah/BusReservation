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
    
}
