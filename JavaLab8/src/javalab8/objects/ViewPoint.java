/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javalab8.objects;

import javalab8.interfaces.IMovable;
import javalab8.interfaces.IPaintable;

/**
 *
 * @author borisost
 */
public class ViewPoint  extends PaneObject implements IMovable{

    @Override
    public void move(int dX, int dY) {
        setX(getX()+dX);
        setY(getY()+dY);
    }
    
}
