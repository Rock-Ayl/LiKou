package easy27;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2023-01-25
 * 2451. 差值数组不同的字符串
 * 给你一个字符串数组 words ，每一个字符串长度都相同，令所有字符串的长度都为 n 。
 * <p>
 * 每个字符串 words[i] 可以被转化为一个长度为 n - 1 的 差值整数数组 difference[i] ，其中对于 0 <= j <= n - 2 有 difference[i][j] = words[i][j+1] - words[i][j] 。注意两个字母的差值定义为它们在字母表中 位置 之差，也就是说 'a' 的位置是 0 ，'b' 的位置是 1 ，'z' 的位置是 25 。
 * <p>
 * 比方说，字符串 "acb" 的差值整数数组是 [2 - 0, 1 - 2] = [2, -1] 。
 * words 中所有字符串 除了一个字符串以外 ，其他字符串的差值整数数组都相同。你需要找到那个不同的字符串。
 * <p>
 * 请你返回 words中 差值整数数组 不同的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["adc","wzy","abc"]
 * 输出："abc"
 * 解释：
 * - "adc" 的差值整数数组是 [3 - 0, 2 - 3] = [3, -1] 。
 * - "wzy" 的差值整数数组是 [25 - 22, 24 - 25]= [3, -1] 。
 * - "abc" 的差值整数数组是 [1 - 0, 2 - 1] = [1, 1] 。
 * 不同的数组是 [1, 1]，所以返回对应的字符串，"abc"。
 * 示例 2：
 * <p>
 * 输入：words = ["aaa","bob","ccc","ddd"]
 * 输出："bob"
 * 解释：除了 "bob" 的差值整数数组是 [13, -13] 以外，其他字符串的差值整数数组都是 [0, 0] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= words.length <= 100
 * n == words[i].length
 * 2 <= n <= 20
 * words[i] 只含有小写英文字母。
 */
public class Code7 {

    public String oddString(String[] words) {
        //缓存1
        int[] arr1 = null;
        int[] arr2 = null;
        //计数
        int count1 = 1;
        int count2 = 1;
        //每种情况最后出现一次的坐标
        int p1 = -1;
        int p2 = -1;
        //循环
        for (int i = 0; i < words.length; i++) {
            //当前单词
            String word = words[i];
            //该单词的结果
            int[] thisArr = new int[word.length() - 1];
            //循环2
            for (int j = 0; j < thisArr.length; j++) {
                //计算
                thisArr[j] = word.charAt(j + 1) - word.charAt(j);
            }
            //如果第一个没找到
            if (arr1 == null) {
                //记录
                arr1 = thisArr;
                p1 = i;
                //本轮过
                continue;
            }
            //如果是第一个
            if (Arrays.equals(arr1, thisArr)) {
                //记录
                count1++;
            } else {
                //如果第二个没找到
                if (arr2 == null) {
                    //记录
                    arr2 = thisArr;
                    p2 = i;
                } else {
                    //记录
                    count2++;
                }
            }
            //如果只找到一种
            if (arr1 == null || arr2 == null) {
                //本轮过
                continue;
            }
            //如果第一个是
            if (count1 > 1) {
                //返回结果
                return words[p2];
            }
            //如果第二个是
            if (count2 > 1) {
                //返回结果
                return words[p1];
            }
        }
        //默认
        return "";
    }


    public static void main(String[] args) {
        System.out.println(new Code7().oddString(new String[]{"adc", "wzy", "abc"}));
    }

}
