package DataStructure.OptimizedCode_DSA;

public class LL {
    private Node head;
    private Node tail;
    private int size;
    private final Stacks myStack;

    public LL() {
        this.size = 0;
        this.myStack = new Stacks();
    }

    private class Node {
        private int value;
        private Node next;

        private Node(int value) {
            this.value = value;
        }

        private Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    public int deleteFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        myStack.push(val); // Store deleted value in stack
        return val;
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }

        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        myStack.push(val); // Store deleted value in stack
        return val;
    }

    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }

        if (index == size - 1) {
            return deleteLast();
        }

        Node prev = get(index - 1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        size--;
        myStack.push(val); // Store deleted value in stack
        return val;
    }

    public int undoDelete() {
        if (myStack.isEmpty()) {
            System.out.println("Nothing to undo");
            return 0;
        }
        System.out.println("UNDO Completed");
        int value = myStack.pop();
        return value;
    }

    public void garbageBin() {
        if (myStack.isEmpty()) {
            System.out.println("Nothing in the stack.");
        } else {
            System.out.print("Inside Garbage Bin: ");
            myStack.displayStack();
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }
}
