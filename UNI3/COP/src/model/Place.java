package model;
public class Place{
	//atributes
	private String placeName;
	private PlaceDepartment placeDepartment;
	private double amountOfSquareKm;
	private PlaceType placeType;
	private String placeOpeningDate;
	private String placePhoto;
	private Community placeCommunity;
	private double placeFinancialResourcesRequired;
	private Specie[] specieList;
	
	// Relations
	
	// Methods
	
	public enum PlaceDepartment {
        CHO("Choco"),
        VAL("Valle del cauca"),
        CAU("Cauca"),
		NAR("Narino");
        
        private String value;
        
        private PlaceDepartment(String value) {
            this.value = value;
        }
		
		 /**
		 *
         * Retrieves the string value associated with the place department
         *
         * @return The string value of the place department
		 *
         */
		public String getPlaceDepartmentString() {
			return value;
		}
        
		 /**
		 *
         * Retrieves the string value associated with the place department
         *
         * @return The string value of the place department
		 *
         */
        public String getValue() {
            return value;
        }
		
    }
	
	public enum PlaceType {
        PRD("Protected"),
        NTP("National Park"),
        PVT("Private");
        
        private final String value;
        
        PlaceType(String value) {
            this.value = value;
        }
        
		 /**
		 *
         * Retrieves the string value associated with the place type
         *
         * @return The string value of the place type
		 *
         */
        public String getValue() {
            return value;
        }
		
    }
	
	 /**
	 *
     * Constructs a new Place object with the specified attributes
     *
     * @param placeName The name of the place
     * @param placeDepartment The department to which the place belongs
     * @param amountOfSquareKm The total area of the place in square kilometers
     * @param placeType The type of the place
     * @param placeOpeningDate The opening date of the place
     * @param placePhoto The photo associated with the place
     * @param placeCommunity The community to which the place is related
     * @param placeFinancialResourcesRequired The amount of financial resources required for the place
     */
	public Place(String placeName, PlaceDepartment placeDepartment, double amountOfSquareKm, PlaceType placeType, String placeOpeningDate, String placePhoto, Community placeCommunity, double placeFinancialResourcesRequired){
		this.placeName=placeName;
		this.placeDepartment=placeDepartment;
		this.amountOfSquareKm=amountOfSquareKm;
		this.placeType=placeType;
		this.placeOpeningDate=placeOpeningDate;
		this.placePhoto=placePhoto;
		this.placeCommunity=placeCommunity;
		this.placeFinancialResourcesRequired=placeFinancialResourcesRequired;
		this.specieList = new Specie[20];
	}

	 /**
	 *
     * Retrieves the name of the place
     *
     * @return The name of the place
	 *
     */
	public String getName() {
		return placeName;
	}
	
	 /**
	 *
     * Retrieves the SquareKm of a place
     *
     * @return The amount of SquareKm of a place
	 *
     */
	public double getSquareKm() {
		return amountOfSquareKm;
	}
	
	 /**
	 *
     * Retrieves the a community linked to a place
     *
     * @return The community object
	 *
     */
	public Community getCommunity() {
		return placeCommunity;
	}
	
	 /**
	 *
     * Retrieves the array of species registered for the place
     *
     * @return An array of species registered for the place
	 *
     */
	public Specie[] getSpecieList() {
		return specieList;
	}
	
	/**
	 *
     * Retrieves the department of the place
     *
     * @return The department linked to the place
	 *
     */
	public PlaceDepartment getPlaceDepartment() {
		return placeDepartment;
	}
	
	/**
	*
	* Adds a species to the list of species associated with a place
	*
	* @param place The place to which the species will be added
	* @param specie The specie to be added
	* @return True if the specie was successfully added to the place, false otherwise
	*
	*/
	public boolean addSpecie(Place place, Specie specie){
		boolean exit = false;
		for (int i = 0; i < place.getSpecieList().length && !exit; i++) {
					if (place.getSpecieList()[i] == null) {
						place.getSpecieList()[i] = specie;
						exit = true;
					}
				}
	 return exit;
	}
	
	/**
	*
	* Provides a string of the place, including its details and associated species
	*
	* @return A string of the place
	*
	*/
	@Override
	public String toString() {
		String result = "Name: " + placeName + "\n";
		result += "Department: " + placeDepartment.getValue() + "\n";
		result += "Amount of Square KM: " + amountOfSquareKm + "\n";
		result += "Place Type: " + placeType.getValue() + "\n";
		result += "Opening Date: " + placeOpeningDate + "\n";
		result += "Photo: " + placePhoto + "\n";
		result += "Community: " + placeCommunity + "\n";
		result += "Financial Resources Required: " + placeFinancialResourcesRequired + "\n";
		result += "Species: \n";
		for (Specie specie : specieList) {
			if (specie != null) {
				result += "\t" + specie.toString() + "\n";
			}
		}
    return result;
	}
	
}