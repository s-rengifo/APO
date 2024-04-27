package model;
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