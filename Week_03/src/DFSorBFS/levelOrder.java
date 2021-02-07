package DFSorBFS;

import java.util.*;

public class levelOrder {

    public static void main(String[] args) {

    }

    /**
     * 广度优先BFS，一排一排的遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderOne(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root==null){
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                temp.add(poll.val);

                if (poll.left!= null){
                    deque.offer(poll.left);
                }

                if (poll.right!= null){
                    deque.offer(poll.right);
                }
            }
            result.add(temp);
        }

        return result;
    }
}
