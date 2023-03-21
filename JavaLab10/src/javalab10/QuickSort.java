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
public class QuickSort extends Sort{

    private int partitionQuickSort(List<Integer> numbers, int l, int r) {
        int value = numbers.get(r);
        int less = l;
        for (int i = l; i < r; ++i) {
            if (numbers.get(i) <= value) {
                swap(numbers,i,less);
                ++less;
            }
        }
        swap(numbers,less,r);
        return less;
    }

    private void quickSort(List<Integer> numbers, int l, int r) {
        if (l < r) {
            int q = partitionQuickSort(numbers, l, r);
            quickSort(numbers, l, q - 1);
            quickSort(numbers, q + 1, r);
        }
    }
    
    @Override
    public List<Integer> sort(List<Integer> numbers) {
        numbers = numbers.stream().toList();
        quickSort(numbers,0,numbers.size()-1);
        return numbers;
    }
    
}
