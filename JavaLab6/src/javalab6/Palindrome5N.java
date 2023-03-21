/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javalab6;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Boris
 */
public class Palindrome5N implements IPalindrome {
    private int readNumber5N(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое пятизначное число:");
        try{
            int number = scanner.nextInt();
            if(number < 10000 || number > 99999){
                throw new InputMismatchException();
            }
            return number;
        }
        catch(InputMismatchException e){
            System.out.print("Будьте внимательнее. ");
            return readNumber5N();
        }
    }
    
    private int[] intToArray5N(int number){
        int[] array = new int[5];
        int index = 5;
        while(index>0){
            index--;
            array[index] = number%10;
            number /= 10;
        }
        return array;
    }
    
    public void palindrome(){
        Scanner scanner = new Scanner(System.in);
        int number = readNumber5N();
        int[] array = intToArray5N(number);
        for(int i=0;i<array.length/2;i++){
            int j = array.length-1 - i;
            if(array[i] != array[j]){
                System.out.println("Число "+number+" не является палиндромом!");
                return;
            }
        }
        System.out.println("Число "+number+" - это палиндром!");
    }
}
