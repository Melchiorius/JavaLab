/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javalab10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author borisost
 */
public class MergeSort extends Sort {
    
    @Override
    public List<Integer> sort(List<Integer> numbers){
        numbers = numbers.stream().toList();
        List<Integer> buffer = new ArrayList<>(Collections.nCopies(numbers.size(), 0));
        mergeSort(numbers,buffer,0,numbers.size()-1);
        return numbers;
    }
    
    private static void mergeSort(List<Integer> numbers, List<Integer> buffer, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(numbers, buffer, l, m);
            mergeSort(numbers, buffer, m + 1, r);

            int k = l;
            for (int i = l, j = m + 1; i <= m || j <= r; ) {
                if (j > r || (i <= m && numbers.get(i) < numbers.get(j))) {
                    buffer.set(k, numbers.get(i));
                    ++i;
                } else {
                    buffer.set(k, numbers.get(j));
                    ++j;
                }
                ++k;
            }
            for (int i = l; i <= r; ++i) {
                numbers.set(i, buffer.get(i));
            }
        }
    }
}
