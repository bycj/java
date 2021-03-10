package xinan.demo.baselearn.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @description:
 * @author: xinan
 * @create: 2021-03-09 11:06
 **/
public class BufferedWriterDemo  {
    public static void main(String[] args) throws IOException {
        // 创建流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("b.txt"));
        // 写出数据
        bw.write("哥");
        // 写出换行
        bw.newLine();
        bw.write("敢");
        bw.newLine();
        bw.write("摸屎");
        bw.newLine();
        bw.write("你敢吗？");
        bw.newLine();
        // 释放资源
        bw.close();
        }
}
