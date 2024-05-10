package model;

public class Collaborator  {
    // Attributes
    private String collaboratorIdDocument;
    private String collaboratorFullName;
    private String collaboratorEmail;
    private int collaboratorExtensionNumber;

    // Relations

    //Methods
    public Collaborator(String collaboratorIdDocument, String collaboratorFullName, String collaboratorEmail, int collaboratorExtensionNumber){
        this.collaboratorIdDocument=collaboratorIdDocument;
        this.collaboratorFullName=collaboratorFullName;
        this.collaboratorEmail=collaboratorEmail;
        this.collaboratorExtensionNumber=collaboratorExtensionNumber;
    }

    public String getCollaboratorId() {
        return collaboratorIdDocument;
    }

    public String toString() {
        String result = "COLLABORATOR - " + collaboratorFullName +"\n";
        result += "Document Id: " + collaboratorIdDocument + "\n";
        result += "Email: " + collaboratorEmail + "\n";
        result += "Extension number: " + collaboratorExtensionNumber + "\n";

        return result;
    }

}
