package fr.efrei.views;
import java.util.*;
import fr.efrei.repository.SubscriptionRepository;

public class GymAdmin_menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while(!exit){
            System.out.println(" ===== Gym Admin Menu =====");
            System.out.println(" 1. Add a subscription :");
            System.out.println(" 2. Remove a subscription :");
            System.out.println(" 3. Go to the main menu");
            System.out.println(" 4. Quit the gym");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch(choice){
                case 1:
                    // Call a method to add information
                    System.out.println("Add a subscription...");

                    break;
                case 2:
                    // Call a method to remove information
                    System.out.println("Remove a subscription...");
                    System.out.println("Enter subscription ID to view details: ");
                    int subscriptionIdForDetails = scanner.nextInt();
                    SubscriptionRepository subscriptionRepository = SubscriptionRepository.getRepository();
                    subscriptionRepository.findSubscriptionById(subscriptionIdForDetails);
                    subscriptionRepository.displaySubscriptionDetails(subscriptionRepository.findSubscriptionById(subscriptionIdForDetails));

                    break;
                case 3:
                    // Go to the main menu
                    System.out.println("Go to the main menu...");
                    break;
                case 4:
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