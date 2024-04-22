package model;
public class Controller{
	// Atributes
	private String user;
	private String password;

	// Relations
	private Community[] communityList;
	private Place[] placeList;

	// Services
	
	/**
     * 
     * Constructor for the Controller class, initializes the user, password, community list, and place list.
     * 
     * @param user The username for the controller.
     * @param password The password for the controller.
	 *
     */
	public Controller (String user, String password) {
		this.user=user;
		this.password=password;
		communityList= new Community[50];
		placeList= new Place[50];
	}
	
	 /**
	 *
     * Registers a new community
     * 
     * @param communityName The name of the community
     * @param communityTypeSelection An int which indicates type of the community
     * @param communityBossName The name of the community boss
     * @param communityBossPhoneNumber The phone number of the community boss
     * @param tempCommunityMajorProblems The selection of major problems faced by the community
     * @param communityAmountInhabitants The number of inhabitants in the community
	 * @param amountOfProblems Indicate the amount of problems to create an array
     * @return A message indicating the success or failure of the operation
	 *
     */
	public String registerCommunity(String communityName, int communityTypeSelection, String communityBossName, String communityBossPhoneNumber, int[] tempCommunityMajorProblems, int communityAmountInhabitants, int amountOfProblems) {
		String message="Community succesfully created";
		Community.CommunityType communityType = null;
		boolean avalible = communityAvailable();
		if (avalible==true) {
			Community objTemporal=searchCommunity(communityName);
			if (objTemporal==null) {
				boolean exit=false;
				for (int i = 0; i < communityList.length && !exit; i++) {
					if (communityList[i] == null) {
						
						if (communityTypeSelection==1) {
							communityType=Community.CommunityType.AFR;
						}
						else if (communityTypeSelection==2) {
							communityType=Community.CommunityType.IND;
						}
						else if (communityTypeSelection==3) {
							communityType=Community.CommunityType.RAI;
						}
						
						Community.CommunityMajorProblems[] communityMajorProblems = new Community.CommunityMajorProblems[amountOfProblems];
						for (int j = 0; j < amountOfProblems; j++) {
							if (tempCommunityMajorProblems[j]==1) {
							communityMajorProblems[j]=Community.CommunityMajorProblems.HOS;
							}
							else if (tempCommunityMajorProblems[j]==2) {
								communityMajorProblems[j]=Community.CommunityMajorProblems.SCH;
							}
							else if (tempCommunityMajorProblems[j]==3) {
								communityMajorProblems[j]=Community.CommunityMajorProblems.WAT;
							}
							else if (tempCommunityMajorProblems[j]==4) {
								communityMajorProblems[j]=Community.CommunityMajorProblems.FOD;
							}
						}
						
						objTemporal = new Community(communityName, communityType, communityBossName, communityBossPhoneNumber, communityMajorProblems, communityAmountInhabitants);
						communityList[i] = objTemporal;
						exit=true;
					}
				}
			} else
			message = "The community is already created.";
		}
		else
		message="Error, you cannot add more communities.";	
	return message;
	}
	
	/**
	 *
     * Checks if there is an available slot in the community list
     * 
     * @return True if there is an available slot, false otherwise
	 *
     */
	public boolean communityAvailable() {
		for (int i = 0; i<communityList.length; i++) {
			if (communityList[i] == null) {
				return true;
			}
		}
        return false;
    }

	/**
	 *
     * Searches a community by his name
     * 
     * @param communityName The name of the community to search for
     * @return The community object if found, null otherwise
	 *
     */
    public Community searchCommunity(String communityName) {
		
        for (int i = 0; i < communityList.length; i++) {
			if (communityList[i] != null && communityList[i].getName().equals(communityName)) {
				return communityList[i];
			}
		}
    return null;
	
    }
	
