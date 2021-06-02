package xinan.demo.spring.aop;

import org.springframework.stereotype.Component;

public class TestAopBean {

	private String testStr = "testStr";

	public void testAop() {
	    // 被拦截的方法，简单打印
		System.out.println("I am the true aop bean");
	}
}
