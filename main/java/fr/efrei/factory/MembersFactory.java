package fr.efrei.factory;
import fr.efrei.domain.Customer;
import fr.efrei.domain.Members;

public class MembersFactory {
    public static Members createMembers(Customer customer, int ID_Subscription){
        if (customer == null || ID_Subscription == 0)
            return null;
        return new Members.Builder()
                .setCustomer(customer)
                .setID_Subscription(ID_Subscription)
                .build();
    }
}
