	
	import java.util.Scanner;
	public class motorcycleShop {
		public static void main(String[] args) {
			
			Scanner lector = new Scanner(System.in);
			System.out.println("Welcome, our store is on final sales, 3 motobrands have discount and for other brands the discount is 2%");
			System.out.println("Type the price of the motorcycle");
			double motorcycleValue = lector.nextDouble();
			
			System.out.println("Then, type the brand of the selected motorcycle, [Honda]5%, [Yamaha]8% or [Suzuki]10%, for [Others] brands the discount is of 2%");
			String brand = lector.next();
			
			// variables
			double discountValue = 0;
			String hon = "honda";
			String yam = "yamaha";
			String suz = "suzuki";
			String oth = "others";
			
			discountValue = (brand.equalsIgnoreCase(hon)) ? (0.05)*motorcycleValue : discountValue;
			discountValue = (brand.equalsIgnoreCase(yam)) ? (0.08)*motorcycleValue : discountValue;
			discountValue = (brand.equalsIgnoreCase(suz)) ? (0.1)*motorcycleValue : discountValue;
			discountValue = (brand.equalsIgnoreCase(oth)) ? (0.02)*motorcycleValue : discountValue;
			
			double totalPrice = motorcycleValue-discountValue;
			System.out.println("The total amount of the motorcycle with a discount of " + discountValue + " is: " + totalPrice );
			System.out.println("The original price was: " + motorcycleValue);
			
		}
	}