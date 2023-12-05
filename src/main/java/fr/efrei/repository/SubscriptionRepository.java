//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package fr.efrei.repository;

import fr.efrei.domain.Customer;
import fr.efrei.domain.Subscription;
import fr.efrei.factory.SubscriptionFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubscriptionRepository {
    private List<Subscription> subscriptionArrayList = new ArrayList();
    private static SubscriptionRepository instance = null;

    private SubscriptionRepository() {
    }

    public static SubscriptionRepository getRepository() {
        if (instance == null) {
            instance = new SubscriptionRepository();
        }

        return instance;
    }

    public List<Subscription> getSubscriptionArrayList() {
        return this.subscriptionArrayList;
    }
    public void BaseSubscriptions() {
        try {
            CustomerRepository customerRepository = CustomerRepository.getRepository();
            Customer customer1 = customerRepository.findCustomerById(1);
            Subscription subscription1 = SubscriptionFactory.createSubscription("Basic", "1 month", 50, "Standard package", (new SimpleDateFormat("yyyy-MM-dd")).parse("2023-01-01"), customer1, 1);
            Subscription subscription2 = SubscriptionFactory.createSubscription("Premium", "3 months", 120, "Includes access to classes", (new SimpleDateFormat("yyyy-MM-dd")).parse("2023-01-01"), customer1, 2);
            Subscription subscription3 = SubscriptionFactory.createSubscription("Gold", "6 months", 200, "VIP package", (new SimpleDateFormat("yyyy-MM-dd")).parse("2023-01-01"), customer1, 3);

            this.subscriptionArrayList.add(subscription1);
            this.subscriptionArrayList.add(subscription2);
            this.subscriptionArrayList.add(subscription3);
        } catch (ParseException var4) {
            System.out.println("Error parsing date: " + var4.getMessage());
            var4.printStackTrace();
        }
    }


    //Only for gym admin use
    public void addSubscriptionCreated(Subscription subscription) {
        this.subscriptionArrayList.add(subscription);
    }

    public boolean isID_SubscriptionExists(int ID_Subscription) {
        List<Subscription> subscriptions = SubscriptionRepository.getRepository().getSubscriptionArrayList();
        for (Subscription subscription : subscriptions) {
            if (subscription.getID_Subscription() == ID_Subscription) {
                return true; // ID_Subscription already exists
            }
        }
        return false; // ID_Subscription does not exist
    }
    public Subscription findSubscriptionById(int subscriptionId) {
        for(int i = 0; i < this.subscriptionArrayList.size(); ++i) {
            Subscription subscription = (Subscription)this.subscriptionArrayList.get(i);
            if (subscription.getID_Subscription() == subscriptionId) {
                return subscription;
            }
        }

        return null;
    }
    //displays one subscription
    public void displaySubscriptionDetails(Subscription subscription) {

        System.out.println(subscription.toString());
    }
    //displays all subscriptions
    public void displaySubscriptions() {
        List<Subscription> subscriptions = SubscriptionRepository.getRepository().getSubscriptionArrayList();

        for (int i = 0; i < subscriptions.size(); ++i) {
            Subscription subscription = subscriptions.get(i);

            if (subscription != null) {
                System.out.println(i + 1 + ". " + subscription.toString());
            } else {
                System.out.println(i + 1 + ". [Invalid Subscription - null]");
                System.out.println("Subscription at index " + i + " is null");
                System.out.println("Size of subscriptions list: " + subscriptions.size());
                System.out.println("Content of subscriptions list: " + subscriptions);
            }
        }
    }

    public void seeAllSubscriptions() {
        List<Subscription> subscriptions = SubscriptionRepository.getRepository().getSubscriptionArrayList();

        for (int i = 0; i < subscriptions.size(); ++i) {
            Subscription subscription = subscriptions.get(i);

            if (subscription != null) {
                System.out.println(i + 1 + ". " + subscription.toString());
            } else {
                System.out.println(i + 1 + ". [Invalid Subscription - null]");
                System.out.println("Subscription at index " + i + " is null");
                System.out.println("Size of subscriptions list: " + subscriptions.size());
                System.out.println("Content of subscriptions list: " + subscriptions);
            }
        }
    }



    public void removeSubscription(Subscription subscription) {
        this.subscriptionArrayList.remove(subscription);
    }
}
