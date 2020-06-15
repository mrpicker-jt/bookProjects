package com.mrpicker.chapter3;

import com.mrpicker.base.BaseRule;

/**
 * @program: effectiveJava
 * @description: 始终要覆盖toString
 * @author: Mrpicker
 * @create: 2020-06-15 19:27
 **/
public class Rule12 extends BaseRule {
    public Rule12() {
        super("始终要覆盖toString");
        addKeyPoint("提供好的toString实现可以使类用的更加舒适，使用了这个类的系统也更易于调试");
        addKeyPoint("在实际应用中，toString应返回对象中所有值得关注的信息");
        addKeyPoint("无论是否决定指定toString的返回格式，都应该在文档中明确的表示你的意图");
        addKeyPoint("无论是否决定指定toString的返回格式,都为返回值包含的所有信息提供一种可以通过编程访问之的途径");
        addKeyPoint("优先使用ide生成toString");
    }
}

class example12_1 {
    abstract class Phone {
        int areaCode;
        int prefix;
        int lineNum;
    }

    //如果要指定格式，就要严格的按照格式做
    class Phone1 extends Phone {

        /**
         * @Description: 返回的格式为XXX-YYY-ZZZZ
         * @Param: []
         * @return: java.lang.String
         * @Date: 2020/6/15
         */
        @Override
        public String toString() {
            return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
        }
    }


    //如果不指定格式，也需要给出关键域的信息以便调用者重新组织。
    class Phone2 extends Phone {
        /**
         * @Description: 返回一个对这个的描述Phone2 #hashCode:[areaCode=xxx,prefix=yyy,lineNum=zzzz]
         * @Param: []
         * @return: java.lang.String
         * @Date: 2020/6/15
         */
        @Override
        public String toString() {
            //pass
            return super.toString();
        }
    }
}
