package fr.efrei.domain;

public class Members extends Customer{

    private Customer customer;
    private int Id_Member;
    Members(Members.Builder builder){
        this.customer = builder.customer;
        this.Id_Member = builder.Id_Member;
    }



    public Customer getCustomer() {
        return customer;
    }

    public int getId_Member() {
        return Id_Member;
    }
    public String toString() {
        return "Members{" +
                ", customer=" + getCustomer() +
                ", Id_Member=" + getId_Member() +
                '}';
    }

    public static class Builder {

        private Customer customer;
        private int Id_Member;



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