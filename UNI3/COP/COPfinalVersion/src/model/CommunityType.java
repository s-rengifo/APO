package model;
public enum CommunityType {
        AFR("Afrocolombian"),
        IND("Indigenous"),
        RAI("Raizal");
        
        private final String value;
        
        CommunityType(String value) {
            this.value = value;
        }
        
		/**
		 *
         * Retrieves the string value associated with the community type
         *
         * @return The string value of the community type
		 *
         */
        public String getValue() {
            return value;
        }
		
    }