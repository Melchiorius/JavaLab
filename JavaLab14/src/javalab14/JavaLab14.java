/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javalab14;

import java.util.Scanner;

/**
 *
 * @author borisost
 */
public class JavaLab14 {

    
    /**
     * Запрашиваем у пользователя натуральное число
     * @return 
     */
    private static int getNaturalNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите натуральных число:");
        try{
            int number = scanner.nextInt();
            if(number < 1){
                throw new java.util.InputMismatchException();
            }
            return number;
        }
        catch(java.util.InputMismatchException e ){
            System.out.print("Ошибка ввода! Будьте внимательнее! ");
            return getNaturalNumber();
        }
    }

    /**
     * Создаем матрицу размера nхn заполненную случайными значениями от min до max;
     * @param n
     * @param min
     * @param max
     * @return 
     */
    private static double[][] createMatrix(int n, int min, int max){
        double[][] matrix = new double[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int value = (int)(min + Math.random()*(max - min));
                matrix[i][j] = value;
                System.out.print(value+"\t");
            }
            System.out.print("\b\n");
        }
        return matrix;
    }
    /**
     * Находим след матрицы
     * @param matrix
     * @return 
     */
    private static double getTrackOfMatrix(double[][] matrix){
        double track = 0;
        for(int i=0;i<matrix.length;i++){
            track += matrix[i][i];
        }
        System.out.println("След матрицы: "+track);
        return track;
    }
    /**
     * Выводим матрицу в командную строку. Матрица не обязана быть квадратной.
     * @param matrix 
     */    
    private static void printMatrix(double[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+"\t");
                
            }
            System.out.print("\b\n");
        }
    }
    
    /**
     * Находим обратную матрицу методом Гауса
     * @param matrix
     * @return 
     */
    public static double[][] invertMatrix(double[][] matrix) {
        int n = matrix.length;
        // Готовим двойную матрицу. Слева (до i == n) - наша исходная матрица,
        // справа (начиная с i==n) - единичная матрица
        double[][] augmentedMatrix = new double[n][2 * n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, augmentedMatrix[i], 0, n);
            augmentedMatrix[i][i + n] = 1;
        }

        // Построчно
        for (int i = 0; i < n; i++) {
            // Находим опорный элемент в строке i
            double pivot = augmentedMatrix[i][i];
            int pivotRow = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(augmentedMatrix[j][i]) > Math.abs(pivot)) {
                    pivot = augmentedMatrix[j][i];
                    pivotRow = j;
                }
            }

            // Если опорный элемент находится не на диагонали матрицы,
            // то меняем местами строки так,
            // чтобы опорный элемент лежал на диагонали матрицы
            if (pivotRow != i) {
                double[] temp = augmentedMatrix[i];
                augmentedMatrix[i] = augmentedMatrix[pivotRow];
                augmentedMatrix[pivotRow] = temp;
            }

            // Делим строку с опорным элементом на значение опорного элемента
            // Тепень опорный элемент лежащий на диагонали равен 1
            for (int j = 0; j < 2 * n; j++) {
                augmentedMatrix[i][j] /= pivot;
            }

            // Вычитаем строку из всех остальных строк
            // factor - число на диагонали в строке из которой вычитаем
            // augmentedMatrix[i][k] - число в исходной строке
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    double factor = augmentedMatrix[j][i];
                    for (int k = 0; k < 2 * n; k++) {
                        augmentedMatrix[j][k] -= factor * augmentedMatrix[i][k];
                    }
                }
            }
        }
        // Левая под-матрица в двойной матрицы стала единичной матрицей
        // Копируем правую под-матрицу из двойной матрицы. Это обратная.
        double[][] inverse = new double[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(augmentedMatrix[i], n, inverse[i], 0, n);
        }

        return inverse;
    }

    
    
    public static void main(String[] args) {
        System.out.print("Укажите размерность матрицы. ");
        double[][] matrix = createMatrix(getNaturalNumber(),0,100);
        getTrackOfMatrix(matrix);
        double[][] inverse = invertMatrix(matrix);
        
        System.out.print("\nОбратная матрица:");
        printMatrix(inverse);
    }
    
}