	/**
	 *
     * Registers a new place.
     * 
     * @param placeName The name of the place
     * @param placeDepartmentSelection The department to which the place belongs
     * @param amountOfSquareKm The area of the place in square kilometers
     * @param placeTypeSelection The type of the place
     * @param placeOpeningDate The opening date of the place
     * @param placePhoto The photo of the place
     * @param communityName The community to which the place belongs
     * @param placeFinancialResourcesRequired The financial resources required for the place
     * @return A message indicating the success or failure of the operation
	 *
     */
	public String registerPlace(String placeName, int placeDepartmentSelection, double amountOfSquareKm, int placeTypeSelection, String placeOpeningDate, String placePhoto, String communityName, double placeFinancialResourcesRequired) {
		String message="Place succesfully created";
		Place.PlaceDepartment placeDepartment = null;
		Place.PlaceType placeType = null;
		Community placeCommunity = null;
		
		boolean avalible = placeAvailable();
		if (avalible==true) {
			Place objTemporal=searchPlace(placeName);
			placeCommunity=searchCommunity(communityName);
			if (objTemporal==null && placeCommunity!=null) {
				boolean exit=false;
				for (int i = 0; i < placeList.length && !exit; i++) {
					if (placeList[i] == null) {
						
						if (placeDepartmentSelection==1) {
							placeDepartment=Place.PlaceDepartment.CHO;
						}
						else if (placeDepartmentSelection==2) {
							placeDepartment=Place.PlaceDepartment.VAL;
						}
						else if (placeDepartmentSelection==3) {
							placeDepartment=Place.PlaceDepartment.CAU;
						}
						else if (placeDepartmentSelection==4) {
							placeDepartment=Place.PlaceDepartment.NAR;
						}
				
						if (placeTypeSelection==1) {
							placeType=Place.PlaceType.PRD;
						}
						else if (placeTypeSelection==2) {
							placeType=Place.PlaceType.NTP;
						}
						else if (placeTypeSelection==3) {
							placeType=Place.PlaceType.PVT;
						}
				
                    objTemporal = new Place(placeName, placeDepartment, amountOfSquareKm, placeType, placeOpeningDate, placePhoto, placeCommunity, placeFinancialResourcesRequired);
                    placeList[i] = objTemporal;
					exit=true;
					}
				}
			} else
			message = "The Place is already created or community wasnt found.";
		}
		else
		message="Error, you cannot add more communities.";	
	return message;
	}
	
	/**
	 *
     * Checks if there is an available slot in the place list
     * 
     * @return True if there is an available slot, false otherwise
	 *
     */
	public boolean placeAvailable() {
		for (int i = 0; i<placeList.length; i++) {
			if (placeList[i] == null) {
				return true;
			}
		}
        return false;
    }

	/**
	 *
     * Searches for a place by his name
     * 
     * @param placeName The name of the place to search for
     * @return The place object if found, null otherwise
	 *
     */
    public Place searchPlace(String placeName) {
		
        for (int i = 0; i < placeList.length; i++) {
        if (placeList[i] != null && placeList[i].getName().equals(placeName)) {
            return placeList[i];
			}
		}
    return null;
	
    }
	
	/**
	 *
     * Registers a product for a community
     * 
     * @param productName The name of the product to register 
     * @param productNaturalPercentage The natural percentage of the product to register 
	 * @param productTypeSelection The type of the product to register 
	 * @param productHandmade The yes/no selection to store if it is handmade or no
	 * @param communityName The name of the community to register the product
     * @return A message indicating the success or failure of the operation
	 *
     */
	public String registerProduct(String productName, double productNaturalPercentage, int productTypeSelection, String productHandmade, String communityName) {
		String message = "Product successfully registered";
		Product.ProductType productType = null;

		Community community = searchCommunity(communityName);
		if (community != null) {
			boolean exit = false;
				if (productTypeSelection==1) {
					productType=Product.ProductType.FOD;
				}
				else if (productTypeSelection==2) {
					productType=Product.ProductType.CRF;
				}
			Product product = new Product(productName, productNaturalPercentage, productType, productHandmade);
			exit = community.addProduct(product);
			if (!exit) {
				message = "The community's product list is full";
			}
		} else {
			message = "Community not found";
		}
		return message;
	}
	
	 /**
     * Deletes a product by name from the communities
     * 
     * @param productName The name of the product to delete
     * @return A message indicating the success or failure of the operation
	 *
     */
	public String deleteProduct(String productName) {
    String message = "Product not found";

    for (int i = 0; i < communityList.length; i++) {
        if (communityList[i] != null) {
            Product[] productList = communityList[i].getProductList();
            if (productList != null) {
				message = communityList[i].deleteOneProduct(productName, productList);
            }
        }
    }

    return message;
	}
	
	 /**
	 *
     * Adds a species to a place
     * 
     * @param specieName The name of the specie
     * @param specieBiodiversityTypeSelection The type of biodiversity the specie belongs to
     * @param speciePhoto The URL photo of the specie
     * @param specieLivingAmount The number of living individuals of the specie
     * @param placeName The name of the place to add the species to
     * @return A message indicating the success or failure of the operation
	 *
     */
	public String addSpecieToPlace(String specieName, int specieBiodiversityTypeSelection, String speciePhoto, int specieLivingAmount, String placeName) {
		Specie.SpecieBiodiversityType specieBiodiversityType = null;
		
					if (specieBiodiversityTypeSelection==1) {
						specieBiodiversityType=Specie.SpecieBiodiversityType.FLO;
					}
					else if (specieBiodiversityTypeSelection==2) {
						specieBiodiversityType=Specie.SpecieBiodiversityType.FAU;
					}
					
		Specie specie = new Specie(specieName, specieBiodiversityType, speciePhoto, specieLivingAmount);
		String message = "Specie added to place successfully";

		Place place = searchPlace(placeName);
			if (place != null) {
				boolean exit = false;
				exit = place.addSpecie(place, specie);
					if (!exit) {
						message = "The place's specie list is full";
					}
				} else {
				message = "Place not found";
			}
			return message;
	}
	
