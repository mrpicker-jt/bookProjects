package com.mrpicker.generic;

import javafx.util.Pair;

public class Holder {
    static class Bob {
    }

    static class SingleTypeHolder {
        Bob bob;

        public Bob getBob() {
            return bob;
        }

        public void setBob(Bob bob) {
            this.bob = bob;
        }
    }

    static class ObjectHolder {
        Object object;

        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }
    }

    static class GenericHolder<T> {
        T t;

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }
    }

    public static void main(String[] args){
        SingleTypeHolder singleTypeHolder=new SingleTypeHolder();
        singleTypeHolder.setBob(new Bob());
        Bob bob = singleTypeHolder.getBob();

        ObjectHolder objectHolder=new ObjectHolder();
        objectHolder.setObject(new Bob());
        Bob bob1 = (Bob) objectHolder.getObject();

        GenericHolder<Bob> genericHolder=new GenericHolder<>();
        genericHolder.setT(new Bob());
        Bob t = genericHolder.getT();

    }

}
