package io.github.lianjishu.datastructure.binarytree.binarysearchtree;

import io.github.lianjishu.datastructure.binarytree.Node;

import java.util.*;

public class BinarySearchTree {
    public Node root = null; //树根节点

    public BinarySearchTree() {
    }

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    /**
     * 插入节点
     */
    public void insert(int num) {
        if (root == null) {
            root = new Node(num);
            return;
        }

        Node curr = root;
        Node prev = null;
        while (curr != null) {
            if (num < curr.value) {
                prev = curr;
                curr = curr.left;
            } else if (num > curr.value) {
                prev = curr;
                curr = curr.right;
            } else return;
        }
        if (num < prev.value)
            prev.left = new Node(num);
        else
            prev.right = new Node(num);
    }

    /**
     * 层序遍历
     */
    @Override
    public String toString() {
        //初始化队列, 放入根节点
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        //初始化列表,用于保存遍历序列
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();    // 队列出队
            list.add(node.value);        // 保存节点值
            if (node.left != null)
                queue.offer(node.left);  // 左节点入队
            if (node.right != null)
                queue.offer(node.right); // 右节点入队
        }
        //primitive array to wrapper array
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        return Arrays.toString(arr);     // 返回list的String
    }

    public void remove(int target) {
        if (root == null) return;

        Node curr = root, prev = null;
        while (curr != null) {
            if (target == curr.value)
                break;
            prev = curr;
            if (target < curr.value)
                curr = curr.left;
            else if (target > curr.value)
                curr = curr.right;
        }
        // 若无待删除节点，则直接返回
        if (curr == null)
            return;
        // 待删节点的子节点数为0或1
        if (curr.left == null || curr.right == null) {
            //孩子节点
            Node child = curr.left != null ? curr.left : curr.right;
            //删除curr
            if (curr != root) {
                if (prev.left == curr)
                    prev.left = child;
                else
                    prev.right = child;
            } else {//curr == root
                root = child;
            }
        } else {// 待删节点的子节点数为2
            // 获取中序遍历中 cur 的下一个节点
            Node tmp = curr.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            // 递归删除节点 tmp
            remove(tmp.value);
            // 用 tmp 覆盖 cur
            curr.value = tmp.value;
        }

        /**
         *      5
         *     /\
         *    4  6
         *   /\  \
         *  3 9  8
         */


    }

    /**
     * 查找节点
     */
    public Node search(int target) {
        if (root == null) return null;
        Node curr = root;
        while (curr != null) {
            if (target < curr.value)
                curr = curr.left;
            else if (target > curr.value)
                curr = curr.right;
            else // curr.value == target
                break;
        }
        return curr;
    }

    /**
     * 插入节点递归实现
     */
    private void insertWithRecur(int target) {
        if (root == null) root = new Node(target);
        root = insertRecur(root, target);
    }

    private Node insertRecur(Node node, int target) {
        //最小子问题: node==null | 构造新节点
        if (node == null) return new Node(target);
        //递推
        //问题缩小到左子树
        if (target < node.value) node = insertRecur(node.left, target);
        //问题缩小到右子树
        if (target > node.value) node = insertRecur(node.right, target);
        //回溯组装
        return node;
    }
}
