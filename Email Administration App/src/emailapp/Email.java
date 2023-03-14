package emailapp;

import java.util.Scanner;

public class Email {

    private String fName;
    private String lName;
    private String password;
    private String department;
    private int inboxCapacity;
    private String altEmail;

    // Constructor to receive the first and last name
    public Email(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
        System.out.println("- Email Generated -\nFor " + this.fName + " " + this.lName);

        this.department = setDepartment();
        System.out.println("Department is " + this.department + ".");

    }


    // Prompt user for their department
    private String setDepartment() {
        System.out.print("Enter the dept.:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for N/A\nDept Code: ");

        Scanner in = new Scanner(System.in);
        int department = in.nextInt();
        if (department == 1) return "Sales";
        else if (department == 2) return "Development";
        else if (department == 3) return "Accounting";
        else return "N/A";
    }

    // Generate a random password for the user
    private String setPassword(int length) {

        return "";
    }

    // Set the mailbox capacity
    private int setCapacity(int cap) {

        return 0;
    }


    // Set alternate email
    private String setAltEmail() {

        return "";
    }

    // Change the password
    private String changePassword() {

        return "";
    }

}
