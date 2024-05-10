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

                case 1: // Register collaborator
                    registerCollaborator(1);
                    break;

                case 2: // Register improvement collaborator
                    registerCollaborator(2);
                    break;

                case 3: // Calculate efficiency of a collaborator
                    calculateCollaboratorEfficiency();
                    break;

                case 4: // Display all registered collaborators
                    showCollaborators();
                    break;

                case 5: // Remove a collaborator
                    removeCollaborator();
                    break;

                case 6: exit=true;
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
        System.out.println("1. Register collaborator \n2. Register improvement collaborator \n3. Calculate the efficiency of a collaborator \n4. Display registered collaborators \n5. Remove a collaborator \n6. EXIT");
        option=scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    public static void registerCollaborator(int collaboratorTypeSelection){
        String message = "";
        System.out.println("ID document of collaborator");
        String collaboratorIdDocument=scanner.nextLine();
        System.out.println("Full Name of collaborator");
        String collaboratorFullName=scanner.nextLine();
        System.out.println("Institutional email of collaborator");
        String collaboratorEmail=scanner.nextLine();
        System.out.println("Extension number of collaborator");
        int collaboratorExtensionNumber=scanner.nextInt();
        if (collaboratorTypeSelection==2) {
            System.out.println("Number of improvements implemented");
            int collaboratorImprovementsImplemented = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Number of projects led");
            int collaboratorProjectsLed = scanner.nextInt();
            scanner.nextLine();
            message=mainController.addCollaborator(collaboratorIdDocument,collaboratorFullName,collaboratorEmail, collaboratorExtensionNumber, collaboratorImprovementsImplemented, collaboratorProjectsLed);
        } else if (collaboratorTypeSelection==1) {
            message=mainController.addCollaborator(collaboratorIdDocument,collaboratorFullName,collaboratorEmail, collaboratorExtensionNumber);
        }

        System.out.println(message);

    }

    public static void calculateCollaboratorEfficiency(){
        System.out.println("What is the collaborator");
        System.out.println("ID document?");
        String collaboratorIdDocument=scanner.nextLine();
        String message=mainController.calculateCollaboratorEfficiency(collaboratorIdDocument);
        System.out.println(message);

    }

    public static void showCollaborators(){
        String message=mainController.showCollaborators();
        System.out.println(message);
    }

    public static void removeCollaborator(){
        System.out.println("ID document of collaborator");
        String collaboratorIdDocument=scanner.nextLine();
        String message=mainController.removeCollaborator(collaboratorIdDocument);
        System.out.println(message);
    }

}
