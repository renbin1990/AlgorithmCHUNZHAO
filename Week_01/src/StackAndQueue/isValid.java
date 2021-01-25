package StackAndQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
class isValid {

    public static void main(String[] args) {
        isValidOne("{}[][][[]]");

        isValidTwo("{}[][][[]]");
    }

    //不断地replace匹配的括号  0n^2
    private static boolean isValidTwo(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack =new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            //如果集合包含这个元素，吧这个元素压入栈，否则，栈为空，说明括号无法匹配，栈顶元素对应的map集合元素不等于这个元素，说明无法匹配
            if (map.containsKey(chars[i])){
                stack.push(chars[i]);
            }else {
                if (stack.empty() || map.get(stack.pop())!= chars[i]){
                    return false;
                }
            }
        }
        return stack.empty();
     }

    //暴力法，遇到一边括号的进栈，遇到相反的，弹出栈
    public static boolean isValidOne(String s){
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        //如果是左括号，就把他们对应的右括号压栈
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='('){
                stack.push(')');
            }else if (chars[i]=='{'){
                stack.push('}');
            }else if (chars[i]=='['){
                stack.push(']');
            }else if (stack.empty() && stack.pop()!=chars[i]){
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
}
