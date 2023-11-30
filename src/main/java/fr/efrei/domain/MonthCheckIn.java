
package fr.efrei.domain;


import java.util.Date;

public class MonthCheckIn {

    private static final int MIN_CHECK_INS_REQUIRED = 3;
    private Date checkInDate;
    private Members member;

    public MonthCheckIn(Date checkInDate, Members member) {
        this.checkInDate = checkInDate;
        this.member = member;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }
    public Members getMember() {
        return member;
    }


    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setMember(Members member) {
        this.member = member;
    }


    @Override
    public String toString() {
        return "MonthCheckIn{" +
                "member=" + getMember() +
                ", checkInDate=" + getCheckInDate() +
                //", isValid=" + isCheckInValid() +
                '}';
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