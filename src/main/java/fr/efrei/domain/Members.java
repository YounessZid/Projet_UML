package fr.efrei.domain;

public class Members extends Customer{
    private String subscription;
    private String monthCheckIn;
    private String conditions;
    private Customer customer;
    private int Id_Member;
    Members(Members.Builder builder){
        this.subscription = builder.subscription;
        this.monthCheckIn = builder.monthCheckIn;
        this.conditions = builder.conditions;
        this.customer = builder.customer;
        this.Id_Member = builder.Id_Member;
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

    public int getId_Member() {
        return Id_Member;
    }
    public String toString() {
        return "Members{" +
                "subscription='" + getSubscription() + '\'' +
                ", monthCheckIn='" + getMonthCheckIn() + '\'' +
                ", conditions='" + getConditions() + '\'' +
                ", customer=" + getCustomer() +
                ", Id_Member=" + getId_Member() +
                '}';
    }

    public static class Builder {
        private String subscription;
        private String monthCheckIn;
        private String conditions;
        private Customer customer;
        private int Id_Member;

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

        public Builder setId_Member(int Id_Member) {
            this.Id_Member = Id_Member;
            return this;
        }
        public Members build(){
            return new Members(this);
        }
    }

}