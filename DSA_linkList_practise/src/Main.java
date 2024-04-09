public class Main {

    public static Node head; // head node holds the list

    public static class Node {
        int nodeValue;
        Node nextNodeReferencePointer;

        public Node(int nodeValue) {
            this.nodeValue = nodeValue;
            this.nextNodeReferencePointer = null;
        }
        public static int length(Node head) {
            // if the linkedList is empty
            if (head == null)
                return 0;
            int count = 0;
            Node currentPointer = head;
            while (currentPointer != null) {
                count++;
                currentPointer = currentPointer.nextNodeReferencePointer;
            }
            return count;
        }

        public static Node insertAtBegining(Node head,int nodeValue) {
            Node newNode = new Node(nodeValue);
            // if linked list is empty
            if(head == null) {
                return newNode;
            }
            newNode.nextNodeReferencePointer = head;
            head = newNode;
            return newNode;
        }

        public static Node insertAtEnd(Node head,int nodeValue) {
            Node newNode = new Node(nodeValue);

            // empty list
            if(head == null) {
                return newNode;
            }
            Node currentPointer = head;
            while(currentPointer.nextNodeReferencePointer != null ) {
                currentPointer = currentPointer.nextNodeReferencePointer;
            }
            currentPointer.nextNodeReferencePointer = newNode;
            return head;
        }

        public static Node insertAtPosition(Node head,int nodeValue,int position) {
            int size = length(head);
            // check boundary conditions
            if(position > size+1 || position<1) {
                System.out.println("Invalid position");
                return head;
            }
            Node newNode = new Node(nodeValue);
            if(position == 1) {
                newNode.nextNodeReferencePointer = head;
                return newNode;
            } else {
                Node previousNode = head;
                int count = 1;
                while(count < position - 1) {
                    previousNode = previousNode.nextNodeReferencePointer;
                    count++;
                }
                Node currentPointer = previousNode.nextNodeReferencePointer;
                newNode.nextNodeReferencePointer = currentPointer;
                previousNode.nextNodeReferencePointer = newNode;
            }
            return head;
        }

        public static Node deleteAtPosition(Node head, int position) {
            int size = length(head);
            // check boundary conditions
            if (position > size + 1 || position < 1) {
                System.out.println("Invalid position");
                return head;
            }

//            Node deleteNode  = new Node(position);
            if (position == 1) {
                Node firstNode = head;
                Node secondNode = firstNode.nextNodeReferencePointer;
                return secondNode;
            } else {
                int count = 1;
                Node firstNode = head;
                while(count < position - 1) {
                    firstNode = firstNode.nextNodeReferencePointer;
                    count++;
                }
                Node secondNode = firstNode.nextNodeReferencePointer;
                firstNode.nextNodeReferencePointer = secondNode.nextNodeReferencePointer;
                secondNode.nextNodeReferencePointer = null;
            }
            return head;
        }
        public static void display(Node head) {
            if(head == null)
                return;
            Node currentPointer = head;
            while(currentPointer != null) {
                System.out.print(currentPointer.nodeValue+" ");
                currentPointer = currentPointer.nextNodeReferencePointer;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            // create a head node
            head = new Node(1);
            // insert from start
            System.out.println("Inserting from begining");
            head=insertAtBegining(head,2);
            head=insertAtBegining(head,3);
            head=insertAtBegining(head,4);
            head=insertAtBegining(head,7);
            head=insertAtBegining(head,2);


            display(head);
            // insert from end
            System.out.println("Inserting from end");
            head = insertAtEnd(head,5);
            head = insertAtEnd(head,6);
            head = insertAtEnd(head,5);
            head = insertAtEnd(head,1);
            head = insertAtEnd(head,0);

            display(head);
            // insert at a position
            System.out.println("Insert at position 3");
            head = insertAtPosition(head,7,3);
            display(head);
            System.out.println("Delete from position 1");
            head = deleteAtPosition(head,1);
            display(head);
            System.out.println("Delete from position 5");
            head = deleteAtPosition(head,5);
            display(head);
            System.out.println("Delete from position 7");
            head = deleteAtPosition(head,7);
            display(head);
            // length of the linked list
            int l = length(head);
            System.out.println("Length of the Linked List: " +l);
        }
    }
}
