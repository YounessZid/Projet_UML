package fr.efrei.domain;
import java.util.*;
import java.util.Date;
import java.io.*;


public class Subscription {
    private String description, duration, name;
    private int price;
    private Date startDate;
    private ArrayList<String> advantages;
    private ArrayList<String> conditions;
    private String monthCheckIn;
    private Customer customer;

    public Subscription(String description, String duration, String name, int price, Date startDate, ArrayList<String> advantages, ArrayList<String> conditions, String monthCheckIn, Customer customer) {
        this.description = description;
        this.duration = duration;
        this.name = name;
        this.price = price;
        this.startDate = startDate;
        this.advantages = advantages;
        this.conditions = conditions;
        this.monthCheckIn = monthCheckIn;
        this.customer = customer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public ArrayList<String> getAdvantages() {
        return advantages;
    }

    public void setAdvantages(ArrayList<String> advantages) {
        this.advantages = advantages;
    }

    public ArrayList<String> getConditions() {
        return conditions;
    }

    public void setConditions(ArrayList<String> conditions) {
        this.conditions = conditions;
    }

    public String getMonthCheckIn() {
        return monthCheckIn;
    }

    public void setMonthCheckIn(String monthCheckIn) {
        this.monthCheckIn = monthCheckIn;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "description='" + description + '\'' +
                ", duration='" + duration + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", startDate=" + startDate +
                ", advantages=" + advantages +
                ", conditions=" + conditions +
                ", monthCheckIn='" + monthCheckIn + '\'' +
                ", customer=" + customer +
                '}';
    }
}
