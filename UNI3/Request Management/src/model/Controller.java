package model;

import java.util.ArrayList;

public class Controller {
    // Attributes
    private String nameController;

    // Relations
    private ArrayList<Collaborator> collaboratorsList;

    // Services
    public Controller(String nameController)
    {
        this.nameController = nameController;
        collaboratorsList= new ArrayList<>();
    }

    public String addCollaborator(String collaboratorIdDocument, String collaboratorFullName, String collaboratorEmail, int collaboratorExtensionNumber, int collaboratorImprovementsImplemented, int collaboratorProjectsLed) {

        boolean tempCollab = searchCollaborator(collaboratorIdDocument);
        if (tempCollab == true) {
            return "The Collaborator is already created.";
        }

        ImprovementCollaborator improvementCollaborator = new ImprovementCollaborator(collaboratorIdDocument, collaboratorFullName, collaboratorEmail, collaboratorExtensionNumber, collaboratorImprovementsImplemented, collaboratorProjectsLed);

        collaboratorsList.add(improvementCollaborator);

        return "Full-Time Collaborator successfully created";
    }

    public String addCollaborator(String collaboratorIdDocument, String collaboratorFullName, String collaboratorEmail, int collaboratorExtensionNumber) {

        boolean tempCollab = searchCollaborator(collaboratorIdDocument);
        if (tempCollab == true) {
            return "The Collaborator is already created.";
        }

        Collaborator collaborator = new Collaborator(collaboratorIdDocument, collaboratorFullName, collaboratorEmail, collaboratorExtensionNumber);

        collaboratorsList.add(collaborator);

        return "Collaborator successfully created";
    }

    public boolean searchCollaborator(String collaboratorIdDocument) {
        boolean tempCollab = false;
        for (int i = 0; i < collaboratorsList.size(); i++) {
            if (collaboratorsList.get(i).getCollaboratorId().equals(collaboratorIdDocument)) {
                return tempCollab = true;
            }
        }
        return false;
    }

    public String calculateCollaboratorEfficiency(String collaboratorIdDocument) {

        ImprovementCollaborator tempCollab = searchImprovementCollaborator(collaboratorIdDocument);
        if (tempCollab != null) {
            double collabEfficiency = tempCollab.calculateApplicationsEfficiency();
            return "The collaborator efficieny is: " + collabEfficiency;
        } else {
            return "There is no improvement collaborator registered with that ID document";
        }
    }

    public ImprovementCollaborator searchImprovementCollaborator(String collaboratorIdDocument) {
        ImprovementCollaborator tempCollab=null;
        for (int i = 0; i < collaboratorsList.size(); i++) {
            // Instance of
            if (collaboratorsList.get(i) instanceof ImprovementCollaborator && collaboratorsList.get(i).getCollaboratorId().equals(collaboratorIdDocument)) {
                tempCollab = (ImprovementCollaborator)collaboratorsList.get(i);
            }
        }
        return tempCollab;
    }

    public String showCollaborators() {
    String message = "";

        for (int i = 0; i < collaboratorsList.size(); i++) {
            message += collaboratorsList.get(i).toString();
        }

        if (message.equals("")) {
            return "There are no collaborators registered";
        }

        return message;
    }

    public String removeCollaborator(String collaboratorIdDocument) {

        for (int i = 0; i < collaboratorsList.size(); i++) {
            if (collaboratorsList.get(i).getCollaboratorId().equals(collaboratorIdDocument)) {
                collaboratorsList.remove(i);
                return "Collaborator successfully removed";
            }
        }

        return "There is no collaborator registered with that ID document";
    }

}
