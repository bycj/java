package xinan.demo;

import org.junit.Test;

/**
 * @author xinan
 * @date 2020/09/04
 */
public class TestClassLoader {
    @Test
    public void testClassLoader(){
            System.out.println("1-"+ClassLoader.getSystemClassLoader());
            //extensions class loader
            System.out.println("2-"+ClassLoader.getSystemClassLoader().getParent());
            //bootstrap class loader
            System.out.println("3"+ClassLoader.getSystemClassLoader().getParent().getParent());
    }
}
