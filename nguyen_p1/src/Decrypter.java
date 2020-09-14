public class Decrypter {
    public String decrypt(String input){
        int[] arr = new int[4];

        for(int i = 0; i < 4; i++) {
            char ch = input.charAt(i);
            arr[i] = Character.getNumericValue(ch);
        }

        swap(arr, 0, 2);
        swap(arr, 1, 3);

        //how this works: as the encrypt math is inverted, the result for a digit will be negative
        //if so, plus 10 to get the right number wanted
        for(int j = 0; j < 4; j++) {
            arr[j] = arr[j] - 7;
            if(arr[j] < 0){
                arr[j] += 10;
            }
        }
        int returnNum = 0 ;

        for(int k = 0; k < 4; k++){
            returnNum = returnNum * 10 + arr[k];
        }

        String decrypted = Integer.toString(returnNum);

        if(arr[0] == 0){
            decrypted = "0" + decrypted;
        }

        return decrypted;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

