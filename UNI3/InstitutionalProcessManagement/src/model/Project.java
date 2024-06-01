package model;

import java.util.Date;

public abstract class Project implements ProjectEfficiency {
    // Attributes
    protected String projectCode;
    protected String projectName;
    protected Status projectStatus;
    protected Date projectClassificationDate;
    protected Collaborator projectLeader;
    protected ProjectPriority projectPriority;
    protected Date estimatedProjectEndDate;
    protected Date endProjectDate;
    protected Date registrationProjectDate;

    // Relations

    // Methods
    public Project(String projectCode, String projectName, Status projectStatus, Date projectClassificationDate, Collaborator projectLeader, ProjectPriority projectPriority, Date estimatedProjectEndDate, Date endProjectDate, Date registrationProjectDate){
        this.projectCode=projectCode;
        this.projectName=projectName;
        this.projectStatus=projectStatus;
        this.projectClassificationDate=projectClassificationDate;
        this.projectLeader=projectLeader;
        this.projectPriority=projectPriority;
        this.estimatedProjectEndDate=estimatedProjectEndDate;
        this.endProjectDate=endProjectDate;
        this.registrationProjectDate=registrationProjectDate;
    }

    /**
     *
     * Gets the code of the project
     *
     * @return The code of the project
     *
     */
    public String getProjectCode() { return projectCode; }

    /**
     *
     * Sets the actual end date of the project
     *
     * @param endProjectDate The new actual end date of the project
     *
     */
    public void setEndProjectDate(Date endProjectDate) {
        this.endProjectDate = endProjectDate;
    }

    /**
     *
     * Returns a string representation of the project
     *
     * @return A string representation of the project
     *
     */
    public abstract String toString();

    /**
     *
     * Gets the priority of the project
     *
     * @return The priority of the project as a ProjectPriority enum
     *
     */
    public ProjectPriority getProjectPriority() { return projectPriority; }

    /**
     *
     * Gets the leader of the project
     *
     * @return The leader of the project as a Collaborator object
     *
     */
    public Collaborator getProjectLeader() { return projectLeader; }

    /**
     *
     * Gets the end date of the project
     *
     * @return The end date of the project as a Date object
     *
     */
    public Date getEndProjectDate() { return endProjectDate; }

    /**
     *
     * Gets the registration date of the project
     *
     * @return The registration date of the project as a Date object
     *
     */
    public Date getRegistrationProjectDate() { return registrationProjectDate; }

    /**
     *
     * Gets the estimated end date of the project
     *
     * @return The estimated end date of the project as a Date object
     *
     */
    public Date getEstimatedProjectEndDate() { return estimatedProjectEndDate; }

    /**
     *
     * Calculates the efficiency of the project
     *
     * @return The calculated efficiency of the project as a double
     *
     */
    @Override
    public double calculateProjectEfficiency() {
        double projectEfficiency = 0.0;
        long diffInMillies = Math.abs(endProjectDate.getTime() - estimatedProjectEndDate.getTime());
        long diffInDays = diffInMillies / (24 * 60 * 60 * 1000);
        projectEfficiency = 1 - (diffInDays/100);
        return projectEfficiency;
    }
}

