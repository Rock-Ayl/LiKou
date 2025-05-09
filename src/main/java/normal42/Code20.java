package normal42;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-05-09
 * LCR 005. 最大单词长度乘积
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["abcw","baz","foo","bar","fxyz","abcdef"]
 * 输出：16
 * 解释：这两个单词为 "abcw", "fxyz"。它们不包含相同字符，且长度的乘积最大。
 * 示例 2：
 * <p>
 * 输入：words = ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出：4
 * 解释：这两个单词为 "ab", "cd"。
 * 示例 3：
 * <p>
 * 输入：words = ["a","aa","aaa","aaaa"]
 * 输出：0
 * 解释：不存在这样的两个单词。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 仅包含小写字母
 * <p>
 * <p>
 * 注意：本题与主站 318 题相同：https://leetcode-cn.com/problems/maximum-product-of-word-lengths/
 */
public class Code20 {

    public int maxProduct(String[] words) {
        //hash数组
        int[] wordHashArr = new int[words.length];
        //循环
        for (int i = 0; i < words.length; i++) {
            //转为对应hash,记录
            wordHashArr[i] = toBinaryHashCode(words[i]);
        }
        //结果
        int result = 0;
        //循环1
        for (int i = 0; i < wordHashArr.length; i++) {
            //循环2
            for (int j = i + 1; j < wordHashArr.length; j++) {
                //如果
                if ((wordHashArr[i] & wordHashArr[j]) != 0) {
                    //本轮过
                    continue;
                }
                //刷新最大结果
                result = Math.max(result, words[i].length() * words[j].length());
            }
        }
        //返回
        return result;
    }

    //转为对应二进制
    private int toBinaryHashCode(String word) {
        //缓存
        int[] arr = new int[26];
        //循环
        for (int i = 0; i < word.length(); i++) {
            //计算出字符对应索引
            int key = word.charAt(i) - 'a';
            //出现为1
            arr[key] = 1;
        }
        //数字
        int number = 0;
        //循环
        for (int i = 0; i < arr.length; i++) {
            //先位移一次
            number = number << 1;
            //叠加
            number += arr[i];
        }
        //返回数字
        return number;
    }

    public static void main(String[] args) {
        System.out.println(new Code20().maxProduct(new String[]{"abcw", "baz", "foo", "bar", "fxyz", "abcdef"}));
    }

}
