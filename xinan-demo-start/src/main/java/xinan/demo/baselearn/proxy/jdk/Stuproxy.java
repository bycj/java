package xinan.demo.baselearn.proxy.jdk;

import xinan.demo.baselearn.proxy.Stu;
import xinan.demo.baselearn.proxy.Student;
import xinan.demo.baselearn.proxy.jdk.InvocationHandlerImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xinan
 * @date 2019/12/13
 */
public class Stuproxy {

public static void main(String args[]){
    Student student = new Student();
    Object proxy = Proxy.newProxyInstance(Stu.class.getClassLoader(), new Class<?>[] {Stu.class},
        new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("方法执行前");
                method.invoke(student,args);
                System.out.println("方法执行后");
                return null;
            }
        });
    System.out.println(proxy.getClass());
    Stu stuproxy = (Stu)proxy;
    stuproxy.setName1();


    Student student2 = new Student();
    Stu proxy2 = (Stu)Proxy.newProxyInstance(Stu.class.getClassLoader(),new Class<?>[]{Stu.class},new InvocationHandlerImpl(student2) );
    System.out.println(proxy2.getClass());
    proxy2.setName1();
    }


}
