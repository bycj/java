package xinan.demo.baselearn.io;

/**
 * @description:
 * @author: xinan
 * @create: 2021-03-09 11:41
 **/
public class Employee implements java.io.Serializable {
    // 加入序列版本号
    private static final long serialVersionUID = 1L;
    public String name;
    public String address;
    // 添加新的属性 ,重新编译, 可以反序列化,该属性赋为默认值.
    public int eid;
    public int eid2;
    public transient int age; // transient瞬态修饰成员,不会被序列化
    public void addressCheck() {
        System.out.println("Address  check : " + name + " --- " + address);
    }
}
