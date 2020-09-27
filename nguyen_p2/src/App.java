import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    public static boolean moreInput(){
        Scanner bool = new Scanner(System.in);
        while(true){
            System.out.print("Enter Y or N: ");
            String input = bool.nextLine();
            if(input.charAt(0) != 'Y' || input.charAt(0) != 'N'){
                System.out.print("Invalid input.");
                continue;
            }
            boolean output;
            output = input.equals("Y");
            return output;
        }
    }
    public static double getUserHeight(){
        Scanner height = new Scanner(System.in);
        while(true){
            System.out.print("Enter your height (in inches): ");
            double h = height.nextDouble();
            if(h < 0){
                System.out.print("Invalid height.");
                continue;
            }
            return h;
        }
    }
    public static double getUserWeight(){
        Scanner weight = new Scanner(System.in);
        while(true){
            System.out.print("Enter your weight (in pounds): ");
            double w = weight.nextDouble();
            if(w < 0){
                System.out.print("Invalid weight.");
                continue;
            }
            return w;
        }
    }
    private static void displayBmiInfo(BodyMassIndex bmi) {
        System.out.printf("BMI Score: %n%.1lf%n", bmi.bmiScore());
        System.out.printf("Category: %n%s%n", bmi.bmiCategory());
    }
    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        
    }
}