package fr.efrei;
import fr.efrei.domain.Members;
import fr.efrei.repository.CustomerRepository;
import fr.efrei.views.Customer_Menu;
import fr.efrei.views.GymAdminMenu;
import fr.efrei.views.Members_Menu;
import fr.efrei.repository.GymAdminRepository;

import java.text.ParseException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        GymAdminRepository.getRepository().BaseGymAdmins();

        while (!exit) {
            System.out.println("===== Gym Subscription Menu =====");
            System.out.println("1. Customer menu :");
            System.out.println("2. Member menu :");
            System.out.println("3. GymAdmin menu :");
            System.out.println("4. Quit the gym");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Go to the customer menu
                    System.out.println("Customer Menu...");
                    Customer_Menu.main(args);
                    CustomerRepository customerRepository = CustomerRepository.getRepository();
                    customerRepository.baseCustomers();
                    break;
                case 2:
                    // Go to the members menu
                    System.out.println("Members menu...");
                    Members_Menu.main(args);

                    break;
                case 3:
                    // Go to the gym admin menu
                    System.out.println("GYM Admin menu...");

                    // Prompt for GymAdmin ID
                    System.out.print("Enter GymAdmin ID: ");
                    int adminID = scanner.nextInt();

                    // Check if the user is a GymAdmin
                    if (GymAdminRepository.getRepository().isGymAdmin(adminID)) {
                        // User is a GymAdmin, allow access to GymAdminMenu
                        GymAdminMenu.main(args);
                    } else {
                        System.out.println("Invalid GymAdmin ID. Access denied.");
                    }
                    break;

                case 4:
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
