	
	import java.util.Scanner;
	public class landBustamante {
		
		/* 
		Input: landPerimeterValue
		Output: groundH
		Process: Just with value of the perimeter, the console will calculate the ground height
		knowing that the base is 2(x+6) and height is equal to 2x which carries to the perimeter,
		so the numeric sentece in the code is solved to find the ground Height.
		*/
		public static void groundHeight(double landPerimeterValue) {
			
			//GroundHeight knowing that perimeter is equal to 2(x+6)+2x
			double groundH = (landPerimeterValue-12)/4;
			System.out.println("The total height of the land is: " + groundH);
			groundArea(landPerimeterValue, groundH);
			
		}
		
		public static void groundArea(double landPerimeterValue, double groundH) {
			
			//GroundHeight 
			double groundA = groundH*(groundH+6);
			System.out.println("The total area of the land is: " + groundA);
			
			}
		
	
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Welcome, Sr. Bustamante, type the land perimeter: ");
			double landPerimeter = scanner.nextDouble();
			
			System.out.println("");
            groundHeight(landPerimeter);
			System.out.println("");
		}
	
	
	}