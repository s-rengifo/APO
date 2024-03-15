	
	import java.util.Scanner;
	public class gradesAVG {
			
			// -----BEGINNING OF METHODS-----
			
			// Method VOID
			/**
			*
			* N/A
			*
			*/
	public static void averageCalculator(int grades[]) {
				double sumValues = 0;
				int i = 0;
				double average = 0;
				for (i=0; i<5; i++) {
				sumValues =  sumValues + grades[i];
				average = sumValues/5;
				}
				System.out.println("The average of the 5 grades is: " + average);
			}
			
		// -----END OF METHODS-----
		
		// Main Class
		public static void main(String[] args) {
			
			Scanner lector = new Scanner(System.in);
			System.out.println("Welcome student");
			int [] grades = new int[5];
			int grade = 0;
			int i = 0;
			for (i=0; i<5; i++) {
				grade++;
				System.out.println("Type the grade #" + grade + ":");
				grades[i]=lector.nextInt();
			}
			double average = 0;
			averageCalculator(grades);
			// SystemOutPrint Array
		}
	}
	
	// Samuel J. Rengifo A00404150