package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class generateParenthesis {
    public static void main(String[] args) {
     //   System.out.println(generateParenthesisOne(3));
        System.out.println(generateParenthesisTwo(3));
    }

    private static List<String> generateParenthesisTwo(int i) {
        List<String> list = new ArrayList<>();
        _recursiongenerateParenthesisTwo(0,0,i,"",list);
        return list;
    }

    private static void _recursiongenerateParenthesisTwo(int left, int right, int max, String s, List<String> list) {
        //如果left==max 并且right==max 说明括号添加完成了
        if (left==max && right==max){
            list.add(s);
            return;
        }

        //如果左括号小于max ,这添加左括号
        if (left<max){
            _recursiongenerateParenthesisTwo(left+1,right,max,s+"(",list);
        }
        //如果右括号小于左括号，说明右括号没有添加完，添加右括号
        if (right<left){
            _recursiongenerateParenthesisTwo(left,right+1,max,s+")",list);
        }
    }

    public static List<String> generateParenthesisOne(int n) {
        List<String> list = new ArrayList<>();
        _generateOne(0,0,n,"",list);
        return list;
    }

    //left随时可以加，只要别超标 <n
    //right添加，必须有左括号 左个数必须大于又个数
    private static void _generateOne(int left,int right, int max, String s, List<String> list) {
        if (left==max && right==max){
            list.add(s);
            return;
        }
        if (left<max){
            _generateOne(left+1,right,max,s+"(",list);
        }

        if (right<left){
            _generateOne(left,right+1,max,s+")",list);
        }
    }
}
