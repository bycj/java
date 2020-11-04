package xinan.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.taobao.pandora.boot.PandoraBootstrap;
import xinan.demo.baselearn.proxy.Stu;

/**
 * Pandora Boot应用的入口类
 *
 * @author chengxu
 */
@SpringBootApplication(scanBasePackages = {"xinan.demo"})
public class Application {

    public static void main(String[] args) {
        PandoraBootstrap.run(args);
        SpringApplication.run(Application.class, args);
        PandoraBootstrap.markStartupAndWait();
    }
}
