package com.mrpicker.chapter2;

import com.mrpicker.base.BaseRule;
import sun.misc.Cleaner;

import java.io.Closeable;
import java.io.IOException;

/**
 * @program: effectiveJava
 * @description: 避免使用终结方法和清除方法
 * @author: Mrpicker
 * @create: 2020-06-12 15:37
 **/
public class Rule8 extends BaseRule {
    public Rule8() {
        super("避免使用终结方法和清除方法");
        addKeyPoint("终结方法(finalizer)通常是不可预测的，也是很危险的，一般情况下是不必要的");
        addKeyPoint("清除方法虽然没有终结方法那么危险，但仍然是不可预测，缓慢的。一般情况下也是不必要的");
        addKeyPoint("注重时间的任务不应该在终结方法或清除方法中完成");
        addKeyPoint("永远不应该依赖终结方法或清除方法来更新重要的持久状态");
        addKeyPoint("使用终结方法和清除方法有严重的性能损失");
        addKeyPoint("终结方法有个严重的安全问题，它们为终结方法攻击打开了类的大门");
        addKeyPoint("如果类中的资源（如文件或线程）确实要释放，可以实现AutoCloseable接口。" +
                "并让客户端在不需要该类实例的时候调用close方法");
        addKeyPoint("终结方法和清除方法用途1：当资源的所有者忘记调用它的close方法时，可以充当一层安全网");
        addKeyPoint("终结方法和清除方法用途2：当类需要清除一个不怎么紧急的native peer（非Java的本地对象）时" +
                "可以用终结、清除方法处理");

    }
}

class example8_1 {
    public static void main(String[] args) {
        try (Room room = new Room(88);) {
            System.out.println("GoodBye");
        } catch (Exception e) {

        }
    }

    //an autoCloseable class using cleaner as a safety net
    static class Room implements Closeable {
        static Cleaner cleaner;
        State state;

        public Room(int numJunk) {
            state = new State(numJunk);
            cleaner = Cleaner.create(this, state);
        }

        @Override
        public void close() throws IOException {
            cleaner.clean();
        }

        static class State implements Runnable {

            int numJunk;


            public State(int numJunk) {
                this.numJunk = numJunk;
            }

            @Override
            public void run() {
                System.out.println("Cleaning room: " + numJunk);
                numJunk = 0;
            }
        }
    }
}

