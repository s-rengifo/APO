package model;
public class Product{
	//atributes
	private String productName;
	private double productNaturalPercentage;
	private String productType;
	private String productHandmade;
	
	//relations
	
	//methods
	public Product(String productName, double productNaturalPercentage, String productType, String productHandmade){
		this.productName=productName;
		this.productNaturalPercentage=productNaturalPercentage;
		this.productType=productType;
		this.productHandmade=productHandmade;
	}
}