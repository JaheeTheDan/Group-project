package Files;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import OffenceInfo.*;
import Date.Date;
import Officer.JCFOfficers;
import Person.Driver;
import Ticket.Ticket;

public class DriverSavingAndRetrieval extends DataSavingAndRetrieval {

    public DriverSavingAndRetrieval() {
        super("Driver_files.txt");
    }

    public DriverSavingAndRetrieval(String filePath) {
        super(filePath);
    }

    public DriverSavingAndRetrieval(DriverSavingAndRetrieval obj) {
        super(obj);
    }


    @Override
    protected Object parseObject(String objectString) {
        OffenceInfoMap<String,OffenceInfo> infoMap = new OffenceInfoMap<String,OffenceInfo>("OffenceInfo.txt");

        String[] data = objectString.split(",");

        String fname = data[0];
        String lname = data[1];
        String trn = data[2];

        String dateStringArr[] = data[3].split("/");
        int day = Integer.parseInt(dateStringArr[0]);
        int month = Integer.parseInt(dateStringArr[1]);
        int year = Integer.parseInt(dateStringArr[2]);
        Date dateOfBirth = new Date(day, month, year);

        String address = data[4];
        String contactNumber = data[5];
        String parishIssuedIn = data[6];


        List<Ticket> ticketArray = new ArrayList<Ticket>();
        String[] ticketArrayStrings = data[7].split("\\|");
        for (String ticketString : ticketArrayStrings) {
            String[] ticketData = ticketString.split(";");
            int ticketNumber = Integer.parseInt(ticketData[0]);

            String[] tdate = ticketData[1].split("/");
            int tday = Integer.parseInt(tdate[0]);
            int tmonth = Integer.parseInt(tdate[1]);
            int tyear = Integer.parseInt(tdate[2]);
            Date issueDate = new Date(tday, tmonth,tyear) ;
            
            String parishTicketIssuseIn = ticketData[2];
            OffenceInfo offenceInfo = infoMap.get(ticketData[3]);
            boolean havePaid = Boolean.parseBoolean(ticketData[4]);
            int licensePlateNumber = Integer.parseInt(ticketData[5]);
            String driverFName = ticketData[6];
            String driverLName = ticketData[7];
            int driverTrn = Integer.parseInt(ticketData[8]);


            String officerFname = ticketData[9];
            String officerLname = ticketData[10];
            int officerBadgeNumber = Integer.parseInt(ticketData[11]);
            String officerPoliceStation = ticketData[12];
            JCFOfficers officerIssueTicket = new JCFOfficers(officerFname, officerLname, officerBadgeNumber, officerPoliceStation);

            Ticket ticket = new Ticket(ticketNumber, issueDate, parishTicketIssuseIn, offenceInfo, havePaid, licensePlateNumber, driverFName, driverLName, driverTrn, officerIssueTicket);
            ticketArray.add(ticket);
        }
        
        Driver driver = new Driver(fname, lname, trn, dateOfBirth, address, contactNumber, ticketArray, parishIssuedIn);
        return driver;
    }

    
    @Override
    protected String stringifyObject(Object obj) {
        String line = "";

        if (obj instanceof String) {
            line += obj.toString();
            return line;
        }

        Driver driver = (Driver) obj;
        line += driver.getFname() + ",";
        line += driver.getLname() + ",";
        line += driver.getTrn() + ",";
        line += driver.getDateOfBirth().getDay() + "/" + driver.getDateOfBirth().getMonth() + "/" + driver.getDateOfBirth().getYear() + ", ";
        line += driver.getAddress() + ",";
        line += driver.getContactNumber() + ",";
        line += driver.getParishIssuedIn() + ",";
        
        for (Ticket ticket : driver.getTicketArray()) {
            String ticketLine = "";
            ticketLine += ticket.getTicketNumber() + ";";
            ticketLine += ticket.getIssueDate() + ";";
            ticketLine += ticket.getParishTicketIssuseIn() + ";";
            ticketLine += ticket.getOffenceInfo().getCode() + ";";
            ticketLine += ticket.getHavePaid() + ";";
            ticketLine += ticket.getLicensePlateNumber() + ";";
            ticketLine += ticket.getDriverFName() + ";";
            ticketLine += ticket.getDriverLName() + ";";
            ticketLine += ticket.getDriverTrn() + ";";
            
            String officerIssueTicketString = "";
            JCFOfficers officerIssueTicket = ticket.getOfficerIssueTicket();
            officerIssueTicketString += officerIssueTicket.getFname() + ";";
            officerIssueTicketString += officerIssueTicket.getLname() + ";";
            officerIssueTicketString += officerIssueTicket.getBadgeNumber() + ";";
            officerIssueTicketString += officerIssueTicket.getPoliceStation()+ ";";

            ticketLine += officerIssueTicketString;
            line += ticketLine;
            line += "|";
        }
        return line;
    }


