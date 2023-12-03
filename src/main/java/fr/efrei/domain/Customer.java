package fr.efrei.domain;

public class Customer {
    private String firstName;
    private String lastName;
    private int age;
    private int ID;


    public Customer() {
    }

    private Customer(Customer.Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        age = builder.age;
        ID = builder.ID;
    }



    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getID() {
        return ID;
    }
    @Override
    public String toString() {
        return "Members{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", id=" + ID +
                '}';
    }
    public void printCustomerDetails() {
        System.out.println("Customer Details:");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Age: " + age);
        System.out.println("ID: " + ID);
        System.out.println("=====================================");
    }


    public static class Builder {
        private String firstName;
        private String lastName;
        private int age;
        private int ID;

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
        public Builder setID(int ID){
            this.ID = ID;
            return this;
        }
        public Customer build() {
            return new Customer(this);
        }
    }
}