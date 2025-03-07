package easy5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2021-01-02
 * 1704. 判断字符串的两半是否相似
 * 给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
 * <p>
 * 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含有大写和小写字母。
 * <p>
 * 如果 a 和 b 相似，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "book"
 * 输出：true
 * 解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。
 * 示例 2：
 * <p>
 * 输入：s = "textbook"
 * 输出：false
 * 解释：a = "text" 且 b = "book" 。a 中有 1 个元音，b 中有 2 个元音。因此，a 和 b 不相似。
 * 注意，元音 o 在 b 中出现两次，记为 2 个。
 * 示例 3：
 * <p>
 * 输入：s = "MerryChristmas"
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：s = "AbCdEfGh"
 * 输出：true
 */
public class Code3 {

    public static boolean halvesAreAlike(String s) {
        //初始化元音缓存
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'A', 'e', 'E', 'u', 'U', 'o', 'O', 'i', 'I'));
        //左边元音次数
        int leftSize = 0;
        //右边元音次数
        int rightSize = 0;
        //转化为char
        char[] arr = s.toCharArray();
        //中间值
        int mid = arr.length / 2;
        //循环
        for (int i = 0; i < arr.length; i++) {
            //获取当前字母
            char x = arr[i];
            //如果是元音
            if (set.contains(x)) {
                //如果是左边
                if (i < mid) {
                    //左边叠加
                    leftSize++;
                } else {
                    //右边叠加
                    rightSize++;
                }
            }
        }
        //如果左右元音相同
        if (leftSize == rightSize) {
            //相同
            return true;
        }
        //缺省不同
        return false;
    }

    public static void main(String[] args) {
        System.out.println(halvesAreAlike("MerryChristmas"));
    }
}
