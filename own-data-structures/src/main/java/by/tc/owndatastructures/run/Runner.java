package by.tc.owndatastructures.run;

import by.tc.owndatastructures.exception.IndexOutListSizeException;
import by.tc.owndatastructures.util.list.Iterator;
import by.tc.owndatastructures.util.list.Linked;
import by.tc.owndatastructures.util.list.Simple;
import by.tc.owndatastructures.util.list.impl.LinkedList;
import by.tc.owndatastructures.util.list.impl.SimpleList;
import by.tc.owndatastructures.util.tree.impl.BinaryTree;


/**
 * Created by cplus on 25.11.2017.
 */
public class Runner {
    public static void main(String[] args) throws IndexOutListSizeException {
        /*SimpleList list = new SimpleList(2);
        System.out.println(list.isEmpty());
        list.add(5);
        list.add("afs");
        list.add("casfaew");
        list.add(43.2);
        list.add(4214424L);
        list.add(23);
        list.add(5);
        list.add("afs");
        list.add("casfa");
        list.add(43.2);
        list.add(42144249L);
        list.add(23);
        list.remove(11);
        list.remove(0);
        list.remove(5);
        System.out.println(list.size());
        Iterator iter = list.getIterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println(list);
        System.out.println(list.contains("casfra"));
        System.out.println(list.contains(42144249L));
        list.update(0, 123);
        list.update(3, 9999);
        System.out.println(list);
        System.out.println(list.isEmpty());
        iter = list.getIterator();
        while (iter.hasNext()) {
            list.remove(0);
        }
        System.out.println(list);
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        list.add(43);
        list.add(null);
        SimpleList list1 = new SimpleList();
        list1.add(43);
        list1.add(null);
        list1.add("null");
        list.add("null");
        for (int i = 0; i < 3; ++i) {
            list.add(i + 0.3);
            list1.add(i + 0.3);
        }
        list.remove(3);
        list1.remove(3);
        list.update(0,"qwertyuiop");
        list1.update(0,"qwertyuiop");
        System.out.println(list1);
        System.out.println(list);
        System.out.println(list.equals(list1));
        System.out.println(list.get(1));
        System.out.println(list1.get(1));
        System.out.println(list.get(4));
        System.out.println(list1.get(3));
        for(int i = 0; i<1000; ++i){
            list.add(i);
            System.out.println(list.get(list.size()-1));
        }*/


        /*List<Object> list = new LinkedList<>();
        list.add("sad");
        list.add("q");
        list.add(1);
        list.add(2);
        System.out.println(list.get(0));
        LinkedList<Object> list1 = new LinkedList<>();
        list1.addFirst("sad");
        list1.addFirst("q");
        list1.addFirst(1);
        list1.addFirst(2);

        LinkedList<Object> list2 = new LinkedList<>();
        list2.addLast("sad");
        list2.addLast("q");
        list2.addLast(1);
        list2.addLast(2);
        System.out.println(list);
        System.out.println(list1);
        System.out.println(list2);*/

       /* Linked list = new LinkedList();

        //System.out.println(list.isEmpty());
        //System.out.println(list.size());
        list.addFirst("qwer");
        list.addLast(1);
        list.addFirst("csd");
        list.addLast(3);
        list.addFirst("fsd");
        list.addFirst("fsd1");
        list.addFirst(null);*/

       /* System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());*/
        /*System.out.println(list);

        Linked linked = new LinkedList();
        linked.addFirst(3);
        linked.addFirst(1);
        linked.addFirst("qwer");
        linked.addFirst("csd");
        linked.addFirst("fsd");
        linked.addFirst("fsd1");
        linked.addFirst(null);
        linked.addLast(45893);

        Iterator iter = linked.getIterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println(iter.hasNext());*/

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(4);
        binaryTree.add(5);
        binaryTree.add(6);
        binaryTree.add(7);
        binaryTree.add(8);
        binaryTree.add(9);
        binaryTree.add(null);
        binaryTree.add(11);
        binaryTree.add(12);
        binaryTree.add(13);
        binaryTree.add(14);
        binaryTree.add(15);
        binaryTree.add(16);
        System.out.println(binaryTree.preOrder());
        System.out.println(binaryTree.postOrder());
        System.out.println(binaryTree.inOrder());
        System.out.println(binaryTree.contains(null));

    }
}
