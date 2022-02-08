package emailapp;

import java.io.IOException;
import java.util.Scanner;

public class EmailApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char option = ' ';
        String pass;

        Email email = new Email();

        while (option != 'q') {
            System.out.println("Welcome to your account! Choose an option: \n");
            System.out.println(" 1. Display name\n 2. Display email\n 3. Display mailbox capacity\n 4. Change password\n 5. Change mailbox capacity\n\n q. Quit");
            option = scanner.next().charAt(0);

            switch (option) {
                case '1':
                    email.displayName();
                    break;

                case '2':
                    email.displayEmailAddress();
                    break;

                case '3':
                    email.displayMailboxCapacity();
                    break;

                case '4':
                    email.changePassword();
                    break;

                case '5':
                    email.setMailboxCapacity();
                    break;

            }
        }
    }
}
