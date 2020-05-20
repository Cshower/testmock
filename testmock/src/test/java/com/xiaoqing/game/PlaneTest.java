package com.xiaoqing.game;

import static org.junit.Assert.*;
import java.awt.Image;
import org.junit.Test;

public class PlaneTest {
	Plane plane;
	
	@Test
	public void testCheckLocation() {
		plane = new Plane();
		plane.setLive(false);
		plane.checkLocation();
		assertEquals(true, plane.isLive());
	}

	@Test
	public void testMove() {
		plane = new Plane();
		double x = plane.getX() + 2.0*Math.cos(plane.getdegree());
		double y = plane.getY() + 2.0*Math.sin(plane.getdegree());
		plane.move();
		assertEquals(x, plane.getX(), 2.0);   //两个double类型比较要加一个精度
		assertEquals(y, plane.getY(), 2.0);
	}

	@Test
	public void testSetCollide() {
		Image img = GameUtil.getImage("images/plane.png");
		plane = new Plane(img);
		plane.setCollide(false);
		assertEquals(false, plane.getCollide());
	}

	@Test
	public void testSetBulletCount() {
		plane = new Plane();
		plane.setBulletCount(4);
		assertEquals(4, plane.getBulletCount());
	}

	@Test
	public void testFire() {
		Image img = GameUtil.getImage("images/plane.png");
		plane = new Plane(img);
		plane.setLive(true);
		plane.fire();
		if(Math.random() < 0.5) {
			assertEquals(true, plane.isLive()); //	
		}
	}

}
