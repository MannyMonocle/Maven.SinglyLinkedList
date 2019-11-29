package com.zipcodewilmington.singlylinkedlist;

import java.awt.*;
import java.util.List;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<D> {

    //State
    private Node<D> zeroIndexNode;
    private final IdGenerator id = new IdGenerator();
    private Integer size = 0;
    private Node<D> endNode = getNode(size - 1);

    //Constructor
    public SinglyLinkedList() {
        zeroIndexNode = null;
    }

    //SinglyLinkedList Class Methods
    public void add(D newElement){
        Node<D> addedNode = (size > 0) ? new Node(this.endNode, newElement) : makeZeroIndexNode(newElement);
        size++;
    }

    public Node makeZeroIndexNode(D element){
        Node<D> zeroNode = new Node(0, element);
        zeroIndexNode = zeroNode;
        endNode = zeroNode;
        return zeroNode;
}

    public Node getNode(Integer index){
        Node<D> nodeToCheck = zeroIndexNode;

        for(int i = 0; i < size; i++) {
            if (nodeToCheck.getIndex() == index) {
                return nodeToCheck;
            } else {
                nodeToCheck = nodeToCheck.getNextNode();
            }
        }
        return null;
    }

    public D get(Integer index){
        Node<D> from = getNode(index);
        return (from == null) ? null : from.getValue();
    }






    //Private Class UniqueId
    private class IdGenerator{
        private Integer lastIdUsed;

        //Constructor
        private IdGenerator(){
            lastIdUsed = -1;
        }

        //Methods
        public Integer current(){ return lastIdUsed; }

        public Integer next(){
            lastIdUsed++;
            return lastIdUsed;
        }
    }

    //Private Class Node
    private class Node<D> {
        private Node<D> prevNode;
        private Node<D> nextNode;
        private Integer index;
        private Integer uniqueId;
        private D value;

        //Node Constructors
        public Node(Integer index, D element) {
            prevNode = SinglyLinkedList.this.getNode(index - 1);
            nextNode = SinglyLinkedList.this.getNode(index + 1);
            this.index = index;
            uniqueId = id.next();
            value = element;
        }

        public Node(Node<D> prevNode, D element){
            this.prevNode = prevNode;
            index = prevNode.getIndex() + 1;
            this.nextNode = prevNode.getNextNode();
            incrementAllIndecesAfter(this);
            uniqueId = id.next();
            value = element;
            prevNode.setNextNode(this);
        }

        //Node Methods
        public void incrementAllIndecesAfter(Node<D> current){
            if(current.getNextNode() != null){
                Node node = current.nextNode;
                Integer nodeIndex = node.getIndex();
                node.setIndex(nodeIndex + 1);
                incrementAllIndecesAfter(node);
            }
        }


        //Node Getters and Setters
        public Node<D> getPrevNode() {
            return prevNode;
        }

        public void setPrevNode(Node prevNode) {
            this.prevNode = prevNode;
        }

        public Node<D> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Integer getIndex() { return index; }

        public void setIndex(Integer index) { this.index = index; }

        public Integer getUniqueId() { return uniqueId; }

        public D getValue() { return this.value; }

        public void setValue(D newValue) { this.value = newValue; }
    }

}
