	
	import java.util.Scanner;
	public class exerciseOneEmcali {
	
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Welcome to Emcali, to calculate the price of a call, type the following parameters: ");
			System.out.println("As first step, type how long the call last, first type the amount of hours");
			int hourCallDuration = scanner.nextInt();
			int hourToMinutesCallDuration = hourCallDuration*60;
			System.out.println("Now type the amount of minutes");
			int minutesCallDuration = scanner.nextInt();
			int totalCallDuration = minutesCallDuration+hourToMinutesCallDuration;
			System.out.println("As second step, type just the hour of the day when you called");
			int callLogHour = scanner.nextInt();
			System.out.println("As final step, type the city zone that you called to: (North, South, East, West or Downtown)");
			String cityZone = scanner.next();
			
			switch (cityZone) {
				
				case "north":
				if (callLogHour>=18 && callLogHour<=23 || callLogHour>=0 && callLogHour<=7 ) {
					System.out.println("The final rate of the call is: $" + 65*totalCallDuration);
				} if (callLogHour>=8 && callLogHour<=17) {
					System.out.println("The final rate of the call is: $" + 80*totalCallDuration);
				} break;
				
				case "south":
				if (callLogHour>=18 && callLogHour<=23 || callLogHour>=0 && callLogHour<=7 ) {
					System.out.println("The final rate of the call is: $" + 60*totalCallDuration);
				} if (callLogHour>=8 && callLogHour<=17) {
					System.out.println("The final rate of the call is: $" + 70*totalCallDuration);
				} break;
				
				case "east":
				if (callLogHour>=18 && callLogHour<=23 || callLogHour>=0 && callLogHour<=7 ) {
					System.out.println("The final rate of the call is: $" + 80*totalCallDuration);
				} if (callLogHour>=8 && callLogHour<=17) {
					System.out.println("The final rate of the call is: $" + 100*totalCallDuration);
				} break;
				
				case "west":
				if (callLogHour>=18 && callLogHour<=23 || callLogHour>=0 && callLogHour<=7 ) {
					System.out.println("The final rate of the call is: $" + 55*totalCallDuration);
				} if (callLogHour>=8 && callLogHour<=17) {
					System.out.println("The final rate of the call is: $" + 60*totalCallDuration);
				} break;
				
				case "downtown":
				if (callLogHour>=18 && callLogHour<=23 || callLogHour>=0 && callLogHour<=7 ) {
					System.out.println("The final rate of the call is: $" + 68*totalCallDuration);
				} if (callLogHour>=8 && callLogHour<=17) {
					System.out.println("The final rate of the call is: $" + 75*totalCallDuration);
				} break;
			}
		}
	}