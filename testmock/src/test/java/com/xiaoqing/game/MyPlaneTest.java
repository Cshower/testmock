package com.xiaoqing.game;

import static org.junit.Assert.*;

import java.awt.Image;
import java.awt.event.KeyEvent;

import org.junit.Before;
import org.junit.Test;

public class MyPlaneTest {
	MyPlane myplane;
	
	@Before
	public void setUp() throws Exception {
		myplane = new MyPlane();
	}

	@Test
	public void testCheckLocation() {
		myplane.moveX(-3);
		myplane.checkLocation();
		assertEquals(0, myplane.getX(), 0.2);  //注意精度
		myplane.moveX(600);
		myplane.checkLocation();
		assertEquals(576, myplane.getX(), 0.2);
		
		myplane.moveY(20);
		myplane.checkLocation();
		assertEquals(30, myplane.getY(), 0.2);
		myplane.moveY(570);
		myplane.checkLocation();
		assertEquals(526, myplane.getY(), 0.2);
	}

	@Test
	public void testMove() {
		myplane.accelerate = true;
		myplane.move();
		assertEquals(5, myplane.getStep(), 0.2);
		myplane.accelerate = false;
		myplane.move();
		assertEquals(3, myplane.getStep(), 0.2);
		
		myplane.up = true;
		double y = myplane.getY() - myplane.getStep();
		myplane.move();
		assertEquals(y, myplane.getY(), 0.2);
		myplane.up = false;
		myplane.down = true;
		y = myplane.getY() + myplane.getStep();
		myplane.move();
		assertEquals(y, myplane.getY(), 0.2);
		
		myplane.right = true;
		double x = myplane.getX() + myplane.getStep();
		myplane.move();
		assertEquals(x, myplane.getX(), 0.2);
		myplane.left = true;
		myplane.right = false;
		x = myplane.getX() - myplane.getStep();
		myplane.move();
		assertEquals(x, myplane.getX(), 0.2);
	}

	@Test
	public void testFire() {
		Image img = GameUtil.getImage("images/plane.png");
		myplane = new MyPlane(img, 40, 40);
		myplane.fire();
		for(int i = 0;i < myplane.bullets.length;i++) {
			assertEquals(true, myplane.bullets[i].isLive());
		}
	}
	
	

}
