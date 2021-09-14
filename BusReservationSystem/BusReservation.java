package BusReservationSystem;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class BusReservation {
	
	static String Name;
	static int Destination;
	static int Amount;
	private static int[] seats = new int[30];
	public int reservation(String [] args, double price) throws IOException {

		int to = 0, z = 0;
		int available[] = new int[29];
		String BusId[] = new String[7];
  		double dest[] = new double [100];
		Scanner book = new Scanner(System.in);
		for (int i = 1; i < 4;) {

			// "available[]" is the SEAT AVAILABLE//
			// store 30 seats every destination [1-28]//
			for (int l = 0; l < 30; l++) {
				seats[l] = 0;
			}
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
				System.out.println("**    1)  7:00 A.M      |  RM " + price + " |   " + available[1] + "   **");
				System.out.println("**    2)  10:00 A.M     |  RM " + price + " |   " + available[2] + "   **");
				System.out.println("**    3)  5:00 P.M      |  RM " + price + " |   " + available[3] + "   **");
				System.out.println("**    4)  8:00 P.M      |  RM " + price + " |   " + available[4] + "   **");
				System.out.println("**----------------------------------------**");
				System.out.println("**  - PULAU PINANG      |        |        **");
				System.out.println("**    5)  7:00 A.M      |  RM " + price + " |   " + available[5] + "   **");
				System.out.println("**    6)  10:00 A.M     |  RM " + price + " |   " + available[6] + "   **");
				System.out.println("**    7)  5:00 P.M      |  RM " + price + " |   " + available[7] + "   **");
				System.out.println("**    8)  8:00 P.M      |  RM " + price + " |   " + available[8] + "   **");
				System.out.println("**----------------------------------------**");
				System.out.println("**  - JOHOR BAHRU       |        |        **");
				System.out.println("**    9)  7:00 A.M      |  RM " + price + " |   " + available[9] + "   **");
				System.out.println("**    10) 10:00 A.M     |  RM " + price + " |   " + available[10] + "   **");
				System.out.println("**    11) 5:00 P.M      |  RM " + price + " |   " + available[11] + "   **");
				System.out.println("**    12) 8:00 P.M      |  RM " + price + " |   " + available[12] + "   **");
				System.out.println("**----------------------------------------**");
				System.out.println("**  - NEGERI SEMBILAN   |        |        **");
				System.out.println("**    13) 7:00 A.M      |  RM " + price + " |   " + available[13] + "   **");
				System.out.println("**    14) 10:00 A.M     |  RM " + price + " |   " + available[14] + "   **");
				System.out.println("**    15) 5:00 P.M      |  RM " + price + " |   " + available[15] + "   **");
				System.out.println("**    16) 8:00 P.M      |  RM " + price + " |   " + available[16] + "   **");
				System.out.println("**----------------------------------------**");
				System.out.println("**  - MALAKA            |        |        **");
				System.out.println("**    17) 7:00 A.M      |  RM " + price + " |   " + available[17] + "   **");
				System.out.println("**    18) 10:00 A.M     |  RM " + price + " |   " + available[18] + "   **");
				System.out.println("**    19) 5:00 P.M      |  RM " + price + " |   " + available[19] + "   **");
				System.out.println("**    20) 8:00 P.M      |  RM " + price + " |   " + available[20] + "   **");
				System.out.println("**----------------------------------------**");
				System.out.println("**  - KELANTAN          |        |        **");
				System.out.println("**    21) 7:00 A.M      |  RM " + price + " |   " + available[21] + "   **");
				System.out.println("**    22) 10:00 A.M     |  RM " + price + " |   " + available[22] + "   **");
				System.out.println("**    23) 5:00 P.M      |  RM " + price + " |   " + available[23] + "   **");
				System.out.println("**    24) 8:00 P.M      |  RM " + price + " |   " + available[24] + "   **");
				System.out.println("**----------------------------------------**");
				System.out.println("**  - PERAK             |        |        **");
				System.out.println("**    25) 7:00 A.M      |  RM " + price + " |   " + available[25] + "   **");
				System.out.println("**    26) 10:00 A.M     |  RM " + price + " |   " + available[26] + "   **");
				System.out.println("**    27) 5:00 P.M      |  RM " + price + " |   " + available[27] + "   **");
				System.out.println("**    28) 8:00 P.M      |  RM " + price + " |   " + available[28] + "   **");
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
						
						System.out.print("\nENTER PASSENGER'S NAME: ");
						Name = book.nextLine();
						
					}

						x = 0;

						// if Passenger's Name already used, display error and go back to Inputing//
						
					}

					// inputing of Destination//
					// integers Only [1-28]//
					for (x = 1; x == 1;) {
						System.out.print("ENTER DESTINATION [number]: ");
						to = book.nextInt();

						// if Inputed integers are "<1" or ">28", display error and go back to Inputing//
						if (Destination < 1 || Destination > 28) {
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

					// convert the integer to string//
					String Dest[] = { " ", "SELANGOR 7AM", "SELANGOR 10AM", "SELANGOR 5PM", "SELANGOR 8PM",
							"PULAU PINANG 7AM", "PULAU PINANG 10AM", "PULAU PINANG 5PM", "PULAU PINANG 8PM",
							"JOHOR BAHRU 7AM", "JOHOR BAHRU 10AM", "JOHOR BAHRU 5PM", "JOHOR BAHRU 8PM",
							"NEGERI SEMBILAN 7AM", "NEGERI SEMBILAN 10AM", "NEGERI SEMBILAN 5PM", "NEGERI SEMBILAN 8PM",
							"MELAKA 7AM", "MELAKA 10AM", "MELAKA 5PM", "MELAKA 8PM", "KELANTAN 7AM", "KELANTAN 10AM",
							"KELANTAN 5PM", "KELANTAN 8PM", "PERAK 7AM", "PERAK 10AM", "PERAK 5PM", "PERAK 8PM", };
					double fare[] = { 0, 10, 11, 12, 10, 40, 41, 42, 40, 40, 41, 42, 40, 15, 16, 17, 15, 16, 17, 18, 16,
							42, 43, 44, 42, 39, 40, 41, 39 };
					String busID[] = { " ", "WZO 5989", "WAZ 1325", "WRT 7226", "WFS 2391", "WFK 1490", "WYF 6457",
							"WXI 1812", "WEE 5027", "WYP 0563", "WFP 9608", "WEO 7328", "WTD 9930", "WUO 4034",
							"WXR 2322", "WDY 3288", "WSB 1611", "WMQ 8787", "WEU 4211", "WZD 8826", "WRF 6736",
							"WTF 4522", "WFX 9128", "WGL 9060", "WYQ 4868", "WBY 5428", "WFN 6188", "WNX 0932",
							"WON 1539" };

					// converted integer to string, transfer to storage array//
					int Destination= Dest[to];
					ticketD[z][0] = fare[to];
					ticketB[z][2] = busID[to];

					// inputing for Number of Passenger's//
					for (x = 1; x == 1;) {
						System.out.print("HOW MANY PASSENGERS ARE YOU?: ");
						Amount = book.nextInt();

						// subtract the available seat by the the number inputed//
						for (int l = 0; i < 30; i++) {
							if (seats[l] == 0) {
							seats[l] = 1;
							available[to]=available[to]-1;
							return l + 1;
							print=1;
							}
							

								// if the subtracted available seat is "<0", display error//
								// add the inputed number to the subtracted seat, to back the original
								// seat//
								// display the available seat and back to the inputing//
								if (available[to] < 0) {
									System.out.print(
											"Sorry, We don't have seat available for " + Amount + " person\n");
									available[to] = available[to] - Amount;
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
					int print;
					if (print == 1) {
						System.out.println("\n***************************************");
						System.out.println("**        PASSENGER'S DETAILS        **");
						System.out.println("***************************************");
						System.out.println("PASSENGER'S NAME: " + Name);
						System.out.println("PASSENGER'S DESTINATION : " + Destination);
						System.out.println("FARE PRICE(PER PERSON): RM " + ticketD[z][0]);
						System.out.println("NO. OF PASSENGERS: " + Amount);
						System.out.println("BUS ID: " + ticketI[z][2]);
						System.out.println("***************************************");
						System.out.println("***************************************\n");
						ticketS[z][3] = "0";
						ticketD[z][3] = ((ticketI[z][0] - ticketI[z][1]) * ticketD[z][0]);
						x = 0;
					}
					z++;
				}
			}

		}}}
