package by.tc.owndatastructures.util.impl;


import by.tc.owndatastructures.exception.IndexOutListSizeException;
import by.tc.owndatastructures.util.Iterator;
import by.tc.owndatastructures.util.Simple;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by cplus on 25.11.2017.
 */
public class SimpleList implements Simple, Serializable, Cloneable {
    private static final long serialVersionUID = -7521721020811369924L;
    private static final int DEFAULT_SIZE = 10;

    private Object[] array;
    private int size;

    public SimpleList() {
        array = new Object[DEFAULT_SIZE];
    }

    public SimpleList(int firstSize) {
        array = new Object[firstSize];
    }

    public Iterator getIterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator {
        private int index;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return array[index++];
            }
            return null;
        }
    }

    @Override
    public boolean add(Object value) {
        if (size >= array.length) {
            resize(array.length * 2);
        }
        array[size++] = value;
        return true;
    }

    @Override
    public Object get(int index) throws IndexOutListSizeException {
        checkRange(index);
        return array[index];
    }

    @Override
    public Object remove(int index) throws IndexOutListSizeException {
        checkRange(index);

        Object oldValue = array[index];
        int numberElements = size - index - 1;

        if (numberElements > 0) {
            System.arraycopy(array, index + 1, array, index, numberElements);
        }

        array[--size] = null;

        return oldValue;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void update(int index, Object value) throws IndexOutListSizeException {
        checkRange(index);
        array[index] = value;
    }

    @Override
    public boolean contains(Object value) {
        Object elem;
        for (int i = 0; i < size; ++i) {
            elem = array[i];

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

    private void resize(int newSize) {
        Object[] temp = array;
        array = new Object[newSize];
        System.arraycopy(temp, 0, array, 0, size);
    }

    private void checkRange(int index) throws IndexOutListSizeException {
        if (index < 0 || index >= size) {
            throw new IndexOutListSizeException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleList that = (SimpleList) o;

        if (size != that.size) return false;

        int count = 0;
        Object elem;
        Object thatElem;

        for (int i = 0; i < size; ++i) {
            elem = array[i];
            thatElem = that.array[i];

            if (elem == null ? thatElem == null : elem.equals(thatElem)) {
                count++;
            }
        }
        return count == size;
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(array);
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        if (size > 0) {
            for (int i = 0; i < size - 1; ++i) {
                result.append(array[i]).append(", ");
            }
            result.append(array[size - 1]);
        }

        result.append("]");
        return result.toString();
    }
}
