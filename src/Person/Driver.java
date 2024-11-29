package Person;

import java.util.ArrayList;
import Date.Date;
import java.util.List;
import Ticket.Ticket;

public class Driver extends Person {
    private String parishIssuedIn;
    private List<Ticket> ticketArray;

    // Constructors
    public Driver() {
        super();
        this.ticketArray = new ArrayList<Ticket>();
        this.parishIssuedIn = " ";
    }
    // Person(String fname, String lname, String trn, Date dateOfBirth, String address, String contactNumber) {
    public Driver(String fname, String lname, String trn, Date dateOfBirth, 
        String address, String contactNumber, List<Ticket> ticketArray, String parishIssuedIn) {
        super(fname, lname, trn, dateOfBirth, address, contactNumber);
        this.ticketArray = ticketArray;
        this.parishIssuedIn = parishIssuedIn;
    }

    // Getters and Setters
    public List<Ticket> getTicketArray() {
        return ticketArray;
    }

    public void setTicketArray(List<Ticket> ticketArray) {
        this.ticketArray = ticketArray;
    }

    public String getParishIssuedIn() {
        return parishIssuedIn;
    }

    public void setParishIssuedIn(String parishIssuedIn) {
        this.parishIssuedIn = parishIssuedIn;
    }

    // Methods
    public void addTicketToArray(Ticket ticket) {
        ticketArray.add(ticket);
    }

    public void removeTicketFromArray(Ticket ticket) {
        ticketArray.remove(ticket);
    }

    @Override
    public String toString() {
        String output = super.toString();
        output += "Driver{" +
                "ticketArray=" + ticketArray +
                ", parishIssuedIn='" + parishIssuedIn + '\'' +
                "} ";
        return output;
    }

    
}






// public void viewTickets(TicketFilter filter) {
//     for (Ticket ticket : ticketArray) {
//         if (filter.apply(ticket)) {
//             System.out.println(ticket);
//         }
//     }
// }

// public boolean checkForWarrants() {
//     for (Ticket ticket : ticketArray) {
//         if (ticket.isWarrant()) {
//             return true;
//         }
//     }
//     return false;
// }

// public void payTicket(Ticket ticket) {
//     if (ticket.isPaid()) {
//         System.out.println("Ticket is already paid.");
//     } else {
//         ticket.setPaid(true);
//         System.out.println("Ticket paid successfully.");
//     }
// }

// // TicketFilter interface for filtering tickets
// interface TicketFilter {
//     boolean apply(Ticket ticket);
// }

// // Example TicketFilter implementations
// static class PaidTicketFilter implements TicketFilter {
//     @Override
//     public boolean apply(Ticket ticket) {
//         return ticket.isPaid();
//     }
// }

// static class OutstandingTicketFilter implements TicketFilter {
//     @Override
//     public boolean apply(Ticket ticket) {
//         return !ticket.isPaid();
//     }
// }

// static class WarrantTicketFilter implements TicketFilter {
//     @Override
//     public boolean apply(Ticket ticket) {
//         return ticket.isWarrant();
//     }
// }