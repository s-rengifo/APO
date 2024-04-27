package model;
public enum PlaceDepartment {
        CHO("Choco"),
        VAL("Valle del cauca"),
        CAU("Cauca"),
		NAR("Narino");
        
        private String value;
        
        private PlaceDepartment(String value) {
            this.value = value;
        }
		
		 /**
		 *
         * Retrieves the string value associated with the place department
         *
         * @return The string value of the place department
		 *
         */
		public String getPlaceDepartmentString() {
			return value;
		}
        
		 /**
		 *
         * Retrieves the string value associated with the place department
         *
         * @return The string value of the place department
		 *
         */
        public String getValue() {
            return value;
        }
		
    }