import java.util.List;
import java.io.*;
import java.util.Formatter;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class ContactList {
    List<ContactItem> contacts;

    public ContactList() {
        contacts = new ArrayList<>();
    }

    public void addContactItem(ContactItem data) {
        contacts.add(data);
    }

    public int getSize(){
        return contacts.size();
    }

    public void writeContacts(String fileName) {
        try(Formatter output = new Formatter(fileName)) {
            for(int i = 0; i < contacts.size(); i++) {
                ContactItem data = contacts.get(i);
                output.format("First Name: %s\nLast Name: %s\nPhone number (xxx-xxx-xxxx): %s\nEmail address (x@y.z): %s\n",
                        data.getFirstName(), data.getLastName(), data.getPhoneNum(), data.getEmail());
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void editContactItem(int index, String newFirstName, String newLastName, String newPhoneNum, String newEmail)
            throws IllegalArgumentException{
        ContactItem toBeEdited = getContactItem(index);
        toBeEdited.setFirstName(newFirstName);
        toBeEdited.setLastName(newLastName);
        toBeEdited.setPhoneNum(newPhoneNum);
        toBeEdited.setEmail(newEmail);
        if(newFirstName == "" && newLastName == "" && newPhoneNum == "" && newEmail == ""){
            throw new IllegalArgumentException("You cannot leave everything blank");
        }
    }
    public ContactItem getContactItem(int index) throws ArrayIndexOutOfBoundsException{
        if(index >= getSize()){
            throw new ArrayIndexOutOfBoundsException();
        }
        return contacts.get(index);
    }

    public void removeContactItems(int index) throws ArrayIndexOutOfBoundsException{
        if(index >= getSize()){
            throw new ArrayIndexOutOfBoundsException();
        }
        contacts.remove(index);
    }

    public void saveContactList(String filename){
        writeContacts(filename);
    }

    public void loadContactList(String fileName) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader(fileName));
        String fn;
        while((fn = read.readLine()) != null){
            fn = fn.substring("First Name: ".length());
            String ln = read.readLine();
            ln = ln.substring("Last Name: ".length());
            String pn = read.readLine();
            pn = pn.substring("Phone number (xxx-xxx-xxxx): ".length());
            String em = read.readLine();
            em = em.substring("Email address (x@y.z): ".length());
            ContactItem ci = new ContactItem(fn, ln, pn, em);
            addContactItem(ci);
        }
        read.close();
    }

    public String contactOutput(){
        String retVal = "";
        for(int i = 0; i < contacts.size(); i++){
            String itemString = String.format("Name: %s %s\nPhone: %s\nEmail: %s%n", contacts.get(i).getFirstName(),
                    contacts.get(i).getLastName(), contacts.get(i).getPhoneNum(), contacts.get(i).getEmail());
            retVal += itemString;
        }
        return retVal;
    }
}
