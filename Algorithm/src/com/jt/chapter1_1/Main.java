package com.jt.chapter1_1;

import edu.princeton.cs.algs4.StdOut;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File("data");
        StdOut.println(file.getAbsolutePath());
        StdOut.println(file.isDirectory());
    }
}
