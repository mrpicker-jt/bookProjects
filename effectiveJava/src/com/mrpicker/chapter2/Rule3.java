package com.mrpicker.chapter2;

import com.mrpicker.base.BaseRule;

/**
 * @program: effectiveJava
 * @description: 用私有构造器或者枚举类型强化Singleton属性
 * @author: Mrpicker
 * @create: 2020-06-09 17:06
 **/
public class Rule3 extends BaseRule {

    public Rule3() {
        super("用私有构造器或者enum强化Singleton属性");
        addKeyPoint("方式1：使用一个公有域来实现单例");
        addKeyPoint("方式2：使用一个静态工厂方法实现");
        addKeyPoint("方式3：使用enum来实现单例（推荐）");
    }
}

/**
 * 方式1：使用一个公有域来实现单例
 * 优势1：使用final修饰的instance保证引用不可变
 * 优势2；简单
 * 劣势1：无法防止序列化和反序列化来制造fake的instance实例。必须声明所有域transient的，并且提供一个readResolve()方法(See Rule89 for detail)
 */
class Singleton1 {
    public static final Singleton1 instance = new Singleton1();

    private Singleton1() {
        if (instance != null) {
            throw new IllegalStateException("can't be created twice");
        }
    }


    //readResolve method to preserve singleton property
    private Object readResolve() {
        return instance;
    }
}


/**
 * 方式2：使用一个静态工厂方法实现
 * 优势1：可以很容易修改工厂方法。例如改成为每个调用的线程提供一个单例
 * 优势2：如果需要，可以改造成一个泛型Singleton工厂（See Rule30）
 * 优势3：可以通过方法引用作为一个提供者。例如Singleton2::getInstance 就可以作为一个 Supplier<Singleton2> 接口
 * 除非满足以上三个优势之一，否则优先使用公有域来实现单例
 * 劣势1：无法防止序列化和反序列化来制造fake的instance实例。必须声明所有域transient的，并且提供一个readResolve()方法(See Rule89 for detail)
 */
class Singleton2 {
    private static final Singleton2 instance = new Singleton2();

    private Singleton2() {
        if (instance != null) {
            throw new IllegalStateException("can't be created twice");
        }
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}

/**
 * 方式3：使用enum来实现单例（推荐）
 * 优势1：与公有域实现单例的方法类似，但是更简洁
 * 优势2：无偿提供了序列化机制，绝对防止多次实例化，即使面对复杂的反射和序列化攻击的时候。
 * 劣势：如果Singleton必须extends一个超类，则不适合用这个方法。
 */
enum Singleton3{
    INSTANCE
}

