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

        // Знаходження сум для парних і непарних рядків
        int evenRowSum = 0;
        int oddRowSum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i % 2 == 0) {
                    evenRowSum += matrix[i][j];
                } else {
                    oddRowSum += matrix[i][j];
                }
            }
        }

        System.out.println("Сума елементів у парних рядках (рядок 0, 2): " + evenRowSum);
        System.out.println("Сума елементів у непарних рядках (рядок 1, 3): " + oddRowSum);

        // Знаходження добутків для парних і непарних стовпців
        long evenColumnProduct = 1;
        long oddColumnProduct = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j % 2 == 0) {
                    evenColumnProduct *= matrix[i][j];
                } else {
                    oddColumnProduct *= matrix[i][j];
                }
            }
        }

        System.out.println("Добуток елементів у парних стовпцях (стовпець 0, 2): " + evenColumnProduct);
        System.out.println("Добуток елементів у непарних стовпцях (стовпець 1, 3): " + oddColumnProduct);

        // Перевірка, чи є матриця магічним квадратом
        boolean isMagicSquare = isMagic(matrix);
        System.out.println("Матриця " + (isMagicSquare ? "є магічним квадратом." : "не є магічним квадратом."));
    }

    private static boolean isMagic(int[][] matrix) {
        int size = matrix.length;
        int magicSum = 0;

        // Знаходимо суму першого рядка як еталонну
        for (int j = 0; j < size; j++) {
            magicSum += matrix[0][j];
        }

        // Перевіряємо суми рядків
        for (int i = 0; i < size; i++) {
            int rowSum = 0;
            for (int j = 0; j < size; j++) {
                rowSum += matrix[i][j];
            }
            if (rowSum != magicSum) {
                return false;
            }
        }

        // Перевіряємо суми стовпців
        for (int j = 0; j < size; j++) {
            int colSum = 0;
            for (int i = 0; i < size; i++) {
                colSum += matrix[i][j];
            }
            if (colSum != magicSum) {
                return false;
            }
        }

        // Перевіряємо суми діагоналей
        int mainDiagonalSum = 0;
        int secondaryDiagonalSum = 0;
        for (int i = 0; i < size; i++) {
            mainDiagonalSum += matrix[i][i];
            secondaryDiagonalSum += matrix[i][size - 1 - i];
        }

        return mainDiagonalSum == magicSum && secondaryDiagonalSum == magicSum;
    }
}
