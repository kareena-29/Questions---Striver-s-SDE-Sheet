package Day_1;

public class Set_Matrix_Zeros {
    public static void setZeros(int matrix[][]) {
        int col0 = 0;
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0)
                col0 = 1;
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 1)
                matrix[i][0] = 0;
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 0, 5}, {7, 8, 9}};
        setZeros(matrix);
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}