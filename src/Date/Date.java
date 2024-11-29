package Date;

import java.time.*;

public class Date {
    private int day;
    private int month;
    private int year;

    // Default Constructor
    public Date() {
        autoSetDate(); // Automatically sets a default date
    }

    // Primary Constructor
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Getters and Setters
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Display ToString Method
    public String toString() {
        String output;
        output = day + "/" + month + "/" + year;
        return output;
    }

    public void autoSetDate() {
        LocalDate currentDate = LocalDate.now();
        this.day = currentDate.getDayOfMonth();
        this.month = currentDate.getMonthValue();
        this.year = currentDate.getYear();

    }

}