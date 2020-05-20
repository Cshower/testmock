package com.xiaoqing.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BulletTest {
	Bullet bullet;
	
	@Before
	public void setUp() throws Exception {
		bullet = new Bullet();
	}
	
	@Test
	public void testCheckLocation() {
		//600 > GAME_HEIGHT
		bullet.moveY(600);
		bullet.checkLocation();
		assertEquals(false, bullet.isLive());
	}

	@Test
	public void testMove() {
		double step = bullet.getY() + 4;
		bullet.move();
		assertEquals(step, bullet.getY(), 2.0); //都是double类型要加上一个误差值
	}

	@Test
	public void testBullet() {
		assertEquals(10, bullet.getHeight());
		assertEquals(10, bullet.getWidth());
	}

	@Test
	public void testSetLive() {
		bullet.setLive(true);
		assertEquals(true, bullet.isLive());
	}

	@Test
	public void testIsLive() {
		bullet.setLive(false);
		assertEquals(false, bullet.isLive());
	}

}
