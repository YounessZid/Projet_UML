package fr.efrei.factory;
import fr.efrei.domain.Customer;

public class CustomerFactory {
    public static Customer getCustomer(String firstName, String lastName, int age, int id, String clientTitle){
        return new Customer.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAge(age)
                .build();
    }
}
