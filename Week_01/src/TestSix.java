import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 五毒解法：1.读题+思考；直接看解法并比较不同解法的优缺点
 * 2.直接写，提交-->优化
 * 3.一天后再进行练习
 * 4、一周后练习
 * 5、面试之前进行薄弱环节的练习（恢复性）
 */
public class TestSix {

    public static void main(String[] args) {
        //20. 有效的括号
      //  isValid("{[]}}}");
        //Fizz Buzz
        fizzBuzz(20);
    }

    /**
     * 写一个程序，输出从 1 到 n 数字的字符串表示。
     * 1. 如果 n 是3的倍数，输出“Fizz”；
     * 2. 如果 n 是5的倍数，输出“Buzz”；
     * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/fizz-buzz
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     */
    private static List<String> fizzBuzz(int n) {
        //1、暴力求解
        List<String> list= new ArrayList<>();

        if (n>=3){
            for (int j = 1; j <= n; j++) {
                if (j%3==0 && j%5==0){
                    list.add("FizzBuzz");
                }else if (j%3==0){
                    list.add("Fizz");
                }else if (j%5==0){
                    list.add("Buzz");
                }else {
                    list.add(""+j);
                }
            }
        }else {
            for (int j = 1; j <= n; j++) {
                list.add(""+j);
            }
        }

        return list;
    }

    //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
    //有效字符串需满足：
    //左括号必须用相同类型的右括号闭合。
    //左括号必须以正确的顺序闭合。
    private static void isValid(String s) {
        //暴力法，不断地replace匹配的括号  0n^2
        //遇到一边括号的，进栈，遇到另一边，弹出栈
        isValidOne(s);
        isValidTwo(s);
    }

    private static boolean isValidTwo(String s) {
        if (s.isEmpty()){
            return false;
        }

        if (s.length()==1){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        //如果是左括号，就把他们对应的右括号压栈
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='('){
                stack.push(')');
            }else if (chars[i]=='{'){
                stack.push('}');
            }else if (chars[i]=='['){
                stack.push(']');
            }else if (stack.empty()|| stack.pop()!=chars[i]){
                //否则就只能是右括号。
                //1，如果栈为空，说明括号无法匹配。
                //2，如果栈不为空，栈顶元素就要出栈，和这个右括号比较。
                //如果栈顶元素不等于这个右括号，说明无法匹配，
                //直接返回false。
                return false;
            }
        }

        //最后如果栈为空，说明完全匹配，是有效的括号。
        //否则不完全匹配，就不是有效的括号
        return stack.empty();
    }

    private static boolean isValidOne(String s) {
        if (s.isEmpty()){
            return false;
        }

        if (s.length()==1){
            return false;
        }


        char[] chars = s.toCharArray();

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            //如果集合包含这个元素，吧这个元素压入栈，否则，栈为空，说明括号无法匹配，栈顶元素对应的map集合元素不等于这个元素，说明无法匹配
            if (map.containsKey(chars[i])){
                stack.push(chars[i]);
            }else {
                if (stack.empty() || map.get(stack.pop())!=chars[i]){
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
