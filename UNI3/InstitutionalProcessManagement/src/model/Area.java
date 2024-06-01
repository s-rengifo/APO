package model;

import java.util.ArrayList;

public class Area  {
    // Attributes
    private String areaName;
    private String areaInternalCode;
    private ArrayList<Application> applicationsList;
    private ArrayList<Project> projectsList;

    // Relations

    //Methods
    public Area(String areaName, String areaInternalCode){
        this.areaName=areaName;
        this.areaInternalCode=areaInternalCode;
        applicationsList= new ArrayList<Application>();
        projectsList= new ArrayList<Project>();
    }

    /**
     *
     * Gets the list of applications associated with this area
     *
     * @return The list of applications
     *
     */
    public ArrayList<Application> getApplicationList() { return applicationsList; }

    /**
     *
     * Gets the list of projects associated with this area
     *
     * @return The list of projects
     *
     */
    public ArrayList<Project> getProjectList() { return projectsList; }

    /**
     *
     * Gets the internal code of the area
     *
     * @return The internal code of the area
     *
     */
    public String getAreaInternalCode() { return areaInternalCode; }

    /**
     *
     * Adds an application to the list of applications associated with this area
     *
     * @param application The application to be added
     *
     */
    public void addApplication(Application application){
        applicationsList.add(application);
    }

    /**
     *
     * Adds a Knowledge Management project to the list of projects associated with this area
     *
     * @param projectKnowledgeManagement The Knowledge Management project to be added
     *
     */
    public void addProject(ProjectKnowledgeManagement projectKnowledgeManagement){
        projectsList.add(projectKnowledgeManagement);
    }

    /**
     *
     * Adds a Process Transformation Improvement project to the list of projects associated with this area
     *
     * @param projectProcessTransformationImprovement The Process Transformation Improvement project to be added
     *
     */
    public void addProject(ProjectProcessTransformationImprovement projectProcessTransformationImprovement){
        projectsList.add(projectProcessTransformationImprovement);
    }

}
