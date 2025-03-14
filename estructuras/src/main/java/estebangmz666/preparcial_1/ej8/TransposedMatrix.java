package estebangmz666.preparcial_1.ej8;

/*Escriba un método recursivo que retorne la matriz transpuesta de una matriz de tamaño mxn.*/

public class TransposedMatrix {
    public static int[][] recursiveTransposeMatrix(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        transposeHelper(matrix, result, 0, 0);
        return result;
    }

    private static void transposeHelper(int[][] matrix, int[][] result, int i, int j){
        if (i >= matrix.length) {
            return;
        }
        result[j][i] = matrix[i][j];
        if (j + 1 < matrix[0].length) {
            transposeHelper(matrix, result, i, j + 1);
        } else {
            transposeHelper(matrix, result, i + 1, 0);
        }
    }
}    