package emailapp;

import java.util.Objects;

import static jdk.nashorn.internal.objects.NativeString.toLowerCase;

public class Email {
    private String address;
    private String firstName, lastName;
    private String department, company;
    private String password;
    private int mailboxCapacity = -1;


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setCompany(String company) {
        this.company = company;
    }


    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }


    public void generateEmail() {
        if (department.length() > 1)
            address = toLowerCase(firstName + "." + lastName + "@" + department + "." + company + ".com");
        else address = toLowerCase(firstName + "." + lastName + "@" + company + ".com");
        password = "RANDOM"; // TODO: Write Random Password Generator
    }

    public String getEmailAddress() {
        return address;
    }


    public String getName() {
        return firstName + ' ' + lastName;
    }

    public boolean verifyPassword(String oldPassword){
        return Objects.equals(oldPassword, password);
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
