package yehor.lab2;

import java.util.Random;
import java.util.Scanner;

/**
 * Лабораторна робота №2. Створення матриці цілих чисел (з клавіатури або випадково)
 * та обчислення її характеристик.
 */
public class MatrixApp {

    private static final int MAX_DIMENSION = 20;
    private static final int MIN_RANDOM_VALUE = 1;
    private static final int MAX_RANDOM_VALUE = 70;

    private static final int KEYBOARD_FILL = 1;
    private static final int RANDOM_FILL = 2;

    private static final Scanner INPUT = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        System.out.println("Матриця цілих чисел (максимальний розмір " + MAX_DIMENSION + "x" + MAX_DIMENSION + ")");
        int rows = askNumber("Кількість рядків (висота) від 1 до " + MAX_DIMENSION + ": ",
                1, MAX_DIMENSION);
        int columns = askNumber("Кількість стовпців (ширина) від 1 до " + MAX_DIMENSION + ": ",
                1, MAX_DIMENSION);

        int[][] matrix = chooseFillMode() == KEYBOARD_FILL
                ? fillFromKeyboard(rows, columns)
                : fillRandomly(rows, columns);

        printMatrix(matrix);
        printResults(matrix);
    }

    private static int chooseFillMode() {
        System.out.println("Спосіб заповнення матриці:");
        System.out.println("  " + KEYBOARD_FILL + ") ввести елементи з клавіатури");
        System.out.println("  " + RANDOM_FILL + ") згенерувати випадкові числа від "
                + MIN_RANDOM_VALUE + " до " + MAX_RANDOM_VALUE);
        return askNumber("Ваш вибір: ", KEYBOARD_FILL, RANDOM_FILL);
    }

    private static int[][] fillFromKeyboard(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        System.out.println("Введіть елементи матриці по рядках, числа через пробіл.");
        for (int i = 0; i < rows; i++) {
            matrix[i] = askRow(i + 1, columns);
        }
        return matrix;
    }

    private static int[] askRow(int rowNumber, int columns) {
        while (true) {
            System.out.print("Рядок " + rowNumber + " (елементів: " + columns + "): ");
            String[] parts = INPUT.nextLine().trim().split("\\s+");
            if (parts.length != columns) {
                System.out.println("  Помилка: кількість елементів у рядку має дорівнювати " + columns + ".");
                continue;
            }
            try {
                int[] row = new int[columns];
                for (int j = 0; j < columns; j++) {
                    row[j] = Integer.parseInt(parts[j]);
                }
                return row;
            } catch (NumberFormatException e) {
                System.out.println("  Помилка: рядок містить не ціле число.");
            }
        }
    }

    private static int[][] fillRandomly(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = RANDOM.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE + 1);
            }
        }
        return matrix;
    }

    private static int askNumber(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String line = INPUT.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("  Помилка: число повинно бути в межах [" + min + "; " + max + "].");
            } catch (NumberFormatException e) {
                System.out.println("  Помилка: \"" + line + "\" не є цілим числом.");
            }
        }
    }

    private static int findMin(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            for (int value : row) {
                min = Math.min(min, value);
            }
        }
        return min;
    }

    private static int findMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            for (int value : row) {
                max = Math.max(max, value);
            }
        }
        return max;
    }

    private static double arithmeticMean(int[][] matrix) {
        long sum = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                sum += value;
            }
        }
        return (double) sum / countElements(matrix);
    }

    /**
     * Середнє геометричне визначене лише для додатних чисел. Щоб уникнути переповнення
     * добутку, використовується сума логарифмів: G = e^((ln a1 + ... + ln an) / n).
     *
     * @return середнє геометричне або -1, якщо в матриці є нулі чи від'ємні числа
     */
    private static double geometricMean(int[][] matrix) {
        double logarithmSum = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                if (value <= 0) {
                    return -1;
                }
                logarithmSum += Math.log(value);
            }
        }
        return Math.exp(logarithmSum / countElements(matrix));
    }

    private static int countElements(int[][] matrix) {
        return matrix.length * matrix[0].length;
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println();
        System.out.println("Матриця " + matrix.length + "x" + matrix[0].length + ":");
        for (int[] row : matrix) {
            StringBuilder line = new StringBuilder("|");
            for (int value : row) {
                line.append(String.format("%5d", value));
            }
            System.out.println(line.append(" |"));
        }
    }

    private static void printResults(int[][] matrix) {
        System.out.println();
        System.out.println("Мінімум:              " + findMin(matrix));
        System.out.println("Максимум:             " + findMax(matrix));
        System.out.printf("Середнє арифметичне:  %.3f%n", arithmeticMean(matrix));
        double geometric = geometricMean(matrix);
        if (geometric < 0) {
            System.out.println("Середнє геометричне:  неможливо обчислити "
                    + "(у матриці є нулі або від'ємні числа)");
        } else {
            System.out.printf("Середнє геометричне:  %.3f%n", geometric);
        }
    }
}
