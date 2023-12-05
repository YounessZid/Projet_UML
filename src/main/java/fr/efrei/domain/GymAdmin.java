 package fr.efrei.domain;
import java.util.*;
import fr.efrei.repository.SubscriptionRepository;
public class GymAdmin {
    private String firstName;
    private String lastName;
    private int ID_Admin;


    public GymAdmin() {
    }

    private GymAdmin(GymAdmin.Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        ID_Admin = builder.ID_Admin;

    }

    public int getID_Admin() {
        return ID_Admin;
    }

    public String getFirstName() {
        return firstName;
    }
    private String getLastName() {
        return lastName;

    }
    @Override
    public String toString() {
        return "Members{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                "Id=" + getID_Admin() +
                '}';
    }
    public void addSubscription(Subscription subscription) {
        SubscriptionRepository.getRepository().getSubscriptionArrayList().add(subscription);
        System.out.println("Subscription added successfully.");
    }

    public void removeSubscription(Subscription subscription) {
        SubscriptionRepository.getRepository().removeSubscription(subscription);
        System.out.println("Subscription removed successfully.");
    }


    public int getAdminID() {
        return ID_Admin;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private int ID_Admin;
        public int getID_Admin() {
            return ID_Admin;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public Builder setfirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setlastName(String lastName) {
            this.lastName= lastName;
            return this;
        }

        public Builder setID_Admin(int ID_Admin) {
            this.ID_Admin = ID_Admin;
            return this;
        }

        public GymAdmin build(){
            return new GymAdmin(this);
        }
}}