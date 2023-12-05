package fr.efrei.domain;

public class Members extends Customer {
    private Customer customer;
    private int ID_Subscription;


    // Make the constructor public
    public Members(Members.Builder builder) {
        this.customer = builder.customer;
        this.ID_Subscription = builder.ID_Subscription;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getID_Subscription() {
        return ID_Subscription;
    }

    public String toString() {
        return "Members{" +
                ", customer=" + getCustomer() +
                ", ID_Subscription=" + getID_Subscription() +
                '}';
    }

    public static class Builder {
        private Customer customer;
        private int ID_Subscription;

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }
        public Builder setID_Subscription(int ID_Subscription) {
            this.ID_Subscription = ID_Subscription;
            return this;
        }

        public Members build() {
            return new Members(this);
        }
    }
}
