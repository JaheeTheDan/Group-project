package Officer;

public class ParentOfficer
{
	protected String fname;
	protected String lname;
	
	
	
	//Default Constructor
	public ParentOfficer()
	{
		fname = " ";
		lname = " ";
		
	}
	
	
	//Primary Constructor
	public ParentOfficer (String fname, String lname)
	{
		this.fname = fname;
		this.lname = lname;
	
	}
	
	
	//Copy Constructor
	public ParentOfficer(ParentOfficer po)
	{		
		this.fname = po.fname;
		this.lname = po.lname;
		
	}

	// Getters & Setters
	
	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}
	
	
	//Display

	
	public String ToString()
	{
		String output;
		
		output = "Public Officers First: " + fname;
		output += "Public Officers last: " + lname;
		
		return output;
		
		
	}
	
	

}
