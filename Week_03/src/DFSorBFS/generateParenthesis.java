package DFSorBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class generateParenthesis {

    //广度优先BFS
    public List<String> generateParenthesisTwo(int n) {
        List<String> result = new ArrayList<>();
        if (n==0){
            return result;
        }

        String left = "(";
        String right = ")";

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("",n,n));

        while (!queue.isEmpty()){
            Node poll = queue.poll();

            if (poll.left== 0 && poll.right ==0){
                result.add(poll.res);
            }

            if (poll.left>0){
                queue.offer(new Node(poll.res+left, poll.left-1, poll.right));
            }

            if (poll.right>0 && poll.left< poll.right){
                queue.offer(new Node(poll.res+right, poll.left, poll.right-1));
            }

        }


        return result;
    }


    public List<String> generateParenthesisOne(int n) {
        List<String> result = new ArrayList<>();
        _generateParenthesis(0,0,n,result,"");
        return result;
    }

    private void _generateParenthesis(int left, int right, int n, List<String> result, String s) {
        if (left== n && right == n){
            result.add(s);
            return;
        }

        if (left<n){
            _generateParenthesis(left+1,right,n,result,s+"(");
        }

        if (right<left){
            _generateParenthesis(left,right+1,n,result,s+")");
        }
    }
}
