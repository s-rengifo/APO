package model;
public enum PlaceType {
        PRD("Protected"),
        NTP("National Park"),
        PVT("Private");
        
        private final String value;
        
        PlaceType(String value) {
            this.value = value;
        }
        
		 /**
		 *
         * Retrieves the string value associated with the place type
         *
         * @return The string value of the place type
		 *
         */
        public String getValue() {
            return value;
        }
		
    }