package javaPractice.algo.sort;

/**
 * Created by Santosh on 5/25/17.
 */
public class BinarySearchTest {

    public static boolean searchKey(int[] intArray, int element) {

        int low = 0;
        int high = intArray.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            if (element > intArray[middle]) {
                low = middle + 1;
            } else if (element < intArray[middle]) {
                high = middle - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {

        int[] intArray = { 2, 4, 5, 8, 9, 22, 44, 55, 66, 88, 100 };

        int element = 44;

        boolean result = searchKey(intArray, element);

        if (result) {
            System.out.println("The element found in the Array");
        } else {
            System.out.println("The element is not found in the Array");
        }

    }
}
