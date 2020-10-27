package com.jt.sword_to_offer;

import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description: 替换空格
 * 实现一个函数，把字符串中的每个空格替换成%20 比如'We are happy'->'We%20are%20happy'
 * @author: Mrpicker
 * @create: 2020-10-22 20:09
 **/
public class Ex5 {

    public static void main(String[] args) {
        char[] characters = " We are  happy ".toCharArray();
        StdOut.println(java.lang.String.valueOf(replaceBlank(characters)));
    }

    private static char[] replaceBlank(char[] characters) {
        //先统计空格的数量
        int blankCount = 0;
        for (Character c : characters) {
            if (c.equals(' ')) {
                blankCount++;
            }
        }
        char[] newArray = new char[characters.length + blankCount * 2];
        int curIdx = newArray.length - 1;
        for (int i = characters.length - 1; i >= 0; i--) {
            Character c = characters[i];
            if (c.equals(' ')) {
                newArray[curIdx] = '0';
                newArray[curIdx - 1] = '2';
                newArray[curIdx - 2] = '%';
                curIdx -= 3;
            } else {
                newArray[curIdx] = c;
                curIdx -= 1;
            }
        }
        return newArray;
    }


}
