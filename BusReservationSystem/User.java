package BusReservationSystem;

public class User extends Details{
	
   public User(String ID, int passcode, String name, String ICNo, String phoneNo ,char gender) 
   {
       super(ID, passcode, name, ICNo, phoneNo, gender);
   }

   @Override
   public String toString() 
   {
       return super.toString();
   }
   
}
