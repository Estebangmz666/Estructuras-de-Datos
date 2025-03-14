package estebangmz666.preparcial_1.ej10;

/*Utilizando divide y vencerás realizar la multiplicación de un array de numeros */

public class ArrayMultiplication {
    public static Integer multiplyArray(int[] array) {
        return multiplyArrayHelper(array, 0, array.length - 1);
    }

    public static Integer multiplyArrayHelper(int[] array, int start, int end) {
        if (start == end) {
            return array[start];
        }

        int middle = (start + end) / 2;
        return multiplyArrayHelper(array, start, middle) * multiplyArrayHelper(array, middle + 1, end);
    }
}