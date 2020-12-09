package com.jt.sword_to_offer;

import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description: 剪绳子
 * <p>
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * @author: Mrpicker
 * @create: 2020-12-09 19:38
 **/
public class Ex14 {
    public static void main(String[] args) {
        int N = 13;
        StdOut.println(maxByCut(N));
        StdOut.println(cuttingRope(N));
    }

    /**
     * 动态规划
     * 思路：
     * 自底向上的思考方法。一个F[N]数组存储着每个N的最大值。
     * 一条N长度绳子第一次剪成两段 a长,b长时(a+b=N)，那么可以知道F[a]和F[b]的值，
     * 则通过循环a，即可以算出最大的F[a]*F[b]的值，即F[N]的值
     * <p>
     * 思考N类的问题时，先从N=1的最简单情况开始思考，然后考虑N与N-1之间的关系。
     * 如果发现不了N与N-1之间明显的关系，可以尝试思考N与i,N-i之间的关系（1<=i<N）
     * 如果是前者，那么通常和递归有关；如果是后者，可以尝试动态规划的思路
     *
     * @param n
     * @return
     */
    private static int maxByCut(int n) {
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int[] f = new int[n];
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                f[i - 1] = Math.max(f[i - 1], Math.max(j * (i - j), j * f[i - j - 1]));
            }
        }
        return f[n - 1];
    }

    public static int cuttingRope(int n) {
        if (n < 4) return n - 1;
        int a = n / 3, b = n % 3;
        if (b == 0) return a = (int) Math.pow(3, a);
        if (b == 1) return a = (int) (Math.pow(3, a - 1) * 4);
        return a = (int) (Math.pow(3, a) * 2);
    }

}
