package easy3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By Rock-Ayl on 2020-11-14
 * 1189. “气球” 的最大数量
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 * <p>
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "nlaebolko"
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：text = "leetcode"
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 10^4
 * text 全部由小写英文字母组成
 */
public class Code22 {

    public static int maxNumberOfBalloons(String text) {
        //需要1个
        char[] word1s = new char[]{'b', 'a', 'n'};
        //需要2个
        char[] word2s = new char[]{'l', 'o'};
        //缓存
        Map<Character, Integer> map = new HashMap<>();
        //循环
        for (char c : text.toCharArray()) {
            //如果存在
            if (map.containsKey(c)) {
                //+1
                map.put(c, map.get(c) + 1);
            } else {
                //初始化
                map.put(c, 1);
            }
        }
        //数量
        Integer minSize1 = null;
        //循环
        for (char word1 : word1s) {
            //获取次数
            Integer x = map.get(word1);
            //判空
            if (x != null) {
                //判空
                if (minSize1 == null) {
                    //初始化
                    minSize1 = x;
                } else {
                    //取最小
                    minSize1 = Math.min(minSize1, x);
                }
            }
        }
        //数量2
        Integer minSize2 = null;
        //循环
        for (char word2 : word2s) {
            //获取次数
            Integer y = map.get(word2);
            //判空
            if (y != null) {
                //除法
                y = y / 2;
                //判空
                if (minSize2 == null) {
                    //初始化
                    minSize2 = y;
                } else {
                    //取最小
                    minSize2 = Math.min(minSize2, y);
                }
            }
        }
        //判空
        if (minSize1 == null || minSize2 == null) {
            //返回
            return 0;
        }
        //对比返回
        return Math.min(minSize1, minSize2);
    }

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("hpitp"));
    }
}
