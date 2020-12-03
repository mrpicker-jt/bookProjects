package com.jt.sword_to_offer;

import com.jt.chapter1_3.LinkQueue;
import com.jt.chapter1_3.intefaces.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description: 机器人的运动范围 回溯法
 * <p>
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * Solution：
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/mian-shi-ti-13-ji-qi-ren-de-yun-dong-fan-wei-dfs-b/
 * @author: Mrpicker
 * @create: 2020-12-02 19:05
 **/
public class Ex13 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1(20, 20, 6);
        StdOut.println(solution1.count());
        Solution2 solution2 = new Solution2(20, 20, 6);
        StdOut.println(solution2.count());
    }

    private static int get(int num) {
        int s = 0;
        while (num != 0) {
            s += num % 10;
            num /= 10;
        }
        return s;
    }

    static class Solution1 {
        int m;
        int n;
        int k;
        boolean[][] visited;

        public Solution1(int m, int n, int k) {
            this.m = m;
            this.n = n;
            this.k = k;
            visited = new boolean[m][n];
        }

        public int count() {
            return dfs(0, 0, 0, 0);
        }

        /**
         *思路：
         * 回溯法思想的深度递归遍历，先一直往路径的最深处搜索，发现到头的时候从上一个可行节点处
         * 切换成另外一条路径继续往最深处搜索。
         * 通常用递归实现，是栈的思想
         *
         * 这里可以优化成只想右和下搜索
         *
         * @param i
         * @param j
         * @param si
         * @param sj
         * @return
         */
        private int dfs(int i, int j, int si, int sj) {
            if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || si + sj > k) {
                return 0;
            }
            visited[i][j] = true;
            return 1 + dfs(i + 1, j, get(i + 1), get(j)) + dfs(i, j + 1, get(i), get(j + 1));
        }
    }

    static class Solution2 {
        int m;
        int n;
        int k;
        boolean[][] visited;
        int visitedCount;


        public Solution2(int m, int n, int k) {
            this.m = m;
            this.n = n;
            this.k = k;
            visited = new boolean[m][n];
        }

        public int count() {
            if (m <= 0 || n <= 0) {
                return 0;
            }
            return bfs();
        }

        /**
         * 广度优先搜索，输入一个起点，由起点逐渐向四周蔓延，直到无法蔓延为止。
         * 通常使用循环实现，是队列的思想。
         *
         * @return
         */
        private int bfs() {
            Queue<int[]> queue = new LinkQueue<>();
            queue.enQueue(new int[]{0, 0});
            while (!queue.isEmpty()) {
                int[] step = queue.deQueue();
                int i = step[0];
                int j = step[1];
                int si = get(i);
                int sj = get(j);
                if (i >= m || j >= n || si + sj > k || visited[i][j]) {
                    continue;
                }
                visited[i][j] = true;
                visitedCount++;
                //可以往下走或者往右走
                queue.enQueue(new int[]{i + 1, j});
                queue.enQueue(new int[]{i, j + 1});
            }
            return visitedCount;
        }
    }

}
