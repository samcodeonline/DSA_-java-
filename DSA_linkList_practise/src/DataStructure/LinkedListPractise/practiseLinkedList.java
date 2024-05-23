package DataStructure.LinkedListPractise;

import java.util.LinkedList;
import java.util.Stack;

public class practiseLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(32);
        linkedList.add(388);
        linkedList.add(129);
        linkedList.add(19);
        linkedList.add(1);

        // Display the initial list
        System.out.println("Initial list: " + linkedList);

        // Stack to keep track of deletions
        Stack<DeletedNode> undoStack = new Stack<>();

        // Delete an element at any index, Just type the index here.
        deleteNode(linkedList, 3, undoStack);

        // Display the list after deletion
        System.out.println("After deletion: " + linkedList);

        // Perform an undo operation
        undoDelete(linkedList, undoStack);

        // Display the list after undo operation
        System.out.println("After undo operation: " + linkedList);
    }

    // Method to delete a node and store the deletion in the stack
    public static void deleteNode(LinkedList<Integer> list, int index, Stack<DeletedNode> stack) {
        if (index < 0 || index >= list.size()) {
            System.out.println("Index out of bounds");
            return;
        }
        int deletedValue = list.remove(index);
        stack.push(new DeletedNode(deletedValue, index));
    }

    // Method to undo the last deletion
    public static void undoDelete(LinkedList<Integer> list, Stack<DeletedNode> stack) {
        if (stack.isEmpty()) {
            System.out.println("Nothing to undo");
            return;
        }
        DeletedNode node = stack.pop();
        list.add(node.index, node.value);
    }

    // Helper class to store the deleted node information
    public static class DeletedNode {
        int value;
        int index;

        DeletedNode(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}