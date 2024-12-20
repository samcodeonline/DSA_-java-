package DataStructure.Civo;

public class LL {

    private Node head;
    private Node tail;
    private int size;

    Stacks myStack = new Stacks();
//    LL myList = new LL();
    public LL(){
        this.size = 0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }
        size += 1;
    }

    public int insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return val;
        }
        Node node = new Node(val);
        tail.next = node ;
        tail = node;
        size ++;
        return val;
    }

    public void insert(int val , int index){
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
            return;
        }

        Node temp = head;
        for(int i = 1 ; i < index ; i++){
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return val;
    }

//    this is used to find the element in the linklist at any node.

//    public Node find(int value){
//        Node node = head;
//        while(node != null){
//            if(node.value == value){
//                return node;
//            }
//            node = node.next;
//        }
//        return node;
//    }

    public Node get(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int deleteLast(){
        if(size <= 1){
            return deleteFirst();
        }

        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        return val;
    }

    public int delete(int index){
        if(index == 0){
            return deleteFirst();
        }

        if(index == size - 1){
            return deleteLast();
        }


        Node prev = get(index - 1);

        int val = prev.next.value;

        prev.next = prev.next.next;

        myStack.push(val);

        return val;

    }

    public int undoDelete(){

        if(myStack.isEmpty()){
            System.out.println("nothing to undo");
            return 0;
        }
        System.out.println("UNDO Completed");
        int value = myStack.pop();
//        System.out.println(value);
        return value;
    }

    public void garbageBin(){
        if(myStack.isEmpty()){
            System.out.println("Nothing in the stack.");
        }
//        if(!myStack.isEmpty()){
            System.out.print("Inside Garbage Bin : ");
            System.out.print(myStack.size());
//        }
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}