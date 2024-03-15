import java.util.Scanner;
public class arregloTotalConsonante {

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese la cadena a evaluar si tiene consonantes.");
        String word = lector.nextLine().toLowerCase();
        int counter = 0;
		counter = lookForConsonants(counter, word);
        System.out.println("The total amount of consonants are: " + counter);
    }
	
	// -----BEGINNING OF METHODS-----
	
	// 1. Look-For-Consonant | METHOD int
			/**
			*
			* This method will check how many consonants are on the string.
			*
			* @param int counter
			* @return counter
			*
			*/
	public static int lookForConsonants(int counter, String word) {
	for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u' ) {
                counter++;
            }
     }
	return counter;
	}
	
}