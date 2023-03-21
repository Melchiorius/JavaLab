/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javalab5;

import java.util.Scanner;

/**
 *
 * @author Boris
 */
public class JavaLab5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Для квадратного уравнения вида a*х^2 + b*x + c = 0 введите числа a, b и c каждое на отдельной строке:");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = b*b-4*a*c;
        if(d < 0){
            System.out.println("Уравнение не имеет корней!");
        }
        else if(d == 0){
            System.out.println("Уравнение имеет один корень!");
            System.out.println("X = "+(-b/(2*a)));
        }
        else{
            System.out.println("Уравнение имеет два корня!");
            System.out.println("X1 = "+(-b-Math.sqrt(d))/(2*a));
            System.out.println("X2 = "+(-b+Math.sqrt(d))/(2*a));
        }
    }
    
}
