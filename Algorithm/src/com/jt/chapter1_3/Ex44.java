package com.jt.chapter1_3;

import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description: 文件编辑器的缓冲区
 * @author: Mrpicker
 * @create: 2020-09-15 10:42
 **/
public class Ex44 {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        buffer.insert('a');
        buffer.insert('b');
        buffer.insert('c');
        buffer.insert('d');
        buffer.insert('e');
        StdOut.println(buffer);
        buffer.left(2);
        StdOut.println(buffer);
        buffer.insert('f');
        StdOut.println(buffer);
        buffer.right(1);
        buffer.delete();
        StdOut.println(buffer);
        StdOut.println(buffer.size());
    }


}
