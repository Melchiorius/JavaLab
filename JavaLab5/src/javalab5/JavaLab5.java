/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javalab5;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Boris
 */
public class JavaLab5 {

    
    private static void quadraticEquation(){
        System.out.println("��� ����������� ��������� ���� a*�^2 + b*x + c = 0 ������� ����� ����� a, b � c, ������ �� ��������� ������ ��� ����� ������:");
        Scanner scanner = new Scanner(System.in);
        try{
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            int d = b*b-4*a*c;
            if(d < 0){
                System.out.println("��������� �� ����� ������!");
            }
            else if(d == 0){
                System.out.println("��������� ����� ���� ������!");
                System.out.println("X = "+(-b/(2*a)));
            }
            else{
                System.out.println("��������� ����� ��� �����!");
                System.out.println("X1 = "+(-b-Math.sqrt(d))/(2*a));
                System.out.println("X2 = "+(-b+Math.sqrt(d))/(2*a));
            }
        }
        catch(InputMismatchException e){
            System.out.println("������ �����! ������������ �������� ����� �� ����������! ������ ������������!");
            quadraticEquation();
        }
    }
    
    public static void main(String[] args) {
        quadraticEquation();
    }
    
}
