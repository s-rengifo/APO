	
	import java.util.Scanner;
	public class fiveIntNumbers {
		
		/* 
		Input: v1, v2, v3, v4, v5
		Output: averageS
		Process: With the five integer numbers the system calculates the average doing the sum
		of the five integers and then, it divides by five that is the amount of integers that
		were inputed. The console should show the average in the screen. By the way, a conversion to
		double data was added for calculate the average with decimals.
		*/
		public static void average(int v1, int v2, int v3, int v4, int v5) {
			
			//Average
			double averageS = (double)(v1+v2+v3+v4+v5)/5;
			System.out.println("The average of the five integers is: " + averageS);
			
		}
			
		/* 
		Input: v1, v2, v3, v4, v5
		Output: modTotal
		Process: With the five integer numbers the system will calculate how many numbers of the five
		integers are divisible by 10, 6 new variables should do the process to calculate the task, each
		modValue should find out if the integer inputed is divisible by 10, if the modular of that number
		is equal to 0, the variable will get a value of 1, if is not, it will get a value 0, of that way
		when all the numbers are checked, the last process will sum all the modValue variables to then show
		in screen how numbers were divisible by 10.
		*/
		public static void divisible(int v1, int v2, int v3, int v4, int v5) {
			
			//Divisible
			int modValue1 = v1%10 == 0 ? 1 : 0;
			int modValue2 = v2%10 == 0 ? 1 : 0;
			int modValue3 = v3%10 == 0 ? 1 : 0;
			int modValue4 = v4%10 == 0 ? 1 : 0;
			int modValue5 = v5%10 == 0 ? 1 : 0;
			int modTotal = modValue1+modValue2+modValue3+modValue4+modValue5; 
			System.out.println("There are " + modTotal + " numbers divisible by 10");
			
		}
		
		/* 
		Input: v1, v2, v3, v4, v5
		Output: resultDivisibleByFive
		Process: With the five integer numbers the system will calculate if there is at least a number of the five integers
		that is divisible by five, for that, in console, two variables will be defined, the first one as a boolean, this one
		is going check as the past process if the number is divisible by 5 doing the modular of the number by five and
		comparing if the result is equal to zero and of that way with a chain of or if one of the modular is equal to zero,
		it will be in off to set the boolean variable to true which will make that the next variable that is a String, will
		set a text to prove that there is one number at least divisible by five, if is not, it will assign a text saying that
		there is no number divisible by five. As last step, the system should show the result in the screen.
		*/
		public static void numberDivisibleByFive(int v1, int v2, int v3, int v4, int v5) {
			
			//There is at least a number divisible by 5
			boolean divisibleByFive = v1%5==0 || v2%5==0 || v3%5==0 || v4%5==0 || v5%5==0;
			String resultDivisibleByFive = divisibleByFive==true ? "There is one number at least divisible by 5." : "There is no number divisible by 5.";
			System.out.println(resultDivisibleByFive);
		
		}
		
		/* 
		Input: v1, v2, v3, v4, v5
		Output: highestTotalValue
		Process: With the five integer numbers the system will calculate which of the numbers is the higher, by four
		int variable, the system will check which number is the higher, the system will first compare the two first
		integer values to save the value of the higher integer and it will do the same for other three times, comparing
		the last saved value with the following integer to compare, in order to that process, the last variable will
		contain the value of the highest integer. As last, the console should show the result in screen.
		*/
		public static void theHigherValue(int v1, int v2, int v3, int v4, int v5) {
			
			//Which is the highest value of the five integers.
			int highestValue1 = v1>v2 ? v1 : v2;
			int highestValue2 = highestValue1>v3 ? highestValue1 : v3 ;
			int highestValue3 = highestValue2>v4 ? highestValue2 : v4;
			int highestTotalValue = highestValue3>v5 ? highestValue3 : v5;
			System.out.println("The highest value is: " + highestTotalValue);
		
		}
	
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Welcome, type the first integer");
			int firstValue = scanner.nextInt();
			System.out.println("Then, type the second integer");
			int secondValue = scanner.nextInt();
			System.out.println("Type the third integer");
			int thridValue = scanner.nextInt();
			System.out.println("Type the fourth integer");
			int fourthValue = scanner.nextInt();
			System.out.println("Type the fifth integer");
			int fifthValue = scanner.nextInt();
			
			System.out.println("");
            average(firstValue, secondValue, thridValue, fourthValue, fifthValue);
			divisible(firstValue, secondValue, thridValue, fourthValue, fifthValue);
			numberDivisibleByFive(firstValue, secondValue, thridValue, fourthValue, fifthValue);
			theHigherValue(firstValue, secondValue, thridValue, fourthValue, fifthValue);
			System.out.println("");
		}
	
	
	}