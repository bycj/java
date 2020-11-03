package xinan.demo.baselearn.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author xinan
 * @date 2019/12/23
 */
public class InvocationHandlerImpl implements InvocationHandler {
    private Object target;
    public InvocationHandlerImpl(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法执行前2");
        method.invoke(target,args);
        System.out.println("方法执行后2");
        return null;
    }
}
