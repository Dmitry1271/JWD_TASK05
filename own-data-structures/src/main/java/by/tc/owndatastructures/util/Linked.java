package by.tc.owndatastructures.util;

/**
 * Created by cplus on 25.11.2017.
 */
public interface Linked extends Simple{
    void addFirst(Object elem);

    void addLast(Object elem);

    Object removeFirst();

    Object removeLast();

    int size();
}
