import java.util.Scanner;
public class calculatorTest {
	// ERROR 1 -> no array change when its filled | ERROR 2 -> error when travel accompanied array | ERROR 3 -> Whats the higher price in array
	//MAIN
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		double totalPassengerToPay = 0;
		double travelAccompaniedToPay = 0;
		double[] lastTenPrices = new double[10];
		int menuSelectOption = 0;
		int k = 0;
		int z = 0;
		
		do {
			menuSelectOption = welcome();
			if (z==10) {
				z=0;
			}
			switch (menuSelectOption) {
				case 1:
					// ALONE
					String chooseRate = chooseFlightRate();
					totalPassengerToPay = rateSelectionMenu(chooseRate, totalPassengerToPay);
					System.out.println("Passenger, the final price of your flight will be: $" + totalPassengerToPay );
					lastTenPrices[z] = totalPassengerToPay;
					z++;
					totalPassengerToPay = 0;
					break;
					
				case 2:
					//ACCOMPANIED
					for (int i=1; i<4; i++) {
						if (i>1) {
							System.out.println(" ");
							System.out.println("Welcome Passenger " + i);
						}
					chooseRate = chooseFlightRate();
					totalPassengerToPay = rateSelectionMenu(chooseRate, totalPassengerToPay);
					System.out.println("Passenger " + i + ", the final price of your flight will be: $" + totalPassengerToPay );
					//ADD PRICES TO ARRAY
					if (i==1) {
					lastTenPrices[z] = totalPassengerToPay;
					}
					if (i>1) {
					z++;
					lastTenPrices[z] = totalPassengerToPay;
					}
					travelAccompaniedToPay = travelAccompaniedToPay+totalPassengerToPay;
					totalPassengerToPay = 0;
						if (i==3) {
							System.out.println("The total for the " + i + " passengers will be: $" + travelAccompaniedToPay);
							travelAccompaniedToPay = 0;
						}
					}
					break;
					
				case 3:
					// QUERY
					System.out.println("The lastest 10 flights prices are:");
					for (k = 0; k < lastTenPrices.length; k++) {
					System.out.println("Price # " + (k+1) + ": " + lastTenPrices[k]);
					}
					break;
				
				case 4:
					// END
					System.out.println("Thank you for use our services, hope to see you soon again.");
					break;
				
				default:
					System.out.println("You are typing a not valid selection.");
					
		}} while (menuSelectOption != 4);
	}
	
	// CONSTANTS
			public static final int PRICE_XS_RATE = 175000;
			public static final int PRICE_S_RATE = 218750;
			public static final int PRICE_M_RATE = 284375;
			public static final int EXTRA_SEAT_SELECT = 50000;
			public static final int EXTRA_SEAT_WINDOW_AISLE = 15000;
			public static final int EXTRA_TENKG_BAG = 50000;
			public static final int EXTRA_TWENTYTHREEKG_BAG = 100000;
			
	// -----BEGINNING OF METHODS-----
	
	// 1. Welcome | METHOD int
			/**
			*
			* This method will welcome the user and it will ask for a menu selection.
			*
			* @return menuSelectOption
			*
			*/
			public static int welcome() {
				Scanner lector = new Scanner(System.in);
				System.out.println("Welcome to the Flight Calculator");
				System.out.println("Choose a option to continue");
				System.out.println("[1] You are traveling ALONE");
				System.out.println("[2] You are traveling ACCOMPANIED");
				System.out.println("[3] Consult lastest flight prices");
				System.out.println("[4] Close the program");
				int menuSelectOption=lector.nextInt();
			return menuSelectOption;
			}
	
	// 2.1 Rate_XS_Includes | METHOD void
			/**
			*
			* This method will just display information about what the XS rate brings.
			*
			*/
			public static void rateXsIncludes() {
				System.out.println(" ");
				System.out.println("This rate brings:");
				System.out.println("	1.Personal item (3kg)");
				System.out.println("	2.Check-in: Web/App");
				System.out.println("The XS rate cost is $" + PRICE_XS_RATE);
				System.out.println(" ");
			}
			
	// 2.2 Rate_S_Includes | METHOD void
			/**
			*
			* This method will just display information about what the S rate brings.
			*
			*/
			public static void rateSIncludes() {
				System.out.println(" ");
				System.out.println("This rate brings:");
				System.out.println("	1.Personal item (3kg)");
				System.out.println("	2.Hand luggage (10kg)");
				System.out.println("	3.Check-in: Web/App");
				System.out.println("	4.Miles accumulation");
				System.out.println("The S rate cost is $" + PRICE_S_RATE);
				System.out.println(" ");
			}
			
	// 2.3 Rate_M_Includes | METHOD void
			/**
			*
			* This method will just display information about what the M rate brings.
			*
			*/
			public static void rateMIncludes() {
				System.out.println(" ");
				System.out.println("This rate brings:");
				System.out.println("	1.Personal item (3kg)");
				System.out.println("	2.Hand luggage (10kg)");
				System.out.println("	3.Checked bag (23kg)");
				System.out.println("	4.Check-in: Web/App");
				System.out.println("	5.Economy seat selection");
				System.out.println("	6.Miles accumulation");
				System.out.println("The M rate cost is $" + PRICE_M_RATE);
				System.out.println(" ");
			}
			
	// 2.4 Rate_Recommendation | METHOD void
			/**
			*
			* This method will manage the three possible rates to choose and will display the best one to choose.
			*
			* @param double passengerW
			*
			*/
			public static void rateRecommendation(double passengerW) {
				Scanner lector = new Scanner(System.in);
				while (passengerW<=0 || passengerW>109) {
					System.out.println("There is no avalible rate for the weight inputed, must be from 1kg to 109kg.");
					System.out.println("Type the value again.");
					passengerW=lector.nextDouble();
					}
						if (passengerW>0 && passengerW<=3) {
							System.out.println("You should take the XS rate");
							rateXsIncludes();
						}
						
						if (passengerW>3 && passengerW<=13) {
							System.out.println("You should take the S rate");
							rateSIncludes();
						}
						
						if (passengerW>13 && passengerW<=36) {
							System.out.println("You should take the M rate");
							rateMIncludes();
						}
						
						if (passengerW>36 && passengerW<=109) {
							System.out.println("You should take the M rate and you must add extra bags");
							rateMIncludes();
						}
			}
			
	// 3. Choose-Flight-Rate | METHOD String
			/**
			*
			* This method will show to the user a suggested rate depending on the imputed weight.
			*
			* @return chooseRate
			*
			*/
			public static String chooseFlightRate() {
				Scanner lector = new Scanner(System.in);
				System.out.println("Dear passenger, type an approximate value in kg of the weight you are traveling with");
				double passengerW=lector.nextDouble();
				rateRecommendation(passengerW);
				System.out.println("Choose a flight rate (XS-S-M): ");
				lector.nextLine(); 
				String chooseRate=lector.nextLine();
			return chooseRate;
			}
	
	// 4.1 Seat-Selection-XS-S | METHOD Double
			/**
			*
			* This method will display the option to select a seat for the XS and S rates, returning the sum value to the check.
			*
			* @param double totalPassengerToPay
			* @return totalPassengerToPay
			*
			*/ 
			public static double seatSelectionLowRates(double totalPassengerToPay) {
			Scanner lector = new Scanner(System.in);
						System.out.println("The rate picked doesnt let you to select a seat for free");
						System.out.println("Do you want to select a seat for $" + EXTRA_SEAT_SELECT + "? (YES/NO)");
						String ynSeatSelection=lector.nextLine();
							if (ynSeatSelection.equalsIgnoreCase("yes")) {
								totalPassengerToPay = totalPassengerToPay+EXTRA_SEAT_SELECT;
								// SEAT POSITION SELECT
								System.out.println("Which seat position do you want?");
								System.out.println("The (Middle) seat has no extra cost");
								System.out.println("The (Aisle) or (Window) seat has an extra cost of $" + EXTRA_SEAT_WINDOW_AISLE);
								String choosePositionSeat=lector.nextLine();
									if (choosePositionSeat.equalsIgnoreCase("aisle") || choosePositionSeat.equalsIgnoreCase("window")) {
										totalPassengerToPay = totalPassengerToPay+EXTRA_SEAT_WINDOW_AISLE;
									} else {System.out.println("You seat will be the mediddle one");}
							} else {System.out.println("A seat will be assigned to you randomly");}
			return totalPassengerToPay;
			}
			
		// 4.2 Seat-Selection-M | METHOD Double
			/**
			*
			* This method will allow the rate M user to select their seat, returning the sum value to the check.
			*
			* @param double totalPassengerToPay
			* @return totalPassengerToPay
			*
			*/ 
			public static double seatSelectionMRate(double totalPassengerToPay) {
			Scanner lector = new Scanner(System.in);
								// SEAT POSITION SELECT
								System.out.println("Which seat position do you want?");
								System.out.println("The (Middle) seat has no extra cost");
								System.out.println("The (Aisle) or (Window) seat has an extra cost of $" + EXTRA_SEAT_WINDOW_AISLE);
								String choosePositionSeat=lector.nextLine();
									if (choosePositionSeat.equalsIgnoreCase("aisle") || choosePositionSeat.equalsIgnoreCase("window")) {
										totalPassengerToPay = totalPassengerToPay+EXTRA_SEAT_WINDOW_AISLE;
									} else {System.out.println("You seat will be the Middle one");}
			return totalPassengerToPay;
			}
			
		// 5. Extra-10KG-Checked-Suitcase | METHOD Double
			/**
			*
			* This method will allow the user to add extra 10kg suitcases, returning the sum value to the check.
			*
			* @param double totalPassengerToPay
			* @return totalPassengerToPay
			*
			*/
			public static double extraTenKgSuitcaseSelection(double totalPassengerToPay) {
			Scanner lector = new Scanner(System.in);
						System.out.println("Do you want to add extra 10kg suitcase? (YES/NO)");
						String ynChooseExtraTenSuitcase=lector.nextLine();
							if (ynChooseExtraTenSuitcase.equalsIgnoreCase("yes")) {
								System.out.println("How many extra 10kg suitcase do you want?");
								System.out.println("Each passenger can add up to 3 suitcases");
								System.out.println("The price for each checked bag will be $" + EXTRA_TENKG_BAG);
								int amountExtraTenSuitcase = 0;
								amountExtraTenSuitcase=lector.nextInt();
								if (amountExtraTenSuitcase!=0) {
								while (amountExtraTenSuitcase<0 || amountExtraTenSuitcase>3) {
									System.out.println("Remember that you can just add up to 3 checked (10kg) bags");
									amountExtraTenSuitcase=lector.nextInt();
								}} totalPassengerToPay = totalPassengerToPay+(EXTRA_TENKG_BAG*amountExtraTenSuitcase);
							}
			return totalPassengerToPay;
			}
			
		// 6. Extra-23KG-Checked-Suitcase | METHOD Double
			/**
			*
			* This method will allow the user to add extra 23kg suitcases, returning the sum value to the check.
			*
			* @param double totalPassengerToPay
			* @return totalPassengerToPay
			*
			*/
			public static double extraTwentyThreeKgSuitcaseSelection(double totalPassengerToPay) {
			Scanner lector = new Scanner(System.in);
						System.out.println("Do you want to add an extra 23kg suitcase? (YES/NO)");
						String ynChooseExtraTwentyTSuitcase=lector.nextLine();
							if (ynChooseExtraTwentyTSuitcase.equalsIgnoreCase("yes")) {
								System.out.println("How many extra 23kg suitcase do you want?");
								System.out.println("Each passenger can add up to 2 suitcases");
								System.out.println("The price for each checked bag will be $" + EXTRA_TWENTYTHREEKG_BAG);
								int amountExtraTwentyTSuitcase = 0;
								amountExtraTwentyTSuitcase=lector.nextInt();
								if (amountExtraTwentyTSuitcase != 0) {
								while (amountExtraTwentyTSuitcase<0 || amountExtraTwentyTSuitcase>2) {
									System.out.println("Remember that you can just add up to 2 checked (23kg) bags");
									amountExtraTwentyTSuitcase=lector.nextInt();
								}} totalPassengerToPay = totalPassengerToPay+(EXTRA_TWENTYTHREEKG_BAG*amountExtraTwentyTSuitcase);
							}
			return totalPassengerToPay;
			}
			
		// 7. Rate-Selection-Menu | METHOD Double
			/**
			*
			* This method will allow you to call a menu for selecting the rate flight, allowing to call it repetitive times when the user is traveling accompanied.
			*
			* @param String chooseRate
			* @param double totalPassengerToPay
			* @return totalPassengerToPay
			*
			*/
			public static double rateSelectionMenu(String chooseRate, double totalPassengerToPay) {
			Scanner lector = new Scanner(System.in);
						if (chooseRate.equalsIgnoreCase("xs")) {
						totalPassengerToPay = totalPassengerToPay+PRICE_XS_RATE;
						// EXTRA SEAT SELECTION XS-S
						totalPassengerToPay = seatSelectionLowRates(totalPassengerToPay);
						// EXTRA CHECKED BAG 10KG
						totalPassengerToPay = extraTenKgSuitcaseSelection(totalPassengerToPay);
						// EXTRA CHECKED BAG 23KG
						totalPassengerToPay = extraTwentyThreeKgSuitcaseSelection(totalPassengerToPay);
					} else if (chooseRate.equalsIgnoreCase("s")) {
						totalPassengerToPay = totalPassengerToPay+PRICE_S_RATE;
						// EXTRA SEAT SELECTION XS-S
						totalPassengerToPay = seatSelectionLowRates(totalPassengerToPay);
						// EXTRA CHECKED BAG 10KG
						totalPassengerToPay = extraTenKgSuitcaseSelection(totalPassengerToPay);
						// EXTRA CHECKED BAG 23KG
						totalPassengerToPay = extraTwentyThreeKgSuitcaseSelection(totalPassengerToPay);
					} else if (chooseRate.equalsIgnoreCase("m")) {
						totalPassengerToPay = totalPassengerToPay+PRICE_M_RATE;
						// EXTRA SEAT SELECTION M
						totalPassengerToPay = seatSelectionMRate(totalPassengerToPay);
						// EXTRA CHECKED BAG 10KG
						totalPassengerToPay = extraTenKgSuitcaseSelection(totalPassengerToPay);
						// EXTRA CHECKED BAG 23KG
						totalPassengerToPay = extraTwentyThreeKgSuitcaseSelection(totalPassengerToPay);
					}else {
						System.out.println("You didnt choose a valid rate.");
					}
			return totalPassengerToPay;
			}
}