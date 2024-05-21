package DataStructure.Civo;

import static java.lang.System.exit;

class Stack extends LL {
    Node top;

    public Stack() {
        this.top = null;
    }

    public void push(int x){
        Node temp = new Node();

        if(temp == null){
            System.out.println("\n OverFlow");
            return;
        }

        temp.value = x;
        temp.next = top;
        top = temp;
    }

    public boolean isEmpty(){ return top == null; }

    public void pop()
    {
        if(top == null){
            System.out.println("\nStackUnderFlow");
            return;
        }
        top = (top).next;
    }


    public void display() {
        if(top == null){
            System.out.println("\nStack UnderFlow");
            exit(1);
        }
        else{
            Node temp = top;
            while (temp != null){
                System.out.printf("%d->" , temp.value);

                temp = temp.next;
            }
        }
    }
}


public class StackImplement{
    public static void main(String[] args) {
        Stack stackFunc = new Stack();
        stackFunc.push(3);
        stackFunc.push(5);
        stackFunc.push(7);
        stackFunc.push(4);
        stackFunc.push(14);
        stackFunc.push(42);
        stackFunc.push(45);
        stackFunc.push(432);

        stackFunc.display();

        System.out.println("");
        System.out.println("After 2 pops");

        stackFunc.pop();
        stackFunc.pop();

        stackFunc.display();
        System.out.println("");
        System.out.println("UNDO");

        stackFunc.display();
    }
}