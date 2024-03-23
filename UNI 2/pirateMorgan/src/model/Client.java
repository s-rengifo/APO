package model;
public class Client{
	//atributes
	private String pNitClient;
	private String pNameClient;
	
	//relations
	
	//methods
	public Client(String pNitClient, String pNameClient){
		this.pNitClient=pNitClient;
		this.pNameClient=pNameClient;
	}	
	
	public String getNit() {
		return pNitClient;
	}
	
	public String getName() {
		return pNameClient;
	}
}