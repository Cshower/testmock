package com.xiaoqing.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlaneBulletTest {
	PlaneBullet planebullet;
	
	@Before
	public void setUp() throws Exception {
		planebullet = new PlaneBullet();
	}

	@Test
	public void testCheckLocation() {
		planebullet.moveY(-3);
		planebullet.checkLocation();
		assertEquals(false, planebullet.isLive());
	}

	@Test
	public void testMove() {
		double y = planebullet.getY() - 4;
		planebullet.move();
		assertEquals(y, planebullet.getY(), 0.2);
	}

}
