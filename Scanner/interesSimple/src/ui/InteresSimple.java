import java.util.Scanner;
public class InteresSimple{

	public static void main(String[] args){
		
		Scanner lector=new Scanner(System.in);
		System.out.println("Bienvenido");
		
		System.out.println("Ingrese el interes mensual entre 1% y 20%, digite el numero sin porcentaje.");
		double interesMensual= lector.nextDouble();
		
		System.out.println("Ingrese el valor del prestamo: ");
		double valorPrestamo= lector.nextDouble();
		
		System.out.println("Ingrese el dia del ano en que se solicito el prestamo (1-360): ");
	    double diaDelAno= lector.nextDouble();
		
		interesMensual= interesMensual/100;
		double conversionDiasMeses= (360-diaDelAno)/30;
		double interesTotal= valorPrestamo*interesMensual*conversionDiasMeses;
		
		System.out.println("El interes a pagar al final del ano es: "+interesTotal);
	
	}

}