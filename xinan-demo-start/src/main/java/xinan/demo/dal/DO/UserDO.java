package xinan.demo.dal.DO;

import io.swagger.models.auth.In;
import lombok.Data;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.text.DecimalFormat;
import java.util.*;

/**
 * @author xinan
 * @date 2020/05/23
 */
@Data
public class UserDO implements Comparable<UserDO>{
    private Integer id;
    private String age;
    private String name;
    private String sex;

    @Override
    public int compareTo(UserDO userDO) {
        if (this.getId().equals(userDO.getId())) {
            return 0;
        }
        return this.getId()-userDO.getId()>0? 1:-1;
    }

    public static void main (String args[]){
        Map<String,Integer> map = new HashMap<>();
        List<Map.Entry<String,Integer>> list1 = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        list1.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        });
        for (Map.Entry<String,Integer>entry:list1) {
            System.out.print(entry.getValue());
        }
        UserDO userDO = new UserDO();
        userDO.setId(1);
        UserDO userDO2 = new UserDO();
        userDO2.setId(3);
        UserDO userDO3 = new UserDO();
        userDO3.setId(2);
        List<UserDO>list = new ArrayList<>();
        list.add(userDO);
        list.add(userDO2);
        list.add(userDO3);
        list.sort(new Comparator<UserDO>() {
            @Override
            public int compare(UserDO o1, UserDO o2) {
                return o1.getId()-o2.getId();
            }
        });
        list.forEach(e->System.out.print(e));
        System.out.print(userDO.compareTo(userDO2));
    }
}
