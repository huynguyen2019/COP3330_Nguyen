public class Encrypter {

    //instance method called `encrypt` that accepts a String of 4 digits representing a single integer
    public String encrypt(String input){
        int[] arr = new int[4];

        for(int i = 0; i < 4; i++) {
            char ch = input.charAt(i);
            arr[i] = Character.getNumericValue(ch);
        }
        //Replace each digit with the result of adding 7 to the digit and
        // getting the remainder after dividing the new value by 10.
        for(int j = 0; j < 4; j++) {
            arr[j] = (arr[j] + 7) % 10;
        }

        //Swap the first digit with the third, and swap the second digit with the fourth.
        swap(arr, 0, 2);
        swap(arr, 1, 3);

        //Return the encrypted integer as a String.
        int returnNum = 0 ;

        for(int e = 0; e < 4; e++){
            returnNum = returnNum * 10 + arr[e];
        }

        String encrypted = Integer.toString(returnNum);

        //In case the result starts with leading zero
        if(arr[0] == 0){
            encrypted = "0" + encrypted;
        }

        return encrypted;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

