import com.edlison.design.spring.aop.style_anno.AnnoAOPConfig;
import com.edlison.design.spring.aop.style_anno.LoginService;
import com.edlison.design.spring.aop.style_api.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring_AOP_Test
 *
 * @Author Edlison
 * @Date 2/2/21 22:10
 */
public class Spring_AOP_Test {

    @Test
    public void Test1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-aop-api.xml");
        // 动态代理的是接口
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
        userService.delete();
        userService.update();
        userService.query();
    }

    @Test
    public void Test2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-aop-aspect.xml");
        // 动态代理的是接口
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
        userService.delete();
        userService.update();
        userService.query();
    }

    @Test
    public void Test3() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnoAOPConfig.class);

        LoginService userService = context.getBean("loginService", LoginService.class);
        userService.login();
    }
}
