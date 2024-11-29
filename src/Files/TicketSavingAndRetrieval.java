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
        OffenceInfoMap<String,OffenceInfo> infoMap = new OffenceInfoMap<String,OffenceInfo>("OffenceInfo.txt");
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

    
    public Ticket retrieveDataInIndex(int index) {
        return (Ticket) super.retrieveDataInIndex(index);
    }

    
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

        OffenceInfoMap<String, OffenceInfo> infoMap = new OffenceInfoMap<String, OffenceInfo>("OffenceInfo.txt");


        // Creating a ticket
        Ticket ticket = new Ticket(12345, new Date(), "qwer", infoMap.get("1"), false, 123456, "qwrt", "qert", 123456, new JCFOfficers());

        file.saveData(ticket);

        System.out.println(file.retrieveDataInIndex(0));

    }

}
