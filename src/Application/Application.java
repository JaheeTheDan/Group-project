package Application;

import Date.Date;

public class Application 
{
	private String applicantFName;
	private String applicantLName;
	private int applicantTRN;
	private Driver driver;
	private Date date;
	private String isApproved;
	private String reasonForDenial;
	
	//Default Constructor
	public Application()
	{
		applicantFName = "";
		applicantLName = "";
		applicantTRN = 0;
		driver = new Driver();
		date = new Date();
		isApproved = "";
		reasonForDenial = "";
	}
	
	//Primary Constructor
	public Application(String applicantFName, String applicantLName, int applicantTRN, Driver driver, Date date, String isApproved, String reasonForDenial)
	{
		this.applicantFName = applicantFName;
		this.applicantLName = applicantLName;
		this.applicantTRN = applicantTRN;
		this.driver = driver;
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

	public Driver getDriver() 
	{
		return driver;
	}

	public void setDriver(Driver driver) 
	{
		this.driver = driver;
	}

	public Date getDate() 
	{
		return date;
	}

	public void setDate(Date date) 
	{
		this.date = date;
	}

	public String isApproved() 
	{
		return isApproved;
	}

	public void setApproved(String isApproved) 
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
	public String ToString()
	{
		String output;
		
		output = "Applicant first name: " + applicantFName;
		output += "\nApplicant last name: " + applicantLName;
		output += "\nApplicant TRN: " + applicantTRN;
		output += "\nDriver: " + driver.getTicketArray() + driver.getParishIssuedIn();
		output += "\n Date: " + date.getDay() + "/" + date.getMonth() + "/" + date.getYear();
		output += "\n Applicant is approved?: " + isApproved;
		output += "\n Reason for denial: " + reasonForDenial;
		
		System.out.println(output);
		
		return output;
	}
	
	

}

