import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class ContactListTest {
    @Test
    public void addingItemsIncreasesSize(){
        ContactList list = new ContactList();
        ContactItem con = new ContactItem("Ryou", "Amamiya","123-456-7890","pdg@gmail.com");
        list.addContactItem(con);
        int sizer = list.getSize();
        assertEquals(1, sizer);
    }
    @Test
    public void newListIsEmpty(){
        ContactList list = new ContactList();
        assertEquals(0, list.getSize());
    }
    @Test
    public void removingItemsDecreasesSize(){
        ContactList list = new ContactList();
        ContactItem con = new ContactItem("Ryou", "Amamiya","123-456-7890","pdg@gmail.com");
        list.addContactItem(con);
        list.removeContactItems(0);
        assertEquals(0, list.getSize());
    }
    @Test
    public void removingFailsWithInvalidIndex(){
        ContactList list = new ContactList();
        ContactItem con = new ContactItem("Ryou", "Amamiya","123-456-7890","pdg@gmail.com");
        list.addContactItem(con);
        try{
            list.removeContactItems(1);
            fail();
        } catch(ArrayIndexOutOfBoundsException e) { }
    }
    @Test
    public void savedContactListCanBeLoaded() throws IOException {
        ContactList list = new ContactList();
        ContactItem con = new ContactItem("Ryou", "Amamiya","123-456-7890","pdg@gmail.com");
        list.addContactItem(con);
        list.saveContactList("text.txt");
        ContactList list2 = new ContactList();
        list2.loadContactList("text.txt");
        assertEquals(con, list.getContactItem(0));
    }
    @Test
    public void editingItemsFailsWithAllBlankValues(){
        assertThrows(IllegalArgumentException.class, ()-> {
            ContactList list = new ContactList();
            ContactItem con = new ContactItem("Ryou", "Amamiya","123-456-7890","pdg@gmail.com");
            list.addContactItem(con);
            list.editContactItem(0, "", "", "","");
        });
    }
    @Test
    public void editingItemsFailsWithInvalidIndex(){
        ContactList list = new ContactList();
        ContactItem con = new ContactItem("Ryou", "Amamiya","123-456-7890","pdg@gmail.com");
        list.addContactItem(con);
        try{
            list.editContactItem(1,"Me","Name","987-654-3210","noname@yahoo.org");
            assertTrue(false);
        } catch(ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }
    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactList list = new ContactList();
        ContactItem con = new ContactItem("Ryou", "Amamiya","123-456-7890","pdg@gmail.com");
        list.addContactItem(con);
        list.editContactItem(0, "", "Randia", "123-123-1234","h25@gmail.com");
        assertEquals("Randia", con.getLastName());
    }
    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactList list = new ContactList();
        ContactItem con = new ContactItem("Ryou", "Amamiya","123-456-7890","pdg@gmail.com");
        list.addContactItem(con);
        list.editContactItem(0, "Mel", "", "123-123-1234","h25@gmail.com");
        assertEquals("Mel", con.getFirstName());
    }
    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactList list = new ContactList();
        ContactItem con = new ContactItem("Ryou", "Amamiya","123-456-7890","pdg@gmail.com");
        list.addContactItem(con);
        list.editContactItem(0, "Mel", "Randia", "","h25@gmail.com");
        assertEquals("Randia", con.getLastName());
    }
    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactList list = new ContactList();
        ContactItem con = new ContactItem("Ryou", "Amamiya","123-456-7890","pdg@gmail.com");
        list.addContactItem(con);
        list.editContactItem(0, "Mel", "Randia", "123-123-1234","h25@gmail.com");
        assertEquals("Mel", con.getFirstName());
        assertEquals("Randia", con.getLastName());
        assertEquals("123-123-1234", con.getPhoneNum());
        assertEquals("h25@gmail.com", con.getEmail());
    }
}
