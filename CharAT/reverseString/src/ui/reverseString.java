	
	import java.util.Scanner;
	public class reverseString {
		public static void main(String[] args) {
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Welcome, write a five characters string to then display it reversed: ");
			String input = scanner.nextLine();
			String output = (input.length() > 5) ? "Ingresaste mas de cinco caracteres" :
                       (input.length() < 5) ? "La cadena debe tener exactamente cinco caracteres" : "La cadena tiene cinco caracteres";
                       
            System.out.print(input.charAt(4));
            System.out.print(input.charAt(3));
            System.out.print(input.charAt(2));
            System.out.print(input.charAt(1));
            System.out.print(input.charAt(0));
    }
}

// 