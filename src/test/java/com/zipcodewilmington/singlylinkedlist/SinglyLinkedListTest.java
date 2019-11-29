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

}
