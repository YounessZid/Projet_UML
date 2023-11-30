package fr.efrei.domain;

public class Members extends Customer{
    private String subscription;
    private String monthCheckIn;
    private String conditions;
    private Customer customer;
    private Members(Members.Builder builder){
        this.subscription = builder.subscription;
        this.monthCheckIn = builder.monthCheckIn;
        this.conditions = builder.conditions;
        this.customer = builder.customer;
    }

    public String getSubscription() {
        return subscription;
    }

    public String getMonthCheckIn() {
        return monthCheckIn;
    }

    public String getConditions() {
        return conditions;
    }

    public Customer getCustomer() {
        return customer;
    }
    public String toString() {
        return "Members{" +
                "subscription='" + subscription + '\'' +
                ", monthCheckIn='" + monthCheckIn + '\'' +
                ", conditions='" + conditions + '\'' +
                ", customer=" + customer +
                '}';
    }

    public static class Builder {
        private String subscription;
        private String monthCheckIn;
        private String conditions;
        private Customer customer;

        public Builder setSubscription(String subscription) {
            this.subscription = subscription;
            return this;
        }

        public Builder setMonthCheckIn(String monthCheckIn) {
            this.monthCheckIn = monthCheckIn;
            return this;
        }

        public Builder setConditions(String conditions) {
            this.conditions = conditions;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }
        public Members build(){
            return new Members(this);
        }
    }

}
