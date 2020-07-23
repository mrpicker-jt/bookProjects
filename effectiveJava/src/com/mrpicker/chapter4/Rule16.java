package com.mrpicker.chapter4;

import com.mrpicker.base.BaseRule;

/**
 * @program: effectiveJava
 * @description: 要在公有类而非公有域中使用访问方法
 * @author: Mrpicker
 * @create: 2020-07-23 15:32
 **/
public class Rule16 extends BaseRule {
    public Rule16(){
        super("要针对公有类而非公有域使用访问方法");
        addKeyPoint("如果类可以在它所在的包之外进行访问，就提供访问方法");
        addKeyPoint("如果类是包级私有的，或者是私有嵌套类，那么直接暴露它的数据域也没问题");
    }
}
