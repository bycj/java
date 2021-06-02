package xinan.demo.spring.aop;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTestBootstrap {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop/aop.xml");
		TestAopBean bean = (TestAopBean) context.getBean("aopTestBean");
		bean.testAop();
		// 输出内容 看输出顺序，了解到增强方法的执行顺序 :
		// Around proceed 之前 -> Before -> Around proceed 之后 -> After
		//around Before
		//before Test
		//I am the true aop bean
		//around After
		//after Test
	}
}
