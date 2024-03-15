	
	import java.util.Scanner;
	public class salaryIncrease {
		
		public static void main (String[] args) {
			
			Scanner lector=new Scanner(System.in);
			System.out.println("Welcome, type your salary");
			double salary = lector.nextDouble();
			salary = salary*1.05;
			System.out.println("The salary increased by 5% is equivalent to: " + salary);
			
		}
	}