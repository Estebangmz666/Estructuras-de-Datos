package estebangmz666.divideandconquer;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int numberToSearch = 5;
        System.out.println("El número " + numberToSearch + " se encuentra en la posición: " + Operation.binarySearch(array, numberToSearch));
    }
}