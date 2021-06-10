package xinan.demo.baselearn.pattern.builder;

/**
 * @description:
 * @author: xinan
 * @create: 2021-06-10 16:35
 **/
public class BuilderDemo {
    public static void main (String []args) {
        Computer computer=new Computer.Builder("因特尔","三星")
                .setDisplay("三星24寸")
                .setKeyboard("罗技")
                .setUsbCount(2)
                .build();
    }
}

