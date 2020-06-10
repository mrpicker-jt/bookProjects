package com.mrpicker.chapter2;

import com.mrpicker.base.BaseRule;

/**
 * @program: effectiveJava
 * @description: 通过私有构造器强化不可实例化的能力
 * @author: Mrpicker
 * @create: 2020-06-10 15:26
 **/
public class Rule4 extends BaseRule {
    public Rule4() {
        super("通过私有构造器强化不可实例化的能力");
        addKeyPoint("像工具类这种不想被实例化的类适用");
        addKeyPoint("适用抽象类来强制不可实例化是行不通的，因为子类可以继承后再实例化");
        addKeyPoint("通常使用私有构造器方法来实现不可实例化");
        addWeakPoint("使用私有构造器的话也无法被子类化了。因为子类实例化的时候会隐式或显式的调用超类的构造器方法");
    }
}

//Non instantiable Util Class
class UtilClass{

    public UtilClass(){
        throw new AssertionError();
    }
}
