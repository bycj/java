package xinan.demo.classloader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

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
                    System.out.println("classNmae:{}"+className);
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
    }
}

