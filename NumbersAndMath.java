import static java.lang.System.nanoTime;
import static org.junit.Assert.assertEquals;

public class NumbersAndMath {
    public static void main(String[]args){
        long time;

        for(int i = 0; i <= 128; i++){
            time = nanoTime();
            //System.out.println("Digits in " + i + ": " + getDigitCount(i));
            //System.out.println("Time: " + (nanoTime() - time));
            assertEquals(("" + i).length(), getDigitCount(i));

            time = nanoTime();
            System.out.println("\nDigits in " + Integer.toBinaryString(i) + ": " + getBinaryDigitCount(i));
            System.out.println(nanoTime() - time);
            assertEquals(Integer.toBinaryString(i).length(), getBinaryDigitCount(i));
        }

        int testNum = 1234567890;
        int digits = getDigitCount(testNum);

        for(int i = 1; i <= digits + 1; i++){
            System.out.println(addCommasToInt(testNum));
            System.out.println(addCommasToInt(-testNum));
            testNum /= 10;
        }
    }

    public static int getDigitCount(int num){
        if(num == 0) return 1;

        return (int)Math.log10(Math.abs(num)) + 1;
    }

    public static int getBinaryDigitCount(int num){
        if(num == 0) return 1;

        int count = 0;

        while(num > 0){
            num /= 2;
            count++;
        }
        return count;
    }

    public static String addCommasToInt(int num){
        StringBuilder sb = new StringBuilder();
        if(num < 0) sb.append("-");

        num = Math.abs(num);
        String numAsStr = "" + num;
        int len = numAsStr.length();

        for(int i = 0; i < len; i++){
            if((len - i) % 3 == 0 && i > 0){
                sb.append(",");
            }
            sb.append(numAsStr.charAt(i));
        }
        return sb.toString();
    }

    public static String toStr(long num){
        return "" + num;
    }
}