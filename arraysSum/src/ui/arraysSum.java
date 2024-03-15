import java.util.Scanner;

public class arraysSum {
    public static void main(String[] args) {
        int[] arreglo1 = {6, 9, 0, 5, 2};
        int[] arreglo2 = {4, 7, 5, 1, 3};
        
        int[] sumaArray = suma(arreglo1, arreglo2);
        
        for (int i = 0; i < sumaArray.length; i++) {
            System.out.print(sumaArray[i]);
        }
    }
    
    public static int[] suma(int[] arreglo1, int[] arreglo2) {
        int[] suma = new int[arreglo1.length + 1];
        int resultado;
        
        for (int i = arreglo1.length - 1; i >= 0; i--) {
            resultado = arreglo1[i] + arreglo2[i] + suma[i + 1];
            suma[i + 1] = resultado % 10;
            suma[i] = resultado / 10;
        }
        
        return suma;    
    }
}
