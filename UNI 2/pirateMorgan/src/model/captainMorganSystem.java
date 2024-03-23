package model;
public class captainMorganSystem{
// Atributes	
private String name;
private String personalId;

// Relations
private Ship pirate;
private Client c1;
private Client c2;
private Client c3;
private Client c4;
private Client c5;

// Services
	public captainMorganSystem (String personalId, String name, String nameShip, double limMin, double limMax) {
		this.personalId= personalId;
		this.name= name;
		// this. (objeto que esta en memoria en este momento)
		
		pirate= new Ship (nameShip, limMin, limMax);
		
		c1=null;
		c2=null;
		c3=null;
		c4=null;
		c5=null;
	}
	
	public void updateInfoShip(int option, String newShipName, double newMinLim, double newMaxLim)
	{
	switch (option) {
		case 1: //Update ship name
		pirate.setName(newShipName);
		break;}
	}
	
	public String addClient(String pNitClient, String pNameClient)
	{
		String message="Client succesfully created";
		boolean avalible = clientAvailable();
		if (avalible==true) {
			Client objTemporal=searchClient(pNitClient);
			if (objTemporal==null) {
				objTemporal= new Client(pNitClient, pNameClient);
				if (c1==null)
					c1=objTemporal;
				else if (c2==null)
					c2=objTemporal;
				else if (c3==null)
					c3=objTemporal;
				else if (c4==null)
					c4=objTemporal;
				else if (c5==null)
					c5=objTemporal;
			} else
				message = "The client is already created.";
				
		}
		else
		message="Error, you cannot add more clients.";
			
		return message;
	}
	
	public boolean clientAvailable() {
        return c1 == null || c2 == null || c3 == null || c4 == null || c5 == null;
    }

    public Client searchClient(String pNitClient) {
		
        if (c1 != null && c1.getNit().equals(pNitClient)) {
            return c1;
        }
        if (c2 != null && c2.getNit().equals(pNitClient)) {
            return c2;
        }
        if (c3 != null && c3.getNit().equals(pNitClient)) {
            return c3;
        }
        if (c4 != null && c4.getNit().equals(pNitClient)) {
            return c4;
        }
        if (c5 != null && c5.getNit().equals(pNitClient)) {
            return c5;
        }
        return null;
    }
	
	public void displayClients() {
        if (c1 != null) System.out.println("Client 1 | NIT: " + c1.getNit() + " Name: " + c1.getName());
        if (c2 != null) System.out.println("Client 2 | NIT: " + c2.getNit() + " Name: " + c2.getName());
        if (c3 != null) System.out.println("Client 3 | NIT: " + c3.getNit() + " Name: " + c3.getName());
        if (c4 != null) System.out.println("Client 4 | NIT: " + c4.getNit() + " Name: " + c4.getName());
        if (c5 != null) System.out.println("Client 5 | NIT: " + c5.getNit() + " Name: " + c5.getName());
    }
	
}