package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;


public class Controller {
    // Attributes
    private String nameController;

    // Relations
    private ArrayList<Collaborator> collaboratorsList;
    private ArrayList<Area> areasList;

    // Services
    public Controller(String nameController)
    {
        this.nameController = nameController;
        collaboratorsList= new ArrayList<Collaborator>();
        areasList= new ArrayList<Area>();
    }

    /**
     *
     * Registers a new application
     *
     * @param shortDescription The short description of the application
     * @param collaboratorName The name of the collaborator
     * @param applicationCode The unique code of the application
     * @return A message indicating the result of the registration
     *
     */
    public String registerApplication(String shortDescription,String collaboratorName, String applicationCode) {
            Collaborator applicationCollaborator = searchCollaborator(collaboratorName);
            if (applicationCollaborator==null) {
                return "There is no collaborator registered with this name";
            }

            boolean uniqueApplicationCodeChecker = findApplicationCode(applicationCode);
            if (uniqueApplicationCodeChecker==true) {
                return "There is already an application registered with this application code";
            }

        Status applicationStatus=Status.PEN;
        Date registrationDate = new Date();
        Date applicationManagementDate = null;
        Application application = new Application(registrationDate, shortDescription, applicationStatus, applicationCode, applicationCollaborator, applicationManagementDate);
        AreaApplicant tempApplicantArea = searchAreaApplicant();
        if (tempApplicantArea != null) {
            tempApplicantArea.addApplication(application);
        } else {
            return "There is no Applicant Area registered yet";
        }

        return "Application registered successfully";
    }

    /**
     *
     * Searches for an AreaApplicant in the list of areas
     *
     * @return the AreaApplicant if found, or null if not found
     *
     */
    public AreaApplicant searchAreaApplicant() {
        for (int i = 0; i < areasList.size(); i++) {
            if (areasList.get(i) instanceof AreaApplicant) {
                AreaApplicant areaApplicant = (AreaApplicant) areasList.get(i);
               return areaApplicant;
            }
        }
        return null;
    }

