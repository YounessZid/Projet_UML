package fr.efrei.factory;
import fr.efrei.domain.Customer;

public class CustomerFactory {
    public static Customer createCustomer(String firstName, String lastName, int age, int ID, int ID_Subscription){
        if (firstName == null || lastName == null || age == 0 || ID == 0 || ID_Subscription == 0)
            return null;
        return new Customer.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAge(age)
                .setID(ID)
                .setID_Subscription(ID_Subscription)
                .build();
    }
}
