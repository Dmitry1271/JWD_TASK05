package by.tc.owndatastructures.util.tree.impl;

import by.tc.owndatastructures.util.tree.Tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cplus on 27.11.2017.
 */
public class BinaryTree<E extends Comparable> implements Tree<E>, Serializable, Cloneable {
    private static final long serialVersionUID = -577133173077825018L;

    private Node root;

    public BinaryTree() {
    }

    public BinaryTree(E elem) {
        root = new Node();
        root.elem = elem;
    }

    @Override
    public boolean add(E elem) {
        if (elem == null) {
            return false;
        }

        if (root != null) {
            root = insert(root, elem);
        } else {
            root = new Node();
            root.elem = elem;
        }
        return true;
    }

    @Override
    public boolean remove(E elem) {
        if (search(elem, root) != null) {
            remove(elem, root);
            return true;
        }
        return false;
    }

    @Override
    public boolean search(E elem) {
        return search(elem, root) != null;
    }

    @Override
    public List<E> preOrder() {
        List<E> list = new ArrayList<>();
        return preOrder(root, list);
    }


    @Override
    public List<E> inOrder() {
        List<E> list = new ArrayList<>();
        return inOrder(root, list);
    }

    @Override
    public List<E> postOrder() {
        List<E> list = new ArrayList<>();
        return postOrder(root, list);
    }

    private Node insert(Node node, E elem) {
        if (node == null) {
            node = new Node();
            node.elem = elem;
        } else if (elem.compareTo(node.elem) < 0) {
            node.left = insert(node.left, elem);
        } else {
            node.right = insert(node.right, elem);
        }
        return node;
    }

    private Node search(E elem, Node node) {
        if (node == null) {
            return null;
        }

        if (node.elem.equals(elem)) {
            return node;
        } else {

            if (elem.compareTo(node.elem) < 0) {
                node = search(elem, node.left);
            } else {
                node = search(elem, node.right);
            }

        }
        return node;
    }

    private Node remove(E elem, Node node) {
        if (elem.compareTo(node.elem) < 0) {
            node.left = remove(elem, node.left);
        } else if (elem.compareTo(node.elem) > 0) {
            node.right = remove(elem, node.right);
        } else if (node.left != null && node.right != null) {
            node.elem = getMin(node.right).elem;
            node.right = remove(node.elem, node.right);
        } else {
            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    private Node getMin(Node node) {
        if (node.left != null) {
            node = getMin(node.left);
        }

        return node;
    }

    private List<E> preOrder(Node node, List<E> list) {
        if (node != null) {
            list.add(node.elem);
            preOrder(node.left, list);
            preOrder(node.right, list);
        }
        return list;
    }

    private List<E> inOrder(Node node, List<E> list) {
        if (node != null) {
            inOrder(node.left, list);
            list.add(node.elem);
            inOrder(node.right, list);
        }
        return list;
    }

    private List<E> postOrder(Node node, List<E> list) {
        if (node != null) {
            postOrder(node.left, list);
            postOrder(node.right, list);
            list.add(node.elem);
        }
        return list;
    }

    private class Node {
        E elem;
        Node left;
        Node right;

        Node() {
        }

        Node(E elem, Node left, Node right) {
            this.elem = elem;
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Node node = (Node) o;

            if (elem != null ? !elem.equals(node.elem) : node.elem != null) {
                return false;
            }
            if (left != null ? !left.equals(node.left) : node.left != null) {
                return false;
            }
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
            return "\nNode{" +
                    "elem=" + elem +
                    ",left=" + left +
                    ",right=" + right +
                    '}';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BinaryTree that = (BinaryTree) o;

        if (root != null ? root.equals(that.root) : that.root == null) {
            return true;
        }
        return that.preOrder().equals(preOrder());
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
