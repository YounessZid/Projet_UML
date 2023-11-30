package fr.efrei.factory;
import fr.efrei.domain.Customer;
import fr.efrei.domain.Members;

public class MembersFactory {
    public static Members getMembers(String subscription, String monthCheckIn, String conditions, String firstName, String lastName, int age, int id, String clientTitle){
        return new Members.Builder()
                .setSubscription(subscription)
                .setMonthCheckIn(monthCheckIn)
                .setConditions(conditions)
                .setId_Member(id)
                .build();
    }
}
