package xinan.demo.baselearn.reflection;

import xinan.demo.baselearn.proxy.Student;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author xinan
 * @date 2019/12/11
 */
public class Reftest {
    public static void main(String args[]) throws Exception {

        Class clazz = Student.class;
        Object student = clazz.newInstance();
        Constructor constructor = clazz.getConstructor();
        System.out.println("构造函数名:"+constructor.getName());
        Field f = clazz.getField("name");
        System.out.println("属性name:"+f.getName());
        f.set(student, "chenjian");
        System.out.println("属性value："+f.get(student));

        Method m1 = clazz.getMethod("setName1");
        Method m2 = clazz.getMethod("setName2",String.class);
        System.out.println(m1.getName());
        System.out.println(m2.getName());
        m1.invoke(student);
        m2.invoke(student,"xinan");


        Method[]ms  = clazz.getMethods();

    }
}
