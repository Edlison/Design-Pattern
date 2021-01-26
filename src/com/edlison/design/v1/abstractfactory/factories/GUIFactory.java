package com.edlison.design.v1.abstractfactory.factories;

import com.edlison.design.v1.abstractfactory.buttons.Button;
import com.edlison.design.v1.abstractfactory.checkboxes.CheckBox;

/**
 * GUIFactory
 * 抽象工厂
 *
 * @Author Edlison
 * @Date 1/26/21 13:26
 */
public interface GUIFactory {
    Button createButton();
    CheckBox createCheckBox();
}
