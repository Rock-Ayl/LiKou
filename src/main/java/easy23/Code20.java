package easy23;

import java.util.LinkedHashMap;

/**
 * @Author ayl
 * @Date 2022-10-09
 * 2053. 数组中第 K 个独一无二的字符串
 * 独一无二的字符串 指的是在一个数组中只出现过 一次 的字符串。
 * <p>
 * 给你一个字符串数组 arr 和一个整数 k ，请你返回 arr 中第 k 个 独一无二的字符串 。如果 少于 k 个独一无二的字符串，那么返回 空字符串 "" 。
 * <p>
 * 注意，按照字符串在原数组中的 顺序 找到第 k 个独一无二字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：arr = ["d","b","c","b","c","a"], k = 2
 * 输出："a"
 * 解释：
 * arr 中独一无二字符串包括 "d" 和 "a" 。
 * "d" 首先出现，所以它是第 1 个独一无二字符串。
 * "a" 第二个出现，所以它是 2 个独一无二字符串。
 * 由于 k == 2 ，返回 "a" 。
 * 示例 2:
 * <p>
 * 输入：arr = ["aaa","aa","a"], k = 1
 * 输出："aaa"
 * 解释：
 * arr 中所有字符串都是独一无二的，所以返回第 1 个字符串 "aaa" 。
 * 示例 3：
 * <p>
 * 输入：arr = ["a","b","a"], k = 3
 * 输出：""
 * 解释：
 * 唯一一个独一无二字符串是 "b" 。由于少于 3 个独一无二字符串，我们返回空字符串 "" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= arr.length <= 1000
 * 1 <= arr[i].length <= 5
 * arr[i] 只包含小写英文字母。
 */
public class Code20 {

    public String kthDistinct(String[] arr, int k) {
        //缓存
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        //循环
        for (String s : arr) {
            //如果存在
            if (map.containsKey(s)) {
                //记录
                map.put(s, map.get(s) + 1);
            } else {
                //记录
                map.put(s, 1);
            }
        }
        //指针
        int p = 1;
        //循环
        for (String key : map.keySet()) {
            //如果只出现了一次
            if (map.get(key) == 1) {
                //如果是目标
                if (p == k) {
                    //返回
                    return key;
                }
                //+1
                p++;
            }
        }
        //默认
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new Code20().kthDistinct(new String[]{"d", "b", "c", "b", "c", "a"}, 1));
    }

}
