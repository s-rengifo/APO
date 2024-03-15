	
	import java.util.Scanner;
	public class reverseFiveStringLenght {
		public static void main(String[] args) {
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Welcome, write a five characters string to then display it reversed: ");
			String input = scanner.nextLine();
			String output = (input.length() > 5) ? "Ingresaste mas de cinco caracteres" :
                       (input.length() < 5) ? "La cadena debe tener exactamente cinco caracteres" :
                       new StringBuilder(input).reverse().toString();
			System.out.println("Resultado: " + output);
			scanner.close();
    }
}
