package by.tc.owndatastructures.util;

import by.tc.owndatastructures.exception.IndexOutListSizeException;

/**
 * Created by cplus on 25.11.2017.
 */
public interface Simple extends Container {
    boolean add(Object value);

    Object get(int index) throws IndexOutListSizeException;

    Object remove(int index) throws IndexOutListSizeException;

    int size();

    void update(int index, Object value) throws IndexOutListSizeException;

    boolean contains(Object value);

    boolean isEmpty();
}
