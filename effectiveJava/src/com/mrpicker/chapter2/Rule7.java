package com.mrpicker.chapter2;

import com.mrpicker.base.BaseRule;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @program: effectiveJava
 * @description: 消除过期的对象引用
 * @author: Mrpicker
 * @create: 2020-06-11 15:43
 **/
public class Rule7 extends BaseRule {
    public Rule7() {
        super("消除过期的对象引用");
        addKeyPoint("清空对象引用应该是一种例外，而不是一种规范行为");
        addKeyPoint("一般来说，只要是类自己管理内存，就应该警惕内存泄漏问题");
        addKeyPoint("内存泄漏的另一个主要来源是缓存。使用WeakHashMap可以清除一些过期的缓存");
        addKeyPoint("内存泄漏的第三个常见来源是监听器和回调。如果在使用后没有被显示反注册，它们就会逐渐堆积起来。" +
                "确保反注册后立刻被垃圾回收的方式是保存它们的WeakReference");
    }
}

class example7_1 {
    class LackMemoryStack<T> {
        static final int DEFAULT_INITIAL_CAPACITY = 16;
        T[] elements;
        int size = 0;

        public LackMemoryStack(int capacity, Class<T> tClass) {
            elements = (T[]) Array.newInstance(tClass, capacity);
        }

        public void push(T t) {
            ensureCapacity();
            elements[size++] = t;
        }

        /**
         * @Description: 这里的pop方法会造成内存泄漏，因为pop中只修改了size的值，而element[]中还保存着被pop对象的引用
         * @Param: []
         * @return: T
         * @Date: 2020/6/12
         */
        public T pop() {
            if (size == 0) {
                throw new RuntimeException("Stack size is 0");
            }
            return elements[--size];
        }

        private void ensureCapacity() {
            if (elements.length == size) {
                elements = Arrays.copyOf(elements, size * 2 + 1);
            }
        }

    }

    class FixStack<T> {
        static final int DEFAULT_INITIAL_CAPACITY = 16;
        T[] elements;
        int size = 0;

        public FixStack(int capacity, Class<T> tClass) {
            elements = (T[]) Array.newInstance(tClass, capacity);
        }

        public void push(T t) {
            ensureCapacity();
            elements[size++] = t;
        }

        /**
         * @Description: 这里的pop方法在size-1的时候还把element[]对应位置置空了
         * @Param: []
         * @return: T
         * @Date: 2020/6/12
         */
        public T pop() {
            if (size == 0) {
                throw new RuntimeException("Stack size is 0");
            }
            --size;
            T element = elements[size];
            elements[size] = null;
            return element;
        }

        private void ensureCapacity() {
            if (elements.length == size) {
                elements = Arrays.copyOf(elements, size * 2 + 1);
            }
        }

    }
}
