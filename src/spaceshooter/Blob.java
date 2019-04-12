/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author 805598
 */
public class Blob extends Creature {
    public Blob(int x, int y) {
        super(x, y, "/images/Cow-PNG-Image.png");
        super.setDy(1);
        super.setDx(1);
    }    
}

