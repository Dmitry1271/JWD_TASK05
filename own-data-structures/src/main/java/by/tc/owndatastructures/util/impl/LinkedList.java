package by.tc.owndatastructures.util.impl;

import by.tc.owndatastructures.exception.IndexOutListSizeException;
import by.tc.owndatastructures.util.Iterator;
import by.tc.owndatastructures.util.Linked;

/**
 * Created by cplus on 25.11.2017.
 */
public class LinkedList implements Linked {
    private Node first;
    private Node last;
    private int size;


    public LinkedList() {
        last = new Node(null, first, null);
        first = new Node(null, null, last);
    }

    @Override
    public void addFirst(Object elem) {
        Node next = first;
        next.setElem(elem);
        first = new Node(null, null, next);
        next.setPrev(first);
        size++;
    }

    @Override
    public void addLast(Object elem) {
        Node prev = last;
        prev.setElem(elem);
        last = new Node(null, prev, null);
        prev.setNext(last);
        size++;
    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public boolean add(Object value) {
        addLast(value);
        return true;
    }

    @Override
    public Object get(int index) throws IndexOutListSizeException {
        checkRange(index);
        return getIndexNode(index).getElem();
    }

    @Override
    public Object remove(int index) throws IndexOutListSizeException {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void update(int index, Object value) throws IndexOutListSizeException {
        checkRange(index);
        getIndexNode(index).setElem(value);
    }

    @Override
    public boolean contains(Object value) {
        Node node = first;
        Object elem;
        for (int i = 0; i < size; ++i) {
            node = node.getNext();
            elem = node.getElem();
            if (elem == null ? value == null : elem.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator getIterator() {
        return null;
    }

    private class Node {
        private Object elem;
        private Node prev;
        private Node next;

        public Node() {

        }

        public Node(Object elem, Node prev, Node next) {
            this.elem = elem;
            this.prev = prev;
            this.next = next;
        }

        public Object getElem() {
            return elem;
        }

        public void setElem(Object elem) {
            this.elem = elem;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private void checkRange(int index) throws IndexOutListSizeException {
        if (index < 0 || index >= size) {
            throw new IndexOutListSizeException("Index: " + index + ", Size: " + size);
        }
    }

    private Node getIndexNode(int index) {
        Node result = first.getNext();
        for (int i = 0; i < index; ++i) {
            result = result.getNext();
        }
        return result;
    }
}
