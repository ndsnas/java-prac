public class LoopInLinkedList {
    public static class Node {
        int data;
        Node next = null;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(7);
        node.next.next.next.next.next.next.next = new Node(8);
        node.next.next.next.next.next.next.next.next = new Node(9);
        node.next.next.next.next.next.next.next.next.next = new Node(10);
        node.next.next.next.next.next.next.next.next.next.next = new Node(11);

        node.next.next.next.next.next.next.next.next.next.next.next = node.next.next.next.next; // 11 -> 5

        loop(node);
    }

    public static void loop(Node node) {
        Node r = node;
        Node t = node;
        do {
            r = r.next.next;
            t = t.next;
        } while (r != null && r.next != null && t != null && r != t);

        System.out.println("r reached at: " + r.data + " t reached at: " + t.data);
        if (r == t) {
            r = node;
            do {
                r = r.next;
                t = t.next;
            } while (r.next != t.next);
            System.out.println("Loop starts at :: " + r.next.data);

            // removing loop
            t.next = null;
            display(node);
        } else {
            System.out.println("No Loop Present");
            display(node);
        }
    }

    public static void display(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