    /**
     * This function saves a given driver object to file.
     *
     * @param driver The driver object to be saved. It cannot be null.
     *
     * @throws IllegalArgumentException If the provided driver object is null.
     * @throws Exception                If any other error occurs during the saving
     *                                  process.
     *
     * @author Jaheem Shaw
     */
    public void saveData(Driver driver) {
        try {
            if (driver == null) {
                throw new IllegalArgumentException("Driver data cannot be null.");
            }
            super.saveData(driver);
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return;
        }
    }

    /**
     * Retrieves a driver object from the file based on the given index.
     *
     * @param index The index of the driver object to retrieve. The index is
     *              zero-based, meaning the first object in the file has an index of
     *              0.
     *              It cannot be negative.
     *
     * @return The driver object at the specified index. If the index is out of
     *         bounds, this method returns null.
     *
     * @throws IndexOutOfBoundsException If the specified index is out of bounds.
     * @throws IllegalArgumentException If the provided index is negative.
     * @throws Exception                If any other error occurs during the
     *                                  retrieval process.
     *
     * @author Jaheem Shaw
     */
    public Driver retrieveDataInIndex(int index) {
        return (Driver) super.retrieveDataInIndex(index);
    }

    /**
     * Updates a driver object in the file at the specified index.
     *
     * @param index The index of the driver object to update. The index is
     *              zero-based, meaning the first object in the file has an index of
     *              0.
     *              It cannot be negative.
     * @param driver The updated driver object to be saved. It cannot be null.
     *
     * @throws IndexOutOfBoundsException If the specified index is out of bounds.
     * @throws IllegalArgumentException If the provided index is negative or the
     *                                  driver object is null.
     * @throws Exception                If any other error occurs during the
     *                                  updating process.
     *
     * @author Jaheem Shaw
     */
    public void updateDataInIndex(int index, Driver driver) {
        try {
            if (driver == null) {
                throw new IllegalArgumentException("Driver data cannot be null.");
                
            }
            super.updateDataInIndex(index, driver);
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return;
        }
        
    }


    public Driver[] getAllData() {
        return Arrays.copyOf(super.getAllData(), numberOfLines, Driver[].class);
    }

    public static void main(String[] args) {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        DriverSavingAndRetrieval file = new DriverSavingAndRetrieval();

        Driver driver_1 = new Driver("a", "b", "123", new Date(), "qwerty", "876", new ArrayList<Ticket>(), "qertt");

        // System.out.println(driver_1);
        Ticket ticket_1 = new Ticket(
            12345678, 
            new Date(), 
            "zxcvbn", 
            new OffenceInfo(1, "qwert", 1), 
            false, 
            1234567, 
            "qwerty", 
            "adfgh", 
            1234567, 
            new JCFOfficers()
            );
        driver_1.getTicketArray().add(ticket_1);

        file.saveData(driver_1);

        Driver driver_2 = file.retrieveDataInIndex(0);
        System.out.println(driver_2);

        
    }

}
