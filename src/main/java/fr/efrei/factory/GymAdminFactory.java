package fr.efrei.factory;
import fr.efrei.domain.GymAdmin;

public class GymAdminFactory {
    public static GymAdmin getGymAdmin(String firstName, String lastName, String password){
        return new GymAdmin.Builder()
                .setfirstName(firstName)
                .setlastName(lastName)
                .setPassword(password)
                .build();
    }
}

