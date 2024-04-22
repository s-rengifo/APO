package model;
public class Professor{
	// Attributes
	private String professorName;
	private String professorSurname;
	private String professorId;
	private Proyect[] proyectList;
	
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
	public Professor(String professorName, String professorSurname, String professorId){
		this.professorName=professorName;
		this.professorSurname=professorSurname;
		this.professorId=professorId;
		this.proyectList = new Proyect[30];
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
     * Retrieves the array of proyects registered for a professor
     *
     * @return An array of proyects registered for a professor
	 *
     */
	public Proyect[] getProyectList() {
		return proyectList;
	}
	
	public boolean addProyect(Professor professor, Proyect proyect){
		boolean exit = false;
		for (int i = 0; i < professor.getProyectList().length && !exit; i++) {
					if (professor.getProyectList()[i] == null) {
						professor.getProyectList()[i] = proyect;
						exit = true;
					}
				}
	 return exit;
	}
	
}