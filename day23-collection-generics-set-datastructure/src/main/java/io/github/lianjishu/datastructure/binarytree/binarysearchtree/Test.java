package io.github.lianjishu.datastructure.binarytree.binarysearchtree;

import io.github.lianjishu.datastructure.binarytree.Node;

public class Test {
    public static void main(String[] args) {
        Node root = new Node(7);
        BinarySearchTree binarySearchTree = new BinarySearchTree(root);
        binarySearchTree.root.left = new Node(4);
        binarySearchTree.root.right = new Node(10);

        binarySearchTree.root.left.right = new Node(5);

        System.out.println(binarySearchTree.toString());

        System.out.println("==============\n");

        BinarySearchTree binarySearchTree1 = new BinarySearchTree();
        binarySearchTree1.insert(8);
        binarySearchTree1.insert(4);
        binarySearchTree1.insert(2);
        binarySearchTree1.insert(1);
        binarySearchTree1.insert(3);
        binarySearchTree1.insert(6);
        binarySearchTree1.insert(5);
        binarySearchTree1.insert(7);
        binarySearchTree1.insert(12);
        binarySearchTree1.insert(10);
        binarySearchTree1.insert(14);
        binarySearchTree1.insert(9);
        binarySearchTree1.insert(11);
        binarySearchTree1.insert(15);
        binarySearchTree1.insert(14);
        binarySearchTree1.insert(13);
        System.out.printf(binarySearchTree1.toString());

    }
}
