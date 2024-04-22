package model;
public class Proyect{
	// Attributes
	private String proyectName;
	private double proyectInversion;
	private Role proyectRole;
	
	// Relations
	
	// Methods
	
    public enum Role {
        LEA("Leader"),
        EXE("Executant"),
        OBS("Observer");
		
        private final String value;
        
        Role(String value) {
            this.value = value;
        }
        
		/**
		 *
         * Retrieves the string value associated with the role
         *
         * @return The string value of the role
		 *
         */
        public String getValue() {
            return value;
        }
		
    }
	
	 /**
	 *
     * Constructs a new Project object with the specified attributes
     *
     * @param proyectName
     * @param proyectInversion
	 * @param proyectRole
	 *
     */
	public Proyect(String proyectName, double proyectInversion, Role proyectRole){
		this.proyectName=proyectName;
		this.proyectInversion=proyectInversion;
		this.proyectRole=proyectRole;
	}
	
	public Role getProyectRole() {
         return proyectRole;
    }
	
	public double getProyectInversion() {
         return proyectInversion;
    }
	
	public String getName() {
         return proyectName;
    }
}