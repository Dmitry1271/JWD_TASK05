package by.tc.owndatastructures.util.list.impl;


import by.tc.owndatastructures.exception.IndexOutListSizeException;
import by.tc.owndatastructures.util.list.Iterator;
import by.tc.owndatastructures.util.list.Simple;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by cplus on 25.11.2017.
 */
public class SimpleList<E> implements Simple<E>, Serializable, Cloneable {
    private static final long serialVersionUID = -7521721020811369924L;
    private static final int DEFAULT_SIZE = 10;
    private E[] array;
    private int size;

    public SimpleList() {
        array = (E[]) new Object[DEFAULT_SIZE];
    }

    public SimpleList(int firstSize) {

        array = (E[]) new Object[firstSize];
    }


    private void resize(int newSize) {
        E[] temp = array;
        array = (E[]) new Object[newSize];
        System.arraycopy(temp, 0, array, 0, size);
    }

    private void checkRange(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutListSizeException("Index: " + index + ", Size: " + size);
        }
    }

    public Iterator getIterator() {
        return new MyListIterator();
    }

    private int indexOf(E elem) {
        for (int i = 0; i < size; ++i) {
            if (elem != null ? elem.equals(array[i]) : array[i] == null) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean add(E elem) {
        if (size >= array.length) {
            resize(array.length * 2);
        }
        array[size++] = elem;
        return true;
    }

    @Override
    public E get(int index) {
        checkRange(index);
        E a = null;
        return array[index];
    }

    @Override
    public E remove(int index) {
        checkRange(index);

        E oldValue = array[index];
        int numberElements = size - index - 1;

        if (numberElements > 0) {
            System.arraycopy(array, index + 1, array, index, numberElements);
        }

        array[--size] = null;

        return oldValue;
    }

    @Override
    public boolean remove(E elem) {
        int index = indexOf(elem);
        if (index >= 0) {
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
        array[index] = elem;
    }

    @Override
    public boolean contains(E elem) {
        E current;
        for (int i = 0; i < size; ++i) {
            current = array[i];

            if (current != null ? current.equals(elem) : elem == null) {
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
        System.arraycopy(this.array, 0, array, 0, size);
        return array;
    }

    private class MyListIterator implements Iterator<E> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            if (!this.hasNext()) {
                throw new IndexOutListSizeException("Index: " + index + ", Size: " + size);
            }
            return array[index++];
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

        SimpleList<?> that = (SimpleList<?>) o;

        if (size != that.size) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (array[i] != null ? !that.array[i].equals(array[i]) : that.array[i] != null) {
                return false;
            }
        }

        return true;
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
