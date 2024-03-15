	
	import java.util.Scanner;
	public class teacherClass {
		
		public static void main (String[] args) {
			
			Scanner lector=new Scanner(System.in);
			System.out.println("Welcome, type the amount of men in your class");
			int men = lector.nextInt();
			System.out.println("Type the amount of women in your class");
			int women = lector.nextInt();
			int total = men+women;
			System.out.println("The percentage of men is equal to " + ((100*men)/total) + "% and the percentage of women is equal to " + ((100*women)/total) + "%.");
			
		}
	}