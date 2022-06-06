// https://leetcode.com/problems/intersection-of-two-linked-lists/
public class Intersection {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public static void main(String[] args) {

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next;

        System.out.println(getIntersectionNode(headA, headB).val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ll_print(headA);
        ll_print(headB);
        int sizeA = ll_size(headA);
        int sizeB = ll_size(headB);
        int delta = Math.abs(sizeA - sizeB);

        if (sizeA > sizeB) {
            for (int i = 0; i < delta; i++) {
                headA = headA.next;
            }
        } else if (sizeA < sizeB) {
            for (int i = 0; i < delta; i++) {
                headB = headB.next;
            }
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public static void ll_print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static int ll_size(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}