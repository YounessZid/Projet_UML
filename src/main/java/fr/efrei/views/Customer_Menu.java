package fr.efrei.views;
import java.util.*;

import fr.efrei.domain.Customer;
import fr.efrei.factory.CustomerFactory;

public class Customer_Menu {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        Customer ArrayList[];

        while (!exit) {
            System.out.println("===== Gym Subscription Menu =====");
            System.out.println("1. Register as a new customer :");
            System.out.println("2. Get a subscription :");
            System.out.println("3. Change your age in our database");
            System.out.println("5. Go back to the main menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            java.lang.String lastName;
            switch (choice) {
                case 1:
                    // Call a method to view information
                    System.out.println("New to the club ? Register now !\n");
                    System.out.println("First Name : ");
                    String myfirstName = scanner.next();
                    System.out.println("Last Name : ");
                    String mylastName = scanner.next();
                    System.out.println("Age : ");
                    int myage = scanner.nextInt();
                    System.out.println("ID : ");
                    int myID = scanner.nextInt();

                    Customer myCustomer = createCustomer(myfirstName, mylastName, myage, myID);

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
                    System.out.println("Quit the gym...");
                    break;
                case 5:
                    // Exit the program
                    exit = true;
                    System.out.println("Exiting Information System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }

        scanner.close();
    }
}
