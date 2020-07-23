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

    }
}
