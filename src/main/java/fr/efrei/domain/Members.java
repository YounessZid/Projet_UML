package fr.efrei.domain;

public class Members {
    private String firstName;
    private String lastName;
    private Members() {}

    private Members(Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
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
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
    public static class Builder {
        private String firstName;
        private String lastName;
        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Members build() {
            return new Members(this);
        }
    }
}
