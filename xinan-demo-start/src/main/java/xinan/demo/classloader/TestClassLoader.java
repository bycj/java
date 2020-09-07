package xinan.demo.classloader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

/**
 * @author xinan
 * @date 2020/09/05
 */
public class TestClassLoader {

    public static void main(String[] args)
        throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException,
        InvocationTargetException {

        MyClassLoader myLoader = new MyClassLoader();
        Object object = myLoader.loadClass("xinan.demo.classloader.TestClassLoader").newInstance();
        /**
         *"object.getClass()"的结果是xinan.demo.classloader.TestClassLoader 说明这2个类的全名称一致
         *但是"object instanceof TestClassLoader"的结果是false，说明这2个不是同一个类
         * 因此可以得出结论唯一标识一个类需要 :同一个类加载器+类的全限定名相同
         */
        System.out.println(object.getClass());
        System.out.println(object instanceof TestClassLoader);



        /**
         *APPClassloader 系统默认类加载器 负责加载用户类路径（ClassPath）上所指定的类库
         * mcl在加载时根据双亲委派先看parent加载器是否已经加载了"xinan.demo.classloader.Person"
         *因为"xinan.demo.classloader.Person"在ClassPath下，所以优先被AppClassLoader加载，mcl不会再次加载
         */
        MyClassLoader mcl = new MyClassLoader();
        Class<?> c1 = mcl.loadClass("xinan.demo.classloader.Person");
        Object obj = c1.newInstance();
        System.out.println(obj);
        System.out.println(obj.getClass().getClassLoader());

        /**
         * 把MyClassLoader的parent指定为系统加载器的parent，也就是ExtClassLoader
         * 由于ExtClassLoader没有加载"xinan.demo.classloader.Person"
         * 因此MyClassLoader可以加载"xinan.demo.classloader.Person"
         */
        MyClassLoader mcl2 = new MyClassLoader(ClassLoader.getSystemClassLoader().getParent());
        Object object2 = mcl2.loadClass("xinan.demo.classloader.Person").newInstance();
        System.out.println(object2);
        System.out.println(object2.getClass().getClassLoader());

        TestMyClassloader testMyClassloader = new TestMyClassloader();
        testMyClassloader.foo();

    }



}

