/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javalab12;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Boris
 */
public class JavaLab12 {

    private static int scanNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое положительное число:");
        try{
            int number = scanner.nextInt();
            if(number < 1){
                throw new java.util.InputMismatchException();
            }
            return number;
        }
        catch(java.util.InputMismatchException e ){
            System.out.print("Ошибка ввода! Будьте внимательнее! ");
            return scanNumber();
        }
    }
    
    public static void main(String[] args) {
        int max = scanNumber();
        BigInteger fib0 = new BigInteger("1");
        BigInteger fib1 = new BigInteger("1");
        System.out.println("Fib0 = 1\nFib1 = 1");
        for(int i=1;i<max;i++){
            BigInteger newFib = fib0.add(fib1);
            fib0 = fib1;
            fib1 = newFib;
            System.out.println("Fib"+(i+1)+" = "+fib1);
        }
        
    }
    
}
