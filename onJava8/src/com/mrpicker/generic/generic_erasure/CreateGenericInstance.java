package com.mrpicker.generic.generic_erasure;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class CreateGenericInstance {
    public static void main(String[] args){
        //方式1：通过获取到Class<T> 泛型来创建，但是只适用于无参构造函数。pass
//        GenericCreator1<Emploee> genericCreator1=new GenericCreator1<>(Emploee.class);
//        System.out.println(genericCreator1.get());
//        GenericCreator1<Integer> genericCreator2=new GenericCreator1<>(Integer.class);
//        System.out.println(genericCreator2.get());

        //方式2：通过实现Supplier<T>泛型来创建
//        System.out.println(new EmploeeCreator().get());
//        IntegerCreator integerCreator=new IntegerCreator();
//        IntStream.range(0,5).forEach(index -> System.out.println(integerCreator.get()));

        //方式3：通过构建一个Creator<T>基类来实现
        new EmploeeCreator2().f();


    }
}

class GenericCreator1<T> implements Supplier<T> {
    Class<T> tClass;


    public GenericCreator1(Class<T> tClass) {
        this.tClass = tClass;
    }

    @Override
    public T get() {
        try {
            return tClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

class IntegerCreator implements Supplier<Integer>{

    static int anInt;

    @Override
    public Integer get() {
        return anInt++;
    }
}

class EmploeeCreator implements Supplier<Emploee>{

    @Override
    public Emploee get() {
        try {
            return Emploee.class.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

abstract class AbstractCreator<T> {
    protected T t;

    public AbstractCreator(){
        t=create();
    }

    protected abstract T create();

}

class EmploeeCreator2 extends AbstractCreator<Emploee>{

    @Override
    protected Emploee create() {
        return new Emploee();
    }

    public void f(){
        System.out.println(t.toString());
    }
}

class Emploee{
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
