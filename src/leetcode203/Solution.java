package leetcode203;

import java.util.List;

/***
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
//       先定义出几个变量 delNode(待删除元素)  head(链表的头元素)
        // 分情况:
        //1. 删除头部节点
        while (head != null && head.val == val) {
            head = head.next;
        }
        // 2. 如果所有的元素都一样 e.g 都是 var = 6,其结果都被上个步骤删除头节点,删完了
        if (head == null) {
            return null;
        }
        // 3. 删除中间重复值
        ListNode prev = head;
        // 这时候再考虑除了头部节点之后的节点情况(即prev.next), prev后面的节点(prev.next)才是要删除的元素

        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }
}
