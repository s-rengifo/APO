package ui;
import java.util.Scanner;
import model.University;

public class Main {
	
public static Scanner scanner= new Scanner(System.in);
	
	public static void main(String[] args) {
		
		University objAdmin= new University("admin","admin");
		
		boolean exit=false;
		int option=0;
		do {
			
				option=mainMenu();
				switch(option) {
				case 1: // Register professor
						System.out.println("Select the professor type to register:");
						System.out.println("[1] Full-Time Professor \n[2] Part-Time Professor");
						int professorType = scanner.nextInt();
						scanner.nextLine();
						switch (professorType) {
                        case 1:
                            registerFullTimeProfessor(objAdmin);
                            break;
                        case 2:
                            registerPartTimeProfessor(objAdmin);
                            break;
                        default:
                            System.out.println("Non valid option");
						}
						break;
						
				case 2: // Show all registered professors
						queryAllProfessor(objAdmin);
						break;
						
				case 3: // Calculate salary of the professors
						calculateSalaryProfessor(objAdmin);
						break;
						
				case 4: // Query FullTime professors which his bonus salary is higher than 2M 
						queryFullTimeBonusHigherTwoM(objAdmin);
						break;
				
				case 5: exit=true;
						break;
						
				default: System.out.println("Non valid option");
				}
		
		} while (!exit);
		
	}
	
	// -----BEGINNING OF METHODS-----
	
	// 1. Main Menu | METHOD int
			/**
			*
			* This method will display to the user, the possible options to choose from the administrative menu and will return the selected option.
			*
			* @return option This variable return an int which will work for choose a option from the administrative menu 
			*
			*/
	public static int mainMenu() {
		int option=0;
		System.out.println("1. Register professor \n2. Show all registered professors \n3. Show the salary of all the professors \n4. Query FullTime professors which his bonus salary is higher than 2M \n5. EXIT");
		option=scanner.nextInt();
		scanner.nextLine();
		return option;
	}
	
	 // 1.11 Register Full-Time Professor | METHOD void
			 /**
			 *
			 * This method allows the user to register a Full-Time Professor by providing all necessary attributes
			 *
			 * @param objAdmin The University object through which the Full-Time Professor will be registered
			 *
			 */
	public static void registerFullTimeProfessor(University objAdmin) {
		String professorName;
		String professorSurname;
		String professorId;
		double professorBaseSalary;
		int extraHoursAmount;
		double bonusSalary;

		System.out.println("Write the name of the professor:");
		professorName = scanner.nextLine();
		System.out.println("Write the surname of the professor:");
		professorSurname = scanner.nextLine();
		System.out.println("Write the identification of the professor:");
		professorId = scanner.nextLine();
		System.out.println("What is the base salary of the professor:");
		professorBaseSalary = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Write the extra hours amount of the professor:");
		extraHoursAmount = scanner.nextInt();
		System.out.println("Write the bonus salary of the professor:");
		bonusSalary = scanner.nextDouble();
		scanner.nextLine();

		String message = objAdmin.registerFullTimeProfessor(professorName, professorSurname, professorId, professorBaseSalary, extraHoursAmount, bonusSalary);
		System.out.println(message);
	}
    
    // 1.12 Register Part-Time Professor | METHOD void
		 /**
		 *
		 * This method allows the user to register a Part-Time Professor by providing all necessary attributes
		 *
		 * @param objAdmin The University object through which the Part-Time Professor will be registered
		 *
		 */
    public static void registerPartTimeProfessor(University objAdmin) {
        String professorName;
        String professorSurname;
        String professorId;
		double professorBaseSalary;
        int workedHoursAmount;
        
        System.out.println("Write the name of the professor:");
        professorName = scanner.nextLine();
        System.out.println("Write the surname of the professor:");
        professorSurname = scanner.nextLine();
        System.out.println("Write the identification of the professor:");
        professorId = scanner.nextLine();
		System.out.println("What is the base salary of the professor:");
		professorBaseSalary = scanner.nextDouble();
		scanner.nextLine();
        System.out.println("Write the worked hours amount of the professor:");
        workedHoursAmount = scanner.nextInt();
        scanner.nextLine();
        
        String message = objAdmin.registerPartTimeProfessor(professorName, professorSurname, professorId, professorBaseSalary, workedHoursAmount);
        System.out.println(message);
    }
	
	   // 1.2 Query all Professors | METHOD void
		 /**
		 *
		 * This method allows the query all the registered professors
		 *
		 * @param objAdmin The University object through which the professors will be registered
		 *
		 */
	    public static void queryAllProfessor(University objAdmin) {
        
        String message = objAdmin.queryAllProfessor();
        System.out.println(message);
		}
		
		 // 1.3 Calculate salary of all Professors | METHOD void
		 /**
		 *
		 * This method allows the query all the professors salary
		 *
		 * @param objAdmin The University object through which the professors salary will be displayed
		 *
		 */
	    public static void calculateSalaryProfessor(University objAdmin) {
        
        String message = objAdmin.calculateSalaryProfessor();
        System.out.println(message);
		}
		
		 // 1.4 Query FullTime professors which his bonus salary is higher than 2M  | METHOD void
		 /**
		 *
		 * This method allows the query of FullTime professors which his bonus salary is higher than 2M
		 *
		 * @param objAdmin The University object through which the professors will be displayed
		 *
		 */
	    public static void queryFullTimeBonusHigherTwoM(University objAdmin) {
        
        String message = objAdmin.queryFullTimeBonusHigherTwoM();
        System.out.println(message);
		}
		
}