package Linked;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 *
 */
public class swapPairs {
    public static void main(String[] args) {
        swapPairs(new ListNode(){});
    }

    /**
     * 其中我们应该关心的主要有三点：
     * 返回值
     * 调用单元做了什么
     * 终止条件
     * 在本题中：
     * 返回值：交换完成的子链表
     * 调用单元：设需要交换的两个点为 head 和 next，head 连接后面交换完成的子链表，next 连接 head，完成交换
     * 终止条件：head 为空指针或者 next 为空指针，也就是当前无节点或者只有一个节点，无法进行交换
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode perv = new ListNode(0);
        perv.next = head;
        ListNode temp = perv;

        while (temp.next!= null && temp.next.next!= null){
            ListNode start = temp.next;
            ListNode end = temp.next.next;

            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }

        return perv.next;
    }
}
