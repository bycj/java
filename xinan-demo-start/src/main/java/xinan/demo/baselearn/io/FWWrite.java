package xinan.demo.baselearn.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @description:
 * @author: xinan
 * @create: 2021-03-09 09:50
 **/
public class FWWrite {
    public static void main(String[] args) throws IOException {
        // 使用文件名称创建流对象
        FileWriter fw = new FileWriter("fw.txt");
        // 写出数据
        fw.write(97); // 写出第1个字符
        fw.write('b'); // 写出第2个字符
        fw.write('C'); // 写出第3个字符

        //关闭资源时,与FileOutputStream不同。 如果不关闭,数据只是保存到缓冲区，并未保存到文件。
         fw.close();
    }
}
//public class FWWrite {
//    public static void main(String[] args) throws IOException {
//        // 使用文件名称创建流对象
//        FileWriter fw = new FileWriter("fw.txt");
//        // 写出数据，通过flush
//        fw.write('刷'); // 写出第1个字符
//        fw.flush();
//        fw.write('新'); // 继续写出第2个字符，写出成功
//        fw.flush();
//
//        // 写出数据，通过close
//        fw.write('关'); // 写出第1个字符
//        fw.close();
//        fw.write('闭'); // 继续写出第2个字符,【报错】java.io.IOException: Stream closed
//        fw.close();
//    }
//}