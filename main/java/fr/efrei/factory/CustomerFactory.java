package fr.efrei.factory;
import fr.efrei.domain.Customer;

public class CustomerFactory {
    public static Customer createCustomer(String firstName, String lastName, int age, int ID){
        if (firstName == null || lastName == null || age == 0 || ID == 0)
            return null;
        return new Customer.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAge(age)
                .setID(ID)
                .build();
    }
}
