//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package fr.efrei.repository;

import fr.efrei.domain.Customer;
import fr.efrei.factory.CustomerFactory;
import fr.efrei.domain.Members;
import fr.efrei.domain.Subscription;
import fr.efrei.factory.MembersFactory;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CustomerRepository {
    public static List<Customer> customerArrayList = new ArrayList();
    private static CustomerRepository instance = null;

    private CustomerRepository() {
    }

    public static CustomerRepository getRepository() {
        if (instance == null) {
            instance = new CustomerRepository();
        }

        return instance;
    }

    public void addCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter firstname: ");
        String firstname = scanner.nextLine();
        System.out.print("Enter lastname: ");
        String lastname = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        while (isCustomerExists(firstname, lastname, age)) {
            System.out.println("Customer already exists. Please enter the details again.");
            System.out.print("Enter firstname: ");
            firstname = scanner.nextLine();
            System.out.print("Enter lastname: ");
            lastname = scanner.nextLine();
            System.out.print("Enter age: ");
            age = scanner.nextInt();
        }

        Scanner idScanner = new Scanner(System.in);
        System.out.print("Enter id: ");

        int id;
        for (id = idScanner.nextInt(); isDuplicateId(id); id = idScanner.nextInt()) {
            System.out.println("This customer id is already taken, please enter another one");
        }
        Customer customer = CustomerFactory.createCustomer(firstname, lastname, age, id);
        customerArrayList.add(customer);
        customer.printCustomerDetails();
    }


    private boolean isDuplicateId(int id) {
        Iterator var2 = customerArrayList.iterator();

        Customer customer;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            customer = (Customer)var2.next();
        } while(customer.getID() != id);

        return true;
    }

    private boolean isCustomerExists(String firstname, String lastname, int age) {
        Iterator var4 = customerArrayList.iterator();

        Customer customer;
        do {
            if (!var4.hasNext()) {
                return false;
            }

            customer = (Customer)var4.next();
        } while(!customer.getFirstName().equals(firstname) || !customer.getLastName().equals(lastname) || customer.getAge() != age);

        return true;
    }

    /*private Customer getExistingCustomer(String firstname, String lastname, int age) {
        Iterator var4 = customerArrayList.iterator();

        Customer customer;
        do {
            if (!var4.hasNext()) {
                return null;
            }

            customer = (Customer)var4.next();
        } while(!customer.getFirstName().equals(firstname) || !customer.getLastName().equals(lastname) || customer.getAge() != age);

        return customer;
    }*/




    public void updateCustomerAge() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer ID to update age: ");
        int idToUpdate = scanner.nextInt();
        boolean customerExists = false;

        Iterator<Customer> iterator = customerArrayList.iterator();

        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.getID() == idToUpdate) {
                customerExists = true;
                System.out.print("Enter new age for the customer: ");
                int newAge = scanner.nextInt();

                // Remove the existing customer from the list
                iterator.remove();

                // Create and add the updated customer
                Customer updatedCustomer = CustomerFactory.createCustomer(customer.getFirstName(), customer.getLastName(), newAge, customer.getID());
                customerArrayList.add(updatedCustomer);

                System.out.println("Age updated successfully for customer with ID " + idToUpdate);
                break;
            }
        }

        if (!customerExists) {
            System.out.println("Customer with ID " + idToUpdate + " not found.");
        }
    }


    public void subscribe() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer ID to subscribe: ");
        int customerId = scanner.nextInt();
        Customer customer = this.findCustomerById(customerId);
        if (customer == null) {
            System.out.println("Customer with ID " + customerId + " not found.");
        } else {
            System.out.println("Existing Subscriptions:");
            SubscriptionRepository subscriptionRepository = SubscriptionRepository.getRepository();
            subscriptionRepository.displaySubscriptions();
            System.out.print("Enter the subscription number to subscribe: ");
            int subscriptionChoice = scanner.nextInt();
            if (subscriptionChoice >= 1 && subscriptionChoice <= SubscriptionRepository.getRepository().getSubscriptionArrayList().size()) {
                Subscription chosenSubscription = (Subscription)SubscriptionRepository.getRepository().getSubscriptionArrayList().get(subscriptionChoice - 1);
                int customerAge = customer.getAge();
                double discount = 0.0;
                if (customerAge < 18 || customerAge > 60) {
                    discount = 0.2;
                    System.out.println("Congratulations! You get a 20% discount for being under 18 or over 60.");
                }


                double discountedPrice = (double)chosenSubscription.getPrice() * (1.0 - discount);
                simulatePayment(chosenSubscription, discountedPrice);
                Customer updatedCustomer = CustomerFactory.createCustomer(customer.getFirstName(), customer.getLastName(), customer.getAge(), customer.getID());

                Members member = MembersFactory.createMembers(updatedCustomer, chosenSubscription.getID_Subscription());
                MembersRepository.getRepository().addMember(member);

                System.out.println("Subscription details:");
                System.out.println(chosenSubscription.toString());
                System.out.println("Final Price: $" + discountedPrice);
                System.out.println("Member ID: " + customer.getID());
                System.out.println("Subscription ID: " + chosenSubscription.getID_Subscription());

            } else {
                System.out.println("Invalid subscription choice.");
            }

        }



    }
    public void simulatePayment(Subscription subscription, double price) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Simulating payment for subscription: " + subscription.getName());
        System.out.println("Price: $" + price);
        System.out.println("Enter 'confirm' to proceed with payment: ");

        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("confirm")) {
            System.out.println("Payment successful!");
            // Perform any additional logic here, e.g., update the subscription status, etc.
        } else {
            System.out.println("Payment canceled.");
        }

    }


    public Customer findCustomerById(int customerId) {
        Iterator var2 = customerArrayList.iterator();

        Customer customer;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            customer = (Customer)var2.next();
        } while(customer.getID() != customerId);

        return customer;
    }


    public void displayCustomerDetails(Customer customer) {
        System.out.println(customer.toString());
    }

    public void baseCustomers() {
        Customer customer1 = CustomerFactory.createCustomer("John", "Doe", 25, 1);
        customerArrayList.add(customer1);
    }


    public void removeCustomer(Customer customer) {
        customerArrayList.remove(customer);
    }
}
