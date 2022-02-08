package emailapp;

import java.util.Random;
import java.util.Scanner;

public class EmailApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char option = ' ';
        String pass;

        Email email = new Email();

        System.out.println("Email generator\n\n");

        System.out.println("What is your first name?");
        email.setFirstName(scanner.nextLine());

        System.out.println("What is your last name?");
        email.setLastName(scanner.nextLine());

        System.out.println("What company do you work for?");
        email.setCompany(scanner.nextLine());

        System.out.println("What department?");
        email.setDepartment(scanner.nextLine());

        email.generateEmail();

        System.out.println("This is your email address: " + email.getEmailAddress());
        System.out.println("This is your randomly chosen password: " + email.getPassword());
        System.out.println("\n");

        while (option != 'q') {
            System.out.println("Welcome to your account! Choose an option: \n");
            System.out.println(" 1. Display name\n 2. Display email\n 3. Display mailbox capacity\n 4. Change password\n 5. Change mailbox capacity\n\n q. Quit");
            option = scanner.next().charAt(0);

            switch (option) {
                case '1':
                    System.out.println("Your name is " + email.getName() + '.');
                    break;

                case '2':
                    System.out.println("Your email is " + email.getEmailAddress() + '.');
                    break;

                case '3':
                    if (email.getMailboxCapacity() == -1) {
                        System.out.println("It seems like you didn't set a mailbox capacity.\n Enter the desired capacity: ");
                        email.setMailboxCapacity(scanner.nextInt());
                        scanner.nextLine();
                        System.out.println("You have successfully set a mailbox capacity of " + String.valueOf(email.getMailboxCapacity()) + ".");
                    }
                    else {
                        System.out.println("You have a mailbox capacity of " + String.valueOf(email.getMailboxCapacity()) + ".");
                    }
                    break;

                case '4':
                    System.out.print("Enter your current password: ");
                    Scanner scanner2 = new Scanner(System.in);
                    pass = scanner2.nextLine();
                    if (email.verifyPassword(pass)) {
                        System.out.print("Enter the new password: ");
                        email.changePassword(scanner2.nextLine());
                    }
                    else {
                        System.out.println("Invalid password!\n");
                    }
                    break;

                case '5':
                    System.out.println("Set the mailbox capacity: ");
                    email.setMailboxCapacity(scanner.nextInt());
                    scanner.nextLine();
                    break;

            }
        }
    }
}
