package com.jt.chapter1_3;

import edu.princeton.cs.algs4.StdOut;

import java.io.File;

/**
 * @program: Algorithm
 * @description: 文件列表
 * @author: Mrpicker
 * @create: 2020-09-15 10:08
 **/
public class Ex43 {
    public static void main(String[] args) {
        printAllFiles("C:\\Users\\TTLX\\Desktop\\app图标");
    }

    private static void printAllFiles(String dirPath) {
        File file = new File(dirPath);
        if (file.isDirectory()) {
            int depth = 0;
            printFiles(file, 0);
        }
    }

    private static void printFiles(File dirFile, int depth) {
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            prefix.append(" ");
        }
        File[] files = dirFile.listFiles();
        if (files != null) {
            for (File file : files) {
                StdOut.println(prefix.toString() + file.getName());
                if (file.isDirectory()) {
                    printFiles(file, depth + 1);
                }
            }
        }
    }
}
