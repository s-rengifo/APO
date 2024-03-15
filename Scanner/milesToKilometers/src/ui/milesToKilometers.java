
	import java.util.Scanner;
	public class milesToKilometers {
		
		public static void main (String[] args) {
			
			Scanner lector=new Scanner(System.in);
			System.out.println("Welcome, type a number in miles to convert to kilometers.");
			double milesData = lector.nextDouble();
			double kilometersData = milesData*1.609;
			System.out.println("The result of the number typed in miles is equal to: " + kilometersData + " kilometers.");
			
		}
	}