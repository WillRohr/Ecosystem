/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author 805598
 */
public class Ecosystem extends JPanel {

    private Creature blob;
    private Sheep[] sheeps;    
    private Cobra[] cobras;
    private ArrayList<Bush> bushs;
    private Timer timer;
    private boolean gameover;
    private long lastTime;
        
    public Ecosystem() {
        super();
        blob = new  Blob(1200 / 2, 450 - 100);
        cobras = new Cobra[20];
        sheeps = new Sheep[18];
        bushs = new ArrayList<>();
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/60);
        lastTime = System.currentTimeMillis();
        spawnCobras();
        spawnSheeps();
    }
    
    private void spawnCobras() {
        for(int i = 0; i <20; i++){
        cobras[i] = new Cobra(25 + i * 50, 50);
        }
    }
     private void spawnSheeps() {
        for(int i = 0; i <18; i++){
        sheeps[i] = new Sheep(25 + i * 50, 50);
        }
     }
    
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        long dT = System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
        g.setColor(Color.black);
        this.setBackground(Color.red);
        blob.draw(g);
        
        for (Cobra cobra : cobras) {
            cobra.draw(g);
        }
        for (Sheep sheep : sheeps) {
            sheep.draw(g);
        }
        
        for (Bush bush : bushs) {
            if (bush != null) {
                bush.draw(g);
                System.out.println("It exists");
            }
            System.out.println("It may not exist");
        }
        if(gameover == true) {
            g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
            g.setColor(Color.BLACK);
            g.drawString("Game over", 325, 400); 
}

    }
    
    private class ScheduleTask extends TimerTask {
    
        @Override
        public void run() {
            blob.update();
            wallCollisions(blob);
            for (Bush bush : bushs) {
                if (bush == null)
                   continue;
                   
                    bush.update();
                    
            } 
           for (Cobra cobra : cobras) {
               if (cobra == null){
                   continue;
                   
               }
               wallCollisions(cobra);
               cobra.update();
           }
           for (Sheep sheep : sheeps) {
               if (sheep == null) {
                   continue;
               }
               wallCollisions(sheep);
               sheep.update();
               
           }
           
            
            repaint();           
            }
  
    }
        private void wallCollisions(Creature c) {
       
        if (c.getX() <= 0 || c.getX() + c.getSize() >= this.getWidth()){
            c.setDx(-c.getDx());
        }
        if (c.getY() <= 0 || c.getY() + c.getSize() >= this.getHeight()){
            c.setDy(-c.getDy());
        }

    }

    
    public void keyPressed(KeyEvent e) {
        final int SPEED = 9;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            blob.setDx(SPEED);
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            blob.setDx(-SPEED);
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            blob.setDy(-SPEED);
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            blob.setDy(SPEED);
        }
    }
    
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            blob.setDx(0);
            
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            blob.setDx(0);
            
        if (e.getKeyCode() == KeyEvent.VK_UP)
            blob.setDy(0);
            
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            blob.setDy(0);
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
            bushs.add( new Bush(blob.getX(), blob.getY()) );
            
    }   
    
    
    
    
    
}