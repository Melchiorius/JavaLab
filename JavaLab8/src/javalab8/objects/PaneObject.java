/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javalab8.objects;

/**
 *
 * @author borisost
 */
public abstract class PaneObject {
    private int x;
    private int y;

    public PaneObject() {
        x = 0;
        y = 0;
    }

    public PaneObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
}
