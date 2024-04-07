package model;
public class Specie{
	//atributes
	private String specieName;
	private String specieBiodiversityType;
	private String speciePhoto;
	private int specieLivingAmount;
	
	//relations
	
	//methods
	public Specie(String specieName, String specieBiodiversityType, String speciePhoto, int specieLivingAmount){
		this.specieName=specieName;
		this.specieBiodiversityType=specieBiodiversityType;
		this.speciePhoto=speciePhoto;
		this.specieLivingAmount=specieLivingAmount;
	}
}