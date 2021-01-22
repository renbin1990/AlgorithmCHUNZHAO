import java.util.*;

/**
 * 五毒解法：1.读题+思考；直接看解法并比较不同解法的优缺点
 * 2.直接写，提交-->优化
 * 3.一天后再进行练习
 * 4、一周后练习
 * 5、面试之前进行薄弱环节的练习（恢复性）
 */
public class TestFour {

    public static void main(String[] args) {
      //  StackDemo();
      //  QueueDemo();
      //  DequeDemo();
     //   PriorityQueueDemo();

        isValid("{[]}");

    }

    //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
    //有效字符串需满足：
    //左括号必须用相同类型的右括号闭合。
    //左括号必须以正确的顺序闭合。
    private static boolean isValid(String s) {
        //暴力法
        //遇到一边括号的，进栈，遇到另一边，弹出栈
        return true;
    }

    private static void PriorityQueueDemo() {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer("1");
        priorityQueue.offer("2");
        priorityQueue.offer("3");
        priorityQueue.offer("4");
        priorityQueue.offer("5");
    }

    private static void DequeDemo() {
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("1");
        deque.addFirst("2");
        deque.addFirst("3");
        deque.addLast("4");
        deque.addLast("5");

        System.out.println(deque);   //12345
    }

    private static void QueueDemo() {
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        queue.offer("4");
        queue.offer("5");


        System.out.println(queue.size());  //5
        System.out.println(queue.poll());  //5
        System.out.println(queue.size());  //4
        System.out.println(queue.peek());  //4
        System.out.println(queue);      //2345

    }

    private static void StackDemo() {
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");

        System.out.println(stack.empty());  //false
        System.out.println(stack.peek());  //5
        System.out.println(stack.size());  //5
        System.out.println(stack.pop());  //5
        System.out.println(stack.size());  //4
        System.out.println(stack.search(2));  //2
    }
}
