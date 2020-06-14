package com.mrpicker.pets;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.stream.Stream;

/**
 * Created by 姜腾 on 2020/5/26.
 */
public class ShowMethod {
    public static void show(String className){
        try {
            Class<?> aClass = Class.forName(className);
            Method[] methods = aClass.getMethods();
            Constructor<?>[] constructors = aClass.getConstructors();
            Stream.of(methods).map(method -> method.toString().replaceAll("\\w+\\.","")).forEach(System.out::println);
            Stream.of(constructors).map(method -> method.toString().replaceAll("\\w+\\.","")).forEach(System.out::println);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
