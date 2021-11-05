
public class FindMiddle {

    public static class DLLNode {
        DLLNode prev;
        int data;
        DLLNode next;

        public DLLNode(int data) {
            this.data = data;
        }
    }

    public static class Stack {

        static int count = 0;
        static DLLNode middle;
        static DLLNode top;
        static DLLNode head;

        public Stack(int data) {
            top = new DLLNode(data);
            head = top;
            middle = top;
            count = 1;
        }

        public DLLNode push(int data) {
            DLLNode node = new DLLNode(data);
            node.prev = top;
            top.next = node;
            top = node;
            count++;
            if (count % 2 == 0) {
                middle = middle.next;
            }
            return node;
        }

        public DLLNode pop() {
            DLLNode prev = top.prev;
            prev.next = null;
            top = prev;
            count--;
            if (count % 2 != 0) {
                middle = middle.prev;
            }
            return top;
        }

        public void deleteMiddle() {
            DLLNode tempNext = middle.next;
            DLLNode tempPrev = middle.prev;
            middle.prev.next = middle.next;
            middle.next.prev = middle.prev;
            count--;
            if (count % 2 == 0) {
                middle = tempNext;
            } else {
                middle = tempPrev;
            }
        }

        public void printTop() {
            System.out.println(top.data);
        }

        public void findMiddle() {
            System.out.println(middle.data);
        }

        public void printStack() {
            DLLNode pointer = head;
            while (pointer != null) {
                System.out.print(pointer.data + "   ");
                pointer = pointer.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.printStack();
        stack.findMiddle();
        stack.push(10);
        stack.printStack();
        stack.findMiddle();
        stack.push(11);

        stack.printStack();
        stack.findMiddle();

        stack.deleteMiddle();
        stack.printStack();
        stack.findMiddle();

        stack.deleteMiddle();
        stack.printStack();
        stack.findMiddle();

        stack.deleteMiddle();
        stack.printStack();
        stack.findMiddle();

        stack.deleteMiddle();
        stack.printStack();
        stack.findMiddle();

        stack.push(12);

        stack.printStack();
        stack.findMiddle();

        stack.push(13);

        stack.printStack();
        stack.findMiddle();

        stack.pop();
        stack.printStack();
        stack.findMiddle();

        stack.pop();
        stack.printStack();
        stack.findMiddle();

        stack.push(14);

        stack.printStack();
        stack.findMiddle();

        stack.push(15);

        stack.printStack();
        stack.findMiddle();

    }
}