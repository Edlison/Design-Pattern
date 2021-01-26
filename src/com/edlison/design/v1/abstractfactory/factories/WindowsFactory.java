package com.edlison.design.v1.abstractfactory.factories;

import com.edlison.design.v1.abstractfactory.buttons.Button;
import com.edlison.design.v1.abstractfactory.buttons.WindowsButton;
import com.edlison.design.v1.abstractfactory.checkboxes.CheckBox;
import com.edlison.design.v1.abstractfactory.checkboxes.WindowsCheckBox;

/**
 * WindowsFactory
 * 具体工厂Windows
 *
 * @Author Edlison
 * @Date 1/26/21 13:28
 */
public class WindowsFactory implements GUIFactory{

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}
