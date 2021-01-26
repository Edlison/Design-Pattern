package com.edlison.design.v1.abstractfactory.checkboxes;

/**
 * WindowsCheckBox
 *
 * @Author Edlison
 * @Date 1/26/21 13:20
 */
public class WindowsCheckBox implements CheckBox{
    @Override
    public void submit() {
        System.out.println("This is Windows");
        System.out.println("Windows CheckBox Click!");
    }
}
