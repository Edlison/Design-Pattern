package com.edlison.design.v1.abstractfactory;

import com.edlison.design.v1.abstractfactory.app.Application;
import com.edlison.design.v1.abstractfactory.factories.GUIFactory;
import com.edlison.design.v1.abstractfactory.factories.MacOSFactory;
import com.edlison.design.v1.abstractfactory.factories.WindowsFactory;

/**
 * AbstractFactoryTest
 * 运行类
 *
 * @Author Edlison
 * @Date 1/26/21 13:46
 */
public class AbstractFactoryTest {
    // 对Application进行配置
    private static Application configureApplication() {
        Application app;
        GUIFactory factory;

        // 获取需要实例化的条件
        String osName = System.getProperty("os.name").toLowerCase();

        // 根据情况进行实例化工厂
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            factory = new WindowsFactory();
        }

        // 工程装载进Application
        app = new Application(factory);

        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        System.out.println(app.getButton());
        System.out.println(app.getCheckBox());
        app.run();
    }
}
