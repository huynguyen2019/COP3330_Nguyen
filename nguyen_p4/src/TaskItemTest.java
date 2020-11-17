import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate(){
        TaskItem create = new TaskItem("Task1", "First", "0", true);
    }
    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){
        TaskItem create = new TaskItem("", "Second", "2020-10-15", true);
    }
    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){
        TaskItem create = new TaskItem("Task1", "Second", "2020-10-15", true);
        assertEquals("2020-10-15", create.getDueDate());
    }
    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        TaskItem create = new TaskItem("Task1", "Second", "2020-10-15", true);
        assertEquals("Task1", create.getTitle());
    }
    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate(){
        TaskItem set = new TaskItem("Task1", "Second", "2020-10-15", true);
        set.setDueDate("0");
    }
    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate(){
        TaskItem set = new TaskItem("Task1", "Second", "2020-10-15", true);
        set.setDueDate("2020-11-15");
    }
    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle(){
        TaskItem set = new TaskItem("Task1", "Second", "2020-10-15", true);
        set.setTitle("");
    }
    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle(){
        TaskItem set = new TaskItem("Task1", "Second", "2020-10-15", true);
        set.setTitle("Task2");
    }
}
