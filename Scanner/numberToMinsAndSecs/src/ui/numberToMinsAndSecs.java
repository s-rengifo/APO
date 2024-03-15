	
	import java.util.Scanner;
	public class numberToMinsAndSecs {
		
		public static void main (String[] args) {
			
			Scanner lector=new Scanner(System.in);
			System.out.println("Welcome, type a number in seconds to convert it and display it to minutes and seconds");
			int secondsIn = lector.nextInt();
			int minutesOut = secondsIn/60;
			int secondsOut = (secondsIn-(minutesOut*60));
			System.out.println("The typed number is equal to: " + minutesOut + " minutes and " + secondsOut + " seconds.");
			
		}
	}