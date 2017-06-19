package mike.code.oj.leetcode;

/**
 * @author Mike
 * @project oj-code
 * @date 4/24/15, 3:29 PM
 * @e-mail mike@mikecoder.net
 */
public class LinkedListCycleII {
    static class ListNode {
        int      val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return "ListNode{" + "val=" + val + "'}'";
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;

        System.out.println(detectCycle(a));
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode P1 = head;
        ListNode P2 = head;

        while (P2 != null && P2.next != null) {
            P1 = P1.next;
            P2 = P2.next.next;

            if (P1 == P2) {
                break;
            }
        }

        if (P2 == null || P2.next == null) {
            return null;
        }

        P1 = head;
        while (P1 != P2) {
            P1 = P1.next;
            P2 = P2.next;
        }
        return P1;
    }

}
