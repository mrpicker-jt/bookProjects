package com.mrpicker.chapter3;

import com.mrpicker.base.BaseRule;

/**
 * @program: effectiveJava
 * @description: 谨慎地覆盖clone
 * @author: Mrpicker
 * @create: 2020-06-17 15:55
 **/
public class Rule13 extends BaseRule {
    public Rule13(){
        super("谨慎地覆盖clone");
        addKeyPoint("事实上，实现Cloneable接口的类是为了提供一个功能适当的共有的clone方法");
        addKeyPoint("不可变的类永远都不应该提供clone方法");
        addKeyPoint("实际上，clone方法就是另一个构造器；必须确保它不会伤害到原始的对象，并确保正确的创建被克隆对象中的约束条件");
        addKeyPoint("Cloneable架构与引用可变对象的final域的正常做法是不兼容的");
        addKeyPoint("对象拷贝的更好办法是提供一个拷贝构造器或者拷贝工厂（ex. new ArrayList(ArrayList list)）");
        setSummary("所有实现了Cloneable接口的类都应该覆盖clone方法，并且是共有的方法，它的返回类型是类本身。这个方法应该先调用super.clone()方法，然后修正" +
                "任何需要修正的域");
    }
}
