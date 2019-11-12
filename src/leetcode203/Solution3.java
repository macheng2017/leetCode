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
    public ListNode removeElements(ListNode head, int val, int depth) {

        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call: remove" + val + " in " + head);
        if (head == null) {
            System.out.print(depthString);
            System.out.println("Return: " + null);
            return null;
        }
        // 把链表看作一个 一个元素 和一个长一点的链表,而这个长一点的链表就是下面的函数调用
        // 想想数组求和的例子
        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove " + val + ": " + res);

        ListNode ret;
        if (head.val == val) {
            ret = res;
        } else {
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return: " + ret);
        return ret;
    }

    private String generateDepthString(int depth) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            str.append("--");
        }
        return str.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println("head = " + head);
    }
}
