package xinan.demo;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.securitysdk.fastjson.JSONArray;
import com.alibaba.securitysdk.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
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

    /**
     * 测试url解码
     */
    @Test
    public void testUrlDecode() throws UnsupportedEncodingException {
        String response = "%7B%22hasError%22%3Afalse%2C%22content%22%3A%7B%22traceId%22%3A%220b5114a216086098134844300ea2cb%22%2C%22code%22%3A0%2C%22data%22%3A%7B%22updateTime%22%3A%222020-12-22+12%3A03%3A33%22%2C%22interval%22%3A30%2C%22timestamp%22%3A1608609813532%2C%22data%22%3A%7B%22yesterday%22%3A%7B%22uv%22%3A%5B263%2C361%2C415%2C456%2C483%2C540%2C618%2C817%2C1095%2C1427%2C1820%2C2258%2C2598%2C3005%2C3397%2C3827%2C4224%2C4538%2C4805%2C5158%2C5535%2C5973%2C6333%2C6582%5D%2C%22payByrCnt%22%3A%5B1%2C2%2C2%2C2%2C3%2C3%2C3%2C3%2C5%2C11%2C17%2C36%2C49%2C58%2C91%2C114%2C124%2C130%2C133%2C140%2C148%2C153%2C157%2C162%5D%2C%22pv%22%3A%5B776%2C1153%2C1271%2C1436%2C1486%2C1668%2C1850%2C2233%2C2913%2C3731%2C4686%2C6125%2C7314%2C8579%2C10535%2C12059%2C13235%2C14257%2C15272%2C16537%2C17643%2C18990%2C20177%2C21198%5D%2C%22payOrdCnt%22%3A%5B2%2C3%2C4%2C4%2C5%2C5%2C5%2C5%2C8%2C16%2C22%2C72%2C102%2C117%2C219%2C270%2C288%2C300%2C304%2C312%2C321%2C327%2C333%2C356%5D%2C%22payCnt%22%3A%5B2%2C3%2C4%2C4%2C5%2C5%2C5%2C5%2C8%2C16%2C22%2C124%2C154%2C169%2C272%2C327%2C345%2C360%2C443%2C451%2C460%2C466%2C472%2C495%5D%2C%22payAmt%22%3A%5B138.0%2C377.0%2C446.0%2C446.0%2C532.24%2C532.24%2C532.24%2C532.24%2C989.84%2C2801.99%2C5093.789999999999%2C17522.9%2C25789.379999999994%2C27915.939999999995%2C52364.85999999999%2C65594.50000000001%2C70811.59999999999%2C73657.11999999998%2C74414.90000000002%2C76040.59%2C78124.39%2C79718.62999999998%2C81385.06999999999%2C84119.37%5D%2C%22statHour%22%3A%5B%2200%22%2C%2201%22%2C%2202%22%2C%2203%22%2C%2204%22%2C%2205%22%2C%2206%22%2C%2207%22%2C%2208%22%2C%2209%22%2C%2210%22%2C%2211%22%2C%2212%22%2C%2213%22%2C%2214%22%2C%2215%22%2C%2216%22%2C%2217%22%2C%2218%22%2C%2219%22%2C%2220%22%2C%2221%22%2C%2222%22%2C%2223%22%5D%7D%2C%22today%22%3A%7B%22uv%22%3A%5B260%2C350%2C411%2C442%2C480%2C525%2C613%2C786%2C1068%2C1447%2C1956%2C2410%2C2424%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%5D%2C%22payByrCnt%22%3A%5B3%2C3%2C3%2C3%2C3%2C3%2C4%2C5%2C8%2C11%2C25%2C44%2C44%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%5D%2C%22pv%22%3A%5B762%2C1063%2C1235%2C1301%2C1432%2C1626%2C1817%2C2200%2C2903%2C3822%2C5515%2C7259%2C7335%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%5D%2C%22payOrdCnt%22%3A%5B4%2C4%2C4%2C4%2C4%2C4%2C5%2C6%2C9%2C13%2C37%2C99%2C99%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%5D%2C%22payAmt%22%3A%5B684.5%2C684.5%2C684.5%2C684.5%2C684.5%2C684.5%2C810.5%2C1165.74%2C1952.52%2C3503.95%2C8877.43%2C22206.86%2C22206.86%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%5D%2C%22statHour%22%3A%5B%2200%22%2C%2201%22%2C%2202%22%2C%2203%22%2C%2204%22%2C%2205%22%2C%2206%22%2C%2207%22%2C%2208%22%2C%2209%22%2C%2210%22%2C%2211%22%2C%2212%22%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%5D%7D%7D%7D%2C%22message%22%3A%22%B2%D9%D7%F7%B3%C9%B9%A6%22%7D%7D\n";
        String str =  URLDecoder.decode(response,"GB18030");
        System.out.println(str);
    }

    @Test
    public void testJson() throws IOException {
        File file = new File("/Users/xinan/demo.json");
        String content = FileUtils.readFileToString(file);
        //对基本类型的解析
        JSONObject obj = JSONObject.parseObject(content);
        System.out.println(obj.get("array") instanceof JSONArray);
        System.out.println(obj.get("array") instanceof JSONObject);
        System.out.println(obj.get("object") instanceof JSONObject);
        System.out.println(obj.get("object") instanceof JSONArray);
        System.out.println("color：" + obj.getString("color"));
        System.out.println("number" + obj.getIntValue("number"));
        System.out.println("boolean" + obj.getBoolean("boolean"));
        //对数组的解析
        JSONArray array = obj.getJSONArray("array");
        System.out.println("array：");
        for (int i = 0; i < array.size(); i++) {
            int s = (int) array.get(i);
            System.out.println(s);
        }
    }
}
