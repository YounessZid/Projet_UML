package fr.efrei.views;

import fr.efrei.Menu;
import fr.efrei.domain.Members;
import java.util.Scanner;
import fr.efrei.domain.Customer;
import fr.efrei.repository.CustomerRepository;
import fr.efrei.repository.MembersRepository;
import fr.efrei.repository.SubscriptionRepository;

public class Members_Menu {

    // Method to check if the user with a given ID is a member
    public static boolean isMember(int userId, Members[] membersArray) {
        for (Members member : membersArray) {
            if (member.getCustomer().getID() == userId) {
                return true;
            }
        }
        return false;
    }

    // Method to display the Members menu
    public static void main(String[] args) {
        Scanner member_scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println(" ===== Members Menu =====");
            System.out.println(" 1. Members detail :");
            System.out.println(" 2. Change your age in our database :");
            System.out.println(" 3. Unsubscribe to a subscription :");
            System.out.println(" 5. Go to the main menu");
            System.out.println(" 6. Quit the gym");
            System.out.print("Enter your choice: ");

            int choice = member_scanner.nextInt();

            switch (choice) {
                case 1:
                    // Call a method to view information
                    CustomerRepository customerRepository = CustomerRepository.getRepository();
                    // Call a method to view information
                    System.out.println("View member details...");

                    // Ask for customer ID
                    System.out.print("Enter customer ID to view details: ");
                    int customerIdForDetails = member_scanner.nextInt();

                    // Find the customer with the given ID
                    Customer customerForDetails = customerRepository.getCustomerById(customerIdForDetails);

                    if (customerForDetails == null) {
                        System.out.println("Customer with ID " + customerIdForDetails + " not found.");
                    } else {
                        // Create a Members object and pass it to the viewMemberDetails method
                        Members member = new Members.Builder()
                                .setCustomer(customerForDetails)
                                .build();

                        viewMemberDetails(member);
                    }
                    break;

                case 2:
                    // Call a method to add information
                    System.out.println("Unsubscribe to a subscription...");
                    SubscriptionRepository subscriptionRepository = SubscriptionRepository.getRepository();
                    subscriptionRepository.addSubscriptions();
                    MembersRepository membersRepository = MembersRepository.getRepository();
                    membersRepository.unsubscribe();
                    break;
                case 3:
                    // Call a method to update information
                    System.out.println("Change the age...");

                    break;

                case 4:

                    System.out.println("");

                    break;
                case 5:

                    System.out.println("Go to the main menu...");
                    Menu.main(args);
                    break;
                case 6:
                    // Exit the program
                    System.out.println("Quit the gym...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }

        member_scanner.close();
    }

    private static void viewMemberDetails(Members member) {
        System.out.println("\n---- Member Details ----");
        System.out.println("Customer Details: " + member.getCustomer().toString());
    }

    private static void updateMemberDetails(Members member) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter new age for the member: ");
        int newAge = scanner.nextInt();

        // Assuming you have a method in the Members class to update age
        member.getCustomer().setAge(newAge);

        System.out.println("Member details updated successfully.");
    }
}