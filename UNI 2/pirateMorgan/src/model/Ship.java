package model;
public class Ship{
	//atributes
	private String name;
	private double limMin;
	private double limMax;
	
	//relations
	
	//methods
	public Ship(String nameShip, double limitMin, double limitMax){
		this.name=nameShip;
		this.limMin=limitMin;
		this.limMax=limitMax;
	}	
	
	public String getName() {
		return name;
	}
	
	public void setName (String newShipName) {
		this.name=newShipName;
	}
}