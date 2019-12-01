package com.zipcodewilmington.singlylinkedlist;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Test
    public void addTest(){
        SinglyLinkedList list = new SinglyLinkedList();
        String expected = "pass";
        list.add(expected);
        String actual = (String) list.get(0);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void add2Test(){
        SinglyLinkedList list = new SinglyLinkedList();
        String expected = "pass";
        list.add("wrong");
        list.add(expected);
        String actual = (String) list.get(1);
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void removeTest(){
        SinglyLinkedList list = new SinglyLinkedList();
        Integer[] numbers = {0,1,9,2,3,4,5};
        for(Integer num : numbers){ list.add(num); }
        list.remove(2);
        Integer actual = (Integer) list.get(4);
        Assert.assertEquals(4,actual,0.001);


    }

}
