/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javalab10;

import java.util.List;

/**
 *
 * @author borisost
 */
public abstract class Sort {
    protected void swap(List<Integer> numbers, int index0, int index1){
        int tmp = numbers.get(index1);
        numbers.set(index1,numbers.get(index0));
        numbers.set(index0,tmp);
    }
    
    public abstract List<Integer> sort(List<Integer> numbers);
}
