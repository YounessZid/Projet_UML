package fr.efrei.domain;

import java.util.ArrayList;
import java.util.Date;

public class Discount extends Subscription {

    public Discount(String description, String duration, String name, int price, Date startDate, ArrayList<String> advantages, ArrayList<String> conditions, String monthCheckIn, Customer customer) {
        super(description, duration, name, price, startDate, advantages, conditions, monthCheckIn, customer);
    }

    @Override
    public int getPrice() {
        int originalPrice = super.getPrice();
        int discountPercentage = 0;

        if (getCustomer() != null) {
            int customerAge = getCustomer().getAge();
            if (customerAge < 18 || customerAge > 65) {
                discountPercentage = 10;
            }
        }

        double discountAmount = (originalPrice * discountPercentage) / 100.0;
        return originalPrice - (int) discountAmount;
    }
}