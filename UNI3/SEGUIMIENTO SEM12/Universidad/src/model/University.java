package model;
public class University{
	// Atributes
	private String user;
	private String password;

	// Relations
	private Professor[] professorList;

	// Services
	
	/**
     * 
     * Constructor for the University class, initializes the user, password and professor list
     * 
     * @param user The username for the University
     * @param password The password for the University
	 *
     */
	public University (String user, String password) {
		this.user=user;
		this.password=password;
		professorList= new Professor[50];
	}
	
    /**
	 *
     * Registers a new Full-Time Professor
     *
     * @param professorName The name of the professor
     * @param professorSurname The surname of the professor
     * @param professorId The identification of the professor
     * @param extraHoursAmount The extra hours amount of the professor
     * @param bonusSalary The bonus salary of the professor
     * @return A message indicating the success or failure of the operation
	 *
     */
    public String registerFullTimeProfessor(String professorName, String professorSurname, String professorId, double professorBaseSalary, int extraHoursAmount, double bonusSalary) {
       double professorTotalSalary = 0;
	   
	   if (!professorAvailable()) {
            return "Error, you cannot add more professors.";
        }

        Professor objTemporal = searchProfessor(professorId);
        if (objTemporal != null) {
            return "The Professor is already created.";
        }

        FullTimeProfessor fullTimeProfessor = new FullTimeProfessor(professorName, professorSurname, professorId, professorBaseSalary, professorTotalSalary, extraHoursAmount, bonusSalary);
        // Calculate salary
		professorTotalSalary = fullTimeProfessor.calculateSalary();
		// Set salary
		fullTimeProfessor.setProfessorTotalSalary(professorTotalSalary);
		
        boolean exit = false;
        for (int i = 0; i < professorList.length && !exit; i++) {
            if (professorList[i] == null) {
                professorList[i] = fullTimeProfessor;
                exit = true;
            }
        }
        
        return "Full-Time Professor successfully created";
    }
    
    /**
	 *
     * Registers a new Part-Time Professor
     *
     * @param professorName The name of the professor
     * @param professorSurname The surname of the professor
     * @param professorId The identification of the professor
     * @param workedHoursAmount The worked hours amount of the professor
     * @return A message indicating the success or failure of the operation
	 *
     */
    public String registerPartTimeProfessor(String professorName, String professorSurname, String professorId, double professorBaseSalary, int workedHoursAmount) {
        double professorTotalSalary = 0;
		
		if (!professorAvailable()) {
            return "Error, you cannot add more professors.";
        }

        Professor objTemporal = searchProfessor(professorId);
        if (objTemporal != null) {
            return "The Professor is already created.";
        }

        PartTimeProfessor partTimeProfessor = new PartTimeProfessor(professorName, professorSurname, professorId, professorBaseSalary, professorTotalSalary, workedHoursAmount);
        // Calculate salary
		professorTotalSalary = partTimeProfessor.calculateSalary();
		// Set salary
		partTimeProfessor.setProfessorTotalSalary(professorTotalSalary);
		
        boolean exit = false;
        for (int i = 0; i < professorList.length && !exit; i++) {
            if (professorList[i] == null) {
                professorList[i] = partTimeProfessor;
                exit = true;
            }
        }
        
        return "Part-Time Professor successfully created";
    }
    
    /**
	 *
     * Checks if there is an available slot in the professor list
     *
     * @return True if there is an available slot, false otherwise
	 *
     */
    public boolean professorAvailable() {
        for (int i = 0; i < professorList.length; i++) {
            if (professorList[i] == null) {
                return true;
            }
        }
        return false;
    }
    
    /**
	 *
     * Searches a professor by their ID
     *
     * @param professorId The ID of the professor to search for
     * @return The professor object if found, null otherwise
	 *
     */
    public Professor searchProfessor(String professorId) {
        for (int i = 0; i < professorList.length; i++) {
            if (professorList[i] != null && professorList[i].getId().equals(professorId)) {
                return professorList[i];
            }
        }
        return null;
    }
	
	 /**
	 *
     * Queries all the professors and add them to a message String if they exist
     *
     * @return The professor if found
	 *
     */
	public String queryAllProfessor() {
        String message = "";
		
		for (int i = 0; i < professorList.length; i++) {
			if (professorList[i] != null) {
				message+=professorList[i].toString() + " \n";
			}
		}
        
		if (message.equals("")) {message="No professors are registered yet.";}
        
        return message;
    }
	
	 /**
	 *
     * This add to a message String the salary of the registered professors 
     *
     * @return The professor and the salary if found
	 *
     */
	public String calculateSalaryProfessor() {
        String message = "";
		String name = "";
		String surname = "";
		double salary = 0;
		
		for (int i = 0; i < professorList.length; i++) {
			if (professorList[i] != null) {
				Professor tempProfessor = professorList[i];
				salary = tempProfessor.getProfessorTotalSalary();
				name = tempProfessor.getProfessorName();
				surname = tempProfessor.getProfessorSurname();
				message+= "PROFESSOR - " + name + " " + surname + " \n";
				message+= "Salary: $" + salary + " \n";
			}
		}
        
		if (message.equals("")) {message="No professors are registered yet.";}
        
        return message;
    }
	
	 /**
	 *
     * Queries all the FullTime professors which has a bonus salary higher than 2M
     *
     * @return The professor if found
	 *
     */
	public String queryFullTimeBonusHigherTwoM() {
        String message = "The full time professors which has a bonus higher than 2M are: \n";
		String name = "";
		String surname = "";
		double bonus = 0;
		
		for (int i = 0; i < professorList.length; i++) {
			if (professorList[i] != null && professorList[i] instanceof FullTimeProfessor) {
				FullTimeProfessor tempProfessor = (FullTimeProfessor) professorList[i];;
				bonus = tempProfessor.getBonusSalary();
				name = tempProfessor.getProfessorName();
				surname = tempProfessor.getProfessorSurname();
				if (bonus>2000000) {
					message+= "PROFESSOR - " + name + " " + surname + " \n";
				}
			}
		}
        
		if (message.equals("The full time professors which has a bonus higher than 2M are: \n")) {message="No full time professors registered with this conditions.";}
        
        return message;
    }
	
}
