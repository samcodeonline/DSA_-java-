package DataStructure.OptimizedCode_DSA;

import java.util.EmptyStackException;

import java.util.EmptyStackException;

public class Stacks {
    private Node top;
    private int size;

    private class Node {
        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(int data) {
        Node temp = new Node(data);
        temp.next = top;
        top = temp;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        int result = top.data;
        top = top.next;
        size--;
        return result;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return top.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void displayStack() {
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
