package by.tc.owndatastructures.util.list.impl;

import by.tc.owndatastructures.util.list.Iterator;
import by.tc.owndatastructures.util.list.Linked;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cplus on 03.12.2017.
 */
public class LinkedIteratorTest {
    @Test
    public void hasNext() throws Exception {
        Linked list = new LinkedList();
        list.addFirst(3);
        list.addLast(4);
        list.add(5);
        Iterator iter = list.getIterator();
        Assert.assertTrue(iter.hasNext());
    }

    @Test
    public void hasNext1() throws Exception {
        Linked list = new LinkedList();
        Iterator iter = list.getIterator();
        Assert.assertFalse(iter.hasNext());
    }

    @Test
    public void next() throws Exception {
        Object[] expected = {3, 4, 5, null};

        Linked list = new LinkedList();
        list.addFirst(3);
        list.addLast(4);
        list.add(5);
        list.add(null);

        Object[] actual = new Object[list.size()];
        Iterator iter = list.getIterator();

        int i = 0;
        while (iter.hasNext()) {
            actual[i++] = iter.next();
        }
        Assert.assertArrayEquals(expected, actual);
    }

}
