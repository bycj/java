package xinan.demo.baselearn.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @description:
 * @author: xinan
 * @create: 2021-03-09 11:42
 **/
public class SerializeDemo{
    public static void main(String [] args)   {
        Employee e = new Employee();
        e.name = "zhangsan";
        e.address = "beiqinglu";
        e.age = 20;
        try {
            // 创建序列化流对象
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.txt"));
            // 写出对象
            out.writeObject(e);
            // 释放资源
            out.close();
            System.out.println("Serialized data is saved"); // 姓名，地址被序列化，年龄没有被序列化。
        } catch(IOException i)   {
            i.printStackTrace();
        }
    }
}
