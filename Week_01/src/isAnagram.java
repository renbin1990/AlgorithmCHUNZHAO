import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**\
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */
public class isAnagram {

    public static void main(String[] args) {
        //暴力法。转换成数组，排序，判断是否相等
        isAnagramOne("anagram","anagram");
        //哈希表，把S添加到哈希表中，
        //利用key值唯一特性
        isAnagramTwo("anagram","anagram");
    }

    private static boolean isAnagramTwo(String s, String t) {
        if (s.length()==t.length()) {
            if (s.length() >= t.length()) {
                Map<Character, Integer> maps = new HashMap<>();
                Map<Character, Integer> mapt = new HashMap<>();
                for (int i = 0; i < s.length(); i++) {
                    maps.put(s.charAt(i), maps.getOrDefault(s.charAt(i),0)+1);
                    mapt.put(t.charAt(i), mapt.getOrDefault(t.charAt(i),0)+1);
                }

                if (maps.equals(mapt)){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isAnagramOne(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();

        Arrays.sort(chars);
        Arrays.sort(chart);

        return Arrays.equals(chars,chart);
    }
}
