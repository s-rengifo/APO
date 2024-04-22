package model;
public class Product{
	// Atributes
	private String productName;
	private double productNaturalPercentage;
	private ProductType productType;
	private String productHandmade;
	
	// Relations
	
	// Methods
	
	public enum ProductType {
        FOD("Food"),
        CRF("Craft");
        
        private final String value;
        
        ProductType(String value) {
            this.value = value;
        }
        
		 /**
		 *
         * Retrieves the string value associated with the product type
         *
         * @return The string value of the product type
		 *
         */
        public String getValue() {
            return value;
        }
		
    }
	
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