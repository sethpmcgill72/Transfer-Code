public class MiscSorting {
    public static void main(String[]args){

    }

    public static int[] sort(int[] arr1, int[] arr2) { //combines two SORTED arrays into one
        int len1 = arr1.length - 1; //reference to arr1 length
        int len2 = arr2.length - 1; //reference to arr2 length
        int[] arr3 = new int[len1 + len2 + 2]; //combined array to be returned
        int len3 = arr3.length - 1;

        while (len1 >= 0 && len2 >= 0) {
            if (arr1[len1] > arr2[len2]) {
                arr3[len3] = arr1[len1];
                len1--;
                len3--;
            }

            else if (arr1[len1] == arr2[len2]) {
                arr3[len3] = arr1[len1];
                len1--;
                len3--;

                arr3[len3] = arr2[len2];
                len2--;
                len3--;
            }

            else {
                arr3[len3] = arr2[len2];
                len2--;
                len3--;
            }
        }

        while(len1 >= 0){
            arr3[len3] = arr1[len1];
            len1--;
            len3--;
        }

        while(len2 >= 0){
            arr3[len3] = arr2[len2];
            len2--;
            len3--;
        }

        return arr3;
    }
}
