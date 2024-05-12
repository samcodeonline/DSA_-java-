package DataStructure.LinkedListPractise;


import java.util.Scanner;

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
    // Method to print the LinkedList.
    //    it is the method to insert the list
    public static LinkedList insert(LinkedList list, int data)
    {
        // Create a new node with given data

                /*
                we defined (new_node) a reference of type Node, which is going to
                make object holding the data in it.
                   */
        Node new_node = new Node(data);

                /*
                in this case the linklist is empty and there is nothing in it.
                so we would pass the data that we are willing to insert in the
                new_node object that we have created

                */
        if (list.head == null) {
            list.head = new_node;
        }
        else {
                /*
                in this case the linklist is carrying the elements in it. and in order to
                find the null value we need to take the assistance of while loop
                which would help us to iterate the referece until it would not reach the end o
                of the list and as

                */
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

                /*
                And as it would find null item in the list , it would replace the value
                of it with the newly created object (new_node)

                */
            // Insert the new_node at last node
            last.next = new_node;
        }

                 /*
                in the end it is going to return us the list that we would finally have
                width the new item
                */
        // Return the list by head
        return list;
    }
    public static void printList(LinkedList list)
    {
                /*
                In this line of code we are creating an object (currNode),
                which is pointing to the head of the linklist
                */
        Node currNode = list.head;

        System.out.print("LinkedList: ");


                 /*
                   In these lines of code we are trying to print the data
                   using the object created at start. if the object is not null it
                   would print the data out until the condition is not
                   going to get false.
                */

        // Traverse through the LinkedList
        while (currNode != null) {
                /*
                    It would print the first node and after that , it would check the condition and
                    then print the other ones until it would not reach the null reference.
                */
            // Print the data at current node
            System.out.print(currNode.data + " ");

                /*
                     It would tell the reference variable to be at the next node and
                     then at the next iteration to the next one.

                */
            // Go to next node
            currNode = currNode.next;
        }
    }
    public static  LinkedList deleteByKey( LinkedList list, int key)
    {
                /*
                    In this line of code we are taking two objects (currNode, prev)
                    currNode object is pointing towards head and prev is pointing to the default
                    value(null)
                */

        // Store head node
        Node currNode = list.head, prev = null;


                /*
                    In this if statement we are taking two conditions currNode (notEqualto) null and then
                    currNode.data == key if they are going to match the condition
                    then the condition would get true (if you are getting confused check the
                    contructors out there. the constructor is having a value which is the data)
                */
        if (currNode != null && currNode.data == key) {

                /*
                    It would make the head to the currNode.next as it would move on to the
                    next elements and place itself at the position at which to be placed.
                */
            list.head = currNode.next; // Changed head

            // Display the message
            System.out.println(key + " found and deleted");
                /*
                    It would print the updated list after the deletion of the element from the list.
                */
            // Return the updated List
            return list;
        }

                /*
                    This while loop is checking the key provided and then moving on to the
                    list and then finding out the key where is it , it would keep getting
                    implementing itself until the condition would not get match.
                */

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

//    static int menuOptions() {
//        System.out.println("Task to perform: ");
//        System.out.println("1. Delete ");
//        System.out.println("2. Undo ");
//        Scanner number = new Scanner(System.in);
//        int num;
//        num = number.nextInt();
//        if(num == 1){
//            // Method to insert a new node
//            //public static LinkedList insert(LinkedList list, int data);
//            //insert(LinkedList list, int data);
//            System.out.println("Delete it");
//        }
//        if(num == 2){
//            System.out.println("Undo it");
//        }
//        return 0;
//    }
    public static void main(String[] args) {
//        menuOptions();
        Scanner newScanner = new Scanner(System.in);
        System.out.println("1. Insertion");
        System.out.println("2. Deletion");
        System.out.println("3. Print list");
        int number ;
        System.out.print("Select the item here: ");
        number = newScanner.nextInt();
        switch (number){
            case 1:
                System.out.println("Let's insert the item");
//                execute the code here
                break;
            case 2:
                System.out.println("Let's delete the item");
//                execute the code here
                break;
            default:
                System.out.println("There is nothing to do");
        }
    }
}
