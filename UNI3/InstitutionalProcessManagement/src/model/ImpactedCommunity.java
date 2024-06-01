package model;

public enum ImpactedCommunity {
    STU("Students"),
    PRO("Professors"),
    ADM("Administratives");

    private final String value;

    ImpactedCommunity(String value) {
        this.value = value;
    }

    /**
     *
     * Retrieves the string value associated with the Impacted Community
     *
     * @return The string value of the Impacted Community
     *
     */
    public String getValue() {
        return value;
    }

}