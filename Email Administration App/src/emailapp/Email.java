package emailapp;

import java.util.Scanner;

public class Email {
    private String email;
    private String fName;
    private String lName;
    private String password;
    private int passwordLength = 12;
    private String department;
    private int inboxCapacity = 150;
    private String altEmail;

    // Constructor to receive the first and last name
    public Email(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;

        // Setting the dept
        this.department = setDepartment();

        // Generating a random password
        this.password = setPassword(passwordLength);

        // Put together the email:
        if (this.department.equals("N/A")) {
            this.email = this.fName.toLowerCase() + "." + this.lName.toLowerCase() + "@" + "company.com";
        } else {
            this.email = this.fName.toLowerCase() + "." + this.lName.toLowerCase() + "@" +
                    this.department.toLowerCase() + ".company.com";
        }
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
        String characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int random = (int) (Math.random() * characterSet.length());
            password[i] = characterSet.charAt(random);
        }

        return new String(password);
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getInboxCapacity() {
        return this.inboxCapacity;
    }

    // Set the mailbox capacity
    public void setInboxCapacity(int cap) {
        this.inboxCapacity = cap;
    }

    public String getAltEmail() {
        return this.altEmail;
    }

    // Set alternate email
    public void setAltEmail(String em) {
        this.email = em;
    }

    public String getName() {
        return this.fName + " " + this.lName;
    }

    public String getAllInfo() {
        return "Name: " + this.fName + " " + this.lName +
                "\nEmail: " + this.email + "\nDepartment: " + this.department +
                "\nInbox Capacity: " + this.inboxCapacity;
    }

}
