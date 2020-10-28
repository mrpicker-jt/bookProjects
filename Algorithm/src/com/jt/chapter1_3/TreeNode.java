package com.jt.chapter1_3;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @program: Algorithm
 * @description: 二叉树节点
 * @author: Mrpicker
 * @create: 2020-10-28 19:56
 **/
public class TreeNode<T> {
    T item;
    TreeNode<T> left;//左子节点
    TreeNode<T> right;//右子节点

    public TreeNode(T item) {
        this.item = item;
    }

    public TreeNode() {
    }

    public static void main(String[] args) {
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        IntStream.range(0, 20).mapToObj(i -> "item" + i).forEach(linkedList::add);
        TreeNode<String> root = generateTree(linkedList.getFirst());
        printTreePrefixRecurse(root);

    }

    public static <T> TreeNode<T> generateTree(Node<T> first) {
        if (first == null) {
            return null;
        }
        TreeNode<T> root = new TreeNode<>();
        root.item = first.item;
        List<TreeNode<T>> nextTNodes = new ArrayList<>();
        nextTNodes.add(root);
        innerSetTree(nextTNodes, first.next);
        return root;
    }

    private static <T> void innerSetTree(List<TreeNode<T>> curTNodes, Node<T> cur) {
        List<TreeNode<T>> nextTNodes = new ArrayList<>();
        //先遍历填充当前层的左右子节点
        for (int i = 0; i < curTNodes.size(); i++) {
            TreeNode<T> tTreeNode = curTNodes.get(i);
            //先填充左节点
            if (cur != null) {
                tTreeNode.left = new TreeNode<>(cur.item);
                nextTNodes.add(tTreeNode.left);
                cur = cur.next;
            } else {
                return;
            }
            //再填充右节点
            if (cur != null) {
                tTreeNode.right = new TreeNode<>(cur.item);
                nextTNodes.add(tTreeNode.right);
                cur = cur.next;
            } else {
                return;
            }
        }
        innerSetTree(nextTNodes, cur);
    }

    public static <T> void printTreePrefixRecurse(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        StdOut.print(root.item.toString() + " ");
        printTreePrefixRecurse(root.left);
        printTreePrefixRecurse(root.right);
    }

    public static <T> void printTreePrefix(TreeNode<T> root) {
        
    }

}
