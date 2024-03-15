import java.util.Scanner;

public class cambioCaracter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de la cadena, los dos caracteres y el numero
        System.out.println("Bienvenido, ingrese una cadena:");
        String cadena = scanner.nextLine();

        System.out.println("Ingrese el primer caracter:");
        char caracterUno = scanner.next().charAt(0);

        System.out.println("Ingrese el segundo caracter:");
        char caracterDos = scanner.next().charAt(0);

        System.out.println("Ingrese un numero entre 1 y 3:");
        int numero = scanner.nextInt();

        if (cadena.indexOf(caracterUno) == -1) {
            System.out.println("El caracter ingresado no existe en la cadena.");
            return;
        }

        // Cambio del primer caracter por el segundo en la posicion correspondiente
        int contador = 0;
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < cadena.length(); i++) {
            char actual = cadena.charAt(i);
            if (actual == caracterUno) {
                contador++;
                if (contador == numero) {
                    resultado.append(caracterDos);
                } else {
                    resultado.append(actual);
                }
            } else {
                resultado.append(actual);
            }
        }

        // Verificacion de si se realizo algun cambio en la cadena
        if (resultado.toString().equals(cadena)) {
            System.out.println("La cadena no puede ser cambiada.");
        } else {
            System.out.println("La cadena modificada es: " + resultado.toString());
        }
    }
}
