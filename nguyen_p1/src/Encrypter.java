public class Encrypter {

    public String encrypt(String input){
        int[] arr = new int[4];

        for(int i = 0; i < 4; i++) {
            char ch = input.charAt(i);
            arr[i] = Character.getNumericValue(ch);
        }

        for(int j = 0; j < 4; j++) {
            arr[j] = (arr[j] + 7) % 10;
        }


        swap(arr, 0, 2);
        swap(arr, 1, 3);


        int returnNum = 0 ;

        for(int e = 0; e < 4; e++){
            returnNum = returnNum * 10 + arr[e];
        }

        String encrypted = Integer.toString(returnNum);

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

