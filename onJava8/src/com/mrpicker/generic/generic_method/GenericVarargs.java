package com.mrpicker.generic.generic_method;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenericVarargs {
    @SafeVarargs
    public static <T> List<T> makeList(T... args) {
        return Stream.of(args).collect(Collectors.toList());
    }

    
    public static void main(String[] args){
        List<String> a = makeList("A");
        System.out.println(a.getClass().getName());
        System.out.println(a);
        List<Integer> integers = makeList(1, 2, 3, 4);
        integers.stream().map(integer -> integer+" ").forEach(System.out::print);
    }
}
