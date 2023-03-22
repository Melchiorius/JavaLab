/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javalab8;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javalab8.interfaces.IMovable;
import javalab8.interfaces.IPaintable;
import javalab8.objects.Cloud;
import javalab8.objects.Moon;
import javalab8.objects.ViewPoint;

/**
 *
 * @author borisost
 */
public class JavaLab8 {
    List<IMovable> clouds;
    Frame frame;
    
    public JavaLab8(){
        clouds = new ArrayList<>();
        frame = new Frame();
        frame.setVisible(true);
        ViewPoint viewpoint = new ViewPoint();
        frame.setViewpoint(viewpoint);
        Moon moon = new Moon(50,50);
        frame.getPane().addPaintableObj(moon);
        for(int i=0;i<5;i++){
            createCloud();
        }
        run();
    }
    
    private void createCloud(){
        Cloud cloud = new Cloud(-(int)(frame.getSize().getWidth()*0.25),(int)(30+Math.random()*frame.getSize().getHeight()-60), (int)(20+Math.random()*30),(int)(15+Math.random()*15));
        frame.getPane().addPaintableObj(cloud);
        clouds.add(cloud);
    }
    
    
    private void run(){
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                List<IMovable> remove = new ArrayList<>();
                for(IMovable cloud : clouds){
                    cloud.move(2, 0);
                    if(cloud.getX() > frame.getSize().getWidth()*1.25){
                        remove.add(cloud);
                    }
                }
                for(IMovable obj : remove){
                    clouds.remove(obj);
                    if(obj instanceof IPaintable){
                        frame.getPane().removePaintableObj((IPaintable)obj);
                        createCloud();
                    }
                }
                frame.repaint();
            }
        }, 0,80);
    }
    
    public static void main(String[] args) {
        new JavaLab8();
    }
    
}
