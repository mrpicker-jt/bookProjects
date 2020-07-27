package com.mrpicker.chapter4;

import com.mrpicker.base.BaseRule;

/**
 * @program: effectiveJava
 * @description: 使可变性最小化
 * @author: Mrpicker
 * @create: 2020-07-23 15:43
 **/
public class Rule17 extends BaseRule {
    public Rule17(){
        super("使可变性最小化");
        addKeyPoint("要让类成为不可变，要遵循下面五条规则：\n" +
                "1.不要提供任何会修改对象状态的方法\n" +
                "2.保证类不会被拓展（一般做法是声明为final）\n" +
                "3.声明所有的域是final的\n" +
                "4.声明所有的域是私有的\n" +
                "5.确保任何可变组件的互斥访问。如果类具有指向可变对象的域，则必须确保使用该类的客户端无法获得指向这些对象的引用");
        addKeyPoint("不可变对象比较简单，本质上是线程安全的，它们不要求同步，可以被自由地共享");
        addKeyPoint("不仅可以共享不可变对象，还可以共享它们的内部信息");
        addKeyPoint("不可变对象为其他元素提供了大量的构件，如 map key");
        addKeyPoint("不可变对象无偿提供了失败的原子性");
        addKeyPoint("不可变类真正惟一的缺点是：对于每个不同的值都需要一个单独的对象");
        addKeyPoint("除非有很好的理由让类成为可变的类，否则它就应该是不可变类");
        addKeyPoint("如果类不能做成不可变的，也要尽可能降低它的可变性");
    }
}
