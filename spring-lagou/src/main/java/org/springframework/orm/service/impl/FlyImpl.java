package org.springframework.orm.service.impl;

import org.springframework.orm.service.Fly;

public class FlyImpl implements Fly {
    @Override
    public void fly() {
        System.out.println("++++++++++++++++ Fly ++++++++++++++++");
    }
}
