package DataStructure.LinkedList;

//import sun.security.util.DerValue;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LinkedList {

    Node head; // head of list


    static class Node {

        int data;
        Node next;

        // Constructor
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    // Method to insert a new node
    public static LinkedList insert(LinkedList list, int data)
    {
        // Create a new node with given data
        Node new_node = new Node(data);



        if (list.head == null) {
            list.head = new_node;
        }
        else {

            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_node at last node
            last.next = new_node;
        }

        // Return the list by head
        return list;
    }

    // Method to print the LinkedList.
    public static void printList(LinkedList list)
    {
        Node currNode = list.head;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");

            // Go to next node
            currNode = currNode.next;
        }
    }


    public static LinkedList deleteByKey(LinkedList list, int key)
    {
        // Store head node
        Node currNode = list.head, prev = null;

        if (currNode != null && currNode.data == key) {
            list.head = currNode.next; // Changed head

            // Display the message
            System.out.println(key + " found and deleted");

            // Return the updated List
            return list;
        }

        while (currNode != null && currNode.data != key) {

            prev = currNode;
            currNode = currNode.next;
        }


        if (currNode != null) {

            prev.next = currNode.next;

            // Display the message
            System.out.println(key + " found and deleted");
        }


        if (currNode == null) {
            // Display the message
            System.out.println(key + " not found");
        }
        // return the List
        return list;
    }

    // Driver code
    public static void main(String[] args)
    {
        /* Start with the empty list. */
        LinkedList list = new LinkedList();

        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);

        // Print the LinkedList
        printList(list);

        deleteByKey(list, 1);

        // Print the LinkedList
        printList(list);

        deleteByKey(list, 4);

        // Print the LinkedList
        printList(list);

        deleteByKey(list, 10);

        // Print the LinkedList
        printList(list);

    }
}
