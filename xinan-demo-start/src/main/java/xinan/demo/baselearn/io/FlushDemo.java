package xinan.demo.baselearn.io;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * @description:
 * @author: xinan
 * @create: 2021-03-09 09:52
 **/

/**
 * 关闭close和刷新flush
 * 因为内置缓冲区的原因，如果不关闭输出流，无法写出字符到文件中。但是关闭的流对象，是无法继续写出数据的。如果我们既想写出数据，又想继续使用流，就需要flush 方法了。
 * flush ：刷新缓冲区，流对象可以继续使用。
 * close:先刷新缓冲区，然后通知系统释放资源。流对象不可以再被使用了。
 */
public class FlushDemo {
    public static void main(String[] args) throws Exception {
        //源   也就是输入流【读取流】 读取a.txt文件
        FileReader fr=new FileReader("a.txt");  //必须要存在a.txt文件，否则报FileNotFoundException异常
        //目的地  也就是输出流
        FileWriter fw=new FileWriter("b.txt");  //系统会自动创建b.txt，因为它是输出流！
        int len;
        while((len=fr.read())!=-1){
            fw.write(len);
        }
        fr.close();
        fw.flush();
        fw.close();
        //注意这里是没有使用close关闭流，开发中不能这样做，但是为了更好的体会flush的作用
        /**
         * flush()这个函数是清空的意思，用于清空缓冲区的数据流，进行流的操作时，数据先被读到内存中，然后再用数据写到文件中，那么当你数据读完时，我们如果这时调用close()方法关闭读写流，这时就可能造成数据丢失，
         * 为什么呢？因为，读入数据完成时不代表写入数据完成，一部分数据可能会留在缓存区中，这个时候flush()方法就格外重要了。
         */
    }
}
