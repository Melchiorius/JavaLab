/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javalab10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author borisost
 */
public class JavaLab10 {

    
    private static List<Integer> initList(int N){
        List<Integer> numbers = new ArrayList<>();
        for(int i=0;i<N;i++){
            numbers.add((int)(Math.random()*100*N));
        }
        return numbers;
    }
    
    private static void printList(List<Integer> numbers){
        numbers.forEach(num -> {System.out.print(num+" ");});
        System.out.print("\b\n");
    }
    
    private static List<Integer> sort(List<Integer> numbers){
        //return new BubbleSort().sort(numbers);
        //return new ShakerSort().sort(numbers);
        //return new MergeSort().sort(numbers);
        //return new QuickSort().sort(numbers);
        return new HipSort().sort(numbers);
    }
    
    public static void main(String[] args) {
        List<Integer> numbers = initList(10);
        printList(numbers);
        List<Integer> sorterNumbers = sort(numbers);
        printList(sorterNumbers);
    }
    
}
