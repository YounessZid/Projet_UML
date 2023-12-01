package fr.efrei.domain;

public class GymAdmin {
    private String firstName;
    private String lastName;
    private String password;

    public GymAdmin() {
    }

    private GymAdmin(GymAdmin.Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        password = builder.password;
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
                '}';
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String password;

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

        public GymAdmin build(){
            return new GymAdmin(this);
        }
}}
