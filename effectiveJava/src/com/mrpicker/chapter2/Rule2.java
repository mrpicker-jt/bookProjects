package com.mrpicker.chapter2;

import com.mrpicker.base.BaseRule;

import java.util.EnumSet;

/**
 * @program: effectiveJava
 * @description: 遇到多个构造器参数时考虑使用Builder模式
 * @author: Mrpicker
 * @create: 2020-06-09 15:25
 **/
public class Rule2 extends BaseRule {

    public Rule2() {
        super("遇到多个构造器参数时考虑使用Builder模式");
        addBenefit("易于编写，容易阅读");
        addBenefit("有多个可变参数，可以通过重复调用一个方法将输入集中到一个属性中。可以自动填充某些属性");
        addBenefit("对象的参数在build()之前均可调整，同时build()之后可以freeze对象");
        addWeakPoint("构建Builder可能需要一些开销");
        addWeakPoint("仅使用于参数很多的类进行初始化");
        addWeakPoint("如果要使用Builder模式的话最好在设计之初时，后期在已有很多属性的类中重构Builder模式可能会比较复杂");
        setSummary("如果类的构造器或者静态工厂方法中具有多个参数，设计这种类时，Builder模式可能是个不错的选择");

    }
}

class example2_1 {
    public static void main(String[] args) {
        Nutrition nutrition = new Nutrition.Builder(1540).fat(10).carbon(61.3).build();
        System.out.println(nutrition);
    }

    static class Nutrition {
        int energy;//required
        int protein;
        int fat;
        int salt;
        double carbon;

        Nutrition(Builder builder) {
            //Nutrition本身是不可变的，只有在Builder调用build之前更改Nutrition的属性
            energy = builder.energy;
            protein = builder.protein;
            fat = builder.fat;
            salt = builder.salt;
            carbon = builder.carbon;
        }

        @Override
        public String toString() {
            return "Nutrition{" +
                    "energy=" + energy +
                    ", protein=" + protein +
                    ", fat=" + fat +
                    ", salt=" + salt +
                    ", carbon=" + carbon +
                    '}';
        }

        static class Builder {
            private int energy;//required
            private int protein;
            private int fat;
            private int salt;
            private double carbon;

            Builder(int energy) {
                this.energy = energy;
            }

            Builder protein(int protein) {
                this.protein = protein;
                return this;
            }

            Builder fat(int fat) {
                this.fat = fat;
                return this;
            }

            Builder salt(int salt) {
                this.salt = salt;
                return this;
            }

            Builder carbon(double carbon) {
                this.carbon = carbon;
                return this;
            }

            public Nutrition build() {
                return new Nutrition(this);
            }

        }
    }
}

class example2_2 {

    public static void main(String[] args) {
        NYPizza nyPizza = new NYPizza.Builder(NYPizza.SIZE.BIG).addTopping(Pizza.TOPPING.HAM).addTopping(Pizza.TOPPING.MUSHROOM)
                .addTopping(Pizza.TOPPING.PEPPER).addTopping(Pizza.TOPPING.HAM).build();
        System.out.println(nyPizza);
    }

    abstract static class Pizza {
        EnumSet toppings;

        Pizza(Builder builder) {
            toppings = builder.toppings.clone();
        }

        enum TOPPING {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

        abstract static class Builder<T extends Builder<T>> {
            EnumSet<TOPPING> toppings = EnumSet.noneOf(TOPPING.class);

            public T addTopping(TOPPING topping) {
                toppings.add(topping);
                return self();
            }

            //规定子类Builder的行为1
            abstract Pizza build();

            //规定子类Builder的行为2
            protected abstract T self();
        }

    }

    static class NYPizza extends Pizza {
        SIZE size;

        NYPizza(Builder builder) {
            super(builder);
            this.size = builder.size;
        }

        @Override
        public String toString() {
            return "NYPizza{" +
                    "toppings=" + toppings +
                    ", size=" + size +
                    '}';
        }

        enum SIZE {SMALL, MEDIUM, BIG}

        static class Builder extends Pizza.Builder<Builder> {
            SIZE size;

            Builder(SIZE size) {
                this.size = size;
            }

            /**
             * @Description: NYPizza:覆盖了返回类型是Pizza的方法，协变
             * @Param: []
             * @return: com.mrpicker.chapter2.example2.NYPizza
             * @Date: 2020/6/9
             */
            @Override
            NYPizza build() {
                return new NYPizza(this);
            }

            @Override
            protected Builder self() {
                return this;
            }
        }
    }

}
