package app;

import java.util.Random;

public class MatrixOperations {
    public static void main(String[] args) {
        // Створення та заповнення двовимірного масиву
        int[][] matrix = new int[4][4];
        Random random = new Random();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(50) + 1; // Випадкові числа від 1 до 50
            }
        }

        // Виведення матриці
        System.out.println("Матриця:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%4d", value);
            }
            System.out.println();
        }
    }
}
