package com.mrpicker.chapter3;

import com.mrpicker.base.BaseRule;

import java.util.HashMap;
import java.util.Objects;

/**
 * @program: effectiveJava
 * @description: 覆盖equals时总要覆盖hashCode
 * @author: Mrpicker
 * @create: 2020-06-15 15:38
 **/
public class Rule11 extends BaseRule {
    public Rule11() {
        super("覆盖equals时总要覆盖hashCode");
        addKeyPoint("每个覆盖了equals方法的类都需要覆盖hashcode，不这样的话，可能会使基于hash的集合（如HashMap,HashSet）无法正常运作");
        addKeyPoint("Object的hashCode约定：" +
                "在单个应用程序执行期间，只要对象中的equals方法中引用的关键域信息没有改变，那么对于该对象的多次hashcode调用，返回值应该一致。如果是应用程序和另一程序相互交互，则可以不同" +
                "如果两个对象根据equals(Object)方法比较是相等的。那么这两对象的hashcode方法返回值也必须要相等" +
                "如果两个对象根据equals(Object)方法比较是不相等的，则不一定要求hashcode产生不同的结果。但是应该知道，给截然不同的对象不同的hashcode值，有助于提高hash集合的性能");
        addKeyPoint("如果覆盖了equals而没有覆盖hashcode，则违反了第二条规定");
        addKeyPoint("不要试图从散列码计算中排除掉对象的一个关键域来提高性能");
        addKeyPoint("不要对hashCode的返回值做具体的规定，因此客户端无法理所当然的依赖它。这样可以为修改提供灵活性");
        setSummary("总之，每当覆盖equals方法时都要覆盖hashCode，否则程序将无法正确运行。hashCode方法必须遵循Object规定的通用约定，并且必须完成一定的工作，" +
                "将不相等的散列码分配给不相等的实例");
    }
}


class example11_1 {
    public static void main(String[] args) {
        HashMap<Student, String> map = new HashMap<>();
        String name = "mrpicker";
        int id = 1;
        map.put(new Student(id, name), "result");
        /*
         *这里get结果为null。因为HashMap会根据key取value时，会先算出key的hashcode找到hashcode对应的bucket（桶），然后再桶中通过equals找到对应的value。
         * 如果hashcode不匹配，也不会进行之后的步骤。而没有覆盖hashcode导致两个Student对象的hashcode返回值是不同的
         */
        System.out.println(map.get(new Student(id, name)));
        System.out.println("----------------------------------");
        HashMap<FixStudent, String> map1 = new HashMap<>();
        map1.put(new FixStudent(id, name), "result");
        System.out.println(map1.get(new FixStudent(id, name)));
    }
}


//覆盖了equals而没有覆盖hashcode
class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        //使用 == 操作符检查‘参数是否为这个对象的引用’
        if (this == obj) {
            return true;
        }
        //使用 instance of 操作符检查‘参数是否为正确的类型’
        if (obj instanceof Student) {
            //将参数转为正确的类型
            Student student = (Student) obj;
            //对于参数中每一个关键域，检查参数中的域是否与对象自身的域一一匹配
            return id == student.id && name.equals(student.name);
        }
        return false;
    }
}


/**
 * 1.声明一个名为result的int型变量，将它初始化为对象的第一个关键域的散列码c，如步骤2.a所示。
 * 2.对象中每个剩余的关键域f都完成以下步骤
 * a.为该域计算int型值的散列码c
 * Ⅰ:如果该域为基本类型，则计算Type.hashCode(f),这里的Type是基本装箱类型，和f相对应
 * Ⅱ:如果该域为一个对象引用，并且该类的equals方法通过递归地调用equals的方式来比较这个域，则同样的为这个域递归调用hashCode。
 * 如果需要更复杂的比较，则可以为该域设计一个‘范式’，然后针对这个范式调用hashCode。如果这个域为null，则返回0（或者其他常数）
 * Ⅲ:如果该域为一个数组，则要把数组中的每一个元素当做单独的域来处理。即递归的应用上述规则，对每个重要的元素计算一个散列码，然后根据2.b
 * 的做法将这些散列码组合起来。如果数组域中没有重要的元素，可以直接用一个常数作为散列码（最好不要是0）；如果数组中的元素都很重要，可以使用
 * Arrays.hashCode方法。
 * b.按照下面的公式，将2.a中得到的散列码c合并到result中
 * result = 31 * result + c;
 * 3.返回result
 */
class FixStudent {
    int id;
    String name;

    public FixStudent(int id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public int hashCode() {
        //如果不太注重性能的话，可以直接用下列方法
        Objects.hash(id, name);

        //步骤1
        int result = Integer.hashCode(id);
        //步骤2
        result = 31 * result + name.hashCode();
        //步骤3
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        //使用 == 操作符检查‘参数是否为这个对象的引用’
        if (this == obj) {
            return true;
        }
        //使用 instance of 操作符检查‘参数是否为正确的类型’
        if (obj instanceof FixStudent) {
            //将参数转为正确的类型
            FixStudent fixStudent = (FixStudent) obj;
            //对于参数中每一个关键域，检查参数中的域是否与对象自身的域一一匹配
            return id == fixStudent.id && name.equals((fixStudent.name));
        }
        return false;
    }
}
