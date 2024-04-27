package model;
public class Proyect{
	// Attributes
	private String proyectName;
	private double proyectInversion;
	private Role proyectRole;
	
	// Relations
	
	// Methods
	
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