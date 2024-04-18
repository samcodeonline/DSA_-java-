public class Stack {
    public static class stack_str {
    int[] nodeValue = new int[5];
    stack_str nextNodeReferencePointer;

        public stack_str(int nodeValue[]) {
            this.nodeValue = nodeValue;
            this.nextNodeReferencePointer = null;
        }
    }
}
