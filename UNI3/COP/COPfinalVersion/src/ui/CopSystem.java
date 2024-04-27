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
	
			System.out.println("Welcome, choose an option to start. \n1. Administrative menu \n2. Queries menu \n3. EXIT");
			option = scanner.nextInt();
			
			// Administrative menu
			if (option==1) {
				option=administrativeMenu();
				switch(option) {
				case 1: // Register community
						registerCommunity(objAdmin);
						break;
						
				case 2: // Register place
						registerPlace(objAdmin);
						break;
						
				case 3: // Register product
						registerProduct(objAdmin);
						break;
						
				case 4: // Delete product
						deleteProduct(objAdmin);
						break;
						
				case 5: // Add species to a place
						addSpecieToPlace(objAdmin);
						break;
						
				case 6: // Update species data in a place
						updateSpecieToPlace(objAdmin);
						break;
						
				case 7: // Test cases
						testCase(objAdmin);
						break;
						
				case 8: break;
						
				default: System.out.println("Non valid option");
				}
			}
			
			// Queries menu
			else if (option==2) {
				option=queriesMenu();
				switch(option) {
					
				case 1: // Query information about a place
						showPlace(objAdmin);
						break;
				
				case 2: // Query the information of the communities of a department
						showDepartmentCommunity(objAdmin);
						break;
						
				case 3: // Query communities by lack of hospital or school 
						showCommunityWithMajorProblems(objAdmin);
						break;
						
				case 4: // Query the name of the place with the highest number of species
						showPlaceNameWithMostSpecies(objAdmin);
						break;
						
				case 5: // Query the three largest places per square kilometer
						showThreeBiggestPlacesPerSquareKm(objAdmin);
						break;
				
				case 6: break;
						
				default: System.out.println("Non valid option");
				}
			}
			
			else if (option==3) {
				exit=true;
				scanner.close();
			}
			
			else {System.out.println("You need to enter a valid option");}
		
		} while (!exit);
		
	}
	
	// -----BEGINNING OF METHODS-----
	
	// 1. Administrative Menu | METHOD int
			/**
			*
			* This method will display to the user, the possible options to choose from the administrative menu and will return the selected option.
			*
			* @return option This variable return an int which will work for choose a option from the administrative menu 
			*
			*/
	public static int administrativeMenu() {
		int option=0;
		System.out.println("1. Register community \n2. Register place \n3. Register product \n4. Delete product \n5. Add species to a place \n6. Update species data in a place \n7. Test Case \n8. EXIT TO MAIN MENU");
		option=scanner.nextInt();
		scanner.nextLine();
		return option;
	}
	
	// 1.1 Register Community | METHOD void
			/**
			*
			* This method will allow to the user create a community by indicating all his attributes.
			*
			* @param objAdmin This object will be a link between Controller class and CopSystem for create a community attached to the admin user.
			*
			*/
	public static void registerCommunity(Controller objAdmin) {
		String communityName;
		int communityTypeSelection = 0;
		String communityBossName;
		String communityBossPhoneNumber;
		int communityAmountInhabitants;
		
		boolean selectionChecker=true;
		
			System.out.println("Write the name of the community");
			communityName=scanner.nextLine();
			System.out.println("Choose the type of the community: \n[1] Afrocolombian \n[2] Indigenous \n[3] Raizal");
			while (selectionChecker) {
			communityTypeSelection = scanner.nextInt();
			scanner.nextLine();
				if (communityTypeSelection==1) {
					selectionChecker=false;
				}
				else if (communityTypeSelection==2) {
					selectionChecker=false;
				}
				else if (communityTypeSelection==3) {
					selectionChecker=false;
				} else {System.out.println("You did not choose a valid option.");}
			}
			selectionChecker=true;
			System.out.println("Write the name of community Boss");
			communityBossName=scanner.nextLine();
			System.out.println("Write the community Boss's phone number");
			communityBossPhoneNumber=scanner.nextLine();
			System.out.println("Write the number of major problems of the community");
			int amountOfProblems = scanner.nextInt();
			scanner.nextLine();
			
			int[] tempCommunityMajorProblems = new int[amountOfProblems];
			
			System.out.println("Choose the major problems of the community: \n[1] Lack of hospital \n[2] Lack of school \n[3] Lack of potable water \n[4] Lack of access to basic food");
			for (int i = 0; i < amountOfProblems; i++) {
				while (selectionChecker) {
					int tempSelection = scanner.nextInt();
					scanner.nextLine();
					if (tempSelection>=1 && tempSelection<=4) {
						tempCommunityMajorProblems[i]=tempSelection;
						selectionChecker=false;
					} else {System.out.println("You did not choose a valid option.");}
				}
				selectionChecker=true;
			}
				

			System.out.println("Write the inhabitants amount of the community");
			communityAmountInhabitants=scanner.nextInt();
			
		String message=objAdmin.registerCommunity(communityName, communityTypeSelection, communityBossName, communityBossPhoneNumber, tempCommunityMajorProblems, communityAmountInhabitants, amountOfProblems);
		System.out.println(message);
	}
	
	// 1.2 Register Place | METHOD void
			/**
			*
			* This method will allow to the user create a place by indicating all his attributes.
			*
			* @param objAdmin This object will be a link between Controller class and CopSystem for create a place attached to the admin user.
			*
			*/
	public static void registerPlace(Controller objAdmin) {
		String placeName;
		int placeDepartmentSelection = 0;
		double amountOfSquareKm;
		int placeTypeSelection = 0;
		String placeOpeningDate;
		String placePhoto;
		String communityName;
		double placeFinancialResourcesRequired;
		
		boolean selectionChecker=true;
		
			System.out.println("Write the name of the place");
			placeName=scanner.nextLine();
			System.out.println("Write the department correspondent to the place: \n[1] Choco \n[2] Valle \n[3] Cauca \n[4] Narino");
			while (selectionChecker) {
			placeDepartmentSelection = scanner.nextInt();
			scanner.nextLine();
				if (placeDepartmentSelection==1) {
					selectionChecker=false;
				}
				else if (placeDepartmentSelection==2) {
					selectionChecker=false;
				}
				else if (placeDepartmentSelection==3) {
					selectionChecker=false;
				}
				else if (placeDepartmentSelection==4) {
					selectionChecker=false;
				} else {System.out.println("You did not choose a valid option.");}
			}
			selectionChecker=true;
			System.out.println("Write the amount of square KM's of the place");
			amountOfSquareKm=scanner.nextDouble();
			scanner.nextLine();
			System.out.println("Write the type of the place: \n[1] Protected \n[2] National Park \n[3] Private");
			while (selectionChecker) {
			placeTypeSelection = scanner.nextInt();
			scanner.nextLine();
				if (placeTypeSelection==1) {
					selectionChecker=false;
				}
				else if (placeTypeSelection==2) {
					selectionChecker=false;
				}
				else if (placeTypeSelection==3) {
					selectionChecker=false;
				} else {System.out.println("You did not choose a valid option.");}
			}
			selectionChecker=true;
			System.out.println("Write the place opening date");
			placeOpeningDate=scanner.nextLine();
			System.out.println("Place the URL image of the place");
			placePhoto=scanner.nextLine();
			System.out.println("Select a community to add it to the place");
			communityName=scanner.nextLine();
			System.out.println("Type the amount of money to take care of the place");
			placeFinancialResourcesRequired=scanner.nextDouble();
			scanner.nextLine();
			
		String message=objAdmin.registerPlace(placeName, placeDepartmentSelection, amountOfSquareKm, placeTypeSelection, placeOpeningDate, placePhoto, communityName, placeFinancialResourcesRequired);
		System.out.println(message);	
		
	}
	
	// 1.3 Register Product | METHOD void
			/**
			*
			* This method will allow to the user create a product by indicating all his attributes.
			*
			* @param objAdmin This object will be a link between Controller class and CopSystem for create a product attached to the admin user.
			*
			*/
	public static void registerProduct(Controller objAdmin) {
		String productName;
		double productNaturalPercentage;
		int productTypeSelection = 0;
		String productHandmade;
		String communityName;
		
		boolean selectionChecker=true;

			System.out.println("Write the name of the product");
			productName = scanner.nextLine();
			System.out.println("Write the natural percentage of the product");
			productNaturalPercentage = scanner.nextDouble();
			scanner.nextLine();
			System.out.println("Write the type of the product: \n[1] Food \n[2] Craft");
			while (selectionChecker) {
			productTypeSelection = scanner.nextInt();
			scanner.nextLine();
				if (productTypeSelection==1) {
					selectionChecker=false;
				}
				else if (productTypeSelection==2) {
					selectionChecker=false;
				} else {System.out.println("You did not choose a valid option.");}
			}
			selectionChecker=true;
			System.out.println("Write if the product is handmade (yes/no)");
			productHandmade = scanner.nextLine();
			System.out.println("Select a community to attach the product to:");
			communityName = scanner.nextLine();
		
		String message = objAdmin.registerProduct(productName, productNaturalPercentage, productTypeSelection, productHandmade, communityName);
		System.out.println(message);
	
	}
	
	// 1.4 Delete Product | METHOD void
			/**
			*
			* This method will allow to the user delete a product that has been already registered.
			*
			* @param objAdmin This object will be a link between Controller class and CopSystem for delete a product attached to the admin user.
			*
			*/
	public static void deleteProduct(Controller objAdmin) {
		System.out.println("Enter the name of the product to delete:");
		String productNameToDelete = scanner.nextLine();
  
		String message = objAdmin.deleteProduct(productNameToDelete);
		System.out.println(message);
	}
	
	// 1.5 Add species to a place | METHOD void
			/**
			*
			* This method will allow to the user create a specie by indicating all his attributes and then link it to a place.
			*
			* @param objAdmin This object will be a link between Controller class and CopSystem for create a specie attached to the admin user.
			*
			*/
	public static void addSpecieToPlace(Controller objAdmin) {
		    String specieName;
			int specieBiodiversityTypeSelection = 0;
			String speciePhoto;
			int specieLivingAmount;
			String placeName;
			
			boolean selectionChecker=true;

				System.out.println("Write the name of the specie:");
				specieName = scanner.nextLine();
				System.out.println("Choose the biodiversity type of the specie: \n[1] Flora \n[2] Fauna");
				while (selectionChecker) {
				specieBiodiversityTypeSelection = scanner.nextInt();
				scanner.nextLine();
					if (specieBiodiversityTypeSelection==1) {
						selectionChecker=false;
					}
					else if (specieBiodiversityTypeSelection==2) {
						selectionChecker=false;
					} else {System.out.println("You did not choose a valid option.");}
				}
				selectionChecker=true;
				System.out.println("Enter the URL image of the specie:");
				speciePhoto = scanner.nextLine();
				System.out.println("Write the number of living specimens of the specie:");
				specieLivingAmount = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Select a place to attach the specie to:");
				placeName = scanner.nextLine();

			String message = objAdmin.addSpecieToPlace(specieName, specieBiodiversityTypeSelection, speciePhoto, specieLivingAmount, placeName);
			System.out.println(message);
	}
	
	// 1.6 Update species data in a place | METHOD void
			/**
			*
			* This method will allow to the user update specie data in a place by indicating the attributes to update.
			*
			* @param objAdmin This object will be a link between Controller class and CopSystem for update registered species data in a place attached to the admin user.
			*
			*/
	public static void updateSpecieToPlace(Controller objAdmin) {
		    String specieName;
			String attributeToUpdate;
			int newSpecieBiodiversityTypeSelection = 0;
			String newSpeciePhoto = "";
			int newSpecieLivingAmount = 0;
			String newSpecieName = "";

			System.out.println("Enter the name of the specie to update:");
			specieName = scanner.nextLine();

				System.out.println("Choose the attribute to update: \n[1] Specie Name \n[2] Biodiversity Type \n[3] Specie Photo \n[4] Living Amount");
				int selection = scanner.nextInt();
				scanner.nextLine();

				switch (selection) {
					case 1:
						System.out.println("Enter new specie name:");
						newSpecieName = scanner.nextLine();
						break;
					case 2:
						System.out.println("Choose the new biodiversity type: \n[1] Flora \n[2] Fauna");
						boolean selectionChecker=true;
						while (selectionChecker) {
						newSpecieBiodiversityTypeSelection = scanner.nextInt();
						scanner.nextLine();
							if (newSpecieBiodiversityTypeSelection==1) {
								selectionChecker=false;
							}
							else if (newSpecieBiodiversityTypeSelection==2) {
								selectionChecker=false;
							} else {System.out.println("You did not choose a valid option.");}
						}
						selectionChecker=true;
						break;
					case 3:
						System.out.println("Enter new specie photo URL:");
						newSpeciePhoto = scanner.nextLine();
						break;
					case 4:
						System.out.println("Enter new living amount:");
						newSpecieLivingAmount = scanner.nextInt();
						scanner.nextLine();
						break;
					default:
						System.out.println("Invalid option");
						return;
				}
				String message = objAdmin.updateSpecie(specieName, newSpecieBiodiversityTypeSelection, newSpeciePhoto, newSpecieLivingAmount, newSpecieName);
				System.out.println(message);
			}
			
	// 1.7 Test Case | METHOD void
			/**
			*
			* This method will create objects to test the program.
			*
			* @param objAdmin This object will be a link between Controller class for register objects.
			*
			*/
	public static void testCase(Controller objAdmin) {
		String message = objAdmin.createTestCaseValues();
		System.out.println(message);
	}
				
	// 2. Queries Menu | METHOD int
			/**
			*
			* This method will display to the user, the possible options to choose from the queries menu and will return the selected option.
			*
			* @return option This variable return an int which will work for choose a option from the queries menu 
			*
			*/
	public static int queriesMenu() {
		int option=0;
		System.out.println("1. Query information about a place \n2. Query the information of the communities of a department \n3. Query communities by lack of hospital or school \n4. Query the name of the place with the highest number of species \n5. Query the three largest places per square kilometer \n6. EXIT TO MAIN MENU");
		option=scanner.nextInt();
		scanner.nextLine();
		return option;
	}
	
	// 2.1 Query information about a place | METHOD void
			/**
			*
			* This method will show to the user all the information about a specific place.
			*
			* @param objAdmin This object will be a link between Controller class and CopSystem for show a place attached to the admin user.
			*
			*/
	public static void showPlace(Controller objAdmin) {
		String placeName;
		
			System.out.println("Write the name of the place");
			placeName=scanner.nextLine();
			
			String message = objAdmin.showPlace(placeName);
			System.out.println(message);
		
	}
	
	// 2.2 Query the information of the communities of a department | METHOD void
			/**
			*
			* This method will show to the user all the information about all the communities in a specific department.
			*
			* @param objAdmin This object will be a link between Controller class and CopSystem for show all the information about all the communities in a specific department attached to the admin user.
			*
			*/
	public static void showDepartmentCommunity(Controller objAdmin) {
		int placeDepartmentSelection = 0;
		
			System.out.println("Select the department correspondent for search his communities: \n[1] Choco \n[2] Valle \n[3] Cauca \n[4] Narino");
			boolean selectionChecker=true;
			while (selectionChecker) {
			placeDepartmentSelection = scanner.nextInt();
			scanner.nextLine();
				if (placeDepartmentSelection==1) {
					selectionChecker=false;
				}
				else if (placeDepartmentSelection==2) {
					selectionChecker=false;
				}
				else if (placeDepartmentSelection==3) {
					selectionChecker=false;
				}
				else if (placeDepartmentSelection==4) {
					selectionChecker=false;
				} else {System.out.println("You did not choose a valid option.");}
			}
			selectionChecker=true;
			
			String message = objAdmin.showCommunityDepartment(placeDepartmentSelection);
			System.out.println(message);
		
	}
	
	// 2.3 Query communities by lack of hospital or school | METHOD void
			/**
			*
			* This method will show to the user all the communities that match with the conditions of major problems.
			*
			* @param objAdmin This object will be a link between Controller class and CopSystem for show all the information about all the communities that match with the conditions of major problems attached to the admin user.
			*
			*/
	public static void showCommunityWithMajorProblems(Controller objAdmin) {
		String message = objAdmin.queryCommunityMajorProblem();
		System.out.println(message);
	}
	
	// 2.4 Query the name of the place with the highest number of species | METHOD void
			/**
			*
			* This method will show to the user the place with the most highest number of species.
			*
			* @param objAdmin This object will be a link between Controller class and CopSystem for show the place with the most highest number of species attached to the admin user.
			*
			*/
	public static void showPlaceNameWithMostSpecies(Controller objAdmin) {
		String message = objAdmin.queryPlaceNameWithMostSpecies();
		System.out.println(message);
	}
	
	// 2.5 Query the three largest places per square kilometer | METHOD void
			/**
			*
			* This method will show to the user the three largest places per square kilometer.
			*
			* @param objAdmin This object will be a link between Controller class and CopSystem for show the three largest places per square kilometer attached to the admin user.
			*
			*/
	public static void showThreeBiggestPlacesPerSquareKm(Controller objAdmin) {
		String message = objAdmin.queryThreeBiggestPlacesPerSquareKm();
		System.out.println(message);
	}
	
}