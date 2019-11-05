package leetcode203;

/***
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
//       先定义出几个变量 delNode(待删除元素)  dummyHead(链表的虚拟头节点) prev(前一个节点)

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head; // 将虚拟头节点放到链表前面

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
//                ListNode delNode = prev.next;
//                prev.next = delNode.next;
//                delNode.next = null;
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }
}
