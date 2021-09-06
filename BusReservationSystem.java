import java.io.*;

public class BusReservationAndTicketingSystem {

	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String user, password, yn, search, again, choice;
		int to = 0, y = 1, z = 0, end = 0;
		int available[] = new int[29];
		int ticketI[][] = new int[100][3];
		String ticketS[][] = new String[100][4];
        String ticketB[][] = new String[100][4];
		double ticketD[][] = new double[100][4];
		double pay[] = new double[20];
		double change[] = new double[20];

		for (int i = 1; i < 4;) {
			System.out.print("Enter Username: ");
			user = in.readLine();
			System.out.print("Enter Password: ");
			password = in.readLine();

			// "available[]" is the SEAT AVAILABLE//
			// store 30 seats every destination [1-28]//
			for (int o = 1; o <= 28; o++) {
				available[o] = 30;
			}

			// if user and password are correct proceed to MAIN MENU//
			if (user.equals("1") && password.equals("1")) {

				for (int x = 1; x == 1;) {
					// the MAIN MENU//
					System.out.println("********************************************");
					System.out.println("** BUS RESERVATION AND TICKETING SYSTEM   **");
					System.out.println("********************************************");
					System.out.println("** [1] Serach                             **");
					System.out.println("** [2] Booking                            **");
					System.out.println("** [3] Payment                            **");
					System.out.println("** [4] View                               **");
					System.out.println("** [5] Exit                               **");
					System.out.println("********************************************");
					System.out.println("********************************************\n");

					for (x = 1; x == 1;) {
						System.out.print("ENTER CHOICE: ");
						choice = in.readLine();

						// if CHOICE is "1" display the DESTINATION//
						if (choice.equals("1")) {
							// the DESTINATION DETAILS//
							// display the "Destination", every destination "Fare", and the "Seat"
							// available//
							System.out.println("********************************************");
							System.out.println("**   DESTINATION        |  FARE  |  SEAT  **");
							System.out.println("********************************************");
							System.out.println("** 1.)SELANGOR          |  RM 10 |   " + available[1] + "   **");
							System.out.println("** 2.)MELAKA            |  RM 16 |   " + available[2] + "   **");
							System.out.println("** 3.)NEGERI SEMBILAN   |  RM 15 |   " + available[3] + "   **");
							System.out.println("** 4.)PERAK             |  RM 39 |   " + available[4] + "   **");
							System.out.println("** 5.)PULAU PINANG      |  RM 40 |   " + available[5] + "   **");
							System.out.println("** 5.)JOHOR BAHRU       |  RM 40 |   " + available[6] + "   **");
							System.out.println("** 5.)KELANTAN          |  RM 42 |   " + available[7] + "   **");
							System.out.println("********************************************");
							System.out.println("********************************************\n");
							x = 0;
						}

						// if CHOICE is "2" proceed to Ticket Booking//
						else if (choice.equals("2")) {
							int print = 1;

							// display first the Destination Details//
							System.out.println("********************************************");
							System.out.println("**   DESTINATION        |  FARE  |  SEAT  **");
							System.out.println("********************************************");
							System.out.println("**  - SELANGOR          |        |        **");
							System.out.println("**    1)  7:00 A.M      |  RM 10 |   " + available[1] + "   **");
							System.out.println("**    2)  10:00 A.M     |  RM 11 |   " + available[2] + "   **");
							System.out.println("**    3)  5:00 P.M      |  RM 12 |   " + available[3] + "   **");
							System.out.println("**    4)  8:00 P.M      |  RM 10 |   " + available[4] + "   **");
							System.out.println("**----------------------------------------**");
							System.out.println("**  - PULAU PINANG      |        |        **");
							System.out.println("**    5)  7:00 A.M      |  RM 40 |   " + available[5] + "   **");
							System.out.println("**    6)  10:00 A.M     |  RM 41 |   " + available[6] + "   **");
							System.out.println("**    7)  5:00 P.M      |  RM 42 |   " + available[7] + "   **");
							System.out.println("**    8)  8:00 P.M      |  RM 40 |   " + available[8] + "   **");
							System.out.println("**----------------------------------------**");
							System.out.println("**  - JOHOR BAHRU       |        |        **");
							System.out.println("**    9)  7:00 A.M      |  RM 40 |   " + available[9] + "   **");
							System.out.println("**    10) 10:00 A.M     |  RM 41 |   " + available[10] + "   **");
							System.out.println("**    11) 5:00 P.M      |  RM 42 |   " + available[11] + "   **");
							System.out.println("**    12) 8:00 P.M      |  RM 40 |   " + available[12] + "   **");
							System.out.println("**----------------------------------------**");
							System.out.println("**  - NEGERI SEMBILAN   |        |        **");
							System.out.println("**    13) 7:00 A.M      |  RM 15 |   " + available[13] + "   **");
							System.out.println("**    14) 10:00 A.M     |  RM 16 |   " + available[14] + "   **");
							System.out.println("**    15) 5:00 P.M      |  RM 17 |   " + available[15] + "   **");
							System.out.println("**    16) 8:00 P.M      |  RM 15 |   " + available[16] + "   **");
							System.out.println("**----------------------------------------**");
							System.out.println("**  - MALAKA            |        |        **");
							System.out.println("**    17) 7:00 A.M      |  RM 16 |   " + available[17] + "   **");
							System.out.println("**    18) 10:00 A.M     |  RM 17 |   " + available[18] + "   **");
							System.out.println("**    19) 5:00 P.M      |  RM 18 |   " + available[19] + "   **");
							System.out.println("**    20) 8:00 P.M      |  RM 16 |   " + available[20] + "   **");
							System.out.println("**----------------------------------------**");
							System.out.println("**  - KELANTAN          |        |        **");
							System.out.println("**    21) 7:00 A.M      |  RM 42 |   " + available[21] + "   **");
							System.out.println("**    22) 10:00 A.M     |  RM 43 |   " + available[22] + "   **");
							System.out.println("**    23) 5:00 P.M      |  RM 44 |   " + available[23] + "   **");
							System.out.println("**    24) 8:00 P.M      |  RM 42 |   " + available[24] + "   **");
							System.out.println("**----------------------------------------**");
							System.out.println("**  - PERAK             |        |        **");
							System.out.println("**    25) 7:00 A.M      |  RM 39 |   " + available[25] + "   **");
							System.out.println("**    26) 10:00 A.M     |  RM 40 |   " + available[26] + "   **");
							System.out.println("**    27) 5:00 P.M      |  RM 41 |   " + available[27] + "   **");
							System.out.println("**    28) 8:00 P.M      |  RM 39 |   " + available[28] + "   **");
							System.out.println("********************************************");
							System.out.println("********************************************\n");

							if ((available[1] == 0) && (available[2] == 0) && (available[3] == 0) && (available[4] == 0)
									&& (available[5] == 0) && (available[6] == 0) && (available[7] == 0)
									&& (available[8] == 0) && (available[9] == 0) && (available[10] == 0)
									&& (available[11] == 0) && (available[12] == 0) && (available[13] == 0)
									&& (available[14] == 0) && (available[15] == 0) && (available[16] == 0)
									&& (available[17] == 0) && (available[18] == 0) && (available[19] == 0)
									&& (available[20] == 0) && (available[21] == 0) && (available[22] == 0)
									&& (available[23] == 0) && (available[24] == 0) && (available[25] == 0)
									&& (available[26] == 0) && (available[27] == 0) && (available[28] == 0)) {
								System.out.println("Sorry, We don't  have available seats for all Destination!");
								x = 0;

							}

							// inputing of Passenger's Name//
							else {
								for (x = 1; x == 1;) {
									System.out.print("\nENTER PASSENGER'S NAME: ");
									ticketS[z][0] = in.readLine();

									x = 0;

									// if Passenger's Name already used, display error and go back to Inputing//
									for (int l = 0; l < z; l++) {
										if (ticketS[l][0].equalsIgnoreCase(ticketS[z][0])) {
											System.out.println("Sorry, Passenger's name have already used!");
											x = 1;
										}
									}
								}

								// inputing of Destination//
								// integers Only [1-28]//
								for (x = 1; x == 1;) {
									System.out.print("ENTER DESTINATION [number]: ");
									to = Integer.parseInt(in.readLine());

									// if Inputed integers are "<1" or ">5", display error and go back to Inputing//
									if (to < 1 || to > 28) {
										System.out.println("Invalid Input!");
										x = 1;
									}
									// if available seat is eqaul to "Zero", display error and go back to Inputing//
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
								String dest[] = { " ", "SELANGOR 7AM", "SELANGOR 10AM", "SELANGOR 5PM", "SELANGOR 8PM",
										"PULAU PINANG 7AM", "PULAU PINANG 10AM", "PULAU PINANG 5PM", "PULAU PINANG 8PM",
										"JOHOR BAHRU 7AM", "JOHOR BAHRU 10AM", "JOHOR BAHRU 5PM", "JOHOR BAHRU 8PM",
										"NEGERI SEMBILAN 7AM", "NEGERI SEMBILAN 10AM", "NEGERI SEMBILAN 5PM","NEGERI SEMBILAN 8PM",
										"MELAKA 7AM", "MELAKA 10AM", "MELAKA 5PM", "MELAKA 8PM",
										"KELANTAN 7AM", "KELANTAN 10AM", "KELANTAN 5PM", "KELANTAN 8PM", "PERAK 7AM",
										"PERAK 10AM", "PERAK 5PM", "PERAK 8PM", };
								double fare[] = { 0, 10, 11, 12, 10, 40, 41, 42, 40, 40, 41, 42, 40, 15, 16, 17, 15, 16,
										17, 18, 16, 42, 43, 44, 42, 39, 40, 41, 39 };
								String busID[]={" ","WZO 5989","WAZ 1325","WRT 7226","WFS 2391",
												"WFK 1490","WYF 6457","WXI 1812","WEE 5027",
												"WYP 0563","WFP 9608","WEO 7328","WTD 9930",
												"WUO 4034","WXR 2322","WDY 3288","WSB 1611",
												"WMQ 8787","WEU 4211","WZD 8826","WRF 6736",
												"WTF 4522","WFX 9128","WGL 9060","WYQ 4868",
												"WBY 5428","WFN 6188","WNX 0932","WON 1539"};

								// converted integer to string, transfer to storage array//
								ticketS[z][1] = dest[to];
								ticketD[z][0] = fare[to];
								ticketB[z][2] = busID[to];

								// inputing for Number of Passenger's//
								for (x = 1; x == 1;) {
									System.out.print("HOW MANY PASSENGERS ARE YOU?: ");
									ticketI[z][0] = Integer.parseInt(in.readLine());

									// subtract the available seat by the the number inputed//
									for (int p = 1; p <= 28; p++) {
										if (to == p) {
											print = 1;
											available[to] = available[to] - ticketI[z][0];

											// if the subtracted available seat is "<0", display error//
											// add the inputed number to the subtracted seat, to back the original
											// seat//
											// display the available seat and back to the inputing//
											if (available[to] < 0) {
												System.out.print("Sorry, We don't have seat available for "
														+ ticketI[z][0] + " person\n");
												available[to] = available[to] + ticketI[z][0];
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
									System.out.println("PASSENGER'S NAME: " + ticketS[z][0]);
									System.out.println("PASSENGER'S DESTINATION : " + ticketS[z][1]);
									System.out.println("FARE PRICE(PER PERSON): RM " + ticketD[z][0]);
									System.out.println("NO. OF PASSENGERS: " + ticketI[z][0]);
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

						else if (choice.equals("3")) {

					

						}

						else if (choice.equals("4")) {

							
						}

						else if (choice.equals("5")) {
							end = 1;
							x = 0;
							System.out.println("Thank You!");
						}

						else {
							System.out.println("Invalid Input!");
							x = 1;
						}
					}

					for (y = 1; y == 1;) {
						if (end == 1) {
							break;
						}
						System.out.print("Do you want another transaction? [Y/N]: ");
						yn = in.readLine();

						if (yn.equalsIgnoreCase("y")) {
							x = 1;
							y = 0;
						} else if (yn.equalsIgnoreCase("n")) {
							System.out.println("\nThank You!!!");
							break;
						} else {
							System.out.println("Invalid Input!!!");
							y = 1;
						}
					}
				}
				i = 4;
			} else {
				System.out.println("\nInvalid user or password!\n");
				i++;
			}

		}

	}

}