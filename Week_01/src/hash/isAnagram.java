package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */
public class isAnagram {
    public static void main(String[] args) {
        isAnagramOne("", "");
        isAnagramTwo("", "");
        isAnagramThree("", "");


    }
    //利用key值唯一特性
    //只有长度相等，他们才能有相等的机会，在成都相等的条件下，把他们加入哈希表中，判断他们是否相等
    private static boolean isAnagramThree(String s, String t) {
        if (s.length() ==t.length()){
            Map<Character,Integer> maps = new HashMap<>();
            Map<Character,Integer> mapt = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                //当Map集合中有这个key时，就使用这个key值；
                //如果没有就使用默认值defaultValue。保证value相同
                maps.put(s.charAt(i),maps.getOrDefault(s.charAt(i),0)+1);
                mapt.put(t.charAt(i),mapt.getOrDefault(t.charAt(i),0)+1);
            }

            return maps.equals(mapt);
        }
        return false;
    }

    //使用数组比较大小的方法
    private static boolean isAnagramTwo(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();

        Arrays.sort(chars);
        Arrays.sort(chart);

        return Arrays.equals(chars, chart);
    }

    //排序，循环遍历是否相等
    public static boolean isAnagramOne(String s, String t) {
        if (s.equals("")) {
            return true;
        }

        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();

        Arrays.sort(chars);
        Arrays.sort(chart);

        if (chars.length == chart.length) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != chart[i]) {
                    return false;
                }
            }

            return true;
        }
        return false;
    }
}
