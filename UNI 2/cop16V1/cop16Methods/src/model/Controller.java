package model;
public class Controller{
	// Atributes
	private String user;
	private String password;

	// Relations
	private Community[] communityList;

	// Services
	public Controller (String user, String password) {
		this.user=user;
		this.password=password;
		// this. (objeto que esta en memoria en este momento)
		communityList= new Community[50];
	}
		
		public String addCommunity(String communityName, String communityType, String communityBossName, String communityBossPhoneNumber, String[] communityMajorProblems, String communityProduct, int communityAmountInhabitants) {
		String message="Community succesfully created";
		boolean avalible = communityAvailable();
		if (avalible==true) {
			Community objTemporal=searchCommunity(communityName);
			if (objTemporal==null) {
				boolean exit=false;
				for (int i = 0; i < communityList.length && !exit; i++) {
					if (communityList[i] == null) {
                    objTemporal = new Community(communityName, communityType, communityBossName, communityBossPhoneNumber, communityMajorProblems, communityProduct, communityAmountInhabitants);
                    communityList[i] = objTemporal;
					exit=true;
				}
			}} else
				message = "The community is already created.";
				
		}
		else
		message="Error, you cannot add more communities.";
			
		return message;
	}
	
	public boolean communityAvailable() {
		for (int i = 0; i<communityList.length; i++) {
			if (communityList[i] == null) {
				return true;
			}
		}
        return false;
    }

    public Community searchCommunity(String communityName) {
		
        for (int i = 0; i < communityList.length; i++) {
        if (communityList[i] != null && communityList[i].getName().equals(communityName)) {
            return communityList[i];
			}
		}
    return null;
	
    }
	
	public String queryRegisteredAmountOfCommunitiesDependingOfType(String communityTypeToCheck) {
		int tempCounter = 0;
        for (int i = 0; i < communityList.length; i++) {
        if (communityList[i] != null && communityList[i].getCommunityType().equals(communityTypeToCheck)) {
            tempCounter++;
        }
    }
	String message = "The amount of " + communityTypeToCheck + " registered communities is: " + tempCounter;
	return message;
    }
	
	public String displayCommuntiesByLackOfHospitalAndSchool() {
		boolean found = false;
		String message = "";
		for (int i = 0; i < communityList.length; i++) {
			Community currentCommunity = communityList[i];
			if (currentCommunity != null) {
				String[] majorProblems = currentCommunity.getCommunityMajorProblems();
				if (majorProblems != null) {  
					boolean hasHospitalProblem = false;
					boolean hasSchoolProblem = false;

					for (int j = 0; j < majorProblems.length; j++) {
						if ("Lack of hospital".equals(majorProblems[j])) {
							hasHospitalProblem = true;
						}
						if ("Lack of school".equals(majorProblems[j])) {
							hasSchoolProblem = true;
						}
					}

					if (hasHospitalProblem && hasSchoolProblem) {
						System.out.println("Community " + communityList[i].getName());
						found = true;
					}
				}
			}
		}
		
		if (!found) {
			message = "There is no community with these two major problems";
		}
		
		return message;
		}

}