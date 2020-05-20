package testmock;


import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class Junit4Test extends TestCase{
    private Mockery context = new JUnit4Mockery();
    private IMathfun math = null;
    private TestJunit4 test = null;
    @Before
    public void setUp() throws Exception{
        super.setUp();
        math = context.mock(IMathfun.class);
    }
    @Test
    public void test(){
    	context.checking(new Expectations(){ 
            { 
                exactly(1).of(math).abs(-20);
                will(returnValue(20));
                exactly(2).of(math).abs(-30);
                will(returnValue(30));
            } 
      }); 
    	test = new TestJunit4(math);
        assertEquals(200, test.cal(-20));
        assertEquals(300, test.cal(-30));
    }
}
