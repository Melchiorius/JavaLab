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
public class ShakerSort extends Sort{

    @Override
    public List<Integer> sort(List<Integer> numbers) {
        numbers = numbers.stream().toList();
        int N = numbers.size()-1;
        int S = 0;
        while(S<N){
            for(int i=0;i<N;i++){
                if(numbers.get(i+1)<numbers.get(i)){
                    swap(numbers,i,i+1);
                }
            }
            N--;
            for(int i=N;i>S;i--){
                if(numbers.get(i-1)>numbers.get(i)){
                    swap(numbers,i-1,i);
                }
            }
            S++;
        }
        return numbers;
    }
    
}
