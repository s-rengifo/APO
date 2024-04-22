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
     * Constructor for the University class, initializes the user, password and professor list.
     * 
     * @param user The username for the University.
     * @param password The password for the University.
	 *
     */
	public University (String user, String password) {
		this.user=user;
		this.password=password;
		professorList= new Professor[50];
	}
	
	 /**
	 *
     * Registers a new professor
     * 
     * @param professorName
     * @param professorSurname
     * @param professorId
     * @return A message indicating the success or failure of the operation
	 *
     */
	public String registerProfessor(String professorName, String professorSurname, String professorId) {
		String message="Professor succesfully created";
		boolean avalible = professorAvailable();
		if (avalible==true) {
			Professor objTemporal=searchProfessor(professorId);
			if (objTemporal==null) {
				boolean exit=false;
				for (int i = 0; i < professorList.length && !exit; i++) {
					if (professorList[i] == null) {
						objTemporal = new Professor(professorName, professorSurname, professorId);
						professorList[i] = objTemporal;
						exit=true;
					}
				}
			} else
			message = "The Professor is already created.";
		}
		else
		message="Error, you cannot add more professors.";	
	return message;
	}
	
	/**
	 *
     * Checks if there is an available slot in the professor list
     * 
     * @return True if there is an available slot, false otherwise
	 *
     */
	public boolean professorAvailable() {
		for (int i = 0; i<professorList.length; i++) {
			if (professorList[i] == null) {
				return true;
			}
		}
        return false;
    }

	/**
	 *
     * Searches a community by his name
     * 
     * @param communityName The name of the community to search for
     * @return The community object if found, null otherwise
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
	
	public String registerProyectProfessor(String proyectName, double proyectInversion, int proyectRoleSelection, String professorName) {
		Proyect.Role proyectRole = null;
		
					if (proyectRoleSelection==1) {
						proyectRole=Proyect.Role.LEA;
					}
					else if (proyectRoleSelection==2) {
						proyectRole=Proyect.Role.EXE;
					}
					else if (proyectRoleSelection==3) {
						proyectRole=Proyect.Role.OBS;
					}
					
		Proyect proyect = new Proyect(proyectName, proyectInversion, proyectRole);
		String message = "Proyect added to professor successfully";

		Professor professor = searchProfessorName(professorName);
			if (professor != null) {
				boolean exit = false;
				exit = professor.addProyect(professor, proyect);
					if (!exit) {
						message = "The professor proyect list is full";
					}
				} else {
				message = "Professor not found";
			}
			return message;
	}
	
	/**
	 *
     * Searches for a professor by his name
     * 
     * @param professorName The name of the professor to search for
     * @return The professor object if found, null otherwise
	 *
     */
    public Professor searchProfessorName(String professorName) {
		
        for (int i = 0; i < professorList.length; i++) {
        if (professorList[i] != null && professorList[i].getName().equals(professorName)) {
            return professorList[i];
			}
		}
    return null;
	
    }
	
	public String queryObserverProfessor(int proyectRoleSelection) {
		Proyect.Role proyectRole = null;
		String message = "";
		Proyect.Role tempRole = null;
		
					if (proyectRoleSelection==1) {
						proyectRole=Proyect.Role.LEA;
					}
					else if (proyectRoleSelection==2) {
						proyectRole=Proyect.Role.EXE;
					}
					else if (proyectRoleSelection==3) {
						proyectRole=Proyect.Role.OBS;
					}	
		
		message += "Professors which role in a proyect is observer: ";
		for (int i = 0; i < professorList.length; i++) {
			Professor professor = professorList[i];
			if (professor != null) {
				String professorName = professor.getName();
				Proyect tempProyect = professor.getProyectList()[i];
				if (tempProyect!=null) {
					tempRole = tempProyect.getProyectRole();
				}
				if (tempRole==proyectRole) {
					message += "\n" + (i+1) + ". " + professorName;
				}
			}
		
			if (message.equals("Professors which role in a proyect is observer: ")) {
				message = "Seems that, there are no professors working on a Observer proyect role";
			}
		}

		return message;
	}
	
	public String queryProyectHigherInversion() {
		String message = "";
		double highestInversion = 0;
		String highestInversionProjectName = "";

		for (Professor professor : professorList) {
			if (professor != null) {
				Proyect[] proyects = professor.getProyectList();
				for (Proyect proyect : proyects) {
				if (proyect != null) {
					double proyectInversion = proyect.getProyectInversion();
					if (proyectInversion > highestInversion) {
						highestInversion = proyectInversion;
					highestInversionProjectName = proyect.getName();
					}
				}
				}
			}
		}

		if (highestInversionProjectName.equals("")) {
			message = "No projects registered.";
		} else {
			message = "The project with the highest inversion is: " + highestInversionProjectName +
					  " with an inversion of $" + highestInversion;
		}

		return message;
	}

}