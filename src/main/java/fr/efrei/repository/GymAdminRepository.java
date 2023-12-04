package fr.efrei.repository;

import fr.efrei.domain.Customer;
import fr.efrei.factory.CustomerFactory;
import fr.efrei.domain.Members;
import fr.efrei.domain.Subscription;
import fr.efrei.factory.MembersFactory;
import fr.efrei.domain.GymAdmin;
import fr.efrei.factory.GymAdminFactory;
import fr.efrei.repository.ISubscriptionRepository;
import fr.efrei.repository.SubscriptionRepository;
import fr.efrei.repository.CustomerRepository;
import fr.efrei.repository.MembersRepository;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class GymAdminRepository {
    private List<GymAdmin> GymAdminArrayList = new ArrayList();

    private static GymAdminRepository instance = null;

    private GymAdminRepository() {
    }

    public static GymAdminRepository getRepository() {
        if (instance == null) {
            instance = new GymAdminRepository();
        }

        return instance;
    }

    public List<GymAdmin> getGymAdminArrayList() {
        return this.GymAdminArrayList;
    }

    public void BaseGymAdmins() {
        GymAdmin GymAdmin1 = (new GymAdmin.Builder())
                .setfirstName("Charles")
                .setlastName("Fazi")
                .setID_Admin(4322)
                .build();
        GymAdmin GymAdmin2 = (new GymAdmin.Builder())
                .setfirstName("Louis")
                .setlastName("Personnic")
                .setID_Admin(1103)
                .build();
        GymAdmin GymAdmin3 = (new GymAdmin.Builder())
                .setfirstName("Youness")
                .setlastName("Zidane")
                .setID_Admin(1510)
                .build();
        this.GymAdminArrayList.add(GymAdmin1);
        this.GymAdminArrayList.add(GymAdmin2);
        this.GymAdminArrayList.add(GymAdmin3);

    }

    public void addSubscription(Subscription subscription) {
        SubscriptionRepository.getRepository().getSubscriptionArrayList().add(subscription);
        System.out.println("Subscription added successfully.");
    }

    public void removeSubscription(Subscription subscription) {
        SubscriptionRepository.getRepository().removeSubscription(subscription);
        System.out.println("Subscription removed successfully.");
    }


}
