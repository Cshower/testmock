package com.xiaoqing.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BloodTest {
	Blood blood;
	
	@Before
	public void setUp() throws Exception {
		blood = new Blood();
	}

	@Test
	public void testAddBlood() {
		//count==5
		blood.addBlood();
		assertEquals(5, blood.getCount());
		//count==3
		blood.setCount(3);
		blood.addBlood();
		assertEquals(4, blood.getCount());
	}

	@Test
	public void testMinusBlood() {
		blood.setCount(3);
		blood.minusBlood();
		assertEquals(2, blood.getCount());
	}

}
