package com.mrpicker.chapter4;

import com.mrpicker.base.BaseRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: effectiveJava
 * @description: 使类和成员的可访问性最小化
 * @author: Mrpicker
 * @create: 2020-07-21 15:40
 **/
public class Rule15 extends BaseRule {
    public Rule15() {
        super("使类和成员的可访问性最小化");
        addKeyPoint("尽可能使每个类或者成员不被外界访问");
        addKeyPoint("公有类的实例域绝不能是公有的（See Rule16）");
        addKeyPoint("让类具有公有的静态final数组域，或者返回这种域的访问方法，是错误的");
    }

    static class example15_1 {
        //potential security problems
        public static final Thing[] outThings = new Thing[0];
        private static final Thing[] inThings = new Thing[0];
        //解决方法1；暴露出一个不可修改的List
        public static final List<Thing> outThingList = Collections.unmodifiableList(new ArrayList<>(Arrays.asList(inThings)));

        /**
         * @Description: 解决方法2:返回一个该数组的clone
         * @Param: []
         * @return: com.mrpicker.chapter4.Rule15.Thing[]
         * @Date: 2020/7/23
         */
        public static Thing[] getInThings() {
            return inThings.clone();
        }


    }

    private class Thing {

    }
}
