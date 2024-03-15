	
	import java.util.Scanner;
	public class sumArray {

		// Main Class
		public static void main(String[] args) {
			
			Scanner lector = new Scanner(System.in);
			System.out.println("Welcome, enter the lenght of the array.");
			int arrayLenght = lector.nextInt();
			int i = 0;
			int [] arregloIntUno = new int[arrayLenght];
			int [] arregloIntDos = new int[arrayLenght];
			System.out.println("Type the values of the array #1");
			for (i=0; i<arrayLenght; i++) {
				arregloIntUno[i]=lector.nextInt();
				while (arregloIntUno[i]<0 || arregloIntUno[i]>9) {
				System.out.println("You typed a value higher than expected, must be between 0 and 9.");
				arregloIntUno[i]=lector.nextInt();
				}
			}
			System.out.println("Type the values of the array #2");
			for (i=0; i<arrayLenght; i++) {
				arregloIntDos[i]=lector.nextInt();
				while (arregloIntDos[i]<0 || arregloIntDos[i]>9) {
				System.out.println("You typed a value higher than expected, must be between 0 and 9.");
				arregloIntDos[i]=lector.nextInt();
				}
			}
			
			int [] finalArray = new int[arrayLenght+1];
			int indexSum = 0;
			int valueHigherThanAllowed = 0;
			for (i=arrayLenght; i==0; i--) {
				indexSum = arregloIntUno[i] + arregloIntDos[i];
				if (indexSum > 9) {
					valueHigherThanAllowed = indexSum-9;
					finalArray[i-1]=0;
				}
			}
			
		}
}
	
	
	// Samuel J. Rengifo A00404150