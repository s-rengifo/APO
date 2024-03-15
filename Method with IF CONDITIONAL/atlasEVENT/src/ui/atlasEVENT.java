	
	import java.util.Scanner;
	public class atlasEVENT {
		
			// CONSTANTS
			public static final int PRICE_PER_NIGHT = 200000;
			public static final int PRICE_PER_WAY_BUS = 100000;
			public static final int PRICE_PER_WAY_PLANE = 300000;
			
			// -----BEGINNING OF METHODS-----
			
			// 1. Welcome-SystemOutPrint | Method VOID
			/**
			*
			* This method will display the introducing text to the program, 
			* will welcome the user and will explain to the user that he/she has to stay 
			* at least one night with Atlas to reserve the night.
			*
			*/
			public static void welcomeSout() {
				System.out.println("Welcome to ATLAS event");
				System.out.println("To start your experience, start by typing, how many nights you want to stay with ATLAS?");
				System.out.println("To do the reservation you should stay one night with ATLAS mandatory.");
				System.out.println("Each night has the price of $200.000 but if you stay 3 nights, a 10% discount will be added to your stayover.");}
		
			// 2. Check&Calculate-Total-Nights-Price | Method DOUBLE
			/**
			*
			* With the variable before inputted in main (totalNightsPrice), this method will evaluate values 
			* with a prerequisite in main, so it will only evaluate values from 1 to 3. 
			* There will be 3 possible options to calculate totalNightsPrice and if the user decides 
			* to choose 3 nights to stay, a 10% discount will be applied to his stay over with Atlas.
			*
			* @param int reservationNights
			* @return totalNightsPrice
			*
			*/
			public static double checkAmountNightsToStay(int reservationNights){
				double totalNightsPrice = 0;
				 if (reservationNights==1) {
					totalNightsPrice = reservationNights*PRICE_PER_NIGHT;}
				 if (reservationNights==2) {
					 totalNightsPrice = reservationNights*PRICE_PER_NIGHT;}
				 if (reservationNights==3) {
					 totalNightsPrice = ((reservationNights*PRICE_PER_NIGHT)-((reservationNights*PRICE_PER_NIGHT)*0.1));}
				 return totalNightsPrice;}
			 
			// 3. Transportation-SystemOutPrint | Method VOID
			/**
			*
			* This method will just display information about the prices 
			* and options to take at the moment of choosing a transport method.
			*
			*/
			public static void transportationSout() {
				System.out.println("Do you want to transport by (Bus) or (Plane)");
				System.out.println("By bus the price is of $100.000 each way");
				System.out.println("By plane the price is of $300.000 each way");}
			
			// 4. Calculate-OneWay-Price | Method DOUBLE
			/**
			*
			* The method will start comparing if the String oneWayOrRoundTripTransportation has the word “oneway” and 
			* if it's true, it will invoke the third method to display the information about transportation, 
			* to then request to type which transport method he decided to use (bus or plane), so depending of the choose of the user, 
			* the system will calculate in console and save into the variable the price of that oneway choose.
			*
			* @param String oneWayOrRoundTripTransportation
			* @return totalTransportationPrice
			*
			*/
				public static double oneWayPriceCalculate(String oneWayOrRoundTripTransportation){
				double totalTransportationPrice = 0;
				if (oneWayOrRoundTripTransportation.equalsIgnoreCase("oneway")) {
					transportationSout();
					Scanner lector = new Scanner(System.in);
					String transportationChoice = lector.next();
					 if (transportationChoice.equalsIgnoreCase("bus")) {
						 totalTransportationPrice = PRICE_PER_WAY_BUS*1;}
						 
					 if (transportationChoice.equalsIgnoreCase("plane")) {
						 totalTransportationPrice = PRICE_PER_WAY_PLANE*1;}
					 }
				return totalTransportationPrice;}
			
			// 5. Calculate-RoundTrip-Price | Method DOUBLE
			/**
			*
			* The method will start comparing if the String oneWayOrRoundTripTransportation has the word “roundtrip” and 
			* if it's true, it will invoke the third method to display the information about transportation, 
			* to then request to type which transport method he decided to use (bus or plane), so depending of the choose of the user, 
			* the system will calculate in console and save into the variable the price of that roundtrip choose.
			*
			* @param String oneWayOrRoundTripTransportation
			* @return totalTransportationPrice
			*
			*/
			public static double roundTripPriceCalculate(String oneWayOrRoundTripTransportation){	
			double totalTransportationPrice = 0;
			if (oneWayOrRoundTripTransportation.equalsIgnoreCase("roundtrip")) {
				transportationSout();
				Scanner lector = new Scanner(System.in);
				String transportationChoice = lector.next();
				 if (transportationChoice.equalsIgnoreCase("bus")) {
					 totalTransportationPrice = PRICE_PER_WAY_BUS*2;}
					 
				 if (transportationChoice.equalsIgnoreCase("plane")) {
					 totalTransportationPrice = PRICE_PER_WAY_PLANE*2;}
				}
			return totalTransportationPrice;}
			
			// 6. VIPpackage-SystemOutPrint | Method VOID
			/**
			*
			* This method will just display information about the VIP package and will display 
			* the price to help the user to decide if he really wants to take this extra service.
			*
			* @param double totalCheckNoTaxesNoVip
			*
			*/
			public static void vipPackageSout(double totalCheckNoTaxesNoVip) {
			System.out.println("Do you want to add the VIP package?");
			System.out.println("This package offers a preferential moment to enter to the stage,");
			System.out.println("access to food and exclusive drinks and the possibility to meet the members of RBD.");
			System.out.println("The price of this package wil be $" + (totalCheckNoTaxesNoVip*0.3));
			System.out.println("Type YES/NO");}
			
			// 7. Add VIPpackage to check | Method DOUBLE
			/**
			*
			* As the VIP price is calculated in main, in this method, the user just will decide with YES/NO 
			* if he wants to take the VIP package price with value that he saw second before, 
			* if he decided to take it, the variable will update.
			*
			* @param double vipPricePackage
			* @return vipPricePackage
			*
			*/
			public static double addVipPackageToCheck(double vipPricePackage){
			Scanner lector = new Scanner(System.in); 
			String ynVipPackage = lector.next();
				if (ynVipPackage.equalsIgnoreCase("yes")) {
					vipPricePackage=vipPricePackage+0;
				} else if (ynVipPackage.equalsIgnoreCase("no")) {vipPricePackage=0;}
			return vipPricePackage;}
			
			// 8. TotalCheck-SystemOutPrint | Method VOID
			/**
			*
			* This method will just display information about the VIP package and will display 
			* the price to help the user to decide if he really wants to take this extra service.
			*
			* @param double stayoverValuePrice
			* @param double transportationValuePrice
			* @param double totalCheckNoTaxesNoVip
			*
			*/
				public static void finalTotalCheckSout(double stayoverValuePrice, double transportationValuePrice, double totalCheckNoTaxesNoVip) {
					System.out.println("");
					System.out.println("------------------------");
					System.out.println("|	 ATLAS");
					System.out.println("|       Agency");
					System.out.println("|");
					System.out.println("|      67 Avenue, 9st");
					System.out.println("|   Medellin, Antioquia");
					System.out.println("|");
					System.out.println("|	  RECIPT");
					System.out.println("|");
					System.out.println("| Product:");
					System.out.println("| Stayover $" + stayoverValuePrice);
					System.out.println("| Transportation $" + (transportationValuePrice-stayoverValuePrice));
					if (totalCheckNoTaxesNoVip>=200000) {
						System.out.println("| VIP package $" + (totalCheckNoTaxesNoVip-((stayoverValuePrice)+(transportationValuePrice-stayoverValuePrice))));
					}
					System.out.println("| Taxes $" + (totalCheckNoTaxesNoVip*0.2));
					System.out.println("|	TOTAL $" + (totalCheckNoTaxesNoVip+(totalCheckNoTaxesNoVip*0.2)));
					System.out.println("------------------------");
				}
			
		// -----END OF METHODS-----
		
		// Main Class
		public static void main(String[] args) {
			
			Scanner lector = new Scanner(System.in);
			welcomeSout();
			
			// Hospitality reservation
			int reservationNights = lector.nextInt();
			double totalCheckNoTaxesNoVip = 0;
			double stayoverValuePrice = 0;
			double transportationValuePrice = 0;
			if (reservationNights>=1 && reservationNights<=3) {
				
				totalCheckNoTaxesNoVip = checkAmountNightsToStay(reservationNights);
				stayoverValuePrice = totalCheckNoTaxesNoVip;
				// Transportation decision
				System.out.println("Do you want to pick (Oneway) transportation or (Roundtrip)");
				String oneWayOrRoundTripTransportation = lector.next();
				if (oneWayOrRoundTripTransportation.equalsIgnoreCase("oneway")) {
				totalCheckNoTaxesNoVip = totalCheckNoTaxesNoVip + (oneWayPriceCalculate(oneWayOrRoundTripTransportation));
				transportationValuePrice = totalCheckNoTaxesNoVip;}
					else if (oneWayOrRoundTripTransportation.equalsIgnoreCase("roundtrip")) {
						totalCheckNoTaxesNoVip = totalCheckNoTaxesNoVip+ (roundTripPriceCalculate(oneWayOrRoundTripTransportation));
						transportationValuePrice = totalCheckNoTaxesNoVip;
							} else {System.out.println("You are not typing a possible selection, must be one way or round trip");}
				} else {System.out.println("The inputed typed it is not valid, the value need to be from 1 to 3.");}
				
				// VIPpackage decision
				if (totalCheckNoTaxesNoVip>=200000) {
					vipPackageSout(totalCheckNoTaxesNoVip);
					double vipPricePackage=totalCheckNoTaxesNoVip*0.3;
					totalCheckNoTaxesNoVip = totalCheckNoTaxesNoVip + addVipPackageToCheck(vipPricePackage);
				}
				
				// FINAL CHECK DISPLAY
				if (totalCheckNoTaxesNoVip>0) {
				finalTotalCheckSout(stayoverValuePrice, transportationValuePrice, totalCheckNoTaxesNoVip);
				}
		
		}
	}
	
	// Samuel J. Rengifo A00404150