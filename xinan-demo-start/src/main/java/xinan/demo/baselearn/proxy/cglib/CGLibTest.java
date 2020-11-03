package xinan.demo.baselearn.proxy.cglib;


import xinan.demo.baselearn.proxy.Student;

public class CGLibTest {
    public static void main(String[] args) {
        Student student = (Student) new CGLibProxy().createProxyObject(new Student());
        student.setName2("xinan");
    }
}
