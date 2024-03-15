
	import java.util.Scanner;
	public class mainMenu {
		
	//METHODS
	
	public static int mensajeBienvenida(){
	System.out.println("Bienvenido, escoja una opction: ");
	System.out.println("[1] Ingresar - [2] Eliminar - [3] Contar - [4] Salir ");
	Scanner scanner = new Scanner(System.in);
	int seleccionDeNumero = scanner.nextInt();
	return seleccionDeNumero;
	}

	public static void ingresar() {
	System.out.println("Usted ha escogido la opcion #1 para ingresar");
	}

	public static void eliminar() {
	System.out.println("Usted ha escogido la opcion #2 para eliminar");
	}

	public static int contar(Scanner scanner) {
	
	System.out.println("Usted ha escogido la opcion #3 para eliminar");
	System.out.println("Ingrese el primer numero a comenzar el conteo.");
	int primerNumero = scanner.nextInt();
	System.out.println("Ingrese el segundo numero al cual debe llegar el conteo.");
	int segundoNumero = scanner.nextInt();
	int counter = 0;
	for (primerNumero=primerNumero; primerNumero<segundoNumero; primerNumero++) {
	counter++;}
	return counter;}

	public static boolean salir() {
	System.out.println("Usted ha escogido la opcion #4 para salir del menu");
	return false;
	}

	//MAIN
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in); 
	boolean continuar = true;

	do { 
	int opcion = mensajeBienvenida();

	switch (opcion) {

	case 1:
	ingresar();
	break;

	case 2:
	eliminar();
	break;

	case 3:
	int counter = contar(scanner);
	System.out.println("La cuenta total ha sido de: " + counter);
	break;

	case 4:
	continuar = salir();
	break;

	default:
	System.out.println("El valor ingresado no corresponde a ninguna de las opciones");
	
	}
	} while (continuar==true);

	}
}

