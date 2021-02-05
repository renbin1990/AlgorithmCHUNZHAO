package DivideConquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class letterCombinations {
    public static void main(String[] args) {
        //递归
        letterCombinationsOne("23");
        //队列
        letterCombinationsTwo("23");
    }

    public static List<String> letterCombinationsTwo(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length()==0){
            return result;
        }
        String[] letter_map = {
                " ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };

        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            String letters  = letter_map[digits.charAt(i)-'0'];
            int size = result.size();
            for (int j = 0; j < size; j++) {
                String remove = result.remove(0);
                for (int k = 0; k < letters.length(); k++) {
                    result.add(remove+letters.charAt(k));
                }
            }
        }

        return result;
    }

    public static List<String> letterCombinationsOne(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length()==0){
            return result;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        _letterCombinationsOne(0,digits,result,phoneMap,"");
        return result;
    }

    private static void _letterCombinationsOne(int level, String digits, List<String> result, Map<Character, String> phoneMap, String s) {
        if (level== digits.length()){
            result.add(s);
            return;
        }

        //拿到前一个索引的元素，遍历元素
        String letters = phoneMap.get(digits.charAt(level));
        for (int i = 0; i < letters.length(); i++) {
            _letterCombinationsOne(level+1,digits,result,phoneMap,s+letters.charAt(i));
        }
    }
}
