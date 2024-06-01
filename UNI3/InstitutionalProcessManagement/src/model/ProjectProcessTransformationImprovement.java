package model;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProjectProcessTransformationImprovement extends Project {
    // Attributes
    private String processId;
    // Relations

    // Methods

    public ProjectProcessTransformationImprovement(String projectCode, String projectName, Status projectStatus, Date projectClassificationDate, Collaborator projectLeader, ProjectPriority projectPriority, Date estimatedProjectEndDate, Date endProjectDate, Date registrationProjectDate, String processId){
        super(projectCode, projectName, projectStatus, projectClassificationDate, projectLeader, projectPriority, estimatedProjectEndDate, endProjectDate, registrationProjectDate);
        this.processId=processId;
    }

    /**
     *
     * Returns a string representation of the project
     *
     * @return A string containing information about the project, including its name, leader, status, classification date (if available), priority, estimated end date (if available), process ID, and whether it is finished or not
     *
     */
    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
        String formattedDate = "";
        String result = "Project name: " + projectName + "\n";
        result += "Leader of the project: " + projectLeader.getCollaboratorFullName() + "\n";
        result += "Status: " + projectStatus.getValue() + "\n";
        if (projectClassificationDate!=null) {
            formattedDate = formatter.format(projectClassificationDate);
            result += "Classification Date: " + formattedDate + "\n";
        }
        if (projectPriority!=null) {
            result += "Priority: " + projectPriority.getValue() + "\n";
            formattedDate = formatter.format(estimatedProjectEndDate);
            result += "Estimated End Date: " + formattedDate + "\n";
        }
        result += "Process ID: " + processId + "\n";
        if (endProjectDate!=null) {
            formattedDate = formatter.format(endProjectDate);
            result += "Project Finished on: " + formattedDate + "\n";
            result += "THIS PROJECT IS FINISHED ALREADY";
        }

        return result;
    }
}
