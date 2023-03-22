/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javalab9;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Boris
 */
public class JavaLab9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Felidae> cats = new ArrayList<>();
        cats.add(new Tiger());
        cats.add(new Cat());
        cats.add(new MainKun());
        cats.add(new CatGirl());
        for(Felidae cat : cats){
            cat.say();
        }
    }
    
}
