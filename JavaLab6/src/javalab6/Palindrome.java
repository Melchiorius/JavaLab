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
public class Palindrome implements IPalindrome {
    private long readNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число:");
        try{
            return scanner.nextLong();
        }
        catch(InputMismatchException e){
            System.out.print("Будьте внимательнее. ");
            return readNumber();
        }
    }
    
    private int[] addValueToArray(int[] array, int value){
        int[] copy = new int[array.length+1];
        System.arraycopy(array, 0, copy, 1, array.length);
        copy[0] = value;
        return copy;
    }
    
    private int[] NumberToArray(long number){
        int[] array = new int[0];
        int index = 0;
        while(number>0){
            array = addValueToArray(array,(int)(number%10));
            number /= 10;
        }
        return array;
    }
    
    public void palindrome(){
        long number = readNumber();
        int[] array = NumberToArray(number);
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
