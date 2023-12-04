package fr.efrei.repository;

import fr.efrei.domain.Customer;
import fr.efrei.domain.Subscription;
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
            Subscription subscription1 = (new Subscription.Builder())
                    .setName("Basic")
                    .setDuration("1 month")
                    .setPrice(50)
                    .setStartDate((new SimpleDateFormat("yyyy-MM-dd")).parse("2023-01-01"))
                    .setDescription("Standard package")
                    .setCustomer((Customer)null)
                    .setID_Subscription(1)
                    .build();
            Subscription subscription2 = (new Subscription.Builder())
                    .setName("Premium")
                    .setDuration("3 months")
                    .setPrice(120)
                    .setStartDate((new SimpleDateFormat("yyyy-MM-dd")).parse("2023-01-01"))
                    .setDescription("Includes access to classes")
                    .setCustomer((Customer)null)
                    .setID_Subscription(2)
                    .build();
            Subscription subscription3 = (new Subscription.Builder())
                    .setName("Gold")
                    .setDuration("6 months")
                    .setPrice(200)
                    .setStartDate((new SimpleDateFormat("yyyy-MM-dd")).parse("2023-01-01"))
                    .setDescription("VIP package")
                    .setCustomer((Customer)null)
                    .setID_Subscription(3)
                    .build();
            this.subscriptionArrayList.add(subscription1);
            this.subscriptionArrayList.add(subscription2);
            this.subscriptionArrayList.add(subscription3);
        } catch (ParseException var4) {
            var4.printStackTrace();
        }

    }
    public void addSubscription(Subscription subscription) {
        int ID_Subscription;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Subscription Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Duration");
        String duration= scanner.nextLine();
        System.out.print("Enter price: ");
        int price= scanner.nextInt();
        System.out.print("Enter Description");
        String description = scanner.nextLine();
        do {
            System.out.print("Enter ID_Subscription: ");
            ID_Subscription = scanner.nextInt();

            // Check if the ID_Subscription already exists
            if (isID_SubscriptionExists(ID_Subscription)) {
                System.out.println("ID_Subscription already exists. Please choose another one.");
            }
        } while (isID_SubscriptionExists(ID_Subscription));
        Subscription newSubscription = (new Subscription.Builder())
                .setName(name)
                .setDuration(duration)
                .setPrice(price)
                .setDescription(description)
                .setID_Subscription(ID_Subscription)
                .setCustomer((Customer)null)
                .build();
        subscriptionArrayList.add(newSubscription);
        newSubscription.printSubscriptionDetails();
    }
    private boolean isID_SubscriptionExists(int ID_Subscription) {
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
    public void displaySubscriptionDetails(Subscription subscription) {
        System.out.println(subscription.toString());
    }

    public void removeSubscription(Subscription subscription) {
        this.subscriptionArrayList.remove(subscription);
    }
}