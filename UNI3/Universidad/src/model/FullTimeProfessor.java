package model;
public class FullTimeProfessor extends Professor {
	// Attributes
	private int extraHoursAmount;
	private double bonusSalary;
	
	// Relations
	
	// Methods
	
	 /**
	 *
     * Constructs a new Full-Time-Professor object with the specified attributes
     *
     * @param professorName
     * @param professorSurname
     * @param professorId
	 * @param extraHoursAmount
	 * @param bonusSalary
	 *
     */
	public FullTimeProfessor(String professorName, String professorSurname, String professorId){
		super(professorName, professorSurname, professorId);
		this.extraHoursAmount=extraHoursAmount;
		this.bonusSalary=bonusSalary;
	}
	
}