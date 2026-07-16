package io.github.lianjishu.datastructure.binarytree;

public class Node {
    public int value = 0;
    public Node left = null;
    public Node right = null;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
