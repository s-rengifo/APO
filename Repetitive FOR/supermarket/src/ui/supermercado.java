	
	import java.util.Scanner;
	public class supermercado {
	
	public static void main(String[] args) {
	items();
	}
			
			public static void items(){
			System.out.println("Digite la cantidad de items que quiere comprar: ");
			Scanner lector = new Scanner(System.in); 
			int cantidadItems = lector.nextInt();
			int i=1;
			int totalCuenta = 0;
			for (i=1; i<=cantidadItems; i++) {
				System.out.println("Digite el precio del item #" + i);
				int precioItems = lector.nextInt();
				totalCuenta = totalCuenta+precioItems;
				}
			System.out.println("El total de cuenta es: $" + totalCuenta);}
			
			
		}