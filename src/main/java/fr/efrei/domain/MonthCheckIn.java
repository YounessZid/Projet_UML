package fr.efrei.domain;


import java.util.Date;

public class MonthCheckIn {

    private static final int minCheckIn = 5;
    private int checkInCpt;

    private Members member;

    private MonthCheckIn(MonthCheckIn.Builder builder) {
        checkInCpt= builder.checkInCpt;
        member= builder.member;
    }

    public int getCheckInCpt() {
        return checkInCpt;
    }

    public Members getMember() {return member;}

    @Override
    public String toString() {
        return "MonthCheckIn{" +
                "member=" + getMember() +
                ", checkInDate=" + getCheckInCpt() +
                //", isValid=" + isCheckInValid() +
                '}';
    }

    public static class Builder {
        private static final int mincheckIn = 5;
        private int checkInCpt;

        private Members member;

        public MonthCheckIn.Builder setcheckInCpt(int checkInCpt) {
            this.checkInCpt = checkInCpt;
            return this;
        }
        public Builder setLastName(Members member) {
            this.member = member;
            return this;
        }

        public MonthCheckIn build() {
            return new MonthCheckIn(this);
        }
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

}