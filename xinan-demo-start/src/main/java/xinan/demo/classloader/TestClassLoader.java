package xinan.demo.classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author xinan
 * @date 2020/09/05
 */
public class TestClassLoader {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String className = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    //返回读取指定资源的输入流
                    InputStream is = getClass().getResourceAsStream(className);
                    if (is == null){
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);

                    //将一个byte数组转换为Class类的实例
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object object = myLoader.loadClass("xinan.demo.classloader.TestClassLoader").newInstance();
        //测试不同加载器加载的同名类不是同一个类
        System.out.println(object.getClass());
        System.out.println(object instanceof TestClassLoader);

        //测试存在相同全路径的类时，会加载哪个类，此时要看类加载器的优先级
        MyClassLoader mcl = new MyClassLoader();
        /**
         *APPClassloader 系统默认类加载器 负责加载用户类路径（ClassPath）上所指定的类库
         * mcl在加载时根据双亲委派先看parent加载器是否已经加载了"xinan.demo.classloader.Person"
         *因为"xinan.demo.classloader.Person"在ClassPath下，所以优先被AppClassLoader加载，mcl不会再次加载
         */
        Class<?> c1 = mcl.loadClass("xinan.demo.classloader.Person");
        Object obj = c1.newInstance();
        System.out.println(obj);
        System.out.println(obj.getClass().getClassLoader());

        /**
         * 打破双亲委派模型,把MyClassLoader的parent指定为系统加载器的parent，也就是ExtClassLoader
         * 由于ExtClassLoader没有加载"xinan.demo.classloader.Person"
         * 因此MyClassLoader可以加载"xinan.demo.classloader.Person"
         */
        MyClassLoader mcl2 = new MyClassLoader(ClassLoader.getSystemClassLoader().getParent());
        Object object2 = mcl2.loadClass("xinan.demo.classloader.Person").newInstance();
        System.out.println(object2);
        System.out.println(object2.getClass().getClassLoader());
    }



}

