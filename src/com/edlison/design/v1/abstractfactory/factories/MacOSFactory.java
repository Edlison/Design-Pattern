package com.edlison.design.v1.abstractfactory.factories;

import com.edlison.design.v1.abstractfactory.buttons.Button;
import com.edlison.design.v1.abstractfactory.buttons.MacOSButton;
import com.edlison.design.v1.abstractfactory.checkboxes.CheckBox;
import com.edlison.design.v1.abstractfactory.checkboxes.MacOSCheckBox;

/**
 * MacOSFactory
 * 具体工厂MacOS
 *
 * @Author Edlison
 * @Date 1/26/21 13:28
 */
public class MacOSFactory implements GUIFactory{

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacOSCheckBox();
    }
}
