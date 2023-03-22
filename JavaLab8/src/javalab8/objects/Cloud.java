/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javalab8.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import javalab8.interfaces.IMovable;
import javalab8.interfaces.IPaintable;

/**
 *
 * @author borisost
 */
public class Cloud extends PaneObject implements IPaintable, IMovable{

    private int maxDist;
    private int radius;
    List<Element> elements;

    public Cloud() {
        this(0,0,10,5);
    }
    
    public Cloud(int x, int y) {
        this(x,y,10,5);
        
    }

    public Cloud(int x, int y, int maxDist, int radius) {
        super(x, y);
        this.maxDist = maxDist;
        this.radius = radius;
        generateCloud();
    }
    
    private void generateCloud(){
        elements = new ArrayList<>();
        elements.add(new Element(0,0,radius));
        for(int i=0;i<5;i++){
            elements.add(new Element((int)(Math.random()*maxDist*3),(int)(Math.random()*maxDist),(int)((double)radius/2)+(int)(Math.random()*((double)radius/2))));
        }
    }
    
    private class Element{
        int x;
        int y;
        int radius;

        public Element(int x, int y, int radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getRadius() {
            return radius;
        }
        
        
    }
    
    @Override
    public void draw(Graphics g) {
        Color tmp = g.getColor();
        g.setColor(Color.GRAY);
        Graphics2D g2d = (Graphics2D) g;
        for(Element e : elements){
            Ellipse2D cloud = new Ellipse2D.Double(getX()+e.getX(),getY()+e.getY(),e.getRadius()*2,e.getRadius()*2);
            g2d.fill(cloud);
        }
        g.setColor(tmp);
    }

    @Override
    public void move(int dX, int dY) {
        setX(getX()+dX + (-2 + (int)(Math.random()*5)));
        setY(getY()+dY+ (-2 + (int)(Math.random()*5)));
    }
    
}
