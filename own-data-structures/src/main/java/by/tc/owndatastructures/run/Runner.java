package by.tc.owndatastructures.run;

import by.tc.owndatastructures.exception.IndexOutListSizeException;
import by.tc.owndatastructures.util.Iterator;
import by.tc.owndatastructures.util.Linked;
import by.tc.owndatastructures.util.impl.LinkedList;
import by.tc.owndatastructures.util.impl.SimpleList;


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

        Linked list = new LinkedList();

        //System.out.println(list.isEmpty());
        //System.out.println(list.size());
        list.addFirst("qwer");
        list.addLast(1);
        list.addFirst("csd");
        list.addLast(3);
        list.addFirst("fsd");
        list.addFirst("fsd1");
       // System.out.println(list.size());
        //System.out.println(list.get(0));
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());
        System.out.println(list);
        //System.out.println(list.size());



    }
}
