package Person;

import Date.Date;

public class Person {
    protected String fname;
    protected String lname;
    protected String trn;
    protected Date dateOfBirth;
    protected String address;
    protected String contactNumber;

    // Constructors
    public Person() {
        fname = " ";
        lname = " ";
        trn = " ";
        dateOfBirth = new Date();
        address = " ";
        contactNumber = " ";
    }


    public Person(String fname, String lname, String trn, Date dateOfBirth, String address, String contactNumber) {
    
        this.fname = fname;
        this.lname = lname;
        this.trn = trn;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    public Person(Person obj) {
        this.fname = obj.fname;
        this.lname = obj.lname;
        this.trn = obj.trn;
        this.dateOfBirth = obj.dateOfBirth;
        this.address = obj.address;
        this.contactNumber = obj.contactNumber;
    }

    

    // Getters and Setters
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

    public String getTrn() {
        return trn;
    }

    public void setTrn(String trn) {
        this.trn = trn;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String toString(){
        String output = "";
        output += "Name: " +fname+" "+lname+"\n";
        output += "Date: " + dateOfBirth +"\n";
        return output;
    }
    
}