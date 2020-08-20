package com.mrpicker.chapter4;

import com.mrpicker.base.BaseRule;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @program: effectiveJava
 * @description: 复合优先于继承
 * @author: Mrpicker
 * @create: 2020-07-27 15:23
 **/
public class Rule18 extends BaseRule {
    public Rule18() {
        super("复合优先于继承");
        addKeyPoint("与方法调用不同的是，继承打破了封装性");
        addKeyPoint("对于两个类A,B 只有当两者之间确实存在‘is-a’的关系时，B才应该继承A");
        addKeyPoint("复合不适用于回调框架，即存在所谓的Self问题");
    }


    static class example18_1 {
        public static void main(String[] args) {

        }

        class SelfCountHashSet<E> extends HashSet<E> {
            //统计创建以来添加了多少元素
            private int addCount = 0;

            public SelfCountHashSet() {
            }

            public SelfCountHashSet(int initialCapacity, float loadFactor) {
                super(initialCapacity, loadFactor);
            }

            public int getAddCount() {
                return addCount;
            }


            /**
             * @Description: 这个子类虽然能正确工作，但它的功能正确性依赖于这样一个事实：HashSet的addAll方法是在它的add方法上实现的。
             * 这种自用性（Self-Use）是实现细节，而非承诺。不能保证在Java平台中的所有实现都保持统一，不能保证随着发行版本不同而不发生变化。这样的类是很脆弱的
             * 另外一个稍好的做法是覆盖addAll方法，重写addAll的逻辑。然而这相当于重写超类方法的逻辑，很困难，很耗时，容易出错，并且可能会降低性能。
             * @Param: [e]
             * @return: boolean
             * @Date: 2020/7/27
             */
            @Override
            public boolean add(E e) {
                addCount++;
                return super.add(e);
            }

            /**
             * @Description: 这里注释掉‘addCount++’是因为HashSet内部的addAll的实现方式是循环调用add方法，所以只需要在add方法内加就行了
             * @return: boolean
             * @Date: 2020/7/27
             */
            @Override
            public boolean addAll(Collection<? extends E> c) {
//                addCount++;
                return super.addAll(c);
            }
        }

        /**
         * @Description: 可重用的Set包装类，所有的操作都转发给Set. Set接口的存在让ForwardingSet得以实现。因为HashSet和ForwardingSet都实现了同一套的Set接口，
         * 带来了更多的灵活性。
         * @Date: 2020/7/27
         */
        class ForwardingSet<E> implements Set<E> {
            private Set<E> set;

            public ForwardingSet(Set<E> set) {
                this.set = set;
            }


            @Override
            public int size() {
                return set.size();
            }

            @Override
            public boolean isEmpty() {
                return set.isEmpty();
            }

            @Override
            public boolean contains(Object o) {
                return set.contains(o);
            }

            @Override
            public Iterator<E> iterator() {
                return set.iterator();
            }

            @Override
            public Object[] toArray() {
                return set.toArray();
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return set.toArray(a);
            }

            @Override
            public boolean add(E e) {
                return set.add(e);
            }

            @Override
            public boolean remove(Object o) {
                return set.remove(o);
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return set.containsAll(c);
            }

            @Override
            public boolean addAll(Collection<? extends E> c) {
                return set.addAll(c);
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return set.retainAll(c);
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return set.retainAll(c);
            }

            @Override
            public void clear() {
                set.clear();
            }

            @Override
            public boolean equals(Object obj) {
                return set.equals(obj);
            }

            @Override
            public int hashCode() {
                return set.hashCode();
            }

            @Override
            public String toString() {
                return set.toString();
            }
        }

        /**
         * @Description: SelfCountSet这个类将Set实例包装起来了，被称为包装类。这也正是装饰者模式，
         * @Date: 2020/7/27
         */
        class SelfCountSet<E> extends ForwardingSet<E> {
            private int totalCount = 0;

            public SelfCountSet(Set<E> set) {
                super(set);
            }

            public int getTotalCount() {
                return totalCount;
            }

            @Override
            public boolean add(E e) {
                totalCount += 1;
                return super.add(e);
            }

            @Override
            public boolean addAll(Collection<? extends E> c) {
                totalCount += c.size();
                return super.addAll(c);
            }
        }

    }
}
