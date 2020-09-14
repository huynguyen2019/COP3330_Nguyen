import java.util.Scanner;
import java.util.Arrays;

public class Encrypter {
    // main method
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int[] buf = new int[4];
        while(inp.hasNextInt()) {
            Encrypter e = new Encrypter(inp);
            System.out.print("Encrypted String: ");
            System.out.println(e.encrypt());
        }
        inp.close();
    }
    private int[] input;
    public Encrypter(Scanner s) {
        input = new int[4];
        for(int i = 0; i < input.length; i++) {
            input[i] = s.nextInt();
        }
    }

    //instance method called `encrypt` that accepts a String of 4 digits representing a single integer
    public String encrypt(){
        int[] arr = new int[4];

        //Replace each digit with the result of adding 7 to the digit and
        // getting the remainder after dividing the new value by 10.
        for(int j = 0; j < arr.length; j++){
            arr[j] = (arr[j] + 7) % 10;
        }

        //Swap the first digit with the third, and swap the second digit with the fourth.
        swap(arr, 0, 2);
        swap(arr, 1, 3);

        //Return the encrypted integer as a String.
        String encrypted = Arrays.toString(arr);
        return encrypted;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
