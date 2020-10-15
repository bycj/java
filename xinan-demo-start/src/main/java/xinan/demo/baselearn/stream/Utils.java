package xinan.demo.baselearn.stream;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinan
 * @date 2020/02/27
 */

public class Utils {

    static class A{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Cat> getCats() {
            return cats;
        }

        public void setCats(List<Cat> cats) {
            this.cats = cats;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        private List<Cat> cats;
        private String age;
    }
    static class Cat{
        private String color;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }


        private String price;
        private List<Integer> counts;

        public List<Integer> getCounts() {
            return counts;
        }

        public void setCounts(List<Integer> counts) {
            this.counts = counts;
        }
    }


    static class A1{
        private String name;
        private List<Cat1> cats;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Cat1> getCats() {
            return cats;
        }

        public void setCats(List<Cat1> cats) {
            this.cats = cats;
        }
    }
    static class Cat1{
        private String color;

        public String getColor2() {
            return color2;
        }

        public void setColor2(String color2) {
            this.color2 = color2;
        }

        private String color2;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        private String price;

    }
public static void main(String args[]){
    //开始复制
    A a=new A();
    a.setName("cd");
    a.setAge("11");
    Cat cat=new Cat();
    cat.setColor("red");
    cat.setPrice("200");
    List<Integer>counts = new ArrayList<>();
    counts.add(1);
    cat.setCounts(counts);
    List<Cat>cats=new ArrayList<>();
    cats.add(cat);
    a.setCats(cats);

    A1 a1=new A1();
    BeanUtils.copyProperties(a,a1);
    System.out.print(a1);
    System.out.print(a1);
    ////我们想得到的a1为
    //a1:{"name":"cd","cat":{"price":"200","color":"red"}}
    ////实际的结果为
    //a1:{"name":"cd","cat":{"price":"200","color":"red","count":"20"}}
    ////所以大家进行属性复制的时候注意List，当有List的时候我们要取出来一个一个复制

}

}
