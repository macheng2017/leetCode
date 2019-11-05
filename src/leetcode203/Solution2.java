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
//       先定义出几个变量 delNode(待删除元素)  dummyHead(链表的虚拟头节点)

        ListNode dummyHead = new ListNode(-1);

        while (dummyHead.next != null) {
            if (dummyHead.next.val == val) {
                ListNode delNode = dummyHead.next;
                dummyHead.next = delNode.next;
                delNode.next = null;
            } else {
                dummyHead.next = dummyHead.next.next;
            }
        }
        return head;
    }
}
