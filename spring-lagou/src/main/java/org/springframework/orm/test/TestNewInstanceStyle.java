package org.springframework.orm.test;

import sun.reflect.ReflectionFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2021/08/23/上午10:45
 * @Description:
 */

public class TestNewInstanceStyle {
    public static class TestObject{
        public String name = "fujian";
    }

    /**
     * 通过反射来实例化类的三种方式
     * java.lang.Class.newInsance()
     * java.lang.reflect.Constructor.newInstance()
     * sun.reflect.ReflectionFactory.newConstructorForSerialization().newInstance()
     * @param args
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public static void main(String[] args)
            throws IllegalAccessException, InvocationTargetException, InstantiationException {
        ReflectionFactory reflectionFactory = ReflectionFactory.getReflectionFactory();
        Constructor<?> constructor = reflectionFactory.newConstructorForSerialization(TestObject.class);
        constructor.setAccessible(true);
        TestObject testObject = (TestObject) constructor.newInstance();
        System.out.println(testObject.name);

        //普通方式
        TestObject testObject1 = new TestObject();
        System.out.println(testObject1.name);

    }
}
