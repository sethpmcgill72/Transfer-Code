import java.util.Arrays;

public class NRaisedToTwo{//N^2 or higher time complexity. CLASS IS COMPLETE, EXCEPT FOR BOGO
    public static void select(int[] arr){//SPACE: O(1). COMPLETE.
        System.out.println("Initial: " + Arrays.toString(arr));
        int len = arr.length;
        int minIndex;
        int temp;

        for(int i = 0; i < len - 1; i++){
            minIndex = i; //assign minIndex to i, the current index

            for(int j = i + 1; j < len; j++){//for every value after i.
                if(arr[j] < arr[minIndex]){//go through the array and find the smallest value, then assign its index to minIndex.
                    minIndex = j;
                }
            }

            temp = arr[minIndex];
            arr[minIndex] = arr[i]; //swap values
            arr[i] = temp; //ith index = the value at the minimum index.

            System.out.println("Iter " + (i + 1) + " " + Arrays.toString(arr));
        }
        System.out.println("Sorted? " + HelperClass.isSorted(arr));
    }

    public static void insert(int[] arr){//SPACE: O(1). COMPLETE.
        System.out.println("Initial: " + Arrays.toString(arr));
        int len = arr.length;
        int temp;

        for(int i = 1; i < len; i++){
            temp = arr[i];
            int j = i; //var for the while loop.

            while(j > 0 && temp < arr[j - 1]){//working backwards, so j cannot be index 0 (also the reason why j is being decremented).
                arr[j] = arr[j - 1]; //swap j and j-1
                j--; //decrement j
            }
            arr[j] = temp;

            System.out.println("Iter " + (i) + " " + Arrays.toString(arr));
        }
        System.out.println("Sorted? " + HelperClass.isSorted(arr));
    }

    public static void bubble(int[] arr){//SPACE: O(1). COMPLETE.
        System.out.println("Initial: " + Arrays.toString(arr));
        int len = arr.length;
        int val;
        boolean swappedPairs; //checks if a pair is swapped in a given iteration (i.e. already sorted).
        // prevents algorithm from running when array is already sorted, causing extra runtime.

        for(int i = 0; i < len - 1; i++){//swaps pairs until array is sorted.
            swappedPairs = false;
            for(int j = 0; j < len - 1; j++){//iterate over array.
                if(arr[j] > arr[j + 1]){//if a pair is not sorted, swap them.
                    val = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = val;
                    swappedPairs = true;
                }
            }

            System.out.println("Iter " + (i + 1) + " " + Arrays.toString(arr));

            if(!swappedPairs){//see swappedPairs declaration
                break;
            }
        }

        System.out.println("Sorted? " + HelperClass.isSorted(arr));
    }

    public static void shell(int[] arr){
        System.out.println("Initial: " + Arrays.toString(arr));
        int len = arr.length;

        System.out.println("Sorted? " + HelperClass.isSorted(arr));
    }

    public static void bogo(int[] arr){//SPACE: O(1)... at least it has that going for it...
        System.out.println("Initial: " + Arrays.toString(arr));
        int len = arr.length;

        while(!HelperClass.isSorted(arr)){
            break;
        }

        System.out.println("Sorted? " + HelperClass.isSorted(arr));
    }
}