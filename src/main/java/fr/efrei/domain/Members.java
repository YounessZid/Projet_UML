package fr.efrei.domain;

public class Members extends Customer {
    private Customer customer;


    // Make the constructor public
    public Members(Members.Builder builder) {
        this.customer = builder.customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String toString() {
        return "Members{" +
                ", customer=" + getCustomer() +
                '}';
    }

    public static class Builder {
        private Customer customer;

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Members build() {
            return new Members(this);
        }
    }
}
