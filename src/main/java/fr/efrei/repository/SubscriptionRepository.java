//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package fr.efrei.repository;

import fr.efrei.domain.Customer;
import fr.efrei.domain.Subscription;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

    public void addSubscriptions() {
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


    public void removeSubscription(Subscription subscription) {
        this.subscriptionArrayList.remove(subscription);
    }
}
