package fr.efrei.factory;
import fr.efrei.domain.Customer;
import fr.efrei.domain.Members;

public class MembersFactory {
    public static Members getMembers(Customer customer, int Id_Member){
        if (customer == null || Id_Member == 0)
            return null;
        return new Members.Builder()
                .setId_Member(Id_Member)
                .setCustomer(customer)
                .build();
    }
}
