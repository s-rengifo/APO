package model;

public enum ProjectPriority {
    EME("Emergency"),
    HIG("High"),
    MED("Medium"),
    LOW("Low");

    private final String value;

    ProjectPriority(String value) {
        this.value = value;
    }

    /**
     *
     * Retrieves the string value associated with the Project Priority
     *
     * @return The string value of the Project Priority
     *
     */
    public String getValue() {
        return value;
    }

}
