import java.io.IOException;
import java.util.Scanner;

public class ContactApp {
    public static void main(String[] args) throws IOException {
        mainMenu();
    }

    private static Scanner input = new Scanner(System.in);

    private static void mainMenu() throws IOException {
        while(true){
            System.out.print("Main Menu\n---------\n\n");
            System.out.print("1) create a new list\n");
            System.out.print("2) load an existing list\n");
            System.out.print("3) quit\n\n");
            ContactList contacts = new ContactList();
            int mainNumber = input.nextInt();
            String emp = input.nextLine();
            if(mainNumber == 1){
                System.out.print("new contact list has been created\n");
                listOperations(contacts);
            } else if(mainNumber == 2){
                System.out.print("Enter the filename to load: ");
                String fileName = input.nextLine();
                contacts.loadContactList(fileName);
                System.out.print("contact list has been loaded\n");
                listOperations(contacts);
            } else if(mainNumber == 3){
                return;
            } else{
                System.out.println("Invalid input.\n");
            }
        }
    }

    private static void listOperations(ContactList contacts){
        while(true){
            System.out.print("List Operation Menu\n---------\n\n");
            System.out.print("1) view the list\n");
            System.out.print("2) add an item\n");
            System.out.print("3) edit an item\n");
            System.out.print("4) remove an item\n");
            System.out.print("5) save the current list\n");
            System.out.print("6) quit to the main menu\n\n");
            int opNumber = input.nextInt();
            String emptyLn = input.nextLine();
            if(opNumber == 1){
                currentContacts(contacts);
            } else if(opNumber == 2){
                System.out.println("First Name: ");
                String fn = input.nextLine();
                System.out.println("Last Name: ");
                String ln = input.nextLine();
                System.out.println("Phone number (xxx-xxx-xxxx): ");
                String pn = input.nextLine();
                System.out.println("Email address (x@y.z): ");
                String em = input.nextLine();
                ContactItem newItem = new ContactItem(fn, ln, pn, em);
                contacts.addContactItem(newItem);
            } else if (opNumber == 3){
                currentContacts(contacts);
                System.out.println("Which contact will you edit? ");
                int index = input.nextInt();
                String empty = input.nextLine();
                System.out.printf("Enter a new first name for contact %d: ", index);
                String newFirstName = input.nextLine();
                System.out.printf("Enter a new last name for contact %d: ", index);
                String newLastName = input.nextLine();
                System.out.printf("Enter a new phone number (xxx-xxx-xxxx) for contact %d: ", index);
                String newPhone = input.nextLine();
                System.out.printf("Enter a new email address (x@y.z) for contact %d: ", index);
                String newEmail = input.nextLine();
                contacts.editContactItem(index, newFirstName, newLastName, newPhone, newEmail);
            } else if (opNumber == 4){
                currentContacts(contacts);
                System.out.println("Which contact will you remove? ");
                int index = input.nextInt();
                contacts.removeContactItems(index);
            } else if(opNumber == 5){
                System.out.println("Enter the filename to save as: ");
                String fileName = input.nextLine();
                contacts.saveContactList(fileName);
                System.out.println("contact list has been saved\n");
            } else if (opNumber == 6){
                return;
            } else {
                System.out.println("Invalid input\n");
            }
        }
    }

    private static void currentContacts(ContactList contacts){
        System.out.print("Current Contacts\n---------\n\n");
        for(int i = 0; i < contacts.getSize(); i++){
            System.out.printf("%s\n", contacts.contactOutput());
        }
    }
}
