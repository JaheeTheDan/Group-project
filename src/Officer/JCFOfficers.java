package Officer;

public class JCFOfficers extends ParentOfficer
{
	
	private int badgeNumber;
	private String policeStation;
	
	
	
	//Default Constructor
	public JCFOfficers()
	{
		super();
		badgeNumber = 0;
		policeStation = " ";
		
	}
	
	
	
	//Primary Constructor
	
	public JCFOfficers(String fname, String lname, int badgeNumber, String policeStation)
	{
		super( fname, lname);
		this.badgeNumber = badgeNumber;
		this.policeStation = policeStation;
		
	}
	
	
	
	
	//Copy Constructor
	
	public JCFOfficers(JCFOfficers JCFO )
	{
		super(JCFO);
		this.badgeNumber = JCFO.badgeNumber;
		this.policeStation = JCFO.policeStation;
		
	}

	// Setters & Getters

	public int getBadgeNumber() {
		return badgeNumber;
	}



	public void setBadgeNumber(int badgeNumber) {
		this.badgeNumber = badgeNumber;
	}



	public String getPoliceStation() {
		return policeStation;
	}



	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}
	
	
	
	
	
	public String toString()
	{
		String output;
		 super.toString();
		 output = "Police Badge Number : " + badgeNumber;
		 output = "Policce Station     : " + policeStation;
		
		return output;
	}
	
	
	

	
}
