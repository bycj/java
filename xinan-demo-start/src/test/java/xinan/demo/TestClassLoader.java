package xinan.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * @author xinan
 * @date 2020/09/04
 */
public class TestClassLoader {
    @Test
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
}
