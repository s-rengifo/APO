package model;

public class ImprovementCollaborator extends Collaborator implements Efficient {

    // Attributes
    private int collaboratorImprovementsImplemented;
    private int collaboratorProjectsLed;
    // Relations

    // Methods

    public ImprovementCollaborator(String collaboratorIdDocument, String collaboratorFullName, String collaboratorEmail, int collaboratorExtensionNumber, int collaboratorImprovementsImplemented, int collaboratorProjectsLed){
        super(collaboratorIdDocument, collaboratorFullName, collaboratorEmail, collaboratorExtensionNumber);
        this.collaboratorImprovementsImplemented=collaboratorImprovementsImplemented;
        this.collaboratorProjectsLed=collaboratorProjectsLed;
    }

    @Override
    public double calculateApplicationsEfficiency() {
        double applicationEfficiency = 0.0;
        if (collaboratorProjectsLed != 0) {
            applicationEfficiency = (double) collaboratorImprovementsImplemented / collaboratorProjectsLed;
        }
        return applicationEfficiency;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Improvements Implemented: " + collaboratorImprovementsImplemented + "\n" + "Projects Led: " + collaboratorProjectsLed + "\n";
    }

}
