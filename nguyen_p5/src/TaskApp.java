import java.io.IOException;
import java.util.Scanner;

public class TaskApp {
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
            TaskList tasks = new TaskList();
            int mainNumber = input.nextInt();
            String emp = input.nextLine();
            if(mainNumber == 1){
                System.out.print("new task list has been created\n");
                listOperations(tasks);
            } else if(mainNumber == 2){
                System.out.print("Enter the filename to load: ");
                String fileName = input.nextLine();
                tasks.loadFile(fileName);
                System.out.print("task list has been loaded\n");
                listOperations(tasks);
            } else if(mainNumber == 3){
                return;
            } else{
                System.out.println("Invalid input.\n");
            }
        }
    }

    private static void listOperations(TaskList tasks){
        while(true){
            System.out.print("List Operation Menu\n---------\n\n");
            System.out.print("1) view the list\n");
            System.out.print("2) add an item\n");
            System.out.print("3) edit an item\n");
            System.out.print("4) remove an item\n");
            System.out.print("5) mark an item as completed\n");
            System.out.print("6) unmark an item as completed\n");
            System.out.print("7) save the current list\n");
            System.out.print("8) quit to the main menu\n\n");
            int opNumber = input.nextInt();
            String emptyLn = input.nextLine();
            if(opNumber == 1){
                currentTasks(tasks);
            } else if(opNumber == 2){
                System.out.println("Task title: ");
                String title = input.nextLine();
                System.out.println("Task description: ");
                String describe = input.nextLine();
                System.out.println("Task due date (YYYY-MM-DD): ");
                String dueDate = input.nextLine();
                TaskItem newItem = new TaskItem(title, describe, dueDate, false);
                tasks.addTaskItem(newItem);
            } else if (opNumber == 3){
                currentTasks(tasks);
                System.out.println("Which task will you edit? ");
                int index = input.nextInt();
                String empty = input.nextLine();
                System.out.printf("Enter a new title for task %d: ", index);
                String newTitle = input.nextLine();
                System.out.printf("Enter a new description for task %d: ", index);
                String newDesc = input.nextLine();
                System.out.printf("Enter a new task due date (YYYY-MM-DD) for task %d: ", index);
                String newDueDate = input.nextLine();
                tasks.editTaskItem(index, newTitle, newDesc, newDueDate);
            } else if (opNumber == 4){
                currentTasks(tasks);
                System.out.println("Which task will you remove? ");
                int index = input.nextInt();
                tasks.removeTaskItems(index);
            } else if (opNumber == 5){
                System.out.print("Uncompleted Tasks\n---------\n\n");
                for(int i = 0; i < tasks.getSize(); i++){
                    System.out.printf("%s", tasks.taskOutput());
                }
                System.out.println("Which task will you mark as completed? ");
                int index = input.nextInt();
                tasks.isTaskComplete(index, true);
            } else if (opNumber == 6){
                System.out.print("Completed Tasks\n---------\n\n");
                for(int i = 0; i < tasks.getSize(); i++){
                    System.out.printf("%s", tasks.taskOutput());
                }
                System.out.println("Which task will you unmark as completed? ");
                int index = input.nextInt();
                tasks.isTaskComplete(index, false);
            } else if(opNumber == 7){
                System.out.println("Enter the filename to save as: ");
                String fileName = input.nextLine();
                tasks.saveTaskList(fileName);
                System.out.println("task list has been saved\n");
            } else if (opNumber == 8){
                return;
            } else {
                System.out.println("Invalid input\n");
            }
        }
    }

    private static void currentTasks(TaskList tasks){
        System.out.print("Current Tasks\n---------\n\n");
        for(int i = 0; i < tasks.getSize(); i++){
            System.out.printf("%s\n", tasks.taskOutput());
        }
    }
}
