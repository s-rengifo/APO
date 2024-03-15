	
	import java.util.Scanner;
	public class phoneDiscount {
		
		public static void main (String[] args) {
			
			Scanner lector=new Scanner(System.in);
			System.out.println("Welcome, type the total value of the phone");
			double phoneValue = lector.nextDouble();
			System.out.println("Type the percentage (%) of discount");
			double discountValue = lector.nextDouble();
			double totalPrice = phoneValue-((discountValue/100)*phoneValue);
			System.out.println("The total amount of the phone with " + discountValue + "% of discount is: " + totalPrice);
			
		}
	}