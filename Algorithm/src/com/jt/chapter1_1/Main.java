package com.jt.chapter1_1;

import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        File file = new File("data");
        Path path= Paths.get(file.getAbsolutePath());
        StdOut.println(file.getAbsolutePath());
        StdOut.println(file.isDirectory());
    }
}
