package model;
public class PartTimeProfessor extends Professor {
	// Attributes
	private int workedHoursAmount;
	private static final double VALUE_PER_HOUR = 40000;
	
	// Relations
	
	// Methods
	
	 /**
	 *
     * Constructs a new Part-Time-Professor object with the specified attributes
     *
     * @param professorName
     * @param professorSurname
     * @param professorId
	 * @param professorBaseSalary
     * @param professorTotalSalary
	 * @param workedHoursAmount
	 *
     */
	public PartTimeProfessor(String professorName, String professorSurname, String professorId, double professorBaseSalary, double professorTotalSalary, int workedHoursAmount){
		super(professorName, professorSurname, professorId, professorBaseSalary, professorTotalSalary);
		this.workedHoursAmount=workedHoursAmount;
	}
	
	/**
	*
	* Provides the string of a PartTimeProfessor
	*
	* @return A string of the PartTimeProfessor
	*
	*/
	@Override
	public String toString() {
		String result = super.toString();
		result += "Worked hours: " + workedHoursAmount + "\n";
		
    return result;
	}
	
	/**
	*
	* Calculates the salary of a professor
	*
	* @return The salary of the professor
	*
	*/
	public double calculateSalary() {
		double professorTotalSalary = getProfessorBaseSalary()+(VALUE_PER_HOUR*workedHoursAmount);
		
    return professorTotalSalary;
	}
	
}