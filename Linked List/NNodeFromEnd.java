public class NNodeFromEnd {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        System.out.println(findNode(head, 3).val);

    }

    public static class Node {
        int val;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }

    public static int counter = 0;

    public static Node findNode(Node head, int n) {
        Node node = null;
        // traverse till last node
        if (head.next != null) {
            node = findNode(head.next, n);
        }
        // then start increasing counter
        counter++;
        // when counter==n keep returning node until call stack is empty
        if (counter == n) {
            node = head;
        }

        return node;
    }
}