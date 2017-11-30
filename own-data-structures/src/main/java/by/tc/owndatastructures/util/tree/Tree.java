package by.tc.owndatastructures.util.tree;

import java.util.List;

/**
 * Created by cplus on 27.11.2017.
 */
public interface Tree {
    boolean add(Object elem);

    void remove(Object elem);

    boolean contains(Object elem);

    List<Object> preOrder();

    List<Object> inOrder();

    List<Object> postOrder();
}
