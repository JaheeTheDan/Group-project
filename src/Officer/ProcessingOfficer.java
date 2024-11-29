package Officer;

import java.util.Scanner;
import Files.*;

public class ProcessingOfficer extends ParentOfficer {

	// Methods
	// addNewDriver
	// updateDriverInfo
	// viewDriver
	// viewAll
	// deleteDriver

	// Methods for ProcessingOfficer class

	// addNewDriver: This method will be responsible for adding a new driver to the
	// system.
	// It will take necessary parameters such as driver's personal information,
	// license details, and any other relevant data.
public void addNewDriver(String name, String address, String licenseNumber /* other parameters */) {
	
		Scanner inputScanner = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter Driver TRN: ");
        String userName = inputScanner.nextLine();  // Read user input
        
		
		System.out.println("Username is: " + userName);  // Output user input
        inputScanner.close();
    }
	



	// updateDriverInfo: This method will allow updating existing driver's
	// information.
	// It will take the driver's ID or license number as a parameter and the updated
	// details.
public void updateDriverInfo(String driverId, String newName, String newAddress /* other updated parameters */) {
	// Implementation goes here
}

	// viewDriver: This method will retrieve and display the information of a
	// specific driver.
	// It will take the driver's ID or license number as a parameter.
	public void viewDriver(String driverId) {
		// Implementation goes here
	}

	// viewAll: This method will retrieve and display all the driver's information.
	// It may not take any parameters, or it could take pagination parameters if the
	// system has a large number of drivers.
	public void viewAll(/* pagination parameters if needed */) {
		// Implementation goes here
	}

	// deleteDriver: This method will remove a driver from the system.
	// It will take the driver's ID or license number as a parameter.
	public void deleteDriver(String driverId) {
		// Implementation goes here
	}

}