	 /**
	 *
     * Searches for a specie by the name across all places
     * 
     * @param specieName The name of the specie to search
     * @return The species object if found, null otherwise
	 *
     */
	public Specie searchSpecie(String specieName) {
    for (Place place : placeList) {
        if (place != null) {
            Specie[] species = place.getSpecieList();
            if (species != null) {
                for (Specie specie : species) {
                    if (specie != null && specie.getSpecieName().equalsIgnoreCase(specieName)) {
                        return specie;
                    }
                }
            }
        }
    }
    return null;
	}
	
	/**
	*
	* Updates the details of a species
	*
	* @param specieName The name of the species to be updated
	* @param newSpecieBiodiversityTypeSelection The selection representing the new biodiversity type of the species
	* @param newSpeciePhoto The new photo URL of the species
	* @param newSpecieLivingAmount The new living amount of the species
	* @param newSpecieName The new name of the specie
	* @return A message indicating the result of the update operation
	*
	*/
	public String updateSpecie(String specieName, int newSpecieBiodiversityTypeSelection, String newSpeciePhoto, int newSpecieLivingAmount, String newSpecieName) {
		Specie.SpecieBiodiversityType newSpecieBiodiversityType = null;
		Specie specie = searchSpecie(specieName);
		String message  = "";
		
		if (specie != null) {
			message = "Specie updated successfully";
			
			if (newSpecieBiodiversityTypeSelection != 0) {
				
					if (newSpecieBiodiversityTypeSelection==1) {
						newSpecieBiodiversityType=Specie.SpecieBiodiversityType.FLO;
					}
					else if (newSpecieBiodiversityTypeSelection==2) {
						newSpecieBiodiversityType=Specie.SpecieBiodiversityType.FAU;
					}
					specie.setSpecieBiodiversityType(newSpecieBiodiversityType);
			}
			
			else if (newSpeciePhoto != "") {
				specie.setSpeciePhoto(newSpeciePhoto);
			}
			
			else if (newSpecieLivingAmount != 0) {
				specie.setSpecieLivingAmount(newSpecieLivingAmount);
			}
			
			else if (newSpecieName != "") {
				specie.setSpecieName(newSpecieName);
			}
			
		} else {message = "Specie not found";}

		return message;
	}
	
	/**
	*
	* Displays information about a place
	*
	* @param placeName The name of the place to be displayed
	* @return A message containing information about the place
	*
	*/
	public String showPlace(String placeName) {
		Place place = searchPlace(placeName);
		String message  = "";
		
		if (place != null) {
			message = place.toString();
		} else {message = "Place not found";}

		return message;
	}
	
	/**
	*
	* Shows communities within a specified department
	*
	* @param placeDepartmentSelection The selection representing the department
	* @return A message listing the communities within the specified department
	*
	*/
	public String showCommunityDepartment(int placeDepartmentSelection) {
		Place.PlaceDepartment placeDepartment = null;
		Place.PlaceDepartment tempPlaceDepartment = null;
		String message = "";
		String communityName = "";
		
		if (placeDepartmentSelection==1) {
			placeDepartment=Place.PlaceDepartment.CHO;
		}
		else if (placeDepartmentSelection==2) {
			placeDepartment=Place.PlaceDepartment.VAL;
		}
		else if (placeDepartmentSelection==3) {
			placeDepartment=Place.PlaceDepartment.CAU;
		}
		else if (placeDepartmentSelection==4) {
			placeDepartment=Place.PlaceDepartment.NAR;
		}
		
		message += "Communities in " + placeDepartment.getValue() + ":";
		for (int i = 0; i < placeList.length; i++) {
			if (placeList[i]!=null) {
				
					Place place = placeList[i];
					tempPlaceDepartment = place.getPlaceDepartment();
					if (place != null && tempPlaceDepartment==placeDepartment) {
						Community tempCommunity = place.getCommunity();
						communityName = tempCommunity.getName();
							// ARRAY CREATE
							String[] tempArray= new String[50];
							tempArray[i]= communityName;
						boolean tempExit = true;
						for (int j = 1; j < tempArray.length; j++) {
							if (tempArray[j]==communityName) {
								tempExit = false;
							}
							else if (tempArray[j]!=communityName && tempExit == true) {
								message += "\n- " + communityName;
								tempExit = false;
							}
						}
					
				}
			
				if (message.equals("Communities in " + placeDepartment.getValue() + ":")) {
					message = "No communities found in " + placeDepartment.getValue();
				}
				
			} else if (message.equals("Communities in " + placeDepartment.getValue() + ":")) {message = "There are no registered places";}
		}

		return message;
	}
	
