package com.edlison.design.v1.abstractfactory.app;

import com.edlison.design.v1.abstractfactory.buttons.Button;
import com.edlison.design.v1.abstractfactory.checkboxes.CheckBox;
import com.edlison.design.v1.abstractfactory.factories.GUIFactory;

/**
 * Application
 * 客户端
 *
 * @Author Edlison
 * @Date 1/26/21 13:35
 */
public class Application {
    private GUIFactory factory;

    public Application(GUIFactory factory) {
        this.factory = factory;
    }

    public Button getButton() {
        return this.factory.createButton();
    }

    public CheckBox getCheckBox() {
        return this.factory.createCheckBox();
    }

    public void run() {
        System.out.println("this.factory.createButton() = " + this.factory.createButton());
        System.out.println("this.factory.createCheckBox() = " + this.factory.createCheckBox());
    }
}
