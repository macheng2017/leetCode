package leetcode203;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        this(x, null);
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode() {
        this(0, null);
    }

    public ListNode(int[] e) {
        ListNode listNode;
        for (int i = 0; i < e.length; i++) {
            listNode = new ListNode(e);
        }
    }

}
