package by.tc.owndatastructures.util.list.impl;

import by.tc.owndatastructures.util.list.Simple;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by cplus on 02.12.2017.
 */

public class SimpleListTest {
    @Test
    public void toArray() throws Exception {
        Integer[] expected = {1, 2, null, null, -9, -193, new Integer("43"), new Integer(65)};
        Simple<Integer> list = new SimpleList<>(2);
        list.add(1);
        list.add(2);
        list.add(null);
        list.add(null);
        list.add(-9);
        list.add(-193);
        list.add(43);
        list.add(65);
        Integer[] actual = new Integer[list.size()];
        actual = list.toArray(actual);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void add() throws Exception {
        String[] expected = {"qwer", "vvvv", null, "34"};
        Simple<String> list = new SimpleList<>(4);
        list.add("qwer");
        list.add("vvvv");
        list.add(null);
        list.add("34");
        String[] actual = new String[list.size()];
        actual = list.toArray(actual);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void get() throws Exception {
        String expected = "tr";
        Simple<String> list = new SimpleList<>();
        list.add("qwer");
        list.add("vvvv");
        list.add("tr");
        list.add(null);
        list.add("34");
        String actual = list.get(2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void remove() throws Exception {
        Double[] expected = {2.4, 6.7};
        Simple<Double> list = new SimpleList<>();
        list.add(1.5);
        list.add(2.4);
        list.add(4d);
        list.add(6.7);
        list.remove(0);
        list.remove(1);
        Double[] actual = new Double[list.size()];
        actual = list.toArray(actual);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void remove1() throws Exception {
        String[] expected = {"wqe", "4"};
        Simple<String> list = new SimpleList<>();
        list.add("54");
        list.add("wqe");
        list.add("4");
        list.add("kf");
        list.add(null);
        list.remove("54");
        list.remove(null);
        list.remove("kf");
        list.remove("uuuuuuuuuuuuuuuuu");
        String[] actual = new String[list.size()];
        actual = list.toArray(actual);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void size() throws Exception {
        int expected = 3;
        Simple<Object> list = new SimpleList<>();
        list.add(null);
        list.add("qwer");
        list.add(4);
        int actual = list.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void update() throws Exception {
        Integer[] expected = {1, 2, 3};
        Simple<Integer> list = new SimpleList<>();
        list.add(5);
        list.add(null);
        list.add(3);
        list.update(0, 1);
        list.update(1, 2);
        Integer[] actual = new Integer[list.size()];
        actual = list.toArray(actual);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void contains() throws Exception {
        Simple<String> list = new SimpleList<>();
        list.add("q");
        list.add("w");
        list.add("r");
        list.add("gr");
        Assert.assertTrue(list.contains("q"));
    }

    @Test
    public void isEmpty() throws Exception {
        Simple list = new SimpleList();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void isEmpty1() throws Exception {
        Simple list = new SimpleList();
        list.add(null);
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void equals() throws Exception {
        Simple list1 = new SimpleList();
        list1.add(1);
        list1.add(null);
        list1.add("qwer");
        list1.add(0.4);
        list1.add('t');

        Simple list2 = new SimpleList();
        list2.add(1);
        list2.add(null);
        list2.add("qwer");
        list2.add(0.4);
        list2.add('t');

        Assert.assertTrue(list1.equals(list2));
    }

}
