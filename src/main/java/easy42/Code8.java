package easy42;

import java.util.ArrayList;
import java.util.List;

/**
 * 2273. 移除字母异位词后的结果数组
 * 算术评级: 2
 * 第 293 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1295
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的字符串数组 words ，其中 words[i] 由小写英文字符组成。
 * <p>
 * 在一步操作中，需要选出任一下标 i ，从 words 中 删除 words[i] 。其中下标 i 需要同时满足下述两个条件：
 * <p>
 * 0 < i < words.length
 * words[i - 1] 和 words[i] 是 字母异位词 。
 * 只要可以选出满足条件的下标，就一直执行这个操作。
 * <p>
 * 在执行所有操作后，返回 words 。可以证明，按任意顺序为每步操作选择下标都会得到相同的结果。
 * <p>
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。例如，"dacb" 是 "abdc" 的一个字母异位词。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["abba","baba","bbaa","cd","cd"]
 * 输出：["abba","cd"]
 * 解释：
 * 获取结果数组的方法之一是执行下述步骤：
 * - 由于 words[2] = "bbaa" 和 words[1] = "baba" 是字母异位词，选择下标 2 并删除 words[2] 。
 * 现在 words = ["abba","baba","cd","cd"] 。
 * - 由于 words[1] = "baba" 和 words[0] = "abba" 是字母异位词，选择下标 1 并删除 words[1] 。
 * 现在 words = ["abba","cd","cd"] 。
 * - 由于 words[2] = "cd" 和 words[1] = "cd" 是字母异位词，选择下标 2 并删除 words[2] 。
 * 现在 words = ["abba","cd"] 。
 * 无法再执行任何操作，所以 ["abba","cd"] 是最终答案。
 * 示例 2：
 * <p>
 * 输入：words = ["a","b","c","d","e"]
 * 输出：["a","b","c","d","e"]
 * 解释：
 * words 中不存在互为字母异位词的两个相邻字符串，所以无需执行任何操作。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 10
 * words[i] 由小写英文字母组成
 */
public class Code8 {

    public List<String> removeAnagrams(String[] words) {
        //初始化结果
        List<String> result = new ArrayList<>();
        //缓存
        int[][] arr = new int[words.length][26];
        //初始化,第一个单词
        String word = words[0];
        arr[0] = hash(word);
        result.add(word);
        //上一个索引
        int lastIndex = 0;
        //循环剩下的
        for (int i = 1; i < words.length; i++) {
            //获取单词
            word = words[i];
            //构建hash
            arr[i] = hash(word);
            //比较,如果不同
            if (eq(arr[i], arr[lastIndex]) == false) {
                //组装
                result.add(word);
                lastIndex = i;
            }
        }
        //返回
        return result;
    }

    //构建hash
    private int[] hash(String word) {
        //缓存
        int[] arr = new int[26];
        //循环
        for (char c : word.toCharArray()) {
            //+1
            arr[c - 'a']++;
        }
        //返回
        return arr;
    }

    //对比hash
    private boolean eq(int[] arr1, int[] arr2) {
        //循环
        for (int i = 0; i < arr1.length; i++) {
            //如果不同
            if (arr1[i] != arr2[i]) {
                //过
                return false;
            }
        }
        //默认相同
        return true;
    }

    public static void main(String[] args) {
        new Code8().removeAnagrams(new String[]{"abba", "baba", "bbaa", "cd", "cd"});
    }

}
