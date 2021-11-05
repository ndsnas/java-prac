public class ReverseLinkedList {

    public static class Node {
        Node next;
        int value;

        Node(int value) {
            this.next = null;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        // printLinkedList(head);
        // Node reversedHead = reverseLinkedList(head);
        // printLinkedList(reversedHead);

        System.out.println(kFromLast(head, 2).value);

    }

    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    public static Node reverseLinkedList(Node head) {
        Node curr = head;
        Node prev = null;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static int counter = 0;

    public static Node kFromLast(Node head, int k) {
        if (head == null)
            return head;
        Node node = kFromLast(head.next, k);

        counter += 1;
        if (counter == k) {
            return head;
        }
        return node;
    }
}