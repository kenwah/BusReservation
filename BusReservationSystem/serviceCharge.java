package BusReservationSystem;

public interface serviceCharge {
    static final double SERVICE_CHARGE = 0.02;

    public void calcServiceCharge(int amount);

    public void calcTotalIncludeSC(int amount);
        
}
