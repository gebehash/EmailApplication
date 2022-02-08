package emailapp;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

import static jdk.nashorn.internal.objects.NativeString.toLowerCase;

public class Email {
    private final String address;
    private final String firstName;
    private final String lastName;
    private String department;
    private final String companyPrefix = "hashinc.com";
    private String password;
    private String alternateMail;
    private int mailboxCapacity = -1;
    private Scanner in = new Scanner(System.in);

    String setDepartment() {
        System.out.println("Choose a department: \n 1. Sales\n 2. Accounting\n 3. Development\n 0. none");
        int option = in.nextInt();
        in.nextLine();
        switch (option) {
            case 1:
                return "sales";
            case 2:
                return "accounting";
            case 3:
                return "dev";
            default: return "";
        }
    }

    public Email() {
        System.out.print("Enter your first name: ");
        this.firstName = in.nextLine();

        System.out.print("Enter your last name: ");
        this.lastName = in.nextLine();

        department = setDepartment();
        if (department.length() > 1)
            address = toLowerCase(firstName + "." + lastName + "@" + department + "." + companyPrefix);
        else address = toLowerCase(firstName + "." + lastName + "@" + companyPrefix);

        password = "RANDOM"; // TODO: Write Random Password Generator

        System.out.println("This is your email address: " + address);
        System.out.println("This is your randomly chosen password: " + password);
        pressEnterToContinue();
    }

    public void displayName() {
        System.out.println("Your name is " + firstName + ' ' + lastName + '\n');
        pressEnterToContinue();

    }

    public void displayEmailAddress() {
        System.out.println("Your email is " + address + ".\n");
        pressEnterToContinue();
    }

    public void setMailboxCapacity() {
        System.out.print("Set the mailbox capacity: ");
        mailboxCapacity = in.nextInt();
        in.nextLine();
        System.out.println("You have successfully set a mailbox capacity of " + mailboxCapacity + "mb.");
        pressEnterToContinue();
    }

    public void displayMailboxCapacity() {
        if (mailboxCapacity == -1) {
            System.out.println("It seems like you didn't set a mailbox capacity.\n");
            setMailboxCapacity();
        }
        else {
            System.out.println("You have a mailbox capacity of " + mailboxCapacity + "mb.");
            pressEnterToContinue();
        }

    }

    public boolean verifyPassword(String oldPassword){
        return Objects.equals(oldPassword, password);
    }

    public void changePassword() {
        System.out.print("Enter your current password: ");
        String pass = in.nextLine();
        if (verifyPassword(pass)) {
            System.out.print("Enter the new password: ");
            password = in.nextLine();
            System.out.println("You have successfully changed the password!\n");
        }
        else {
            System.out.println("Invalid password!\n");
        }
        pressEnterToContinue();
    }

    public void pressEnterToContinue() {
        System.out.println("Press ENTER to continue...");
        in.nextLine();
    }

}
