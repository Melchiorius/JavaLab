/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javalab11;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Boris
 */
public class JavaLab11 {

    private static int[] scanNumbers(int n){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите "+n+" натуральных числа:");
        int[] numbers = new int[n];
        try{
            for(int i=0;i<n;i++){
                int number = scanner.nextInt();
                if(number < 1){
                    throw new java.util.InputMismatchException();
                }
                numbers[i] = number;
            }
        }
        catch(java.util.InputMismatchException e ){
            System.out.print("Ошибка ввода! Будьте внимательнее! ");
            return scanNumbers(n);
        }
        Arrays.sort(numbers);
        return numbers;
    }
    public static void main(String[] args) {
        System.out.print("Укажите размеры отверстия. ");
        int[] holeSize = scanNumbers(2);
        System.out.print("Укажите размеры кирпича. ");
        int[] brickSize = scanNumbers(3);
        if(holeSize[0] >= brickSize[0] && holeSize[1] >= brickSize[1]){
            System.out.println("Влезет!");
        }
        else{
            System.out.println("Не влезет!");
        }
    }
    
}
