package Ticket;

import Date.Date;
import OffenceInfo.*;
import Officer.JCFOfficers;

public class Ticket {
    private int ticketNumber;
    private Date issueDate;
    private String parishTicketIssuseIn;
    private OffenceInfo offenceInfo;
    private boolean havePaid;
    private int licensePlateNumber;
    private String driverFName;
    private String driverLName;
    private int driverTrn;
    private JCFOfficers officerIssueTicket;


    public Ticket(){
        ticketNumber = 0;
        issueDate = new Date();
        parishTicketIssuseIn = " ";
        offenceInfo = new OffenceInfo(0, " ", 0.0f);
        havePaid = false;
        licensePlateNumber = 0;
        driverFName = " ";
        driverLName = " ";
        driverTrn = 0;
        officerIssueTicket = new JCFOfficers();
    }

    public Ticket(int ticketNumber,Date issueDate, String parishTicketIssuseIn, OffenceInfo offenceInfo, boolean havePaid,int licensePlateNumber,String driverFName,String driverLName,int driverTrn, JCFOfficers officerIssueTicket){
        this.ticketNumber = ticketNumber;
        this.issueDate = issueDate;
        this.parishTicketIssuseIn = parishTicketIssuseIn;
        this.offenceInfo = offenceInfo;
        this.havePaid = havePaid;
        this.licensePlateNumber = licensePlateNumber;
        this.driverFName = driverFName;
        this.driverLName = driverLName;
        this.driverTrn = driverTrn;
        this.officerIssueTicket = officerIssueTicket;
    }

    public Ticket(Ticket obj){
        this.ticketNumber = obj.ticketNumber;
        this.issueDate = obj.issueDate;
        this.parishTicketIssuseIn = obj.parishTicketIssuseIn;
        this.offenceInfo = obj.offenceInfo;
        this.havePaid = obj.havePaid;
        this.licensePlateNumber = obj.licensePlateNumber;
        this.driverFName = obj.driverFName;
        this.driverLName = obj.driverLName;
        this.driverTrn = obj.driverTrn;
        this.officerIssueTicket = obj.officerIssueTicket;
    }

    public int getTicketNumber() {
        return this.ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Date getIssueDate() {
        return this.issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getParishTicketIssuseIn() {
        return this.parishTicketIssuseIn;
    }

    public void setParishTicketIssuseIn(String parishTicketIssuseIn) {
        this.parishTicketIssuseIn = parishTicketIssuseIn;
    }

    public OffenceInfo getOffenceInfo() {
        return this.offenceInfo;
    }

    public void setOffenceInfo(OffenceInfo offenceInfo) {
        this.offenceInfo = offenceInfo;
    }

    public boolean isHavePaid() {
        return this.havePaid;
    }

    public boolean getHavePaid() {
        return this.havePaid;
    }

    public void setHavePaid(boolean havePaid) {
        this.havePaid = havePaid;
    }

    public int getLicensePlateNumber() {
        return this.licensePlateNumber;
    }

    public void setLicensePlateNumber(int licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public String getDriverFName() {
        return this.driverFName;
    }

    public void setDriverFName(String driverFName) {
        this.driverFName = driverFName;
    }

    public String getDriverLName() {
        return this.driverLName;
    }

    public void setDriverLName(String driverLName) {
        this.driverLName = driverLName;
    }

    public int getDriverTrn() {
        return this.driverTrn;
    }

    public void setDriverTrn(int driverTrn) {
        this.driverTrn = driverTrn;
    }

    public JCFOfficers getOfficerIssueTicket() {
        return this.officerIssueTicket;
    }

    public void setOfficerIssueTicket(JCFOfficers officerIssueTicket) {
        this.officerIssueTicket = officerIssueTicket;
    }


    public String toString() {
        return "Ticket{" +
                "ticketNumber=" + ticketNumber +
                ", issueDate=" + issueDate +
                ", parishTicketIssuseIn='" + parishTicketIssuseIn + '\'' +
                ", offenceInfo=" + offenceInfo +
                ", havePaid=" + havePaid +
                ", licensePlateNumber=" + licensePlateNumber +
                ", driverFName='" + driverFName + '\'' +
                ", driverLName='" + driverLName + '\'' +
                ", driverTrn=" + driverTrn +
                ", officerIssueTicket=" + officerIssueTicket +
                '}';
    }
}
