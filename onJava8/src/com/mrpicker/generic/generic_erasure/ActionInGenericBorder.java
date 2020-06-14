package com.mrpicker.generic.generic_erasure;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ActionInGenericBorder {
    class ArrayMaker<T> {
        Class<T> tClass;

        public ArrayMaker(Class<T> tClass) {
            this.tClass = tClass;
        }

        public T[] create(int size) {
            return (T[]) Array.newInstance(tClass, size);
        }
    }

    class ListMaker<T> {
        public List<T> create() {
            return new ArrayList<>();
        }
    }

    static class FilledList<T> extends ArrayList<T> {
        public FilledList(Supplier<T> supplier, int size) {
            IntStream.range(0, size).forEach(index -> add(index, supplier.get()));
        }

        public FilledList(T t, int size) {
            IntStream.range(0, size).forEach(index -> add(index, t));
        }
    }

    public static void main(String[] args){
        FilledList<Integer> filledList1 =new FilledList<>(47,5);
        FilledList<String> filledList2 =new FilledList<>(() -> "Hello",5);
        System.out.println(filledList1);
        System.out.println(filledList2);
    }
}
