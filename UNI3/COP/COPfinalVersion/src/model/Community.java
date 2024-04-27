package model;
public class Community{
	// Atributes
	private String communityName;
	private CommunityType communityType;
	private String communityBossName;
	private String communityBossPhoneNumber;
	private CommunityMajorProblems[] communityMajorProblems;
	private int communityAmountInhabitants;
	private Product[] productList; 
	
	// Relations
	
	// Methods
	
	 /**
	 *
     * Constructs a new Community object with the specified attributes
     *
     * @param communityName The name of the community
     * @param communityType The type of the community
     * @param communityBossName The name of the community boss or leader
     * @param communityBossPhoneNumber The phone number of the community boss or leader
     * @param communityMajorProblems An array containing the major problems faced by the community
     * @param communityAmountInhabitants The total number of inhabitants in the community
     *
	 */
	public Community(String communityName, CommunityType communityType, String communityBossName, String communityBossPhoneNumber, CommunityMajorProblems[] communityMajorProblems, int communityAmountInhabitants){
		this.communityName=communityName;
		this.communityType=communityType;
		this.communityBossName=communityBossName;
		this.communityBossPhoneNumber=communityBossPhoneNumber;
		this.communityMajorProblems=communityMajorProblems;
		this.communityAmountInhabitants=communityAmountInhabitants;
		productList= new Product[20];
	}	
	
	 /**
	 *
     * Retrieves the string value of the community type
     *
     * @return The string value of the community type
     */
	public String getCommunityType() {
			return communityType.getValue();
		}
	
	 /**
     * Retrieves the name of the community
     *
     * @return The name of the community
     */
	public String getName() {
		return communityName;
	}
	
	 /**
	 *
     * Retrieves the array of major problems faced by the community
     *
     * @return an array of major problems faced by the community
	 *
     */
	public CommunityMajorProblems[] getCommunityMajorProblems() {
		return communityMajorProblems;
	}
	
	 /**
	 *
     * Retrieves the array of products registered for the community
     *
     * @return An array of products registered for the community
     */
	public Product[] getProductList() {
		return productList;
	}
	
	/**
	*
	* Adds a product to the product list
	*
	* @param product The product to be added
	* @return True if the product was successfully added, false otherwise
	*
	*/
	public boolean addProduct(Product product){
		boolean exit = false;
		for (int i = 0; i < productList.length && !exit; i++) {
				if (productList[i] == null) {
					productList[i] = product;
					exit = true;
				}
			}
	 return exit;
	}
	
	/**
	*
	* Deletes a product from the product list based on its name
	*
	* @param productName The name of the product to be deleted
	* @param productList The list of products from which to delete
	* @return A message indicating the result of the deletion operation
	*
	*/
	public String deleteOneProduct(String productName, Product[] productList){
		String message = "Product not found";
		for (int j = 0; j < productList.length; j++) {
                    if (productList[j] != null && productList[j].getName().equalsIgnoreCase(productName)) {
                        productList[j] = null;
                        message = "Product deleted successfully";
                    }
                }
	 return message;
	}
	
	/**
	*
	* Provides a string of the community, including its details and products
	*
	* @return A string of the community
	*
	*/
	@Override
	public String toString() {
		Product product = null;
		String result = "COMMUNITY - " + communityName + "\n";
		result += "Type: " + communityType.getValue() + "\n";
		result += "Boss name: " + communityBossName + "\n";
		result += "Boss number: " + communityBossPhoneNumber + "\n";
		result += "Major Problems: \n";
		for (CommunityMajorProblems majorProblem : communityMajorProblems) {
			if (majorProblem != null) {
				result += "\t" + majorProblem.getValue() + "\n";
			}
		}
		result += "Amount of Inhabitants: " + communityAmountInhabitants + "\n";
		result += "Products: \n";
		for (int i = 0; i < productList.length; i++) {
			product = productList[i];
			if (product != null) {
				result += "\t" + product.getName() + "\n";
			}
		}
		
    return result;
	}
	
}