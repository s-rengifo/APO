package model;
public class Specie{
	// Atributes
	private String specieName;
	private SpecieBiodiversityType specieBiodiversityType;
	private String speciePhoto;
	private int specieLivingAmount;
	
	// Relations
	
	// Methods
	
	 /**
	 *
     * Constructs a new Specie object with the specified attributes
     *
     * @param specieName The name of the specie
     * @param specieBiodiversityType The type of biodiversity the specie belongs to
     * @param speciePhoto The URL photo of the specie
     * @param specieLivingAmount The number of living individuals of the specie
	 *
     */
	public Specie(String specieName, SpecieBiodiversityType specieBiodiversityType, String speciePhoto, int specieLivingAmount){
		this.specieName=specieName;
		this.specieBiodiversityType=specieBiodiversityType;
		this.speciePhoto=speciePhoto;
		this.specieLivingAmount=specieLivingAmount;
	}
	
	 /**
	 *
     * Retrieves the name of the species
     *
     * @return The name of the species
	 *
     */
	public String getSpecieName() {
        return specieName;
    }

	 /**
	 *
     * Sets the name of the specie
     *
     * @param specieName The name of the species to set
	 *
     */
    public void setSpecieName(String specieName) {
        this.specieName = specieName;
    }

	 /**
	 *
     * Retrieves the biodiversity type of the specie
     *
     * @return The biodiversity type of the specie
	 *
     */
    public SpecieBiodiversityType getSpecieBiodiversityType() {
        return specieBiodiversityType;
    }

	 /**
	 *
     * Sets the biodiversity type of the specie
     *
     * @param specieBiodiversityType The biodiversity type of the species to set
	 *
     */
    public void setSpecieBiodiversityType(SpecieBiodiversityType specieBiodiversityType) {
        this.specieBiodiversityType = specieBiodiversityType;
    }
	
	 /**
	 *
     * Retrieves the URL photo of the species
     *
     * @return The URL photo of the specie
	 *
     */
    public String getSpeciePhoto() {
        return speciePhoto;
    }

	 /**
	 *
     * Sets the URL photo of the specie
     *
     * @param speciePhoto The URL photo of the specie to set
	 *
     */
    public void setSpeciePhoto(String speciePhoto) {
        this.speciePhoto = speciePhoto;
    }

	 /**
	 *
     * Retrieves the number of living individuals of the species
     *
     * @return The number of living individuals of the species
	 *
     */
    public int getSpecieLivingAmount() {
        return specieLivingAmount;
    }
	
	 /**
	 *
     * Sets the number of living individuals of the specie
     *
     * @param specieLivingAmount the number of living individuals of the specie to set
	 *
     */
    public void setSpecieLivingAmount(int specieLivingAmount) {
        this.specieLivingAmount = specieLivingAmount;
    }
}