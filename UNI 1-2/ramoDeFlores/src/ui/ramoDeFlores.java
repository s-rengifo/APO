import java.util.Scanner;

public class ramoDeFlores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Definicion de precios de los elementos
        int precioOrquidea = 15300;
        int precioRosaBlanca = 4800;
        int precioEucalipto = 1200;
        int precioEspuma = 9700;

        // Definicion de cantidad de elementos en el arreglo floral
        int cantidadOrquideas, cantidadRosasBlancas, cantidadEucalipto, cantidadEspuma;

        // Entrada del usuario: cantidad de elementos en el arreglo floral
        System.out.println("Ingrese la cantidad de orquídeas:");
        cantidadOrquideas = scanner.nextInt();

        System.out.println("Ingrese la cantidad de rosas blancas:");
        cantidadRosasBlancas = scanner.nextInt();

        System.out.println("Ingrese la cantidad de tallos de eucalipto:");
        cantidadEucalipto = scanner.nextInt();

        System.out.println("Ingrese la cantidad de espumas:");
        cantidadEspuma = scanner.nextInt();

        // Tamaño del ramo: pequeño, mediano, grande
        System.out.println("Ingrese el tamaño del ramo (pequeño, mediano, grande):");
        String tamanoRamo = scanner.next();

        // Cálculo del costo de los elementos
        int costoOrquideas = cantidadOrquideas * precioOrquidea;
        int costoRosasBlancas = cantidadRosasBlancas * precioRosaBlanca;
        int costoEucalipto = cantidadEucalipto * precioEucalipto;
        int costoEspuma = cantidadEspuma * precioEspuma;

        // Cálculo del costo total de los elementos
        int costoTotalElementos = costoOrquideas + costoRosasBlancas + costoEucalipto + costoEspuma;

        // Costo de mano de obra según el tamaño del ramo
        int costoManoDeObra = 0;
        switch (tamanoRamo) {
            case "pequeño":
                costoManoDeObra = 23000;
                break;
            case "mediano":
                costoManoDeObra = 45000;
                break;
            case "grande":
                costoManoDeObra = 62000;
                break;
            default:
                System.out.println("Tamaño de ramo inválido.");
                return;
        }

        // Cálculo del costo total del ramo incluyendo mano de obra
        double costoTotalRamo = costoTotalElementos + costoManoDeObra;

        // Aplicación del IVA
        double costoTotalConIVA = costoTotalRamo * 1.19;

        // Mostrar el costo total del ramo con IVA
        System.out.println("El costo total del ramo con IVA es: $" + costoTotalConIVA);
    }
}
