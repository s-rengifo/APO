package model;
public class Community{
	//atributes
	private String communityName;
	private String communityType;
	private String communityBossName;
	private String communityBossPhoneNumber;
	private String[] communityMajorProblems;
	private String communityProduct;
	private int communityAmountInhabitants;
	
	//relations
	
	//methods
	public Community(String communityName, String communityType, String communityBossName, String communityBossPhoneNumber, String[] communityMajorProblems, String communityProduct, int communityAmountInhabitants){
		this.communityName=communityName;
		this.communityType=communityType;
		this.communityBossName=communityBossName;
		this.communityBossPhoneNumber=communityBossPhoneNumber;
		this.communityMajorProblems=communityMajorProblems;
		this.communityProduct=communityProduct;
		this.communityAmountInhabitants=communityAmountInhabitants;
	}	
	
	public String getName() {
		return communityName;
	}
	
	public String getCommunityType() {
		return communityType;
	}
	
	public String[] getCommunityMajorProblems() {
		return communityMajorProblems;
	}
}