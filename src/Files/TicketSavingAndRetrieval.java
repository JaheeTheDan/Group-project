package Files;

import java.io.IOException;
import java.util.Arrays;

import Date.Date;
import OffenceInfo.OffenceInfo;
import OffenceInfo.OffenceInfoMap;
import Officer.JCFOfficers;
import Ticket.Ticket;

public class TicketSavingAndRetrieval extends DataSavingAndRetrieval{

    public TicketSavingAndRetrieval() {
        super("Tickets_file.txt");
    }

    public TicketSavingAndRetrieval(String filePath) {
        super(filePath);
    }

    public TicketSavingAndRetrieval(TicketSavingAndRetrieval obj) {
        super(obj);
    }


    @Override
    protected Object parseObject(String objectString) {
        OffenceInfoMap<String,OffenceInfo> infoMap = new OffenceInfoMap<String,OffenceInfo>();
        String[] data = objectString.split(",");
        
        int ticketNumber = Integer.parseInt(data[0]);

        String[] tdate = data[1].split("/");
        int tday = Integer.parseInt(tdate[0]);
        int tmonth = Integer.parseInt(tdate[1]);
        int tyear = Integer.parseInt(tdate[2]);
        Date issueDate = new Date(tday, tmonth,tyear) ;
        
        String parishTicketIssuseIn = data[2];
        OffenceInfo offenceInfo = infoMap.get(data[3]);
        boolean havePaid = Boolean.parseBoolean(data[4]);
        int licensePlateNumber = Integer.parseInt(data[5]);
        String driverFName = data[6];
        String driverLName = data[7];
        int driverTrn = Integer.parseInt(data[8]);


        String officerFname = data[9];
        String officerLname = data[10];
        int officerBadgeNumber = Integer.parseInt(data[11]);
        String officerPoliceStation = data[12];
        JCFOfficers officerIssueTicket = new JCFOfficers(officerFname, officerLname, officerBadgeNumber, officerPoliceStation);

        Ticket ticket = new Ticket(ticketNumber, issueDate, parishTicketIssuseIn, offenceInfo, havePaid, licensePlateNumber, driverFName, driverLName, driverTrn, officerIssueTicket);

        return ticket;
    }

    
    @Override
    protected String stringifyObject(Object obj) {
        String line = "";
        if (obj instanceof String) {
            line += obj.toString();
            return line;
        }

        Ticket ticket = (Ticket) obj;
        line += ticket.getTicketNumber() + ",";
        line += ticket.getIssueDate() + ",";
        line += ticket.getParishTicketIssuseIn() + ",";
        line += ticket.getOffenceInfo().getCode() + ",";
        line += ticket.getHavePaid() + ",";
        line += ticket.getLicensePlateNumber() + ",";
        line += ticket.getDriverFName() + ",";
        line += ticket.getDriverLName() + ",";
        line += ticket.getDriverTrn() + ",";
        
        String officerIssueTicketString = "";
        JCFOfficers officerIssueTicket = ticket.getOfficerIssueTicket();
        officerIssueTicketString += officerIssueTicket.getFname() + ",";
        officerIssueTicketString += officerIssueTicket.getLname() + ",";
        officerIssueTicketString += officerIssueTicket.getBadgeNumber() + ",";
        officerIssueTicketString += officerIssueTicket.getPoliceStation()+ ",";

        line += officerIssueTicketString;

        return line;
    }


    /**
     * Saves a ticket object to the file.
     *
     * @param ticket The ticket object to be saved. It cannot be null.
     * @throws IllegalArgumentException If the ticket object is null.
     * @throws Exception If an error occurs while saving the ticket data.
     * @author Jaheem Shaw
     */
    public void saveData(Ticket ticket) {
        try {
            if (ticket == null) {
                throw new IllegalArgumentException("Ticket data cannot be null.");
            }
            super.saveData(ticket);
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return;
        }
    }


    

    /**
     * Retrieves a ticket object from the file based on the given index.
     *
     * @param index The index of the ticket object to retrieve. The index is zero-based.
     *              It must be a non-negative integer and less than the total number of ticket objects in the file.
     * @return The ticket object at the specified index. If the index is out of range,
     *         this method returns null.
     * @throws Exception If an error occurs while reading the file or parsing the ticket data.
     * @throws IndexOutOfBoundsException If the specified index is out of bounds.
     *
     * @author Jaheem Shaw
     */
    public Ticket retrieveDataInIndex(int index) {
        return (Ticket) super.retrieveDataInIndex(index);
    }

    
    /**
     * Updates a ticket object in the file at the specified index.
     *
     * @param index The index of the ticket object to update. The index is zero-based.
     *              It must be a non-negative integer and less than the total number of ticket objects in the file.
     * @param ticket The updated ticket object. It cannot be null.
     *
     * @throws IllegalArgumentException If the ticket object is null.
     * @throws Exception If an error occurs while updating the ticket data.
     * @throws IndexOutOfBoundsException If the specified index is out of bounds.
     *
     * @author Jaheem Shaw
     */
    public void updateDataInIndex(int index, Ticket ticket) {
        try {
            if (ticket == null) {
                throw new IllegalArgumentException("Ticket data cannot be null.");
            }
            super.updateDataInIndex(index, ticket);
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return;
        }
    }


    /**
     * Retrieves all ticket data from the file and returns them as an array of Ticket objects.
     *
     * @return An array of Ticket objects containing all the ticket data from the file.
     *         If there are no ticket data in the file, this method returns an empty array.
     *
     * @throws Exception If an error occurs while reading the file or parsing the ticket data.
     *
     * @author Jaheem Shaw
     */
    public Ticket[] getAllData() {
        return Arrays.copyOf(super.getAllData(), numberOfLines, Ticket[].class);
    }



    public static void main(String[] args) {
         try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        TicketSavingAndRetrieval file = new TicketSavingAndRetrieval();

        OffenceInfoMap<String, OffenceInfo> infoMap = new OffenceInfoMap<String, OffenceInfo>();


        // Creating a ticket
        Ticket ticket = new Ticket(12345, new Date(), "qwer", infoMap.get("1"), false, 123456, "qwrt", "qert", 123456, new JCFOfficers());

        file.saveData(ticket);

        System.out.println(file.retrieveDataInIndex(0));

    }

}
