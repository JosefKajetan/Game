package com.john;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.security.Key;

public class Player extends Sprite{

    public int dx;
    public int dy;



    public Player(int x, int y){
        super(x,y);
        loadImage();
    }

    //načtení obrázku hráče
    private void loadImage(){
        loadImage("res/spider.png");
        getImageDimensions();
    }

    //metoda pro pohyb
    public void move(){

        if (x > 0 && x < 960 - width && y > 0 && y < 540 - height - 20) {

            x += dx;
            y += dy;
        }

        else if (y < 0 + 16) {
            this.y = y + 10;
        }

        else if (y > 540 - height - 20) {
            this.y = y - 10;
        }

        else if (x > 960 - width) {
            this.x = x - 10;

        } else {
            this.x = x + 10;

        }

    }


    //získání zmáčknuté klávesy
    public void keyPressed(KeyEvent e){

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            dy = -1;}
        if(code == KeyEvent.VK_S){dy = 1;}
        if(code == KeyEvent.VK_D){dx = 1;}
        if(code == KeyEvent.VK_A){dx = -1;}
    }

    public void keyReleased(KeyEvent e){

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){dy = 0;}
        if(code == KeyEvent.VK_S){dy = 0;}
        if(code == KeyEvent.VK_D){dx = 0;}
        if(code == KeyEvent.VK_A){dx = 0;}
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

}

