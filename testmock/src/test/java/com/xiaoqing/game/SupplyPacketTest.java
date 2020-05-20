package com.xiaoqing.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SupplyPacketTest {
	SupplyPacket supplypacket;
	
	@Before
	public void setUp() throws Exception {
		supplypacket = new SupplyPacket(GameUtil.getImage("images/supply.png"));
	}

	@Test
	public void testCheckLocation() {
		supplypacket.setLive(false);
		supplypacket.moveY(400);
		supplypacket.checkLocation();
		assertEquals(false, supplypacket.isLive());
		
		supplypacket.setLive(true);
		supplypacket.moveY(592);
		supplypacket.checkLocation();
		assertEquals(false, supplypacket.isLive());
	}

	@Test
	public void testMove() {
		double y = supplypacket.getY() + 2;
		supplypacket.move();
		assertEquals(y, supplypacket.getY(), 0.2);
	}

}
