package DivideConquer;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class generateParenthesis {

    public static void main(String[] args) {

    }

    public List<String> generateParenthesis(int n) {
        List<String> list  = new ArrayList<>();
        _generateParenthesis(0,0,n,list,"");
        return  list;
    }

    private void _generateParenthesis(int left, int right, int max, List<String> list, String s) {
        //递归终结条件
        if (left==max && right==max){
            list.add(s);
            return;
        }

        //处理当前逻辑
        String lefts = s+"(";
        String rights = s+")";

        //下探到下一层
        if (left<max){
            _generateParenthesis(left+1,right,max,list,lefts);
        }

        if (right<left){
            _generateParenthesis(left,right+1,max,list,rights);
        }
    }
}
