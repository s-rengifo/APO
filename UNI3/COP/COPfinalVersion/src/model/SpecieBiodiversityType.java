package model;
public enum SpecieBiodiversityType {
        FLO("Flora"),
        FAU("Fauna");
        
        private final String value;
        
        SpecieBiodiversityType(String value) {
            this.value = value;
        }
        
		 /**
		 *
         * Retrieves the string value associated with the biodiversity type
         *
         * @return The string value of the biodiversity type
		 *
         */
        public String getValue() {
            return value;
        }
		
    }