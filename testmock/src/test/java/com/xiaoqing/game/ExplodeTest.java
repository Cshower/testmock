package com.xiaoqing.game;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExplodeTest {
	Explode explode;
	
	@Test
	public void testDraw() {
		explode = new Explode();
		explode.count = 13;
		explode.paint();
		assertEquals(14, explode.count);
	}

}
