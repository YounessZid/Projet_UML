package fr.efrei.factory;
import fr.efrei.domain.GymAdmin;

public class GymAdminFactory {
    public static GymAdmin getGymAdmin(String firstName, String lastName, int ID_Admin){
        if (firstName == null || lastName == null || ID_Admin == 0)
            return null;
        return new GymAdmin.Builder()
                .setfirstName(firstName)
                .setlastName(lastName)
                .setID_Admin(ID_Admin)
                .build();
    }
}

