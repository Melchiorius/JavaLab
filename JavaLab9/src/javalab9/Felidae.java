/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javalab9;

/**
 *
 * @author Boris
 */
public abstract class Felidae {
    private int age;
    protected static int maxAge = 20;
    
    public abstract void say();

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int getMaxAge() {
        return maxAge;
    }
    
}
