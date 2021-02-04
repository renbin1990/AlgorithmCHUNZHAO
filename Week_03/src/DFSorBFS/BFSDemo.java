package DFSorBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSDemo {

    /**
     * 广度优先BFS代码
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if (root==null){
            return allResults;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                result.add(poll.val);

                if (poll.left!= null){
                    queue.add(poll.left);
                }

                if (poll.right!= null){
                    queue.add(poll.right);
                }
            }


        }
        return allResults;
    }
}
