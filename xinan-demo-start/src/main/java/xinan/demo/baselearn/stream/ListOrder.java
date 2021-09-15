package xinan.demo.baselearn.stream;

import java.util.*;

/**
 * @author xinan
 * @date 2020/02/27
 */
public class ListOrder {
    public static void main(String arfs[]){
        List<User> users = new ArrayList<>(5);
        User user1 = new User(null, "cj123");
        User user2 = new User(3, "cj1");
        User user3 = new User(null, "cj12");
        User user4 = new User(5, "cj1");
        User user5 = new User(1, "cj1");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if (o1.getId()==null && o2.getId()==null){
                    return -1;
                }
                if(o1.getId()==null ){
                    return 1;
                }
                else if(o2.getId()==null){
                    return -1;
                }
                return o2.getId().compareTo(o1.getId());
            }
        });
        System.out.println(users);
    }
}
