	
	import java.util.Scanner;
	public class descuento {
	
	
	public static void discount(double totalValueInput) {
			if (totalValueInput>100000) {
			totalValueInput=totalValueInput-(totalValueInput*0.25);}
			System.out.println("The total price is: " + totalValueInput);
			}
	
	public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Welcome, type the total value of what you bought");
			double totalValueInput = scanner.nextDouble();
			discount(totalValueInput);
			
			}
		}