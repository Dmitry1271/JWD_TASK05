package by.tc.owndatastructures.util.tree.impl;

import by.tc.owndatastructures.util.tree.Tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cplus on 27.11.2017.
 */
public class BinaryTree implements Tree, Serializable, Cloneable {
    private static final long serialVersionUID = -577133173077825018L;

    private Node root;

    private List<Object> traverse;

    public BinaryTree() {
    }

    public BinaryTree(Object elem) {
        root = new Node();
        root.elem = elem;
    }

    @Override
    public boolean add(Object elem) {
        if (root != null) {
            root = insert(root, null, elem);
        } else {
            root = new Node();
            root.elem = elem;
        }
        return true;
    }

    @Override
    public void remove(Object elem) {

    }

    @Override
    public boolean contains(Object elem) {
        return preOrder().contains(elem);
    }

    @Override
    public List<Object> preOrder() {
        traverse = new ArrayList<>();
        preOrder(root);
        return traverse;
    }


    @Override
    public List<Object> inOrder() {
        traverse = new ArrayList<>();
        inOrder(root);
        return traverse;
    }

    @Override
    public List<Object> postOrder() {
        traverse = new ArrayList<>();
        postOrder(root);
        return traverse;
    }

    private Node insert(Node node, Node parent, Object elem) {
        if (node == null) {
            node = new Node();
            node.elem = elem;
            node.parent = parent;
        } else if (goLeft(node)) {
            node.left = insert(node.left, node, elem);
        } else {
            node.right = insert(node.right, node, elem);
        }
        return node;
    }

    private boolean goLeft(Node node) {
        int depthLeft = getDepth(node.left, 0);
        int depthRight = getDepth(node.right, 0);

        return depthLeft == depthRight;
    }

    private int getDepth(Node node, int depth) {
        if (node != null) {
            depth = getDepth(node.right, depth + 1);
        }
        return depth;
    }


    private void preOrder(Node node) {
        if (node != null) {
            traverse.add(node.elem);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            traverse.add(node.elem);
            inOrder(node.right);
        }
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            traverse.add(node.elem);
        }
    }

    private class Node {
        Object elem;
        Node left;
        Node right;
        Node parent;

        Node() {
        }

        Node(Object elem, Node left, Node right, Node parent) {
            this.elem = elem;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (elem != null ? !elem.equals(node.elem) : node.elem != null) return false;
            if (left != null ? !left.equals(node.left) : node.left != null) return false;
            return right != null ? right.equals(node.right) : node.right == null;
        }

        @Override
        public int hashCode() {
            int result = elem != null ? elem.hashCode() : 0;
            result = 31 * result + (left != null ? left.hashCode() : 0);
            result = 31 * result + (right != null ? right.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "elem=" + elem +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BinaryTree that = (BinaryTree) o;

        return root != null ? root.equals(that.root) : that.root == null;
    }

    @Override
    public int hashCode() {
        return root != null ? root.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }
}
