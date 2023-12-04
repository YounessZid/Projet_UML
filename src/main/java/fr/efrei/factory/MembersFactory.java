package fr.efrei.factory;
import fr.efrei.domain.Customer;
import fr.efrei.domain.Members;

public class MembersFactory {
    public static Members getMembers(Customer customer){
        if (customer == null)
            return null;
        return new Members.Builder()
                .setCustomer(customer)
                .build();
    }
}
