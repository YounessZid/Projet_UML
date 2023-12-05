package fr.efrei.repository;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
import fr.efrei.factory.SubscriptionFactory;

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
        GymAdmin GymAdmin1 = GymAdminFactory.createGymAdmin("Charles", "Fazi", 4322);
        GymAdmin GymAdmin2 = GymAdminFactory.createGymAdmin("Louis", "Personnic", 1103);
        GymAdmin GymAdmin3 = GymAdminFactory.createGymAdmin("Youness", "Zidane", 1510);
        this.GymAdminArrayList.add(GymAdmin1);
        this.GymAdminArrayList.add(GymAdmin2);
        this.GymAdminArrayList.add(GymAdmin3);

    }
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void addSubscription() throws ParseException {
        CustomerRepository customerRepository = CustomerRepository.getRepository();
        Customer customer1 = customerRepository.findCustomerById(1);


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Subscription Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Duration: ");
        String duration= scanner.nextLine();
        System.out.print("Enter price: ");
        int price= scanner.nextInt();
        System.out.print("Enter Description: ");
        String description = scanner.nextLine();

        System.out.print("Enter ID_Subscription: ");
        int ID_Subscription = 0 ;
        SubscriptionRepository subscriptionRepository = SubscriptionRepository.getRepository();
        do {
            System.out.print("Enter ID_Subscription: ");
            ID_Subscription = scanner.nextInt();
            if (subscriptionRepository.isID_SubscriptionExists(ID_Subscription)) {
                System.out.println("ID_Subscription already exists. Please choose a different one.");
            }
        } while (subscriptionRepository.isID_SubscriptionExists(ID_Subscription));

        scanner.nextLine();
        Subscription subscription = SubscriptionFactory.createSubscription(name, duration, price, description, (new SimpleDateFormat("yyyy-MM-dd")).parse("2023-01-01"), customer1, ID_Subscription);
        SubscriptionRepository.getRepository().addSubscriptionCreated(subscription);



        System.out.println("Subscription added successfully.");

    }

    public void removeSubscription(Subscription subscription) {
        SubscriptionRepository.getRepository().removeSubscription(subscription);
        System.out.println("Subscription removed successfully.");
    }
    public boolean isGymAdmin(int adminID) {
        for (GymAdmin admin : GymAdminArrayList) {
            if (admin.getID_Admin() == adminID) {
                return true; // User is a GymAdmin
            }
        }
        return false; // User is not a GymAdmin
    }



}

