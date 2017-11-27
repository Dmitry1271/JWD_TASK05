package by.tc.owndatastructures.util.list;

/**
 * Created by cplus on 25.11.2017.
 */
public interface Simple extends Container {
    boolean add(Object value);

    Object get(int index);

    Object remove(int index);

    int size();

    void update(int index, Object value);

    boolean contains(Object value);

    boolean isEmpty();
}
