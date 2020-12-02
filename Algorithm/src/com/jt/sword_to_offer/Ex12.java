package com.jt.sword_to_offer;

import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description: 矩阵中的路径 回溯法
 * <p>
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，
 * 每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径。
 * <p>
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * <p>
 * 解答：
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/solution/mian-shi-ti-12-ju-zhen-zhong-de-lu-jing-shen-du-yo/
 * @author: Mrpicker
 * @create: 2020-12-02 16:47
 **/
public class Ex12 {
    public static void main(String[] args) {
        char[][] matrix = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
        char[] path1 = {'c', 'c', 'e', 'd', 'f', 's'};
        char[] path2 = {'s', 'c', 'f', 'a'};
        StdOut.println(isExists(path1, matrix));
        StdOut.println(isExists(path2, matrix));
    }

    private static boolean isExists(char[] path, char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (dfs(path, matrix, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 核心思路：
     * 从第0个到第k个，依次往后一个个找
     * 对于第k个，当发现matrix[i][j]不满足path[k]时，则matrix[i][j]之后的路径也不需要找了。
     *
     * @param path
     * @param matrix
     * @param i      当前定位的Matrix坐标 i
     * @param j      当前定位的Matrix坐标 j
     * @param k      当前匹配的path的index
     * @return
     */
    private static boolean dfs(char[] path, char[][] matrix, int i, int j, int k) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] != path[k]) {
            //只要当前不满足条件，就可以直接停止这条路径。
            return false;
        }
        //满足条件后，当前这个（i,j）点就对应了path的k的位置
        if (k == path.length - 1) {
            //说明已经找完了，不用再往下找了
            return true;
        }
        //说明没找完，继续找path[k+1],为了防止一条路径重复访问，将访问过的点置为空字符
        matrix[i][j] = '\0';
        boolean res = dfs(path, matrix, i + 1, j, k + 1) || dfs(path, matrix, i, j + 1, k + 1) ||
                dfs(path, matrix, i - 1, j, k + 1) || dfs(path, matrix, i, j - 1, k + 1);
        //一条路径全部走完后，恢复原来的字符，如果不恢复的话会影响到到其它路径的搜索
        matrix[i][j] = path[k];
        return res;
    }
}
