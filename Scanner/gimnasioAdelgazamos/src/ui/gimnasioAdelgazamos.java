import java.util.Scanner;

public class gimnasioAdelgazamos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el peso actual en kilogramos:");
        double pesoActual = scanner.nextDouble();

        System.out.println("Ingrese la estatura en metros:");
        double estatura = scanner.nextDouble();

        System.out.println("Ingrese el numero de sesiones de aerobicos por semana:");
        int sesionesPorSemana = scanner.nextInt();

        double pesoIdeal = (estatura*100) - 110;

        double caloriasPorPerder = (pesoActual - pesoIdeal) * 3500;

        double caloriasPorSesion = 450 * 45 / 60;
        
        double caloriasQuemadasPorSemana = sesionesPorSemana * caloriasPorSesion; 
        
        double semanasParaPerderPeso = caloriasPorPerder / caloriasQuemadasPorSemana;

        System.out.println("El peso ideal es: " + pesoIdeal + " kg");
        System.out.println("Se demorara aproximadamente " + semanasParaPerderPeso + " semanas en alcanzar su peso ideal.");

        scanner.close();
    }
}
