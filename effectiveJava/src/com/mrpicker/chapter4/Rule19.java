package com.mrpicker.chapter4;

import com.mrpicker.base.BaseRule;

/**
 * @program: effectiveJava
 * @description: 要么设计继承并提供文档说明，要么禁止继承
 * @author: Mrpicker
 * @create: 2020-08-18 14:52
 **/
public class Rule19 extends BaseRule {
    public Rule19(){
        super("要么设计继承并提供文档说明，要么禁止继承");
        addKeyPoint("设计基类时构造器不能调用可Override的方法");
    }
}
