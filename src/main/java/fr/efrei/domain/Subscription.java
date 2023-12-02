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

    private Subscription(Subscription.Builder builder){
        name = builder.name;
        duration = builder.duration;
        price = builder.price;
        startDate = builder.startDate;
        description = builder.description;
        customer = builder.customer;
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



    @Override
    public String toString() {
        return "Subscription{" +
                "description='" + description + '\'' +
                ", duration='" + duration + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", startDate=" + startDate +
                ", customer=" + customer +
                '}';
    }

    public static class Builder {
        private String name;
        private String duration;
        private int price;
        private Date startDate;
        private String description;
        private Customer customer;

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
