import java.util.Random;

public class lab2 {

    public static void main(String[] args) {
        try {
            int rows = 5;
            int cols = 5;
            char[][] A = generateMatrix(rows, cols);
            char[][] B = generateMatrix(rows, cols);
            char[][] C = addMatrices(A, B);
            printMatrix(C);

            int evenSum = sumMaxInEvenRows(C);
            int oddSum = sumMinInOddRows(C);
            System.out.println("Сума найбільших елементів в рядках матриці з парними номерами: " + evenSum);
            System.out.println("Сума найменших елементів в рядках матриці з непарними номерами: " + oddSum);
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    private static char[][] generateMatrix(int rows, int cols) {
        Random random = new Random();
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (char) (random.nextInt(26) + 'a'); // генеруємо випадкові букви
            }
        }
        return matrix;
    }

    private static char[][] addMatrices(char[][] A, char[][] B) throws Exception {
        if (A.length != B.length || A[0].length != B[0].length) {
            throw new Exception("Матриці мають різні розміри");
        }
        int rows = A.length;
        int cols = A[0].length;
        char[][] C = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                C[i][j] = (char) (A[i][j] + B[i][j]); // додаємо відповідні елементи матриць A та B
            }
        }
        return C;
    }

    private static int sumMaxInEvenRows(char[][] matrix) {
        int sum = 0;
        for (int i = 1; i < matrix.length; i += 2) {
            int max = matrix[i][0];
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
            sum += max;
        }
        return sum;
    }

    private static int sumMinInOddRows(char[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i += 2) {
            int min = matrix[i][0];
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
            sum += min;
        }
        return sum;
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}