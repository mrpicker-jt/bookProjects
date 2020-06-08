package com.mrpicker.chapter2;

import com.mrpicker.base.BaseRule;

import java.math.BigInteger;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

/**
 * @program: effectiveJava
 * @description: 用静态工厂方法代替构造器
 * @author: Mrpicker
 * @create: 2020-06-08 13:06
 **/
public class Rule1 extends BaseRule {

    public Rule1() {
        super("用静态工厂方法代替构造器");
        addBenefit("静态工厂方法与构造器不同的第一大优势在于，它们有名称,可以更准确的描述被返回的对象");
        addBenefit("第二大优势在于，不必在每次调用它们的时候都返回一个新对象。对象可以被缓存起来");
        addBenefit("第三大优势在于，它可以返回原返回类型的任何子类型的对象。这样我们在选择返回对象的类上就有了更大的灵活性");
        addBenefit("第四大优势在于，所返回的对象的类可以随着每次调用而发生变化，这取决于静态方法的参数值");
        addBenefit("第五大优势在于，方法返回的对象所属的类，在编写包含该静态工厂方法的类时可以不存在。（即可以返回一个通用的接口）");
        addWeakPoint("缺点1：类如果没有public或protect的构造器方法，就不能被子类实例化");
        addWeakPoint("缺点2，程序员很难发现它们，因为没有在API文档中明确标识出来");
    }


    public static void main(String[] args) {
        System.out.println(new Rule1());
    }

    private static void example(){
        //for b1
        BigInteger.probablePrime(3, new Random());
        //for b2
        Boolean.valueOf("True");
        //for b3
        Collections.synchronizedCollection(new ArrayList<>());
        //for b4
        //EnumSet返回的EnumSet类型和元素个数有关。如果小于等于64，返回RegularEnumSet；否则返回JumboEnumSet
        EnumSet.of(Test.TEST1, Test.TEST2, Test.TEST3);
        //for b5
        /**
         *JDBC 就是一个服务提供者框架
         * 服务提供者框架：
         * 组件1：服务接口：这是提供者实现的。这里Connection就是服务接口的一部分
         * 组件2：服务提供者注册API：这是提供者用来注册实现的。这里DriverManager.registerDriver(driver)就是服务提供者注册API
         * 组件3：服务访问API：用于客户端获取服务的实例。服务访问API是”灵活的静态工厂“。 Connection connection = DriverManager.getConnection("");
         * 组件4：服务提供者接口（可选）：表示产生服务接口之实例的工厂对象。如果没有服务提供者接口，实现就通过反射来实例化。Driver就是服务提供者接口
         */
        Driver driver = new Driver() {
            @Override
            public Connection connect(String url, Properties info) throws SQLException {
                return null;
            }

            @Override
            public boolean acceptsURL(String url) throws SQLException {
                return false;
            }

            @Override
            public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
                return new DriverPropertyInfo[0];
            }

            @Override
            public int getMajorVersion() {
                return 0;
            }

            @Override
            public int getMinorVersion() {
                return 0;
            }

            @Override
            public boolean jdbcCompliant() {
                return false;
            }

            @Override
            public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                return null;
            }
        };
        try {
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    enum Test {
        TEST1, TEST2, TEST3
    }
}
