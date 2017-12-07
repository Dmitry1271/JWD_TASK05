package by.tc.owndatastructures.util.tree;

import java.util.List;

/**
 * Created by cplus on 27.11.2017.
 */
public interface Tree<E extends Comparable> {
    boolean add(E elem);

    boolean remove(E elem);

    boolean search(E elem);

    List<E> preOrder();

    List<E> inOrder();

    List<E> postOrder();
}
