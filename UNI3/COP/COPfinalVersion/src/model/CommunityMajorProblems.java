package model;
public enum CommunityMajorProblems {
        HOS("Lack of hospital"),
        SCH("Lack of school"),
        WAT("Lack of potable water"),
        FOD("Lack of access to basic food");
        
        private final String value;
        
        CommunityMajorProblems(String value) {
            this.value = value;
        }
        
		/**
		 *
         * Retrieves the string value associated with the major problem.
         *
         * @return The string value of the major problem
		 *
         */
        public String getValue() {
            return value;
        }
    }