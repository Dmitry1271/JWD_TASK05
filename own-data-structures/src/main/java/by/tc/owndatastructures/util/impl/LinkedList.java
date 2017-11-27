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

        first.next = last;
        last.prev = first;
    }

    @Override
    public void addFirst(Object elem) {
        Node next = first;
        next.elem = elem;
        first = new Node(null, null, next);
        next.prev = first;
        size++;
    }

    @Override
    public void addLast(Object elem) {
        Node prev = last;
        prev.elem = elem;
        last = new Node(null, prev, null);
        prev.next = last;
        size++;
    }

    @Override
    public Object removeFirst() {
        if (isEmpty()) {
            throw new NoListElementException("Size: " + size);
        }

        Node forRemove = first.next;

        Object elem = forRemove.elem;
        first.next = forRemove.next;

        size--;
        return elem;
    }

    @Override
    public Object removeLast() {
        if (isEmpty()) {
            throw new NoListElementException("Size: " + size);
        }
        Node forRemove = last.prev;

        Object elem = forRemove.elem;
        last.prev = forRemove.prev;

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
        return getIndexNode(index).elem;

    }

    @Override
    public Object remove(int index) {
        checkRange(index);
        Node forRemove = getIndexNode(index);
        Object elem = forRemove.elem;

        Node next = forRemove.next;
        Node prev = forRemove.prev;

        next.prev = prev;
        prev.next = next;
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
        getIndexNode(index).elem = value;
    }

    @Override
    public boolean contains(Object value) {
        Node node = first;
        Object elem;
        for (int i = 0; i < size; ++i) {
            node = node.next;
            elem = node.elem;
            if (elem != null ? elem.equals(value) : value == null) {
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
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator {
        private int index;
        private Node current = first.next;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Object next() {
            if (!this.hasNext()) {
                throw new IndexOutListSizeException("Index: " + index + ", Size: " + size);
            }
            Object elem = current.elem;
            current = current.next;
            index++;
            return elem;
        }
    }

    private class Node {
        private Object elem;
        private Node prev;
        private Node next;

        Node() {
        }

        Node(Object elem, Node prev, Node next) {
            this.elem = elem;
            this.prev = prev;
            this.next = next;
        }
    }

    private void checkRange(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutListSizeException("Index: " + index + ", Size: " + size);
        }
    }

    private Node getIndexNode(int index) {
        Node result = first.next;
        for (int i = 0; i < index; ++i) {
            result = result.next;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinkedList that = (LinkedList) o;

        if (size != that.size) return false;

        Node node = first.next;
        Node thatNode = that.first.next;
        int count = 0;

        for (int i = 0; i < size; ++i) {
            if (thatNode.elem != null ? thatNode.elem.equals(node.elem) : node.elem == null) {
                count++;
            }
        }

        return count == size;
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
        Node current = first.next;

        if (size > 0) {
            for (int i = 0; i < size - 1; ++i) {
                result.append(current.elem).append(", ");
                current = current.next;
            }
            result.append(last.prev.elem);
        }
        result.append("]");

        return result.toString();
    }
}
