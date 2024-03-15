import java.util.Scanner;

public class Adelgazamos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el peso actual en kilogramos:");
        double pesoActual = scanner.nextDouble();

        System.out.println("Ingrese la estatura en metros:");
        double estatura = scanner.nextDouble();

        System.out.println("Ingrese el numero de sesiones de aerobicos por semana:");
        int sesionesPorSemana = scanner.nextInt();

        // Peso ideal
        double pesoIdeal = estatura * 100 - 10;

        // Calcular la cantidad de calorias que se deben quemar para alcanzar el peso ideal
        double caloriasPorPerder = (pesoActual - pesoIdeal) * 3500;

        // Calcular las calorias quemadas por sesion de aerobicos
        double caloriasPorSesion = 450 * 45 / 60; // 450 calorias por hora de aerobicos

        // Calcular las calorias quemadas por semana
        double caloriasQuemadasPorSemana = sesionesPorSemana * caloriasPorSesion;

        // Calcular el tiempo en semanas para alcanzar el peso ideal
        double semanasParaPerderPeso = caloriasPorPerder / caloriasQuemadasPorSemana;

        System.out.println("El peso ideal es: " + pesoIdeal + " kg");
        System.out.println("Se demorara aproximadamente " + semanasParaPerderPeso + " semanas en alcanzar su peso ideal.");

        scanner.close();
    }
}
