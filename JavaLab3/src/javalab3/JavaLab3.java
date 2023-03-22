/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javalab3;

/**
 *
 * @author borisost
 */
public class JavaLab3 {

    
    private static void print(char from, char to){
        for(int i=from;i<=to;i++){
            System.out.print((char)i);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        print('A','Z');
        print('a','z');
        System.out.println();
        print('А','Я');
        print('а','я');
    }
    
}
