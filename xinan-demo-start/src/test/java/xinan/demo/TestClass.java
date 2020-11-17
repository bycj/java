package xinan.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import xinan.demo.baselearn.classloader.Person;

/**
 * @author xinan
 * @date 2020/09/04
 */
public class TestClass {

    @Test
    /**
     * test classloader
     */
    public void testClassLoader(){
            System.out.println("1-"+ClassLoader.getSystemClassLoader());
            //extensions class loader
            System.out.println("2-"+ClassLoader.getSystemClassLoader().getParent());
            //bootstrap class loader
            System.out.println("3"+ClassLoader.getSystemClassLoader().getParent().getParent());

            Map queryResult = new HashMap();
            queryResult.put("uv", 1);
            queryResult.put("pv", 1);

            List<String>indexList = new ArrayList<>();
            indexList.add("uv");

            Map<String,Object> monitorResult = new HashMap<String,Object>();
            for(String index:indexList){
                if (queryResult.containsKey(index)){
                    monitorResult.put(index,queryResult.get((index)));
                }
            }

            System.out.println("queryResult:"+monitorResult);

    }

    @Test
    public void testValueOrRef(){
        ArrayList<Person>arrayList = new ArrayList<>();
       for (int i=0;i<10;i++){
           Person person = new Person("name"+i);
           arrayList.add(person);
       }
       System.out.println(arrayList);
    }

    /**
     * 测试map的遍历
     */
    @Test
    public void testMapIterator(){
        List<Map<String,Object>>list1 = new ArrayList<>();
        List<Map<String,Object>>list2 = new ArrayList<>();
        List<Map<String,Object>>list3 = new ArrayList<>();
        for (Map<String,Object> map1 : list2){
            String pageId1 = (String)map1.get("pageId");
            for (Map<String,Object>map2 :list2){
                if (!map2.containsKey(pageId1)){
                    list3.add(map2);
                }
            }
        }
    }
}