	/**
	*
	* Queries communities with major problems such as lack of hospital or school
	*
	* @return A message listing communities with major problems, if there are
	*
	*/
	public String queryCommunityMajorProblem() {
		String message = "";
		
		message += "Communities with major problems as Lack of hospital or school are: \n\n";
		for (int i = 0; i < communityList.length; i++) {
			if (communityList[i] != null) {
				Community tempCommunity = communityList[i];
				Community.CommunityMajorProblems[] communityMajorProblems = tempCommunity.getCommunityMajorProblems();
				boolean tempExit = true;
					for (int j = 0; j < communityMajorProblems.length; j++) {
						if (tempExit == true) {
							if (communityMajorProblems[j]==Community.CommunityMajorProblems.HOS || communityMajorProblems[j]==Community.CommunityMajorProblems.SCH) {
								message += tempCommunity.toString();
								message += "\n";
								tempExit = false;
							}
						}
					}
			}
		}
		if (message.equals("Communities with major problems as Lack of hospital or school are: \n\n")) {
			message = "No communities created or none of the communities had the indicated problems";
		}
		return message;
	}
	
	/**
	*
	* Queries the place with the most species
	*
	* @return A message indicating the place with the most species, if there are
	*
	*/
	public String queryPlaceNameWithMostSpecies() {
		String message = "";
		String placeName = "";
		int specieCounter = 0;
		int tempCounter= 0;
			
		message += "The place with most species is: ";
		for (int i = 0; i < placeList.length; i++) {
			if (placeList[i]!=null) { 
			Place place = placeList[i];
			// ARRAY CREATE
			Specie[] tempArray = place.getSpecieList();
				for (int j = 0; j < tempArray.length; j++) {
					if (tempArray[j]!=null) {
						tempCounter++;
					}
				}
				if (tempCounter>specieCounter) {
					specieCounter = tempCounter;
					placeName = place.getName();
				}
				else if (tempCounter==specieCounter) {
					if (specieCounter>=1) {
					placeName += ", " + place.getName();
					}
				}

				tempCounter = 0;
			}
		}
		message += placeName;
		
		if (message.equals("The place with most species is: ")) {
			message = "There are no places created or no species linked";
		}
		return message;
	}
	
	/**
	*
	* Queries the three biggest places per square kilometer
	*
	* @return A message listing the three biggest places per square kilometer, if there are
	*
	*/
	public String queryThreeBiggestPlacesPerSquareKm() {
		String message = "";
		double[] tempArrayInt= new double[3];
		String[] tempArrayString= new String[3];
			
		message += "The biggest places per Km2 are: \n";
		for (int i = 0; i < placeList.length; i++) {
			if (placeList[i]!=null) { 
			Place place = placeList[i];
			// ARRAY CREATE
			double tempValue = place.getSquareKm();
			boolean tempExit = true;
			boolean tempExitTwo = true;
				for (int j = 0; j < tempArrayInt.length; j++) {
					if (tempValue>tempArrayInt[j] && tempExit == true) {
						
						if (tempArrayInt[0]!=0 && tempValue>tempArrayInt[0]) {
							if (tempArrayInt[1]!=0 && tempArrayInt[1]>tempArrayInt[2]) {
								tempArrayInt[2]=tempArrayInt[1];
								tempArrayString[2]=tempArrayString[1];	
							}
						tempArrayInt[1]=tempArrayInt[0];
						tempArrayString[1]=tempArrayString[0];
						tempExitTwo = false;
						}
						
						if (tempArrayInt[1]!=0 && tempValue>tempArrayInt[1] && tempExitTwo == true) {
							tempArrayInt[2]=tempArrayInt[1];
							tempArrayString[2]=tempArrayString[1];	
						}
						
						tempArrayInt[j]=tempValue;
						tempArrayString[j]=place.getName();
						tempExit = false;
					}
				}
			}
		}
		for (int k = 0; k < tempArrayInt.length; k++) {
			if (tempArrayInt[k]!=0) {
				message += (k+1) + ". " + tempArrayString[k] + " (" + tempArrayInt[k] + ") \n";
			}
		}
		
		
		if (message.equals("The biggest places per Km2 are: \n")) {
			message = "There are no places created";
		}
		return message;
	}
	
}