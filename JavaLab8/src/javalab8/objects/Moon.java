/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javalab8.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javalab8.interfaces.IPaintable;

/**
 *
 * @author borisost
 */
public class Moon extends PaneObject implements IPaintable{

    int radius = 100;

    public Moon() {
        super();
    }

    public Moon(int x, int y) {
        super(x, y);
    }
    
    @Override
    public void draw(Graphics g) {
        Color tmp = g.getColor();
        Ellipse2D moon = new Ellipse2D.Double(getX(),getY(),radius*2,radius*2);
        g.setColor(Color.WHITE);
        ((Graphics2D)g).fill(moon);
        g.setColor(tmp);
    }
     
}
