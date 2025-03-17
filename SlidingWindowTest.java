import static java.lang.System.nanoTime;

public class SlidingWindowTest {
    public static void main(String[]args){
        int[] arr = {1,12,-5,-6,50,3};
        long time;

        time = nanoTime();
        System.out.println(maxSubArray(arr, 4));
        System.out.println(nanoTime() - time);

        time = nanoTime();
        System.out.println(mySolution(arr, 4));
        System.out.println(nanoTime() - time);

        time = nanoTime();
        System.out.println(secondSolution(arr, 4));
        System.out.println(nanoTime() - time);
    }

    //All methods find the sub array with k values with the largest average.
    public static double maxSubArray(int[] arr, int k){
        double maxSum = 0;

        for(int i = 0; i < k; i++){//get first k values, and set up window from 0 to k, not inclusive.
            maxSum += arr[i];
        }

        int currSum = (int)maxSum;
        for(int i = k; i < arr.length; i++){
            currSum += arr[i] - arr[i - k];//subtract
            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum / k;
    }

    public static double mySolution(int[] nums, int k){
        if(nums.length == 1){
            return nums[0];
        }

        double maxSum = Integer.MIN_VALUE;
        int currSum;
        int left = 0;
        int right = k;

        while(right <= nums.length){
            currSum = 0;
            for(int i = left; i < right; i++){
                currSum += nums[i];
            }

            maxSum = Math.max(currSum, maxSum);
            left++;
            right++;
        }

        return maxSum / k;
    }

    private static double secondSolution(int[] nums, int k){
        int currSum = 0;

        for(int i = 0; i < k; i++){//Add the first k - 1 values to currSum;
            currSum += nums[i];
        }
        double maxSum = currSum;

        for(int i = k; i < nums.length; i++){
            currSum += nums[i] - nums[i - k]; //currSum = the next pair of k nums. subtract the leftmost value, and add the next rightmost element.
            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum / k; //average of the largest set of k consecutive numbers.
    }
}