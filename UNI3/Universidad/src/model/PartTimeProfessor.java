package model;
public class PartTimeProfessor extends Professor {
	// Attributes
	private int workedHoursAmount;
	
	// Relations
	
	// Methods
	
	 /**
	 *
     * Constructs a new Part-Time-Professor object with the specified attributes
     *
     * @param professorName
     * @param professorSurname
     * @param professorId
	 * @param workedHoursAmount
	 *
     */
	public PartTimeProfessor(String professorName, String professorSurname, String professorId, int workedHoursAmount){
		super(professorName, professorSurname, professorId);
		this.workedHoursAmount=workedHoursAmount;
	}
	
}