package model;

public interface CollaboratorEfficiency {
    /**
     *
     * Calculates the efficiency of a collaborator based on the number of projects ended and the total number of projects
     *
     * @param projectsEndedAmount The number of projects that the collaborator has completed
     * @param projectsAmount The total number of projects assigned to the collaborator
     * @return The calculated efficiency of the collaborator as a double. If no projects are assigned, the efficiency is 0.0
     *
     */
    public double calculateCollaboratorEfficiency(int projectsEndedAmount, int projectsAmount);
}
