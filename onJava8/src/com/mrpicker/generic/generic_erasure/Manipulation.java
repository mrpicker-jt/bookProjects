package com.mrpicker.generic.generic_erasure;

class Manipulator<T> {
    private T obj;

    Manipulator(T x) {
        obj = x;
    }

    // compile Error: cannot find symbol: method f():
    public void manipulate() {
//        obj.f();
    }
}

class Manipulator2<T extends HasF> {
    private T obj;

    Manipulator2(T x) {
        obj = x;
    }

    // T 必须有HasF的泛型边界
    public void manipulate() {
        obj.f();
    }
}

// Manipulator2 擦除泛型后等同于 Manipulator3
class Manipulator3 {
    private HasF obj;

    Manipulator3(HasF x) {
        obj = x;
    }

    public void manipulate() {
        obj.f();
    }
}

class HasF {
    public void f() {
        System.out.println("HasF.f()");
    }
}

public class Manipulation {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator2<HasF> manipulator = new Manipulator2<>(hf);
        manipulator.manipulate();
    }
}