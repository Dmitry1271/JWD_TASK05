package by.tc.owndatastructures.util.list.impl;

import by.tc.owndatastructures.exception.IndexOutListSizeException;
import by.tc.owndatastructures.exception.NoListElementException;
import by.tc.owndatastructures.util.list.Iterator;
import by.tc.owndatastructures.util.list.Linked;

import java.io.Serializable;

/**
 * Created by cplus on 25.11.2017.
 */
public class LinkedList<E> implements Linked<E>, Serializable, Cloneable {
    private static final long serialVersionUID = -2194415995257282277L;

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
    public void addFirst(E elem) {
        Node next = first;
        next.elem = elem;
        first = new Node(null, null, next);
        next.prev = first;
        size++;
    }

    @Override
    public void addLast(E elem) {
        Node prev = last;
        prev.elem = elem;
        last = new Node(null, prev, null);
        prev.next = last;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoListElementException("Size: " + size);
        }

        Node forRemove = first.next;

        E elem = forRemove.elem;
        first.next = forRemove.next;

        size--;
        return elem;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new NoListElementException("Size: " + size);
        }
        Node forRemove = last.prev;

        E elem = forRemove.elem;
        last.prev = forRemove.prev;

        size--;
        return elem;
    }

    @Override
    public boolean add(E elem) {
        addLast(elem);
        return true;
    }

    @Override
    public E get(int index) {
        checkRange(index);
        return getIndexNode(index).elem;

    }

    @Override
    public E remove(int index) {
        checkRange(index);
        Node forRemove = getIndexNode(index);
        E elem = forRemove.elem;

        Node next = forRemove.next;
        Node prev = forRemove.prev;

        next.prev = prev;
        prev.next = next;
        size--;

        return elem;
    }

    @Override
    public boolean remove(E elem) {
        int index = indexOf(elem);
        if (index > 0) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void update(int index, E elem) {
        checkRange(index);
        getIndexNode(index).elem = elem;
    }

    @Override
    public boolean contains(E value) {
        Node node = first;
        E elem;
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
    public E[] toArray(E[] array) {
        Node node = first.next;
        for (int i = 0; i < size; ++i) {
            array[i] = node.elem;
            node = node.next;
        }
        return array;
    }

    @Override
    public Iterator getIterator() {
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<E> {
        private int index;
        private Node current = first.next;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            if (!this.hasNext()) {
                throw new IndexOutListSizeException("Index: " + index + ", Size: " + size);
            }
            E elem = current.elem;
            current = current.next;
            index++;
            return elem;
        }
    }

    private Node getIndexNode(int index) {
        Node result = first.next;
        for (int i = 0; i < index; ++i) {
            result = result.next;
        }
        return result;
    }

    private int indexOf(E value) {
        Node node = first.next;
        for (int i = 0; i < size; ++i) {
            if (value != null ? value.equals(node.elem) : node.elem == null) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    private class Node {
        private E elem;
        private Node prev;
        private Node next;

        Node() {
        }

        Node(E elem, Node prev, Node next) {
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
