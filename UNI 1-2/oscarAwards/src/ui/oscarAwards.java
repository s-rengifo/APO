import java.util.Scanner;
public class oscarAwards {
	
	//MAIN
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		System.out.println("Welcome to the Oscar Awards");
		boolean menuRepetitive = true;
		int totalVoteCounter=0;
		int filmOneCounter = 0;
		int filmTwoCounter = 0;
		int filmThreeCounter = 0;
		int filmFourCounter = 0;
		int filmFiveCounter = 0;
		while (menuRepetitive) {	
			System.out.println("Choose a option, [1] For film voting , [2] For end the votations.");
			int menuSelection=lector.nextInt();
			if (menuSelection==1) {
				menuVotation();
				int menuFilmSelection=lector.nextInt();
				totalVoteCounter++;
				filmOneCounter = filmOneCounterMethod(menuFilmSelection, filmOneCounter);
				filmTwoCounter = filmTwoCounterMethod(menuFilmSelection, filmTwoCounter);
				filmThreeCounter = filmThreeCounterMethod(menuFilmSelection, filmThreeCounter);
				filmFourCounter = filmFourCounterMethod(menuFilmSelection, filmFourCounter);
				filmFiveCounter = filmFiveCounterMethod(menuFilmSelection, filmFiveCounter);
			}
			if (menuSelection==2 || totalVoteCounter>500000) {
				menuRepetitive = false;
				System.out.println("The total amount of persons who vote is: " + totalVoteCounter);
				mostVotedFilmCompare(filmOneCounter, filmTwoCounter, filmThreeCounter, filmFourCounter, filmFiveCounter);
			}
		}
		
		
	}
		
	// -----BEGINNING OF METHODS-----
	
		// 1. Menu-Votation | METHOD void
			/**
			*
			* This method will show the films that are available to vote for.
			*
			*/
			public static void menuVotation() {
				System.out.println(" ");
				System.out.println("Pick one of the following 6 films:");
				System.out.println("[1] El chico y la garza");
				System.out.println("[2] Elemental");
				System.out.println("[3] Nimona");
				System.out.println("[4] Robot Dreams");
				System.out.println("[5] Spider-Man: Cruzando el Multiverso");
				System.out.println(" ");
			}
		
		// 2.1 Votation-Counter-Selection-Film-One | METHOD int
			/**
			*
			* This method will add a sum variable to the user to count depending on film selection.
			*
			* @param int menuFilmSelection
			* @param int filmOneCounter
			* @return filmOneCounter
			*
			*/
			public static int filmOneCounterMethod(int menuFilmSelection, int filmOneCounter) {
			if (menuFilmSelection==1) {
					System.out.println("You picked movie [1], El chico y la garza");
					filmOneCounter++;
			}
			return filmOneCounter;
			}
			
			// 2.2 Votation-Counter-Selection-Film-Two | METHOD int
			/**
			*
			* This method will add a sum variable to the user to count depending on film selection.
			*
			* @param int menuFilmSelection
			* @param int filmTwoCounter
			* @return filmTwoCounter
			*
			*/
			public static int filmTwoCounterMethod(int menuFilmSelection, int filmTwoCounter) {
			if (menuFilmSelection==2) {
					System.out.println("You picked movie [2], Elemental");
					filmTwoCounter++;
			}
			return filmTwoCounter;
			}
			
			// 2.3 Votation-Counter-Selection-Film-Three | METHOD int
			/**
			*
			* This method will add a sum variable to the user to count depending on film selection.
			*
			* @param int menuFilmSelection
			* @param int filmThreeCounter
			* @return filmThreeCounter
			*
			*/
			public static int filmThreeCounterMethod(int menuFilmSelection, int filmThreeCounter) {
			if (menuFilmSelection==3) {
					System.out.println("You picked movie [3], Nimona");
					filmThreeCounter++;
			}
			return filmThreeCounter;
			}
			
			// 2.4 Votation-Counter-Selection-Film-Four | METHOD int
			/**
			*
			* This method will add a sum variable to the user to count depending on film selection.
			*
			* @param int menuFilmSelection
			* @param int filmFourCounter
			* @return filmFourCounter
			*
			*/
			public static int filmFourCounterMethod(int menuFilmSelection, int filmFourCounter) {
			if (menuFilmSelection==4) {
					System.out.println("You picked movie [4], Robot Dreams");
					filmFourCounter++;
			}
			return filmFourCounter;
			}
			
			// 2.5 Votation-Counter-Selection-Film-Five | METHOD int
			/**
			*
			* This method will add a sum variable to the user to count depending on film selection.
			*
			* @param int menuFilmSelection
			* @param int filmFiveCounter
			* @return filmFiveCounter
			*
			*/
			public static int filmFiveCounterMethod(int menuFilmSelection, int filmFiveCounter) {
			if (menuFilmSelection==5) {
					System.out.println("You picked movie [5], Spider-Man: Cruzando el Multiverso");
					filmFiveCounter++;
			}
			return filmFiveCounter;
			}
			
			// 3. Most-Voted-Film | METHOD void
			/**
			*
			* This compares the inputted data and will show on screen which was the most voted movie, if there is a draw the system will show another text.
			*
			*/
			public static void mostVotedFilmCompare(int filmOneCounter, int filmTwoCounter, int filmThreeCounter, int filmFourCounter, int filmFiveCounter) {
				if (filmOneCounter>filmTwoCounter && filmOneCounter>filmThreeCounter && filmOneCounter>filmFourCounter && filmOneCounter>filmFiveCounter ) {
					System.out.println("The film most voted was El chico y la garza");
				}
				if (filmTwoCounter>filmOneCounter && filmTwoCounter>filmThreeCounter && filmTwoCounter>filmFourCounter && filmTwoCounter>filmFiveCounter ) {
					System.out.println("The film most voted was Elemental");
				}
				if (filmThreeCounter>filmOneCounter && filmThreeCounter>filmTwoCounter && filmThreeCounter>filmFourCounter && filmThreeCounter>filmFiveCounter ) {
					System.out.println("The film most voted was Nimona");
				}
				if (filmFourCounter>filmOneCounter && filmFourCounter>filmTwoCounter && filmFourCounter>filmThreeCounter && filmFourCounter>filmFiveCounter ) {
					System.out.println("The film most voted was Robot Dreams");
				}
				if (filmFiveCounter>filmOneCounter && filmFiveCounter>filmTwoCounter && filmFiveCounter>filmThreeCounter && filmFiveCounter>filmFourCounter ) {
					System.out.println("The film most voted was Spider-Man: Cruzando el Multiverso");
				}
				if (filmFiveCounter==filmOneCounter && filmTwoCounter==filmThreeCounter && filmFiveCounter==filmFourCounter) {
					System.out.println("There is a draw between film votation.");
				}
			}
}