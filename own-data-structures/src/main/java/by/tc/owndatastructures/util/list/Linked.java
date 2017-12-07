package by.tc.owndatastructures.util.list;

/**
 * Created by cplus on 25.11.2017.
 */
public interface Linked<E> extends Simple<E>{
    void addFirst(E elem);

    void addLast(E elem);

    E removeFirst();

    E removeLast();

    int size();
}
