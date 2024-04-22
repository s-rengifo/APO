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
						registerProfessor(objAdmin);
						break;
						
				case 2: // Register project to a professor
						registerProyectProfessor(objAdmin);
						break;
						
				case 3: // Show project with higher inversion
						showProyectHigherInversion(objAdmin);
						break;
						
				case 4: // Show professor which his role is observer
						showObserverProfessor(objAdmin);
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
		System.out.println("1. Register professor \n2. Register proyect to a professor \n3. Show project with higher inversion \n4. Show professor which his role is observer \n5. EXIT");
		option=scanner.nextInt();
		scanner.nextLine();
		return option;
	}
	
	// 1.1 Register Professor | METHOD void
			/**
			*
			* This method will allow to the user create a community by indicating all his attributes.
			*
			* @param objAdmin This object will be a link between Controller class and CopSystem for create a community attached to the admin user.
			*
			*/
	public static void registerProfessor(University objAdmin) {
		
		String professorName;
		String professorSurname;
		String professorId;
		
		boolean selectionChecker=true;
		
			System.out.println("Write the name of the professor");
			professorName=scanner.nextLine();
			System.out.println("Write the surname of the professor");
			professorSurname=scanner.nextLine();
			System.out.println("Write the identification of the professor");
			professorId=scanner.nextLine();
			
		String message=objAdmin.registerProfessor(professorName, professorSurname, professorId);
		System.out.println(message);
	}
	
	// 1.2 Register project to a professor | METHOD void
			/**
			*
			* This method will allow to the user create a community by indicating all his attributes.
			*
			* @param objAdmin This object will be a link between Controller class and CopSystem for create a community attached to the admin user.
			*
			*/
	public static void registerProyectProfessor(University objAdmin) {
		
		String proyectName;
		double proyectInversion;
		int proyectRoleSelection = 0;
		String professorName;
		
		boolean selectionChecker=true;
		
			System.out.println("Write the name of the proyect");
			proyectName=scanner.nextLine();
			System.out.println("Write the proyect inversion ($)");
			proyectInversion=scanner.nextDouble();
			scanner.nextLine();
			System.out.println("Choose the proyect role: \n[1] Leader \n[2] Executant \n[3] Observer");
				while (selectionChecker) {
				proyectRoleSelection = scanner.nextInt();
				scanner.nextLine();
					if (proyectRoleSelection==1) {
						selectionChecker=false;
					}
					else if (proyectRoleSelection==2) {
						selectionChecker=false;
					}
					else if (proyectRoleSelection==3) {
						selectionChecker=false;
					} else {System.out.println("You did not choose a valid option.");}
				}
			selectionChecker=true;
			System.out.println("Write a professor (NAME) to attach the proyect to:");
			professorName = scanner.nextLine();
			
		String message=objAdmin.registerProyectProfessor(proyectName, proyectInversion, proyectRoleSelection, professorName);
		System.out.println(message);
	}
	
	// 1.3 Show project with higher inversion | METHOD void
	public static void showProyectHigherInversion(University objAdmin) {
		
			String message = objAdmin.queryProyectHigherInversion();
			
			System.out.println(message);
		
	}
	
	// 1.4 Show professors which their role is observer | METHOD void
			/**
			*
			* This method will show to the user all the information about all the professors as role as observer.
			*
			* @param objAdmin This object will be a link between University class and Main for show all the information about all the professors as role as observer attached to the admin user.
			*
			*/
	public static void showObserverProfessor(University objAdmin) {
		int proyectRoleSelection = 3;
		
			String message = objAdmin.queryObserverProfessor(proyectRoleSelection);
			System.out.println(message);
		
	}
	
}