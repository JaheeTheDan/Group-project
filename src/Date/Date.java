package Date;

public class Date {
    // Attributes
    private int day;
    private int month;
    private int year;

    // Constructor (optional, initializes to default values)
    public Date() {
        autoSetDate(); // Automatically sets a default date
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Getters
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    // Setters
    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // toString method to represent the date as a string
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }

    // autoSetDate method to set a default date (e.g., current date or any predefined date)
    public void autoSetDate() {
        // Example: setting a default date (1st January 2000)
        this.day = 1;
        this.month = 1;
        this.year = 2000;
    }

    // Main method (optional, for testing purposes)
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("Default Date: " + date);

        // Setting a custom date
        date.setDay(15);
        date.setMonth(11);
        date.setYear(2024);
        System.out.println("Custom Date: " + date);

        // Getting individual attributes
        System.out.println("Day: " + date.getDay());
        System.out.println("Month: " + date.getMonth());
        System.out.println("Year: " + date.getYear());
    }
}
