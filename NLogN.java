import java.util.Arrays;

public class NLogN{
    //Initial set-up. This is here simply to print the initial array, as well as to
    //confirm that the array is sorted after the algorithm has finished execution.
    public static void quick(int[] arr){
        System.out.println("Initial: " + Arrays.toString(arr));


        System.out.println("Sorted? " + HelperClass.isSorted(arr));
    }

    private static void quickAlgo(int[] arr, int iteration, int pivotLow,int pivotHigh){
        System.out.println("Iter " + iteration + " " + Arrays.toString(arr));

    }

    public static void merge(int[] arr){
        System.out.println("Initial: " + Arrays.toString(arr));

        mergeAlgo(arr, 1);
        System.out.println("Sorted? " + HelperClass.isSorted(arr));
    }

    private static void mergeAlgo(int[] arr, int iteration){
        System.out.println("Iter " + iteration + " " + Arrays.toString(arr));
    }

    public static void tim(int[] arr){
        System.out.println("Initial: " + Arrays.toString(arr));
        int len = arr.length;

        System.out.println("Sorted? " + HelperClass.isSorted(arr));
    }

    public static void heap(int[] arr){
        System.out.println("Initial: " + Arrays.toString(arr));
        int len = arr.length;

        System.out.println("Sorted? " + HelperClass.isSorted(arr));
    }

    public static void tree(int[] arr){
        System.out.println("Initial: " + Arrays.toString(arr));
        int len = arr.length;

        System.out.println("Sorted? " + HelperClass.isSorted(arr));
    }

    public static void cube(int[] arr){
        System.out.println("Initial: " + Arrays.toString(arr));
        int len = arr.length;

        System.out.println("Sorted? " + HelperClass.isSorted(arr));
    }
}
