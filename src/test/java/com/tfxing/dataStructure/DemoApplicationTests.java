package com.tfxing.dataStructure;

import com.tfxing.dataStructure.entity.arrayList.ArrayList;
import com.tfxing.dataStructure.entity.linkedList.LinkedList;
import com.tfxing.dataStructure.entity.rbTree.RBTree;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }
    
    @Test
    void testRBTree() {
        RBTree<Integer> rbTree = new RBTree<>();
        rbTree.add(324);
        rbTree.add(245);
        rbTree.add(643);
        rbTree.add(211);
        rbTree.add(200);
        rbTree.add(192);
        rbTree.add(195);
        rbTree.add(985);
        rbTree.add(728);
        rbTree.add(120);
        rbTree.add(159);
        System.out.println(rbTree);
    }

    @Test
    void testLinkedList() {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.remove(1);
        list.update(2,"e");
        System.out.println(list);

        System.out.println();
        
        System.out.println(list.getSize());
    }
    
    @Test
    void testArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        System.out.println(list.getSize());
        list.remove(1);
        list.remove(4);
        list.remove(7);
        list.remove(10);
        System.out.println(list);
        System.out.println(list.getSize());
    }
    
    @Test
    void testAdd() {
        int i = 0;
        System.out.println(++i);
        
        int j = 0;
        System.out.println(j+=1);
        
        int g = 0;
        System.out.println(g++);
    }
}
