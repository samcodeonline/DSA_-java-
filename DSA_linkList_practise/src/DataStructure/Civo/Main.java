package DataStructure.Civo;

import DataStructure.LinkedListPractise.practiseLinkedList;

import java.util.Scanner;
import java.util.Stack;



public class Main {
    public static void menu(){
        System.out.println("");
        System.out.println("1. Insert At First Position ");
        System.out.println("2. Display List ");
        System.out.println("3. Insert At last Position ");
        System.out.println("4. End Program ");
        System.out.println("5. Insert At Any Position ");
        System.out.println("6. Delete the Item ");
        System.out.println("7. Undo Last Item ");
    }
    public static void main(String[] args) {
// Stack to keep track of deletions
//        Stack<DeletedNode> undoStack = new Stack<>();
        LL newList = new LL();
        while(true){
            menu();
            System.out.println("");
            System.out.print("Choose the options: ");
            Scanner newScanner = new Scanner(System.in);
            int choose;
            choose = newScanner.nextInt();
            switch (choose){
                case 1:
                    System.out.print("Count: ");
                    int insertion;
                    insertion = newScanner.nextInt();
                    for(int i = 0 ; i < insertion; i++){
                        int num;
                        num = newScanner.nextInt();
                        newList.insertFirst(num);
                    }
                    break;
                case 2:
                    newList.display();
                    break;

                case 3:
                    System.out.print("Count: ");
                    int insertLast;
                    insertLast = newScanner.nextInt();
                    for(int i = 0 ; i < insertLast; i++){
                        int num;
                        num = newScanner.nextInt();
                        newList.insertFirst(num);
                    }
                    break;
                case 4:
                    return;
                case 5:
                    System.out.print("Count: ");
                    int insertRandomly;
                    insertRandomly = newScanner.nextInt();
                    for(int i = 0 ; i < insertRandomly; i++){
                        int num,position;
                        System.out.print("Data: ");
                        num = newScanner.nextInt();
                        System.out.print("Position: ");
                        position = newScanner.nextInt();
                        newList.insert(num,position);
                    }
                    break;
                case 6:
                    System.out.print("Count: ");
                    int deleteRandomly;
                    deleteRandomly = newScanner.nextInt();
                    for(int i = 0 ; i < deleteRandomly; i++) {
                        int position;
                        System.out.print("Position: ");
                        position = newScanner.nextInt();
                        newList.delete(position);
                    }
                    break;
                default:
                    System.out.println("nothing to find here");
            }
        }
    }
}
