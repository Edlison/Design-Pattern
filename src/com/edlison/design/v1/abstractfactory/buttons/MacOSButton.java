package com.edlison.design.v1.abstractfactory.buttons;

/**
 * MacOSButton
 *
 * @Author Edlison
 * @Date 1/26/21 13:20
 */
public class MacOSButton implements Button{

    @Override
    public void print() {
        System.out.println("This is MacOS");
        System.out.println("MacOS Button Click!");
    }
}
