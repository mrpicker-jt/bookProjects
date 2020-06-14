package com.mrpicker.java_enum;

import java.util.Random;
import java.util.stream.IntStream;

enum TestEnum {
    TEST1, TEST2, TEST3, TEST4, TEST5
}

public class Enums {

    private static Random random = new Random(47);

    public static void main(String[] a) {
        IntStream.range(0,10).forEach(i -> System.out.println(randomGet(TestEnum.class)));
    }

    public static  <T extends Enum<T>> T randomGet(Class<T> enumClass) {
        T[] enumConstants = enumClass.getEnumConstants();
        return enumConstants[random.nextInt(enumConstants.length)];
    }
}
