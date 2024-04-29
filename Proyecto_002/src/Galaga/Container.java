package Galaga;


import java.awt.Graphics;
import java.awt.Graphics2D;

import Interfaces.Deadble;
import Interfaces.Drawable;
import Interfaces.Movable;
import Interfaces.Shootable;

public class Container {
	
	public void draw(Drawable d, Graphics g) {
		d.draw(g);		
	}
	
	public void move(Movable m,String direction) {
        m.move(direction);
    }
	
	public void shoot(Shootable s) {
		s.shoot();
	}
	
	public void dead(Deadble d) {
		d.dead();
	}

}
