package BusReservationSystem;

public class displayDetails {
    static void CustomerDetails(String name[], String ticketDes[], int ticketFare[], int ticketSeat[], int custAmount,int to, String ticketBus[],int s) {
        System.out.println("\n***************************************");
        System.out.println("**        PASSENGER'S DETAILS        **");
        System.out.println("***************************************");
        System.out.println("PASSENGER'S NAME: " + name[0]);
        System.out.println("PASSENGER'S DESTINATION : " + ticketDes[to]);
        System.out.println("FARE PRICE(PER PERSON): RM " + ticketFare[to]);
        System.out.println("NO. OF PASSENGERS: " + custAmount);
        System.out.println("SEAT: " + ticketSeat[s]);
        System.out.println("BUS ID: " + ticketBus[to]);
        System.out.println("***************************************");
        System.out.println("***************************************\n");
    }

    public static void CustomerDetails(String[] name, String[] ticketDes, double[] ticketFare, int[] ticketSeat,
            int custAmount, int to, String[] ticketBus, int s) {
    };
}