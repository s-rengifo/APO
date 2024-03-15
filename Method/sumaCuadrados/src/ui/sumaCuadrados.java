	
	import java.util.Scanner;
	public class sumaCuadrados {
		
		/* 
		Entrada:
		Salida:
		Proceso:
		*/
		
		public static void sum(int v1, int v2) {
			int sumS = (v1*v1)+(v2*v2);
			System.out.println("The sum of the squares is: " + sumS);
		}
	
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Welcome, type the first value of the square");
			int firstValue = scanner.nextInt();
			System.out.println("Then, type the second value of the square");
			int secondValue = scanner.nextInt();
            sum(firstValue, secondValue);
		}
	
	
	}