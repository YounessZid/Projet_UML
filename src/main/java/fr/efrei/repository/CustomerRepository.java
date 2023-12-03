package fr.efrei.repository;

import fr.efrei.domain.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerRepository {
    public List<Customer> customerArrayList = new ArrayList<>();
    private static CustomerRepository instance = null;
    private CustomerRepository(){}
    public static CustomerRepository getRepository(){
        if(instance == null){
            instance = new CustomerRepository();
        }
        return instance;
    }
    //CRUDE OPERATION :
    public void addCustomer(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter firstname: ");
        String firstname = scanner.nextLine();

        System.out.print("Enter lastname: ");
        String lastname = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        if (isCustomerExists(firstname, lastname, age)) {
            System.out.println("Customer already exists: " + getExistingCustomer(firstname, lastname, age));
            return;
        }

        Scanner idScanner = new Scanner(System.in);

        System.out.print("Enter id: ");
        int id = idScanner.nextInt();

        while (isDuplicateId(id)) {
            System.out.println("This customer id is already taken, please enter another one");
            id = idScanner.nextInt();
        }
        Customer customer = new Customer.Builder()
                .setFirstName(firstname)
                .setLastName(lastname)
                .setAge(age)
                .setID(id)
                .build();
        customerArrayList.add(customer);
        customer.printCustomerDetails();
        //Prints the newly made customer
    }
    private boolean isDuplicateId(int id) {
        for (Customer customer : customerArrayList) {
            if (customer.getID() == id) {
                return true;
            }
        }
        return false;
    }
    //checks if the id is already taken

    private boolean isCustomerExists(String firstname, String lastname, int age) {
        for (Customer customer : customerArrayList) {
            if (customer.getFirstName().equals(firstname) &&
                    customer.getLastName().equals(lastname) &&
                    customer.getAge() == age) {
                return true;
            }
        }
        return false;
    }
    //checks if the customer already exists

    private Customer getExistingCustomer(String firstname, String lastname, int age) {
        for (Customer customer : customerArrayList) {
            if (customer.getFirstName().equals(firstname) &&
                    customer.getLastName().equals(lastname) &&
                    customer.getAge() == age) {
                return customer;
            }
        }
        return null;
    }
    //returns the customer if he already exists
    public void removeSubscription(Customer customer){
        customerArrayList.remove(customer);
    }
}