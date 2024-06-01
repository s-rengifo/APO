package model;

public class AreaApplicant extends Area {
    // Attributes
    private String officeBelonging;
    private Collaborator collaboratorResponsible;
    // Relations

    // Methods

    public AreaApplicant(String areaName, String areaInternalCode, String officeBelonging, Collaborator collaboratorResponsible){
        super(areaName, areaInternalCode);
        this.officeBelonging=officeBelonging;
        this.collaboratorResponsible=collaboratorResponsible;
    }
}
