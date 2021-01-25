package Linked;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 */
class hasCycle {
    public static void main(String[] args) {
        hasCycleOne(new ListNode(){});

        hasCycleTwo(new ListNode(){});
    }

    //遍历所有节点，每次遍历到一个节点时，判断该节点此前是否被访问过。利用setb不可重复行
    private static boolean hasCycleTwo(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head!= null){
            if (!set.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 当一个链表有环时，快慢指针都会陷入环中进行无限次移动，然后变成了追及问题。
     * 想象一下在操场跑步的场景，只要一直跑下去，快的总会追上慢的。当两个指针都进入环后，
     * 每轮移动使得慢指针到快指针的距离增加一，同时快指针到慢指针的距离也减少一，只要一直移动下去，快指针总会追上慢指针
     * 如果存在环，如何判断环的长度呢？方法是，快慢指针相遇后继续移动，直到第二次相遇。两次相遇间的移动次数即为环的长度。
     */
    public static boolean hasCycleOne(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode first = head;
        ListNode fast = head;

        while (fast!= null){
            fast = fast.next;
            if (fast!=null){
                fast = fast.next;
            }

            if (fast==first){
                return true;
            }

            first = first.next;
        }

        return false;
    }
}
