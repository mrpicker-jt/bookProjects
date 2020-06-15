package com.mrpicker.chapter3;

import com.mrpicker.base.BaseRule;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: effectiveJava
 * @description: 覆盖equals方法请准守通用约定
 * @author: Mrpicker
 * @create: 2020-06-15 10:26
 **/
public class Rule10 extends BaseRule {
    public Rule10() {
        super("覆盖equals方法请准守通用约定");
        addKeyPoint("满足以下任意条件，可以不覆盖equals方法\n" +
                "类的每个实例本质上是惟一的（例如Thread类）\n" +
                "类没有必要提供逻辑相等的测试功能（例如Pattern）\n" +
                "类的超类已经覆盖了equals，且超类的行为对这个类也是适合的。(例如Map和AbstractMap)\n" +
                "类是私有的，或者包级私有的。可以确保它的equals方法永远不会被调用");
        addKeyPoint("什么时候需要覆盖equals方法：如果类具有自己特有的逻辑相等的概念，并且超类还没有覆盖equals。（这通常属于值类）");
        addKeyPoint("覆盖equals方法时，须遵循以下约定；\n" +
                "自反性：对于任何非null的引用值x，x.equals(x)必须返回true\n" +
                "对称性：对于任何非null的引用值x,y。当且仅当y.equals(x)为true时，x.equals(y)必须返回true\n" +
                "传递性：对于任何非null的引用值x,y,z.如果x.equals(y)和y.equals(z)都为true，则x.equals(z)必须返回true\n" +
                "一致性：对于任何非null的引用值x,y.如果equals比较操作中所使用的的对象信息没有改变，那么不论调用多少次x.equals(y)，多次调用的结果必须一致\n" +
                "非空性：对于任何非null的引用值x,x.equals(null)必须返回false");
        addKeyPoint("实现高质量equals方法的诀窍：\n" +
                "使用 == 操作符检查‘参数是否为这个对象的引用’\n" +
                "使用 instance of 操作符检查'参数是否为正确的类型'\n" +
                "将参数转为正确的类型\n" +
                "对于参数中每一个关键域，检查参数中的域是否与对象自身的域一一匹配");
        addKeyPoint("在编写完equals方法后，应该问自己三个问题。它是否满足对称性；传递性；持久性");
        addKeyPoint("最后一些建议：" +
                "覆盖equals时总要覆盖hashCode（See Rule11）" +
                "不要企图让equals方法过于智能" +
                "不要将equals中声明的Object类型改为其它类型。因为这不是覆盖，而是重载" +
                "除非万不得已，不要覆盖equals。优先用ide工具生成equals");


    }
}


/**
 * @Description: 自反性
 * @Date: 2020/6/15
 */
class example10_1 {
    public static void main(String[] args) {
        List<ViolateReflexivity> list = new ArrayList<>();
        ViolateReflexivity violateReflexivity = new ViolateReflexivity();
        list.add(violateReflexivity);
        System.out.println(list.contains(violateReflexivity));
    }

    //违背自反性的类
    static class ViolateReflexivity {
        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return false;
            }
            return super.equals(obj);
        }
    }
}

/**
 * @Description: 对称性
 * @Date: 2020/6/15
 */
class example10_2 {

    public static void main(String[] args) {
        IgnoreCaseString ignoreCaseString = new IgnoreCaseString("Haha");
        String s = "haha";
        System.out.println(ignoreCaseString.equals(s));
        System.out.println(s.equals(ignoreCaseString));
        System.out.println("-----------------------------------");
        IgnoreCaseStringFixSymmetry fix1 = new IgnoreCaseStringFixSymmetry("Haha");
        IgnoreCaseStringFixSymmetry fix2 = new IgnoreCaseStringFixSymmetry("haha");
        System.out.println(fix1.equals(fix2));
        System.out.println(fix1.equals(s));
        System.out.println(s.equals(fix1));


    }

    //违背对称性的类
    static final class IgnoreCaseString {
        String s;

        public IgnoreCaseString(String s) {
            this.s = s;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof IgnoreCaseString) {
                return s.equalsIgnoreCase(((IgnoreCaseString) obj).s);
            }
            //在这里和String比较时违反了对称性
            if (obj instanceof String) {
                return s.equalsIgnoreCase((String) obj);
            }
            return false;
        }
    }

    //修复对称性
    static final class IgnoreCaseStringFixSymmetry {
        String s;

        public IgnoreCaseStringFixSymmetry(String s) {
            this.s = s;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof IgnoreCaseStringFixSymmetry && ((IgnoreCaseStringFixSymmetry) obj).s.equalsIgnoreCase(s);
        }
    }
}


/**
 * @Description: 传递性
 * @Date: 2020/6/15
 */
class example10_3 {

    public static void main(String[] args) {
        ColorPoint colorPoint1 = new ColorPoint(1, 1, 88);
        Point point = new Point(1, 1);
        ColorPoint colorPoint2 = new ColorPoint(1, 1, 1);
        System.out.println(colorPoint1.equals(point));
        System.out.println(point.equals(colorPoint2));
        System.out.println(colorPoint1.equals(colorPoint2));
        System.out.println("-------------------------------------");


    }

    static class Point {
        int x;
        int y;

        public Point() {

        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Point) {
                Point point = (Point) obj;
                return x == point.x && y == point.y;
            }
            return false;
        }
    }


    //这个类违反了传递性
    static class ColorPoint extends Point {
        int color;

        public ColorPoint(int x, int y, int color) {
            super(x, y);
            this.color = color;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj instanceof Point) {
                if (!(obj instanceof ColorPoint)) {
                    //这里违反了传递性
                    return super.equals(obj);
                } else {
                    ColorPoint colorPoint = (ColorPoint) obj;
                    return x == colorPoint.x && y == colorPoint.y && color == colorPoint.color;
                }
            }

            return false;
        }
    }


    /**
     * @Description: 虽然没有一种好方法可以既extend不可实例化的类，又增加值组件。但可以遵循‘复合优于继承（Rule18）’的建议
     * 注意：可以在继承一个抽象类的情况下在子类中增加新的值组件同时也不会打破equals的约定。例如Shape抽象类可以有Circle类（值radius）
     * 和Rectangle类（值width,height）。只要不能直接创建超类的实例，传递性的问题就不会发生。
     * @Date: 2020/6/15
     */
    static class FixColorPoint {
        Point point;
        int color;

        public FixColorPoint(Point point, int color) {
            this.point = point;
            this.color = color;
        }

        public Point asPoint() {
            return point;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof FixColorPoint) {
                return point.equals(((FixColorPoint) obj).point) && color == ((FixColorPoint) obj).color;
            }
            return false;
        }
    }
}

/**
 * @Description: equals最佳实践
 * @Date: 2020/6/15
 */
class example10_4 {
    class Student {
        int id;
        String name;

        @Override
        public boolean equals(Object obj) {
            //使用 == 操作符检查‘参数是否为这个对象的引用
            if (this == obj) {
                return true;
            }
            //使用 instance of 操作符检查'参数是否为正确的类型
            if (obj instanceof Student) {
                //将参数转为正确的类型
                Student student = (Student) obj;
                //对于参数中每一个关键域，检查参数中的域是否与对象自身的域一一匹配
                return id == student.id && name.equals(student.name);
            }
            return false;
        }
    }

}
