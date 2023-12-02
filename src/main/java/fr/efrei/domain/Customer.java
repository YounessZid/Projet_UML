package fr.efrei.domain;

public class Customer {
    private String firstName;
    private String lastName;
    private int age;


    public Customer() {
    }

    private Customer(Customer.Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        age = builder.age;
    }



    public String getFirstName() {
        return firstName;
    }
    private String getLastName() {
        return lastName;

    }
    public int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return "Members{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", age='" + getAge() + '\'' +
                '}';
    }
    public static class Builder {
        private String firstName;
        private String lastName;
        private int age;

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }
        public Customer build() {
            return new Customer(this);
        }
    }
}
