package com.mrpicker.chapter4;

import com.mrpicker.base.BaseRule;

/**
 * @program: effectiveJava
 * @description: 使类和成员的可访问性最小化
 * @author: Mrpicker
 * @create: 2020-07-21 15:40
 **/
public class Rule15 extends BaseRule {
    public Rule15(){
        super("使类和成员的可访问性最小化");
        addKeyPoint("尽可能使每个类或者成员不被外界访问");
        addKeyPoint("公有类的实例域绝不能是公有的（See Rule16）");
    }
}
