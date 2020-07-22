package com.mrpicker.chapter3;

import com.mrpicker.base.BaseRule;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @program: effectiveJava
 * @description: 考虑实现Comparable接口
 * @author: Mrpicker
 * @create: 2020-07-20 16:14
 **/
public class Rule14 extends BaseRule {
    public Rule14() {
        super("考虑实现Comparable接口");
        addKeyPoint("如果一个类有很明显的内在排序关系，就应该实现Comparable接口");
        addKeyPoint("compareTo的规范与equal类似，需满足自反性，对称性，传递性");
        addKeyPoint("compareTo返回0的话建议equal也返回True，否则的话需要在compareTo注释上说明");
    }


    static class example14_1 {
        /**
         * @Description: 也可以用Comparator来快速实现对多个域的比较
         * @Param: [args]
         * @return: void
         * @Date: 2020/7/20
         */
        public static void main(String[] args) {
            Comparator<Data> comparator = Comparator.comparingInt((Data data) -> data.keyData)
                    .thenComparingInt(data -> data.descriptionData);
            List<Data> collect = IntStream.range(0, 20).mapToObj(i -> new Data((int) (Math.random() * (i + 10))
                    , (int) (Math.random() * (i + 10)))).collect(Collectors.toList());
            Data[] datas = collect.toArray(new Data[]{});
            collect.sort(comparator);
            Arrays.sort(datas);
            System.out.println("-------------collect-----------------");
            System.out.println(collect);
            System.out.println("-------------array-----------------");
            Arrays.stream(datas).forEach(data -> System.out.print(data+","));
        }
    }

    static class Data implements Comparable<Data> {
        int keyData;
        int descriptionData;

        public Data(int keyData, int descriptionData) {
            this.keyData = keyData;
            this.descriptionData = descriptionData;
        }

        @Override
        public int compareTo(Data o) {
            int compareKey = Integer.compare(keyData, o.keyData);
            if (compareKey == 0) {
                return Integer.compare(descriptionData, o.descriptionData);
            }
            return compareKey;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "keyData=" + keyData +
                    ", descriptionData=" + descriptionData +
                    '}';
        }
    }
}
