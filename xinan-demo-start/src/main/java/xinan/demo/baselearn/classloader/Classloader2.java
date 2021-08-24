package xinan.demo.baselearn.classloader;

/**
 * @description:
 * @author: xinan
 * @create: 2021-08-11 16:28
 **/
@DProcessor
public class Classloader2 implements ClassloaderInterface{
    @Override
    public void print() {
        System.out.println(this.getClass().getName());
    }
}
