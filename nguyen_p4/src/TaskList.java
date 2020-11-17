import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Formatter;
import java.io.FileNotFoundException;

public class TaskList {
    List<TaskItem> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void addTaskItem(TaskItem data) {
        tasks.add(data);
    }

    public int getSize(){
        return tasks.size();
    }

    /**
     * write the task in the format specified, if no file then throw exception
     * @param fileName a String of file name
     */
    public void writeTasks(String fileName) {
        try(Formatter output = new Formatter(fileName)) {
            for(int i = 0; i < tasks.size(); i++) {
                TaskItem data = tasks.get(i);
                output.format("Task title: %s\nTask Description: %s\nTask Due Date (YYYY-MM-DD): %s\nCompleted: %b\n",
                        data.getTitle(), data.getDescription(), data.getDueDate(), data.getComStatus());
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void removeTaskItems(int index) throws ArrayIndexOutOfBoundsException{
        if(index >= getSize()){
            throw new ArrayIndexOutOfBoundsException();
        }
        tasks.remove(index);
    }

    public void editTaskItem(int index, String newTitle, String newDesc, String newDueDate) throws ArrayIndexOutOfBoundsException{
        TaskItem toBeEdited = getTaskItem(index);
        toBeEdited.setTitle(newTitle);
        toBeEdited.setDescription(newDesc);
        toBeEdited.setDueDate(newDueDate);
    }
    public TaskItem getTaskItem(int index) throws ArrayIndexOutOfBoundsException{
        if(index >= getSize()){
            throw new ArrayIndexOutOfBoundsException();
        }
        return tasks.get(index);
    }

    public void isTaskComplete(int index, boolean comStatus) throws ArrayIndexOutOfBoundsException{
        TaskItem toBeMarked = getTaskItem(index);
        toBeMarked.setComStatus(comStatus);
    }

    public void saveTaskList(String filename){
        writeTasks(filename);
    }

    public void loadFile(String fileName) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader(fileName));
        String title;
        while((title = read.readLine()) != null){
            title = title.substring("Task title: ".length());
            String desc = read.readLine();
            desc = desc.substring("Task Description: ".length());
            String dueDate = read.readLine();
            dueDate = dueDate.substring("Task Due Date (YYYY-MM-DD): ".length());
            String status = read.readLine();
            status = status.substring("Completed: ".length());
            boolean completed = Boolean.parseBoolean(status);
            TaskItem ti = new TaskItem(title, desc, dueDate, completed);
            addTaskItem(ti);
        }
        read.close();
    }

    public String output(){
        String retVal = "";
        for(int i = 0; i < tasks.size(); i++){
            String itemString = String.format("[%s] %s: %s%n", tasks.get(i).getDueDate(),
                    tasks.get(i).getTitle(), tasks.get(i).getDescription());
            if(tasks.get(i).getComStatus() == true){
                itemString = "*** " + itemString;
            }
            retVal += itemString;
        }
        return retVal;
    }
}
