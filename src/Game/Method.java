/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.Area;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agusbudianto2
 */
public class Method {
    private JLabel jlabel1;
    private JLabel kucing;
    private int sec = 0, min = 0;
    private JLabel minute, second;
    private Timer timer;
    private JLabel winArea;

    JLabel car1, car2, car3, car4;
    public Method(){

    }
    public Method(JLabel jlabel1){
        this.jlabel1 = jlabel1;
    }
    public Method(JLabel minute, JLabel second, JLabel kucing){
        this.minute = minute;
        this.second = second;
        this.kucing = kucing;
    }
    public Method(JLabel kucing, JLabel car1, JLabel car2, JLabel car3, JLabel car4){
        this.kucing = kucing;
        this.car1 = car1;
        this.car2 = car2;
        this.car3 = car3;
        this.car4 = car4;
    }
    public void moveUp(){
        jlabel1.setLocation(jlabel1.getX(), jlabel1.getY() - 53);
        if(jlabel1.getY()<0){
            jlabel1.setLocation(jlabel1.getX(), 555);
        }
    }
    public void moveRight(){
        jlabel1.setLocation(jlabel1.getX()+ 30, jlabel1.getY());
        if(jlabel1.getX()>=1000){
            jlabel1.setLocation(0, jlabel1.getY());
        }
    }
    public void moveLeft(){
        jlabel1.setLocation(jlabel1.getX()-30, jlabel1.getY());
        if(jlabel1.getX()<=0){
            jlabel1.setLocation(1020-jlabel1.getWidth(), jlabel1.getY());
        }
    }
    public void moveDown(){
            jlabel1.setLocation(jlabel1.getX(), jlabel1.getY()+53);
    }
    public Thread Ttime(JLabel star1, JLabel star2, JLabel star3){
        return new Thread(){
            public void run(){
                for(;;){
                    try{
                        sleep(1000);
                        if(sec > 8){
                            star1.setIcon(new ImageIcon(getClass().getResource("/image/bintangabu.png")));
                        }
                        if(sec > 10){
                            star2.setIcon(new ImageIcon(getClass().getResource("/image/bintangabu.png")));
                        }
                        if(sec > 59){
                            sec = 0;
                            min++;
                        }else if(min > 59){
                            sec = 0;
                            min = 0;
                        }
                        String detik = String.format("%02d", sec);
                        second.setText(detik);
                        sec++;
                        String menit = String.format("%02d", min);
                        minute.setText(menit);
                    }catch(Exception e){
                        
                    }
                }
            }
        };

    }

    public boolean isCollide(JLabel jlabel1, JLabel kucing){
        // Create a new rectangle that represents the bounds of the jlabel1 object, but expanded by 53 pixels on all sides
        java.awt.Rectangle jlabel1Bounds = new java.awt.Rectangle(jlabel1.getBounds().x, jlabel1.getBounds().y, jlabel1.getBounds().width, jlabel1.getBounds().height);

        // Check for collision using the expanded bounds
        if(jlabel1Bounds.intersects(kucing.getBounds())){
            return true;
        }
        return false;
    }
    public void startGame(){
        timer.start();

    }
    public void stopGame(){
        timer.stop();

    }

}
