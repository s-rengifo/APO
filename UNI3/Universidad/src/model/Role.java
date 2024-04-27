package model;
public enum Role {
        LEA("Leader"),
        EXE("Executant"),
        OBS("Observer");
		
        private final String value;
        
        Role(String value) {
            this.value = value;
        }
        
		/**
		 *
         * Retrieves the string value associated with the role
         *
         * @return The string value of the role
		 *
         */
        public String getValue() {
            return value;
        }
		
    }