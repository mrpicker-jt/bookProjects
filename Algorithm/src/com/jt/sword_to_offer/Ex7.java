package com.jt.sword_to_offer;

import com.jt.chapter1_3.SinglyLinkedList;
import com.jt.chapter1_3.TreeNode;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @program: Algorithm
 * @description: 重建二叉树
 * @author: Mrpicker
 * @create: 2020-11-11 19:45
 **/
public class Ex7 {
    static HashMap<Integer, Integer> inMap = new HashMap<>();

    public static void main(String[] args) {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        IntStream.range(0, 10).forEach(linkedList::add);
        TreeNode<Integer> root = TreeNode.generateTree(linkedList.getFirst());
        List<Integer> preList = new ArrayList<>();
        List<Integer> inList = new ArrayList<>();
        List<Integer> postList = new ArrayList<>();
        TreeNode.pre(root, preList);
        StdOut.println();
        TreeNode.mid(root, inList);
        StdOut.println();
        TreeNode.post(root, postList);
        StdOut.println();
        StdOut.println();
        StdOut.println();

        TreeNode<Integer> treeNode = generateByPreAndIn(preList, inList);
        TreeNode.levelTravel(treeNode);
        StdOut.println();
        TreeNode<Integer> treeNode1 = generateByPostAndIn(postList, inList);
        TreeNode.levelTravel(treeNode1);

    }

    private static TreeNode<Integer> generateByPreAndIn(List<Integer> preOrder, List<Integer> inOrder) {
        if (preOrder.isEmpty() || inOrder.isEmpty()) {
            return null;
        }
        inMap.clear();
        for (int i = 0; i < inOrder.size(); i++) {
            inMap.put(inOrder.get(i), i);
        }
        return recur(preOrder, 0, 0, inOrder.size() - 1);
    }

    private static TreeNode<Integer> recur(List<Integer> preOrder, int root, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode<Integer> node = new TreeNode<>();
        node.setItem(preOrder.get(root));
        int i = inMap.get(preOrder.get(root));
        node.setLeft(recur(preOrder, root + 1, left, i - 1));
        node.setRight(recur(preOrder, root + i - left + 1, i + 1, right));
        return node;
    }


    // TODO: 2020/11/11 根据中序和后序重建 
    private static TreeNode<Integer> generateByPostAndIn(List<Integer> postOrder, List<Integer> inOrder) {
        if (postOrder.isEmpty() || inOrder.isEmpty()) {
            return null;
        }
        inMap.clear();
        for (int i = 0; i < inOrder.size(); i++) {
            inMap.put(inOrder.get(i), i);
        }
        return recurPost(postOrder, postOrder.size() - 1, 0, inOrder.size() - 1);
    }

    private static TreeNode<Integer> recurPost(List<Integer> postOrder, int root, int left, int right) {
        if (left > right) {
            return null;
        }
        if (root < 0) {
            return null;
        }
        TreeNode<Integer> node = new TreeNode<>();
        node.setItem(postOrder.get(root));
        int i = inMap.get(postOrder.get(root));
        node.setLeft(recurPost(postOrder, root - (right - i) - 1, i + 1, right));
        node.setRight(recurPost(postOrder, root - 1, left, i - 1));
        return node;
    }

}
