 package fr.efrei.domain;

public class GymAdmin {
    private String firstName;
    private String lastName;
    private String password;
    private int ID_Admin;


    public GymAdmin() {
    }

    private GymAdmin(GymAdmin.Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        password = builder.password;
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
    private String getPassword() {
        return password;
    }
    @Override
    public String toString() {
        return "Members{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", password='" + getPassword() + '\'' +
                "Id=" + getID_Admin() +
                '}';
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String password;
        private int ID_Admin;

        public Builder setfirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setlastName(String lastName) {
            this.lastName= lastName;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
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