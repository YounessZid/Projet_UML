package fr.efrei.domain;


import java.util.Date;

public class MonthCheckIn {
    private Date dateOfCheckIn;
    private int numberOfCheckIn;

    public MonthCheckIn(Date dateOfCheckIn, int numberOfCheckIn) {
        this.dateOfCheckIn = dateOfCheckIn;
        this.numberOfCheckIn = numberOfCheckIn;
    }

}
