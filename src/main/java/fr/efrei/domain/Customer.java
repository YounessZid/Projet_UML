package fr.efrei.domain;

public class Customer {
    private String firstName;
    private String lastName;
    private int age;
    private int ID_cust;


    public Customer() {
    }

    private Customer(Customer.Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        age = builder.age;
        ID_cust = builder.age;
    }

    public String getFirstName() {
        return firstName;
    }
    private String getLastName() {
        return lastName;

    }

    public int getID_cust() {
        return ID_cust;
    }

    private int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return "Members{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", age='" + getAge() + '\'' +
                "Id=" + getID_cust() +
                '}';
    }
    public static class Builder {
        private String firstName;
        private String lastName;
        private int age;
        private int ID_cust;

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
        public Builder setID_cust(int ID_cust){
            this.ID_cust = ID_cust;
            return this;
        }
        public Customer build() {
            return new Customer(this);
        }
    }
}
