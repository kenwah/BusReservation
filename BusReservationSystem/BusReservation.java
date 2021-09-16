package BusReservationSystem;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class BusReservation {

	public void reservation(ArrayList<Bus> busList){

		int to = 0,custAmount=0,s=0,f=0;
		String name[]=new String[20];
		int available[] = new int[29];
		String BusId[] = new String[7];
		String ticketDes[] = new String [100];
		double ticketFare[] = new double[3];
		String ticketBus[] = new String [100];
		int ticketSeat[] = new int [100];
		Scanner book = new Scanner(System.in);

		for (int i = 1; i < 4;) {

			// "available[]" is the SEAT AVAILABLE//
			// store 30 seats every destination [1-28]//
			
			for (int o = 1; o <= 28; o++) {
				available[o] = 30;
			}

			// if user and password are correct proceed to MAIN MENU//

			for (int x = 1; x == 1;) {

				int print = 1;

				// display first the Destination Details//
				System.out.println("********************************************");
				System.out.println("**   DESTINATION        |  FARE  |  SEAT  **");
				System.out.println("********************************************");
				System.out.println("**  - SELANGOR          |        |        **");
				System.out.println("**    1)  7:00 A.M      |  RM " + busList.get(0).getPrice() + " |   " + available[1] + "   **");
				System.out.println("**    2)  10:00 A.M     |  RM " + busList.get(1).getPrice() + " |   " + available[2] + "   **");
				System.out.println("**    3)  5:00 P.M      |  RM " + busList.get(2).getPrice() + " |   " + available[3] + "   **");
				System.out.println("**    4)  8:00 P.M      |  RM " + busList.get(3).getPrice() + " |   " + available[4] + "   **");
				System.out.println("**----------------------------------------**");
				System.out.println("**  - PULAU PINANG      |        |        **");
				System.out.println("**    5)  7:00 A.M      |  RM " + busList.get(4).getPrice() + " |   " + available[5] + "   **");
				System.out.println("**    6)  10:00 A.M     |  RM " + busList.get(5).getPrice() + " |   " + available[6] + "   **");
				System.out.println("**    7)  5:00 P.M      |  RM " + busList.get(6).getPrice() + " |   " + available[7] + "   **");
				System.out.println("**    8)  8:00 P.M      |  RM " + busList.get(7).getPrice() + " |   " + available[8] + "   **");
				System.out.println("**----------------------------------------**");
				System.out.println("**  - JOHOR BAHRU       |        |        **");
				System.out.println("**    9)  7:00 A.M      |  RM " + busList.get(8).getPrice() + " |   " + available[9] + "   **");
				System.out.println("**    10) 10:00 A.M     |  RM " + busList.get(9).getPrice() + " |   " + available[10] + "   **");
				System.out.println("**    11) 5:00 P.M      |  RM " + busList.get(10).getPrice() + " |   " + available[11] + "   **");
				System.out.println("**    12) 8:00 P.M      |  RM " + busList.get(11).getPrice() + " |   " + available[12] + "   **");
				System.out.println("**----------------------------------------**");
				System.out.println("**  - NEGERI SEMBILAN   |        |        **");
				System.out.println("**    13) 7:00 A.M      |  RM " + busList.get(12).getPrice() + " |   " + available[13] + "   **");
				System.out.println("**    14) 10:00 A.M     |  RM " + busList.get(13).getPrice() + " |   " + available[14] + "   **");
				System.out.println("**    15) 5:00 P.M      |  RM " + busList.get(14).getPrice() + " |   " + available[15] + "   **");
				System.out.println("**    16) 8:00 P.M      |  RM " + busList.get(15).getPrice() + " |   " + available[16] + "   **");
				System.out.println("**----------------------------------------**");
				System.out.println("**  - MALAKA            |        |        **");
				System.out.println("**    17) 7:00 A.M      |  RM " + busList.get(16).getPrice() + " |   " + available[17] + "   **");
				System.out.println("**    18) 10:00 A.M     |  RM " + busList.get(17).getPrice() + " |   " + available[18] + "   **");
				System.out.println("**    19) 5:00 P.M      |  RM " + busList.get(18).getPrice() + " |   " + available[19] + "   **");
				System.out.println("**    20) 8:00 P.M      |  RM " + busList.get(19).getPrice() + " |   " + available[20] + "   **");
				System.out.println("**----------------------------------------**");
				System.out.println("**  - KELANTAN          |        |        **");
				System.out.println("**    21) 7:00 A.M      |  RM " + busList.get(20).getPrice() + " |   " + available[21] + "   **");
				System.out.println("**    22) 10:00 A.M     |  RM " + busList.get(21).getPrice() + " |   " + available[22] + "   **");
				System.out.println("**    23) 5:00 P.M      |  RM " + busList.get(22).getPrice() + " |   " + available[23] + "   **");
				System.out.println("**    24) 8:00 P.M      |  RM " + busList.get(23).getPrice() + " |   " + available[24] + "   **");
				System.out.println("**----------------------------------------**");
				System.out.println("**  - PERAK             |        |        **");
				System.out.println("**    25) 7:00 A.M      |  RM " + busList.get(24).getPrice() + " |   " + available[25] + "   **");
				System.out.println("**    26) 10:00 A.M     |  RM " + busList.get(25).getPrice() + " |   " + available[26] + "   **");
				System.out.println("**    27) 5:00 P.M      |  RM " + busList.get(26).getPrice() + " |   " + available[27] + "   **");
				System.out.println("**    28) 8:00 P.M      |  RM " + busList.get(27).getPrice() + " |   " + available[28] + "   **");
				System.out.println("********************************************");
				System.out.println("********************************************\n");
				if ((available[1] == 0) && (available[2] == 0) && (available[3] == 0) && (available[4] == 0)
						&& (available[5] == 0) && (available[6] == 0) && (available[7] == 0) && (available[8] == 0)
						&& (available[9] == 0) && (available[10] == 0) && (available[11] == 0) && (available[12] == 0)
						&& (available[13] == 0) && (available[14] == 0) && (available[15] == 0) && (available[16] == 0)
						&& (available[17] == 0) && (available[18] == 0) && (available[19] == 0) && (available[20] == 0)
						&& (available[21] == 0) && (available[22] == 0) && (available[23] == 0) && (available[24] == 0)
						&& (available[25] == 0) && (available[26] == 0) && (available[27] == 0)
						&& (available[28] == 0)) {
					System.out.println("Sorry, We don't  have available seats for all Destination!");
					x = 0;

				}

				// inputing of Passenger's Name//
				else {
					for (x = 1; x == 1;) {
						for(int a=0;a<name.length;a++){
						System.out.print("\nENTER PASSENGER'S NAME: ");
						name[i] = book.nextLine();
						}
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
								if (available[to] == 0) {
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
					ticketDes[to] = busList.get(to).getDestination();
					ticketFare[to] = busList.get(to).getPrice();
					ticketBus[to] = busList.get(to).getBusID();
					ticketSeat[s] = seatID[s];
					

					// inputing for Number of Passenger's//
					for (x = 1; x == 1;) {
						System.out.print("HOW MANY PASSENGERS ARE YOU?: ");
						custAmount = book.nextInt();

						// subtract the available seat by the the number inputed//
						for (int p = 0; p < 30; p++) {
							if(to==p){
							available[to]=available[to]-1;
							print=1;
							}
							

								// if the subtracted available seat is "<0", display error//
								// add the inputed number to the subtracted seat, to back the original
								// seat//
								// display the available seat and back to the inputing//
								if (available[to] < 0) {
									System.out.print(
											"Sorry, We don't have seat available for " + custAmount + " person\n");
									available[to] = available[to] - custAmount;
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