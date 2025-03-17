import java.util.Arrays;

public class AddArrayElements {
    public static void main(String[]args){
        int[] arrOne = {2, 10, 3};
        int[] arrTwo = {5, 6, 4};
        //Same Length

        System.out.println(Arrays.toString(add(arrOne, arrTwo)));

        arrOne = new int[]{1, 7, 3};
        arrTwo = new int[]{5, 2, 4, 4};
        //arrTwo is longer

        System.out.println(Arrays.toString(add(arrOne, arrTwo)));

        arrOne = new int[]{1, 7, 3, 8};
        arrTwo = new int[]{5, 2, 4};
        //arrOne is longer

        System.out.println(Arrays.toString(add(arrOne, arrTwo)));
    }

    private static int[] add(int[] arrOne, int[] arrTwo){
        int[] result = new int[Math.max(arrOne.length, arrTwo.length)];

        //Add elements from each array to index until the shortest array's final index has been reached.
        for(int i = 0; i < Math.min(arrOne.length, arrTwo.length); i++){
            result[i] = arrOne[i] + arrTwo[i];
        }

        //Add any remaining elements from the array with a longer length.
        if(arrOne.length < arrTwo.length){
            for(int i = arrOne.length; i < arrTwo.length; i++){
                result[i] = arrTwo[i];
            }
            return result;
        }

        for(int i = arrTwo.length; i < arrOne.length; i++){
            result[i] = arrOne[i];
        }
        return result;
    }

    private static int[] addMod10(int[] arrOne, int[] arrTwo){
        int[] result = add(arrOne, arrTwo);

        //Optional for making each element have a one digit element. Does not work properly if the last digit is >= 10.
        int val = 0;
        for(int i = 0; i < result.length - 1; i++){
            if(result[i] >= 10){
                val = result[i] / 10;
                result[i] %= 10;
                result[i + 1] += val;
            }
        }
        return result;
    }
}
