/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javalab9;

/**
 *
 * @author Boris
 */
public class CatGirl extends Felis{
    @Override
    public void say() {
        System.out.println(Math.random()<0.8?"Niaaa!":"Baka Senpai!");
    }
}
