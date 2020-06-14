package com.mrpicker.java_enum;

import java.util.stream.Stream;

enum DescripEnum {
    FOOTBALL("this is football"),
    BASKETBALL("haha,i play it"),
    PINGPONG("popular in china");

    private String description;

    DescripEnum(String description) {
        this.description = description;
    }

    //add method for enum
    public String getDescription() {
        return description;
    }


    //override method in enum
    @Override
    public String toString() {
        return name() + "---" + description;
    }
}

public class AddEnumMethod {
    public static void main(String[] a) {
        Stream.of(DescripEnum.values()).forEach(System.out::println);
    }
}
