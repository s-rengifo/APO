package model;
public class Professor{
	// Attributes
	private String professorName;
	private String professorSurname;
	private String professorId;
	private double professorBaseSalary;
    private double professorTotalSalary;
	
	// Relations
	
	// Methods
	
	 /**
	 *
     * Constructs a new Professor object with the specified attributes
     *
     * @param professorName
     * @param professorSurname
     * @param professorId
     * @param professorBaseSalary
     * @param professorTotalSalary
	 *
     */
	public Professor(String professorName, String professorSurname, String professorId, double professorBaseSalary, double professorTotalSalary){
		this.professorName=professorName;
		this.professorSurname=professorSurname;
		this.professorId=professorId;
		this.professorBaseSalary=professorBaseSalary;
		this.professorTotalSalary=professorTotalSalary;
	}
	
	 /**
     * Retrieves the id of the professor
     *
     * @return The id of the of professor
     */
	public String getId() {
		return professorId;
	}
	
	/**
     * Retrieves the name of the professor
     *
     * @return The name of the id of professor
     */
	public String getName() {
		return professorName;
	}
	
	/**
	*
	* Provides the string of a professor
	*
	* @return A string of the professor
	*
	*/
	public String toString() {
		String result = "PROFESSOR - " + professorName + " " + professorSurname +"\n";
		result += "Document Id: " + professorId + "\n";
		result += "Base salary: $" + professorBaseSalary + "\n";
		result += "TOTAL salary: $" + professorTotalSalary + "\n";
		
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
		double professorTotalSalary = 0;
		
    return professorTotalSalary;
	}
	
	 /**
	 *
	 * Sets the total salary of the professor
	 *
	 * @param professorTotalSalary The new total salary of the professor
	 *
	 */
	public void setProfessorTotalSalary(double professorTotalSalary) {
        this.professorTotalSalary = professorTotalSalary;
    }
	
	 /**
     * Retrieves the base salary of the professor
     *
     * @return The base salary of the of professor
     */
	public double getProfessorBaseSalary() {
		return professorBaseSalary;
	}
	
	 /**
     * Retrieves the name of the professor
     *
     * @return The name of the of professor
     */
	public String getProfessorName() {
		return professorName;
	}
	
	 /**
     * Retrieves the surname of the professor
     *
     * @return The surname of the of professor
     */
	public String getProfessorSurname() {
		return professorSurname;
	}
	
	 /**
     * Retrieves the full salary of the professor
     *
     * @return The full salary of the of professor
     */
	public double getProfessorTotalSalary() {
		return professorTotalSalary;
	}
	
}