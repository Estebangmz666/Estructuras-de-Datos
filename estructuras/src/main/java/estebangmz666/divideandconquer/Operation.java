package estebangmz666.divideandconquer;

public class Operation {
    public static int binarySearch(int[] array, int numberToSearch) {
        return binarySearch(array, numberToSearch, 0, array.length - 1);
    }

    private static int binarySearch(int[] array, int numberToSearch, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (array[mid] == numberToSearch) {
            return mid;
        } else if (array[mid] < numberToSearch) {
            return binarySearch(array, numberToSearch, mid + 1, right);
        } else {
            return binarySearch(array, numberToSearch, left, mid - 1);
        }
    }
}