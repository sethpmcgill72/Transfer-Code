import java.util.ArrayList;
import static java.lang.System.currentTimeMillis;
import static java.lang.System.nanoTime;

public class PrimeNumbers {
    public static void main(String[]args){
        int[] cases = {1, 2, 3, 4, 5, 23, 51, 100, 1087, 1088, 1089, 1090, 1091, 1092,
                1093, 1094, 1095, 1096, 1097, 1098, 1099, 1110, 2103, 2131, 2909, 4073,
                5099, 7919, 27644437, 479001593, 479001599, Integer.MAX_VALUE};
        int val;
        long time;
        boolean[] primes;

        for(int i = 0; i < cases.length; i++){
            val = cases[i];

            System.out.println("Val = " + val);
            time = nanoTime();
            System.out.println("Naive: " + isPrimeNaive(val));
            System.out.println("Time: " + (nanoTime() - time) + "ns");


            time = nanoTime();
            System.out.println("Sieve: ");
            primes = primeSieve(val);
            System.out.println("Time: " + (nanoTime() - time) + "ns");

            if(cases[i] <= 10_000){
                //System.out.println(Arrays.toString(primes));
                System.out.println("Sieve Output: " + getPrimesFromBool(primes) + "\n");
            }

            else{
                System.out.println();
            }
        }
        System.out.println("NOTE: For test cases with a value > 10,000, results are not printed." +
                "This is to avoid having the console filled with rows of numbers, making it difficult" +
                "to find ");
    }

    //Determines if a given number, num, is prime.
    //Efficient if num is less <= 2 or even and somewhat efficient
    //if num is not prime, but inefficient if num is prime.
    public static boolean isPrimeNaive(int num){
        if(num < 2){
            //Negative numbers, 0 and 1. These values are neither prime nor composite...
            //The proper return statement may be confusing, but this function only determines
            //the primality of a number, and isPrime(x) -> false does not necessarily mean that
            //x is a composite number.
            return false;
        }

        if(num != 2 && num % 2 == 0){
            return false;
        }

        for(int i = 3; i < num / 2; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    //Not for determining if a given number is prime, but rather giving a list of primes from 2 to num, inclusive.
    //This breaks when num is exceptionally large, since creating an array with, say, (2^31)-1
    //values takes up a load of memory (OutOfMemoryError). Aside from this, this function works.
    public static boolean[] primeSieve(int num) throws RuntimeException{
        if(num < 2){//Numbers below 2 are not prime(nor composite, for that matter).
            return new boolean[]{};
        }

        boolean[] primes; //0 to num, inclusive.

        if(num == Integer.MAX_VALUE){
            throw new OutOfMemoryError("Exceptionally large value would result in an error " +
                    "(improve this message and error type, this sucks)");
        }

        else{
            primes = new boolean[num + 1];
        }

        //start at index 2 to avoid setting 0 and 1 indexes, which,
        //of course, represent 0 and 1, to true, since these are not prime.
        for(int i = 2; i < primes.length; i++){
            primes[i] = true;
        }
        //i <= num / 2 because if num = 5, 5 / 2 = 2 (cast to int) with i < num / 2, no iterations would occur.
        //Do NOT use i * i, because int (and even long) overflow can occur. i + i will not result in overflow due
        //to i's limit being num / 2 (inclusive), so even if num is the integer limit, this will never be exceeded.
        for(int i = 2; i <= num / 2; i++){
            if(primes[i]){//If multiples of i have not been checked
                for(int j = i + i; j <= num; j += i){
                    primes[j] = false;
                }
            }
        }
        return primes;
    }

    public static ArrayList<Integer> getPrimesFromNum(int num){
        boolean[] primes = primeSieve(num);
        ArrayList<Integer> primeList = new ArrayList<>();

        for(int i = 2; i < primes.length; i++){
            if(!primes[i]){
                primeList.add(i);
            }
        }

        return primeList;
    }

    public static ArrayList<Integer> getPrimesFromBool(boolean[] primes){
        ArrayList<Integer> primeList = new ArrayList<>();

        for(int i = 2; i < primes.length; i++){
            if(primes[i]){
                primeList.add(i);
            }
        }

        return primeList;
    }
}