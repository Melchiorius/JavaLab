package ru.boost;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class JavaLab17 {

    private static int getNaturalNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите натуральное числа:");
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

    public static void main(String[] args) {
        int n = getNaturalNumber();
        BigInteger factoral = BigInteger.valueOf(1);
        for(int i=1;i<=n;i++){
            factoral = factoral.multiply(BigInteger.valueOf(i));
        }
        System.out.println("Факториал числа "+n+" = "+factoral.toString());
    }

}
