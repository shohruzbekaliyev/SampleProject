public class BinarySearch {

    public static boolean binarySearch(final int[] array, final int search) {
        int first = 0;
        int last = array.length - 1;
        int middle = (first + last) / 2;
        while (first <= last) {
            if (array[middle] < search) {
                first = middle + 1;
            } else if (array[middle] == search) {
                return true;
            } else {
                last = middle - 1;
            }
            middle = (first + last) / 2;
        }
        return false;
    }

}
