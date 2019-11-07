package leetcode203;

/***
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Solution3 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        // 把链表看作一个 一个元素 和一个长一点的链表,而这个长一点的链表就是下面的函数调用
        // 想想数组求和的例子
        ListNode res = removeElements(head.next, val);
        if (head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }
    }
}
