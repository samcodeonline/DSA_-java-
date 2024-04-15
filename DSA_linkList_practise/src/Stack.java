public class Stack {
//    as the element would be pushed the element would go to the place of the array or array list and then
//    the stack would be underflow.
    public static class stack_str {
    int[] nodeValue = new int[5];
    stack_str nextNodeReferencePointer;

        public stack_str(int nodeValue[]) {
            this.nodeValue = nodeValue;
            this.nextNodeReferencePointer = null;
        }
    }
}
