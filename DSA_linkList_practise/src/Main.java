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
                Node previousPointer = head;
                int count = 1;
                while(count < position - 1) {
                    previousPointer = previousPointer.nextNodeReferencePointer;
                    count++;
                }
                Node currentPointer = previousPointer.nextNodeReferencePointer;
                newNode.nextNodeReferencePointer = currentPointer;
                previousPointer.nextNodeReferencePointer = newNode;
            }
            return head;
        }

        public static Node deleteAtPosition(Node head, int nodeValue, int position){
            int size = length(head);
            // check boundary conditions
            if(position > size+1 || position<1) {
                System.out.println("Invalid position");
                return head;
            }
            Node newNode = new Node(nodeValue);
            if(position == 1) {
                newNode.nextNodeReferencePointer = null;
                newNode = head;
                return newNode;
            }

            else {
                Node previousPointer = null;
                int count = 1;
                while(count < position - 1) {
                    previousPointer = null;
                    count++;
                }
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
            display(head);
            // insert from end
            System.out.println("Inserting from end");
            head = insertAtEnd(head,5);
            head = insertAtEnd(head,6);
            display(head);
            // insert at a position
            System.out.println("Insert at position 3");
            head = insertAtPosition(head,7,3);
            display(head);
            System.out.println("Delete at position 1");
            head = deleteAtPosition(head,4,1);
            display(head);
            // length of the linked list
            int l = length(head);
            System.out.println("Length of the Linked List: " +l);
        }
    }
}
