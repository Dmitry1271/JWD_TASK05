package by.tc.owndatastructures.util.list;

/**
 * Created by cplus on 25.11.2017.
 */
public interface Simple<E> extends Container {
    boolean add(E value);

    E get(int index);

    E remove(int index);

    boolean remove(E value);

    int size();

    void update(int index, E value);

    boolean contains(E value);

    boolean isEmpty();

    E[] toArray(E[] array);
}
