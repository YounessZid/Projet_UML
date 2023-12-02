package fr.efrei.factory;
import fr.efrei.domain.Customer;

public class CustomerFactory {
    public static Customer createCustomer(String firstName, String lastName, int age, int ID_Cust){
        if (firstName == null || lastName == null || age == 0 || ID_Cust == 0)
            return null;
        return new Customer.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAge(age)
                .setID_cust(ID_Cust)
                .build();
    }
}