    /**
     *
     * Checks if an application code already exists
     *
     * @param applicationCode The code of the application to search for
     * @return true If the application code exists, false otherwise
     *
     */
    public boolean findApplicationCode(String applicationCode) {
        for (int i = 0; i < areasList.size(); i++) {
            if (areasList.get(i) instanceof AreaApplicant) {
                ArrayList<Application> tempAreaArrayList = areasList.get(i).getApplicationList();
                for (int j = 0; j < tempAreaArrayList.size(); j++) {
                    if (tempAreaArrayList.get(j).getApplicationCode().equals(applicationCode)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     *
     * Adds a new area
     *
     * @param areaName The name of the area
     * @param areaInternalCode The internal code of the area
     * @param areaTempTypeSelection The type selection for the area
     * @return A message indicating the result of the addition
     *
     */
    public String addArea(String areaName, String areaInternalCode, int areaTempTypeSelection) {
        boolean uniqueAreaInternalCodeChecker = findAreaInternalCode(areaInternalCode);
        if (uniqueAreaInternalCodeChecker==true) {
            return "There is already an area registered with this internal code";
        }

        if (areaTempTypeSelection==2) {
            AreaTransformation tempTransformationArea = searchAreaTransformation();
            if (tempTransformationArea != null) {
                return "There is already created an Transformation Area";
            }
            AreaTransformation area = new AreaTransformation(areaName, areaInternalCode);
            areasList.add(area);
        }
        if (areaTempTypeSelection==3) {
            Area area = new Area(areaName, areaInternalCode);
            areasList.add(area);
        }

        return "Area registered successfully";
    }

    /**
     *
     * Searches for an AreaTransformation in the list of areas
     *
     * @return The AreaTransformation if found, or null if not found
     *
     */
    public AreaTransformation searchAreaTransformation() {
        for (int i = 0; i < areasList.size(); i++) {
            if (areasList.get(i) instanceof AreaTransformation) {
                AreaTransformation areaTransformation = (AreaTransformation) areasList.get(i);
                return areaTransformation;
            }
        }
        return null;
    }

    /**
     *
     * Checks if an area internal code already exists
     *
     * @param areaInternalCode The internal code of the area to search for
     * @return true If the area internal code exists, false otherwise
     *
     */
    public boolean findAreaInternalCode(String areaInternalCode) {
        for (int i = 0; i < areasList.size(); i++) {
            if (areasList.get(i).getAreaInternalCode().equals(areaInternalCode)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * Adds a new AreaApplicant
     *
     * @param areaName The name of the area
     * @param areaInternalCode The internal code of the area
     * @param officeBelonging The office to which the area belongs
     * @param nameCollaboratorResponsible The name of the collaborator responsible for the area
     * @return A message indicating the result of the addition
     *
     */
    public String addArea(String areaName, String areaInternalCode, String officeBelonging, String nameCollaboratorResponsible) {
        AreaApplicant tempAplicantArea = searchAreaApplicant();
        if (tempAplicantArea != null) {
            return "There is already created an Applicant Area";
        }

        boolean uniqueAreaInternalCodeChecker = findAreaInternalCode(areaInternalCode);
        if (uniqueAreaInternalCodeChecker==true) {
            return "There is already an area registered with this internal code";
        }

        Collaborator collaboratorResponsible = searchCollaborator(nameCollaboratorResponsible);
        if (collaboratorResponsible==null) {
            return "There is no collaborator registered with this name";
        }

        AreaApplicant area = new AreaApplicant(areaName, areaInternalCode, officeBelonging, collaboratorResponsible);
        if (collaboratorResponsible.getCollaboratorArea()==null) {
            collaboratorResponsible.setCollaboratorArea(area);
        } else { return "This collaborator is already working in another area";}
        areasList.add(area);

        return "Area registered successfully";
    }

    /**
     *
     * Searches for a collaborator by their full name
     *
     * @param nameCollaboratorResponsible The full name of the collaborator to search for
     * @return The collaborator if found, otherwise null
     *
     */
    public Collaborator searchCollaborator(String nameCollaboratorResponsible) {
        for (int i = 0; i < collaboratorsList.size(); i++) {
            if (collaboratorsList.get(i).getCollaboratorFullName().equals(nameCollaboratorResponsible)) {
                Collaborator tempCollaborator = (Collaborator) collaboratorsList.get(i);
                return tempCollaborator;
            }
        }
        return null;
    }

    /**
     *
     * Adds a new collaborator to the list.
     *
     * @param collaboratorIdDocument The ID document of the collaborator
     * @param collaboratorFullName The full name of the collaborator
     * @param collaboratorEmail The email address of the collaborator
     * @param collaboratorExtensionNumber The extension number of the collaborator
     * @param areaInternalCode The internal code of the area the collaborator belongs to
     * @return A message indicating whether the collaborator was successfully added or if there was an error
     *
     */
    public String addCollaborator(String collaboratorIdDocument,String collaboratorFullName,String collaboratorEmail, int collaboratorExtensionNumber, String areaInternalCode) {
        Area collaboratorArea = null;
        boolean uniqueCollaboratorIdDocumentChecker = findCollaboratorIdDocument(collaboratorIdDocument);
        if (uniqueCollaboratorIdDocumentChecker==true) {
            return "There is already a collaborator registered with this ID document number";
        }

        //IF SELECT TO NOT ADD AN AREA NOW IT IS POSSIBLE TO BE EMPTY
        if (!areaInternalCode.isEmpty()) {
            collaboratorArea = searchArea(areaInternalCode);
            if (collaboratorArea==null) {
                return "There is no area registered with this internal code";
            }
        }

        Collaborator collaborator = new Collaborator(collaboratorIdDocument, collaboratorFullName, collaboratorEmail, collaboratorExtensionNumber, collaboratorArea);
        collaboratorsList.add(collaborator);

        return "Collaborator registered successfully";
    }

    /**
     *
     * Searches for a collaborator by their ID document
     *
     * @param collaboratorIdDocument The ID document of the collaborator to search for
     * @return true If a collaborator with the specified ID document is found, false otherwise
     *
     */
    public boolean findCollaboratorIdDocument(String collaboratorIdDocument) {
        for (int i = 0; i < collaboratorsList.size(); i++) {
            if (collaboratorsList.get(i).getCollaboratorId().equals(collaboratorIdDocument)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * Searches for an area by its internal code
     *
     * @param areaInternalCode The internal code of the area to search for
     * @return The Area object if found, null otherwise
     *
     */
    public Area searchArea(String areaInternalCode) {
        for (int i = 0; i < areasList.size(); i++) {
            if (areasList.get(i).getAreaInternalCode().equals(areaInternalCode)) {
                Area tempArea = (Area) areasList.get(i);
                return tempArea;
            }
        }
        return null;
    }

    /**
     *
     * Modifies the status of an application
     *
     * @param applicationCode The code of the application to modify
     * @param applicationStatusSelection The new status selection for the application (1 for PENDING, 2 for REJECTED, 3 for ACCEPTED)
     * @return A message indicating the result of the operation
     *
     */
    public String modifyApplicationStatus(String applicationCode, int applicationStatusSelection) {
        // Search in Areas list which contain all the applications and when find a match between the imputed code and the (i)application, save the application and then set the newStatus
        // 1. Transform input selection
        // 2. Search for each area and getApplications and search with the code if exists and SAVE IT
        // 3. Set newStatus selection (set method should be in the area Class)

        Status newApplicationStatus = null;

        if (applicationStatusSelection==1) {
            newApplicationStatus=Status.PEN;
        }
        else if (applicationStatusSelection==2) {
            newApplicationStatus=Status.REJ;
        }
        else if (applicationStatusSelection==3) {
            newApplicationStatus=Status.ACP;
        }

        Application application = null;
        for (int i = 0; i < areasList.size(); i++) {
            ArrayList<Application> tempApplicationList = areasList.get(i).getApplicationList();
            if (!tempApplicationList.isEmpty()) {
                for (int j = 0; j < tempApplicationList.size(); j++) {
                    if (tempApplicationList.get(j).getApplicationCode().equals(applicationCode)) {
                        application = tempApplicationList.get(j);
                    }
                }
            }
        }
        if (application==null) {
            return "There was not application registered with the imputed code";
        }

        Date applicationManagementDate = new Date();
        application.setApplicationManagementDate(applicationManagementDate);
        application.setApplicationStatus(newApplicationStatus);
        return "The Application Status was changed successfully";
    }

    /**
     *
     * Adds a new Knowledge Management project to an area
     *
     * @param areaInternalCode The internal code of the area
     * @param projectCode The code of the project
     * @param projectName The name of the project
     * @param projectStatusSelection The status selection for the project (1 for PENDING, 2 for REJECTED, 3 for ACCEPTED)
     * @param projectPrioritySelection The priority selection for the project (1 for EMERGENCY, 2 for HIGH, 3 for MEDIUM, 4 for LOW)
     * @param projectLeaderName The name of the project leader
     * @param processName The name of the process
     * @param projectImpactedCommunitySelection The impacted community selection (1 for STUDENTS, 2 for PROFESSORS, 3 for ADMINISTRATIVE)
     * @param projectTypeSelection The type selection for the project (1 for STANDARD, 2 for DOCUMENTATION, 3 for OPERATIONAL)
     * @return A message indicating the result of the operation
     *
     */
    public String addProject(String applicationCode, String areaInternalCode, String projectCode, String projectName, int projectStatusSelection, int projectPrioritySelection, String projectLeaderName, String processName, int projectImpactedCommunitySelection, int projectTypeSelection) {
        Application applicationToTransform = searchApplication(applicationCode);
        if (applicationToTransform==null) {
            return "There is no application registered with the imputed code";
        } else {
            if (applicationToTransform.getApplicationStatus() == Status.ACP) {
                applicationToTransform.setApplicationStatus(Status.PJT);
            } else if (applicationToTransform.getApplicationStatus() == Status.PJT) {
                return "This application was already transformed into a project";
            } else {
                return "This application was not accepted to proceeded as a project";
            }
        }

        boolean areaChecker = findArea(areaInternalCode);
        if (areaChecker==true) {
            boolean uniqueProjectCodeChecker = findProjectCode(projectCode, areaInternalCode);
            if (uniqueProjectCodeChecker==true) {
                return "There is already a project registered with this code";
            } else {
                Status projectStatus = null;

                if (projectStatusSelection==1) {
                    projectStatus=Status.PEN;
                }
                else if (projectStatusSelection==2) {
                    projectStatus=Status.REJ;
                }
                else if (projectStatusSelection==3) {
                    projectStatus=Status.ACP;
                }

                Date projectClassificationDate = null;
                if (projectStatusSelection==2 || projectStatusSelection==3) {
                    projectClassificationDate = new Date();
                }

                Collaborator projectLeader = searchCollaborator(projectLeaderName);
                if (projectLeader==null) {
                    return "There is no collaborator registered with the imputed name";
                }
                if (!(projectLeader.getCollaboratorArea() instanceof AreaTransformation)) {
                    return "The collaborator does not make part from the Transformation Area";
                }

                ProjectPriority projectPriority = null;

                if (projectPrioritySelection==1) {
                    projectPriority=ProjectPriority.EME;
                }
                else if (projectPrioritySelection==2) {
                    projectPriority=ProjectPriority.HIG;
                }
                else if (projectPrioritySelection==3) {
                    projectPriority=ProjectPriority.MED;
                }
                else if (projectPrioritySelection==4) {
                    projectPriority=ProjectPriority.LOW;
                }

                Date estimatedProjectEndDate = null;
                if (projectPrioritySelection==1) {
                    estimatedProjectEndDate= addDays(new Date(), 5);
                }
                else if (projectPrioritySelection==2) {
                    estimatedProjectEndDate= addDays(new Date(), 10);
                }
                else if (projectPrioritySelection==3) {
                    estimatedProjectEndDate= addDays(new Date(), 30);
                }
                else if (projectPrioritySelection==4) {
                    estimatedProjectEndDate= addDays(new Date(), 60);
                }

                Date endProjectDate = null;

                ImpactedCommunity impactedCommunity = null;
                if (projectImpactedCommunitySelection==1) {
                    impactedCommunity=ImpactedCommunity.STU;
                }
                else if (projectImpactedCommunitySelection==2) {
                    impactedCommunity=ImpactedCommunity.PRO;
                }
                else if (projectImpactedCommunitySelection==3) {
                    impactedCommunity=ImpactedCommunity.ADM;
                }

                ProjectType projectType = null;
                if (projectTypeSelection==1) {
                    projectType=ProjectType.STA;
                }
                else if (projectTypeSelection==2) {
                    projectType=ProjectType.DOC;
                }
                else if (projectTypeSelection==3) {
                    projectType=ProjectType.OPT;
                }

                Date registrationProjectDate = new Date();
                ProjectKnowledgeManagement projectKnowledgeManagement = new ProjectKnowledgeManagement(projectCode, projectName, projectStatus, projectClassificationDate, projectLeader, projectPriority, estimatedProjectEndDate, endProjectDate, registrationProjectDate, processName, impactedCommunity, projectType);

                for (int i = 0; i < areasList.size(); i++) {
                    if (areasList.get(i).getAreaInternalCode().equals(areaInternalCode)) {
                        areasList.get(i).addProject(projectKnowledgeManagement);
                        return "KnowledgeManagement Project registered successfully";
                    }
                }
            }
        }
        return "It seems that there is no area registered with this code";

    }

    public Application searchApplication(String applicationCode) {
        Application application = null;
        for (int i = 0; i < areasList.size(); i++) {
            if (areasList.get(i) instanceof AreaApplicant) {
                ArrayList<Application> tempAreaArrayList = areasList.get(i).getApplicationList();
                for (int j = 0; j < tempAreaArrayList.size(); j++) {
                    if (tempAreaArrayList.get(j).getApplicationCode().equals(applicationCode)) {
                        application = tempAreaArrayList.get(j);
                        return application;
                    }
                }
            }
        }
        return application;
    }

    /**
     *
     * Adds a new Process Transformation Improvement project to an area
     *
     * @param areaInternalCode The internal code of the area
     * @param projectCode The code of the project
     * @param projectName The name of the project
     * @param projectStatusSelection The status selection for the project (1 for PENDING, 2 for REJECTED, 3 for ACCEPTED)
     * @param projectPrioritySelection The priority selection for the project (1 for EMERGENCY, 2 for HIGH, 3 for MEDIUM, 4 for LOW)
     * @param projectLeaderName The name of the project leader
     * @param processId The ID of the process
     * @return a message indicating the result of the operation
     *
     */
    public String addProject(String applicationCode, String areaInternalCode, String projectCode, String projectName, int projectStatusSelection, int projectPrioritySelection, String projectLeaderName, String processId) {
        Application applicationToTransform = searchApplication(applicationCode);
        if (applicationToTransform==null) {
            return "There is no application registered with the imputed code";
        } else {
            if (applicationToTransform.getApplicationStatus() == Status.ACP) {
                applicationToTransform.setApplicationStatus(Status.PJT);
            } else if (applicationToTransform.getApplicationStatus() == Status.PJT) {
                return "This application was already transformed into a project";
            } else {
                return "This application was not accepted to proceeded as a project";
            }
        }

        boolean areaChecker = findArea(areaInternalCode);
        if (areaChecker==true) {
            boolean uniqueProjectCodeChecker = findProjectCode(projectCode, areaInternalCode);
            if (uniqueProjectCodeChecker==true) {
                return "There is already a project registered with this code";
            } else {
                Status projectStatus = null;

                if (projectStatusSelection==1) {
                    projectStatus=Status.PEN;
                }
                else if (projectStatusSelection==2) {
                    projectStatus=Status.REJ;
                }
                else if (projectStatusSelection==3) {
                    projectStatus=Status.ACP;
                }

                Date projectClassificationDate = null;
                if (projectStatusSelection==2 || projectStatusSelection==3) {
                    projectClassificationDate = new Date();
                }

                Collaborator projectLeader = searchCollaborator(projectLeaderName);
                if (projectLeader==null) {
                    return "There is no collaborator registered with the imputed name";
                }
                if (!(projectLeader.getCollaboratorArea() instanceof AreaTransformation)) {
                    return "The collaborator does not make part from the Transformation Area";
                }

                ProjectPriority projectPriority = null;

                if (projectPrioritySelection==1) {
                    projectPriority=ProjectPriority.EME;
                }
                else if (projectPrioritySelection==2) {
                    projectPriority=ProjectPriority.HIG;
                }
                else if (projectPrioritySelection==3) {
                    projectPriority=ProjectPriority.MED;
                }
                else if (projectPrioritySelection==4) {
                    projectPriority=ProjectPriority.LOW;
                }

                Date estimatedProjectEndDate = null;
                if (projectPrioritySelection==1) {
                    estimatedProjectEndDate= addDays(new Date(), 5);
                }
                else if (projectPrioritySelection==2) {
                    estimatedProjectEndDate= addDays(new Date(), 10);
                }
                else if (projectPrioritySelection==3) {
                    estimatedProjectEndDate= addDays(new Date(), 30);
                }
                else if (projectPrioritySelection==4) {
                    estimatedProjectEndDate= addDays(new Date(), 60);
                }

                Date endProjectDate = null;

                Date registrationProjectDate = new Date();
                ProjectProcessTransformationImprovement projectProcessTransformationImprovement = new ProjectProcessTransformationImprovement(projectCode, projectName, projectStatus, projectClassificationDate, projectLeader, projectPriority, estimatedProjectEndDate, endProjectDate, registrationProjectDate, processId);

                for (int i = 0; i < areasList.size(); i++) {
                    if (areasList.get(i).getAreaInternalCode().equals(areaInternalCode)) {
                        areasList.get(i).addProject(projectProcessTransformationImprovement);
                        return "ProcessTransformationImprovement Project registered successfully";
                    }
                }
            }
        }
        return "It seems that there is no area registered with this code";

    }

    /**
     *
     * Checks if a project code is unique
     *
     * @param projectCode The code of the project to search for
     * @param areaInternalCode The internal code of the area
     * @return true If the project code exists in the specified area, false otherwise
     *
     */
    public boolean findProjectCode(String projectCode, String areaInternalCode) {
        for (int i = 0; i < areasList.size(); i++) {
            if (areasList.get(i).getAreaInternalCode().equals(areaInternalCode)) {
                ArrayList<Project> tempProjectArrayList = areasList.get(i).getProjectList();
                for (int j = 0; j < tempProjectArrayList.size(); j++) {
                    if (tempProjectArrayList.get(j).getProjectCode().equals(projectCode)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     *
     * Checks if an area with the specified internal code exists
     *
     * @param areaInternalCode The internal code of the area to search for
     * @return true If the area exists, false otherwise
     *
     */
    public boolean findArea(String areaInternalCode) {
        for (int i = 0; i < areasList.size(); i++) {
            if (areasList.get(i).getAreaInternalCode().equals(areaInternalCode)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * Adds a specified number of days to a given date
     *
     * @param date The date to which days will be added
     * @param days The number of days to add
     * @return The new date after adding the specified number of days
     *
     */
    public Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    /**
     *
     * Closes a project by setting its end date to the current date
     *
     * @param projectCode The code of the project to close
     * @return A message indicating the result of the operation
     *
     */
    public String closeProject(String projectCode) {

        if (!(areasList.isEmpty())) {
            for (int i = 0; i < areasList.size(); i++) {
                ArrayList<Project> tempProjectArrayList = areasList.get(i).getProjectList();
                for (int j = 0; j < tempProjectArrayList.size(); j++) {
                    if (tempProjectArrayList.get(j).getProjectCode().equals(projectCode)) {
                        Date endProjectDate = new Date();
                        tempProjectArrayList.get(j).setEndProjectDate(endProjectDate);
                        return "Project closed successfully";
                    }
                }
            }
            return "There is no project registered with the imputed code";
        }
        return "There is no area registered yet, so also there is no project registered yet";
    }

    /**
     *
     * Returns a string representation of the project identified by the given project code
     *
     * @param projectCode The code of the project to be shown
     * @return A string representation of the project if found, otherwise an error message
     *
     */
    public String showProject(String projectCode) {
        if (!(areasList.isEmpty())) {
            for (int i = 0; i < areasList.size(); i++) {
                ArrayList<Project> tempProjectArrayList = areasList.get(i).getProjectList();
                for (int j = 0; j < tempProjectArrayList.size(); j++) {
                    if (tempProjectArrayList.get(j).getProjectCode().equals(projectCode)) {
                        return tempProjectArrayList.get(j).toString();
                    }
                }
            }
            return "There is no project registered with the imputed code";
        }
        return "There is no area registered yet, so also there is no project registered yet";
    }

    /**
     *
     * Creates test objects for the application and project management system
     *
     * @return A message indicating that the test objects were created successfully
     *
     */
    public String createTestObjects() {

        // Collaborator 1
        addCollaborator("1093736295", "Samuel Rengifo", "s.rengifo@u.icesi.edu.co", 57, "");

        // Area 1 | Transformation and improvement
        addArea("Transformation and improvement", "AR01", 2);

        // Area 2 | Applicant
        addArea("Applicant", "AR02", "Major application management", "Samuel Rengifo");

        // Collaborator 2
        addCollaborator("1038940869", "James Hineztrosa", "s.rengifo@u.icesi.edu.co", 57, "AR01");

        // Collaborator 3
        addCollaborator("1948274084", "Percival Von Norden", "p.vnorden@u.icesi.edu.co", 56, "AR01");

        // Collaborator 4
        addCollaborator("1029587365", "Juan Torres", "j.torres@u.icesi.edu.co", 55, "AR01");

        // Collaborator 5
        addCollaborator("1034758927", "Ana Urrego", "a.urrego@u.icesi.edu.co", 54, "AR01");

        // FOR REGISTER AN APPLICATION IT MUST ALREADY REGISTERED AN APPLICANT AREA AND A COLLABORATOR

        // Application 1
        registerApplication("This application is about rise the professors salary", "Samuel Rengifo", "AP01");

        // Application 2
        registerApplication("This application is about open new undergraduate programs", "James Hineztrosa", "AP02");

        // Application 3
        registerApplication("This application is about generate new vacancies", "Percival Von Norden", "AP03");

        // Application 4
        registerApplication("This application is about reduce temporal contracts on the University", "Samuel Rengifo", "AP04");

        // Application 5
        registerApplication("This application is about build a new building in the University", "Juan Torres", "AP05");

        // Application 6
        registerApplication("This application is about open a new cafeteria", "Ana Urrego", "AP06");

        // CHANGE APPLICATION STATUS TO TRANSFORM THEM INTO PROJECT

        // Set new application status for the 6 registered applications
        modifyApplicationStatus("AP01", 3);
        modifyApplicationStatus("AP02", 3);
        modifyApplicationStatus("AP03", 3);
        modifyApplicationStatus("AP04", 3);
        modifyApplicationStatus("AP05", 3);
        modifyApplicationStatus("AP06", 3);

        // Project 1
        addProject("AP01", "AR01", "PJ01", "Rise teachers salary", 1, 4, "James Hineztrosa", "AP01");

        // Project 2
        addProject("AP02", "AR01", "PJ02", "Open new undergraduate programs", 3, 1, "Percival Von Norden", "AP02");

        // Project 3
        addProject("AP03", "AR01", "PJ03", "Generate new vacancies", 1, 3, "Juan Torres", "AP03");

        // Project 4
        addProject("AP04", "AR01", "PJ04", "Reduce temporal contracts on the University", 3, 2, "Ana Urrego", "AP04");

        // Project 5
        addProject("AP05", "AR01", "PJ05", "Build a new building in the University", 1, 4, "Ana Urrego", "AP05");

        // Project 6
        addProject("AP06", "AR01", "PJ06", "Open a new cafeteria", 3, 3, "Juan Torres", "Cafeteria on Saman", 1, 3);

        return "Test Objects created successfully";
    }

    /**
     *
     * Returns a string summarizing the amount of projects by type and priority in the Transformation AREA
     *
     * @return A message detailing the number of projects by type and priority
     *
     */
    public String indicatorTypePriority() {
        int projectKnowledgeManagementCounter = 0;
        int projectProcessTransformationImprovementCounter = 0;
        int projectPriorityEmergencyCounter = 0;
        int projectPriorityHighCounter = 0;
        int projectPriorityMediumCounter = 0;
        int projectPriorityLowCounter = 0;
        AreaTransformation tempTransformationArea = searchAreaTransformation();
        if (tempTransformationArea == null) {
            return "There is no Transformation Area registered";
        }
        ArrayList<Project> tempProjectArrayList = tempTransformationArea.getProjectList();
        for (int j = 0; j < tempProjectArrayList.size(); j++) {
            if (tempProjectArrayList.get(j) instanceof ProjectKnowledgeManagement) {
                projectKnowledgeManagementCounter++;
            } else if (tempProjectArrayList.get(j) instanceof ProjectProcessTransformationImprovement) {
                projectProcessTransformationImprovementCounter++;
            }

            if (tempProjectArrayList.get(j).getProjectPriority() == ProjectPriority.EME) {
                projectPriorityEmergencyCounter++;
            } else if (tempProjectArrayList.get(j).getProjectPriority() == ProjectPriority.HIG) {
                projectPriorityHighCounter++;
            } else if (tempProjectArrayList.get(j).getProjectPriority() == ProjectPriority.MED) {
                projectPriorityMediumCounter++;
            } else if (tempProjectArrayList.get(j).getProjectPriority() == ProjectPriority.LOW) {
                projectPriorityLowCounter++;
            }

        }

        String message = "The project types registered are the following ones: \nKnowledge Management: " + projectKnowledgeManagementCounter + "\nTransformation-Improvement: " + projectProcessTransformationImprovementCounter + "\n";
        message += "The amount of project by priorities registered are: \nEmergency: " + projectPriorityEmergencyCounter + "\nHigh: " + projectPriorityHighCounter + "\nMedium: " + projectPriorityMediumCounter + "\nLow: " + projectPriorityLowCounter + "\n";

        return message;
    }

    /**
     *
     * Returns a string indicating the number of projects each collaborator in the Transformation Area is leading
     *
     * @return A message detailing the number of projects led by each collaborator in the Transformation Area
     *
     */
    public String indicatorProjectLed() {
    String message = "Each collaborator of the Transformation Area is leading the following amount of projects: \n";
    int leaderAppearances = 0;

        AreaTransformation tempTransformationArea = searchAreaTransformation();
        if (tempTransformationArea == null) {
            return "There is no Transformation Area registered";
        }
        ArrayList<Project> tempProjectArrayList = tempTransformationArea.getProjectList();
        for (int i = 0; i < collaboratorsList.size(); i++) {
            if (collaboratorsList.get(i).getCollaboratorArea() instanceof AreaTransformation) {
                Collaborator tempCollaborator = collaboratorsList.get(i);
                for (int j = 0; j < tempProjectArrayList.size(); j++) {
                    if (!(tempProjectArrayList.isEmpty())) {
                        Collaborator indexCollaborator = tempProjectArrayList.get(j).getProjectLeader();
                        if (tempCollaborator == indexCollaborator) {
                            leaderAppearances++;
                        }
                    } else {
                        return "The project list is empty for the area";
                    }
                }
                message += collaboratorsList.get(i).getCollaboratorFullName() + " is leading " + leaderAppearances + " projects. \n";
                leaderAppearances = 0;
            }

        }
        if (message.equals("Each collaborator of the Transformation Area is leading the following amount of projects: \n")) {
            return "There is no collaborator registered in the Transformation Area";
        }
        return message;
    }

    /**
     *
     * Returns a string summarizing the number of applications received in each month
     *
     * @return A message detailing the number of applications received per month
     *
     */
    public String indicatorApplicationReceived() {
        String message = "";
        int januaryCounter = 0;
        int februaryCounter = 0;
        int marchCounter = 0;
        int aprilCounter = 0;
        int mayCounter = 0;
        int juneCounter = 0;
        int julyCounter = 0;
        int augustCounter = 0;
        int septemberCounter = 0;
        int octoberCounter = 0;
        int novemberCounter = 0;
        int decemberCounter = 0;

        AreaApplicant tempApplicantArea = searchAreaApplicant();
        if (tempApplicantArea == null) {
            return "There is no Applicant Area registered";
        }
        ArrayList<Application> tempApplicationArrayList = tempApplicantArea.getApplicationList();
        int applicationAmount = tempApplicationArrayList.size();
        message += "There are currently " + applicationAmount + " applications received in total. \n";
        for (int i = 0; i < tempApplicationArrayList.size(); i++) {
            if (tempApplicationArrayList.get(i).getApplicationManagementDate() != null) {
                Date tempDate = tempApplicationArrayList.get(i).getApplicationManagementDate();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(tempDate);
                int tempMonth = calendar.get(Calendar.MONTH);
                if (tempMonth == Calendar.JANUARY) {
                    januaryCounter++;
                } else if (tempMonth == Calendar.FEBRUARY) {
                    februaryCounter++;
                } else if (tempMonth == Calendar.MARCH) {
                    marchCounter++;
                } else if (tempMonth == Calendar.APRIL) {
                    aprilCounter++;
                } else if (tempMonth == Calendar.MAY) {
                    mayCounter++;
                } else if (tempMonth == Calendar.JUNE) {
                    juneCounter++;
                } else if (tempMonth == Calendar.JULY) {
                    julyCounter++;
                } else if (tempMonth == Calendar.AUGUST) {
                    augustCounter++;
                } else if (tempMonth == Calendar.SEPTEMBER) {
                    septemberCounter++;
                } else if (tempMonth == Calendar.OCTOBER) {
                    octoberCounter++;
                } else if (tempMonth == Calendar.NOVEMBER) {
                    novemberCounter++;
                } else if (tempMonth == Calendar.DECEMBER) {
                    decemberCounter++;
                }
            }
        }
        message += "The applications were managed in the following months: \n January: " + januaryCounter + "\n February: " + februaryCounter + "\n March: " + marchCounter + "\n April: " + aprilCounter + "\n May: " + mayCounter + "\n June: " + juneCounter + "\n July: " + julyCounter + "\n August: " + augustCounter + "\n September: " + septemberCounter + "\n October: " + octoberCounter + "\n November: " + novemberCounter + "\n December: " + decemberCounter + "\n";
        return message;
    }

    /**
     *
     * Searches for a collaborator by their ID document
     *
     * @param collaboratorIdDocument The ID document of the collaborator
     * @return The Collaborator object if found, otherwise null
     *
     */
    public Collaborator searchCollaboratorByIdDocument(String collaboratorIdDocument) {
        for (int i = 0; i < collaboratorsList.size(); i++) {
            if (collaboratorsList.get(i).getCollaboratorId().equals(collaboratorIdDocument)) {
                Collaborator tempCollaborator = (Collaborator) collaboratorsList.get(i);
                return tempCollaborator;
            }
        }
        return null;
    }

    /**
     *
     * Calculates the efficiency of a collaborator for a specified month
     *
     * @param collaboratorIdDocument The ID document of the collaborator
     * @param monthSelection The selected month (1-12) or 0 for the current month
     * @return A message detailing the efficiency of the collaborator
     *
     */
    public String efficiencyCollaborator(String collaboratorIdDocument, int monthSelection) {
        int monthOfYear = -1;
        int projectFinishedCounter = 0;
        int projectsAmount = 0;

        Collaborator tempCollaborator = searchCollaboratorByIdDocument(collaboratorIdDocument);
        if (tempCollaborator == null) {
            return "There is no collaborator registered with the imputed ID document";
        }

        if (monthSelection==0) {
            Date tempActualDate = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(tempActualDate);
            monthOfYear = calendar.get(Calendar.MONTH);
        } else {
            monthOfYear = monthSelection-1;
        }

        if  (!(tempCollaborator.getCollaboratorArea() instanceof AreaTransformation)) {
            return "The collaborator is not from the Transformation Area";
        }

        AreaTransformation tempArea = (AreaTransformation) tempCollaborator.getCollaboratorArea();

            ArrayList<Project> tempProjectArrayList = tempArea.getProjectList();
            for (int j = 0; j < tempProjectArrayList.size(); j++) {
                if (tempProjectArrayList.get(j).getProjectLeader() == tempCollaborator) {
                    Date registrationProjectDate = (Date) tempProjectArrayList.get(j).getRegistrationProjectDate();
                    if (sameMonth(registrationProjectDate, monthOfYear)) {
                        projectsAmount++;
                    }
                    if (tempProjectArrayList.get(j).getEndProjectDate() != null) {
                        Date endProjectDate = (Date) tempProjectArrayList.get(j).getEndProjectDate();
                        if (sameMonth(endProjectDate, monthOfYear)) {
                            projectFinishedCounter++;
                        }
                    }
                }
            }

        double collaboratorEfficiency = tempCollaborator.calculateCollaboratorEfficiency(projectFinishedCounter, projectsAmount);
        collaboratorEfficiency = collaboratorEfficiency*100;
        return "The efficiency for " + tempCollaborator.getCollaboratorFullName() + " is of: " + collaboratorEfficiency + "%";
    }

    /**
     *
     * Checks if a given date falls within the specified month
     *
     * @param date The date to check
     * @param monthSelection The month to compare (0-11)
     * @return True if the date is within the specified month, otherwise false
     *
     */
    public boolean sameMonth(Date date, int monthSelection) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int monthDate = calendar.get(Calendar.MONTH);

        return monthDate == monthSelection;
    }

    /**
     *
     * Calculates the efficiency of a project based on its code
     *
     * @param projectCode The code of the project
     * @return A message detailing the efficiency of the project
     *
     */
    public String efficiencyProject(String projectCode) {
        Project project = searchProject(projectCode);
        if (project == null) {
            return "There is no project registered with the imputed code";
        }
        if (project.getEndProjectDate() == null) {
            return "You cannot calculate the efficiency of a project that is not closed, you have to close the project to proceed";
        }

        double projectEfficiency = project.calculateProjectEfficiency();
        projectEfficiency = projectEfficiency*100;
        return "The efficiency for the project " + projectCode + " is of: " + projectEfficiency + "%";
    }

    /**
     *
     * Searches for a project by its code
     *
     * @param projectCode The code of the project
     * @return The Project object if found, otherwise null
     *
     */
    public Project searchProject(String projectCode) {
        if (!(areasList.isEmpty())) {
            for (int i = 0; i < areasList.size(); i++) {
                ArrayList<Project> tempProjectArrayList = areasList.get(i).getProjectList();
                for (int j = 0; j < tempProjectArrayList.size(); j++) {
                    if (tempProjectArrayList.get(j).getProjectCode().equals(projectCode)) {
                        Project tempProject = (Project) tempProjectArrayList.get(j);
                        return tempProject;
                    }
                }
            }
        }
        return null;
    }

    /**
     *
     * Calculates the efficiency of an application based on its code
     *
     * @param applicationCode The code of the application
     * @return A message detailing the efficiency of the application
     *
     */
    public String efficiencyApplication(String applicationCode) {
        Application application = searchApplication(applicationCode);
        if (application==null) {
            return "There is no application registered with the imputed code";
        }
        if (application.getApplicationManagementDate() == null) {
            return "You cannot calculate the efficiency of an application that has not been managed, you have to manage it first";
        }

        double applicationEfficiency = application.calculateApplicationEfficiency();
        applicationEfficiency = applicationEfficiency*100;
        return "The efficiency for the application " + applicationCode + " is of: " + applicationEfficiency + "%";
    }

    /**
     *
     * Returns a matrix representation of the projects in a specified area
     *
     * @param areaInternalCode The internal code of the area
     * @return A message detailing the matrix of projects in the area
     *
     */
    public String matrixProject(String areaInternalCode) {
        int collaboratorAreaCounter = 0;
        Area area = searchArea(areaInternalCode);
        if (area == null) {
            return "There is no area registered with the imputed code";
        }

        for (int i = 0; i < collaboratorsList.size(); i++) {
            if (collaboratorsList.get(i).getCollaboratorArea() == area) {
                collaboratorAreaCounter++;
            }
        }

        String[][] matrix = new String[collaboratorAreaCounter][6];

        for (int i = 0; i < collaboratorsList.size(); i++) {
            if (collaboratorsList.get(i).getCollaboratorArea() == area) {
                int row = 0;
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[j][0] == null) {
                        row = j;
                        break;
                    }
                }

                matrix[row][0] = "Collaborator #" + (row + 1) + "\n" + collaboratorsList.get(i).getCollaboratorFullName();

                int col = 1;
                for (int k = 0; k < area.getProjectList().size(); k++) {
                    Project project = area.getProjectList().get(k);
                    if (project.getProjectLeader() == collaboratorsList.get(i)) {
                        if (col < 6) {
                            String priorityString = project.getProjectPriority().getValue();
                            char priorityChar = priorityString.charAt(0);
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            Date estimatedProjectEndDate = project.getEstimatedProjectEndDate();
                            String estimatedProjectEndDateSdf = sdf.format(estimatedProjectEndDate);
                            matrix[row][col] = project.getProjectCode() + "-" + priorityChar + "\n" + estimatedProjectEndDateSdf;
                            col++;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        String message = "";
        for (int i = 0; i < matrix.length; i++) {
            boolean emptyRow = true;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != null) {
                    message += matrix[i][j] + " ";
                    emptyRow = false;
                }
            }
            if (!emptyRow) {
                message += "\n ";
            }
        }
        return message;
    }

}
