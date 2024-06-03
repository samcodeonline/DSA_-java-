package DataStructure.OptimizedCode_DSA;

import java.util.Scanner;

public class Main {
    public static void menu() {
        System.out.println();
        System.out.println("1. Insert At Head ");
        System.out.println("2. Display");
        System.out.println("3. Insert At Tail ");
        System.out.println("4. End Program ");
        System.out.println("5. Insert At Any Position ");
        System.out.println("6. Delete the Item ");
        System.out.println("7. Undo Last Item Deleted ");
        System.out.println("8. Garbage Bin");
    }

    public static void main(String[] args) {
        LL newList = new LL();
        try (Scanner newScanner = new Scanner(System.in)) {
            while (true) {
                menu();
                System.out.print("Choose the option: ");
                int choice = newScanner.nextInt();
                switch (choice) {
                    case 1:
                        handleInsert(newList, newScanner, true);
                        break;
                    case 2:
                        newList.display();
                        break;
                    case 3:
                        handleInsert(newList, newScanner, false);
                        break;
                    case 4:
                        return;
                    case 5:
                        handleInsertAtPosition(newList, newScanner);
                        break;
                    case 6:
                        handleDelete(newList, newScanner);
                        break;
                    case 7:
                        handleUndoDelete(newList);
                        break;
                    case 8:
                        newList.garbageBin();
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }

    private static void handleInsert(LL newList, Scanner scanner, boolean atHead) {
        System.out.print("Count: ");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.print("Enter value: ");
            int value = scanner.nextInt();
            try {
                if (atHead) {
                    newList.insertFirst(value);
                } else {
                    newList.insertLast(value);
                }
            } catch (Exception e) {
                System.out.println("Error inserting value: " + e.getMessage());
            }
        }
    }

    private static void handleInsertAtPosition(LL newList, Scanner scanner) {
        System.out.print("Count: ");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.print("Enter value: ");
            int value = scanner.nextInt();
            System.out.print("Enter position: ");
            int position = scanner.nextInt();

            try {
                newList.insert(value, position);
            } catch (Exception e) {
                System.out.println("Error inserting value at position: " + e.getMessage());
            }
        }
    }

    private static void handleDelete(LL newList, Scanner scanner) {
        System.out.print("Count: ");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.print("Enter position: ");
            int position = scanner.nextInt();

            try {
                int deletedValue = newList.delete(position);
                System.out.println("Deleted successfully: " + deletedValue);
            } catch (Exception e) {
                System.out.println("Error deleting value: " + e.getMessage());
            }
        }
    }

    private static void handleUndoDelete(LL newList) {
        try {
            int value = newList.undoDelete();
            if (value != 0) {
                newList.insertLast(value);
            }
        } catch (Exception e) {
            System.out.println("Error undoing delete: " + e.getMessage());
        }
    }
}
