package by.tc.owndatastructures.util.tree.impl;

import by.tc.owndatastructures.util.tree.Tree;

import java.io.Serializable;

/**
 * Created by cplus on 27.11.2017.
 */
public class BinaryTree implements Tree, Serializable, Cloneable{
    private static final long serialVersionUID = -577133173077825018L;

    private Node node;

    public BinaryTree(){
        node = new Node();
    }

    @Override
    public boolean add(Object elem) {
        return false;
    }

    @Override
    public void remove() {

    }

    private class Node {
        Object elem;
        Node left;
        Node right;

        Node() {
        }

        Node(Object elem, Node left, Node right) {
            this.elem = elem;
            this.left = left;
            this.right = right;
        }
    }
}
