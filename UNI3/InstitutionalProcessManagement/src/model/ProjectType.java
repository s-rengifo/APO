package model;

public enum ProjectType {
    STA("Standardization"),
    DOC("Documentation"),
    OPT("Optimization");

    private final String value;

    ProjectType(String value) {
        this.value = value;
    }

    /**
     *
     * Retrieves the string value associated with the Project Type
     *
     * @return The string value of the Project Type
     *
     */
    public String getValue() {
        return value;
    }

}