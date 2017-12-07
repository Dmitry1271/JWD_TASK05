package by.tc.owndatastructures.util.tree.impl;

import by.tc.owndatastructures.util.tree.Tree;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cplus on 07.12.2017.
 */
public class BinaryTreeTest {
    Tree<Integer> tree;

    @Before
    public void init() {
        tree = new BinaryTree<>();
        tree.add(54);
        tree.add(24);
        tree.add(5);
        tree.add(12);
        tree.add(8);
        tree.add(85);
        tree.add(15);
        tree.add(90);
        tree.add(78);
        tree.add(68);
        tree.add(34);
        tree.add(80);
    }

    @After
    public void destroy() {
        tree = null;
    }

    @Test
    public void add() throws Exception {
        List<String> expected = new ArrayList<>();
        expected.add("j");
        expected.add("e");
        expected.add("a");
        expected.add("f");
        expected.add("x");
        expected.add("s");
        expected.add("y");

        BinaryTree<String> tree = new BinaryTree<>();
        tree.add("j");
        tree.add("e");
        tree.add("a");
        tree.add("f");
        tree.add("x");
        tree.add("y");
        tree.add("s");
        List<String> actual = tree.preOrder();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void remove() throws Exception {
        List<Integer> expected = new ArrayList<>();
        expected.add(85);
        expected.add(34);
        expected.add(12);
        expected.add(8);
        expected.add(15);
        expected.add(90);

        tree.remove(54);
        tree.remove(80);
        tree.remove(24);
        tree.remove(78);
        tree.remove(68);
        tree.remove(5);

        List<Integer> actual = tree.preOrder();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void search() throws Exception {
        Assert.assertTrue(tree.search(78));
    }

    @Test
    public void search1() throws Exception {
        Assert.assertFalse(tree.search(32));
    }

    @Test
    public void preOrder() throws Exception {
        Assert.assertArrayEquals(new Object[]{54, 24, 5, 12, 8, 15, 34, 85, 78, 68, 80, 90}, tree.preOrder().toArray());
    }

    @Test
    public void inOrder() throws Exception {
        Assert.assertArrayEquals(new Object[]{5, 8, 12, 15, 24, 34, 54, 68, 78, 80, 85, 90}, tree.inOrder().toArray());
    }

    @Test
    public void postOrder() throws Exception {
        Assert.assertArrayEquals(new Object[]{8, 15, 12, 5, 34, 24, 68, 80, 78, 90, 85, 54}, tree.postOrder().toArray());
    }

    @Test
    public void equals() throws Exception {
        Tree<Integer> tree1 = new BinaryTree<>();
        tree1.add(54);
        tree1.add(24);
        tree1.add(5);
        tree1.add(12);
        tree1.add(8);
        tree1.add(85);
        tree1.add(15);
        tree1.add(90);
        tree1.add(78);
        tree1.add(68);
        tree1.add(34);
        tree1.add(80);

        Assert.assertTrue(tree.equals(tree1));
    }

}
