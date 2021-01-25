package Linked;

/**
 * 206. 反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class reverseList {
    public static void main(String[] args) {
        //链表都是固定解法，刷边数


    }
    //在遍历链表时，将当前节点的 \textit{next}next 指针改为指向前一个节点。由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。
    // 在更改引用之前，还需要存储后一个节点。最后返回新的头引用。
    //优质题解  https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-a7rx/
    public static ListNode reverseList(ListNode head) {
        //创建一个新的链表
        ListNode prev = null;
        ListNode curr = head;

        while (curr!= null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }


}
