package by.tc.owndatastructures.util.list.impl;

import by.tc.owndatastructures.util.list.Iterator;
import by.tc.owndatastructures.util.list.Simple;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cplus on 03.12.2017.
 */
public class MyListIteratorTest {
    @Test
    public void hasNext() throws Exception {
        Simple<String> list = new SimpleList<>();
        list.add("q");
        list.add("qq");
        list.add("qqq");
        Iterator iter = list.getIterator();
        Assert.assertTrue(iter.hasNext());
    }

    @Test
    public void hasNext1() throws Exception {
        Simple<String> list = new SimpleList<>();
        list.add("q");
        list.add("qq");
        list.remove("q");
        list.remove(0);
        Iterator iter = list.getIterator();
        Assert.assertFalse(iter.hasNext());
    }

    @Test
    public void hasNext2() throws Exception {
        Simple<String> list = new SimpleList<>();
        Iterator iter = list.getIterator();
        Assert.assertFalse(iter.hasNext());
    }

    @Test
    public void next() throws Exception {
        String[] expected = {"q", "qq", "qqq", "qqqq"};
        Simple<String> list = new SimpleList<>();
        list.add("q");
        list.add("qq");
        list.add("qqq");
        list.add("qqqq");
        Iterator<String> iter = list.getIterator();
        String[] actual = new String[list.size()];
        int i = 0;
        while (iter.hasNext()) {
            actual[i++] = iter.next();
        }
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void next1() throws Exception {
        Simple<String> list = new SimpleList<>();
        list.add("sdg");
        Iterator iter = list.getIterator();
        Assert.assertEquals("sdg", iter.next());
    }


}
