/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Color;
/**
 *
 * @author 805598
 */
public class Cobra extends Creature {
    //Fields
    private ImageIcon ii;
    private Image img;
    
    //Constructor
    public Cobra(int x, int y) {
        super(x, y, "/images/cobra.png");
        super.setDy(3);
        super.setDx(1);
    }
}