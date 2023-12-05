package fr.efrei.repository;
import fr.efrei.domain.Members;
import fr.efrei.domain.Customer;
import fr.efrei.domain.Subscription;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class MembersRepository {



    private List<Members> membersArrayList = new ArrayList<>();
    private static MembersRepository instance = null;

    private MembersRepository() {
    }

    public static MembersRepository getRepository() {
        if (instance == null) {
            instance = new MembersRepository();
        }
        return instance;
    }

    public void addMember(Members member) {
        membersArrayList.add(member);
    }

    public void unsubscribe() {
        Scanner scanner = new Scanner(System.in);

        // Ask for member ID to unsubscribe
        System.out.print("Enter member ID to unsubscribe: ");
        int memberId = scanner.nextInt();

        // Find the member with the given ID
        Members member = findMemberById(memberId);

        if (member == null) {
            System.out.println("Member with ID " + memberId + " not found.");
            return;
        }

        // Remove the member from the list
        membersArrayList.remove(member);
        System.out.println("Member with ID " + memberId + " unsubscribed successfully.");
    }



    // Helper method to find a member by ID
    public Members findMemberById(int memberId) {
        for (Members member : membersArrayList) {
            if (member.getCustomer().getID() == memberId) {
                return member;
            }
        }
        return null;
    }

    public void displayMembers() {
        for (Members member : membersArrayList) {
            System.out.println(member);
        }
    }
    public void checkInStatus() {
        Scanner scanner = new Scanner(System.in);

        // Ask for member ID to check in
        System.out.print("Enter member ID to check in: ");
        int memberId = scanner.nextInt();

        // Find the member with the given ID
        Members member = findMemberById(memberId);

        if (member == null) {
            System.out.println("Member with ID " + memberId + " not found.");
            return;
        }

        // Ask for the number of times the member checked in
        System.out.print("Enter the number of times the member checked in: ");
        int checkInCount = scanner.nextInt();

        // Check the condition and display the appropriate message
        if (checkInCount >= 5) {
            System.out.println("Congrats for your dedication!");
        } else {
            System.out.println("You didn't check in enough, you will get additional fees.");
            simulateAdditionnalFees();
        }
    }
    public void simulateAdditionnalFees() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Additional fees payment for subscription: ");
        System.out.println("Price: $" + 20);
        System.out.println("Enter 'confirm' to proceed with payment: ");

        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("confirm")) {
            System.out.println("Payment successful!");
            // Perform any additional logic here, e.g., update the subscription status, etc.
        } else {
            System.out.println("Payment canceled.");
        }

    }


    public List<Members> getMembersArrayList() {
        return membersArrayList;
    }

}
