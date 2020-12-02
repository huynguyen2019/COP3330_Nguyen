import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {
    @Test
    public void constructorFailsWithInvalidDueDate(){
        assertThrows(IllegalArgumentException.class, ()-> {
            TaskItem create = new TaskItem("Task1", "First", "0", true);
        });
    }
    @Test
    public void constructorFailsWithInvalidTitle(){
        assertThrows(IllegalArgumentException.class, ()-> {
            TaskItem create = new TaskItem("", "Second", "2020-10-15", true);
        });
    }
    @Test
    public void constructorSucceedsWithValidDueDate(){
        TaskItem create = new TaskItem("Task1", "Second", "2020-10-15", true);
        assertEquals("2020-10-15", create.getDueDate());
    }
    @Test
    public void constructorSucceedsWithValidTitle(){
        TaskItem create = new TaskItem("Task1", "Second", "2020-10-15", true);
        assertEquals("Task1", create.getTitle());
    }
    @Test
    public void editingDueDateFailsWithInvalidDate(){
        assertThrows(IllegalArgumentException.class, ()-> {
            TaskItem create = new TaskItem("Task1", "First", "2020-10-15", true);
            create.setDueDate("0");
        });
    }
    @Test
    public void editingDueDateSucceedsWithValidDate(){
        TaskItem set = new TaskItem("Task1", "Second", "2020-10-15", true);
        set.setDueDate("2020-11-15");
        assertEquals("2020-11-15",set.getDueDate());
    }
    @Test
    public void editingTitleFailsWithInvalidTitle(){
        assertThrows(IllegalArgumentException.class, ()-> {
            TaskItem create = new TaskItem("Task1", "First", "2020-10-15", true);
            create.setTitle("");
        });
    }
    @Test
    public void editingTaskItemTitleSucceedsWithValidTitle(){
        TaskItem set = new TaskItem("Task1", "Second", "2020-10-15", true);
        set.setTitle("Task2");
        assertEquals("Task2",set.getTitle());
    }
}