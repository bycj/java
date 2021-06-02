package xinan.demo.baselearn.io;

import java.io.File;
import java.io.IOException;

/**
 * @description:
 * @author: xinan
 * @create: 2021-03-16 10:15
 **/
public class FileIO {
    public static void main (String args[]) throws IOException {
        //相对路径
        File file = new File("xinan.txt");
        file.createNewFile();

        //绝对路径
        File file2 = new File("/Users/xinan/xinan.txt");
        file.createNewFile();

        //父子
        File file3 = new File("/Users/xinan","xinan2.txt");
        file3.createNewFile();

        File file1 = new File("/Users/xinan/");
        File file4 = new File(file1,"xinan4.txt");
        file4.createNewFile();
    }
}
