package fr.efrei.views;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import fr.efrei.Menu;
import fr.efrei.domain.Customer;
import fr.efrei.domain.Subscription;
import fr.efrei.factory.SubscriptionFactory;
import fr.efrei.repository.GymAdminRepository;
import fr.efrei.repository.SubscriptionRepository;
import fr.efrei.repository.CustomerRepository;


public class GymAdminMenu {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while(!exit){
            System.out.println(" ===== Gym Admin Menu =====");
            System.out.println(" 1. Add a subscription :");
            System.out.println(" 2. Remove a subscription :");
            System.out.println(" 3. Add a customer :");
            System.out.println(" 4. Go to the main menu");
            System.out.println(" 5. Quit the gym");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch(choice){
                case 1:
                    // Call a method to add information
                    System.out.println("Add a subscription...");
                    GymAdminRepository gymAdminRepository = GymAdminRepository.getRepository();
                    gymAdminRepository.addSubscription();
                    

                    break;
                case 2:
                    // Call a method to remove information
                    System.out.println("Remove a subscription...");
                    System.out.println("Enter subscription ID to view details: ");
                    int subscriptionIdForDetails = scanner.nextInt();
                    SubscriptionRepository subscriptionRepository = SubscriptionRepository.getRepository();
                    subscriptionRepository.findSubscriptionById(subscriptionIdForDetails);
                    subscriptionRepository.displaySubscriptionDetails(subscriptionRepository.findSubscriptionById(subscriptionIdForDetails));
                    subscriptionRepository.removeSubscription(subscriptionRepository.findSubscriptionById(subscriptionIdForDetails));

                    break;

                case 3:
                    // Call a method to add information
                    System.out.println("Add a customer...");
                    CustomerRepository customerRepository = CustomerRepository.getRepository();
                    customerRepository.addCustomer();
                    break;

                case 4:
                    // Go to the main menu
                    System.out.println("Go to the main menu...");
                    Menu.main(args);
                    break;
                case 5:
                    // Quit the gym
                    System.out.println("Quit the gym...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}
