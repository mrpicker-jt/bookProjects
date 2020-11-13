package com.jt.chapter1_3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
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
    public T item;
    public TreeNode<T> left;//左子节点
    public TreeNode<T> right;//右子节点
    public TreeNode<T> parent;

    public TreeNode(T item) {
        this.item = item;
    }

    public TreeNode() {
    }

    public static void main(String[] args) {
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        IntStream.range(0, 20).mapToObj(i -> "item" + i).forEach(linkedList::add);
        TreeNode<String> root = generateTree(linkedList.getFirst());
        printTreePostFixRecurse(root);
        StdOut.println();
        post(root, new ArrayList<>());
        StdOut.println();
        levelTravel(root);
    }

    public static <T> void pre(TreeNode<T> root, List<T> list) {
        Stack<TreeNode<T>> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                printNode(root);
                list.add(root.item);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop().right;
            }
        }
    }

    public static <T> void mid(TreeNode<T> root, List<T> list) {
        Stack<TreeNode<T>> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode<T> pop = stack.pop();
                printNode(pop);
                list.add(pop.item);
                root = pop.right;
            }
        }
    }

    public static <T> void post(TreeNode<T> root, List<T> list) {
        Stack<TreeNode<T>> stack = new Stack<>();
        Stack<TreeNode<T>> output = new Stack<>();


        while (root != null || stack.size() > 0) {
            if (root != null) {
                output.push(root);
                stack.push(root);
                root = root.right;
            } else {
                root = stack.pop().left;
            }
        }
        while (!output.isEmpty()) {
            TreeNode<T> pop = output.pop();
            printNode(pop);
            list.add(pop.item);
        }
    }

    public static <T> void levelTravel(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode<T>> queue = new Queue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            TreeNode<T> dequeue = queue.dequeue();
            printNode(dequeue);
            if (dequeue.left != null) {
                queue.enqueue(dequeue.left);
            }
            if (dequeue.right != null) {
                queue.enqueue(dequeue.right);
            }
        }
    }

    /**
     * @param first 单链表的头
     * @param <T>
     * @return
     */
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
        Stack<TreeNode<T>> stack = new Stack<>();

        // 步骤1：直到当前结点为空 & 栈空时，循环结束
        while (root != null || stack.size() > 0) {

            // 步骤2：判断当前结点是否为空
            // a. 若不为空，执行3
            // b. 若为空，执行5
            if (root != null) {

                // 步骤3：输出当前节点，并将其入栈
                printNode(root);
                stack.push(root);
                // 步骤4：置当前结点的左孩子为当前节点
                // 返回步骤1
                root = root.left;

            } else {

                // 步骤5：出栈栈顶结点
                root = stack.pop();
                // 步骤6：置当前结点的右孩子为当前节点
                root = root.right;
                // 返回步骤1
            }
        }
    }

    public static <T> void printTreeMidFixRecurse(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        printTreeMidFixRecurse(root.left);
        StdOut.print(root.item.toString() + " ");
        printTreeMidFixRecurse(root.right);
    }

    public static <T> void printTreeMidFix(TreeNode<T> root) {
        Stack<TreeNode<T>> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                printNode(root);
                root = root.right;
            }
        }
    }

    public static <T> void printTreePostFixRecurse(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        printTreePostFixRecurse(root.left);
        printTreePostFixRecurse(root.right);
        StdOut.print(root.item.toString() + " ");
    }

    public static <T> void printTreePostFix(TreeNode<T> root) {
        Stack<TreeNode<T>> stack = new Stack<>();
        Stack<TreeNode<T>> output = new Stack<>();

        // 步骤1：直到当前结点为空 & 栈空时，循环结束——> 步骤8
        while (root != null || stack.size() > 0) {

            // 步骤2：判断当前结点是否为空
            // a. 若不为空，执行3、4
            // b. 若为空，执行5、6
            if (root != null) {

                // 步骤3：入栈当前结点到中间栈
                output.push(root);

                // 步骤4：入栈当前结点到普通栈
                stack.push(root);

                // 步骤4：置当前结点的右孩子为当前节点
                // 返回步骤1
                root = root.right;

            } else {

                // 步骤5：出栈栈顶结点
                root = stack.pop();
                // 步骤6：置当前结点的右孩子为当前节点
                root = root.left;
                // 返回步骤1
            }
        }

        // 步骤8：输出中间栈的结点
        while (output.size() > 0) {
            printNode(output.pop());
        }
    }

    private static <T> void printNode(TreeNode<T> node) {
        StdOut.print(node.item.toString() + " ");
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }


}
