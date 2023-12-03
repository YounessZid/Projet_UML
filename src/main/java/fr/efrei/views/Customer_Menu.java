package fr.efrei.views;
import fr.efrei.Menu;
import fr.efrei.repository.CustomerRepository;
import fr.efrei.repository.SubscriptionRepository;

import java.util.Scanner;

public class Customer_Menu {
    public static void addCustomer(){
        CustomerRepository.getRepository().addCustomer();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println(" ===== Gym Subscription Menu =====");
            System.out.println(" 1. Register as a new customer :");
            System.out.println(" 2. Get a subscription :");
            System.out.println(" 3. Change your age in our database");
            System.out.println(" 4. Go to the main menu");
            System.out.println(" 5. Quit the gym");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // Call a method to view information
                    System.out.println("Register as a new customer ...");
                    CustomerRepository customerRepository = CustomerRepository.getRepository();
                    customerRepository.addCustomer();
                    System.out.printf(""+customerRepository.customerArrayList);
                    break;
                case 2:
                    // Call a method to add information
                    System.out.println("Check-in...");
                    break;
                case 3:
                    // Call a method to update information
                    System.out.println("Change the age...");
                    break;
                case 4:
                    // Call a method to delete information
                    System.out.println("Go to the main menu...");
                    Menu.main(args);
                    break;
                case 5:
                    // Exit the program
                    System.out.println("Quit the gym...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }

        scanner.close();
    }
}