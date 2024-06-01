package ui;
import java.util.Scanner;
import model.Controller;

public class Main {

    public static Controller mainController;
    public static Scanner scanner= new Scanner(System.in);


    public static void main(String[] args) {
        String nameController="Admin";
        mainController=new Controller (nameController);
        boolean exit=false;
        int option=0;
        do {

            option=mainMenu();
            switch(option) {
                case 1: // Register Menu Selector
                    registerMenu();
                    break;

                case 2: // Change the status of an application
                    changeApplicationStatus();
                    break;

                case 3: // Register Project Menu Selector
                    registerProjectMenu();
                    break;

                case 4: // Close a project
                    closeProject();
                    break;

                case 5: // View matrix project information PENDING TO DEVELOP
                    matrixProjectView();
                    break;

                case 6: // Query information about a specific project
                    showProject();
                    break;

                case 7: // Query Efficiency
                    efficiencyMenu();
                    break;

                case 8: // Query global work indicators
                    globalWorkIndicatorsMenu();
                    break;

                case 9: // Create test objects
                    createTestObjects();
                    break;

                case 10: exit=true;
                    break;

                default: System.out.println("Non valid option");
            }

        } while (!exit);
    }

    // -----BEGINNING OF METHODS-----

    // 1. Main Menu | METHOD int
    /**
     *
     * This method will display to the user, the possible options to choose from the administrative menu and will return the selected option.
     *
     * @return option This variable return an int which will work for choose a option from the administrative menu
     *
     */
    public static int mainMenu() {
        int option=0;
        System.out.println("1. Register (Application - Area - Collaborator) \n2. Change the status of an application \n3. Register a project \n4. Close a project \n5. Matrix project view \n6. Query information about an specific project \n7. Query efficiency \n8. Query global work indicators \n9. Create test objects \n10. EXIT");
        option=scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    /**
     *
     * Displays the register menu options to the user and processes the selected option
     *
     */
    public static void registerMenu(){
        System.out.println("Select an option to register: \n[1] Application \n[2] Area \n[3] Collaborator \n[4] EXIT");
        int registerSelectOption=scanner.nextInt();
        scanner.nextLine();
        switch(registerSelectOption) {
            case 1: // Register An Application
                registerApplication();
                break;

            case 2: // Register An Area
                System.out.println("Select an option to register: \n[1] Applicant Area \n[2] Transformation Area \n[3] Register a new Area");
                int registerAreaSelectOption=scanner.nextInt();
                scanner.nextLine();
                if (registerAreaSelectOption==1) {registerArea(1);}
                else if (registerAreaSelectOption==2) {registerArea(2);}
                else if (registerAreaSelectOption==3) {registerArea(3);}
                else {System.out.println("Non valid option");}
                break;

            case 3: // Register A Collaborator
                registerCollaborator();
                break;

            case 4: // EXIT
                break;

            default: System.out.println("Non valid option");

        }

    }

    /**
     *
     * Prompts details to register a new application and invokes the corresponding method in the mainController
     *
     */
    public static void registerApplication(){
        System.out.println("Write a short description for the application: ");
        String shortDescription=scanner.nextLine();
        System.out.println("Name of the responsible collaborator");
        String collaboratorName=scanner.nextLine();
        System.out.println("Create a four character code for the application");
        String applicationCode=scanner.nextLine();
        String message=mainController.registerApplication(shortDescription,collaboratorName,applicationCode);
        System.out.println(message);
    }

    /**
     *
     * Prompts details to register a new area and invokes the corresponding method in the mainController
     *
     * @param collaboratorAreaSelection The type of area to register
     *
     */
    public static void registerArea(int collaboratorAreaSelection){
        String message = "";
        System.out.println("Write a name for the area:");
        String areaName=scanner.nextLine();
        System.out.println("Type the internal code of the area");
        String areaInternalCode=scanner.nextLine();
        if (collaboratorAreaSelection==1) {
            System.out.println("Office belonging to the area");
            String officeBelonging=scanner.nextLine();
            System.out.println("Collaborator responsible to the area");
            String nameCollaboratorResponsible=scanner.nextLine();
            message = mainController.addArea(areaName, areaInternalCode, officeBelonging, nameCollaboratorResponsible);
        }
        else if (collaboratorAreaSelection==2) {
            message = mainController.addArea(areaName, areaInternalCode, 2);
        }
        else if (collaboratorAreaSelection==3) {
            message = mainController.addArea(areaName, areaInternalCode, 3);
        }

        System.out.println(message);
    }

    /**
     *
     * Prompts details to register a new collaborator and invokes the corresponding method in the mainController
     *
     */
    public static void registerCollaborator(){
        boolean selectionChecker=true;
        String areaInternalCode = "";
        System.out.println("ID document of collaborator");
        String collaboratorIdDocument=scanner.nextLine();
        System.out.println("Full Name of collaborator");
        String collaboratorFullName=scanner.nextLine();
        System.out.println("Institutional email of collaborator");
        String collaboratorEmail=scanner.nextLine();
        System.out.println("Extension number of collaborator");
        int collaboratorExtensionNumber=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Do you want to link the collaborator to an Area? \n [1] Yes \n [2] Not now");
        while (selectionChecker) {
            int tempSelection=scanner.nextInt();
            scanner.nextLine();
            if (tempSelection==1) {
                System.out.println("Type the Area Internal Code to link the collaborator");
                areaInternalCode=scanner.nextLine();
                selectionChecker=false;
            } else if (tempSelection==2) {
                selectionChecker=false;
            }
            else {System.out.println("You did not choose a valid option.");}
        }
        selectionChecker=true;
        String message=mainController.addCollaborator(collaboratorIdDocument, collaboratorFullName, collaboratorEmail, collaboratorExtensionNumber, areaInternalCode);
        System.out.println(message);
    }

    /**
     *
     * Prompts details to change the status of an application and invokes the corresponding method in the mainController
     *
     */
    public static void changeApplicationStatus(){
    boolean selectionChecker=true;
    int applicationStatusSelection=0;
        System.out.println("Write the unique application code: ");
        String applicationCode=scanner.nextLine();
        System.out.println("Select one of the available Application Status: \n[1] Pending \n[2] Rejected \n[3] Accepted");
        while (selectionChecker) {
            applicationStatusSelection=scanner.nextInt();
            scanner.nextLine();
            if (applicationStatusSelection==1) {
                selectionChecker=false;
            }
            else if (applicationStatusSelection==2) {
                selectionChecker=false;
            }
            else if (applicationStatusSelection==3) {
                selectionChecker=false;
            } else {System.out.println("You did not choose a valid option.");}
        }
        selectionChecker=true;
        String message=mainController.modifyApplicationStatus(applicationCode,applicationStatusSelection);
        System.out.println(message);
    }

    /**
     *
     * Displays the register project menu options to the user and processes the selected option
     *
     */
    public static void registerProjectMenu(){
        System.out.println("Select an option to register a project: \n[1] Knowledge Management \n[2] Process Transformation/Improvement \n[3] EXIT");
        int registerSelectOption=scanner.nextInt();
        scanner.nextLine();
        switch(registerSelectOption) {
            case 1: // Register Knowledge Management Project
                registerProject(1);
                break;

            case 2: // Register Process Transformation/Improvement Project
                registerProject(2);
                break;

            case 3: // EXIT
                break;

            default: System.out.println("Non valid option");

        }

    }

    /**
     *
     * Prompts details to register a new project and invokes the corresponding method in the mainController
     *
     * @param projectSelection The type of project to register
     *
     */
    public static void registerProject(int projectSelection){
        String message = "";
        int projectStatusSelection=0;
        int projectPrioritySelection=0;
        boolean selectionChecker=true;
        System.out.println("Type the application code which you are going to transform into a project");
        String applicationCode=scanner.nextLine();
        System.out.println("Type the internal code of the area which will be in charge of the project");
        String areaInternalCode=scanner.nextLine();
        System.out.println("Write the unique project code: ");
        String projectCode=scanner.nextLine();
        System.out.println("Type the project name");
        String projectName=scanner.nextLine();
        System.out.println("Select the Project Status: \n[1] Pending \n[2] Rejected \n[3] Accepted");
        while (selectionChecker) {
            projectStatusSelection=scanner.nextInt();
            scanner.nextLine();
            if (projectStatusSelection==1 || projectStatusSelection==2 || projectStatusSelection==3) {
                selectionChecker=false;
            } else {System.out.println("You did not choose a valid option.");}
        }
        selectionChecker=true;
        System.out.println("Select the Project Priority: \n[1] Emergency \n[2] High \n[3] Medium \n[4] Low");
        while (selectionChecker) {
            projectPrioritySelection=scanner.nextInt();
            scanner.nextLine();
            if (projectPrioritySelection==1 || projectPrioritySelection==2 || projectPrioritySelection==3 || projectPrioritySelection==4) {
                selectionChecker=false;
            } else {System.out.println("You did not choose a valid option.");}
        }
        selectionChecker=true;
        System.out.println("Type the name of the Leader Collaborator from the Transformation Area");
        String projectLeaderName=scanner.nextLine();

        if (projectSelection==1) {
            int projectImpactedCommunitySelection = 0;
            int projectTypeSelection = 0;
            System.out.println("Type the suggested name of the process to manage");
            String processName=scanner.nextLine();
            System.out.println("Select the Impacted Community: \n[1] Students \n[2] Professors \n[3] Administratives");
            while (selectionChecker) {
                projectImpactedCommunitySelection=scanner.nextInt();
                scanner.nextLine();
                if (projectImpactedCommunitySelection==1 || projectImpactedCommunitySelection==2 || projectImpactedCommunitySelection==3) {
                    selectionChecker=false;
                } else {System.out.println("You did not choose a valid option.");}
            }
            selectionChecker=true;
            System.out.println("Select the Project Type: \n[1] Standardization \n[2] Documentation \n[3] Optimization");
            while (selectionChecker) {
                projectTypeSelection=scanner.nextInt();
                scanner.nextLine();
                if (projectTypeSelection==1 || projectTypeSelection==2 || projectTypeSelection==3) {
                    selectionChecker=false;
                } else {System.out.println("You did not choose a valid option.");}
            }
            selectionChecker=true;
            message = mainController.addProject(applicationCode, areaInternalCode, projectCode, projectName, projectStatusSelection, projectPrioritySelection, projectLeaderName, processName, projectImpactedCommunitySelection, projectTypeSelection);
        }
        else if (projectSelection==2) {
            System.out.println("Type the code of the process to be improved");
            String processId=scanner.nextLine();
            message = mainController.addProject(applicationCode, areaInternalCode, projectCode, projectName, projectStatusSelection, projectPrioritySelection, projectLeaderName, processId);
        }
        System.out.println(message);
    }

    /**
     *
     * Prompts the user to enter a project code to close a project and invokes the corresponding method in the mainController
     *
     */
    public static void closeProject(){
        System.out.println("Write the project code: ");
        String projectCode=scanner.nextLine();
        String message=mainController.closeProject(projectCode);
        System.out.println(message);
    }

    /**
     *
     * Prompts the user to enter an area code and displays the matrix of projects related to that area
     *
     */
    public static void matrixProjectView(){
        System.out.println("Write the Area code to show the projects: ");
        String areaInternalCode=scanner.nextLine();
        String message=mainController.matrixProject(areaInternalCode);
        System.out.println(message);
    }

    /**
     *
     * Prompts the user to enter a project code and displays the details of the specified project
     *
     */
    public static void showProject(){
        System.out.println("Write the Project code: ");
        String projectCode=scanner.nextLine();
        String message=mainController.showProject(projectCode);
        System.out.println(message);
    }

    /**
     *
     * Creates test objects and displays a message indicating the result of the operation
     *
     */
    public static void createTestObjects(){
        String message=mainController.createTestObjects();
        System.out.println(message);
    }

    /**
     *
     * Displays a menu for querying global work indicators and executes the selected query
     *
     */
    public static void globalWorkIndicatorsMenu(){
        System.out.println("Select an option to query an indicator: \n[1] Amount of projects for each type and each priority in Transformation AREA \n[2] Amount of projects led by each collaborator in Transformation AREA \n[3] Amount of applications received and managed during a given month in Applicant AREA \n[4] EXIT");
        int indicatorSelectOption=scanner.nextInt();
        scanner.nextLine();
        switch(indicatorSelectOption) {
            case 1: // Amount of projects for each type and each priority in | Transformation AREA
                indicatorTypePriority();
                break;

            case 2: // Amount of projects led by each collaborator in | Transformation AREA
                indicatorProjectLed();
                break;

            case 3: // Amount of applications received and managed during a given month in | Applicant AREA
                indicatorApplicationReceived();
                break;

            case 4: // EXIT
                break;

            default: System.out.println("Non valid option");

        }

    }

    /**
     *
     * Displays the amount of projects for each type and priority in the Transformation AREA
     *
     */
    public static void indicatorTypePriority(){
        String message=mainController.indicatorTypePriority();
        System.out.println(message);
    }

    /**
     *
     * Displays the amount of projects led by each collaborator in the Transformation AREA
     *
     */
    public static void indicatorProjectLed(){
        String message=mainController.indicatorProjectLed();
        System.out.println(message);
    }

    /**
     *
     * Displays the amount of applications received and managed during a given month in the Applicant AREA
     *
     */
    public static void indicatorApplicationReceived(){
        String message=mainController.indicatorApplicationReceived();
        System.out.println(message);
    }

    /**
     *
     * Displays a menu for querying efficiency and executes the selected query
     *
     */
    public static void efficiencyMenu(){
        System.out.println("Select an option to query the efficiency: \n[1] Collaborator in Transformation AREA \n[2] Project \n[3] Application \n[4] EXIT");
        int indicatorSelectOption=scanner.nextInt();
        scanner.nextLine();
        switch(indicatorSelectOption) {
            case 1: // Collaborator in | Transformation AREA
                efficiencyCollaborator();
                break;

            case 2: // A specific project
                efficiencyProject();
                break;

            case 3: // A specific application
                efficiencyApplication();
                break;

            case 4: // EXIT
                break;

            default: System.out.println("Non valid option");

        }

    }

    /**
     *
     * Prompts the user to enter a collaborator ID document and the month for which the efficiency of the collaborator should be calculated, then displays the calculated efficiency
     *
     */
    public static void efficiencyCollaborator(){
        boolean selectionChecker=true;
        int monthSelection = -1;

        System.out.println("First, type the collaborator ID document");
        String collaboratorIdDocument=scanner.nextLine();
        System.out.println("In which month do you want to calculate the efficiency of the collaborator: \n [0] Actual month \n [1-12] An specific month of the year");
        while (selectionChecker) {
            monthSelection=scanner.nextInt();
            scanner.nextLine();
            if (monthSelection>=0 && monthSelection<=12) {
                selectionChecker=false;
            } else {System.out.println("You did not choose a valid option.");}
        }
        selectionChecker=true;
        String message=mainController.efficiencyCollaborator(collaboratorIdDocument, monthSelection);
        System.out.println(message);
    }

    /**
     *
     * Prompts the user to enter a project code and displays the efficiency of the specified project
     *
     */
    public static void efficiencyProject(){
        System.out.println("Type the Project code");
        String projectCode=scanner.nextLine();
        String message=mainController.efficiencyProject(projectCode);
        System.out.println(message);
    }

    /**
     *
     * Prompts the user to enter an application code and displays the efficiency of the specified application
     *
     */
    public static void efficiencyApplication(){
        System.out.println("Type the Application code");
        String applicationCode=scanner.nextLine();
        String message=mainController.efficiencyApplication(applicationCode);
        System.out.println(message);
    }

}
