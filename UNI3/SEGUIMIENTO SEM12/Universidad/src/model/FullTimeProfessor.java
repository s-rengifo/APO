package model;
public class FullTimeProfessor extends Professor {
	// Attributes
	private int extraHoursAmount;
	private double bonusSalary;
	private static final double VALUE_PER_EXTRA_HOUR = 60000;
	
	// Relations
	
	// Methods
	
	 /**
	 *
     * Constructs a new Full-Time-Professor object with the specified attributes
     *
     * @param professorName
     * @param professorSurname
     * @param professorId
	 * @param professorBaseSalary
     * @param professorTotalSalary
	 * @param extraHoursAmount
	 * @param bonusSalary
	 *
     */
	public FullTimeProfessor(String professorName, String professorSurname, String professorId, double professorBaseSalary, double professorTotalSalary, int extraHoursAmount, double bonusSalary){
		super(professorName, professorSurname, professorId, professorBaseSalary, professorTotalSalary);
		this.extraHoursAmount=extraHoursAmount;
		this.bonusSalary=bonusSalary;
	}
	
	/**
	*
	* Provides the string of a FullTimeProfessor
	*
	* @return A string of the FullTimeProfessor
	*
	*/
	@Override
	public String toString() {
		String result = super.toString();
		result += "Extra worked hours: " + extraHoursAmount + "\n";
		result += "Bonus salary $: " + bonusSalary + "\n";
		
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
		double professorTotalSalary = getProfessorBaseSalary()+bonusSalary+(VALUE_PER_EXTRA_HOUR*extraHoursAmount);
		
    return professorTotalSalary;
	}
	
	 /**
     * Retrieves the bonus salary of the professor
     *
     * @return The bonus salary of the of professor
     */
	public double getBonusSalary() {
		return bonusSalary;
	}
	
}