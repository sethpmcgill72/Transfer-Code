import java.util.Arrays;

public class NPlusKNTimesK {
    public static void bucket(int[] arr){
        System.out.println("Initial: " + Arrays.toString(arr));
        int len = arr.length;

        System.out.println("Sorted? " + HelperClass.isSorted(arr));
    }

    public static void radix(int[] arr){
        System.out.println("Initial: " + Arrays.toString(arr));
        int len = arr.length;

        System.out.println("Sorted? " + HelperClass.isSorted(arr));
    }

    public static void counting(int[] arr){
        System.out.println("Initial: " + Arrays.toString(arr));
        int len = arr.length;

        System.out.println("Sorted? " + HelperClass.isSorted(arr));
    }
}