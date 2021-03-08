package xinan.demo.baselearn.io;

import java.io.FileInputStream;

/**
 * @description:
 * @author: xinan
 * @create: 2021-03-08 10:28
 **/
public class StreamIo {
    public static void main(String[] args) throws Exception {

        FileInputStream inputStream = new FileInputStream("a.txt");
        byte[] bytes = new byte[1024];
        int len;
        while ((len=inputStream.read(bytes))!=-1){
            System.out.print(new String(bytes,0,len));
        }
    }
}
