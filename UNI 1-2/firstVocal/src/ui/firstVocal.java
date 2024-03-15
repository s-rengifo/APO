import java.util.Scanner;
public class firstVocal {

    public static void main(String[] args) {

    Scanner lector = new Scanner (System.in);

    System.out.println("Ingrese la cadena a evaluar.");
    String word = lector.nextLine().toLowerCase();
    int counter = 0;
	boolean stop = true;
	counter = lookForFirstVocal(counter, word, stop);
	System.out.println("The first vocal found is in the position #" + counter);
    }
	
	// -----BEGINNING OF METHODS-----
	
	// 1. Look-For-First-Vocal | METHOD int
			/**
			*
			* This method will check how many consonants are on the string.
			*
			* @param int counter
			* @param String word
			* @param boolean stop
			* @return counter
			*
			*/
	public static int lookForFirstVocal(int counter, String word, boolean stop) {
		for(int i=0; i<word.length(); i++) {
            if(word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u' ) {
				if (stop) {
					counter = i;
					stop = false;
				}
            } 
		}
	return counter;
	}
}