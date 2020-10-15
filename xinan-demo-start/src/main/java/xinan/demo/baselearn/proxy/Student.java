package xinan.demo.baselearn.proxy;

/**
 * @author xinan
 * @date 2019/12/11
 */
public class Student implements Stu{

    public String sex;

    private int age;

    public String name;

    public Student() {
        System.out.println("创建了一个Student实例");
    }

    /**
     *
     */
    @Override
    public void setName1 (){
        System.out.println("调用了无参方法：setName1（）");
    }

    /**
     *
     * @param str
     */
    public void setName2 (String str){
        System.out.println("调用了有参方法setName2（String str）:" + str);
    }
}
