package testmock;

public class TestJunit4 {
	private IMathfun util;

    public TestJunit4(IMathfun util) {
        this.util = util;
    }
    public int cal(int num) {
        return 10 * util.abs(num);
    }
}
