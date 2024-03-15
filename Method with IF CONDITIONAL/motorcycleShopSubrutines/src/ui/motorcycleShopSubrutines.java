	
	import java.util.Scanner;
	public class motorcycleShopSubrutines {
		public static void main(String[] args) {
			
			Scanner lector = new Scanner(System.in);
			System.out.println("Welcome, our store is on final sales, 3 motobrands have discount and for other brands the discount is 2%");
			System.out.println("Type the price of the motorcycle");
			double motorcycleValue = lector.nextDouble();
			
			System.out.println("Then, type the brand of the selected motorcycle, [Honda]5%, [Yamaha]8% or [Suzuki]10%, for [Others] brands the discount is of 2%");
			String brand = lector.next();
			
			motoDiscount(brand, motorcycleValue);
			
			}
			
		public static void motoDiscount(String brand, double motorcycleValue) {
			double discountValue = 0;
			String hon = "honda";
			String yam = "yamaha";
			String suz = "suzuki";
			String oth = "others";
			
			if (brand.equalsIgnoreCase(hon)) {
				discountValue=0.05*motorcycleValue;}
				
			if (brand.equalsIgnoreCase(yam)) {
				discountValue=0.08*motorcycleValue;}
				
			if (brand.equalsIgnoreCase(suz)) {
				discountValue=0.1*motorcycleValue;} 
				else {discountValue=0.02*motorcycleValue;}
				
			printDiscount(motorcycleValue, discountValue);
		}
		
		public static void printDiscount(double motorcycleValue, double discountValue) {
			double totalPrice = motorcycleValue-discountValue;
			System.out.println("The total amount of the motorcycle with a discount of " + discountValue + " is: " + totalPrice );
			System.out.println("The original price was: " + motorcycleValue);
		}
	}