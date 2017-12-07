package by.tc.owndatastructures.util.list.impl;

import by.tc.owndatastructures.util.list.Linked;
import by.tc.owndatastructures.util.list.Simple;
import org.junit.*;
import org.omg.PortableInterceptor.ACTIVE;

import java.util.Arrays;

/**
 * Created by cplus on 03.12.2017.
 */
public class LinkedListTest {
    Linked<String> list;

    @Before
    public void init() {
        list = new LinkedList<>();
        list.add("Dima");
        list.add("Kozlov");
        list.add("Sidorov");
        list.add("212");
        list.add(null);
        list.add("-04fiac398");
    }

    @After
    public void destroy() {
        list = null;
    }

    @Test
    public void addFirst() throws Exception {
        Integer[] expected = {1, 2, null, 3};
        Linked<Integer> list = new LinkedList<>();
        list.addFirst(3);
        list.addFirst(null);
        list.addFirst(2);
        list.addFirst(1);
        Integer[] actual = new Integer[list.size()];
        actual = list.toArray(actual);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void addLast() throws Exception {
        Double[] expected = {1d, 2.3, 3.7, null};
        Linked<Double> list = new LinkedList<>();
        list.addLast(1d);
        list.addLast(2.3);
        list.addLast(3.7);
        list.addLast(null);
        Double[] actual = new Double[list.size()];
        actual = list.toArray(actual);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeFirst() throws Exception {
        String[] expected = {"212", null, "-04fiac398"};
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();

        String[] actual = new String[list.size()];
        actual = list.toArray(actual);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeLast() throws Exception {
        String[] expected = {"Dima", "Kozlov", "Sidorov"};

        list.removeLast();
        list.removeLast();
        list.removeLast();

        String[] actual = new String[list.size()];
        actual = list.toArray(actual);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeFirstAndLast() {
        String[] expected = {"Sidorov", "212"};
        list.removeFirst();
        list.removeLast();
        list.removeLast();
        list.removeFirst();
        String[] actual = new String[list.size()];
        actual = list.toArray(actual);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void add() throws Exception {
        Object[] expected = {"q", 1, null};
        Linked list = new LinkedList();
        list.add("q");
        list.addLast(1);
        list.addLast(null);
        Object[] actual = new Object[list.size()];
        actual = list.toArray(actual);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void get() throws Exception {
        String[] expected = {null, "Kozlov", "Dima", "Kozlov"};
        String[] actual = new String[4];
        actual[0] = list.get(4);
        actual[1] = list.get(1);
        actual[2] = list.get(0);
        actual[3] = list.get(1);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void remove() throws Exception {
        String[] expected = {"Dima", "Sidorov", null};
        list.remove(5);
        list.remove(1);
        list.remove(2);
        String[] actual = new String[list.size()];
        actual = list.toArray(actual);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void remove1() throws Exception {
        String[] expected = {"Dima", "Sidorov", null};
        list.remove("Kozlov");
        list.remove("212");
        list.remove("-04fiac398");
        String[] actual = new String[list.size()];
        actual = list.toArray(actual);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(6, list.size());
    }

    @Test
    public void update() throws Exception {
        String[] expected = {"Dima", "4", "10", "212", null, "rrrr"};
        list.update(1, "4");
        list.update(2, "10");
        list.update(5, "rrrr");
        String[] actual = new String[list.size()];
        actual = list.toArray(actual);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void contains() throws Exception {
        Assert.assertTrue(list.contains("Sidorov"));
    }

    @Test
    public void isEmpty() throws Exception {
        Linked list = new LinkedList();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void isEmpty1() throws Exception {
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void toArray() throws Exception {
        String[] expected = {"Dima", "Kozlov", "Sidorov", "212", null, "-04fiac398"};
        String[] actual = new String[list.size()];
        actual = list.toArray(actual);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void equals() throws Exception {
        Linked<String> list1 = new LinkedList<>();
        list1 = new LinkedList<>();
        list1.add("Dima");
        list1.add("Kozlov");
        list1.add("Sidorov");
        list1.add("212");
        list1.add(null);
        list1.add("-04fiac398");
        Assert.assertTrue(list.equals(list1));
    }
}
