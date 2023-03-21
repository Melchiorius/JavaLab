/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javalab10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author borisost
 */
public class HipSort extends Sort{
    @Override
    public List<Integer> sort(List<Integer> numbers){
        LinkedNode<Integer> root = new LinkedNode(numbers.get(0));
        root.setComparator(new Comparator(){
            @Override
            public int compare(Object t, Object t1) {
                return ((int)t)-((int)t1);
            }
            
        });
        for(int i=1;i<numbers.size();i++){
            root.add(numbers.get(i));
        }
        return root.getAllValues();
    }
}
