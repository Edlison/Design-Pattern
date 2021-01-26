package com.edlison.design.v1.abstractfactory.buttons;

/**
 * WindowsButton
 *
 * @Author Edlison
 * @Date 1/26/21 13:20
 */
public class WindowsButton implements Button{

    @Override
    public void print() {
        System.out.println("This is Windows");
        System.out.println("Windows Button Click!");
    }
}
