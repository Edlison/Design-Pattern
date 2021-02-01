import com.edlison.design.spring.ioc.config.AppConfig;
import com.edlison.design.spring.ioc.pojo.People;
import com.edlison.design.spring.ioc.pojo.Role;
import com.edlison.design.spring.ioc.pojo.Student;
import com.edlison.design.spring.ioc.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * MyTest
 *
 * @Author Edlison
 * @Date 2/1/21 09:25
 */
@Component
public class Spring_IOC_Test {
    public static void main(String[] args) {
        // 创建容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService bean = (UserService) context.getBean("userService");
        System.out.println("bean.getUserDAO() = " + bean.getUserDAO());
    }

    @Test
    public void testDI() {
        // 不能只引入userBeans.xml 这样的话address 的Bean将不会被导入
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = context.getBean("userService", UserService.class);
        UserService userServicePlus = context.getBean("userServicePlus", UserService.class);
        System.out.println("userService = " + userService);
        System.out.println("userServicePlus = " + userServicePlus);
        System.out.println("(userService == userServicePlus) = " + (userService == userServicePlus));
    }

    @Test
    public void testScope() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userServiceSingleA = context.getBean("userService", UserService.class);
        UserService userServiceSingleB = context.getBean("userService", UserService.class);

        UserService userServiceProtoA = context.getBean("userServicePlus", UserService.class);
        UserService userServiceProtoB = context.getBean("userServicePlus", UserService.class);

        System.out.println("Singleton: " + (userServiceSingleA == userServiceSingleB));
        System.out.println("Prototype: " + (userServiceProtoA == userServiceProtoB));
    }

    @Test
    public void testAuto() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        People peopleAutoByName = context.getBean("peopleAutoByName", People.class);

        peopleAutoByName.getCat().shout();
        peopleAutoByName.getDog().shout();

        People peopleAutoByType = context.getBean("peopleAutoByType", People.class);

        peopleAutoByType.getCat().shout();
        peopleAutoByType.getDog().shout();

        System.out.println("is people eq: " + (peopleAutoByName == peopleAutoByType));
        System.out.println("is cat/dog eq: " + (peopleAutoByName.getDog() == peopleAutoByType.getDog()) + (peopleAutoByName.getCat() == peopleAutoByType.getCat()));
    }

    @Test
    public void testAnno() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-anno.xml");

        Role roleA = context.getBean("role", Role.class);
        Role roleB = context.getBean("role", Role.class);

        System.out.println("role.getRole_name() = " + roleA.getRole_name());
        System.out.println("roleB.getRole_name() = " + roleB.getRole_name());
        System.out.println("(roleA == roleB) = " + (roleA == roleB));
    }

    @Test
    public void testConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Student student = context.getBean("getStu", Student.class);

        System.out.println(student);

    }
}