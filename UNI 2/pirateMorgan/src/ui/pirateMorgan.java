package ui;
import java.util.Scanner;
import model.captainMorganSystem;

public class pirateMorgan {
	
	public static Scanner scanner= new Scanner(System.in);
	
	public static void main(String[] args) {
		
		captainMorganSystem objMorgan= new captainMorganSystem("28374059","Juan Rosa Do Santino","El Pirata", 200000, 500000);
		
		boolean exit=false;
		int option=0;
		do {
			option=menu();
			switch(option) {
			case 1: //Register client
					addClient(objMorgan);
					break;
					
			case 2: //Update ship info
					updateShip(objMorgan);
					break;
					
			case 3: //Display all clients
					displayClients(objMorgan);
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
		System.out.println("1.Register Client \n2.Update ship data \n3.Display all the clients \n4.Exit");
		option=scanner.nextInt();
		scanner.nextLine();
		return option;
	}
	
	public static void updateShip(captainMorganSystem objMorgan) {
		int option=0;
		System.out.println("What do you want to change?: \n 1.Name \n 2.Limit Min \n 3.Limit Max");
		option=scanner.nextInt();
		scanner.nextLine();
		String newShipName="";
		double newMinLim=0;
		double newMaxLim=0;
		
		if (option==1) {
			System.out.println("Write the new ship name");
			newShipName=scanner.nextLine();
		}
		else if(option==2) {
			System.out.println("Write the new min limit");
			newMinLim=scanner.nextDouble();
		}
		
		objMorgan.updateInfoShip(option, newShipName, newMinLim, newMaxLim);
	}
	
	public static void addClient(captainMorganSystem objMorgan) {
		String pNameClient;
		String pNitClient;
		
			System.out.println("Write the name of the client to add");
			pNameClient=scanner.nextLine();
			System.out.println("Write the NIT of the client to add");
			pNitClient=scanner.nextLine();
			
		String message=objMorgan.addClient(pNitClient, pNameClient);
		System.out.println(message);
	}
	
	public static void displayClients(captainMorganSystem objMorgan) {
		objMorgan.displayClients();
	}
}