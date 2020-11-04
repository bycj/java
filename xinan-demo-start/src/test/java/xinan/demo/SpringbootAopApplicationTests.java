package xinan.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xinan.demo.baselearn.proxy.Stu;
import xinan.demo.service.UserService;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAopApplicationTests {

    @Resource
    private Stu stu;

    @Test
    public void testAop1() {
        stu.setName1();
    }


}

