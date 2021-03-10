package xinan.demo.baselearn.io;

import java.io.*;

/**
 * @description:
 * @author: xinan
 * @create: 2021-03-09 11:11
 **/
//62ms...
//public class BufferDemo {
//    public static void main(String[] args) throws FileNotFoundException {
//        // 记录开始时间
//        long start = System.currentTimeMillis();
//        // 创建流对象
//        try (
//                FileInputStream fis = new FileInputStream("pom.xml");//exe文件够大
//                FileOutputStream fos = new FileOutputStream("copyPy.exe")
//        ){
//            // 读写数据
//            int b;
//            while ((b = fis.read()) != -1) {
//                fos.write(b);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        // 记录结束时间
//        long end = System.currentTimeMillis();
//        System.out.println("普通流复制时间:"+(end - start)+" 毫秒");
//    }
//}

//缓冲流使用数组复制时间:1 毫秒
public class BufferDemo {
    public static void main(String[] args) throws FileNotFoundException {
        // 记录开始时间
        long start = System.currentTimeMillis();
        // 创建流对象
        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream("pom.xml"));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copyPy.exe"));
        ){
            // 读写数据
            int len;
            byte[] bytes = new byte[8*1024];
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0 , len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("缓冲流使用数组复制时间:"+(end - start)+" 毫秒");
    }
}