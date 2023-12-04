package fr.efrei.domain;
import java.util.*;
import java.util.Date;
import java.io.*;


public class Subscription {
    private String name;
    private String duration;
    private int price;
    private Date startDate;
    private String description;
    private Customer customer;

    private int minCheckIn = 5;
    private int ID_Subscription;

    public int getMinCheckIn() {
        return minCheckIn;
    }

    private Subscription(Subscription.Builder builder){
        name = builder.name;
        duration = builder.duration;
        price = builder.price;
        startDate = builder.startDate;
        description = builder.description;
        customer = builder.customer;
        ID_Subscription = builder.ID_Subscription;
    }


    public String getDescription() {
        return description;
    }

    public String getDuration() {
        return duration;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Date getStartDate() {return startDate;}

    public Customer getCustomer() {
        return customer;
    }

    public int getID_Subscription() {
        return ID_Subscription;
    }

    @Override
    public String toString() {
        return "Subscription :" +
                "\nName :'" + name + '\'' +
                "\nWhat you can expect :" + description + '\'' +
                "\nBeginning :" + startDate + '\'' +
                "\nDuration of the subscription :" + duration + '\'' +
                "\nPrice :" + price +
                "\nID of the Subscription :" + ID_Subscription +
                '}';
    }

    public static class Builder {
        private String name;
        private String duration;
        private int price;
        private Date startDate;
        private String description;
        private Customer customer;
        private int ID_Subscription;

        public Builder setID_Subscription(int ID_Subscription) {
            this.ID_Subscription = ID_Subscription;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setDuration(String duration) {
            this.duration = duration;
            return this;
        }
        public Builder setPrice(int price) {
            this.price = price;
            return this;
        }
        public Builder setStartDate(Date startDate) {
            this.startDate = startDate;
            return this;
        }
        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }
        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Subscription build(){
            return new Subscription(this);
        }
    }
}
