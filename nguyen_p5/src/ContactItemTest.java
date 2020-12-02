import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class ContactItemTest {
    @Test
    public void testToString(){
        ContactItem con = new ContactItem("Ryou", "Amamiya","123-456-7890","pdg@gmail.com");
        assertEquals("First Name: Ryou\n Last Name: Amamiya\n Phone number (xxx-xxx-xxxx): 123-456-7890\n " +
                "Email address (x@y.z): pdg@gmail.com", con.toString());
    }
    @Test
    public void creationFailsWithAllBlankValues(){
        assertThrows(IllegalArgumentException.class, ()-> {
            ContactItem con = new ContactItem("", "","","");
        });
    }
    @Test
    public void creationSucceedsWithBlankEmail(){
        ContactItem con = new ContactItem("Ryou", "Amamiya","123-456-7890","");
        assertEquals(null, con.getEmail());
    }
    @Test
    public void creationSucceedsWithBlankFirstName(){
        ContactItem con = new ContactItem("", "Amamiya","123-456-7890","");
        assertEquals("", con.getFirstName());
    }
    @Test
    public void creationSucceedsWithBlankLastName(){
        ContactItem con = new ContactItem("Ryou", "","123-456-7890","");
        assertEquals("", con.getLastName());
    }
    @Test
    public void creationSucceedsWithBlankPhone(){
        ContactItem con = new ContactItem("Ryou", "Amamiya","","");
        assertEquals(null, con.getPhoneNum());
    }
    @Test
    public void creationSucceedsWithNonBlankValues(){
        ContactItem con = new ContactItem("Ryou", "Amamiya","123-456-7890","pdg@gmail.com");
        assertEquals("Ryou", con.getFirstName());
        assertEquals("Amamiya", con.getLastName());
        assertEquals("123-456-7890", con.getPhoneNum());
        assertEquals("pdg@gmail.com", con.getEmail());
    }
    @Test
    public void editingFailsWithAllBlankValues(){
        assertThrows(IllegalArgumentException.class, ()-> {
            ContactItem con = new ContactItem("", "","","");
            con.setFirstName("Me");
        });
    }
    @Test
    public void editingSucceedsWithBlankEmail(){
        ContactItem con = new ContactItem("Ryou", "Amamiya","123-456-7890","");
        con.setFirstName("Me");
        assertEquals("Me", con.getFirstName());
    }
    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactItem con = new ContactItem("", "Amamiya","123-456-7890","");
        con.setLastName("Me");
        assertEquals("Me", con.getLastName());
    }
    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactItem con = new ContactItem("Ryou", "","123-456-7890","");
        con.setFirstName("Me");
        assertEquals("Me", con.getFirstName());
    }
    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactItem con = new ContactItem("Ryou", "Amamiya","","");
        con.setFirstName("Me");
        assertEquals("Me", con.getFirstName());
    }
    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactItem con = new ContactItem("Ryou", "Amamiya","123-456-7890","pdg@gmail.com");
        con.setFirstName("Me");
        assertEquals("Me", con.getFirstName());
    }
}
