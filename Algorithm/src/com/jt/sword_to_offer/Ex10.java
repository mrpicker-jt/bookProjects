package com.jt.sword_to_offer;

import com.jt.chapter1_4.StopWatch;
import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description: 求Fibonacci数列的第N项
 * @author: Mrpicker
 * @create: 2020-12-01 20:11
 **/

/**
 * 拓展1：青蛙跳台阶
 * <p>
 * 一只青蛙，一次能跳1或2个台阶，跳上N级台阶有几种跳法
 * <p>
 * 思路：先考虑最简单情况：如果只有1个台阶：只有1种跳法；如果有两个台阶，则有2种跳法。对于一个N(N>2)级台阶：
 * 设总的跳法为f(n),则如果第一次跳了1个台阶，对于后面则有f(n-1)种跳法;如果第一次跳了2个台阶，对于后面有f(n-2)种跳法,
 * 两种情况加起来则可得f(n) = f(n-1)+f(n-2)
 * <p>
 * 拓展2: 对于 N 级台阶，如果青蛙一次能跳1-N级台阶，则有几种跳法
 * 根据数学归纳法可得 f(n) = f(1)+f(2)+...+f(n-1) -> f(n) = 2的n-1次方
 */

/**
 * 相关题目:
 * 8个2x1的矩形去完整覆盖一个2*8的矩形，无重叠，横着或竖着摆放，有几种摆法
 *
 * 考虑覆盖最左边有两种办法，横着或竖着。竖着的话则还剩下2*7的区域；横着的话则还剩下2*6的区域
 * 即f(8)=f(7)+f(6)
 *
 */
public class Ex10 {
    public static void main(String[] args) {
        int N = 45;
        StopWatch stopWatch1 = new StopWatch();
        StdOut.println(recursive(N));
        StdOut.println(String.format("recursive cost %.3fs", stopWatch1.elapseTime() / 1000f));
        StopWatch stopWatch2 = new StopWatch();
        StdOut.println(circular(N));
        StdOut.println(String.format("circular cost %.3fs", stopWatch2.elapseTime() / 1000f));
    }

    private static int recursive(int N) {
        if (N == 1) {
            return 0;
        }
        if (N == 2) {
            return 1;
        }
        return recursive(N - 1) + recursive(N - 2);
    }

    private static int circular(int N) {
        if (N == 1) {
            return 0;
        }
        if (N == 2) {
            return 1;
        }
        int[] doubleArr = {0, 1};
        for (int i = 2; i < N; i++) {
            int temp = doubleArr[1];
            doubleArr[1] = doubleArr[0] + doubleArr[1];
            doubleArr[0] = temp;
        }
        return doubleArr[1];
    }
}
