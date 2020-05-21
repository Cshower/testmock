package com.xiaoqing.game;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;
import testmock.TestJunit4;

public class MyGameFrameTest extends TestCase{
	
	//创建mock上下文
	private Mockery context = new JUnit4Mockery() {{
		setImposteriser(ClassImposteriser.INSTANCE);
	}};
	private SupplyPacket supply;
	private MyGameFrame mygameframe;
	
	@Before
    public void setUp() throws Exception{
        super.setUp();
        supply = context.mock(SupplyPacket.class);
         
    }

	@Test
	public void testMain() {
		mygameframe.main(null);
	}

	@Test
	public void testIsCollide() {
		//设置期望
		context.checking(new Expectations(){ 
            { 
                exactly(1).of(supply).isLive();
                will(returnValue(true));
                exactly(2).of(supply).getRect();
                will(returnValue(new Rectangle(288, 460, 40, 40)));
                exactly(3).of(supply).setLive(false);
                will(returnValue(null));
            } 
        }); 
		//调用方法
		mygameframe = new MyGameFrame();
		mygameframe.load();
		mygameframe.init();
		mygameframe.start();
		int count = mygameframe.getPlane().blood.getCount();
		mygameframe.isCollide();
		//验证返回值
		assertEquals(count, mygameframe.getPlane().blood.getCount()); 
	}

}
