package BusReservationSystem;

import java.util.Scanner;
import java.util.ArrayList;

public class BusReservation {

	public void reservation(ArrayList<Bus> busList){

		int to = 0,custAmount=0,s=0;
		String name[]=new String[20];
		String BusId[] = new String[7];
		int available[] = new int[27];
		String ticketDes[] = new String [100];
		double ticketFare[] = new double[3];
		String ticketBus[] = new String [100];
		int ticketSeat[] = new int [100];
		Scanner book = new Scanner(System.in);
		

		for (int i = 1; i < 4;) {

			for (int x = 1; x == 1;) {

				int print = 1;

				// display first the Destination Details//
				System.out.println("********************************************");
				System.out.println("**   DESTINATION        |  FARE  |  SEAT  **");
				System.out.println("********************************************");
				System.out.println("**  - " + busList.get(0).getDestination() + "          |        |        **");
				System.out.println("**    1)  " + busList.get(0).getDepartureTime() + "      |  RM " + busList.get(0).getPrice() + " |   " + busList.get(0).getSeatNo() + "   **");
				System.out.println("**    2)  " + busList.get(1).getDepartureTime() + "      |  RM " + busList.get(1).getPrice() + " |   " + busList.get(1).getSeatNo() + "   **");
				System.out.println("**    3)  " + busList.get(2).getDepartureTime() + "      |  RM " + busList.get(2).getPrice() + " |   " + busList.get(2).getSeatNo() + "   **");
				System.out.println("**    4)  " + busList.get(3).getDepartureTime() + "      |  RM " + busList.get(3).getPrice() + " |   " + busList.get(3).getSeatNo() + "   **");
				System.out.println("**----------------------------------------**");
				System.out.println("**  - " + busList.get(4).getDestination() + "      |        |        **");
				System.out.println("**    5)  " + busList.get(4).getDepartureTime() + "      |  RM " + busList.get(4).getPrice() + " |   " + busList.get(4).getSeatNo() + "   **");
				System.out.println("**    6)  " + busList.get(5).getDepartureTime() + "     |  RM " + busList.get(5).getPrice() + " |   " + busList.get(5).getSeatNo() + "   **");
				System.out.println("**    7)  " + busList.get(6).getDepartureTime() + "      |  RM " + busList.get(6).getPrice() + " |   " + busList.get(6).getSeatNo() + "   **");
				System.out.println("**    8)  " + busList.get(7).getDepartureTime() + "      |  RM " + busList.get(7).getPrice() + " |   " + busList.get(7).getSeatNo() + "   **");
				System.out.println("**----------------------------------------**");
				System.out.println("**  - " + busList.get(8).getDestination() + "       |        |        **");
				System.out.println("**    9)  " + busList.get(8).getDepartureTime() + "      |  RM " + busList.get(8).getPrice() + " |   " + busList.get(8).getSeatNo() + "   **");
				System.out.println("**    10) " + busList.get(9).getDepartureTime() + "     |  RM " + busList.get(9).getPrice() + " |   " + busList.get(9).getSeatNo() + "   **");
				System.out.println("**    11) " + busList.get(10).getDepartureTime() + "      |  RM " + busList.get(10).getPrice() + " |   " + busList.get(10).getSeatNo() + "   **");
				System.out.println("**    12) " + busList.get(11).getDepartureTime() + "      |  RM " + busList.get(11).getPrice() + " |   " + busList.get(11).getSeatNo() + "   **");
				System.out.println("**----------------------------------------**");
				System.out.println("**  - " + busList.get(12).getDestination() + "   |        |        **");
				System.out.println("**    13) " + busList.get(12).getDepartureTime() + "      |  RM " + busList.get(12).getPrice() + " |   " + busList.get(12).getSeatNo() + "   **");
				System.out.println("**    14) " + busList.get(13).getDepartureTime() + "     |  RM " + busList.get(13).getPrice() + " |   " + busList.get(13).getSeatNo() + "   **");
				System.out.println("**    15) " + busList.get(14).getDepartureTime() + "      |  RM " + busList.get(14).getPrice() + " |   " + busList.get(14).getSeatNo() + "   **");
				System.out.println("**    16) " + busList.get(15).getDepartureTime() + "      |  RM " + busList.get(15).getPrice() + " |   " + busList.get(15).getSeatNo() + "   **");
				System.out.println("**----------------------------------------**");
				System.out.println("**  - " + busList.get(16).getDestination() + "            |        |        **");
				System.out.println("**    17) " + busList.get(16).getDepartureTime() + "      |  RM " + busList.get(16).getPrice() + " |   " + busList.get(16).getSeatNo() + "   **");
				System.out.println("**    18) " + busList.get(17).getDepartureTime() + "     |  RM " + busList.get(17).getPrice() + " |   " + busList.get(17).getSeatNo() + "   **");
				System.out.println("**    19) " + busList.get(18).getDepartureTime() + "      |  RM " + busList.get(18).getPrice() + " |   " + busList.get(18).getSeatNo() + "   **");
				System.out.println("**    20) " + busList.get(19).getDepartureTime() + "      |  RM " + busList.get(19).getPrice() + " |   " + busList.get(19).getSeatNo() + "   **");
				System.out.println("**----------------------------------------**");
				System.out.println("**  - " + busList.get(20).getDestination() + "          |        |        **");
				System.out.println("**    21) " + busList.get(20).getDepartureTime() + "      |  RM " + busList.get(20).getPrice() + " |   " + busList.get(20).getSeatNo() + "   **");
				System.out.println("**    22) " + busList.get(21).getDepartureTime() + "     |  RM " + busList.get(21).getPrice() + " |   " + busList.get(21).getSeatNo() + "   **");
				System.out.println("**    23) " + busList.get(22).getDepartureTime() + "      |  RM " + busList.get(22).getPrice() + " |   " + busList.get(22).getSeatNo() + "   **");
				System.out.println("**    24) " + busList.get(23).getDepartureTime() + "      |  RM " + busList.get(23).getPrice() + " |   " + busList.get(23).getSeatNo() + "   **");
				System.out.println("**----------------------------------------**");
				System.out.println("**  - " + busList.get(24).getDestination() + "             |        |        **");
				System.out.println("**    25) " + busList.get(24).getDepartureTime() + "      |  RM " + busList.get(24).getPrice() + " |   " + busList.get(24).getSeatNo() + "   **");
				System.out.println("**    26) " + busList.get(25).getDepartureTime() + "     |  RM " + busList.get(25).getPrice() + " |   " + busList.get(25).getSeatNo() + "   **");
				System.out.println("**    27) " + busList.get(26).getDepartureTime() + "      |  RM " + busList.get(26).getPrice() + " |   " + busList.get(26).getSeatNo() + "   **");
				System.out.println("**    28) " + busList.get(27).getDepartureTime() + "      |  RM " + busList.get(27).getPrice() + " |   " + busList.get(27).getSeatNo() + "   **");
				System.out.println("********************************************");
				System.out.println("********************************************\n");
				if ((busList.get(0).getSeatNo() == 0) && (busList.get(1).getSeatNo() == 0) && (busList.get(2).getSeatNo() == 0) && (busList.get(3).getSeatNo() == 0)
						&& (busList.get(4).getSeatNo() == 0) && (busList.get(5).getSeatNo() == 0) && (busList.get(6).getSeatNo() == 0) && (busList.get(7).getSeatNo() == 0)
						&& (busList.get(8).getSeatNo() == 0) && (busList.get(9).getSeatNo() == 0) && (busList.get(10).getSeatNo() == 0) && (busList.get(11).getSeatNo() == 0)
						&& (busList.get(12).getSeatNo() == 0) && (busList.get(13).getSeatNo() == 0) && (busList.get(14).getSeatNo() == 0) && (busList.get(15).getSeatNo() == 0)
						&& (busList.get(16).getSeatNo() == 0) && (busList.get(17).getSeatNo() == 0) && (busList.get(18).getSeatNo() == 0) && (busList.get(19).getSeatNo() == 0)
						&& (busList.get(20).getSeatNo() == 0) && (busList.get(21).getSeatNo() == 0) && (busList.get(22).getSeatNo() == 0) && (busList.get(23).getSeatNo() == 0)
						&& (busList.get(24).getSeatNo() == 0) && (busList.get(25).getSeatNo() == 0) && (busList.get(26).getSeatNo() == 0) && busList.get(27).getSeatNo() == 0) {
					System.out.println("Sorry, We don't  have available seats for all Destination!");
					x = 0;

				}

				// inputing of Passenger's Name//
				else {
					for (x = 1; x == 1;) {
						for(int a=0;a<name.length;a++){
						System.out.print("\nENTER PASSENGER'S NAME: ");
						name[a] = book.nextLine();
						}
					

						
					
					// inputing of Destination//
					// integers Only [1-28]//
					for (x = 1; x == 1;) {
							System.out.print("ENTER DESTINATION [number]: ");
							to = book.nextInt();

							// if Inputed integers are "<1" or ">28", display error and go back to Inputing//
							if (to < 1 || to > 28) {
							System.out.println("Invalid Input!");
							x = 1;
							
						}
						// if available seat is equal to "Zero", display error and go back to Inputing//
						for (int d = 1; d <= 28; d++) {
							if (to == d) {
								if (busList.get(to).getSeatNo() == 0) {
									System.out.println("Sorry, We don't have available seat!");
									x = 1;
								}
								x = 0;
							}
						}
						
					}
					for (x = 1; x == 1;) {
						System.out.print("ENTER SEAT [from 1 to 30]: ");
						ticketSeat[s] = book.nextInt();

						// if Inputed integers are "<1" or ">30", display error and go back to Inputing//
						if (s < 1 || s > 30) {
						System.out.println("Invalid Input!");
						x = 1;
						
					}

					int seatID[]={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};

					// converted integer to string, transfer to storage array//
					ticketDes[to] = busList.get(to-1).getDestination();
					ticketFare[to] = busList.get(to-1).getPrice();
					ticketBus[to] = busList.get(to-1).getBusID();
					ticketSeat[s] = seatID[s];
					

					// inputing for Number of Passenger's//
					for (x = 1; x == 1;) {
						System.out.print("HOW MANY PASSENGERS ARE YOU?: ");
						custAmount = book.nextInt();

						// subtract the available seat by the the number inputed//
						for (int p = 0; p < 30; p++) {
							if(to==p){
								available[to]= busList.get(to).getSeatNo()-1;
							print=1;
							}
							
			
								if (busList.get(to).getSeatNo() < 0) {
									System.out.print(
											"Sorry, We don't have seat available for " + custAmount + " person\n");
											available[to] = busList.get(to).getSeatNo() - custAmount;
									System.out.print("We only have " + available[to] + " seat available\n");
									x = 1;
									print = 0;
								} else {
									x = 0;
								}
							}
						}

					}

					// print out of passengers details....
					if (print == 1) {
						System.out.println("\n***************************************");
						System.out.println("**        PASSENGER'S DETAILS        **");
						System.out.println("***************************************");
						System.out.println("PASSENGER'S NAME: " + name);
						System.out.println("PASSENGER'S DESTINATION : " + ticketDes[to]);
						System.out.println("FARE PRICE(PER PERSON): RM " + ticketFare[to]);
						System.out.println("NO. OF PASSENGERS: " + custAmount);
						System.out.println("SEAT: " + ticketSeat[s]);
						System.out.println("BUS ID: " + BusId[to]);
						System.out.println("***************************************");
						System.out.println("***************************************\n");
					}
				}
				book.close();	}
			}
		}
		
	}

}