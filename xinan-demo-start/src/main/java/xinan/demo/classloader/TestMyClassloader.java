package xinan.demo.classloader;

import java.lang.reflect.InvocationTargetException;

/**
 * @author xinan
 * @date 2020/09/07
 */
public class TestMyClassloader {

        public void foo()
            throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException {
            if (!(this.getClass().getClassLoader() instanceof MyClassLoader)){
                ClassLoader myClassLoader = new MyClassLoader();
                Class<?> mainClass = myClassLoader.loadClass(this.getClass().getName());
                Object main = mainClass.newInstance();
                mainClass.getDeclaredMethod("foo").invoke(main);
                return;
            }

            //调用自定义加载器加载的类的方法...
            Person person = new Person();
            person.getName();
        }
}
