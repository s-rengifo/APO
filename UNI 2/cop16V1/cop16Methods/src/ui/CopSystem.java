package ui;
import java.util.Scanner;
import model.Controller;

public class CopSystem {
	
	public static Scanner scanner= new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Controller objAdmin= new Controller("admin","admin");
		
		boolean exit=false;
		int option=0;
		do {
			option=menu();
			switch(option) {
			case 1: //Register community
					addCommunity(objAdmin);
					break;
					
			case 2: //Query amount of registered communities by a type
					queryRegisteredAmountOfCommunitiesDependingOfType(objAdmin);
					break;
					
			case 3: // Query community by lack of Hospital and School 
					displayCommuntiesByLackOfHospitalAndSchool(objAdmin);
					break;
					
			case 4: exit=true;
					scanner.close();
					break;
			
			default: System.out.println("Non valid option");
			}
		
		} while (!exit);
		
	}
	
	public static int menu() {
		int option=0;
		System.out.println("1.Register Community \n2.Query the amount of communities depending of the type \n3.Query community by major problems as lack of Hospital and School \n4.Exit");
		option=scanner.nextInt();
		scanner.nextLine();
		return option;
	}
	
	public static void addCommunity(Controller objAdmin) {
		String communityName;
		String communityType;
		String communityBossName;
		String communityBossPhoneNumber;
		String[] communityMajorProblems;
		//PDTE
		String communityProduct;
		int communityAmountInhabitants;
		
			System.out.println("Write the name of the community");
			communityName=scanner.nextLine();
			System.out.println("Write the type of the community");
			communityType=scanner.nextLine();
			System.out.println("Write the name of community Boss");
			communityBossName=scanner.nextLine();
			System.out.println("Write the community Boss's phone number");
			communityBossPhoneNumber=scanner.nextLine();
			System.out.println("Write the number of major problems of the community");
			int amountOfProblems = scanner.nextInt();
			scanner.nextLine();
			communityMajorProblems = new String[amountOfProblems];
			System.out.println("Write the major problems of the community");
			for (int i = 0; i < amountOfProblems; i++) {
				communityMajorProblems[i] = scanner.nextLine();
			}
			System.out.println("Write the community product");
			communityProduct=scanner.nextLine();
			System.out.println("Write the inhabitants amount of the community");
			communityAmountInhabitants=scanner.nextInt();
			
		String message=objAdmin.addCommunity(communityName, communityType, communityBossName, communityBossPhoneNumber, communityMajorProblems, communityProduct, communityAmountInhabitants);
		System.out.println(message);
	}
	
	public static void queryRegisteredAmountOfCommunitiesDependingOfType(Controller objAdmin) {
		String communityTypeToCheck;
		
			System.out.println("Write the type of the community for check how many communities are registered");
			communityTypeToCheck=scanner.nextLine();
			
		String message=objAdmin.queryRegisteredAmountOfCommunitiesDependingOfType(communityTypeToCheck);
		System.out.println(message);
	}
	
	public static void displayCommuntiesByLackOfHospitalAndSchool(Controller objAdmin) {
	String message=objAdmin.displayCommuntiesByLackOfHospitalAndSchool();
	System.out.println(message);
	}
}