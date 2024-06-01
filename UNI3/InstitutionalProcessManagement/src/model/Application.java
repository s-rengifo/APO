package model;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

public class Application implements ApplicationEfficiency {
    // Attributes
    private Date registrationDate;
    private String shortDescription;
    private Status applicationStatus;
    private String applicationCode;
    private Collaborator applicationCollaborator;
    private Date applicationManagementDate;

    // Relations

    //Methods
    public Application(Date registrationDate, String shortDescription, Status applicationStatus, String applicationCode, Collaborator applicationCollaborator, Date applicationManagementDate){
        this.registrationDate=registrationDate;
        this.shortDescription=shortDescription;
        this.applicationStatus=applicationStatus;
        this.applicationCode=applicationCode;
        this.applicationCollaborator=applicationCollaborator;
        this.applicationManagementDate=applicationManagementDate;
    }

    /**
     *
     * Gets the unique code of the application
     *
     * @return The application code
     *
     */
    public String getApplicationCode() { return applicationCode; }

    /**
     *
     * Sets the status of the application
     *
     * @param applicationStatus The new status to be set for the application
     *
     */
    public void setApplicationStatus(Status applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    /**
     *
     * Sets the management date for the application
     *
     * @param applicationManagementDate The date when the application was managed
     *
     */
    public void setApplicationManagementDate(Date applicationManagementDate) {
        this.applicationManagementDate = applicationManagementDate;
    }

    /**
     *
     * Gets the current status of the application
     *
     * @return The current status of the application
     *
     */
    public Status getApplicationStatus() { return applicationStatus; }

    /**
     *
     * Gets the management date of the application
     *
     * @return The date when the application was managed
     *
     */
    public Date getApplicationManagementDate() { return applicationManagementDate; }

    /**
     *
     * Calculates the efficiency of the application based on the difference between the registration date and the management date
     *
     * @return The calculated efficiency of the application
     *
     */
    @Override
    public double calculateApplicationEfficiency() {
        double applicationEfficiency = 0.0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(registrationDate);
        int daysToAdd = 20;
        calendar.add(Calendar.DAY_OF_MONTH, daysToAdd);
        Date newDate = calendar.getTime();
        long diffInMillies = Math.abs(applicationManagementDate.getTime() - newDate.getTime());
        long diffInDays = diffInMillies / (24 * 60 * 60 * 1000);
        applicationEfficiency = 1-(diffInDays/100);
        return applicationEfficiency;
    }

}
