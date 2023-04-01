import java.util.LinkedList;
/////////////////////////////////////////////////////////////
/*
* LinkedList = stores Nodes in 2 parts (data + address)
*              Nodes are in non-consecutive memory locations
*              Elements are linked using pointers
*
*                        Singly Linked List
*            Node               Node                Node
*       [data | address] -> [data | address] -> [data | address]
*
*                        Doubly Linked List
*                  Node                           Node
*       [address | data | address] <-> [address | data | address]
*
*
*       Advantages:
*         1. Dynamic Data Structure (allocates needed memory while running)
*         2. Insertion and Deletion of Nodes is easy. (O1)
*         3. No/Low memory waste
*
*       Disadvantages:
*         1. Greater memory usage (additional pointer)
*         2. No random access of elements (no index [i])
*         3. Accessing/searching elements is more time-consuming O(n)
*
*       Uses:
*         1. Implement Stacks/Queues
*         2. GPS navigation
*         3. Music playlists
* */
/////////////////////////////////////////////////////////////


public class WhatAreThey {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<String>();

//Stack
//        ll.push("A");
//        ll.push("B");
//        ll.push("C");
//        ll.push("D");
//        ll.push("E");
//        ll.push("F");
//        ll.pop();
//

// Queue
        ll.offer("A");
        ll.offer("B");
        ll.offer("C");
        ll.offer("D");
        ll.offer("F");
//        ll.poll();

        ll.add(4, "E");
        ll.remove("F");

        System.out.println(ll.indexOf("E"));

        System.out.println(ll.peekFirst());
        System.out.println(ll.peekLast());
        ll.addFirst("0");
        ll.addLast("F");

        String first = ll.removeFirst();
        String last = ll.removeLast();
        System.out.println(ll);
        System.out.println(first);
        System.out.println(last);
    }

}
