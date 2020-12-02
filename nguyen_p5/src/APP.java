import java.io.IOException;
import java.util.Scanner;

public class APP {
    public static void main(String[] args) throws IOException {
        trueMenu();
    }

    private static Scanner input = new Scanner(System.in);

    private static void trueMenu() throws IOException {
        while(true){
            System.out.print("Select Your Application\n---------\n\n");
            System.out.print("1) task list\n");
            System.out.print("2) contact list\n");
            System.out.print("3) quit\n\n");
            int menuNum = input.nextInt();
            String emp = input.nextLine();
            if(menuNum == 1){
                TaskApp.main(null);
            } else if (menuNum == 2){
                ContactApp.main(null);
            } else if (menuNum == 3){
                return;
            } else {
                System.out.println("Invalid input.\n");
            }
        }
    }
}
