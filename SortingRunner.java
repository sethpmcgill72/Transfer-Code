//Classes are based upon AVERAGE-CASE time complexity.
//Tests are ordered from slowest(average) to fastest.
//Space complexity is not considered.
import static java.lang.System.currentTimeMillis;
import static java.lang.System.nanoTime;

public class SortingRunner {
    public static void main(String[] args){
        long time;
        System.out.println("N^2:");

        System.out.println("Selection:");
        time = currentTimeMillis();
        NRaisedToTwo.select(fillRandom());
        System.out.println("Time: " +(currentTimeMillis() - time) + "ms");

        System.out.println("\nInsertion:");
        time = currentTimeMillis();
        NRaisedToTwo.insert(fillRandom());
        System.out.println("Time: " +(currentTimeMillis() - time) + "ms");

        System.out.println("\nBubble:");
        time = currentTimeMillis();
        NRaisedToTwo.bubble(fillRandom());
        System.out.println("Time: " +(currentTimeMillis() - time) + "ms");

        System.out.println("\nShell:");
        time = currentTimeMillis();
        NRaisedToTwo.shell(fillRandom());
        System.out.println("Time: " + (currentTimeMillis() - time) + "ms");

        //---------------------------//

        System.out.println("\nN*LOG(N):");

        System.out.println("Quick:");
        time = currentTimeMillis();
        NLogN.quick(fillRandom());
        System.out.println("Time: " +(currentTimeMillis() - time) + "ms");

        System.out.println("\nMerge:");
        time = currentTimeMillis();
        NLogN.merge(fillRandom());
        System.out.println("Time: " +(currentTimeMillis() - time) + "ms");

        System.out.println("\nTim:");
        time = currentTimeMillis();
        NLogN.tim(fillRandom());
        System.out.println("Time: " +(currentTimeMillis() - time) + "ms");

        System.out.println("\nHeap");
        time = currentTimeMillis();
        NLogN.heap(fillRandom());
        System.out.println("Time: " +(currentTimeMillis() - time) + "ms");

        System.out.println("\nTree:");
        time = currentTimeMillis();
        NLogN.tree(fillRandom());
        System.out.println("Time: " +(currentTimeMillis() - time) + "ms");

        System.out.println("\nCube:");
        time = currentTimeMillis();
        NLogN.cube(fillRandom());
        System.out.println("Time: " +(currentTimeMillis() - time) + "ms");

        //---------------------------//

        System.out.println("\nN+K OR N*K:");

        System.out.println("Bucket:");
        time = currentTimeMillis();
        NPlusKNTimesK.bucket(fillRandom());
        System.out.println("Time: " + (currentTimeMillis() - time) + "ms");

        System.out.println("\nRadix:");
        time = currentTimeMillis();
        NPlusKNTimesK.radix(fillRandom());
        System.out.println("Time: " + (currentTimeMillis() - time) + "ms");

        System.out.println("\nCounting:");
        time = currentTimeMillis();
        NPlusKNTimesK.counting(fillPositive());
        System.out.println("Time: " + (currentTimeMillis() - time) + "ms");

        //---------------------------//

        System.out.println("\nTHE SUPREME BOGO SORT");
        time = currentTimeMillis();
        NRaisedToTwo.bogo(fillRandom());
        System.out.println("Time: " + (currentTimeMillis() - time) + "ms");

        System.out.println("BOGO Sort time complexity averages O(n*n!), with the worst case being O(infinity)," +
            "and the best case being 0(n) if the array is sorted on the first iteration. Truly a sorting algorithm.");
    }

    public static int[] fillRandom(){
        int[] arr = new int[10];

        for(int i = 0; i < 10; i++){
            arr[i] = (int)(Math.random() * 100 - 50);
        }
        return arr;
    }
    public static int[] fillRandomLen(int len){
        int[] arr = new int[len];

        for(int i = 0; i < len; i++){
            arr[i] = (int)(Math.random() * 100 - 50);
        }
        return arr;
    }

    public static int[] fillPositive(){
        int [] arr = new int[10];

        for(int i = 0; i < 10; i++){
            arr[i] = (int)(Math.random() * 50);
        }
        return arr;
    }
}