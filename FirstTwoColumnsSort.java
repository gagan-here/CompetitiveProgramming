import java.util.Arrays;

//Java Program to Sort first two colimns of a 2D array

public class FirstTwoColumnsSort {

    public static void main(String[] args) {

        int[][] arr = {
            {7, 2, 0, 5, 1},
            {3, 8, 2, 9, 14},
            {5, 1, 0, 5, 2},
            {4, 2, 6, 0, 1}
        };

        System.out.println("Matrix without sorting \n");
        printMatrix(arr);

        int rows = arr.length;
        int cols = 2;  // Sort only the first two columns

        for (int i = 0; i < cols; i++) {
            int[] column = new int[rows];
            for (int j = 0; j < rows; j++) {
                column[j] = arr[j][i];
            }
            Arrays.sort(column);
            for (int j = 0; j < rows; j++) {
                arr[j][i] = column[j];
            }
        }

        System.out.println("Matrix after sorting first two columns \n");
        printMatrix(arr);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

}
