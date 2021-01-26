package com.edlison.design.v1.abstractfactory.checkboxes;

/**
 * MacOSCheckBox
 *
 * @Author Edlison
 * @Date 1/26/21 13:20
 */
public class MacOSCheckBox implements CheckBox{
    @Override
    public void submit() {
        System.out.println("This is MacOS");
        System.out.println("MacOS CheckBox Click!");
    }
}
