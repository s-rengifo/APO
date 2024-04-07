package model;
public class Place{
	//atributes
	private String placeName;
	private String placeDepartment;
	private int amountOfSquareKm;
	private String placeType;
	private String placeOpeningDate;
	private String placePhoto;
	private String placeCommunity;
	private double placeFinancialResourcesRequired;
	private Specie placeLivingSpecie;
	
	//relations
	
	//methods
	public Place(String placeName, String placeDepartment, int amountOfSquareKm, String placeType, String placeOpeningDate, String placePhoto, String placeCommunity, double placeFinancialResourcesRequired, Specie placeLivingSpecie){
		this.placeName=placeName;
		this.placeDepartment=placeDepartment;
		this.amountOfSquareKm=amountOfSquareKm;
		this.placeType=placeType;
		this.placeOpeningDate=placeOpeningDate;
		this.placePhoto=placePhoto;
		this.placeCommunity=placeCommunity;
		this.placeFinancialResourcesRequired=placeFinancialResourcesRequired;
		this.placeLivingSpecie=placeLivingSpecie;
	}	
	
}