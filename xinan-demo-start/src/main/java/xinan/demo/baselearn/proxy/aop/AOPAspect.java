package xinan.demo.baselearn.proxy.aop;


import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AOPAspect {

    public AOPAspect(){
    }

    @Pointcut("execution(* xinan.demo..*.*(..))")
    public void startPoint(){}

    @Before(value = "startPoint()")
    public void before() throws Throwable {
        System.out.println("执行方法前");
    }

    @AfterReturning(value = "startPoint()")
    public void afterReturning() throws Throwable {
        System.out.println("执行方法后");
    }
}