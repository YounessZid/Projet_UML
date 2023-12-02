package fr.efrei.factory;
import fr.efrei.domain.Subscription;
import fr.efrei.domain.Customer;

import java.util.Date;

public class SubscriptionFactory {

    public static Subscription getSubscription(String name, String duration, int price, String description, Date startDate, Customer customer){
        if (name == null || duration == null || price == 0 || description == null || startDate == null || customer == null)
            return null;
        return new Subscription.Builder()
                .setName(name)
                .setDuration(duration)
                .setPrice(price)
                .setDescription(description)
                .setStartDate(startDate)
                .setCustomer(customer)
                .build();
    }

}
