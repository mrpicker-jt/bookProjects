package com.mrpicker.chapter2;

import com.mrpicker.base.BaseRule;
import com.mrpicker.base.TimeClock;

/**
 * @program: effectiveJava
 * @description: 避免创建不必要的对象
 * @author: Mrpicker
 * @create: 2020-06-11 14:08
 **/
public class Rule6 extends BaseRule {
    public Rule6() {
        super("避免创建不必要的对象");
        addKeyPoint("如果对象是不可变的（See Rule17），它就始终可以被重用");
        addKeyPoint("对于创建成本较高的对象，建议缓存下来进行重用");
        addKeyPoint("通过懒加载的方式在需要的时候创建对象。但要权衡其中的性能提升和代码复杂度增加的冲突。");
        addKeyPoint("要优先使用基本类型而非基本装箱类型，要当心无意识的自动装箱");
        addKeyPoint("通过维护自己的对象池来避免创建对象通常不是一种好的做法，除非池中的对象是非常重量级的。ex:数据库连接池");

        setSummary("与本条相对应的是Rule50有关‘保护性拷贝’的内容。本条提及‘当你应该重用当前对象时，不要创建新的对象’；Rule50" +
                "提及‘当你需要创建新的对象时，不要重用现有对象’。注意：因重用对象而付出的代价可能远大于创建重复对象的代价。" +
                "前者会导致潜在的Bug和安全漏洞；后者则只会影响程序的风格和性能");
    }

    private static void example() {
        TimeClock.start();
        Long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(String.format("Long cost %dms", TimeClock.getTimeCost()));
        TimeClock.start();
        long sum1 = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum1 += i;
        }
        System.out.println(String.format("long cost %dms", TimeClock.getTimeCost()));
    }

    public static void main(String[] args) {
        example();
    }
}
