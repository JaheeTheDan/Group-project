package Files;

import java.io.IOException;
import java.util.Arrays;

import Application.Application;
import Date.Date;

public class ApplicationSavingAndRetrieval extends DataSavingAndRetrieval {

    public ApplicationSavingAndRetrieval() {
        super("Application_files.txt");
    }

    public ApplicationSavingAndRetrieval(String filePath) {
        super(filePath);
    }

    public ApplicationSavingAndRetrieval(ApplicationSavingAndRetrieval obj) {
        super(obj);
    }


    @Override
    protected Object parseObject(String objectString) {
        String[] data = objectString.split(",");

        String applicantFName = data[0];

        String applicantLName = data[1];

        int applicantTRN = Integer.parseInt(data[2]);

        // Driver driver;

        String dateStringArr[] = data[3].split("/");
        int day = Integer.parseInt(dateStringArr[0]);
        int month = Integer.parseInt(dateStringArr[1]);
        int year = Integer.parseInt(dateStringArr[2]);
        Date date = new Date(day, month, year);

        Boolean isApproved = Boolean.parseBoolean(data[4]);

        String reasonForDenial = data[5];

        Application application = new Application(
                applicantFName,
                applicantLName,
                applicantTRN,
                date,
                isApproved,
                reasonForDenial);
        return application;
    }

    @Override
    protected String stringifyObject(Object obj) {
        String line = "";
        if (obj instanceof String) {
            line += obj.toString();
            return line;
        }
        
        Application application = (Application) obj;
        line += application.getApplicantFName() + ",";
        line += application.getApplicantLName() + ",";
        line += application.getApplicantTRN() + ",";
        line += application.getDate().toString() + ",";
        line += application.getIsApproved() + ",";
        line += application.getReasonForDenial()+",";
        
        return line;
    }
    
    /**
     * Saves the given application data to the file.
     *
     * @param application The application data to be saved. This object must not be
     *                    null.
     *                    The application data will be appended to the end of the
     *                    file.
     *                    The application data will be written in the format defined
     *                    by the
     *                    {@link #stringifyObject(Object)} method.
     *
     * @throws IOException If an I/O error occurs while writing to the file.
     * @author Jaheem Shaw
     */
    public void saveData(Application application) {
        try {
            if (application == null) {
                throw new IllegalArgumentException("Application data cannot be null.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return;
        }
        super.saveData(application);
    }

    /**
     * Retrieves the data at the specified index from the file.
     *
     * @param index The index of the data to retrieve. The index is 0-based, meaning
     *              the first data is at index 0.
     * @return The data at the specified index, or null if the index is out of
     *         range.
     *         In this case, the data is casted to an {@link Application} object.
     * 
     * @throws IndexOutOfBoundsException If the specified index is out of bounds.
     * @throws IOException If an I/O error occurs while reading the file.
     * @author Jaheem Shaw
     */
    public Application retrieveDataInIndex(int index) {
        return (Application) super.retrieveDataInIndex(index);
    }

    /**
     * Updates the data at the specified index in the file with the given object.
     *
     * @param index The index of the data to update. The index is 0-based, meaning
     *              the first data is at index 0.
     *              If the specified index is out of bounds, an
     *              {@link IndexOutOfBoundsException}
     *              is thrown.
     * @param obj   The new data to replace the existing data at the specified
     *              index.
     *              This object must not be null.
     *
     * @author Jaheem Shaw
     */
    public void updateDataInIndex(int index, Application application) {
        try {
            if (application == null) {
                throw new IllegalArgumentException("Application data cannot be null.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return;
        }
        super.updateDataInIndex(index, application);
    }

    /**
     * Retrieves all the application data from the file.
     *
     * @return An array of {@link Application} objects containing all the data from
     *         the file.
     *         If there are no data in the file, an empty array is returned.
     *         The returned array is a copy of the internal data, so any
     *         modifications to the array
     *         will not affect the internal data.
     *
     * @author Jaheem Shaw
     */
    public Application[] getAllData() {
        return Arrays.copyOf(super.getAllData(), numberOfLines, Application[].class);
    }

    public static void main(String[] args) {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        ApplicationSavingAndRetrieval file = new ApplicationSavingAndRetrieval();

        // Creating an application
        Application application = new Application("John", "Doe", 123456789, new Date(12, 12, 2021), true,
                "No reason provided");

        // Saving the application
        file.saveData(application);

        // Retrieving the application
        Application retrievedApplication = file.retrieveDataInIndex(0);

        System.out.println(retrievedApplication+ "\n----------");

        // Updating the application
        // retrievedApplication.setIsApproved(false);
        // retrievedApplication.setReasonForDenial("Changed reason");
        // file.updateDataInIndex(0, retrievedApplication);

        // Application apps[] = file.getAllData();
        // for (Application app : apps) {
        //     System.out.println(app + "\n");
        // }

    }

}
