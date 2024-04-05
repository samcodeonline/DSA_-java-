
public class linkedList {
    public static Main.Node head; // head node holds the list

    public static class Node {
        int nodeValue;
        Main.Node nextNodeReferencePointer;

        public Node(int nodeValue) {
            this.nodeValue = nodeValue;
            this.nextNodeReferencePointer = null;
        }

        public static int length(Main.Node head) {
            // if the linkedList is empty
            if (head == null)
                return 0;
            int count = 0;
            Main.Node currentPointer = head;
            while (currentPointer != null) {
                count++;
                currentPointer = currentPointer.nextNodeReferencePointer;
            }
            return count;
        }

        public static Main.Node insertAtPosition(Main.Node head, int nodeValue, int position) {
            int size = length(head);
            // check boundary conditions
            if (position > size + 1 || position < 1) {
                System.out.println("Invalid position");
                return head;
            }
            Main.Node newNode = new Main.Node(nodeValue);
            if (position == 1) {
                newNode.nextNodeReferencePointer = head;
                return newNode;
            } else {
                Main.Node previousPointer = head;
                int count = 1;
                while (count < position - 1) {
                    previousPointer = previousPointer.nextNodeReferencePointer;
                    count++;
                }
                Main.Node currentPointer = previousPointer.nextNodeReferencePointer;
                newNode.nextNodeReferencePointer = currentPointer;
                previousPointer.nextNodeReferencePointer = newNode;
            }
            return head;
        }
        public static void display(Main.Node head) {
            if(head == null)
                return;
            Main.Node currentPointer = head;
            while(currentPointer != null) {
                System.out.print(currentPointer.nodeValue+" ");
                currentPointer = currentPointer.nextNodeReferencePointer;
            }
            System.out.println();
        }
        public static void main(String[] args) {
            head = new Main.Node(1);
            // insert at a position
            System.out.println("Insert at position 1");
            head = insertAtPosition(head,7,1);
            display(head);
        }
    }



}
