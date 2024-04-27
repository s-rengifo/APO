package model;
public class Product{
	// Atributes
	private String productName;
	private double productNaturalPercentage;
	private ProductType productType;
	private String productHandmade;
	
	// Relations
	
	// Methods
	
	 /**
	 *
     * Constructs a new Product object with the specified attributes
     *
     * @param productName The name of the product
     * @param productNaturalPercentage The percentage of natural ingredients in the product
     * @param productType The type of the product
     * @param productHandmade Indicates whether the product is handmade or not
	 *
     */
	public Product(String productName, double productNaturalPercentage, ProductType productType, String productHandmade){
		this.productName=productName;
		this.productNaturalPercentage=productNaturalPercentage;
		this.productType=productType;
		this.productHandmade=productHandmade;
	}
	
	 /**
	 *
     * Retrieves the name of the product
     *
     * @return the name of the product
	 *
     */
	public String getName() {
		return productName;
	}	
	
}