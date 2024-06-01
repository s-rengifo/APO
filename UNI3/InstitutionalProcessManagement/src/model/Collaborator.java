package model;

public class Collaborator implements CollaboratorEfficiency {
    // Attributes
    private String collaboratorIdDocument;
    private String collaboratorFullName;
    private String collaboratorEmail;
    private int collaboratorExtensionNumber;
    private Area collaboratorArea;

    // Relations

    //Methods
    public Collaborator(String collaboratorIdDocument, String collaboratorFullName, String collaboratorEmail, int collaboratorExtensionNumber, Area collaboratorArea){
        this.collaboratorIdDocument=collaboratorIdDocument;
        this.collaboratorFullName=collaboratorFullName;
        this.collaboratorEmail=collaboratorEmail;
        this.collaboratorExtensionNumber=collaboratorExtensionNumber;
        this.collaboratorArea=collaboratorArea;
    }

    /**
     *
     * Gets the ID document of the collaborator
     *
     * @return The ID document of the collaborator
     *
     */
    public String getCollaboratorId() {
        return collaboratorIdDocument;
    }

    /**
     *
     * Gets the full name of the collaborator
     *
     * @return The full name of the collaborator
     *
     */
    public String getCollaboratorFullName() {
        return collaboratorFullName;
    }

    /**
     *
     * Gets the area associated with the collaborator
     *
     * @return The area associated with the collaborator
     *
     */
    public Area getCollaboratorArea() {
        return collaboratorArea;
    }

    /**
     *
     * Sets the area associated with the collaborator
     *
     * @param collaboratorArea The new area to be associated with the collaborator
     *
     */
    public void setCollaboratorArea(Area collaboratorArea) {
        this.collaboratorArea = collaboratorArea;
    }

    /**
     *
     * Calculates the efficiency of a collaborator based on the number of projects ended and the total number of projects
     *
     * @param projectsEndedAmount The number of projects that the collaborator has completed
     * @param projectsAmount The total number of projects assigned to the collaborator
     * @return The calculated efficiency of the collaborator as a double. If no projects are assigned, the efficiency is 0.0
     *
     */
    @Override
    public double calculateCollaboratorEfficiency(int projectsEndedAmount, int projectsAmount) {
        double collaboratorEfficiency = 0.0;
        if (projectsAmount != 0) {
            collaboratorEfficiency = (double) projectsEndedAmount/projectsAmount;
        }
        return collaboratorEfficiency;
    }

}
