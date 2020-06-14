package com.mrpicker.generic;

import java.util.stream.Stream;

public class LinkedStack<T> {
    private Node<T> top;

    public static void main(String[] args) {
        LinkedStack<String> linkedStack = new LinkedStack<>();
        String str = "hello mrpicker haha";
        Stream.of(str.split(" ")).forEach(linkedStack::push);
        int count = 0;
        while (!linkedStack.isEmpty()) {
            count++;
            System.out.println(linkedStack.pop() + count);
        }
    }

    public void push(T item) {
        top = new Node<>(item, top);
    }

    public T pop() {
        if (top == null) {
            return null;
        }
        T result = top.item;
        top = top.next;
        return result;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static class Node<T> {
        T item;
        Node<T> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }

}

