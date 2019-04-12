/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter;
/**
 *
 * @author 805598
 */
public class Bush extends Creature {
    
    //Constructor
    public Bush(int x, int y) {
        super(x, y, "/images/missile.gif");
        super.setDy(-1);
    }
}