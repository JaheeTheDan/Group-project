package Application;

import Date.Date;

// TODO: Remembered to uncomment the Driver class
// TODO: And change applicant attributes to the class
// TODO: Add the applicate class
public class Application 
{
	private String applicantFName;
	private String applicantLName;
	private int applicantTRN;
	// private Driver driver;
	private Date date;
	private boolean isApproved;
	private String reasonForDenial;
	
	//Default Constructor
	public Application()
	{
		applicantFName = "";
		applicantLName = "";
		applicantTRN = 0;
		// driver = new Driver();
		date = new Date();
		isApproved = false;
		reasonForDenial = "";
	}
	
	//Primary Constructor
	public Application(String applicantFName, String applicantLName, int applicantTRN, 
	// Driver driver, 
	Date date, boolean isApproved, String reasonForDenial)
	{
		this.applicantFName = applicantFName;
		this.applicantLName = applicantLName;
		this.applicantTRN = applicantTRN;
		// this.driver = driver;
		this.date = date;
		this.isApproved = isApproved;
		this.reasonForDenial = reasonForDenial;
	}

	
	//Getters and Setters
	
	public String getApplicantFName() 
	{
		return applicantFName;
	}

	public void setApplicantFName(String applicantFName) 
	{
		this.applicantFName = applicantFName;
	}

	public String getApplicantLName() 
	{
		return applicantLName;
	}

	public void setApplicantLName(String applicantLName) 
	{
		this.applicantLName = applicantLName;
	}

	public int getApplicantTRN() 
	{
		return applicantTRN;
	}

	public void setApplicantTRN(int applicantTRN) 
	{
		this.applicantTRN = applicantTRN;
	}

	// public Driver getDriver() 
	// {
	// 	return driver;
	// }

	// public void setDriver(Driver driver) 
	// {
	// 	this.driver = driver;
	// }

	public Date getDate() 
	{
		return date;
	}

	public void setDate(Date date) 
	{
		this.date = date;
	}

	public boolean getIsApproved() 
	{
		return isApproved;
	}

	public void setIsApproved(boolean isApproved) 
	{
		this.isApproved = isApproved;
	}

	public String getReasonForDenial() 
	{
		return reasonForDenial;
	}

	public void setReasonForDenial(String reasonForDenial) 
	{
		this.reasonForDenial = reasonForDenial;
	}
	
	
	//ToString Display Method
	public String toString()
	{
		String output;
		
		output = "Applicant first name: " + applicantFName;
		output += "\nApplicant last name: " + applicantLName;
		output += "\nApplicant TRN: " + applicantTRN;
		// output += "\nDriver: " + driver.getTicketArray() + driver.getParishIssuedIn();
		output += "\nDate: " + date.getDay() + "/" + date.getMonth() + "/" + date.getYear();
		output += "\nApplicant is approved?: " + isApproved;
		output += "\nReason for denial: " + reasonForDenial;
		
		return output;
	}
	
	

}

