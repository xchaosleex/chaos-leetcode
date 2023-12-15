package ListNode;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void iterator(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            System.out.print('-');
            head = head.next;
        }
    }

    public ListNode reverse1(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    public ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        // ListNode one = new ListNode(1);
        // ListNode two = new ListNode(2);
        // ListNode three = new ListNode(3);
        // ListNode four = new ListNode(4);
        // ListNode five = new ListNode(5);
        // one.next = two;
        // two.next = three;
        // three.next = four;
        // four.next = five;

        // ListNode zero = new ListNode(0);
        // zero.iterator(one);
        // System.out.println();
        // zero.iterator(zero.reverse2(one));
        // System.out.println();
        System.out.println("123"==null);
        System.out.println(null=="123");
    }

}
