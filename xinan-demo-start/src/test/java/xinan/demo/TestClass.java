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

import com.alibaba.securitysdk.fastjson.JSON;
import com.alibaba.securitysdk.fastjson.JSONArray;
import com.alibaba.securitysdk.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import xinan.demo.baselearn.classloader.Person;
import xinan.demo.baselearn.stream.User;

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
        String response = "%7B%22traceId%22%3A%222105836116097429575158900e31d5%22%2C%22code%22%3A0%2C%22data%22%3A%22AACBEA5B430C31717580DFF03FF6D96C9C90807F97C4314B9DC0159921CD00AC5108067BD53D77F21F2CEC35C0053CD80E5D4F37876C93E0343263C40A41B01CF1DBE204EE782D998E730431DBB8E8D33F42E3BA6737E3A10BC69C772021D24A1BB05E84ADCCEF088C704A6592AFFBD1CE77B3E1D2FDD24D4278313C4A6C4210B58E50AFCBCF133F1C34004CC49942FA8DD0EBE2A38051D28917E9E717AAE8933CC506AC0E51935792D54236855148250F5719132FEE1E40B90469B08F8FE6E3A79D58E96257543D8D1B04CCC034C6CCA76F4E40F7E730D95C13C686F7641D7CECCC37A5C2F77F8961E101EBF4CB22660C4A0E9BA879B5E83D41D95A46BCF3396A697D3F8F1316FDCB714AD2F33EF370A81061241583FB3FC8B90ECD8FACAB0D7A951CE2B9D2973D3910F91E8D4442FA751F393B057ADB113F62A8BDD25FB2BF0DAEE4707DAC70A59B173B2E945D307D7D322E53B07B085FE2B4C99F4377AB9763FD2FB53D34678D198075CB0E6472A7306185F12E865D23642E6525F897177737429206F3556BB6C46CF51C6C205446E59B574B325E1BD0AADB6F5CBFAEB44BF9E9725B3BD665384274BF675C76A00500E96EB3EC655E163318E340CDCABD191DA6D678F22B9D1195D3B9AC0574AB975C0B6CBD7FADA3E756072878285C6B1074FC5647983BDCA5C2ED5BAC61235DB639B50484AF7F89413F1570EAF67112F062EE0E1F8B9DFB4979E542D17E1E28339ED0382DEAE645CDE6EB124FE15A00FB49D69C5BF9D463694CD70D3A291FBAADC0385C0D653089447340B7DA00F8C41920C143FB8D152E1F1D609184411A0E2022E604DE39BD86299157C7A25A7D333035048502CE13B021BDB0237B82F23FC8C95919CD08AECCC74BC7C68B96001D19EF8B0548CC71B85F58C59A9ADEDC8622%22%2C%22message%22%3A%22%B2%D9%D7%F7%B3%C9%B9%A6%22%7D";
        String str =  URLDecoder.decode(response,"GB18030");
        System.out.println(str);
    }

    @Test
    public  void testEmptyData() throws UnsupportedEncodingException {
        String data ="%7B%22traceId%22%3A%222108231716098371002144600effa2%22%2C%22code%22%3A0%2C%22data%22%3A%7B%22own%22%3A%5B%7B%22appSearchUv%22%3A%7B%22ratio%22%3A0.1857%7D%2C%22statDate%22%3A%7B%22value%22%3A%222020-12-31%22%7D%2C%22id%22%3A%7B%22value%22%3A%22%B5%DA%D2%BB%B2%E3%BC%B6%22%7D%2C%22attrValue%22%3A%7B%22value%22%3A%22%B5%DA%D2%BB%B2%E3%BC%B6%22%7D%2C%22attrName%22%3A%7B%22value%22%3A%22purchase_level%22%7D%7D%2C%7B%22appSearchUv%22%3A%7B%22ratio%22%3A0.5681%7D%2C%22statDate%22%3A%7B%22value%22%3A%222020-12-31%22%7D%2C%22id%22%3A%7B%22value%22%3A%22%B5%DA%B6%FE%B2%E3%BC%B6%22%7D%2C%22attrValue%22%3A%7B%22value%22%3A%22%B5%DA%B6%FE%B2%E3%BC%B6%22%7D%2C%22attrName%22%3A%7B%22value%22%3A%22purchase_level%22%7D%7D%2C%7B%22appSearchUv%22%3A%7B%22ratio%22%3A0.1857%7D%2C%22statDate%22%3A%7B%22value%22%3A%222020-12-31%22%7D%2C%22id%22%3A%7B%22value%22%3A%22%B5%DA%C8%FD%B2%E3%BC%B6%22%7D%2C%22attrValue%22%3A%7B%22value%22%3A%22%B5%DA%C8%FD%B2%E3%BC%B6%22%7D%2C%22attrName%22%3A%7B%22value%22%3A%22purchase_level%22%7D%7D%2C%7B%22appSearchUv%22%3A%7B%22ratio%22%3A0.0386%7D%2C%22statDate%22%3A%7B%22value%22%3A%222020-12-31%22%7D%2C%22id%22%3A%7B%22value%22%3A%22%B5%DA%CB%C4%B2%E3%BC%B6%22%7D%2C%22attrValue%22%3A%7B%22value%22%3A%22%B5%DA%CB%C4%B2%E3%BC%B6%22%7D%2C%22attrName%22%3A%7B%22value%22%3A%22purchase_level%22%7D%7D%2C%7B%22appSearchUv%22%3A%7B%22ratio%22%3A0.0095%7D%2C%22statDate%22%3A%7B%22value%22%3A%222020-12-31%22%7D%2C%22id%22%3A%7B%22value%22%3A%22%B5%DA%CE%E5%B2%E3%BC%B6%22%7D%2C%22attrValue%22%3A%7B%22value%22%3A%22%B5%DA%CE%E5%B2%E3%BC%B6%22%7D%2C%22attrName%22%3A%7B%22value%22%3A%22purchase_level%22%7D%7D%2C%7B%22appSearchUv%22%3A%7B%22ratio%22%3A0.0031%7D%2C%22statDate%22%3A%7B%22value%22%3A%222020-12-31%22%7D%2C%22id%22%3A%7B%22value%22%3A%22%B5%DA%C1%F9%B2%E3%BC%B6%22%7D%2C%22attrValue%22%3A%7B%22value%22%3A%22%B5%DA%C1%F9%B2%E3%BC%B6%22%7D%2C%22attrName%22%3A%7B%22value%22%3A%22purchase_level%22%7D%7D%2C%7B%22appSearchUv%22%3A%7B%22ratio%22%3A0.0012%7D%2C%22statDate%22%3A%7B%22value%22%3A%222020-12-31%22%7D%2C%22id%22%3A%7B%22value%22%3A%22%B5%DA%C6%DF%B2%E3%BC%B6%22%7D%2C%22attrValue%22%3A%7B%22value%22%3A%22%B5%DA%C6%DF%B2%E3%BC%B6%22%7D%2C%22attrName%22%3A%7B%22value%22%3A%22purchase_level%22%7D%7D%2C%7B%22appSearchUv%22%3A%7B%22ratio%22%3A0.0004%7D%2C%22statDate%22%3A%7B%22value%22%3A%222020-12-31%22%7D%2C%22id%22%3A%7B%22value%22%3A%22%B5%DA%B0%CB%B2%E3%BC%B6%22%7D%2C%22attrValue%22%3A%7B%22value%22%3A%22%B5%DA%B0%CB%B2%E3%BC%B6%22%7D%2C%22attrName%22%3A%7B%22value%22%3A%22purchase_level%22%7D%7D%2C%7B%22appSearchUv%22%3A%7B%22ratio%22%3A0.0004%7D%2C%22statDate%22%3A%7B%22value%22%3A%222020-12-31%22%7D%2C%22id%22%3A%7B%22value%22%3A%22%B5%DA%BE%C5%B2%E3%BC%B6%22%7D%2C%22attrValue%22%3A%7B%22value%22%3A%22%B5%DA%BE%C5%B2%E3%BC%B6%22%7D%2C%22attrName%22%3A%7B%22value%22%3A%22purchase_level%22%7D%7D%2C%7B%22appSearchUv%22%3A%7B%22ratio%22%3A0.0004%7D%2C%22statDate%22%3A%7B%22value%22%3A%222020-12-31%22%7D%2C%22id%22%3A%7B%22value%22%3A%22%B5%DA%CA%AE%B2%E3%BC%B6%22%7D%2C%22attrValue%22%3A%7B%22value%22%3A%22%B5%DA%CA%AE%B2%E3%BC%B6%22%7D%2C%22attrName%22%3A%7B%22value%22%3A%22purchase_level%22%7D%7D%2C%7B%22appSearchUv%22%3A%7B%22ratio%22%3A0.0069%7D%2C%22statDate%22%3A%7B%22value%22%3A%222020-12-31%22%7D%2C%22id%22%3A%7B%22value%22%3A%22%CE%B4%D6%AA%22%7D%2C%22attrValue%22%3A%7B%22value%22%3A%22%CE%B4%D6%AA%22%7D%2C%22attrName%22%3A%7B%22value%22%3A%22purchase_level%22%7D%7D%5D%2C%22monitor%22%3A%5B%7B%22appSearchUv%22%3A%7B%22ratio%22%3A0.0507%7D%2C%22statDate%22%3A%7B%22value%22%3A%222020-12-31%22%7D%2C%22id%22%3A%7B%22value%22%3A%22%B5%DA%D2%BB%B2%E3%BC%B6%22%7D%2C%22attrValue%22%3A%7B%22value%22%3A%22%B5%DA%D2%BB%B2%E3%BC%B6%22%7D%2C%22attrName%22%3A%7B%22value%22%3A%22purchase_level%22%7D%7D%2C%7B%22appSearchUv%22%3A%7B%22ratio%22%3A0.3905%7D%2C%22statDate%22%3A%7B%22value%22%3A%222020-12-31%22%7D%2C%22id%22%3A%7B%22value%22%3A%22%B5%DA%B6%FE%B2%E3%BC%B6%22%7D%2C%22attrValue%22%3A%7B%22value%22%3A%22%B5%DA%B6%FE%B2%E3%BC%B6%22%7D%2C%22attrName%22%3A%7B%22value%22%3A%22purchase_level%22%7D%7D%2C%7B%22appSearchUv%22%3A%7B%22ratio%22%3A0.3416%7D%2C%22statDate%22%3A%7B%22value%22%3A%222020-12-31%22%7D%2C%22id%22%3A%7B%22value%22%3A%22%B5%DA%C8%FD%B2%E3%BC%B6%22%7D%2C%22attrValue%22%3A%7B%22value%22%3A%22%B5%DA%C8%FD%B2%E3%BC%B6%22%7D%2C%22attrName%22%3A%7B%22value%22%3A%22purchase_level%22%7D%7D%2C%7B%22appSearchUv%22%3A%7B%22ratio%22%3A0.1334%7D%2C%22statDate%22%3A%7B%22value%22%3A%222020-12-31%22%7D%2C%22id%22%3A%7B%22value%22%3A%22%B5%DA%CB%C4%B2%E3%BC%B6%22%7D%2C%22attrValue%22%3A%7B%22value%22%3A%22%B5%DA%CB%C4%B2%E3%BC%B6%22%7D%2C%22attrName%22%3A%7B%22value%22%3A%22purchase_level%22%7D%7D%2C%7B%22appSearchUv%22%3A%7B%22ratio%22%3A0.0477%7D%2C%22statDate%22%3A%7B%22value%22%3A%222020-12-31%22%7D%2C%22id%22%3A%7B%22value%22%3A%22%B5%DA%CE%E5%B2%E3%BC%B6%22%7D%2C%22attrValue%22%3A%7B%22value%22%3A%22%B5%DA%CE%E5%B2%E3%BC%B6%22%7D%2C%22attrName%22%3A%7B%22value%22%3A%22purchase_level%22%7D%7D%2C%7B%22appSearchUv%22%3A%7B%22ratio%22%3A0.0168%7D%2C%22statDate%22%3A%7B%22value%22%3A%222020-12-31%22%7D%2C%22id%22%3A%7B%22value%22%3A%22%B5%DA%C1%F9%B2%E3%BC%B6%22%7D%2C%22attrValue%22%3A%7B%22value%22%3A%22%B5%DA%C1%F9%B2%E3%BC%B6%22%7D%2C%22attrName%22%3A%7B%22value%22%3A%22purchase_level%22%7D%7D%2C%7B%22appSearchUv%22%3A%7B%22ratio%22%3A0.0069%7D%2C%22statDate%22%3A%7B%22value%22%3A%222020-12-31%22%7D%2C%22id%22%3A%7B%22value%22%3A%22%B5%DA%C6%DF%B2%E3%BC%B6%22%7D%2C%22attrValue%22%3A%7B%22value%22%3A%22%B5%DA%C6%DF%B2%E3%BC%B6%22%7D%2C%22attrName%22%3A%7B%22value%22%3A%22purchase_level%22%7D%7D%2C%7B%22appSearchUv%22%3A%7B%22ratio%22%3A0.0031%7D%2C%22statDate%22%3A%7B%22value%22%3A%222020-12-31%22%7D%2C%22id%22%3A%7B%22value%22%3A%22%B5%DA%B0%CB%B2%E3%BC%B6%22%7D%2C%22attrValue%22%3A%7B%22value%22%3A%22%B5%DA%B0%CB%B2%E3%BC%B6%22%7D%2C%22attrName%22%3A%7B%22value%22%3A%22purchase_level%22%7D%7D%2C%7B%22appSearchUv%22%3A%7B%22ratio%22%3A0.0011%7D%2C%22statDate%22%3A%7B%22value%22%3A%222020-12-31%22%7D%2C%22id%22%3A%7B%22value%22%3A%22%B5%DA%BE%C5%B2%E3%BC%B6%22%7D%2C%22attrValue%22%3A%7B%22value%22%3A%22%B5%DA%BE%C5%B2%E3%BC%B6%22%7D%2C%22attrName%22%3A%7B%22value%22%3A%22purchase_level%22%7D%7D%2C%7B%22appSearchUv%22%3A%7B%22ratio%22%3A0.0017%7D%2C%22statDate%22%3A%7B%22value%22%3A%222020-12-31%22%7D%2C%22id%22%3A%7B%22value%22%3A%22%B5%DA%CA%AE%B2%E3%BC%B6%22%7D%2C%22attrValue%22%3A%7B%22value%22%3A%22%B5%DA%CA%AE%B2%E3%BC%B6%22%7D%2C%22attrName%22%3A%7B%22value%22%3A%22purchase_level%22%7D%7D%2C%7B%22appSearchUv%22%3A%7B%22ratio%22%3A0.0065%7D%2C%22statDate%22%3A%7B%22value%22%3A%222020-12-31%22%7D%2C%22id%22%3A%7B%22value%22%3A%22%CE%B4%D6%AA%22%7D%2C%22attrValue%22%3A%7B%22value%22%3A%22%CE%B4%D6%AA%22%7D%2C%22attrName%22%3A%7B%22value%22%3A%22purchase_level%22%7D%7D%5D%7D%2C%22message%22%3A%22%B2%D9%D7%F7%B3%C9%B9%A6%22%7D";

        data = URLDecoder.decode(data,"GB18030");
        System.out.println(data);
        //转成功
        JSONObject jsonObject = JSONObject.parseObject(data);
        System.out.println(data);
        //转失败
        Object jsonResult = JSON.toJSON(data);

        if (jsonResult instanceof JSONObject){
            if (((JSONObject) jsonResult).size() == 0){
                System.out.println("empty json object");
            }

        } else if (jsonResult instanceof JSONArray){
            if (((JSONArray) jsonResult).size() == 0) {
                System.out.println("empty json array");
            }
        }

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

    @Test
    public void testObjectToJson(){
        User user = new User(1,"xinan");
        ArrayList<User> arrayList = new ArrayList<>();
        arrayList.add(user);
        Object jsonObject = JSON.toJSON(user);
        Object jsonArray = JSON.toJSON(arrayList);
        if (jsonObject instanceof JSONObject){
            JSONObject jsonObject1 = (JSONObject)jsonObject;
            System.out.println(jsonObject1);
            System.out.println(jsonObject);
        }
        if (jsonArray instanceof JSONArray){
            JSONArray jsonArray1 = (JSONArray)jsonArray;
            System.out.println(jsonArray1);
            System.out.println(jsonArray);
        }
    }


    @Test
    public void testForEach(){

        ArrayList<String> arrayList = new ArrayList<>();
        for (Object object:arrayList) {

        }
        System.out.println("0 size list can foreach");

        List list = null;
        try {
            for (Object object1:list) {

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("null cannot foreach");
        }
        System.out.println("test pass");
    }
}
