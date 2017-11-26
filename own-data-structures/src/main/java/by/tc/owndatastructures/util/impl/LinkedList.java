package by.tc.owndatastructures.util.impl;

import by.tc.owndatastructures.exception.IndexOutListSizeException;
import by.tc.owndatastructures.exception.NoListElementException;
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
        first = new Node();
        last = new Node();

        first.setNext(last);
        last.setPrev(first);
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
    public Object removeFirst() {
        if (isEmpty()) {
            throw new NoListElementException("Size: " + size);
        }

        Node forRemove = first.getNext();

        Object elem = forRemove.getElem();
        first.setNext(forRemove.getNext());

        size--;
        return elem;
    }

    @Override
    public Object removeLast() {
        if (isEmpty()) {
            throw new NoListElementException("Size: " + size);
        }
        Node forRemove = last.getPrev();

        Object elem = forRemove.getElem();
        last.setPrev(forRemove.getPrev());

        size--;
        return elem;
    }

    @Override
    public boolean add(Object value) {
        addLast(value);
        return true;
    }

    @Override
    public Object get(int index) {
        checkRange(index);
        return getIndexNode(index).getElem();

    }

    @Override
    public Object remove(int index) {
        checkRange(index);
        Node forRemove = getIndexNode(index);
        Object elem = forRemove.getElem();

        Node next = forRemove.getNext();
        Node prev = forRemove.getPrev();

        next.setPrev(prev);
        prev.setNext(next);
        size--;

        return elem;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void update(int index, Object value) {
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
    public Iterator getIterator() {//need add
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

    private void checkRange(int index) {
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

    @Override
    public boolean equals(Object o) {//need correct
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinkedList that = (LinkedList) o;

        if (size != that.size) return false;
        if (first != null ? !first.equals(that.first) : that.first != null) return false;
        return last != null ? last.equals(that.last) : that.last == null;
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node current = first.getNext();

        if (size > 0) {
            for (int i = 0; i < size - 1; ++i) {
                result.append(current.getElem()).append(", ");
                current = current.getNext();
            }
            result.append(last.getPrev().getElem());
        }
        result.append("]");

        return result.toString();
    }
}
