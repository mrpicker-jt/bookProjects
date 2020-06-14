package com.mrpicker.generic.generic_interface;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}


class Latte extends Coffee {
}


class Mocha extends Coffee {
}


class Cappuccino extends Coffee {
}


class Americano extends Coffee {
}


class Breve extends Coffee {
}

class CoffeeSupplier<T> implements Iterable<T>, Supplier<T> {
    List<Class<?>> coffeeTypes = Arrays.asList(Latte.class, Mocha.class,
            Cappuccino.class, Americano.class, Breve.class);

    Random random = new Random(47);
    int size;

    public CoffeeSupplier() {

    }

    public CoffeeSupplier(int size) {
        this.size = size;
    }

    public static void main(String[] args) {
//        Stream.generate(new CoffeeSupplier<>()).limit(5).forEach(System.out::println);
        CoffeeSupplier<Coffee> coffeeSupplier = new CoffeeSupplier<>(5);
        for (Coffee coffee : coffeeSupplier) {
            System.out.println(coffee);
        }
        coffeeSupplier.supplyCoffee(10);
        for (Coffee coffee : coffeeSupplier) {
            System.out.println(coffee);
        }
    }

    public void supplyCoffee(int count) {
        size += count;
    }

    @Override
    public Iterator<T> iterator() {
        return new CoffeeIterator();
    }

    @Override
    public T get() {
        try {
            return (T) coffeeTypes.get(random.nextInt(coffeeTypes.size())).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    class CoffeeIterator implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return size > 0;
        }

        @Override
        public T next() {
            size--;
            return get();
        }
    }
}
