package model;

public enum Status {
    PEN("Pending"),
    REJ("Rejected"),
    ACP("Accepted"),
    PJT("Project");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    /**
     *
     * Retrieves the string value associated with the Status
     *
     * @return The string value of the Status
     *
     */
    public String getValue() {
        return value;
    }

}