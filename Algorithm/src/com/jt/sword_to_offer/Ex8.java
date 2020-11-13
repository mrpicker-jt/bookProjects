package com.jt.sword_to_offer;

import com.jt.chapter1_3.TreeNode;

/**
 * @program: Algorithm
 * @description: 寻找中序遍历中二叉树的下一个节点
 * @author: Mrpicker
 * @create: 2020-11-13 20:00
 **/
public class Ex8 {

    public static <T> TreeNode<T> nextNodeInOrder(TreeNode<T> curNode) {
        if (curNode.right != null) {
            curNode = curNode.right;
            while (curNode.left != null) {
                curNode = curNode.left;
            }
            return curNode;
        } else if (curNode.parent != null) {
            while (curNode.parent != null) {
                if (curNode.parent.left == curNode) {
                    return curNode.parent;
                }
                curNode = curNode.parent;
            }
        }
        return null;
    }
}
