package estebangmz666.preparcial_1.ej8;

public class Main{
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {10, 11, 12}
        };

        int[][] transposed = TransposedMatrix.recursiveTransposeMatrix(matrix);

        System.out.println("Original matrix:");
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        
        System.out.println("Transposed matrix:");
        for (int[] row : transposed) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}