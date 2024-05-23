package DataStructure.Civo;

import DataStructure.LinkedListPractise.practiseLinkedList;

import java.io.IOException;
import java.util.Scanner;

public class Main extends LL {
    public static void menu(){
        System.out.println("");
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
        while(true){
//            clearScreen();
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
                        try{
                            newList.insertFirst(num);
                        }catch(Exception e){
                            System.out.println(e.getLocalizedMessage());
                        }

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
                        try{
                            newList.insertLast(num);
                        }catch(Exception e){
                            System.out.println(e.getLocalizedMessage());
                        }
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
                        try{
                            newList.insert(num,position);
                        }catch(Exception e){
                            System.out.println(e.getLocalizedMessage());
                        }
                    }
                    break;
                case 6:
                    System.out.print("Count: ");
                    int deletion;
                    deletion = newScanner.nextInt();
                    for(int i = 0 ; i < deletion; i++) {
                        int position;
                        System.out.print("Position: ");
                        position = newScanner.nextInt();
                        try{
                            System.out.println("Deleted SuccessFully");
                            newList.delete(position);
                        }catch(Exception e){
                            System.out.println(e.getLocalizedMessage());
                        }
                    }
                    break;
                case 7:
                    try{
                        newList.insertLast(newList.undoDelete());
                    }catch (Exception e){
                        System.out.println(e.getLocalizedMessage());
                    }
                    break;
                case 8:
                    try{
                        newList.garbageBin();
                    }catch (Exception e){
                        System.out.println(e.getLocalizedMessage());
                    }
                    break;
                default:
                    System.out.println("nothing to find here");
            }
        }
    }
}
