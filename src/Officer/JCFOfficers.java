package Officer;

import java.sql.Driver;
import java.util.Date;

import Ticket.Ticket;

public class JCFOfficers extends ParentOfficer {

	private int badgeNumber;
	private String policeStation;

	// Default Constructor
	public JCFOfficers() {
		super();
		badgeNumber = 0;
		policeStation = " ";

	}

	// Primary Constructor
	public JCFOfficers(String fname, String lname, int badgeNumber, String policeStation) {
		super(fname, lname);
		this.badgeNumber = badgeNumber;
		this.policeStation = policeStation;

	}

	// Copy Constructor
	public JCFOfficers(JCFOfficers JCFO) {
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

	public String toString() {
		String output = super.toString();
		output += "Police Badge Number : " + badgeNumber;
		output += "Policce Station     : " + policeStation;

		return output;
	}

	// TODO: Remember to finsh this method when you get the ticket and driver
	// classes
	public void addTicket(
			String ticketNumber,
			Date issueDate,
			String offenceCode,
			String offenceDescription,
			double fineAmount,
			String licensePlateNumber,
			String trn,
			String driverFullName,
			Date driverDOB,
			String driverAddress,
			String driverContact,
			Driver driver) {

		Ticket newTicket = new Ticket(
				ticketNumber,
				issueDate,
				offenceCode,
				offenceDescription,
				fineAmount,
				licensePlateNumber,
				trn,
				driverFullName,
				driverDOB,
				driverAddress,
				driverContact,
				badgeNumber,
				this.getFullName(),
				policeStation);

		driver.tickets.add(newTicket);
		System.out.println("New ticket added successfully:\n" + newTicket);
	}

	public void checkDriverStatus(String trn) {
        boolean hasOutstandingTickets = false;

        System.out.println("Driver Status for TRN: " + trn);
        for (Ticket ticket : tickets) {
            if (ticket.getTrn().equals(trn) && !ticket.isPaid()) {
                hasOutstandingTickets = true;
                System.out.println(ticket);
            }
        }

        if (!hasOutstandingTickets) {
            System.out.println("The driver has no outstanding tickets.");
        }
    }

}

