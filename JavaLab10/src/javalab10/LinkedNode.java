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
public class LinkedNode<T> {
    private LinkedNode parent;
    private LinkedNode lesser;
    private LinkedNode greater;
    private List<T> values;
    private Comparator comparator;
    
    public LinkedNode(T value){
        values = new ArrayList<>();
        values.add(value);
    }
    
    private LinkedNode(T value, LinkedNode parent){
        values = new ArrayList<>();
        values.add(value);
        this.parent = parent;
    }
    
    public void add(T newValue){
        if(comparator == null){
        System.out.println("Comparator not initiated in LinkedNode!");
        return;
        }
        T value = values.get(0);
        int compare = comparator.compare(value, newValue);
        if(compare > 0){
        if(lesser == null){
            lesser = new LinkedNode(newValue, this);
            lesser.setComparator(comparator);
            return;
        }
        lesser.add(newValue);
        return;
        }
        else if(compare < 0){
        if(greater == null){
            greater = new LinkedNode(newValue, this);
            greater.setComparator(comparator);
            return;
        }
        greater.add(newValue);
        return;
        }
        values.add(newValue);
    }

    public void setComparator(Comparator comparator) {
        this.comparator = comparator;
    }

    public LinkedNode getParent() {
        return parent;
    }

    public LinkedNode getLesser() {
        return lesser;
    }

    public LinkedNode getGreater() {
        return greater;
    }

    public List<T> getValues() {
        return values;
    }
    
    public List<T> getAllValues() {
        List<T> list = new ArrayList<>();
        if(lesser != null){
        list.addAll(lesser.getAllValues());
        }
        list.addAll(values);
        if(greater != null){
        list.addAll(greater.getAllValues());
        }
        return list;
    }
    
    public T getValue() {
        return values.get(0);
    }
}
