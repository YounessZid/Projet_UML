package fr.efrei.repository;
import fr.efrei.domain.Subscription;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionRepository {
    private List<Subscription> repository = new ArrayList<>();
    private static SubscriptionRepository instance = null;
    private SubscriptionRepository(){}
    public static SubscriptionRepository getRepository(){
        if(instance == null){
            instance = new SubscriptionRepository();
        }
        return instance;
    }
    //CRUDE OPERATION :
    public void addSubscription(Subscription subscription){
        repository.add(subscription);
    }
    public void removeSubscription(Subscription subscription){
        repository.remove(subscription);
    }
}
