package fr.efrei.domain;


import java.util.Date;

public class MonthCheckIn extends Members {

    private static final int MIN_CHECK_INS_REQUIRED = 3;
    private Date checkInDate;
    private Members member;

    private MonthCheckIn(MonthCheckIn.Builder builder){
        super(builder);
        this.checkInDate = builder.checkInDate;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    /*public boolean isCheckInValid() {
        // Assuming check-ins should be counted only for the current month
        Date currentDate = new Date();
        if (checkInDate.getMonth() == currentDate.getMonth() && checkInDate.getYear() == currentDate.getYear()) {
            int checkIns = Integer.parseInt(getMonthCheckIn());
            return checkIns >= MIN_CHECK_INS_REQUIRED;
        }
        return false;
    }*/



    @Override
    public String toString() {
        return "MonthCheckIn{" +
                "subscription='" + getSubscription() + '\'' +
                ", monthCheckIn='" + getMonthCheckIn() + '\'' +
                ", conditions='" + getConditions() + '\'' +
                ", customer=" + getCustomer() +
                ", checkInDate=" + getCheckInDate() +
                //", isValid=" + isCheckInValid() +
                '}';
    }

    public static class Builder extends Members.Builder {
        private Date checkInDate;

        public Builder setCheckInDate(Date checkInDate) {
            this.checkInDate = checkInDate;

            return this;
        }

        @Override
        public MonthCheckIn build() {
            return new MonthCheckIn(this);
        }
    }
}


