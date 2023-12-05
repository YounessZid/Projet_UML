package fr.efrei.views;
import fr.efrei.Menu;
import fr.efrei.domain.Subscription;
import fr.efrei.factory.CustomerFactory;
import fr.efrei.factory.SubscriptionFactory;
import fr.efrei.repository.CustomerRepository;
import fr.efrei.repository.SubscriptionRepository;
import fr.efrei.domain.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Customer_Menu {
    public static void addCustomer(){
        CustomerRepository.getRepository().addCustomer();
    }

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        CustomerRepository customerRepository3 = CustomerRepository.getRepository();
        Customer customer1 = CustomerFactory.createCustomer("John", "Doe", 25, 1);
        CustomerRepository.customerArrayList.add(customer1);
        SubscriptionRepository subscriptionRepository = SubscriptionRepository.getRepository();
        subscriptionRepository.BaseSubscriptions();




        while (!exit) {
            System.out.println(" ===== Gym Subscription Menu =====");
            System.out.println(" 1. Register as a new customer :");
            System.out.println(" 2. Get a subscription :");
            System.out.println(" 3. Change your age in our database");
            System.out.println(" 4. Customers details :");
            System.out.println(" 5. Members menu");
            System.out.println(" 6. Go to the main menu");
            System.out.println(" 7. Quit the gym");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Call a method to view information
                    System.out.println("Register as a new customer...");
                    CustomerRepository customerRepository = CustomerRepository.getRepository();
                    customerRepository.addCustomer();
                    break;
                case 2:
                    // Call a method to add information
                    System.out.println("Subscribe to a subscription...");
                    CustomerRepository customerRepository1 = CustomerRepository.getRepository();
                    customerRepository1.subscribe();

                    break;
                case 3:
                    // Call a method to update information
                    System.out.println("Change the age...");
                    CustomerRepository customerRepository2 = CustomerRepository.getRepository();
                    customerRepository2.updateCustomerAge();
                    break;
                case 4:
                    System.out.println("Customers details...");
                    System.out.println("Enter customer ID to view details: ");
                    int customerIdForDetails1 = scanner.nextInt();
                    CustomerRepository customerRepository5 = CustomerRepository.getRepository();
                    Customer customerForDetails1 = customerRepository5.findCustomerById(customerIdForDetails1);
                    if (customerForDetails1 != null) {
                        customerRepository3.displayCustomerDetails(customerForDetails1);
                    } else {
                        System.out.println("Customer with ID " + customerIdForDetails1 + " not found.");
                    }
                    break;

                case 5:

                    System.out.println("Enter the members menu...");
                    Members_Menu.main(args);
                    break;
                case 6:

                    System.out.println("Go to the main menu...");
                    Menu.main(args);
                    break;
                case 7:
                    // Exit the program
                    System.out.println("Quit the gym...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }

        scanner.close();
    }
}
