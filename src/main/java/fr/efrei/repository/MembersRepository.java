package fr.efrei.repository;
import fr.efrei.domain.Members;
import fr.efrei.domain.Customer;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class MembersRepository {


    public void addMembers(Members members) {
        membersArrayList.add(members);
    }

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

    public void baseMember() {
        Customer baseCustomer = new Customer.Builder()
                .setFirstName("John")
                .setLastName("Doe")
                .setAge(30)  // Set the appropriate age
                .setID(1)    // Set a unique ID
                .build();

        Members baseMember = new Members.Builder()
                .setCustomer(baseCustomer)
                .build();

        membersArrayList.add(baseMember);
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

    public List<Members> getMembersArrayList() {
        return membersArrayList;
    }

}
