package xinan.demo.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;


/**
 * @author xinan
 * @date 2020/09/05
 */
public class MyClassLoader extends ClassLoader
{
    public MyClassLoader()
    {

    }

    public MyClassLoader(ClassLoader parent)
    {
        super(parent);
    }

    @Override
    public Class<?> loadClass(String name)
        throws ClassNotFoundException {


        try {
            String className = name.substring(name.lastIndexOf(".") + 1) + ".class";
            //这一句很重要，避免通过反射自己加载自己时造成死循环
            if(className.contains("MyClassLoader")){return super.loadClass(name);}
            //MyClassLoader加载指定目录的Person类
            if(className.contains("Person")){
                return findClass(name);
            }
            InputStream is = this.getClass().getResourceAsStream(className);
            if (is == null) {
                return super.loadClass(name);
            } else {
                byte[] b = new byte[is.available()];
                is.read(b);
                return this.defineClass(name, b, 0, b.length);
            }
        } catch (IOException var5) {
            throw new ClassNotFoundException(name);
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException
    {
        File file = getClassFile(name);
        try
        {
            byte[] bytes = getClassBytes(file);
            Class<?> c = this.defineClass(name, bytes, 0, bytes.length);
            return c;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return super.findClass(name);
    }

    private File getClassFile(String name)
    {
        //if (!"/Users/xinan/Person.class".equals(name)){
        //    File file = new File("/Users/xinan/IdeaProjects/my/xinan-demo/xinan-demo-start/target/classes/xinan/demo"
        //        + "/classloader/"+name.substring(name.lastIndexOf(".") + 1) + ".class");
        //    return file;
        //}
        File file = new File("/Users/xinan/Person.class");
        return file;
    }

    private byte[] getClassBytes(File file) throws Exception
    {
        // 这里要读入.class的字节，因此要使用字节流
        FileInputStream fis = new FileInputStream(file);
        FileChannel fc = fis.getChannel();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel wbc = Channels.newChannel(baos);
        ByteBuffer by = ByteBuffer.allocate(1024);

        while (true)
        {
            int i = fc.read(by);
            if (i == 0 || i == -1){
                break;
            }
            by.flip();
            wbc.write(by);
            by.clear();
        }

        fis.close();

        return baos.toByteArray();
    }
}
